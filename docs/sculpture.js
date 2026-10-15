/* An original, dependency-free WebGL coffee cup. Decorative only: donation links
   and page content never depend on graphics support or JavaScript. */
(() => {
  'use strict';

  const canvas = document.getElementById('sculpture');
  const art = canvas?.closest('.hero-art');
  if (!canvas || !art) return;

  const gl = canvas.getContext('webgl', {
    alpha: true,
    antialias: true,
    premultipliedAlpha: false,
    powerPreference: 'low-power',
  });
  if (!gl) return;

  const vertexSource = `
    attribute vec3 aPosition;
    attribute vec3 aNormal;
    attribute float aMaterial;
    uniform mat4 uProjection;
    uniform mat3 uRotation;
    uniform float uFloat;
    varying vec3 vPosition;
    varying vec3 vNormal;
    varying float vMaterial;
    void main() {
      vPosition = uRotation * (aPosition - vec3(0.22, 0.0, 0.0)) * 1.12;
      vPosition.y += uFloat;
      vNormal = uRotation * aNormal;
      vMaterial = aMaterial;
      gl_Position = uProjection * vec4(vPosition - vec3(0.0, 0.0, 5.1), 1.0);
    }
  `;

  const fragmentSource = `
    precision mediump float;
    varying vec3 vPosition;
    varying vec3 vNormal;
    varying float vMaterial;

    // Soft studio reflections give the dark ceramic a readable silhouette.
    vec3 studio(vec3 r) {
      float sky = smoothstep(-0.65, 0.95, r.y);
      vec3 color = mix(vec3(0.035, 0.035, 0.037), vec3(0.47, 0.48, 0.51), sky);
      float wide = pow(max(dot(r, normalize(vec3(-0.7, 0.85, 0.65))), 0.0), 4.0);
      float tall = pow(max(dot(r, normalize(vec3(0.95, 0.1, 0.8))), 0.0), 14.0);
      float rim = pow(max(dot(r, normalize(vec3(-0.6, -0.7, -0.5))), 0.0), 9.0);
      float strip = pow(max(1.0 - abs(r.y - 0.30), 0.0), 35.0);
      color += vec3(0.95, 0.94, 0.92) * wide * 1.15;
      color += vec3(0.98, 0.99, 1.0) * tall * 1.5;
      color += vec3(0.64, 0.66, 0.72) * rim * 0.95;
      color += vec3(0.67, 0.68, 0.72) * strip * 0.55;
      float panel = smoothstep(-0.22, -0.19, r.y) - smoothstep(0.12, 0.16, r.y);
      color += vec3(0.90, 0.89, 0.85) * panel * smoothstep(-0.75, 0.25, r.x) * 0.8;
      return color;
    }

    void main() {
      vec3 n = normalize(vNormal);
      vec3 view = normalize(vec3(0.0, 0.0, 5.1) - vPosition);
      vec3 reflected = reflect(-view, n);
      float facing = max(dot(n, view), 0.0);
      float fresnel = pow(1.0 - facing, 4.0);
      float diffuse = max(dot(n, normalize(vec3(-0.4, 0.8, 1.0))), 0.0);
      float shine = pow(max(dot(reflected, normalize(vec3(-0.5, 0.7, 1.0))), 0.0), 54.0);
      vec3 color;
      if (vMaterial > 1.5) {
        // The same restrained green as the ZORO wordmark.
        color = vec3(0.835, 0.973, 0.584) * (0.85 + diffuse * 0.15);
      } else if (vMaterial > 0.5) {
        color = vec3(0.035, 0.023, 0.016) + studio(reflected) * 0.035;
        color += vec3(0.45, 0.40, 0.33) * shine * 0.25;
      } else {
        color = vec3(0.065, 0.067, 0.070) * (0.75 + diffuse * 1.2);
        color += studio(reflected) * (0.075 + fresnel * 0.26);
        color += vec3(0.36, 0.37, 0.39) * shine;
        color = pow(color, vec3(0.82));
      }
      gl_FragColor = vec4(color, 1.0);
    }
  `;

  function shader(type, source) {
    const result = gl.createShader(type);
    if (!result) throw new Error('Unable to allocate shader');
    gl.shaderSource(result, source);
    gl.compileShader(result);
    if (!gl.getShaderParameter(result, gl.COMPILE_STATUS)) {
      gl.deleteShader(result);
      throw new Error('Decorative shader unavailable');
    }
    return result;
  }

  let program;
  const allocatedShaders = [];
  try {
    program = gl.createProgram();
    if (!program) return;
    allocatedShaders.push(shader(gl.VERTEX_SHADER, vertexSource));
    allocatedShaders.push(shader(gl.FRAGMENT_SHADER, fragmentSource));
    allocatedShaders.forEach((part) => gl.attachShader(program, part));
    gl.linkProgram(program);
    if (!gl.getProgramParameter(program, gl.LINK_STATUS)) throw new Error('Link failed');
  } catch {
    allocatedShaders.forEach((part) => gl.deleteShader(part));
    if (program) gl.deleteProgram(program);
    return;
  }

  gl.useProgram(program);
  allocatedShaders.forEach((part) => gl.deleteShader(part));

  const normalize = (v) => {
    const length = Math.hypot(...v) || 1;
    return v.map((value) => value / length);
  };
  const positions = [];
  const normals = [];
  const materials = [];
  const indices = [];

  function vertex(position, normal, material = 0) {
    const index = positions.length / 3;
    positions.push(...position);
    normals.push(...normal);
    materials.push(material);
    return index;
  }

  // Revolve a smooth cross-section to make a hollow cup, including its rounded
  // base, thin rim, and inner wall. All surfaces are actual geometry.
  const profile = [
    [0, -0.78], [0.52, -0.78], [0.66, -0.775], [0.75, -0.75],
    [0.81, -0.69], [0.84, -0.6], [0.85, -0.43], [0.86, 0.53],
    [0.86, 0.67], [0.852, 0.724], [0.835, 0.752], [0.808, 0.763],
    [0.78, 0.752], [0.764, 0.722], [0.76, 0.665], [0.75, -0.46],
    [0.72, -0.55], [0.65, -0.6], [0.4, -0.61], [0, -0.61],
  ];
  const section = [];
  for (let i = 0; i < profile.length - 1; i++) {
    const a = profile[Math.max(0, i - 1)];
    const b = profile[i];
    const c = profile[i + 1];
    const d = profile[Math.min(profile.length - 1, i + 2)];
    for (let step = 0; step < 5; step++) {
      const t = step / 5;
      section.push([0, 1].map((axis) => 0.5 * (
        2 * b[axis] + (-a[axis] + c[axis]) * t
        + (2 * a[axis] - 5 * b[axis] + 4 * c[axis] - d[axis]) * t * t
        + (-a[axis] + 3 * b[axis] - 3 * c[axis] + d[axis]) * t * t * t
      )));
    }
  }
  section.push(profile[profile.length - 1]);
  const radialSegments = 112;
  for (let i = 0; i < section.length; i++) {
    const [radius, height] = section[i];
    const previous = section[Math.max(0, i - 1)];
    const next = section[Math.min(section.length - 1, i + 1)];
    const dr = next[0] - previous[0];
    const dy = next[1] - previous[1];
    for (let j = 0; j <= radialSegments; j++) {
      const angle = j / radialSegments * Math.PI * 2;
      const c = Math.cos(angle), s = Math.sin(angle);
      vertex([Math.max(radius, 0) * c, height, Math.max(radius, 0) * s], normalize([dy * c, -dr, dy * s]));
      if (i < section.length - 1 && j < radialSegments) {
        const a = i * (radialSegments + 1) + j;
        const b = a + radialSegments + 1;
        indices.push(a, b, a + 1, b, b + 1, a + 1);
      }
    }
  }

  // A rounded C-shaped handle, with both ends seated inside the cup wall.
  const handleStart = positions.length / 3;
  const handleSegments = 72;
  const handleSides = 20;
  for (let i = 0; i <= handleSegments; i++) {
    const angle = -2.0 + i / handleSegments * 4.0;
    const c = Math.cos(angle), s = Math.sin(angle);
    for (let j = 0; j <= handleSides; j++) {
      const around = j / handleSides * Math.PI * 2;
      const radial = Math.cos(around);
      const depth = Math.sin(around);
      const normal = [c * radial, s * radial, depth];
      vertex([
        0.86 + 0.60 * c + normal[0] * 0.135,
        0.015 + 0.56 * s + normal[1] * 0.135,
        normal[2] * 0.135,
      ], normal);
      if (i < handleSegments && j < handleSides) {
        const a = handleStart + i * (handleSides + 1) + j;
        const b = a + handleSides + 1;
        indices.push(a, b, a + 1, b, b + 1, a + 1);
      }
    }
  }

  // Coffee is slightly below the rim so the opening reads as a real cup.
  const coffeeCenter = vertex([0, 0.635, 0], [0, 1, 0], 1);
  const coffeeStart = positions.length / 3;
  for (let i = 0; i <= radialSegments; i++) {
    const angle = i / radialSegments * Math.PI * 2;
    vertex([0.758 * Math.cos(angle), 0.635, 0.758 * Math.sin(angle)], [0, 1, 0], 1);
    if (i < radialSegments) indices.push(coffeeCenter, coffeeStart + i, coffeeStart + i + 1);
  }

  // The Z mark follows the curved front of the cup, rather than floating in
  // front of it. Separate quads keep its edges crisp without loading textures.
  const logoQuads = [
    [[-0.28, 0.28], [0.28, 0.28], [0.28, 0.15], [-0.28, 0.15]],
    [[0.28, 0.15], [0.1, 0.28], [-0.28, -0.15], [-0.1, -0.28]],
    [[-0.28, -0.15], [0.28, -0.15], [0.28, -0.28], [-0.28, -0.28]],
  ];
  function surfaceRadius(y) {
    // Intersect the same sampled outer wall used by the mesh.
    for (let i = 1; i < section.length / 2; i++) {
      const [ar, ay] = section[i - 1];
      const [br, by] = section[i];
      if (ay <= y && by >= y && by > ay) return ar + (br - ar) * (y - ay) / (by - ay);
    }
    return 0.86;
  }
  for (const quad of logoQuads) {
    const start = positions.length / 3;
    // Subdivide each strip so the logo conforms to the ceramic surface.
    const columns = 12;
    const rows = 16;
    for (let i = 0; i <= rows; i++) {
      const v = i / rows;
      for (let j = 0; j <= columns; j++) {
        const u = j / columns;
        const top = quad[0].map((value, axis) => value + (quad[1][axis] - value) * u);
        const bottom = quad[3].map((value, axis) => value + (quad[2][axis] - value) * u);
        const x = top[0] + (bottom[0] - top[0]) * v;
        const y = top[1] + (bottom[1] - top[1]) * v - 0.015;
        const radius = surfaceRadius(y) + 0.006;
        const z = Math.sqrt(radius * radius - x * x);
        vertex([x, y, z], normalize([x, 0, z]), 2);
        if (i < rows && j < columns) {
          const a = start + i * (columns + 1) + j;
          const b = a + columns + 1;
          indices.push(a, b, a + 1, b, b + 1, a + 1);
        }
      }
    }
  }

  function attribute(name, data, size = 3) {
    const buffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, buffer);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(data), gl.STATIC_DRAW);
    const location = gl.getAttribLocation(program, name);
    gl.enableVertexAttribArray(location);
    gl.vertexAttribPointer(location, size, gl.FLOAT, false, 0, 0);
  }

  attribute('aPosition', positions);
  attribute('aNormal', normals);
  attribute('aMaterial', materials, 1);
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, gl.createBuffer());
  gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(indices), gl.STATIC_DRAW);
  gl.enable(gl.DEPTH_TEST);
  gl.clearColor(0, 0, 0, 0);

  const projectionLocation = gl.getUniformLocation(program, 'uProjection');
  const rotationLocation = gl.getUniformLocation(program, 'uRotation');
  const floatLocation = gl.getUniformLocation(program, 'uFloat');
  const motionPreference = window.matchMedia('(prefers-reduced-motion: reduce)');
  const motionButton = art.querySelector('.motion-toggle');
  let userPaused = false;
  let inView = true;
  let contextLost = false;
  let frame = 0;
  let previousTime = 0;
  let lastRenderedTime = 0;
  let projectionReady = false;
  let activeTime = 0;
  let pointerX = 0;
  let pointerY = 0;
  let smoothX = 0;
  let smoothY = 0;

  function resize() {
    const pixelRatio = Math.min(window.devicePixelRatio || 1, 1.75);
    const width = Math.max(1, Math.round(canvas.clientWidth * pixelRatio));
    const height = Math.max(1, Math.round(canvas.clientHeight * pixelRatio));
    if (projectionReady && canvas.width === width && canvas.height === height) return;
    if (canvas.width !== width || canvas.height !== height) {
      canvas.width = width;
      canvas.height = height;
      gl.viewport(0, 0, width, height);
    }
    const f = 1 / Math.tan(38 * Math.PI / 360);
    const near = 0.1;
    const far = 20;
    gl.uniformMatrix4fv(projectionLocation, false, new Float32Array([
      f / (width / height), 0, 0, 0,
      0, f, 0, 0,
      0, 0, (far + near) / (near - far), -1,
      0, 0, 2 * far * near / (near - far), 0,
    ]));
    projectionReady = true;
  }

  function rotation(x, y, z) {
    const cx = Math.cos(x), sx = Math.sin(x);
    const cy = Math.cos(y), sy = Math.sin(y);
    const cz = Math.cos(z), sz = Math.sin(z);
    // Column-major Rz * Ry * Rx.
    return new Float32Array([
      cz * cy, sz * cy, -sy,
      cz * sy * sx - sz * cx, sz * sy * sx + cz * cx, cy * sx,
      cz * sy * cx + sz * sx, sz * sy * cx - cz * sx, cy * cx,
    ]);
  }

  function draw(time) {
    frame = 0;
    if (contextLost || !inView || document.hidden) { previousTime = 0; return; }
    // A gentle 30fps rotation keeps the artwork light on mobile batteries.
    if (!motionPreference.matches && !userPaused && time - lastRenderedTime < 1000 / 30) {
      frame = requestAnimationFrame(draw);
      return;
    }
    lastRenderedTime = time;
    resize();
    if (!motionPreference.matches && !userPaused) {
      if (previousTime) activeTime += Math.min(time - previousTime, 50) / 1000;
      previousTime = time;
      smoothX += (pointerX - smoothX) * 0.035;
      smoothY += (pointerY - smoothY) * 0.035;
    } else if (motionPreference.matches) {
      activeTime = 0;
      smoothX = smoothY = 0;
    }
    const x = 0.35 + Math.sin(activeTime * 0.32) * 0.035 + smoothY * 0.09;
    const y = -0.4 + Math.sin(activeTime * 0.22) * 0.09 + smoothX * 0.16;
    const z = -0.12 + Math.sin(activeTime * 0.3) * 0.025;
    gl.uniformMatrix3fv(rotationLocation, false, rotation(x, y, z));
    gl.uniform1f(floatLocation, Math.sin(activeTime * 0.7) * 0.035);
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
    gl.drawElements(gl.TRIANGLES, indices.length, gl.UNSIGNED_SHORT, 0);
    if (!gl.isContextLost()) art.classList.add('sculpture-ready');
    if (!motionPreference.matches && !userPaused) frame = requestAnimationFrame(draw);
  }

  function requestDraw() {
    if (!frame && !contextLost && inView && !document.hidden) frame = requestAnimationFrame(draw);
  }

  if ('IntersectionObserver' in window) {
    const observer = new IntersectionObserver(([entry]) => {
      inView = entry.isIntersecting;
      if (inView) requestDraw();
      else { cancelAnimationFrame(frame); frame = 0; previousTime = 0; }
    });
    observer.observe(art);
  }

  art.addEventListener('pointermove', (event) => {
    if (event.pointerType === 'touch' || motionPreference.matches || userPaused) return;
    const rect = art.getBoundingClientRect();
    pointerX = (event.clientX - rect.left) / rect.width * 2 - 1;
    pointerY = (event.clientY - rect.top) / rect.height * 2 - 1;
  });
  art.addEventListener('pointerleave', () => { pointerX = pointerY = 0; });

  document.addEventListener('visibilitychange', () => {
    if (document.hidden) { cancelAnimationFrame(frame); frame = 0; previousTime = 0; }
    else requestDraw();
  });
  window.addEventListener('resize', requestDraw, { passive: true });
  function updateMotionControl() {
    motionButton.hidden = motionPreference.matches || contextLost;
    motionButton.setAttribute('aria-pressed', String(userPaused));
    motionButton.innerHTML = userPaused ? 'Play animation <span aria-hidden="true">▷</span>' : 'Pause animation <span aria-hidden="true">Ⅱ</span>';
    art.classList.toggle('art-paused', userPaused);
  }
  motionButton.addEventListener('click', () => {
    userPaused = !userPaused;
    cancelAnimationFrame(frame);
    frame = 0;
    previousTime = 0;
    updateMotionControl();
    requestDraw();
  });
  motionPreference.addEventListener('change', () => {
    previousTime = 0;
    updateMotionControl();
    requestDraw();
  });
  canvas.addEventListener('webglcontextlost', (event) => {
    event.preventDefault();
    contextLost = true;
    cancelAnimationFrame(frame);
    frame = 0;
    art.classList.remove('sculpture-ready');
    updateMotionControl();
  });
  updateMotionControl();
  requestDraw();
})();
