package v5;

import android.graphics.PointF;
import android.view.animation.BaseInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f13301a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final pb.c f13302b = pb.c.k("t", "s", "e", "o", "i", "h", "to", "ti");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final pb.c f13303c = pb.c.k("x", "y");

    public static BaseInterpolator a(PointF pointF, PointF pointF2) {
        pointF.x = x5.f.b(pointF.x, -1.0f, 1.0f);
        pointF.y = x5.f.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = x5.f.b(pointF2.x, -1.0f, 1.0f);
        float fB = x5.f.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        b8.j jVar = x5.g.f14267a;
        try {
            return new PathInterpolator(pointF.x, pointF.y, pointF2.x, fB);
        } catch (IllegalArgumentException e10) {
            return "The Path cannot loop back on itself.".equals(e10.getMessage()) ? new PathInterpolator(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y5.a b(w5.a r25, l5.j r26, float r27, v5.d0 r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.o.b(w5.a, l5.j, float, v5.d0, boolean, boolean):y5.a");
    }
}
