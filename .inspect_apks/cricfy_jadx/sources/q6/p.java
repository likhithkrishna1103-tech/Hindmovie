package q6;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static v.l f10426b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f10425a = new LinearInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final nb.w f10427c = nb.w.I("t", "s", "e", "o", "i", "h", "to", "ti");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final nb.w f10428d = nb.w.I("x", "y");

    public static Interpolator a(PointF pointF, PointF pointF2) {
        WeakReference weakReference;
        Interpolator pathInterpolator;
        pointF.x = s6.g.b(pointF.x, -1.0f, 1.0f);
        pointF.y = s6.g.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = s6.g.b(pointF2.x, -1.0f, 1.0f);
        float fB = s6.g.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        float f = pointF.x;
        float f10 = pointF.y;
        float f11 = pointF2.x;
        Matrix matrix = s6.i.f11583a;
        int i = f != 0.0f ? (int) (527 * f) : 17;
        if (f10 != 0.0f) {
            i = (int) (i * 31 * f10);
        }
        if (f11 != 0.0f) {
            i = (int) (i * 31 * f11);
        }
        if (fB != 0.0f) {
            i = (int) (i * 31 * fB);
        }
        synchronized (p.class) {
            if (f10426b == null) {
                f10426b = new v.l();
            }
            weakReference = (WeakReference) f10426b.c(i);
        }
        Interpolator interpolator = weakReference != null ? (Interpolator) weakReference.get() : null;
        if (weakReference != null && interpolator != null) {
            return interpolator;
        }
        try {
            pathInterpolator = new PathInterpolator(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e9) {
            pathInterpolator = "The Path cannot loop back on itself.".equals(e9.getMessage()) ? new PathInterpolator(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
        }
        try {
            c(i, new WeakReference(pathInterpolator));
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return pathInterpolator;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static t6.a b(r6.a r25, g6.i r26, float r27, q6.e0 r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.p.b(r6.a, g6.i, float, q6.e0, boolean, boolean):t6.a");
    }

    public static void c(int i, WeakReference weakReference) {
        synchronized (p.class) {
            f10426b.d(i, weakReference);
        }
    }
}
