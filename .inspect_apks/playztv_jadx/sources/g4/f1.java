package g4;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends Binder implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f5005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ub.o f5006e;
    public final Set f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public aa.b1 f5007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5008h;

    public f1(b0 b0Var) {
        attachInterface(this, "androidx.media3.session.IMediaSession");
        this.f5005d = new WeakReference(b0Var);
        this.f5006e = new ub.o(b0Var);
        this.f = Collections.synchronizedSet(new HashSet());
        this.f5007g = aa.b1.C;
    }

    public static void L(b0 b0Var, s sVar, int i, q1 q1Var) {
        try {
            r rVar = sVar.f5202d;
            s1.d.h(rVar);
            rVar.i(i, q1Var);
            b0Var.f4958c.a(true, true);
        } catch (RemoteException e10) {
            s1.b.q("MediaSessionStub", "Failed to send result to controller " + sVar, e10);
        }
    }

    public static a2.f0 M(s1.h hVar) {
        return new a2.f0(19, new a2.f0(20, hVar));
    }

    public static ea.y f(b0 b0Var, s sVar, int i, e1 e1Var, s1.h hVar) {
        if (b0Var.j()) {
            return ea.v.f4633v;
        }
        ea.y yVar = (ea.y) e1Var.g(b0Var, sVar, i);
        ea.e0 e0Var = new ea.e0();
        yVar.f(new c2.w(b0Var, e0Var, hVar, yVar, 5), ea.r.f4628u);
        return e0Var;
    }

    public final void G(j jVar, int i) {
        if (jVar == null) {
            return;
        }
        J(jVar, i, 26, M(new b2.f(25)));
    }

    public final int H(s sVar, j1 j1Var, int i) {
        if (j1Var.e0(17)) {
            ub.o oVar = this.f5006e;
            if (!oVar.G(sVar, 17) && oVar.G(sVar, 16)) {
                return j1Var.d0() + i;
            }
        }
        return i;
    }

    public final void I(j jVar, int i, Bundle bundle) {
        f fVar;
        if (jVar == null || bundle == null) {
            return;
        }
        try {
            q1 q1VarA = q1.a(bundle);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                ub.o oVar = this.f5006e;
                IBinder iBinderAsBinder = jVar.asBinder();
                synchronized (oVar.f12868v) {
                    try {
                        s sVarX = oVar.x(iBinderAsBinder);
                        fVar = sVarX != null ? (f) ((s.e) oVar.f12870x).get(sVarX) : null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                l1 l1Var = fVar != null ? fVar.f4997b : null;
                if (l1Var == null) {
                    return;
                }
                l1Var.e(i, q1VarA);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e10) {
            s1.b.q("MediaSessionStub", "Ignoring malformed Bundle for SessionResult", e10);
        }
    }

    public final void J(j jVar, int i, int i10, e1 e1Var) {
        s sVarX = this.f5006e.x(jVar.asBinder());
        if (sVarX != null) {
            K(sVarX, i, i10, e1Var);
        }
    }

    public final void K(final s sVar, final int i, final int i10, final e1 e1Var) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final b0 b0Var = (b0) this.f5005d.get();
            if (b0Var != null && !b0Var.j()) {
                s1.b0.S(b0Var.f4965l, new Runnable() { // from class: g4.x0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ub.o oVar = this.f5246u.f5006e;
                        final s sVar2 = sVar;
                        int i11 = i10;
                        boolean zG = oVar.G(sVar2, i11);
                        final b0 b0Var2 = b0Var;
                        final int i12 = i;
                        if (!zG) {
                            f1.L(b0Var2, sVar2, i12, new q1(-4));
                            return;
                        }
                        q9.e eVar = b0Var2.f4960e;
                        b0Var2.s(sVar2);
                        eVar.getClass();
                        final e1 e1Var2 = e1Var;
                        if (i11 != 27) {
                            oVar.f(sVar2, i11, new e() { // from class: g4.a1
                                @Override // g4.e
                                public final ea.y run() {
                                    return (ea.y) e1Var2.g(b0Var2, sVar2, i12);
                                }
                            });
                        } else {
                            e1Var2.g(b0Var2, sVar2, i12);
                            oVar.f(sVar2, i11, new z0());
                        }
                    }
                });
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    public final void N(j jVar, int i, int i10) {
        if (jVar == null || i10 < 0) {
            return;
        }
        J(jVar, i, 25, M(new a2.c0(i10, 7)));
    }

    public final void O(j jVar, int i, Bundle bundle, boolean z2) {
        if (jVar == null || bundle == null) {
            return;
        }
        try {
            J(jVar, i, 31, new y0(new b2.b(new q0(p1.g0.a(bundle), z2, 0), 7, new s0(15)), 1));
        } catch (RuntimeException e10) {
            s1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    public final void P(j jVar, int i, Bundle bundle, long j5) {
        if (jVar == null || bundle == null) {
            return;
        }
        try {
            J(jVar, i, 31, new y0(new b2.b(new u0(p1.g0.a(bundle), j5), 7, new s0(15)), 1));
        } catch (RuntimeException e10) {
            s1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    public final void Q(j jVar, int i, IBinder iBinder, boolean z2) {
        if (jVar == null || iBinder == null) {
            return;
        }
        try {
            aa.j0 j0VarA = p1.f.a(iBinder);
            aa.g0 g0VarN = aa.j0.n();
            for (int i10 = 0; i10 < j0VarA.size(); i10++) {
                Bundle bundle = (Bundle) j0VarA.get(i10);
                bundle.getClass();
                g0VarN.a(p1.g0.a(bundle));
            }
            J(jVar, i, 20, new y0(new b2.b(new q0(g0VarN.g(), z2, 2), 7, new s0(15)), 1));
        } catch (RuntimeException e10) {
            s1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
        }
    }

    public final void R(j jVar, int i, IBinder iBinder, int i10, long j5) {
        if (jVar == null || iBinder == null) {
            return;
        }
        if (i10 == -1 || i10 >= 0) {
            try {
                aa.j0 j0VarA = p1.f.a(iBinder);
                aa.g0 g0VarN = aa.j0.n();
                for (int i11 = 0; i11 < j0VarA.size(); i11++) {
                    Bundle bundle = (Bundle) j0VarA.get(i11);
                    bundle.getClass();
                    g0VarN.a(p1.g0.a(bundle));
                }
                J(jVar, i, 20, new y0(new b2.b(new b2.c(i10, j5, g0VarN.g()), 7, new s0(15)), 1));
            } catch (RuntimeException e10) {
                s1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e10);
            }
        }
    }

    public final void S(j jVar, int i, float f) {
        if (jVar == null || f < 0.0f || f > 1.0f) {
            return;
        }
        J(jVar, i, 24, M(new a2.a0(2, f)));
    }

    public final void c(j jVar, final int i, final m1 m1Var, final int i10, final e1 e1Var) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final b0 b0Var = (b0) this.f5005d.get();
            if (b0Var != null && !b0Var.j()) {
                final s sVarX = this.f5006e.x(jVar.asBinder());
                if (sVarX == null) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                } else {
                    s1.b0.S(b0Var.f4965l, new Runnable() { // from class: g4.w0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ub.o oVar = this.f5238u.f5006e;
                            s sVar = sVarX;
                            if (oVar.F(sVar)) {
                                m1 m1Var2 = m1Var;
                                b0 b0Var2 = b0Var;
                                int i11 = i;
                                if (m1Var2 != null) {
                                    if (!oVar.I(sVar, m1Var2)) {
                                        f1.L(b0Var2, sVar, i11, new q1(-4));
                                        return;
                                    }
                                } else if (!oVar.H(sVar, i10)) {
                                    f1.L(b0Var2, sVar, i11, new q1(-4));
                                    return;
                                }
                                e1Var.g(b0Var2, sVar, i11);
                            }
                        }
                    });
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    public final h1 e(h1 h1Var) {
        aa.j0 j0Var = h1Var.D.f9952a;
        aa.g0 g0VarN = aa.j0.n();
        aa.a0 a0Var = new aa.a0(4);
        for (int i = 0; i < j0Var.size(); i++) {
            p1.m1 m1Var = (p1.m1) j0Var.get(i);
            p1.g1 g1Var = m1Var.f9944b;
            String string = (String) this.f5007g.get(g1Var);
            if (string == null) {
                StringBuilder sb2 = new StringBuilder();
                int i10 = this.f5008h;
                this.f5008h = i10 + 1;
                int i11 = s1.b0.f11647a;
                sb2.append(Integer.toString(i10, 36));
                sb2.append("-");
                sb2.append(g1Var.f9763b);
                string = sb2.toString();
            }
            a0Var.A(g1Var, string);
            g0VarN.a(new p1.m1(new p1.g1(string, m1Var.f9944b.f9765d), m1Var.f9945c, m1Var.f9946d, m1Var.f9947e));
        }
        this.f5007g = a0Var.d();
        h1 h1VarA = h1Var.a(new p1.n1(g0VarN.g()));
        p1.l1 l1Var = h1VarA.E;
        if (l1Var.D.isEmpty()) {
            return h1VarA;
        }
        p1.k1 k1VarC = l1Var.a().c();
        aa.q1 it = l1Var.D.values().iterator();
        while (it.hasNext()) {
            p1.h1 h1Var2 = (p1.h1) it.next();
            p1.g1 g1Var2 = h1Var2.f9783a;
            String str = (String) this.f5007g.get(g1Var2);
            if (str != null) {
                k1VarC.a(new p1.h1(new p1.g1(str, g1Var2.f9765d), h1Var2.f9784b));
            } else {
                k1VarC.a(h1Var2);
            }
        }
        return h1VarA.d(k1VarC.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    @Override // android.os.Binder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTransact(int r21, android.os.Parcel r22, android.os.Parcel r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.f1.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
