package y2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends HandlerThread implements Handler.Callback {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y1.j f14692v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Handler f14693w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Error f14694x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RuntimeException f14695y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public l f14696z;

    public final void a(int i) throws y1.k {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        this.f14692v.getClass();
        y1.j jVar = this.f14692v;
        int[] iArr = jVar.f14582w;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        y1.b.d("eglGetDisplay failed", eGLDisplayEglGetDisplay != null);
        int[] iArr2 = new int[2];
        y1.b.d("eglInitialize failed", EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr2, 0, iArr2, 1));
        jVar.f14583x = eGLDisplayEglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr3 = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, y1.j.B, 0, eGLConfigArr, 0, 1, iArr3, 0);
        boolean z10 = zEglChooseConfig && iArr3[0] > 0 && eGLConfigArr[0] != null;
        Object[] objArr = {Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr3[0]), eGLConfigArr[0]};
        int i10 = y1.a0.f14551a;
        y1.b.d(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objArr), z10);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(jVar.f14583x, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        y1.b.d("eglCreateContext failed", eGLContextEglCreateContext != null);
        jVar.f14584y = eGLContextEglCreateContext;
        EGLDisplay eGLDisplay = jVar.f14583x;
        if (i == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            y1.b.d("eglCreatePbufferSurface failed", eGLSurfaceEglCreatePbufferSurface != null);
        }
        y1.b.d("eglMakeCurrent failed", EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext));
        jVar.f14585z = eGLSurfaceEglCreatePbufferSurface;
        GLES20.glGenTextures(1, iArr, 0);
        y1.b.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(iArr[0]);
        jVar.A = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(jVar);
        SurfaceTexture surfaceTexture2 = this.f14692v.A;
        surfaceTexture2.getClass();
        this.f14696z = new l(this, surfaceTexture2, i != 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        this.f14692v.getClass();
        y1.j jVar = this.f14692v;
        jVar.f14581v.removeCallbacks(jVar);
        try {
            SurfaceTexture surfaceTexture = jVar.A;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, jVar.f14582w, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = jVar.f14583x;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = jVar.f14583x;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = jVar.f14585z;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(jVar.f14583x, jVar.f14585z);
            }
            EGLContext eGLContext = jVar.f14584y;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(jVar.f14583x, eGLContext);
            }
            EGL14.eglReleaseThread();
            EGLDisplay eGLDisplay3 = jVar.f14583x;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(jVar.f14583x);
            }
            jVar.f14583x = null;
            jVar.f14584y = null;
            jVar.f14585z = null;
            jVar.A = null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                try {
                    a(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                    return true;
                } catch (Error e9) {
                    y1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e9);
                    this.f14694x = e9;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e10) {
                    y1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e10);
                    this.f14695y = e10;
                    synchronized (this) {
                        notify();
                    }
                } catch (y1.k e11) {
                    y1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e11);
                    this.f14695y = new IllegalStateException(e11);
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i == 2) {
                try {
                    b();
                    return true;
                } catch (Throwable th) {
                    try {
                        y1.b.h("PlaceholderSurface", "Failed to release placeholder surface", th);
                        return true;
                    } finally {
                        quit();
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }
}
