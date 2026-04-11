package s1;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int[] A = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Handler f11675u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f11676v = new int[1];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public EGLDisplay f11677w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public EGLContext f11678x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public EGLSurface f11679y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SurfaceTexture f11680z;

    public j(Handler handler) {
        this.f11675u = handler;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f11675u.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture = this.f11680z;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
