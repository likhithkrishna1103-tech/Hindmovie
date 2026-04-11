package y2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends Surface {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f14697y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f14698z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f14699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k f14700w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14701x;

    public l(k kVar, SurfaceTexture surfaceTexture, boolean z10) {
        super(surfaceTexture);
        this.f14700w = kVar;
        this.f14699v = z10;
    }

    public static int a(Context context) {
        try {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 24 && (i >= 26 || !("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) && (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) ? y1.b.l("EGL_EXT_protected_content") : false) {
                return y1.b.l("EGL_KHR_surfaceless_context") ? 1 : 2;
            }
            return 0;
        } catch (y1.k e9) {
            y1.b.g("PlaceholderSurface", "Failed to determine secure mode due to GL error: " + e9.getMessage());
            return 0;
        }
    }

    public static synchronized boolean b(Context context) {
        try {
            if (!f14698z) {
                f14697y = a(context);
                f14698z = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f14697y != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f14700w) {
            try {
                if (!this.f14701x) {
                    k kVar = this.f14700w;
                    kVar.f14693w.getClass();
                    kVar.f14693w.sendEmptyMessage(2);
                    this.f14701x = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
