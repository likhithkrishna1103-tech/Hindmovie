package k4;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends Binder implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f6943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b6.f f6944e;
    public final Set f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ua.y0 f6945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6946h;

    public d1(b0 b0Var) {
        attachInterface(this, "androidx.media3.session.IMediaSession");
        this.f6943d = new WeakReference(b0Var);
        this.f6944e = new b6.f(b0Var);
        this.f = Collections.synchronizedSet(new HashSet());
        this.f6945g = ua.y0.D;
    }

    public static ya.w L(b0 b0Var, s sVar, int i, c1 c1Var, y1.h hVar) {
        if (b0Var.j()) {
            return ya.u.f15014w;
        }
        ya.w wVar = (ya.w) c1Var.i(b0Var, sVar, i);
        ya.c0 c0Var = new ya.c0();
        wVar.h(new c8.a(b0Var, c0Var, hVar, wVar, 6), ya.q.f15009v);
        return c0Var;
    }

    public static void R(b0 b0Var, s sVar, int i, o1 o1Var) {
        try {
            r rVar = sVar.f7160d;
            y1.d.h(rVar);
            rVar.j(i, o1Var);
            b0Var.f6909c.a(true, true);
        } catch (RemoteException e9) {
            y1.b.q("MediaSessionStub", "Failed to send result to controller " + sVar, e9);
        }
    }

    public static androidx.fragment.app.f1 S(y1.h hVar) {
        return new androidx.fragment.app.f1(27, new androidx.fragment.app.f1(28, hVar));
    }

    public final void M(j jVar, int i) {
        if (jVar == null) {
            return;
        }
        P(jVar, i, 26, S(new h2.e(24)));
    }

    public final int N(s sVar, h1 h1Var, int i) {
        if (h1Var.Z(17)) {
            b6.f fVar = this.f6944e;
            if (!fVar.m(sVar, 17) && fVar.m(sVar, 16)) {
                return h1Var.Y() + i;
            }
        }
        return i;
    }

    public final void O(j jVar, int i, Bundle bundle) {
        f fVar;
        if (jVar == null || bundle == null) {
            return;
        }
        try {
            o1 o1VarA = o1.a(bundle);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                b6.f fVar2 = this.f6944e;
                IBinder iBinder = ((i) jVar).f7039d;
                synchronized (fVar2.f1800w) {
                    try {
                        s sVarH = fVar2.h(iBinder);
                        fVar = sVarH != null ? (f) ((v.e) fVar2.f1802y).get(sVarH) : null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                j1 j1Var = fVar != null ? fVar.f6952b : null;
                if (j1Var == null) {
                    return;
                }
                j1Var.e(i, o1VarA);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e9) {
            y1.b.q("MediaSessionStub", "Ignoring malformed Bundle for SessionResult", e9);
        }
    }

    public final void P(j jVar, int i, int i10, c1 c1Var) {
        s sVarH = this.f6944e.h(((i) jVar).f7039d);
        if (sVarH != null) {
            Q(sVarH, i, i10, c1Var);
        }
    }

    public final void Q(final s sVar, final int i, final int i10, final c1 c1Var) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final b0 b0Var = (b0) this.f6943d.get();
            if (b0Var != null && !b0Var.j()) {
                y1.a0.S(b0Var.f6916l, new Runnable() { // from class: k4.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        b6.f fVar = this.f7178v.f6944e;
                        final s sVar2 = sVar;
                        int i11 = i10;
                        boolean zM = fVar.m(sVar2, i11);
                        final b0 b0Var2 = b0Var;
                        final int i12 = i;
                        if (!zM) {
                            d1.R(b0Var2, sVar2, i12, new o1(-4));
                            return;
                        }
                        f9.b0 b0Var3 = b0Var2.f6911e;
                        b0Var2.s(sVar2);
                        b0Var3.getClass();
                        final c1 c1Var2 = c1Var;
                        if (i11 != 27) {
                            fVar.b(sVar2, i11, new e() { // from class: k4.y0
                                @Override // k4.e
                                public final ya.w run() {
                                    return (ya.w) c1Var2.i(b0Var2, sVar2, i12);
                                }
                            });
                        } else {
                            c1Var2.i(b0Var2, sVar2, i12);
                            fVar.b(sVar2, i11, new x0());
                        }
                    }
                });
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    public final void T(j jVar, int i, boolean z10) {
        if (jVar == null) {
            return;
        }
        P(jVar, i, 26, S(new g2.y(3, z10)));
    }

    public final void U(j jVar, int i, int i10) {
        if (jVar == null || i10 < 0) {
            return;
        }
        P(jVar, i, 25, S(new g2.x(i10, 7)));
    }

    public final void V(j jVar, int i, Bundle bundle, boolean z10) {
        if (jVar == null || bundle == null) {
            return;
        }
        try {
            P(jVar, i, 31, new w0(new androidx.fragment.app.e(12, new p0(v1.g0.a(bundle), z10, 0), new r0(14)), 1));
        } catch (RuntimeException e9) {
            y1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e9);
        }
    }

    public final void W(j jVar, int i, Bundle bundle, long j4) {
        if (jVar == null || bundle == null) {
            return;
        }
        try {
            P(jVar, i, 31, new w0(new androidx.fragment.app.e(12, new e8.f(v1.g0.a(bundle), j4), new r0(14)), 1));
        } catch (RuntimeException e9) {
            y1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e9);
        }
    }

    public final void X(j jVar, int i, IBinder iBinder, boolean z10) {
        if (jVar == null || iBinder == null) {
            return;
        }
        try {
            ua.i0 i0VarA = v1.e.a(iBinder);
            ua.f0 f0VarJ = ua.i0.j();
            for (int i10 = 0; i10 < i0VarA.size(); i10++) {
                Bundle bundle = (Bundle) i0VarA.get(i10);
                bundle.getClass();
                f0VarJ.a(v1.g0.a(bundle));
            }
            P(jVar, i, 20, new w0(new androidx.fragment.app.e(12, new p0(f0VarJ.g(), z10, 2), new r0(14)), 1));
        } catch (RuntimeException e9) {
            y1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e9);
        }
    }

    public final void Y(j jVar, int i, IBinder iBinder, int i10, long j4) {
        if (jVar == null || iBinder == null) {
            return;
        }
        if (i10 == -1 || i10 >= 0) {
            try {
                ua.i0 i0VarA = v1.e.a(iBinder);
                ua.f0 f0VarJ = ua.i0.j();
                for (int i11 = 0; i11 < i0VarA.size(); i11++) {
                    Bundle bundle = (Bundle) i0VarA.get(i11);
                    bundle.getClass();
                    f0VarJ.a(v1.g0.a(bundle));
                }
                P(jVar, i, 20, new w0(new androidx.fragment.app.e(12, new h2.c(j4, f0VarJ.g(), i10), new r0(14)), 1));
            } catch (RuntimeException e9) {
                y1.b.q("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", e9);
            }
        }
    }

    public final void Z(j jVar, int i, float f) {
        if (jVar == null || f < 0.0f || f > 1.0f) {
            return;
        }
        P(jVar, i, 24, S(new g2.v(2, f)));
    }

    public final void b(j jVar, int i) {
        if (jVar == null) {
            return;
        }
        P(jVar, i, 26, S(new r0(4)));
    }

    public final void e(j jVar, final int i, final k1 k1Var, final int i10, final c1 c1Var) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final b0 b0Var = (b0) this.f6943d.get();
            if (b0Var != null && !b0Var.j()) {
                final s sVarH = this.f6944e.h(((i) jVar).f7039d);
                if (sVarH == null) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                } else {
                    y1.a0.S(b0Var.f6916l, new Runnable() { // from class: k4.u0
                        @Override // java.lang.Runnable
                        public final void run() {
                            b6.f fVar = this.f7171v.f6944e;
                            s sVar = sVarH;
                            if (fVar.l(sVar)) {
                                k1 k1Var2 = k1Var;
                                b0 b0Var2 = b0Var;
                                int i11 = i;
                                if (k1Var2 != null) {
                                    if (!fVar.o(sVar, k1Var2)) {
                                        d1.R(b0Var2, sVar, i11, new o1(-4));
                                        return;
                                    }
                                } else if (!fVar.n(sVar, i10)) {
                                    d1.R(b0Var2, sVar, i11, new o1(-4));
                                    return;
                                }
                                c1Var.i(b0Var2, sVar, i11);
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

    public final f1 f(f1 f1Var) {
        ua.i0 i0Var = f1Var.D.f12882a;
        ua.f0 f0VarJ = ua.i0.j();
        ua.a0 a0Var = new ua.a0(4);
        for (int i = 0; i < i0Var.size(); i++) {
            v1.m1 m1Var = (v1.m1) i0Var.get(i);
            v1.g1 g1Var = m1Var.f12873b;
            String string = (String) this.f6945g.get(g1Var);
            if (string == null) {
                StringBuilder sb = new StringBuilder();
                int i10 = this.f6946h;
                this.f6946h = i10 + 1;
                int i11 = y1.a0.f14551a;
                sb.append(Integer.toString(i10, 36));
                sb.append("-");
                sb.append(g1Var.f12703b);
                string = sb.toString();
            }
            a0Var.B(g1Var, string);
            f0VarJ.a(new v1.m1(new v1.g1(string, m1Var.f12873b.f12705d), m1Var.f12874c, m1Var.f12875d, m1Var.f12876e));
        }
        this.f6945g = a0Var.c();
        f1 f1VarA = f1Var.a(new v1.n1(f0VarJ.g()));
        v1.l1 l1Var = f1VarA.E;
        if (l1Var.D.isEmpty()) {
            return f1VarA;
        }
        v1.k1 k1VarC = l1Var.a().c();
        ua.n1 it = l1Var.D.values().iterator();
        while (it.hasNext()) {
            v1.h1 h1Var = (v1.h1) it.next();
            v1.g1 g1Var2 = h1Var.f12711a;
            String str = (String) this.f6945g.get(g1Var2);
            if (str != null) {
                k1VarC.a(new v1.h1(new v1.g1(str, g1Var2.f12705d), h1Var.f12712b));
            } else {
                k1VarC.a(h1Var);
            }
        }
        return f1VarA.d(k1VarC.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    @Override // android.os.Binder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTransact(int r20, android.os.Parcel r21, android.os.Parcel r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.d1.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
