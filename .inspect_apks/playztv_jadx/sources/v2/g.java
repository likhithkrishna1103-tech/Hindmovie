package v2;

import android.opengl.GLES20;
import android.util.Log;
import d4.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final float[] i = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f13193j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[] f13194k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q3.d f13196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e0 f13197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13199e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13201h;

    public static boolean b(f fVar) {
        e eVar = fVar.f13189a;
        e eVar2 = fVar.f13190b;
        q3.d[] dVarArr = eVar.f13188a;
        if (dVarArr.length == 1 && dVarArr[0].f10607a == 0) {
            q3.d[] dVarArr2 = eVar2.f13188a;
            if (dVarArr2.length == 1 && dVarArr2[0].f10607a == 0) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        try {
            e0 e0Var = new e0("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f13197c = e0Var;
            this.f13198d = GLES20.glGetUniformLocation(e0Var.f3837v, "uMvpMatrix");
            this.f13199e = GLES20.glGetUniformLocation(this.f13197c.f3837v, "uTexMatrix");
            this.f = this.f13197c.g("aPosition");
            this.f13200g = this.f13197c.g("aTexCoords");
            this.f13201h = GLES20.glGetUniformLocation(this.f13197c.f3837v, "uTexture");
        } catch (s1.k e10) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e10);
        }
    }
}
