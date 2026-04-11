package u2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends Surface {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f12620x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f12621y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f12622u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f12623v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12624w;

    public l(k kVar, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f12623v = kVar;
        this.f12622u = z2;
    }

    public static int a(Context context) {
        try {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 24 && (i >= 26 || !("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) && (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) ? s1.b.l("EGL_EXT_protected_content") : false) {
                return s1.b.l("EGL_KHR_surfaceless_context") ? 1 : 2;
            }
            return 0;
        } catch (s1.k e10) {
            s1.b.g("PlaceholderSurface", "Failed to determine secure mode due to GL error: " + e10.getMessage());
            return 0;
        }
    }

    public static synchronized boolean b(Context context) {
        try {
            if (!f12621y) {
                f12620x = a(context);
                f12621y = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f12620x != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f12623v) {
            try {
                if (!this.f12624w) {
                    k kVar = this.f12623v;
                    kVar.f12616v.getClass();
                    kVar.f12616v.sendEmptyMessage(2);
                    this.f12624w = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
