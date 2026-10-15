/* Dependency-free WebGL takeaway cup, pouring coffee, and a floor reflection.
   Decorative only; page content and donations work without graphics or JS. */
(() => {
  'use strict';

  const canvas = document.getElementById('sculpture');
  const art = canvas?.closest('.hero-art');
  if (!canvas || !art) return;
  const gl = canvas.getContext('webgl', {
    alpha: true, antialias: true, premultipliedAlpha: true, powerPreference: 'low-power',
  });
  if (!gl) return;

  const vertexSource = `
    attribute vec3 aPosition;
    attribute vec3 aNormal;
    attribute float aMaterial;
    uniform mat4 uProjection;
    uniform mat3 uRotation;
    uniform mediump float uTime;
    uniform float uReflection;
    varying mediump vec3 vPosition;
    varying mediump vec3 vNormal;
    varying mediump vec3 vLocal;
    varying mediump float vMaterial;
    varying mediump float vAlpha;
    const float PI = 3.14159265;
    const float FLOOR = -0.985;

    void main() {
      vec3 p = aPosition;
      vec3 n = aNormal;
      float kind = floor(aMaterial + 0.001);
      float phase = fract(aMaterial);
      vAlpha = 1.0;

      if (kind == 1.0) {
        float r = length(p.xz);
        float wave = r * 38.0 - uTime * 5.5;
        p.y += sin(wave) * 0.003 * smoothstep(0.03, 0.18, r);
        n = normalize(vec3(-cos(wave) * p.x * 0.025, 1.0, -cos(wave) * p.z * 0.025));
      } else if (kind == 3.0) {
        // Irregular highlights and a changing cross-section travel downward.
        float wobble = sin(p.y * 13.0 + uTime * 6.0);
        p.xz *= 1.0 + wobble * 0.12;
        p.x += sin(p.y * 5.5 + uTime * 2.3) * 0.009;
        p.z += cos(p.y * 6.0 + uTime * 2.0) * 0.008;
        n = normalize(n + vec3(wobble * 0.12, 0.0, 0.0));
      } else if (kind == 4.0) {
        // Each ring expands from the point where the stream meets the coffee.
        float age = fract(uTime * 0.38 + phase);
        p.xz *= 0.035 + age * 0.66;
        p.y = 0.845 + sin(age * PI) * 0.001;
        vAlpha = pow(1.0 - age, 1.6) * 0.48;
      } else if (kind == 6.0) {
        float age = fract(uTime * 0.48 + phase);
        float angle = phase * PI * 6.0 + 0.5;
        float reach = 0.02 + age * 0.21;
        p += vec3(cos(angle) * reach, 0.845 + sin(age * PI) * 0.11, sin(angle) * reach);
        vAlpha = sin(age * PI) * 0.8;
      }

      vLocal = p;
      if (uReflection > 0.5) {
        vAlpha *= pow(clamp(1.0 - (p.y - FLOOR) / 2.0, 0.0, 1.0), 2.1) * 0.26;
        p.y = 2.0 * FLOOR - p.y;
        n.y = -n.y;
      }
      vPosition = uRotation * p * 1.08;
      vPosition.y -= 0.04;
      vNormal = uRotation * n;
      vMaterial = aMaterial;
      gl_Position = uProjection * vec4(vPosition - vec3(0.0, 0.0, 5.1), 1.0);
      float screenY = gl_Position.y / gl_Position.w;
      if (uReflection > 0.5) vAlpha *= smoothstep(-0.98, -0.58, screenY);
      if (kind == 3.0) vAlpha *= 1.0 - smoothstep(0.65, 0.98, screenY);
    }
  `;

  const fragmentSource = `
    precision mediump float;
    uniform mediump float uTime;
    uniform sampler2D uLogo;
    varying mediump vec3 vPosition;
    varying mediump vec3 vNormal;
    varying mediump vec3 vLocal;
    varying mediump float vMaterial;
    varying mediump float vAlpha;

    vec3 studio(vec3 r) {
      vec3 color = mix(vec3(0.035), vec3(0.44, 0.45, 0.47), smoothstep(-0.65, 0.95, r.y));
      float broad = pow(max(dot(r, normalize(vec3(-0.7, 0.85, 0.65))), 0.0), 4.0);
      float edge = pow(max(dot(r, normalize(vec3(0.95, 0.1, 0.8))), 0.0), 16.0);
      float rim = pow(max(dot(r, normalize(vec3(-0.6, -0.7, -0.5))), 0.0), 9.0);
      color += vec3(0.95, 0.94, 0.92) * broad * 1.15;
      color += vec3(0.98, 0.99, 1.0) * edge * 1.35;
      color += vec3(0.64, 0.66, 0.69) * rim * 0.8;
      return color;
    }

    void main() {
      if (vAlpha < 0.002) discard;
      vec3 n = normalize(vNormal);
      vec3 view = normalize(vec3(0.0, 0.0, 5.1) - vPosition);
      vec3 reflected = reflect(-view, n);
      float diffuse = max(dot(n, normalize(vec3(-0.4, 0.8, 1.0))), 0.0);
      float fresnel = pow(1.0 - max(dot(n, view), 0.0), 4.0);
      float shine = pow(max(dot(reflected, normalize(vec3(-0.5, 0.7, 1.0))), 0.0), 48.0);
      float kind = floor(vMaterial + 0.001);
      vec3 color;

      if (kind == 3.0 || kind == 6.0) {
        // Near-black espresso with warm, moving specular reflections.
        color = vec3(0.035, 0.021, 0.012) + studio(reflected) * 0.16;
        float flow = pow(0.5 + 0.5 * sin(vLocal.y * 30.0 + uTime * 8.0), 7.0);
        color += vec3(0.15, 0.09, 0.04) * flow * 0.45;
        color += vec3(0.50, 0.35, 0.19) * shine;
        color = pow(color, vec3(0.82));
      } else if (kind == 4.0) {
        color = vec3(0.29, 0.23, 0.16) + studio(reflected) * 0.12;
      } else if (kind == 1.0) {
        color = vec3(0.035, 0.023, 0.016) + studio(reflected) * 0.065;
        color += vec3(0.45, 0.40, 0.33) * shine * 0.3;
      } else {
        float sleeve = step(4.5, kind);
        vec3 base = mix(vec3(0.065, 0.067, 0.070), vec3(0.040, 0.041, 0.042), sleeve);
        color = base * (0.75 + diffuse * 1.2);
        color += studio(reflected) * (0.07 + fresnel * 0.24) * (1.0 - sleeve * 0.3);
        color += vec3(0.36, 0.37, 0.39) * shine * (1.0 - sleeve * 0.65);
        color = pow(color, vec3(0.82));
        if (kind == 5.0 && vLocal.z > 0.0) {
          // One continuous print on the sleeve: no raised or overlapping edges.
          vec2 uv = vec2(vLocal.x / 0.75 + 0.5, (vLocal.y - 0.0125) / 0.85 + 0.5);
          if (uv.x >= 0.0 && uv.x <= 1.0 && uv.y >= 0.0 && uv.y <= 1.0) {
            float ink = texture2D(uLogo, uv).a;
            vec3 green = vec3(0.835, 0.973, 0.584) * (0.86 + diffuse * 0.14);
            color = mix(color, green, ink);
          }
        }
      }
      gl_FragColor = vec4(color, vAlpha);
    }
  `;

  function shader(type, source) {
    const result = gl.createShader(type);
    if (!result) throw new Error('Unable to allocate decorative shader');
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

  // Rasterize the exact header SVG into a high-resolution alpha mask. Applying
  // the print in the sleeve shader avoids seams, overlaps, and depth fighting.
  const logoCanvas = document.createElement('canvas');
  logoCanvas.width = logoCanvas.height = 512;
  const logoContext = logoCanvas.getContext('2d');
  const logoPath = document.querySelector('.brand-mark path')?.getAttribute('d');
  if (!logoContext || !logoPath) return;
  logoContext.setTransform(512 / 34, 0, 0, 512 / 34, 0, 0);
  logoContext.fillStyle = '#fff';
  logoContext.fill(new Path2D(logoPath));
  gl.activeTexture(gl.TEXTURE0);
  gl.bindTexture(gl.TEXTURE_2D, gl.createTexture());
  gl.pixelStorei(gl.UNPACK_FLIP_Y_WEBGL, true);
  gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, logoCanvas);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.LINEAR);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR_MIPMAP_LINEAR);
  gl.generateMipmap(gl.TEXTURE_2D);
  gl.uniform1i(gl.getUniformLocation(program, 'uLogo'), 0);

  const normalize = (v) => {
    const length = Math.hypot(...v) || 1;
    return v.map((value) => value / length);
  };
  const positions = [], normals = [], materials = [], indices = [];
  function vertex(position, normal, material = 0) {
    const index = positions.length / 3;
    positions.push(...position);
    normals.push(...normal);
    materials.push(material);
    return index;
  }

  function smoothProfile(profile) {
    const result = [];
    for (let i = 0; i < profile.length - 1; i++) {
      const a = profile[Math.max(0, i - 1)], b = profile[i];
      const c = profile[i + 1], d = profile[Math.min(profile.length - 1, i + 2)];
      for (let step = 0; step < 5; step++) {
        const t = step / 5;
        result.push([0, 1].map((axis) => 0.5 * (
          2 * b[axis] + (-a[axis] + c[axis]) * t
          + (2 * a[axis] - 5 * b[axis] + 4 * c[axis] - d[axis]) * t * t
          + (-a[axis] + 3 * b[axis] - 3 * c[axis] + d[axis]) * t * t * t
        )));
      }
    }
    result.push(profile[profile.length - 1]);
    return result;
  }

  function lathe(section, material = 0, segments = 96) {
    const start = positions.length / 3;
    for (let i = 0; i < section.length; i++) {
      const [radius, height] = section[i];
      const before = section[Math.max(0, i - 1)];
      const after = section[Math.min(section.length - 1, i + 1)];
      const dr = after[0] - before[0], dy = after[1] - before[1];
      for (let j = 0; j <= segments; j++) {
        const angle = j / segments * Math.PI * 2;
        const c = Math.cos(angle), s = Math.sin(angle);
        vertex([Math.max(0, radius) * c, height, Math.max(0, radius) * s], normalize([dy * c, -dr, dy * s]), material);
        if (i < section.length - 1 && j < segments) {
          const a = start + i * (segments + 1) + j, b = a + segments + 1;
          indices.push(a, b, a + 1, b, b + 1, a + 1);
        }
      }
    }
  }

  // Taller, tapered takeaway silhouette, a rolled lip, and a rounded base.
  const cup = smoothProfile([
    [0, -0.98], [0.44, -0.98], [0.53, -0.975], [0.565, -0.95],
    [0.58, -0.91], [0.585, -0.83], [0.765, 0.72], [0.793, 0.865],
    [0.816, 0.9], [0.824, 0.938], [0.807, 0.964], [0.781, 0.968],
    [0.755, 0.947], [0.748, 0.906], [0.74, 0.854], [0.72, 0.72],
    [0.54, -0.78], [0.50, -0.85], [0.3, -0.86], [0, -0.86],
  ]);
  lathe(cup);
  const sleeve = smoothProfile([
    [0.65, -0.46], [0.655, -0.445], [0.663, -0.43],
    [0.757, 0.39], [0.755, 0.414], [0.742, 0.425],
    [0.735, 0.41], [0.642, -0.42], [0.65, -0.46],
  ]);
  lathe(sleeve, 5);

  const coffeeCenter = vertex([0, 0.835, 0], [0, 1, 0], 1);
  const coffeeStart = positions.length / 3;
  for (let i = 0; i <= 96; i++) {
    const angle = i / 96 * Math.PI * 2;
    vertex([0.729 * Math.cos(angle), 0.835, 0.729 * Math.sin(angle)], [0, 1, 0], 1);
    if (i < 96) indices.push(coffeeCenter, coffeeStart + i, coffeeStart + i + 1);
  }

  // A fine stream extends out of frame and ends inside the cup.
  const streamStart = positions.length / 3, streamSteps = 80, streamSides = 12;
  for (let i = 0; i <= streamSteps; i++) {
    const t = i / streamSteps, y = 0.835 + t * 2.5;
    const radius = 0.027 + (1 - t) * 0.006;
    for (let j = 0; j <= streamSides; j++) {
      const angle = j / streamSides * Math.PI * 2;
      const c = Math.cos(angle), s = Math.sin(angle);
      vertex([radius * c, y, radius * s], [c, 0, s], 3);
      if (i < streamSteps && j < streamSides) {
        const a = streamStart + i * (streamSides + 1) + j, b = a + streamSides + 1;
        indices.push(a, b, a + 1, b, b + 1, a + 1);
      }
    }
  }

  // Four fine rings expand and fade into the coffee surface.
  for (let ring = 0; ring < 4; ring++) {
    const start = positions.length / 3;
    for (let i = 0; i <= 96; i++) {
      const angle = i / 96 * Math.PI * 2;
      for (const radius of [0.986, 1.014]) {
        vertex([radius * Math.cos(angle), 0.845, radius * Math.sin(angle)], [0, 1, 0], 4 + ring / 4);
      }
      if (i < 96) {
        const a = start + i * 2;
        indices.push(a, a + 1, a + 2, a + 1, a + 3, a + 2);
      }
    }
  }

  // Tiny droplets stay close to the impact, avoiding a large splash.
  for (let drop = 0; drop < 4; drop++) {
    const start = positions.length / 3, rings = 8, sides = 12;
    for (let i = 0; i <= rings; i++) {
      const phi = i / rings * Math.PI;
      for (let j = 0; j <= sides; j++) {
        const theta = j / sides * Math.PI * 2;
        const normal = [Math.sin(phi) * Math.cos(theta), Math.cos(phi), Math.sin(phi) * Math.sin(theta)];
        vertex(normal.map((v) => v * 0.014), normal, 6 + drop / 4);
        if (i < rings && j < sides) {
          const a = start + i * (sides + 1) + j, b = a + sides + 1;
          indices.push(a, b, a + 1, b, b + 1, a + 1);
        }
      }
    }
  }

  // Uint16 indices are deliberately used for WebGL 1 compatibility.
  if (positions.length / 3 >= 65536) return;
  function attribute(name, data, size = 3) {
    gl.bindBuffer(gl.ARRAY_BUFFER, gl.createBuffer());
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
  gl.enable(gl.BLEND);
  gl.blendFuncSeparate(gl.SRC_ALPHA, gl.ONE_MINUS_SRC_ALPHA, gl.ONE, gl.ONE_MINUS_SRC_ALPHA);
  gl.clearColor(0, 0, 0, 0);

  const uniform = (name) => gl.getUniformLocation(program, name);
  const projectionLocation = uniform('uProjection'), rotationLocation = uniform('uRotation');
  const timeLocation = uniform('uTime'), reflectionLocation = uniform('uReflection');
  const motionPreference = window.matchMedia('(prefers-reduced-motion: reduce)');
  let inView = true, contextLost = false, frame = 0, projectionReady = false;
  let previousTime = 0, lastRenderedTime = 0, activeTime = 0;
  let pointerX = 0, pointerY = 0, smoothX = 0, smoothY = 0;

  function resize() {
    const ratio = Math.min(window.devicePixelRatio || 1, 1.5);
    const width = Math.max(1, Math.round(canvas.clientWidth * ratio));
    const height = Math.max(1, Math.round(canvas.clientHeight * ratio));
    if (projectionReady && canvas.width === width && canvas.height === height) return;
    canvas.width = width;
    canvas.height = height;
    gl.viewport(0, 0, width, height);
    const f = 1 / Math.tan(38 * Math.PI / 360), near = 0.1, far = 20;
    gl.uniformMatrix4fv(projectionLocation, false, new Float32Array([
      f / (width / height), 0, 0, 0, 0, f, 0, 0,
      0, 0, (far + near) / (near - far), -1,
      0, 0, 2 * far * near / (near - far), 0,
    ]));
    projectionReady = true;
  }

  function rotation(x, y, z) {
    const cx = Math.cos(x), sx = Math.sin(x), cy = Math.cos(y), sy = Math.sin(y);
    const cz = Math.cos(z), sz = Math.sin(z);
    return new Float32Array([
      cz * cy, sz * cy, -sy,
      cz * sy * sx - sz * cx, sz * sy * sx + cz * cx, cy * sx,
      cz * sy * cx + sz * sx, sz * sy * cx - cz * sx, cy * cx,
    ]);
  }

  function draw(time) {
    frame = 0;
    if (contextLost || !inView || document.hidden) { previousTime = 0; return; }
    // Cap decorative rendering at 30 fps, including on high-refresh screens.
    if (!motionPreference.matches && time - lastRenderedTime < 1000 / 30) {
      frame = requestAnimationFrame(draw);
      return;
    }
    lastRenderedTime = time;
    resize();
    if (!motionPreference.matches) {
      if (previousTime) activeTime += Math.min(time - previousTime, 50) / 1000;
      previousTime = time;
      smoothX += (pointerX - smoothX) * 0.035;
      smoothY += (pointerY - smoothY) * 0.035;
    } else {
      activeTime = 0;
      smoothX = smoothY = 0;
    }
    gl.uniformMatrix3fv(rotationLocation, false, rotation(0.5 + smoothY * 0.035, -0.32 + smoothX * 0.07, -0.025));
    gl.uniform1f(timeLocation, activeTime);
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
    gl.uniform1f(reflectionLocation, 1);
    gl.drawElements(gl.TRIANGLES, indices.length, gl.UNSIGNED_SHORT, 0);
    gl.clear(gl.DEPTH_BUFFER_BIT);
    gl.uniform1f(reflectionLocation, 0);
    gl.drawElements(gl.TRIANGLES, indices.length, gl.UNSIGNED_SHORT, 0);
    if (!gl.isContextLost()) art.classList.add('sculpture-ready');
    if (!motionPreference.matches) frame = requestAnimationFrame(draw);
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
    if (event.pointerType === 'touch' || motionPreference.matches) return;
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
  motionPreference.addEventListener('change', () => { previousTime = 0; requestDraw(); });
  canvas.addEventListener('webglcontextlost', (event) => {
    event.preventDefault();
    contextLost = true;
    cancelAnimationFrame(frame);
    frame = 0;
    art.classList.remove('sculpture-ready');
  });
  requestDraw();
})();
