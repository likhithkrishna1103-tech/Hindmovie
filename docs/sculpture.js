/* Original </> sculpture. Continuous, filleted, bevelled solid meshes; a small
   physically based studio renderer; and a blurred reflection. No dependencies.
   This file owns its accessible label and vector fallback as well as WebGL. */
(() => {
  'use strict';

  const canvas = document.getElementById('sculpture');
  const art = canvas?.closest('.hero-art');
  if (!canvas || !art) return;
  art.setAttribute('aria-label', 'Sculpted charcoal code brackets with a green forward slash');
  const oldShadow = art.querySelector('.cup-shadow');
  if (oldShadow) oldShadow.hidden = true;
  const fallback = art.querySelector('.sculpture-fallback');
  if (fallback) {
    fallback.innerHTML = `
      <defs>
        <linearGradient id="code-graphite" x1="0" y1="0" x2="1" y2="1">
          <stop stop-color="#65696c"/><stop offset=".25" stop-color="#303337"/>
          <stop offset=".7" stop-color="#1e2124"/><stop offset="1" stop-color="#4c5053"/>
        </linearGradient>
        <linearGradient id="code-jade" x1="0" y1="0" x2="1" y2="1">
          <stop stop-color="#e0ffb1"/><stop offset=".4" stop-color="#c0eb7e"/><stop offset="1" stop-color="#729b46"/>
        </linearGradient>
        <radialGradient id="code-shadow"><stop stop-color="#000" stop-opacity=".55"/><stop offset="1" stop-color="#000" stop-opacity="0"/></radialGradient>
      </defs>
      <ellipse cx="260" cy="400" rx="190" ry="29" fill="url(#code-shadow)"/>
      <g stroke-linejoin="round" stroke-width="8">
        <path d="m169 157-81 91 81 90-24 24L43 248l102-115Z" fill="#52575a" stroke="#52575a" transform="translate(12 10)"/>
        <path d="m169 157-81 91 81 90-24 24L43 248l102-115Z" fill="url(#code-graphite)" stroke="url(#code-graphite)"/>
        <path d="m355 145 101 110-101 107-24-25 80-82-80-84Z" fill="#4a4f51" stroke="#4a4f51" transform="translate(12 9)"/>
        <path d="m355 145 101 110-101 107-24-25 80-82-80-84Z" fill="url(#code-graphite)" stroke="url(#code-graphite)"/>
      </g>
      <rect x="247" y="119" width="33" height="264" rx="16.5" fill="#4b6937" transform="rotate(18 264 251) translate(10 8)"/>
      <rect x="247" y="119" width="33" height="264" rx="16.5" fill="url(#code-jade)" transform="rotate(18 264 251)"/>
    `;
  }

  const gl = canvas.getContext('webgl', {
    alpha: true, antialias: true, premultipliedAlpha: true, powerPreference: 'low-power',
  });
  if (!gl) return;

  const FLOOR = -1.22;
  const TAU = Math.PI * 2;
  const clamp = (value, min, max) => Math.min(max, Math.max(min, value));
  const normalize = (v) => {
    const length = Math.hypot(...v) || 1;
    return v.map((value) => value / length);
  };
  const cross3 = (a, b) => [a[1] * b[2] - a[2] * b[1], a[2] * b[0] - a[0] * b[2], a[0] * b[1] - a[1] * b[0]];
  const dot = (a, b) => a.reduce((sum, value, i) => sum + value * b[i], 0);
  const cross2 = (a, b, c) => (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);

  function multiply(a, b) {
    const result = new Float32Array(16);
    for (let col = 0; col < 4; col++) {
      for (let row = 0; row < 4; row++) {
        for (let k = 0; k < 4; k++) result[col * 4 + row] += a[k * 4 + row] * b[col * 4 + k];
      }
    }
    return result;
  }
  function transform(x, y, z, translation = [0, 0, 0], scale = 1) {
    const cx = Math.cos(x), sx = Math.sin(x), cy = Math.cos(y), sy = Math.sin(y);
    const cz = Math.cos(z), sz = Math.sin(z);
    return new Float32Array([
      cz * cy * scale, sz * cy * scale, -sy * scale, 0,
      (cz * sy * sx - sz * cx) * scale, (sz * sy * sx + cz * cx) * scale, cy * sx * scale, 0,
      (cz * sy * cx + sz * sx) * scale, (sz * sy * cx - cz * sx) * scale, cy * cx * scale, 0,
      ...translation, 1,
    ]);
  }
  function lookAt(eye, target) {
    const z = normalize(eye.map((value, i) => value - target[i]));
    const x = normalize(cross3([0, 1, 0], z)), y = cross3(z, x);
    return new Float32Array([
      x[0], y[0], z[0], 0, x[1], y[1], z[1], 0, x[2], y[2], z[2], 0,
      -dot(x, eye), -dot(y, eye), -dot(z, eye), 1,
    ]);
  }
  function perspective(aspect) {
    const f = 1 / Math.tan(38 * Math.PI / 360), near = 0.1, far = 30;
    return new Float32Array([
      f / aspect, 0, 0, 0, 0, f, 0, 0,
      0, 0, (far + near) / (near - far), -1, 0, 0, 2 * far * near / (near - far), 0,
    ]);
  }

  // Circular fillets give every contour a continuous tangent. Offset contours
  // then make the front bevel: neither glyph is assembled from intersecting bars.
  function filletPolygon(input, requestedRadius) {
    let points = input.map((p) => [...p]);
    const area = points.reduce((sum, p, i) => {
      const q = points[(i + 1) % points.length];
      return sum + p[0] * q[1] - q[0] * p[1];
    }, 0);
    if (area < 0) points.reverse();
    const contour = [];
    let smallestRadius = Infinity;
    for (let i = 0; i < points.length; i++) {
      const p = points[(i - 1 + points.length) % points.length], v = points[i], q = points[(i + 1) % points.length];
      const incoming = normalize([v[0] - p[0], v[1] - p[1]]);
      const outgoing = normalize([q[0] - v[0], q[1] - v[1]]);
      const turn = Math.atan2(incoming[0] * outgoing[1] - incoming[1] * outgoing[0], dot(incoming, outgoing));
      const sign = Math.sign(turn) || 1;
      const tangent = Math.tan(Math.abs(turn) / 2);
      const trim = Math.min(requestedRadius * tangent, Math.hypot(v[0] - p[0], v[1] - p[1]) * .34, Math.hypot(q[0] - v[0], q[1] - v[1]) * .34);
      const radius = trim / Math.max(tangent, 0.0001);
      smallestRadius = Math.min(smallestRadius, radius);
      const entry = [v[0] - incoming[0] * trim, v[1] - incoming[1] * trim];
      const center = [entry[0] - incoming[1] * radius * sign, entry[1] + incoming[0] * radius * sign];
      const start = Math.atan2(entry[1] - center[1], entry[0] - center[0]);
      const steps = Math.max(8, Math.ceil(Math.abs(turn) * 10));
      for (let step = 0; step <= steps; step++) {
        const angle = start + turn * step / steps;
        const c = Math.cos(angle), s = Math.sin(angle);
        contour.push({ p: [center[0] + radius * c, center[1] + radius * s], inward: [-c * sign, -s * sign] });
      }
    }
    return { contour, smallestRadius };
  }

  function triangulate(points) {
    const remaining = points.map((_, i) => i), triangles = [];
    const inside = (p, a, b, c) => cross2(a, b, p) >= -1e-9 && cross2(b, c, p) >= -1e-9 && cross2(c, a, p) >= -1e-9;
    let attempts = 0;
    while (remaining.length > 3 && attempts++ < points.length * points.length) {
      let clipped = false;
      for (let i = 0; i < remaining.length; i++) {
        const a = remaining[(i - 1 + remaining.length) % remaining.length], b = remaining[i], c = remaining[(i + 1) % remaining.length];
        if (cross2(points[a], points[b], points[c]) <= 1e-10) continue;
        if (remaining.some((j) => j !== a && j !== b && j !== c && inside(points[j], points[a], points[b], points[c]))) continue;
        triangles.push(a, b, c);
        remaining.splice(i, 1);
        clipped = true;
        break;
      }
      if (!clipped) throw new Error('Unable to close sculpture face');
    }
    if (remaining.length === 3) triangles.push(...remaining);
    return triangles;
  }

  function extrude(points, { radius = .09, depth = .34, bevel = .055 } = {}) {
    const shape = filletPolygon(points, radius);
    const b = Math.min(bevel, shape.smallestRadius * .62);
    const n = shape.contour.length, positions = [], normals = [], indices = [];
    const profile = [];
    const bevelSteps = 12;
    for (let i = bevelSteps; i >= 0; i--) {
      const theta = i / bevelSteps * Math.PI / 2;
      profile.push([b * (1 - Math.cos(theta)), -depth / 2 + b - b * Math.sin(theta), Math.cos(theta), -Math.sin(theta)]);
    }
    for (let i = 0; i <= bevelSteps; i++) {
      const theta = i / bevelSteps * Math.PI / 2;
      profile.push([b * (1 - Math.cos(theta)), depth / 2 - b + b * Math.sin(theta), Math.cos(theta), Math.sin(theta)]);
    }
    for (let ring = 0; ring < profile.length; ring++) {
      const [inset, z, sideNormal, frontNormal] = profile[ring];
      for (const { p, inward } of shape.contour) {
        positions.push(p[0] + inward[0] * inset, p[1] + inward[1] * inset, z);
        normals.push(-inward[0] * sideNormal, -inward[1] * sideNormal, frontNormal);
      }
      if (ring < profile.length - 1) {
        for (let i = 0; i < n; i++) {
          const a = ring * n + i, next = ring * n + (i + 1) % n, upper = a + n, upperNext = next + n;
          indices.push(a, next, upper, next, upperNext, upper);
        }
      }
    }
    const face = shape.contour.map(({ p, inward }) => [p[0] + inward[0] * b, p[1] + inward[1] * b]);
    const cap = triangulate(face), front = (profile.length - 1) * n;
    for (let i = 0; i < cap.length; i += 3) {
      indices.push(front + cap[i], front + cap[i + 1], front + cap[i + 2]);
      indices.push(cap[i + 2], cap[i + 1], cap[i]);
    }
    return { positions: new Float32Array(positions), normals: new Float32Array(normals), indices: new Uint16Array(indices) };
  }

  let geometry;
  try {
    const chevron = [[.44, .61], [-.16, 0], [.44, -.61], [.25, -.80], [-.55, 0], [.25, .80]];
    geometry = [
      extrude(chevron),
      extrude(chevron.map(([x, y]) => [-x, y])),
      extrude([[-.115, -.98], [.115, -.98], [.115, .98], [-.115, .98]], { radius: .115, depth: .38, bevel: .052 }),
    ];
  } catch (error) {
    console.warn('Sculpture geometry:', error.message);
    return;
  }

  function createRenderer() {
    const resources = { programs: [], buffers: [], targets: [] };
    const precision = gl.getShaderPrecisionFormat(gl.FRAGMENT_SHADER, gl.HIGH_FLOAT).precision ? 'highp' : 'mediump';
    function program(vertex, fragment) {
      const parts = [];
      try {
        for (const [type, source] of [[gl.VERTEX_SHADER, vertex], [gl.FRAGMENT_SHADER, `precision ${precision} float;\n${fragment}`]]) {
          const part = gl.createShader(type);
          gl.shaderSource(part, source);
          gl.compileShader(part);
          if (!gl.getShaderParameter(part, gl.COMPILE_STATUS)) {
            const message = gl.getShaderInfoLog(part);
            gl.deleteShader(part);
            throw new Error(message);
          }
          parts.push(part);
        }
        const result = gl.createProgram();
        parts.forEach((part) => gl.attachShader(result, part));
        gl.bindAttribLocation(result, 0, 'aPosition');
        gl.bindAttribLocation(result, 1, 'aNormal');
        gl.linkProgram(result);
        if (!gl.getProgramParameter(result, gl.LINK_STATUS)) {
          const message = gl.getProgramInfoLog(result);
          gl.deleteProgram(result);
          throw new Error(message);
        }
        resources.programs.push(result);
        return result;
      } finally {
        parts.forEach((part) => gl.deleteShader(part));
      }
    }
    const meshProgram = program(`
      attribute vec3 aPosition;
      attribute vec3 aNormal;
      uniform mat4 uViewProjection;
      uniform mat4 uModel;
      uniform float uReflection;
      varying mediump vec3 vWorld;
      varying mediump vec3 vNormal;
      varying mediump vec3 vLocal;
      varying mediump float vFront;
      void main() {
        vec4 world = uModel * vec4(aPosition, 1.0);
        vWorld = world.xyz;
        vNormal = mat3(uModel) * aNormal;
        vLocal = aPosition;
        vFront = abs(aNormal.z);
        if (uReflection > 0.5) world.y = ${2 * FLOOR} - world.y;
        gl_Position = uViewProjection * world;
      }
    `, `
      uniform vec3 uCamera;
      uniform float uJade;
      uniform float uLightShift;
      varying mediump vec3 vWorld;
      varying mediump vec3 vNormal;
      varying mediump vec3 vLocal;
      varying mediump float vFront;
      const float PI = 3.14159265;

      vec3 fresnel(float cosine, vec3 f0) { return f0 + (1.0 - f0) * pow(1.0 - cosine, 5.0); }
      vec3 brdf(vec3 n, vec3 v, vec3 light, vec3 energy, vec3 base, float metal, float roughness) {
        vec3 l = normalize(light - vWorld), h = normalize(v + l);
        float nl = max(dot(n, l), 0.0), nv = max(dot(n, v), 0.001);
        float nh = max(dot(n, h), 0.0), vh = max(dot(v, h), 0.0);
        float a = roughness * roughness, a2 = a * a;
        float denominator = nh * nh * (a2 - 1.0) + 1.0;
        float distribution = a2 / max(PI * denominator * denominator, 0.0001);
        float k = (roughness + 1.0) * (roughness + 1.0) / 8.0;
        float visibility = (nv / (nv * (1.0 - k) + k)) * (nl / (nl * (1.0 - k) + k));
        vec3 f = fresnel(vh, mix(vec3(0.04), base, metal));
        vec3 specular = distribution * visibility * f / max(4.0 * nv * nl, 0.001);
        vec3 diffuse = (1.0 - f) * (1.0 - metal) * base / PI;
        return (diffuse + specular) * energy * nl;
      }
      float softbox(vec3 r, vec3 direction, vec2 size, float blur) {
        vec3 d = normalize(direction), x = normalize(cross(vec3(0.0, 1.0, 0.0), d)), y = cross(d, x);
        float facing = dot(r, d);
        vec2 p = abs(vec2(dot(r, x), dot(r, y))) / max(facing, 0.001);
        vec2 mask = 1.0 - smoothstep(size, size + vec2(blur), p);
        return mask.x * mask.y * smoothstep(0.0, 0.15, facing);
      }
      vec3 environment(vec3 r, float roughness) {
        float blur = .08 + roughness * .65;
        vec3 color = mix(vec3(.025, .028, .032), vec3(.15, .16, .17), smoothstep(-.6, 1.0, r.y));
        color += vec3(1.35, 1.31, 1.24) * softbox(r, vec3(-.75 + uLightShift, .65, 1.0), vec2(.24, .75), blur);
        color += vec3(.75, .82, .88) * softbox(r, vec3(1.0, .1, .6), vec2(.12, .9), blur);
        color += vec3(.9, .95, .84) * softbox(r, vec3(.15, 1.0, -.25), vec2(.8, .13), blur);
        return color;
      }
      vec3 aces(vec3 x) { return clamp((x * (2.51 * x + .03)) / (x * (2.43 * x + .59) + .14), 0.0, 1.0); }
      void main() {
        vec3 n = normalize(vNormal), v = normalize(uCamera - vWorld);
        float front = smoothstep(.7, .99, vFront);
        float brush = sin(vLocal.y * 180.0) * .0015 * (1.0 - uJade) * front;
        float roughness = mix(.17, .32, front) + brush;
        roughness = mix(roughness, .23, uJade);
        float metal = mix(.68, .16, uJade);
        vec3 base = mix(vec3(.065, .071, .079), vec3(.49, .73, .245), uJade);
        vec3 color = brdf(n, v, vec3(-3.5 + uLightShift, 4.0, 4.5), vec3(4.8, 4.65, 4.4), base, metal, roughness);
        color += brdf(n, v, vec3(4.0, .6, 3.0), vec3(1.8, 1.95, 2.1), base, metal, roughness);
        color += brdf(n, v, vec3(0.0, 4.5, -2.0), vec3(2.8, 3.0, 2.6), base, metal, roughness);
        // Local green bounce ties the central slash to the two graphite pieces.
        float distanceToSlash = length(vWorld - vec3(0.0, 0.05, .25));
        color += brdf(n, v, vec3(0.0, .15, .9), vec3(.32, .55, .14) / (1.0 + distanceToSlash * 3.0), base, metal, roughness) * (1.0 - uJade);
        vec3 f0 = mix(vec3(.04), base, metal);
        vec3 f = fresnel(max(dot(n, v), 0.0), f0);
        color += environment(reflect(-v, n), roughness) * f * .8;
        color += base * vec3(.14, .15, .16) * (1.0 - metal);
        // A resin-like green face stays clear while retaining specular depth.
        color += base * .12 * uJade;
        color = pow(aces(color * mix(1.15, .75, uJade)), vec3(1.0 / 2.2));
        gl_FragColor = vec4(color, 1.0);
      }
    `);

    const floorProgram = program(`
      attribute vec3 aPosition;
      uniform mat4 uViewProjection;
      varying mediump vec2 vFloor;
      void main() { vFloor = aPosition.xz; gl_Position = uViewProjection * vec4(aPosition, 1.0); }
    `, `
      varying mediump vec2 vFloor;
      void main() {
        float left = exp(-pow((vFloor.x + .95) / .48, 2.0) - pow((vFloor.y + .02) / .44, 2.0));
        float right = exp(-pow((vFloor.x - .95) / .48, 2.0) - pow((vFloor.y + .02) / .44, 2.0));
        float center = exp(-pow(vFloor.x / .38, 2.0) - pow(vFloor.y / .32, 2.0));
        float alpha = clamp((left + right) * .28 + center * .30, 0.0, .58);
        vec3 light = vec3(.012, .021, .005) * center;
        gl_FragColor = vec4(light, alpha);
      }
    `);

    const postProgram = program(`
      attribute vec2 aPosition;
      varying mediump vec2 vUV;
      void main() { vUV = aPosition * .5 + .5; gl_Position = vec4(aPosition, 0.0, 1.0); }
    `, `
      uniform sampler2D uImage;
      uniform vec2 uDirection;
      uniform float uComposite;
      uniform float uFloorLine;
      varying mediump vec2 vUV;
      void main() {
        if (uComposite > .5) {
          vec4 color = texture2D(uImage, vUV);
          float below = 1.0 - smoothstep(uFloorLine - .008, uFloorLine + .012, vUV.y);
          float fade = pow(smoothstep(.015, max(.04, uFloorLine), vUV.y), 2.0);
          gl_FragColor = color * below * fade * .23;
        } else {
          vec4 color = texture2D(uImage, vUV) * .227027;
          color += texture2D(uImage, vUV + uDirection * 1.384615) * .316216;
          color += texture2D(uImage, vUV - uDirection * 1.384615) * .316216;
          color += texture2D(uImage, vUV + uDirection * 3.230769) * .070270;
          color += texture2D(uImage, vUV - uDirection * 3.230769) * .070270;
          gl_FragColor = color;
        }
      }
    `);

    function buffer(data, target = gl.ARRAY_BUFFER) {
      const result = gl.createBuffer();
      gl.bindBuffer(target, result);
      gl.bufferData(target, data, gl.STATIC_DRAW);
      resources.buffers.push(result);
      return result;
    }
    const meshes = geometry.map((mesh) => ({
      position: buffer(mesh.positions), normal: buffer(mesh.normals), index: buffer(mesh.indices, gl.ELEMENT_ARRAY_BUFFER), count: mesh.indices.length,
    }));
    const quad = buffer(new Float32Array([-1, -1, 1, -1, -1, 1, -1, 1, 1, -1, 1, 1]));
    const floor = buffer(new Float32Array([-4, FLOOR, -3, 4, FLOOR, -3, -4, FLOOR, 3, -4, FLOOR, 3, 4, FLOOR, -3, 4, FLOOR, 3]));
    const locations = (p, names) => Object.fromEntries(names.map((name) => [name, gl.getUniformLocation(p, name)]));
    const meshUniforms = locations(meshProgram, ['uViewProjection', 'uModel', 'uReflection', 'uCamera', 'uJade', 'uLightShift']);
    const floorUniforms = locations(floorProgram, ['uViewProjection']);
    const postUniforms = locations(postProgram, ['uImage', 'uDirection', 'uComposite', 'uFloorLine']);
    const camera = [0, .32, 4.9], view = lookAt(camera, [0, -.025, 0]);
    let viewProjection, floorLine = .12, width = 0, height = 0, targets = null;

    function deleteTarget(target) {
      gl.deleteTexture(target.texture);
      gl.deleteFramebuffer(target.framebuffer);
      if (target.depth) gl.deleteRenderbuffer(target.depth);
    }
    function target(w, h, depth) {
      const texture = gl.createTexture(), framebuffer = gl.createFramebuffer();
      gl.bindTexture(gl.TEXTURE_2D, texture);
      gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, w, h, 0, gl.RGBA, gl.UNSIGNED_BYTE, null);
      gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
      gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.LINEAR);
      gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
      gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
      gl.bindFramebuffer(gl.FRAMEBUFFER, framebuffer);
      gl.framebufferTexture2D(gl.FRAMEBUFFER, gl.COLOR_ATTACHMENT0, gl.TEXTURE_2D, texture, 0);
      let attachment = null;
      if (depth) {
        attachment = gl.createRenderbuffer();
        gl.bindRenderbuffer(gl.RENDERBUFFER, attachment);
        gl.renderbufferStorage(gl.RENDERBUFFER, gl.DEPTH_COMPONENT16, w, h);
        gl.framebufferRenderbuffer(gl.FRAMEBUFFER, gl.DEPTH_ATTACHMENT, gl.RENDERBUFFER, attachment);
      }
      const result = { texture, framebuffer, depth: attachment, width: w, height: h };
      if (gl.checkFramebufferStatus(gl.FRAMEBUFFER) !== gl.FRAMEBUFFER_COMPLETE) {
        deleteTarget(result);
        throw new Error('Reflection framebuffer unavailable');
      }
      resources.targets.push(result);
      return result;
    }
    function resize() {
      const ratio = Math.min(window.devicePixelRatio || 1, 1.5);
      const w = Math.max(1, Math.round(canvas.clientWidth * ratio)), h = Math.max(1, Math.round(canvas.clientHeight * ratio));
      if (w === width && h === height) return;
      width = w; height = h;
      canvas.width = w; canvas.height = h;
      viewProjection = multiply(perspective(w / h), view);
      const y = viewProjection[5] * FLOOR + viewProjection[13], clipW = viewProjection[7] * FLOOR + viewProjection[15];
      floorLine = y / clipW * .5 + .5;
      if (targets) targets.forEach(deleteTarget);
      resources.targets = [];
      const reflectionWidth = Math.min(512, Math.max(128, Math.round(w * .5)));
      const reflectionHeight = Math.min(512, Math.max(128, Math.round(h * .5)));
      targets = [target(reflectionWidth, reflectionHeight, true), target(reflectionWidth, reflectionHeight, false), target(reflectionWidth, reflectionHeight, false)];
    }
    function attribute(slot, data, size) {
      gl.bindBuffer(gl.ARRAY_BUFFER, data);
      gl.enableVertexAttribArray(slot);
      gl.vertexAttribPointer(slot, size, gl.FLOAT, false, 0, 0);
    }
    function drawMeshes(models, reflection, time) {
      gl.useProgram(meshProgram);
      gl.enable(gl.DEPTH_TEST);
      gl.depthMask(true);
      // The mirrored pass reverses winding, so both sides use depth testing.
      gl.disable(gl.CULL_FACE);
      gl.disable(gl.BLEND);
      gl.uniformMatrix4fv(meshUniforms.uViewProjection, false, viewProjection);
      gl.uniform3fv(meshUniforms.uCamera, camera);
      gl.uniform1f(meshUniforms.uReflection, reflection ? 1 : 0);
      gl.uniform1f(meshUniforms.uLightShift, Math.sin(time * .18) * .13);
      for (let i = 0; i < meshes.length; i++) {
        const mesh = meshes[i];
        attribute(0, mesh.position, 3);
        attribute(1, mesh.normal, 3);
        gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, mesh.index);
        gl.uniformMatrix4fv(meshUniforms.uModel, false, models[i]);
        gl.uniform1f(meshUniforms.uJade, i === 2 ? 1 : 0);
        gl.drawElements(gl.TRIANGLES, mesh.count, gl.UNSIGNED_SHORT, 0);
      }
    }
    function post(image, destination, dx, dy, composite) {
      gl.bindFramebuffer(gl.FRAMEBUFFER, destination?.framebuffer || null);
      gl.viewport(0, 0, destination?.width || width, destination?.height || height);
      gl.useProgram(postProgram);
      gl.disable(gl.DEPTH_TEST);
      gl.depthMask(false);
      gl.disableVertexAttribArray(1);
      attribute(0, quad, 2);
      gl.activeTexture(gl.TEXTURE0);
      gl.bindTexture(gl.TEXTURE_2D, image);
      gl.uniform1i(postUniforms.uImage, 0);
      gl.uniform2f(postUniforms.uDirection, dx, dy);
      gl.uniform1f(postUniforms.uComposite, composite ? 1 : 0);
      gl.uniform1f(postUniforms.uFloorLine, floorLine);
      if (composite) { gl.enable(gl.BLEND); gl.blendFunc(gl.ONE, gl.ONE_MINUS_SRC_ALPHA); }
      else gl.disable(gl.BLEND);
      gl.drawArrays(gl.TRIANGLES, 0, 6);
    }
    function draw(time, pointer) {
      resize();
      const group = transform(.10 + pointer[1] * .10, -.20 + pointer[0] * .18, -.015, [0, .015, 0], 1.025);
      const models = [
        multiply(group, transform(.035, -.16 + Math.sin(time * .37) * .025, -.025, [-.98, Math.sin(time * .55) * .025, -.025])),
        multiply(group, transform(-.025, .18 + Math.cos(time * .31) * .025, .025, [.98, Math.sin(time * .47 + 1.4) * .025, -.055])),
        multiply(group, transform(.025, -.08 + Math.sin(time * .32) * .035, -.31, [0, .015 + Math.sin(time * .52 + .6) * .035, .14])),
      ];
      // Render a real mirrored scene, then blur it at half resolution in two passes.
      gl.bindFramebuffer(gl.FRAMEBUFFER, targets[0].framebuffer);
      gl.viewport(0, 0, targets[0].width, targets[0].height);
      gl.depthMask(true);
      gl.clearColor(0, 0, 0, 0);
      gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
      drawMeshes(models, true, time);
      post(targets[0].texture, targets[1], 1.1 / targets[0].width, 0, false);
      post(targets[1].texture, targets[2], 0, 1.1 / targets[0].height, false);

      gl.bindFramebuffer(gl.FRAMEBUFFER, null);
      gl.viewport(0, 0, width, height);
      gl.depthMask(true);
      gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
      gl.useProgram(floorProgram);
      gl.disable(gl.DEPTH_TEST);
      gl.depthMask(false);
      gl.enable(gl.BLEND);
      gl.blendFunc(gl.ONE, gl.ONE_MINUS_SRC_ALPHA);
      gl.disableVertexAttribArray(1);
      attribute(0, floor, 3);
      gl.uniformMatrix4fv(floorUniforms.uViewProjection, false, viewProjection);
      gl.drawArrays(gl.TRIANGLES, 0, 6);
      post(targets[2].texture, null, 0, 0, true);
      drawMeshes(models, false, time);
    }
    return {
      draw,
      dispose() {
        resources.targets.forEach(deleteTarget);
        resources.buffers.forEach((b) => gl.deleteBuffer(b));
        resources.programs.forEach((p) => gl.deleteProgram(p));
      },
    };
  }

  let renderer;
  try { renderer = createRenderer(); }
  catch (error) { console.warn('Sculpture renderer:', error.message); return; }
  const motionPreference = window.matchMedia('(prefers-reduced-motion: reduce)');
  let frame = 0, inView = true, lost = false, activeTime = 0, previousTime = 0, lastDraw = 0;
  let pointerX = 0, pointerY = 0, smoothX = 0, smoothY = 0;

  function draw(now) {
    frame = 0;
    if (lost || !inView || document.hidden) { previousTime = 0; return; }
    if (!motionPreference.matches && now - lastDraw < 1000 / 30) { frame = requestAnimationFrame(draw); return; }
    const dt = previousTime ? Math.min((now - previousTime) / 1000, .05) : 0;
    previousTime = now;
    lastDraw = now;
    if (motionPreference.matches) {
      activeTime = 0; smoothX = smoothY = 0;
    } else {
      activeTime += dt;
      const damp = 1 - Math.exp(-dt * 6);
      smoothX += (pointerX - smoothX) * damp;
      smoothY += (pointerY - smoothY) * damp;
    }
    try {
      renderer.draw(activeTime, [smoothX, smoothY]);
      if (!gl.isContextLost()) art.classList.add('sculpture-ready');
    } catch (error) {
      console.warn('Sculpture rendering:', error.message);
      art.classList.remove('sculpture-ready');
      renderer.dispose();
      lost = true;
      return;
    }
    if (!motionPreference.matches) frame = requestAnimationFrame(draw);
  }
  function requestDraw() {
    if (!frame && !lost && inView && !document.hidden) frame = requestAnimationFrame(draw);
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
    const bounds = art.getBoundingClientRect();
    pointerX = clamp((event.clientX - bounds.left) / bounds.width * 2 - 1, -1, 1);
    pointerY = clamp((event.clientY - bounds.top) / bounds.height * 2 - 1, -1, 1);
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
    lost = true;
    cancelAnimationFrame(frame);
    frame = 0;
    art.classList.remove('sculpture-ready');
  });
  canvas.addEventListener('webglcontextrestored', () => {
    try {
      renderer = createRenderer();
      lost = false;
      previousTime = 0;
      requestDraw();
    } catch (error) { console.warn('Sculpture restoration:', error.message); }
  });
  requestDraw();
})();
