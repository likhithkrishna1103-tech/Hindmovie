package u2;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends HandlerThread implements Handler.Callback {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public s1.j f12615u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Handler f12616v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Error f12617w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RuntimeException f12618x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l f12619y;

    public final void a(int i) throws s1.k {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        this.f12615u.getClass();
        s1.j jVar = this.f12615u;
        int[] iArr = jVar.f11676v;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        s1.b.d("eglGetDisplay failed", eGLDisplayEglGetDisplay != null);
        int[] iArr2 = new int[2];
        s1.b.d("eglInitialize failed", EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr2, 0, iArr2, 1));
        jVar.f11677w = eGLDisplayEglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr3 = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, s1.j.A, 0, eGLConfigArr, 0, 1, iArr3, 0);
        boolean z2 = zEglChooseConfig && iArr3[0] > 0 && eGLConfigArr[0] != null;
        Object[] objArr = {Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr3[0]), eGLConfigArr[0]};
        int i10 = s1.b0.f11647a;
        s1.b.d(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objArr), z2);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(jVar.f11677w, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        s1.b.d("eglCreateContext failed", eGLContextEglCreateContext != null);
        jVar.f11678x = eGLContextEglCreateContext;
        EGLDisplay eGLDisplay = jVar.f11677w;
        if (i == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            s1.b.d("eglCreatePbufferSurface failed", eGLSurfaceEglCreatePbufferSurface != null);
        }
        s1.b.d("eglMakeCurrent failed", EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext));
        jVar.f11679y = eGLSurfaceEglCreatePbufferSurface;
        GLES20.glGenTextures(1, iArr, 0);
        s1.b.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(iArr[0]);
        jVar.f11680z = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(jVar);
        SurfaceTexture surfaceTexture2 = this.f12615u.f11680z;
        surfaceTexture2.getClass();
        this.f12619y = new l(this, surfaceTexture2, i != 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        this.f12615u.getClass();
        s1.j jVar = this.f12615u;
        jVar.f11675u.removeCallbacks(jVar);
        try {
            SurfaceTexture surfaceTexture = jVar.f11680z;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, jVar.f11676v, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = jVar.f11677w;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = jVar.f11677w;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = jVar.f11679y;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(jVar.f11677w, jVar.f11679y);
            }
            EGLContext eGLContext = jVar.f11678x;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(jVar.f11677w, eGLContext);
            }
            EGL14.eglReleaseThread();
            EGLDisplay eGLDisplay3 = jVar.f11677w;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(jVar.f11677w);
            }
            jVar.f11677w = null;
            jVar.f11678x = null;
            jVar.f11679y = null;
            jVar.f11680z = null;
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
                } catch (Error e10) {
                    s1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e10);
                    this.f12617w = e10;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e11) {
                    s1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e11);
                    this.f12618x = e11;
                    synchronized (this) {
                        notify();
                    }
                } catch (s1.k e12) {
                    s1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e12);
                    this.f12618x = new IllegalStateException(e12);
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
                        s1.b.h("PlaceholderSurface", "Failed to release placeholder surface", th);
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
