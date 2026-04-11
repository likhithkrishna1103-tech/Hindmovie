package f9;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r1 implements c2 {
    public static volatile r1 Z;
    public final w0 A;
    public final p1 B;
    public final b4 C;
    public final u4 D;
    public final q0 E;
    public final s8.a F;
    public final j3 G;
    public final x2 H;
    public final y I;
    public final b3 J;
    public final String K;
    public p0 L;
    public t3 M;
    public q N;
    public n0 O;
    public c3 P;
    public Boolean R;
    public long S;
    public volatile Boolean T;
    public volatile boolean U;
    public int V;
    public int W;
    public final long Y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f4363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f4364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final jb.b f4365x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f4366y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f1 f4367z;
    public boolean Q = false;
    public final AtomicInteger X = new AtomicInteger(0);

    public r1(j2 j2Var) {
        Context context = j2Var.f4236a;
        jb.b bVar = new jb.b(11);
        this.f4365x = bVar;
        h2.f4212k = bVar;
        this.f4363v = context;
        this.f4364w = j2Var.f4240e;
        this.T = j2Var.f4237b;
        this.K = j2Var.f4241g;
        this.U = true;
        if (com.google.android.gms.internal.measurement.n4.f2544h == null && context != null) {
            Object obj = com.google.android.gms.internal.measurement.n4.f2543g;
            synchronized (obj) {
                try {
                    if (com.google.android.gms.internal.measurement.n4.f2544h == null) {
                        synchronized (obj) {
                            com.google.android.gms.internal.measurement.d4 d4Var = com.google.android.gms.internal.measurement.n4.f2544h;
                            final Context applicationContext = context.getApplicationContext();
                            if (applicationContext == null) {
                                applicationContext = context;
                            }
                            if (d4Var == null || d4Var.f2363a != applicationContext) {
                                if (d4Var != null) {
                                    com.google.android.gms.internal.measurement.f4.c();
                                    com.google.android.gms.internal.measurement.r4.a();
                                    com.google.android.gms.internal.measurement.i4.e();
                                }
                                com.google.android.gms.internal.measurement.n4.f2544h = new com.google.android.gms.internal.measurement.d4(applicationContext, com.bumptech.glide.f.E(new ta.l() { // from class: com.google.android.gms.internal.measurement.q4
                                    /* JADX WARN: Finally extract failed */
                                    /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[Catch: all -> 0x0028, TryCatch #2 {all -> 0x0028, all -> 0x0076, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x001f, B:20:0x003c, B:78:0x018b, B:15:0x002b, B:17:0x0033, B:21:0x0041, B:23:0x0047, B:25:0x004d, B:26:0x0051, B:77:0x0188, B:79:0x018e, B:80:0x0191, B:81:0x0192, B:27:0x0056, B:29:0x005a, B:30:0x0067, B:32:0x006d, B:38:0x0083, B:40:0x0089, B:41:0x0095, B:64:0x016c, B:65:0x016f, B:73:0x017f, B:72:0x017c, B:74:0x0180, B:75:0x0185, B:76:0x0186, B:33:0x0073, B:37:0x007a), top: B:88:0x000d }] */
                                    @Override // ta.l
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                        To view partially-correct add '--show-bad-code' argument
                                    */
                                    public final java.lang.Object get() {
                                        /*
                                            Method dump skipped, instruction units count: 407
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.q4.get():java.lang.Object");
                                    }
                                }));
                                com.google.android.gms.internal.measurement.n4.i.incrementAndGet();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
        this.F = s8.a.f11610a;
        Long l10 = j2Var.f;
        this.Y = l10 != null ? l10.longValue() : System.currentTimeMillis();
        g gVar = new g(this);
        gVar.f4185z = ka.f.f7307w;
        this.f4366y = gVar;
        f1 f1Var = new f1(this);
        f1Var.p1();
        this.f4367z = f1Var;
        w0 w0Var = new w0(this);
        w0Var.p1();
        this.A = w0Var;
        u4 u4Var = new u4(this);
        u4Var.p1();
        this.D = u4Var;
        this.E = new q0(new p6.c(j2Var, this));
        this.I = new y(this);
        j3 j3Var = new j3(this);
        j3Var.o1();
        this.G = j3Var;
        x2 x2Var = new x2(this);
        x2Var.o1();
        this.H = x2Var;
        b4 b4Var = new b4(this);
        b4Var.o1();
        this.C = b4Var;
        b3 b3Var = new b3(this);
        b3Var.p1();
        this.J = b3Var;
        p1 p1Var = new p1(this);
        p1Var.p1();
        this.B = p1Var;
        com.google.android.gms.internal.measurement.t0 t0Var = j2Var.f4239d;
        boolean z10 = t0Var == null || t0Var.f2632w == 0;
        if (context.getApplicationContext() instanceof Application) {
            f(x2Var);
            if (((r1) x2Var.f307w).f4363v.getApplicationContext() instanceof Application) {
                Application application = (Application) ((r1) x2Var.f307w).f4363v.getApplicationContext();
                if (x2Var.f4479y == null) {
                    x2Var.f4479y = new t2(x2Var);
                }
                if (z10) {
                    application.unregisterActivityLifecycleCallbacks(x2Var.f4479y);
                    application.registerActivityLifecycleCallbacks(x2Var.f4479y);
                    w0 w0Var2 = ((r1) x2Var.f307w).A;
                    g(w0Var2);
                    w0Var2.J.a("Registered activity lifecycle callback");
                }
            }
        } else {
            g(w0Var);
            w0Var.E.a("Application context is not an Application");
        }
        p1Var.v1(new ya.s(5, this, j2Var, false));
    }

    public static final void d(d0 d0Var) {
        if (d0Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void e(a7.a aVar) {
        if (aVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void f(h0 h0Var) {
        if (h0Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!h0Var.f4202x) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(h0Var.getClass())));
        }
    }

    public static final void g(b2 b2Var) {
        if (b2Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!b2Var.f4048x) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(b2Var.getClass())));
        }
    }

    public static r1 m(Context context, com.google.android.gms.internal.measurement.t0 t0Var, Long l10) {
        Bundle bundle;
        if (t0Var != null) {
            Bundle bundle2 = t0Var.f2634y;
            t0Var = new com.google.android.gms.internal.measurement.t0(t0Var.f2631v, t0Var.f2632w, t0Var.f2633x, bundle2, null);
        }
        o8.u.g(context);
        o8.u.g(context.getApplicationContext());
        if (Z == null) {
            synchronized (r1.class) {
                try {
                    if (Z == null) {
                        Z = new r1(new j2(context, t0Var, l10));
                    }
                } finally {
                }
            }
        } else if (t0Var != null && (bundle = t0Var.f2634y) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            o8.u.g(Z);
            Z.T = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        o8.u.g(Z);
        return Z;
    }

    @Override // f9.c2
    public final s8.a A0() {
        return this.F;
    }

    @Override // f9.c2
    public final w0 C() {
        w0 w0Var = this.A;
        g(w0Var);
        return w0Var;
    }

    @Override // f9.c2
    public final jb.b S0() {
        return this.f4365x;
    }

    public final boolean a() {
        return b() == 0;
    }

    @Override // f9.c2
    public final p1 a0() {
        p1 p1Var = this.B;
        g(p1Var);
        return p1Var;
    }

    public final int b() {
        p1 p1Var = this.B;
        g(p1Var);
        p1Var.m1();
        g gVar = this.f4366y;
        if (gVar.z1()) {
            return 1;
        }
        g(p1Var);
        p1Var.m1();
        if (!this.U) {
            return 8;
        }
        f1 f1Var = this.f4367z;
        e(f1Var);
        f1Var.m1();
        Boolean boolValueOf = f1Var.q1().contains("measurement_enabled") ? Boolean.valueOf(f1Var.q1().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        jb.b bVar = ((r1) gVar.f307w).f4365x;
        Boolean boolY1 = gVar.y1("firebase_analytics_collection_enabled");
        return boolY1 != null ? boolY1.booleanValue() ? 0 : 4 : (this.T == null || this.T.booleanValue()) ? 0 : 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r6 = this;
            boolean r0 = r6.Q
            if (r0 == 0) goto L96
            f9.p1 r0 = r6.B
            g(r0)
            r0.m1()
            java.lang.Boolean r0 = r6.R
            s8.a r1 = r6.F
            if (r0 == 0) goto L34
            long r2 = r6.S
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L34
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L8f
            r1.getClass()
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.S
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L8f
        L34:
            r1.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            r6.S = r0
            f9.u4 r0 = r6.D
            e(r0)
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = r0.K1(r1)
            r2 = 0
            if (r1 == 0) goto L75
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r0.K1(r1)
            if (r1 == 0) goto L75
            android.content.Context r1 = r6.f4363v
            b7.e r3 = u8.b.a(r1)
            boolean r3 = r3.c()
            r4 = 1
            if (r3 != 0) goto L74
            f9.g r3 = r6.f4366y
            boolean r3 = r3.p1()
            if (r3 != 0) goto L74
            boolean r3 = f9.u4.d2(r1)
            if (r3 == 0) goto L75
            boolean r1 = f9.u4.F1(r1)
            if (r1 == 0) goto L75
        L74:
            r2 = r4
        L75:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r6.R = r1
            if (r2 == 0) goto L8f
            f9.n0 r1 = r6.l()
            java.lang.String r1 = r1.t1()
            boolean r0 = r0.q1(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.R = r0
        L8f:
            java.lang.Boolean r0 = r6.R
            boolean r0 = r0.booleanValue()
            return r0
        L96:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "AppMeasurement is not initialized"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.r1.c():boolean");
    }

    @Override // f9.c2
    public final Context f0() {
        return this.f4363v;
    }

    public final q0 h() {
        return this.E;
    }

    public final p0 i() {
        f(this.L);
        return this.L;
    }

    public final t3 j() {
        f(this.M);
        return this.M;
    }

    public final q k() {
        g(this.N);
        return this.N;
    }

    public final n0 l() {
        f(this.O);
        return this.O;
    }
}
