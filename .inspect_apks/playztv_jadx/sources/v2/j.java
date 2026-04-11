package v2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import o2.i0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements GLSurfaceView.Renderer, c {
    public float A;
    public float B;
    public final /* synthetic */ k E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i f13209u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f13212x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float[] f13213y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float[] f13214z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float[] f13210v = new float[16];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float[] f13211w = new float[16];
    public final float[] C = new float[16];
    public final float[] D = new float[16];

    public j(k kVar, i iVar) {
        this.E = kVar;
        float[] fArr = new float[16];
        this.f13212x = fArr;
        float[] fArr2 = new float[16];
        this.f13213y = fArr2;
        float[] fArr3 = new float[16];
        this.f13214z = fArr3;
        this.f13209u = iVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.B = 3.1415927f;
    }

    @Override // v2.c
    public final synchronized void a(float[] fArr, float f) {
        float[] fArr2 = this.f13212x;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f4 = -f;
        this.B = f4;
        Matrix.setRotateM(this.f13213y, 0, -this.A, (float) Math.cos(f4), (float) Math.sin(this.B), 0.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            Matrix.multiplyMM(this.D, 0, this.f13212x, 0, this.f13214z, 0);
            Matrix.multiplyMM(this.C, 0, this.f13213y, 0, this.D, 0);
        }
        Matrix.multiplyMM(this.f13211w, 0, this.f13210v, 0, this.C, 0);
        this.f13209u.b(this.f13211w);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i10) {
        GLES20.glViewport(0, 0, i, i10);
        float f = i / i10;
        Matrix.perspectiveM(this.f13210v, 0, f > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d) : 90.0f, f, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        k kVar = this.E;
        kVar.f13219y.post(new i0(kVar, 17, this.f13209u.e()));
    }
}
