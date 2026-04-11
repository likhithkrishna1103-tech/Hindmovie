package z2;

import android.opengl.GLES20;
import android.util.Log;
import ff.m;
import pa.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final float[] i = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[] f15141j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[] f15142k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f15144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f15145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15147e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15149h;

    public static boolean b(f fVar) {
        e eVar = fVar.f15137a;
        e eVar2 = fVar.f15138b;
        o[] oVarArr = eVar.f15136a;
        if (oVarArr.length == 1 && oVarArr[0].f10085a == 0) {
            o[] oVarArr2 = eVar2.f15136a;
            if (oVarArr2.length == 1 && oVarArr2[0].f10085a == 0) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        try {
            m mVar = new m("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f15145c = mVar;
            this.f15146d = GLES20.glGetUniformLocation(mVar.f4599w, "uMvpMatrix");
            this.f15147e = GLES20.glGetUniformLocation(this.f15145c.f4599w, "uTexMatrix");
            this.f = this.f15145c.t("aPosition");
            this.f15148g = this.f15145c.t("aTexCoords");
            this.f15149h = GLES20.glGetUniformLocation(this.f15145c.f4599w, "uTexture");
        } catch (y1.k e9) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e9);
        }
    }
}
