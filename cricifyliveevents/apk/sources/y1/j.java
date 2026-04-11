package y1;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int[] B = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    public SurfaceTexture A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f14581v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int[] f14582w = new int[1];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public EGLDisplay f14583x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public EGLContext f14584y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public EGLSurface f14585z;

    public j(Handler handler) {
        this.f14581v = handler;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f14581v.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture = this.A;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
