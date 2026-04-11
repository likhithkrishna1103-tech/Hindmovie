package u2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f12675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f12676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f12677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Surface f12679e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12681h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f12683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f12684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f12686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f12687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f12688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f12689q;

    public z(Context context) {
        DisplayManager displayManager;
        e eVar = new e();
        eVar.f12572a = new d();
        eVar.f12573b = new d();
        eVar.f12575d = -9223372036854775807L;
        this.f12675a = eVar;
        x xVar = (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : new x(this, displayManager);
        this.f12676b = xVar;
        this.f12677c = xVar != null ? y.f12670y : null;
        this.f12683k = -9223372036854775807L;
        this.f12684l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.f12682j = 0;
    }

    public static void a(z zVar, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zVar.f12683k = refreshRate;
            zVar.f12684l = (refreshRate * 80) / 100;
        } else {
            s1.b.p("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            zVar.f12683k = -9223372036854775807L;
            zVar.f12684l = -9223372036854775807L;
        }
    }

    public final void b() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.f12679e) == null || this.f12682j == Integer.MIN_VALUE || this.f12681h == 0.0f) {
            return;
        }
        this.f12681h = 0.0f;
        try {
            surface.setFrameRate(0.0f, 0);
        } catch (IllegalStateException e10) {
            s1.b.h("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L8d
            android.view.Surface r0 = r9.f12679e
            if (r0 != 0) goto Lc
            goto L8d
        Lc:
            u2.e r0 = r9.f12675a
            u2.d r2 = r0.f12572a
            boolean r2 = r2.a()
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == 0) goto L39
            u2.d r2 = r0.f12572a
            boolean r2 = r2.a()
            if (r2 == 0) goto L37
            u2.d r2 = r0.f12572a
            long r4 = r2.f12568e
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L2b
            goto L2e
        L2b:
            long r6 = r2.f
            long r6 = r6 / r4
        L2e:
            double r4 = (double) r6
            r6 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r6 = r6 / r4
            float r2 = (float) r6
            goto L3b
        L37:
            r2 = r3
            goto L3b
        L39:
            float r2 = r9.f
        L3b:
            float r4 = r9.f12680g
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 != 0) goto L42
            goto L8d
        L42:
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 == 0) goto L80
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 == 0) goto L80
            u2.d r1 = r0.f12572a
            boolean r1 = r1.a()
            if (r1 == 0) goto L71
            u2.d r1 = r0.f12572a
            boolean r1 = r1.a()
            if (r1 == 0) goto L5f
            u2.d r0 = r0.f12572a
            long r0 = r0.f
            goto L64
        L5f:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L64:
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L71
            r0 = 1017370378(0x3ca3d70a, float:0.02)
            goto L73
        L71:
            r0 = 1065353216(0x3f800000, float:1.0)
        L73:
            float r1 = r9.f12680g
            float r1 = r2 - r1
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L8d
            goto L87
        L80:
            if (r5 == 0) goto L83
            goto L87
        L83:
            int r0 = r0.f12576e
            if (r0 < r1) goto L8d
        L87:
            r9.f12680g = r2
            r0 = 0
            r9.d(r0)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.z.c():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L41
            android.view.Surface r0 = r4.f12679e
            if (r0 == 0) goto L41
            int r1 = r4.f12682j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L41
        L11:
            boolean r1 = r4.f12678d
            r2 = 0
            if (r1 == 0) goto L22
            float r1 = r4.f12680g
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L22
            float r3 = r4.i
            float r1 = r1 * r3
            goto L23
        L22:
            r1 = r2
        L23:
            if (r5 != 0) goto L2c
            float r5 = r4.f12681h
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2c
            goto L41
        L2c:
            r4.f12681h = r1
            int r5 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r5 != 0) goto L34
            r5 = 0
            goto L35
        L34:
            r5 = 1
        L35:
            ta.w.b(r0, r1, r5)     // Catch: java.lang.IllegalStateException -> L39
            return
        L39:
            r5 = move-exception
            java.lang.String r0 = "VideoFrameReleaseHelper"
            java.lang.String r1 = "Failed to call Surface.setFrameRate"
            s1.b.h(r0, r1, r5)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.z.d(boolean):void");
    }
}
