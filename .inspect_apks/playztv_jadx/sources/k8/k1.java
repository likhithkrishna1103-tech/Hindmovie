package k8;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.r4;
import com.google.android.gms.internal.measurement.s4;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements w1 {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static volatile k1 f7279c0;
    public final e A;
    public final z0 B;
    public final p0 C;
    public final h1 D;
    public final k3 E;
    public final h4 F;
    public final l0 G;
    public final x7.a H;
    public final v2 I;
    public final g2 J;
    public final q K;
    public final t2 L;
    public final String M;
    public j0 N;
    public z2 O;
    public p P;
    public k0 Q;
    public Boolean S;
    public long T;
    public volatile Boolean U;
    public final Boolean V;
    public final Boolean W;
    public volatile boolean X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final long f7281b0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f7282u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7283v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f7284w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f7285x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f7286y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final q9.e f7287z;
    public boolean R = false;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final AtomicInteger f7280a0 = new AtomicInteger(0);

    public k1(e2 e2Var) {
        Bundle bundle;
        boolean z2 = false;
        Context context = e2Var.f7149a;
        q9.e eVar = new q9.e(15);
        this.f7287z = eVar;
        c2.f7118k = eVar;
        this.f7282u = context;
        this.f7283v = e2Var.f7150b;
        this.f7284w = e2Var.f7151c;
        this.f7285x = e2Var.f7152d;
        this.f7286y = e2Var.f7155h;
        this.U = e2Var.f7153e;
        this.M = e2Var.f7156j;
        this.X = true;
        com.google.android.gms.internal.measurement.d1 d1Var = e2Var.f7154g;
        if (d1Var != null && (bundle = d1Var.A) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.V = (Boolean) obj;
            }
            Object obj2 = d1Var.A.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.W = (Boolean) obj2;
            }
        }
        if (r4.f3173h == null && context != null) {
            Object obj3 = r4.f3172g;
            synchronized (obj3) {
                try {
                    if (r4.f3173h == null) {
                        synchronized (obj3) {
                            com.google.android.gms.internal.measurement.h4 h4Var = r4.f3173h;
                            Context applicationContext = context.getApplicationContext();
                            applicationContext = applicationContext == null ? context : applicationContext;
                            if (h4Var == null || h4Var.f3035a != applicationContext) {
                                if (h4Var != null) {
                                    com.google.android.gms.internal.measurement.g4.c();
                                    s4.b();
                                    com.google.android.gms.internal.measurement.k4.D();
                                }
                                p4 p4Var = new p4();
                                p4Var.f3149u = applicationContext;
                                r4.f3173h = new com.google.android.gms.internal.measurement.h4(applicationContext, z7.a.t(p4Var));
                                r4.i.incrementAndGet();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
        this.H = x7.a.f14294a;
        Long l10 = e2Var.i;
        this.f7281b0 = l10 != null ? l10.longValue() : System.currentTimeMillis();
        e eVar2 = new e(this);
        eVar2.f7146y = new t7.j(15);
        this.A = eVar2;
        z0 z0Var = new z0(this);
        z0Var.r1();
        this.B = z0Var;
        p0 p0Var = new p0(this);
        p0Var.r1();
        this.C = p0Var;
        h4 h4Var2 = new h4(this);
        h4Var2.r1();
        this.F = h4Var2;
        this.G = new l0(new a1(this, 1));
        this.K = new q(this);
        v2 v2Var = new v2(this);
        v2Var.u1();
        this.I = v2Var;
        g2 g2Var = new g2(this);
        g2Var.u1();
        this.J = g2Var;
        k3 k3Var = new k3(this);
        k3Var.u1();
        this.E = k3Var;
        t2 t2Var = new t2(this);
        t2Var.r1();
        this.L = t2Var;
        h1 h1Var = new h1(this);
        h1Var.r1();
        this.D = h1Var;
        com.google.android.gms.internal.measurement.d1 d1Var2 = e2Var.f7154g;
        if (d1Var2 != null && d1Var2.f2928v != 0) {
            z2 = true;
        }
        if (context.getApplicationContext() instanceof Application) {
            e(g2Var);
            k1 k1Var = (k1) g2Var.f2454v;
            if (k1Var.f7282u.getApplicationContext() instanceof Application) {
                Application application = (Application) k1Var.f7282u.getApplicationContext();
                if (g2Var.f7212x == null) {
                    g2Var.f7212x = new q2(g2Var);
                }
                if (!z2) {
                    application.unregisterActivityLifecycleCallbacks(g2Var.f7212x);
                    application.registerActivityLifecycleCallbacks(g2Var.f7212x);
                    g2Var.g().I.d("Registered activity lifecycle callback");
                }
            }
        } else {
            f(p0Var);
            p0Var.D.d("Application context is not an Application");
        }
        h1Var.y1(new ea.t(9, this, e2Var, false));
    }

    public static k1 c(Context context, com.google.android.gms.internal.measurement.d1 d1Var, Long l10) {
        Bundle bundle;
        if (d1Var != null && (d1Var.f2931y == null || d1Var.f2932z == null)) {
            d1Var = new com.google.android.gms.internal.measurement.d1(d1Var.f2927u, d1Var.f2928v, d1Var.f2929w, d1Var.f2930x, null, null, d1Var.A, null);
        }
        t7.v.h(context);
        t7.v.h(context.getApplicationContext());
        if (f7279c0 == null) {
            synchronized (k1.class) {
                try {
                    if (f7279c0 == null) {
                        f7279c0 = new k1(new e2(context, d1Var, l10));
                    }
                } finally {
                }
            }
        } else if (d1Var != null && (bundle = d1Var.A) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            t7.v.h(f7279c0);
            f7279c0.U = Boolean.valueOf(d1Var.A.getBoolean("dataCollectionDefaultEnabled"));
        }
        t7.v.h(f7279c0);
        return f7279c0;
    }

    public static void d(c3.e eVar) {
        if (eVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static void e(y0 y0Var) {
        if (y0Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!y0Var.f7553w) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(y0Var.getClass())));
        }
    }

    public static void f(x1 x1Var) {
        if (x1Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!x1Var.f7539w) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(x1Var.getClass())));
        }
    }

    @Override // k8.w1
    public final Context a() {
        return this.f7282u;
    }

    @Override // k8.w1
    public final q9.e b() {
        return this.f7287z;
    }

    @Override // k8.w1
    public final p0 g() {
        p0 p0Var = this.C;
        f(p0Var);
        return p0Var;
    }

    public final boolean h() {
        return j() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i() {
        /*
            r6 = this;
            boolean r0 = r6.R
            if (r0 == 0) goto Lb4
            k8.h1 r0 = r6.D
            f(r0)
            r0.p1()
            java.lang.Boolean r0 = r6.S
            x7.a r1 = r6.H
            if (r0 == 0) goto L34
            long r2 = r6.T
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L34
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto Lad
            r1.getClass()
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.T
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto Lad
        L34:
            r1.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            r6.T = r0
            k8.h4 r0 = r6.F
            d(r0)
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = r0.r2(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L76
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r0.r2(r1)
            if (r1 == 0) goto L76
            android.content.Context r1 = r6.f7282u
            wc.b r4 = z7.b.a(r1)
            boolean r4 = r4.e()
            if (r4 != 0) goto L74
            k8.e r4 = r6.A
            boolean r4 = r4.D1()
            if (r4 != 0) goto L74
            boolean r4 = k8.h4.W1(r1)
            if (r4 == 0) goto L76
            boolean r1 = k8.h4.h2(r1)
            if (r1 == 0) goto L76
        L74:
            r1 = r2
            goto L77
        L76:
            r1 = r3
        L77:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            r6.S = r4
            if (r1 == 0) goto Lad
            k8.k0 r1 = r6.m()
            java.lang.String r1 = r1.x1()
            k8.k0 r4 = r6.m()
            r4.t1()
            java.lang.String r4 = r4.H
            boolean r0 = r0.a2(r1, r4)
            if (r0 != 0) goto La7
            k8.k0 r0 = r6.m()
            r0.t1()
            java.lang.String r0 = r0.H
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La6
            goto La7
        La6:
            r2 = r3
        La7:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r6.S = r0
        Lad:
            java.lang.Boolean r0 = r6.S
            boolean r0 = r0.booleanValue()
            return r0
        Lb4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "AppMeasurement is not initialized"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.k1.i():boolean");
    }

    public final int j() {
        h1 h1Var = this.D;
        f(h1Var);
        h1Var.p1();
        Boolean boolY1 = this.A.y1("firebase_analytics_collection_deactivated");
        if (boolY1 != null && boolY1.booleanValue()) {
            return 1;
        }
        Boolean bool = this.W;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        h1 h1Var2 = this.D;
        f(h1Var2);
        h1Var2.p1();
        if (!this.X) {
            return 8;
        }
        z0 z0Var = this.B;
        d(z0Var);
        z0Var.p1();
        Boolean boolValueOf = z0Var.x1().contains("measurement_enabled") ? Boolean.valueOf(z0Var.x1().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        Boolean boolY12 = this.A.y1("firebase_analytics_collection_enabled");
        if (boolY12 != null) {
            return boolY12.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.V;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.U == null || this.U.booleanValue()) ? 0 : 7;
    }

    public final q k() {
        q qVar = this.K;
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final p l() {
        f(this.P);
        return this.P;
    }

    public final k0 m() {
        e(this.Q);
        return this.Q;
    }

    public final j0 n() {
        e(this.N);
        return this.N;
    }

    public final l0 o() {
        return this.G;
    }

    public final z2 p() {
        e(this.O);
        return this.O;
    }

    public final void q() {
        d(this.F);
    }

    @Override // k8.w1
    public final h1 x() {
        h1 h1Var = this.D;
        f(h1Var);
        return h1Var;
    }

    @Override // k8.w1
    public final x7.a y0() {
        return this.H;
    }
}
