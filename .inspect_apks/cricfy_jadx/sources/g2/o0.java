package g2;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Handler.Callback, s2.z, j1, y2.u {
    public static final long A0 = y1.a0.b0(10000);
    public final q0 A;
    public final w2.d B;
    public final y1.x C;
    public final k8.m D;
    public final Looper E;
    public final v1.e1 F;
    public final v1.c1 G;
    public final long H;
    public final boolean I;
    public final k J;
    public final ArrayList K;
    public final y1.v L;
    public final z M;
    public final w0 N;
    public final h1 O;
    public final h P;
    public final long Q;
    public final h2.l R;
    public final h2.f S;
    public final y1.x T;
    public final boolean U;
    public final d V;
    public r1 W;
    public q1 X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public n0 f4821a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public i1 f4822b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public l0 f4823c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f4824d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f4825e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f4826f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f4827g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f4828h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f4829i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f4830j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f4831k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f4832l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f4833m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f4834n0;
    public int o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public n0 f4835p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public long f4836q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public long f4837r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f4838s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f4839t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public n f4840u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p1[] f4841v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long f4842v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e[] f4843w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public q f4844w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean[] f4845x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public long f4846x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final v2.t f4847y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f4848y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final v2.u f4849z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public float f4850z0;

    public o0(Context context, e[] eVarArr, e[] eVarArr2, v2.t tVar, v2.u uVar, q0 q0Var, w2.d dVar, int i, boolean z10, h2.f fVar, r1 r1Var, h hVar, long j4, Looper looper, y1.v vVar, z zVar, h2.l lVar, final y2.u uVar2) {
        q qVar = q.f4885a;
        this.f4846x0 = -9223372036854775807L;
        this.M = zVar;
        this.f4847y = tVar;
        this.f4849z = uVar;
        this.A = q0Var;
        this.B = dVar;
        this.f4830j0 = i;
        this.f4831k0 = z10;
        this.W = r1Var;
        this.P = hVar;
        this.Q = j4;
        this.f4825e0 = false;
        this.L = vVar;
        this.R = lVar;
        this.f4844w0 = qVar;
        this.S = fVar;
        this.f4850z0 = 1.0f;
        this.X = q1.f4886b;
        this.f4842v0 = -9223372036854775807L;
        this.f4828h0 = -9223372036854775807L;
        this.H = q0Var.i();
        this.I = q0Var.b();
        v1.b1 b1Var = v1.f1.f12674a;
        i1 i1VarK = i1.k(uVar);
        this.f4822b0 = i1VarK;
        this.f4823c0 = new l0(i1VarK);
        this.f4843w = new e[eVarArr.length];
        this.f4845x = new boolean[eVarArr.length];
        v2.o oVar = (v2.o) tVar;
        oVar.getClass();
        this.f4841v = new p1[eVarArr.length];
        boolean z11 = false;
        for (int i10 = 0; i10 < eVarArr.length; i10++) {
            e eVar = eVarArr[i10];
            eVar.f4661z = i10;
            eVar.A = lVar;
            eVar.B = vVar;
            this.f4843w[i10] = eVar;
            e eVar2 = this.f4843w[i10];
            synchronized (eVar2.f4657v) {
                eVar2.M = oVar;
            }
            e eVar3 = eVarArr2[i10];
            if (eVar3 != null) {
                eVar3.f4661z = i10;
                eVar3.A = lVar;
                eVar3.B = vVar;
                z11 = true;
            }
            p1[] p1VarArr = this.f4841v;
            e eVar4 = eVarArr[i10];
            p1 p1Var = new p1();
            p1Var.f4884e = eVar4;
            p1Var.f4882c = i10;
            p1Var.f = eVar3;
            p1Var.f4883d = 0;
            p1Var.f4880a = false;
            p1Var.f4881b = false;
            p1VarArr[i10] = p1Var;
        }
        this.U = z11;
        this.J = new k(this, vVar);
        this.K = new ArrayList();
        this.F = new v1.e1();
        this.G = new v1.c1();
        y1.d.g(tVar.f13126a == null);
        tVar.f13126a = this;
        tVar.f13127b = dVar;
        this.f4839t0 = true;
        y1.x xVarA = vVar.a(looper, null);
        this.T = xVarA;
        this.N = new w0(fVar, xVarA, new androidx.fragment.app.f1(14, this));
        this.O = new h1(this, fVar, xVarA, lVar);
        k8.m mVar = new k8.m();
        mVar.f7280w = new Object();
        mVar.f7281x = null;
        mVar.f7282y = null;
        mVar.f7279v = 0;
        this.D = mVar;
        Looper looperB = mVar.b();
        this.E = looperB;
        y1.x xVarA2 = vVar.a(looperB, this);
        this.C = xVarA2;
        this.V = new d(context, looperB, this);
        xVarA2.a(35, new y2.u() { // from class: g2.h0
            @Override // y2.u
            public final void d(long j7, long j10, v1.p pVar, MediaFormat mediaFormat) {
                o0 o0Var = this.f4734v;
                o0Var.getClass();
                uVar2.d(j7, j10, pVar, mediaFormat);
                o0Var.d(j7, j10, pVar, mediaFormat);
            }
        }).b();
    }

    public static Pair S(v1.f1 f1Var, n0 n0Var, boolean z10, int i, boolean z11, v1.e1 e1Var, v1.c1 c1Var) {
        int iT;
        v1.f1 f1Var2 = n0Var.f4808a;
        if (f1Var.p()) {
            return null;
        }
        v1.f1 f1Var3 = f1Var2.p() ? f1Var : f1Var2;
        try {
            Pair pairI = f1Var3.i(e1Var, c1Var, n0Var.f4809b, n0Var.f4810c);
            if (!f1Var.equals(f1Var3)) {
                if (f1Var.b(pairI.first) == -1) {
                    if (!z10 || (iT = T(e1Var, c1Var, i, z11, pairI.first, f1Var3, f1Var)) == -1) {
                        return null;
                    }
                    return f1Var.i(e1Var, c1Var, iT, -9223372036854775807L);
                }
                if (f1Var3.g(pairI.first, c1Var).f && f1Var3.m(c1Var.f12618c, e1Var, 0L).f12654n == f1Var3.b(pairI.first)) {
                    return f1Var.i(e1Var, c1Var, f1Var.g(pairI.first, c1Var).f12618c, n0Var.f4810c);
                }
            }
            return pairI;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static int T(v1.e1 e1Var, v1.c1 c1Var, int i, boolean z10, Object obj, v1.f1 f1Var, v1.f1 f1Var2) {
        v1.e1 e1Var2 = e1Var;
        v1.f1 f1Var3 = f1Var;
        Object obj2 = f1Var3.m(f1Var3.g(obj, c1Var).f12618c, e1Var, 0L).f12643a;
        for (int i10 = 0; i10 < f1Var2.o(); i10++) {
            if (f1Var2.m(i10, e1Var, 0L).f12643a.equals(obj2)) {
                return i10;
            }
        }
        int iB = f1Var3.b(obj);
        int iH = f1Var3.h();
        int iB2 = -1;
        int i11 = 0;
        while (i11 < iH && iB2 == -1) {
            v1.f1 f1Var4 = f1Var3;
            int iD = f1Var4.d(iB, c1Var, e1Var2, i, z10);
            if (iD == -1) {
                break;
            }
            iB2 = f1Var2.b(f1Var4.l(iD));
            i11++;
            f1Var3 = f1Var4;
            iB = iD;
            e1Var2 = e1Var;
        }
        if (iB2 == -1) {
            return -1;
        }
        return f1Var2.f(iB2, c1Var, false).f12618c;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, s2.a0, s2.c1] */
    public static boolean z(u0 u0Var) {
        if (u0Var != null) {
            try {
                ?? r12 = u0Var.f4903a;
                if (u0Var.f4907e) {
                    for (s2.a1 a1Var : u0Var.f4905c) {
                        if (a1Var != null) {
                            a1Var.c();
                        }
                    }
                } else {
                    r12.r();
                }
                if ((!u0Var.f4907e ? 0L : r12.j()) != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public final boolean A(int i, s2.c0 c0Var) {
        w0 w0Var = this.N;
        u0 u0Var = w0Var.f4938k;
        if (u0Var != null && u0Var.f4908g.f4919a.equals(c0Var)) {
            p1 p1Var = this.f4841v[i];
            u0 u0Var2 = w0Var.f4938k;
            int i10 = p1Var.f4883d;
            boolean z10 = (i10 == 2 || i10 == 4) && p1Var.d(u0Var2) == ((e) p1Var.f4884e);
            boolean z11 = p1Var.f4883d == 3 && p1Var.d(u0Var2) == ((e) p1Var.f);
            if (z10 || z11) {
                return true;
            }
        }
        return false;
    }

    public final void A0(v1.f1 f1Var, s2.c0 c0Var, v1.f1 f1Var2, s2.c0 c0Var2, long j4, boolean z10) {
        boolean zR0 = r0(f1Var, c0Var);
        Object obj = c0Var.f11156a;
        if (!zR0) {
            v1.q0 q0Var = c0Var.b() ? v1.q0.f12966d : this.f4822b0.f4762o;
            k kVar = this.J;
            if (kVar.d().equals(q0Var)) {
                return;
            }
            this.C.d(16);
            kVar.f(q0Var);
            x(this.f4822b0.f4762o, q0Var.f12968a, false, false);
            return;
        }
        v1.c1 c1Var = this.G;
        int i = f1Var.g(obj, c1Var).f12618c;
        v1.e1 e1Var = this.F;
        f1Var.n(i, e1Var);
        v1.a0 a0Var = e1Var.f12650j;
        h hVar = this.P;
        hVar.getClass();
        hVar.f4724c = y1.a0.O(a0Var.f12571a);
        hVar.f = y1.a0.O(a0Var.f12572b);
        hVar.f4727g = y1.a0.O(a0Var.f12573c);
        float f = a0Var.f12574d;
        if (f == -3.4028235E38f) {
            f = 0.97f;
        }
        hVar.f4729j = f;
        float f10 = a0Var.f12575e;
        if (f10 == -3.4028235E38f) {
            f10 = 1.03f;
        }
        hVar.i = f10;
        if (f == 1.0f && f10 == 1.0f) {
            hVar.f4724c = -9223372036854775807L;
        }
        hVar.a();
        if (j4 != -9223372036854775807L) {
            hVar.f4725d = m(f1Var, obj, j4);
            hVar.a();
            return;
        }
        if (!Objects.equals(!f1Var2.p() ? f1Var2.m(f1Var2.g(c0Var2.f11156a, c1Var).f12618c, e1Var, 0L).f12643a : null, e1Var.f12643a) || z10) {
            hVar.f4725d = -9223372036854775807L;
            hVar.a();
        }
    }

    public final boolean B() {
        u0 u0Var = this.N.i;
        long j4 = u0Var.f4908g.f4923e;
        if (u0Var.f4907e) {
            return j4 == -9223372036854775807L || this.f4822b0.f4766s < j4 || !q0();
        }
        return false;
    }

    public final void B0(boolean z10, boolean z11) {
        long jElapsedRealtime;
        this.f4827g0 = z10;
        if (!z10 || z11) {
            jElapsedRealtime = -9223372036854775807L;
        } else {
            this.L.getClass();
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.f4828h0 = jElapsedRealtime;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object, s2.a0] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.Object, s2.c1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, s2.c1] */
    public final void C() {
        boolean zC;
        if (z(this.N.f4939l)) {
            u0 u0Var = this.N.f4939l;
            long jP = p(!u0Var.f4907e ? 0L : u0Var.f4903a.j());
            u0 u0Var2 = this.N.i;
            long j4 = r0(this.f4822b0.f4750a, u0Var.f4908g.f4919a) ? this.P.f4728h : -9223372036854775807L;
            h2.l lVar = this.R;
            v1.f1 f1Var = this.f4822b0.f4750a;
            float f = this.J.d().f12968a;
            boolean z10 = this.f4822b0.f4759l;
            p0 p0Var = new p0(lVar, jP, f, this.f4827g0, j4);
            zC = this.A.c(p0Var);
            u0 u0Var3 = this.N.i;
            if (!zC && u0Var3.f4907e && jP < 500000 && (this.H > 0 || this.I)) {
                u0Var3.f4903a.l(false, this.f4822b0.f4766s);
                zC = this.A.c(p0Var);
            }
        } else {
            zC = false;
        }
        this.f4829i0 = zC;
        if (zC) {
            u0 u0Var4 = this.N.f4939l;
            u0Var4.getClass();
            r0 r0Var = new r0();
            r0Var.f4888a = this.f4836q0 - u0Var4.f4916p;
            float f10 = this.J.d().f12968a;
            y1.d.b(f10 > 0.0f || f10 == -3.4028235E38f);
            r0Var.f4889b = f10;
            long j7 = this.f4828h0;
            y1.d.b(j7 >= 0 || j7 == -9223372036854775807L);
            r0Var.f4890c = j7;
            s0 s0Var = new s0(r0Var);
            y1.d.g(u0Var4.f4913m == null);
            u0Var4.f4903a.i(s0Var);
        }
        v0();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, s2.a0, s2.c1] */
    public final void D() {
        w0 w0Var = this.N;
        w0Var.k();
        u0 u0Var = w0Var.f4940m;
        if (u0Var != null) {
            ?? r12 = u0Var.f4903a;
            if ((!u0Var.f4906d || u0Var.f4907e) && !r12.a()) {
                v1.f1 f1Var = this.f4822b0.f4750a;
                if (u0Var.f4907e) {
                    r12.q();
                }
                if (this.A.d()) {
                    if (!u0Var.f4906d) {
                        long j4 = u0Var.f4908g.f4920b;
                        u0Var.f4906d = true;
                        r12.d(this, j4);
                        return;
                    }
                    r0 r0Var = new r0();
                    r0Var.f4888a = this.f4836q0 - u0Var.f4916p;
                    float f = this.J.d().f12968a;
                    y1.d.b(f > 0.0f || f == -3.4028235E38f);
                    r0Var.f4889b = f;
                    long j7 = this.f4828h0;
                    y1.d.b(j7 >= 0 || j7 == -9223372036854775807L);
                    r0Var.f4890c = j7;
                    s0 s0Var = new s0(r0Var);
                    y1.d.g(u0Var.f4913m == null);
                    r12.i(s0Var);
                }
            }
        }
    }

    public final void E() {
        l0 l0Var = this.f4823c0;
        i1 i1Var = this.f4822b0;
        boolean z10 = l0Var.f4794c | (((i1) l0Var.f) != i1Var);
        l0Var.f4794c = z10;
        l0Var.f = i1Var;
        if (z10) {
            g0 g0Var = this.M.f4951w;
            g0Var.F.c(new androidx.fragment.app.d(5, g0Var, l0Var));
            this.f4823c0 = new l0(this.f4822b0);
        }
    }

    public final void F(int i) {
        p1 p1Var = this.f4841v[i];
        try {
            u0 u0Var = this.N.i;
            u0Var.getClass();
            e eVarD = p1Var.d(u0Var);
            eVarD.getClass();
            s2.a1 a1Var = eVarD.D;
            a1Var.getClass();
            a1Var.c();
        } catch (IOException | RuntimeException e9) {
            int i10 = ((e) p1Var.f4884e).f4658w;
            if (i10 != 3 && i10 != 5) {
                throw e9;
            }
            v2.u uVar = this.N.i.f4915o;
            y1.b.h("ExoPlayerImplInternal", "Disabling track due to error: " + v1.p.c(uVar.f13130c[i].j()), e9);
            v2.u uVar2 = new v2.u((o1[]) uVar.f13129b.clone(), (v2.q[]) uVar.f13130c.clone(), uVar.f13131d, uVar.f13132e);
            uVar2.f13129b[i] = null;
            uVar2.f13130c[i] = null;
            h(i);
            u0 u0Var2 = this.N.i;
            u0Var2.a(uVar2, this.f4822b0.f4766s, false, new boolean[u0Var2.f4910j.length]);
        }
    }

    public final void G(int i, boolean z10) {
        boolean[] zArr = this.f4845x;
        if (zArr[i] != z10) {
            zArr[i] = z10;
            this.T.c(new d6.i(this, i, z10));
        }
    }

    public final void H() throws Throwable {
        v(this.O.c(), true);
    }

    public final void I(k0 k0Var) throws Throwable {
        v1.f1 f1VarC;
        this.f4823c0.f(1);
        int i = k0Var.f4784a;
        int i10 = k0Var.f4785b;
        int i11 = k0Var.f4786c;
        s2.d1 d1Var = k0Var.f4787d;
        h1 h1Var = this.O;
        ArrayList arrayList = (ArrayList) h1Var.f4738c;
        y1.d.b(i >= 0 && i <= i10 && i10 <= arrayList.size() && i11 >= 0);
        h1Var.f4744k = d1Var;
        if (i == i10 || i == i11) {
            f1VarC = h1Var.c();
        } else {
            int iMin = Math.min(i, i11);
            int iMax = Math.max(((i10 - i) + i11) - 1, i10 - 1);
            int iO = ((g1) arrayList.get(iMin)).f4720d;
            y1.a0.N(arrayList, i, i10, i11);
            while (iMin <= iMax) {
                g1 g1Var = (g1) arrayList.get(iMin);
                g1Var.f4720d = iO;
                iO += g1Var.f4717a.f11360o.f11299e.o();
                iMin++;
            }
            f1VarC = h1Var.c();
        }
        v(f1VarC, false);
    }

    public final void J() {
        this.f4823c0.f(1);
        O(false, false, false, true);
        this.A.h(this.R);
        m0(this.f4822b0.f4750a.p() ? 4 : 2);
        i1 i1Var = this.f4822b0;
        boolean z10 = i1Var.f4759l;
        y0(this.V.d(i1Var.f4754e, z10), i1Var.f4761n, i1Var.f4760m, z10);
        w2.g gVar = (w2.g) this.B;
        gVar.getClass();
        h1 h1Var = this.O;
        ArrayList arrayList = (ArrayList) h1Var.f4738c;
        y1.d.g(!h1Var.f4736a);
        h1Var.f4745l = gVar;
        for (int i = 0; i < arrayList.size(); i++) {
            g1 g1Var = (g1) arrayList.get(i);
            h1Var.g(g1Var);
            ((HashSet) h1Var.f4742h).add(g1Var);
        }
        h1Var.f4736a = true;
        this.C.e(2);
    }

    public final void K(y1.g gVar) {
        k8.m mVar = this.D;
        y1.x xVar = this.C;
        try {
            O(true, false, true, false);
            L();
            this.A.a(this.R);
            d dVar = this.V;
            dVar.f4646c = null;
            dVar.a();
            dVar.c(0);
            this.f4847y.a();
            m0(1);
        } finally {
            xVar.f14618a.removeCallbacksAndMessages(null);
            mVar.c();
            gVar.e();
        }
    }

    public final void L() {
        for (int i = 0; i < this.f4841v.length; i++) {
            e eVar = this.f4843w[i];
            synchronized (eVar.f4657v) {
                eVar.M = null;
            }
            p1 p1Var = this.f4841v[i];
            e eVar2 = (e) p1Var.f4884e;
            y1.d.g(eVar2.C == 0);
            eVar2.r();
            p1Var.f4880a = false;
            e eVar3 = (e) p1Var.f;
            if (eVar3 != null) {
                y1.d.g(eVar3.C == 0);
                eVar3.r();
                p1Var.f4881b = false;
            }
        }
    }

    public final void M(int i, int i10, s2.d1 d1Var) throws Throwable {
        this.f4823c0.f(1);
        h1 h1Var = this.O;
        h1Var.getClass();
        y1.d.b(i >= 0 && i <= i10 && i10 <= ((ArrayList) h1Var.f4738c).size());
        h1Var.f4744k = d1Var;
        h1Var.i(i, i10);
        v(h1Var.c(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N() {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o0.N():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(boolean r36, boolean r37, boolean r38, boolean r39) {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o0.O(boolean, boolean, boolean, boolean):void");
    }

    public final void P() {
        u0 u0Var = this.N.i;
        this.f4826f0 = u0Var != null && u0Var.f4908g.i && this.f4825e0;
    }

    public final void Q(long j4) {
        u0 u0Var = this.N.i;
        long j7 = j4 + (u0Var == null ? 1000000000000L : u0Var.f4916p);
        this.f4836q0 = j7;
        ((f9.e1) this.J.f4781x).a(j7);
        for (p1 p1Var : this.f4841v) {
            long j10 = this.f4836q0;
            e eVarD = p1Var.d(u0Var);
            if (eVarD != null) {
                eVarD.I = false;
                eVarD.G = j10;
                eVarD.H = j10;
                eVarD.q(false, j10);
            }
        }
        for (u0 u0Var2 = r0.i; u0Var2 != null; u0Var2 = u0Var2.f4913m) {
            for (v2.q qVar : u0Var2.f4915o.f13130c) {
                if (qVar != null) {
                    qVar.q();
                }
            }
        }
    }

    public final void R(v1.f1 f1Var, v1.f1 f1Var2) {
        if (f1Var.p() && f1Var2.p()) {
            return;
        }
        ArrayList arrayList = this.K;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            q4.a.u(arrayList.get(size));
            throw null;
        }
    }

    public final void U(long j4) {
        boolean z10 = this.Y;
        long j7 = A0;
        if (z10) {
            this.X.getClass();
            jMin = this.f4822b0.f4754e != 3 ? j7 : 1000L;
            for (p1 p1Var : this.f4841v) {
                long j10 = this.f4836q0;
                long j11 = this.f4837r0;
                e eVar = (e) p1Var.f;
                e eVar2 = (e) p1Var.f4884e;
                long jE = p1.h(eVar2) ? eVar2.e(j10, j11) : Long.MAX_VALUE;
                if (eVar != null && eVar.C != 0) {
                    jE = Math.min(jE, eVar.e(j10, j11));
                }
                jMin = Math.min(jMin, y1.a0.b0(jE));
            }
            if (this.f4822b0.m()) {
                u0 u0Var = this.N.i;
                if ((u0Var != null ? u0Var.f4913m : null) != null) {
                    if ((y1.a0.O(jMin) * this.f4822b0.f4762o.f12968a) + this.f4836q0 >= r1.e()) {
                        jMin = Math.min(jMin, j7);
                    }
                }
            }
        } else if (this.f4822b0.f4754e != 3 || q0()) {
            jMin = j7;
        }
        this.C.f14618a.sendEmptyMessageAtTime(2, j4 + jMin);
    }

    public final void V(boolean z10) {
        s2.c0 c0Var = this.N.i.f4908g.f4919a;
        long jX = X(c0Var, this.f4822b0.f4766s, true, false);
        if (jX != this.f4822b0.f4766s) {
            i1 i1Var = this.f4822b0;
            this.f4822b0 = y(c0Var, jX, i1Var.f4752c, i1Var.f4753d, z10, 5);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|(1:8)(4:10|(1:12)(1:13)|14|(3:16|(1:18)|19)(10:20|(1:22)(1:23)|106|24|110|(1:26)(6:29|(3:31|(1:33)|34)(24:36|(8:38|(1:50)(3:44|(1:48)|49)|51|(1:58)|59|60|61|62)(1:63)|102|64|(1:66)(1:67)|113|68|(1:70)(1:71)|72|73|(1:75)(1:76)|77|111|78|79|108|80|81|104|82|83|84|61|62)|97|95|100|101)|35|84|61|62))|9|106|24|110|(0)(0)|35|84|61|62) */
    /* JADX WARN: Can't wrap try/catch for region: R(5:36|(20:(8:38|(1:50)(3:44|(1:48)|49)|51|(1:58)|59|60|61|62)(1:63)|113|68|(1:70)(1:71)|72|73|(1:75)(1:76)|77|111|78|79|108|80|81|104|82|83|84|61|62)|102|64|(1:66)(1:67)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
    
        r9 = r2;
        r2 = r6;
        r3 = r11;
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0173, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0176, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0177, code lost:
    
        r9 = r2;
        r2 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7 A[Catch: all -> 0x00aa, TRY_ENTER, TryCatch #4 {all -> 0x00aa, blocks: (B:26:0x00a7, B:31:0x00b4, B:33:0x00ba, B:34:0x00bd, B:38:0x00d0, B:40:0x00d6, B:44:0x00de, B:48:0x00ec, B:49:0x00f1, B:51:0x00f9, B:53:0x010a, B:59:0x0118), top: B:110:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Object, s2.a0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W(g2.n0 r18, boolean r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o0.W(g2.n0, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object, s2.a0] */
    public final long X(s2.c0 c0Var, long j4, boolean z10, boolean z11) {
        p1[] p1VarArr;
        u0();
        B0(false, true);
        if (z11 || this.f4822b0.f4754e == 3) {
            m0(2);
        }
        w0 w0Var = this.N;
        u0 u0Var = w0Var.i;
        u0 u0Var2 = u0Var;
        while (u0Var2 != null && !c0Var.equals(u0Var2.f4908g.f4919a)) {
            u0Var2 = u0Var2.f4913m;
        }
        if (z10 || u0Var != u0Var2 || (u0Var2 != null && u0Var2.f4916p + j4 < 0)) {
            int i = 0;
            while (true) {
                p1VarArr = this.f4841v;
                if (i >= p1VarArr.length) {
                    break;
                }
                h(i);
                i++;
            }
            this.f4846x0 = -9223372036854775807L;
            if (u0Var2 != null) {
                while (w0Var.i != u0Var2) {
                    w0Var.a();
                }
                w0Var.n(u0Var2);
                u0Var2.f4916p = 1000000000000L;
                l(new boolean[p1VarArr.length], w0Var.f4937j.e());
                u0Var2.f4909h = true;
            }
        }
        g();
        if (u0Var2 != null) {
            ?? r10 = u0Var2.f4903a;
            w0Var.n(u0Var2);
            if (!u0Var2.f4907e) {
                u0Var2.f4908g = u0Var2.f4908g.b(j4);
            } else if (u0Var2.f) {
                j4 = r10.t(j4);
                r10.l(this.I, j4 - this.H);
            }
            Q(j4);
            C();
        } else {
            w0Var.b();
            Q(j4);
        }
        u(false);
        this.C.e(2);
        return j4;
    }

    public final void Y(l1 l1Var) {
        l1Var.getClass();
        y1.x xVar = this.C;
        if (l1Var.f4801e != this.E) {
            xVar.a(15, l1Var).b();
            return;
        }
        synchronized (l1Var) {
        }
        try {
            l1Var.f4797a.b(l1Var.f4799c, l1Var.f4800d);
            l1Var.a(true);
            int i = this.f4822b0.f4754e;
            if (i == 3 || i == 2) {
                xVar.e(2);
            }
        } catch (Throwable th) {
            l1Var.a(true);
            throw th;
        }
    }

    public final void Z(l1 l1Var) {
        Looper looper = l1Var.f4801e;
        if (looper.getThread().isAlive()) {
            this.L.a(looper, null).c(new androidx.emoji2.text.w(this, l1Var));
        } else {
            y1.b.p("TAG", "Trying to send message on a dead thread.");
            l1Var.a(false);
        }
    }

    public final void a(j0 j0Var, int i) throws Throwable {
        this.f4823c0.f(1);
        h1 h1Var = this.O;
        if (i == -1) {
            i = ((ArrayList) h1Var.f4738c).size();
        }
        v(h1Var.a(i, j0Var.f4775a, j0Var.f4776b), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(v1.c r7, boolean r8) {
        /*
            r6 = this;
            v2.t r0 = r6.f4847y
            v2.o r0 = (v2.o) r0
            v1.c r1 = r0.i
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto Ld
            goto L12
        Ld:
            r0.i = r7
            r0.f()
        L12:
            if (r8 == 0) goto L15
            goto L16
        L15:
            r7 = 0
        L16:
            g2.d r8 = r6.V
            v1.c r0 = r8.f4647d
            boolean r0 = java.util.Objects.equals(r0, r7)
            if (r0 != 0) goto L53
            r8.f4647d = r7
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L28
        L26:
            r3 = r0
            goto L47
        L28:
            int r2 = r7.f12594c
            r3 = 3
            r4 = 2
            java.lang.String r5 = "AudioFocusManager"
            switch(r2) {
                case 0: goto L41;
                case 1: goto L3f;
                case 2: goto L3d;
                case 3: goto L26;
                case 4: goto L3d;
                case 5: goto L47;
                case 6: goto L47;
                case 7: goto L47;
                case 8: goto L47;
                case 9: goto L47;
                case 10: goto L47;
                case 11: goto L39;
                case 12: goto L47;
                case 13: goto L47;
                case 14: goto L3f;
                case 15: goto L31;
                case 16: goto L37;
                default: goto L31;
            }
        L31:
            java.lang.String r7 = "Unidentified audio usage: "
            l0.e.p(r2, r7, r5)
            goto L26
        L37:
            r3 = 4
            goto L47
        L39:
            int r7 = r7.f12592a
            if (r7 != r1) goto L47
        L3d:
            r3 = r4
            goto L47
        L3f:
            r3 = r1
            goto L47
        L41:
            java.lang.String r7 = "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default."
            y1.b.p(r5, r7)
            goto L3f
        L47:
            r8.f = r3
            if (r3 == r1) goto L4d
            if (r3 != 0) goto L4e
        L4d:
            r0 = r1
        L4e:
            java.lang.String r7 = "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME."
            y1.d.a(r7, r0)
        L53:
            g2.i1 r7 = r6.f4822b0
            boolean r0 = r7.f4759l
            int r1 = r7.f4761n
            int r2 = r7.f4760m
            int r7 = r7.f4754e
            int r7 = r8.d(r7, r0)
            r6.y0(r7, r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o0.a0(v1.c, boolean):void");
    }

    public final void b() {
        for (p1 p1Var : this.f4841v) {
            q1 q1Var = this.Y ? this.X : null;
            ((e) p1Var.f4884e).b(18, q1Var);
            e eVar = (e) p1Var.f;
            if (eVar != null) {
                eVar.b(18, q1Var);
            }
        }
    }

    public final void b0(boolean z10, y1.g gVar) {
        if (this.f4832l0 != z10) {
            this.f4832l0 = z10;
            if (!z10) {
                for (p1 p1Var : this.f4841v) {
                    p1Var.k();
                }
            }
        }
        if (gVar != null) {
            gVar.e();
        }
    }

    public final boolean c() {
        if (!this.U) {
            return false;
        }
        for (p1 p1Var : this.f4841v) {
            if (p1Var.f()) {
                return true;
            }
        }
        return false;
    }

    public final void c0(j0 j0Var) throws Throwable {
        this.f4823c0.f(1);
        int i = j0Var.f4777c;
        s2.d1 d1Var = j0Var.f4776b;
        ArrayList arrayList = j0Var.f4775a;
        if (i != -1) {
            this.f4835p0 = new n0(new n1(arrayList, d1Var), j0Var.f4777c, j0Var.f4778d);
        }
        h1 h1Var = this.O;
        ArrayList arrayList2 = (ArrayList) h1Var.f4738c;
        h1Var.i(0, arrayList2.size());
        v(h1Var.a(arrayList2.size(), arrayList, d1Var), false);
    }

    @Override // y2.u
    public final void d(long j4, long j7, v1.p pVar, MediaFormat mediaFormat) {
        if (this.Z) {
            y1.x xVar = this.C;
            xVar.getClass();
            y1.w wVarB = y1.x.b();
            wVarB.f14616a = xVar.f14618a.obtainMessage(37);
            wVarB.b();
        }
    }

    public final void d0(boolean z10) {
        this.f4825e0 = z10;
        P();
        if (this.f4826f0) {
            w0 w0Var = this.N;
            if (w0Var.f4937j != w0Var.i) {
                V(true);
                u(false);
            }
        }
    }

    public final void e() {
        N();
        V(true);
    }

    public final void e0(v1.q0 q0Var) {
        this.C.d(16);
        k kVar = this.J;
        kVar.f(q0Var);
        v1.q0 q0VarD = kVar.d();
        x(q0VarD, q0VarD.f12968a, true, true);
    }

    @Override // s2.b1
    public final void f(s2.c1 c1Var) {
        this.C.a(9, (s2.a0) c1Var).b();
    }

    public final void f0(q qVar) {
        this.f4844w0 = qVar;
        v1.f1 f1Var = this.f4822b0.f4750a;
        w0 w0Var = this.N;
        w0Var.getClass();
        qVar.getClass();
        if (w0Var.f4944q.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < w0Var.f4944q.size(); i++) {
            ((u0) w0Var.f4944q.get(i)).i();
        }
        w0Var.f4944q = arrayList;
        w0Var.f4940m = null;
        w0Var.k();
    }

    public final void g() {
        e eVar;
        if (this.U && c()) {
            for (p1 p1Var : this.f4841v) {
                int iC = p1Var.c();
                if (p1Var.f()) {
                    int i = p1Var.f4883d;
                    boolean z10 = i == 4 || i == 2;
                    int i10 = i != 4 ? 0 : 1;
                    if (z10) {
                        eVar = (e) p1Var.f4884e;
                    } else {
                        eVar = (e) p1Var.f;
                        eVar.getClass();
                    }
                    p1Var.a(eVar, this.J);
                    p1Var.i(z10);
                    p1Var.f4883d = i10;
                }
                this.o0 -= iC - p1Var.c();
            }
            this.f4846x0 = -9223372036854775807L;
        }
    }

    public final void g0(int i) {
        this.f4830j0 = i;
        v1.f1 f1Var = this.f4822b0.f4750a;
        w0 w0Var = this.N;
        w0Var.f4935g = i;
        int iR = w0Var.r(f1Var);
        if ((iR & 1) != 0) {
            V(true);
        } else if ((iR & 2) != 0) {
            g();
        }
        u(false);
    }

    public final void h(int i) {
        p1[] p1VarArr = this.f4841v;
        int iC = p1VarArr[i].c();
        p1 p1Var = p1VarArr[i];
        e eVar = (e) p1Var.f4884e;
        k kVar = this.J;
        p1Var.a(eVar, kVar);
        e eVar2 = (e) p1Var.f;
        if (eVar2 != null) {
            boolean z10 = (eVar2.C == 0 || p1Var.f4883d == 3) ? false : true;
            p1Var.a(eVar2, kVar);
            p1Var.i(false);
            if (z10) {
                e eVar3 = (e) p1Var.f4884e;
                eVar2.getClass();
                eVar2.b(17, eVar3);
            }
        }
        p1Var.f4883d = 0;
        G(i, false);
        this.o0 -= iC;
    }

    public final void h0(boolean z10) throws Throwable {
        if (!z10) {
            this.Z = false;
            this.C.d(37);
            n0 n0Var = this.f4821a0;
            if (n0Var != null) {
                W(n0Var, false);
                this.f4821a0 = null;
            }
        }
        this.Y = z10;
        b();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        int i;
        int i10;
        u0 u0Var;
        s2.c0 c0Var;
        u0 u0Var2;
        try {
            switch (message.what) {
                case 1:
                    boolean z10 = message.arg1 != 0;
                    int i11 = message.arg2;
                    this.f4823c0.f(1);
                    y0(this.V.d(this.f4822b0.f4754e, z10), i11 >> 4, i11 & 15, z10);
                    break;
                case 2:
                    i();
                    break;
                case 3:
                    W((n0) message.obj, true);
                    break;
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    e0((v1.q0) message.obj);
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    j0((r1) message.obj);
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    t0(false, true);
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    K((y1.g) message.obj);
                    return true;
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                    w((s2.a0) message.obj);
                    break;
                case 9:
                    s((s2.a0) message.obj);
                    break;
                case 10:
                    N();
                    break;
                case 11:
                    g0(message.arg1);
                    break;
                case 12:
                    k0(message.arg1 != 0);
                    break;
                case 13:
                    b0(message.arg1 != 0, (y1.g) message.obj);
                    break;
                case 14:
                    Y((l1) message.obj);
                    break;
                case 15:
                    Z((l1) message.obj);
                    break;
                case 16:
                    v1.q0 q0Var = (v1.q0) message.obj;
                    x(q0Var, q0Var.f12968a, true, false);
                    break;
                case 17:
                    c0((j0) message.obj);
                    break;
                case 18:
                    a((j0) message.obj, message.arg1);
                    break;
                case 19:
                    I((k0) message.obj);
                    break;
                case 20:
                    M(message.arg1, message.arg2, (s2.d1) message.obj);
                    break;
                case 21:
                    l0((s2.d1) message.obj);
                    break;
                case 22:
                    H();
                    break;
                case 23:
                    d0(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    e();
                    break;
                case 26:
                    N();
                    V(true);
                    break;
                case 27:
                    x0(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    f0((q) message.obj);
                    break;
                case 29:
                    J();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    o0(pair.first, (y1.g) pair.second);
                    break;
                case 31:
                    a0((v1.c) message.obj, message.arg1 != 0);
                    break;
                case 32:
                    p0(((Float) message.obj).floatValue());
                    break;
                case 33:
                    q(message.arg1);
                    break;
                case 34:
                    r();
                    break;
                case 35:
                    n0((y2.u) message.obj);
                    break;
                case 36:
                    h0(((Boolean) message.obj).booleanValue());
                    break;
                case 37:
                    this.Z = false;
                    n0 n0Var = this.f4821a0;
                    if (n0Var != null) {
                        W(n0Var, false);
                        this.f4821a0 = null;
                    }
                    break;
                case 38:
                    i0((q1) message.obj);
                    break;
            }
        } catch (b2.l e9) {
            t(e9, e9.f1701v);
        } catch (n e10) {
            e = e10;
            int i12 = e.E;
            w0 w0Var = this.N;
            if (i12 == 1 && (u0Var2 = w0Var.f4937j) != null && e.J == null) {
                e = e.a(u0Var2.f4908g.f4919a);
            }
            int i13 = e.E;
            y1.x xVar = this.C;
            if (i13 == 1 && (c0Var = e.J) != null && A(e.G, c0Var)) {
                this.f4848y0 = true;
                g();
                u0 u0VarG = w0Var.g();
                u0 u0Var3 = w0Var.i;
                if (u0Var3 != u0VarG) {
                    while (u0Var3 != null) {
                        u0 u0Var4 = u0Var3.f4913m;
                        if (u0Var4 == u0VarG) {
                            break;
                        }
                        u0Var3 = u0Var4;
                    }
                }
                w0Var.n(u0Var3);
                if (this.f4822b0.f4754e != 4) {
                    C();
                    xVar.e(2);
                }
            } else {
                n nVar = this.f4840u0;
                if (nVar != null) {
                    nVar.addSuppressed(e);
                    e = this.f4840u0;
                }
                if (e.E == 1 && w0Var.i != w0Var.f4937j) {
                    while (true) {
                        u0Var = w0Var.i;
                        if (u0Var == w0Var.f4937j) {
                            break;
                        }
                        w0Var.a();
                    }
                    y1.d.d(u0Var);
                    E();
                    v0 v0Var = u0Var.f4908g;
                    s2.c0 c0Var2 = v0Var.f4919a;
                    long j4 = v0Var.f4920b;
                    this.f4822b0 = y(c0Var2, j4, v0Var.f4921c, j4, true, 0);
                }
                if (e.K && (this.f4840u0 == null || (i10 = e.f12961v) == 5004 || i10 == 5003)) {
                    y1.b.q("ExoPlayerImplInternal", "Recoverable renderer error", e);
                    if (this.f4840u0 == null) {
                        this.f4840u0 = e;
                    }
                    y1.w wVarA = xVar.a(25, e);
                    Handler handler = xVar.f14618a;
                    Message message2 = wVarA.f14616a;
                    message2.getClass();
                    handler.sendMessageAtFrontOfQueue(message2);
                    wVarA.a();
                } else {
                    y1.b.h("ExoPlayerImplInternal", "Playback error", e);
                    t0(true, false);
                    this.f4822b0 = this.f4822b0.f(e);
                }
            }
        } catch (RuntimeException e11) {
            n nVar2 = new n(2, e11, ((e11 instanceof IllegalStateException) || (e11 instanceof IllegalArgumentException)) ? 1004 : 1000);
            y1.b.h("ExoPlayerImplInternal", "Playback error", nVar2);
            t0(true, false);
            this.f4822b0 = this.f4822b0.f(nVar2);
        } catch (l2.g e12) {
            t(e12, e12.f7665v);
        } catch (s2.b e13) {
            t(e13, 1002);
        } catch (v1.n0 e14) {
            boolean z11 = e14.f12878v;
            int i14 = e14.f12879w;
            if (i14 == 1) {
                i = z11 ? 3001 : 3003;
            } else {
                if (i14 == 4) {
                    i = z11 ? 3002 : 3004;
                }
                t(e14, i);
            }
            i = i;
            t(e14, i);
        } catch (IOException e15) {
            t(e15, 2000);
        }
        E();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:196:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x070f  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x0808  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0884  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0897  */
    /* JADX WARN: Type inference failed for: r1v74, types: [java.lang.Object, s2.a0] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, s2.a0] */
    /* JADX WARN: Type inference failed for: r2v70, types: [java.lang.Object, s2.a0] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, s2.a0] */
    /* JADX WARN: Type inference failed for: r4v33, types: [java.lang.Object, s2.a0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 2244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o0.i():void");
    }

    public final void i0(q1 q1Var) {
        this.X = q1Var;
        b();
    }

    public final void j(u0 u0Var, int i, boolean z10, long j4) {
        p1 p1Var = this.f4841v[i];
        boolean zG = p1Var.g();
        e eVar = (e) p1Var.f4884e;
        if (zG) {
            return;
        }
        boolean z11 = u0Var == this.N.i;
        v2.u uVar = u0Var.f4915o;
        o1 o1Var = uVar.f13129b[i];
        v2.q qVar = uVar.f13130c[i];
        boolean z12 = q0() && this.f4822b0.f4754e == 3;
        boolean z13 = !z10 && z12;
        this.o0++;
        s2.a1 a1Var = u0Var.f4905c[i];
        long j7 = u0Var.f4916p;
        s2.c0 c0Var = u0Var.f4908g.f4919a;
        e eVar2 = (e) p1Var.f;
        int length = qVar != null ? qVar.length() : 0;
        v1.p[] pVarArr = new v1.p[length];
        for (int i10 = 0; i10 < length; i10++) {
            qVar.getClass();
            pVarArr[i10] = qVar.c(i10);
        }
        int i11 = p1Var.f4883d;
        k kVar = this.J;
        if (i11 == 0 || i11 == 2 || i11 == 4) {
            p1Var.f4880a = true;
            y1.d.g(eVar.C == 0);
            eVar.f4660y = o1Var;
            eVar.L = c0Var;
            eVar.C = 1;
            eVar.p(z13, z11);
            eVar.y(pVarArr, a1Var, j4, j7, c0Var);
            eVar.I = false;
            eVar.G = j4;
            eVar.H = j4;
            eVar.q(z13, j4);
            kVar.a(eVar);
        } else {
            p1Var.f4881b = true;
            eVar2.getClass();
            y1.d.g(eVar2.C == 0);
            eVar2.f4660y = o1Var;
            eVar2.L = c0Var;
            eVar2.C = 1;
            eVar2.p(z13, z11);
            eVar2.y(pVarArr, a1Var, j4, j7, c0Var);
            eVar2.I = false;
            eVar2.G = j4;
            eVar2.H = j4;
            eVar2.q(z13, j4);
            kVar.a(eVar2);
        }
        i0 i0Var = new i0(this);
        e eVarD = p1Var.d(u0Var);
        eVarD.getClass();
        eVarD.b(11, i0Var);
        if (z12 && z11) {
            p1Var.m();
        }
    }

    public final void j0(r1 r1Var) {
        this.W = r1Var;
    }

    @Override // s2.z
    public final void k(s2.a0 a0Var) {
        this.C.a(8, a0Var).b();
    }

    public final void k0(boolean z10) {
        this.f4831k0 = z10;
        v1.f1 f1Var = this.f4822b0.f4750a;
        w0 w0Var = this.N;
        w0Var.f4936h = z10;
        int iR = w0Var.r(f1Var);
        if ((iR & 1) != 0) {
            V(true);
        } else if ((iR & 2) != 0) {
            g();
        }
        u(false);
    }

    public final void l(boolean[] zArr, long j4) {
        p1[] p1VarArr;
        long j7;
        u0 u0Var = this.N.f4937j;
        v2.u uVar = u0Var.f4915o;
        int i = 0;
        while (true) {
            p1VarArr = this.f4841v;
            if (i >= p1VarArr.length) {
                break;
            }
            if (!uVar.b(i)) {
                p1VarArr[i].k();
            }
            i++;
        }
        int i10 = 0;
        while (i10 < p1VarArr.length) {
            if (uVar.b(i10) && p1VarArr[i10].d(u0Var) == null) {
                j7 = j4;
                j(u0Var, i10, zArr[i10], j7);
            } else {
                j7 = j4;
            }
            i10++;
            j4 = j7;
        }
    }

    public final void l0(s2.d1 d1Var) throws Throwable {
        this.f4823c0.f(1);
        h1 h1Var = this.O;
        int size = ((ArrayList) h1Var.f4738c).size();
        if (d1Var.f11167b.length != size) {
            d1Var = new s2.d1(new Random(d1Var.f11166a.nextLong())).a(0, size);
        }
        h1Var.f4744k = d1Var;
        v(h1Var.c(), false);
    }

    public final long m(v1.f1 f1Var, Object obj, long j4) {
        v1.c1 c1Var = this.G;
        int i = f1Var.g(obj, c1Var).f12618c;
        v1.e1 e1Var = this.F;
        f1Var.n(i, e1Var);
        if (e1Var.f != -9223372036854775807L && e1Var.a() && e1Var.i) {
            return y1.a0.O(y1.a0.y(e1Var.f12648g) - e1Var.f) - (j4 + c1Var.f12620e);
        }
        return -9223372036854775807L;
    }

    public final void m0(int i) {
        i1 i1Var = this.f4822b0;
        if (i1Var.f4754e != i) {
            if (i != 2) {
                this.f4842v0 = -9223372036854775807L;
            }
            if (i != 3 && i1Var.f4763p) {
                this.f4822b0 = i1Var.i(false);
            }
            this.f4822b0 = this.f4822b0.h(i);
        }
    }

    public final long n(u0 u0Var) {
        if (u0Var == null) {
            return 0L;
        }
        long jMax = u0Var.f4916p;
        if (!u0Var.f4907e) {
            return jMax;
        }
        int i = 0;
        while (true) {
            p1[] p1VarArr = this.f4841v;
            if (i >= p1VarArr.length) {
                return jMax;
            }
            if (p1VarArr[i].d(u0Var) != null) {
                e eVarD = p1VarArr[i].d(u0Var);
                Objects.requireNonNull(eVarD);
                long j4 = eVarD.H;
                if (j4 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(j4, jMax);
            }
            i++;
        }
    }

    public final void n0(y2.u uVar) {
        for (p1 p1Var : this.f4841v) {
            e eVar = (e) p1Var.f4884e;
            if (eVar.f4658w == 2) {
                eVar.b(7, uVar);
                e eVar2 = (e) p1Var.f;
                if (eVar2 != null) {
                    eVar2.b(7, uVar);
                }
            }
        }
    }

    public final Pair o(v1.f1 f1Var) {
        long j4 = 0;
        if (f1Var.p()) {
            return Pair.create(i1.f4749u, 0L);
        }
        int iA = f1Var.a(this.f4831k0);
        Pair pairI = f1Var.i(this.F, this.G, iA, -9223372036854775807L);
        s2.c0 c0VarP = this.N.p(f1Var, pairI.first, 0L);
        long jLongValue = ((Long) pairI.second).longValue();
        if (c0VarP.b()) {
            Object obj = c0VarP.f11156a;
            v1.c1 c1Var = this.G;
            f1Var.g(obj, c1Var);
            if (c0VarP.f11158c == c1Var.e(c0VarP.f11157b)) {
                c1Var.f12621g.getClass();
            }
        } else {
            j4 = jLongValue;
        }
        return Pair.create(c0VarP, Long.valueOf(j4));
    }

    public final void o0(Object obj, y1.g gVar) {
        for (p1 p1Var : this.f4841v) {
            e eVar = (e) p1Var.f4884e;
            if (eVar.f4658w == 2) {
                int i = p1Var.f4883d;
                if (i == 4 || i == 1) {
                    e eVar2 = (e) p1Var.f;
                    eVar2.getClass();
                    eVar2.b(1, obj);
                } else {
                    eVar.b(1, obj);
                }
            }
        }
        int i10 = this.f4822b0.f4754e;
        if (i10 == 3 || i10 == 2) {
            this.C.e(2);
        }
        if (gVar != null) {
            gVar.e();
        }
    }

    public final long p(long j4) {
        u0 u0Var = this.N.f4939l;
        if (u0Var == null) {
            return 0L;
        }
        return Math.max(0L, j4 - (this.f4836q0 - u0Var.f4916p));
    }

    public final void p0(float f) {
        this.f4850z0 = f;
        float f10 = f * this.V.f4649g;
        for (p1 p1Var : this.f4841v) {
            e eVar = (e) p1Var.f4884e;
            if (eVar.f4658w == 1) {
                eVar.b(2, Float.valueOf(f10));
                e eVar2 = (e) p1Var.f;
                if (eVar2 != null) {
                    eVar2.b(2, Float.valueOf(f10));
                }
            }
        }
    }

    public final void q(int i) {
        i1 i1Var = this.f4822b0;
        y0(i, i1Var.f4761n, i1Var.f4760m, i1Var.f4759l);
    }

    public final boolean q0() {
        i1 i1Var = this.f4822b0;
        return i1Var.f4759l && i1Var.f4761n == 0;
    }

    public final void r() {
        p0(this.f4850z0);
    }

    public final boolean r0(v1.f1 f1Var, s2.c0 c0Var) {
        if (c0Var.b() || f1Var.p()) {
            return false;
        }
        int i = f1Var.g(c0Var.f11156a, this.G).f12618c;
        v1.e1 e1Var = this.F;
        f1Var.n(i, e1Var);
        return e1Var.a() && e1Var.i && e1Var.f != -9223372036854775807L;
    }

    public final void s(s2.a0 a0Var) {
        w0 w0Var = this.N;
        u0 u0Var = w0Var.f4939l;
        if (u0Var != null && u0Var.f4903a == a0Var) {
            w0Var.m(this.f4836q0);
            C();
            return;
        }
        u0 u0Var2 = w0Var.f4940m;
        if (u0Var2 == null || u0Var2.f4903a != a0Var) {
            return;
        }
        D();
    }

    public final void s0() {
        u0 u0Var = this.N.i;
        if (u0Var == null) {
            return;
        }
        v2.u uVar = u0Var.f4915o;
        int i = 0;
        while (true) {
            p1[] p1VarArr = this.f4841v;
            if (i >= p1VarArr.length) {
                return;
            }
            if (uVar.b(i)) {
                p1VarArr[i].m();
            }
            i++;
        }
    }

    public final void t(IOException iOException, int i) {
        n nVar = new n(0, iOException, i);
        u0 u0Var = this.N.i;
        if (u0Var != null) {
            nVar = nVar.a(u0Var.f4908g.f4919a);
        }
        y1.b.h("ExoPlayerImplInternal", "Playback error", nVar);
        t0(false, false);
        this.f4822b0 = this.f4822b0.f(nVar);
    }

    public final void t0(boolean z10, boolean z11) {
        O(z10 || !this.f4832l0, false, true, false);
        this.f4823c0.f(z11 ? 1 : 0);
        this.A.j(this.R);
        this.V.d(1, this.f4822b0.f4759l);
        m0(1);
    }

    public final void u(boolean z10) {
        u0 u0Var = this.N.f4939l;
        s2.c0 c0Var = u0Var == null ? this.f4822b0.f4751b : u0Var.f4908g.f4919a;
        boolean zEquals = this.f4822b0.f4758k.equals(c0Var);
        if (!zEquals) {
            this.f4822b0 = this.f4822b0.c(c0Var);
        }
        i1 i1Var = this.f4822b0;
        i1Var.f4764q = u0Var == null ? i1Var.f4766s : u0Var.d();
        i1 i1Var2 = this.f4822b0;
        i1Var2.f4765r = p(i1Var2.f4764q);
        if ((!zEquals || z10) && u0Var != null && u0Var.f4907e) {
            w0(u0Var.f4914n, u0Var.f4915o);
        }
    }

    public final void u0() {
        k kVar = this.J;
        kVar.f4780w = false;
        f9.e1 e1Var = (f9.e1) kVar.f4781x;
        if (e1Var.f4093v) {
            e1Var.a(e1Var.h());
            e1Var.f4093v = false;
        }
        for (p1 p1Var : this.f4841v) {
            e eVar = (e) p1Var.f;
            e eVar2 = (e) p1Var.f4884e;
            if (p1.h(eVar2)) {
                p1.b(eVar2);
            }
            if (eVar != null && eVar.C != 0) {
                p1.b(eVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0436  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [v1.f1] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v19 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v20 */
    /* JADX WARN: Type inference failed for: r25v21 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r2v10, types: [v1.f1] */
    /* JADX WARN: Type inference failed for: r2v15, types: [g2.i1] */
    /* JADX WARN: Type inference failed for: r2v35, types: [g2.w0] */
    /* JADX WARN: Type inference failed for: r35v0, types: [g2.o0] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v25, types: [v1.f1] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(v1.f1 r36, boolean r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1091
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o0.v(v1.f1, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, s2.c1] */
    public final void v0() {
        u0 u0Var = this.N.f4939l;
        boolean z10 = this.f4829i0 || (u0Var != null && u0Var.f4903a.a());
        i1 i1Var = this.f4822b0;
        if (z10 != i1Var.f4755g) {
            this.f4822b0 = i1Var.b(z10);
        }
    }

    public final void w(s2.a0 a0Var) {
        u0 u0Var;
        w0 w0Var = this.N;
        u0 u0Var2 = w0Var.f4939l;
        k kVar = this.J;
        if (u0Var2 != null && u0Var2.f4903a == a0Var) {
            u0Var2.getClass();
            if (!u0Var2.f4907e) {
                float f = kVar.d().f12968a;
                i1 i1Var = this.f4822b0;
                u0Var2.f(f, i1Var.f4750a, i1Var.f4759l);
            }
            w0(u0Var2.f4914n, u0Var2.f4915o);
            if (u0Var2 == w0Var.i) {
                Q(u0Var2.f4908g.f4920b);
                l(new boolean[this.f4841v.length], w0Var.f4937j.e());
                u0Var2.f4909h = true;
                i1 i1Var2 = this.f4822b0;
                s2.c0 c0Var = i1Var2.f4751b;
                long j4 = u0Var2.f4908g.f4920b;
                this.f4822b0 = y(c0Var, j4, i1Var2.f4752c, j4, false, 5);
            }
            C();
            return;
        }
        int i = 0;
        while (true) {
            if (i >= w0Var.f4944q.size()) {
                u0Var = null;
                break;
            }
            u0Var = (u0) w0Var.f4944q.get(i);
            if (u0Var.f4903a == a0Var) {
                break;
            } else {
                i++;
            }
        }
        if (u0Var != null) {
            y1.d.g(true ^ u0Var.f4907e);
            float f10 = kVar.d().f12968a;
            i1 i1Var3 = this.f4822b0;
            u0Var.f(f10, i1Var3.f4750a, i1Var3.f4759l);
            u0 u0Var3 = w0Var.f4940m;
            if (u0Var3 == null || u0Var3.f4903a != a0Var) {
                return;
            }
            D();
        }
    }

    public final void w0(s2.l1 l1Var, v2.u uVar) {
        u0 u0Var = this.N.f4939l;
        u0Var.getClass();
        long jP = p(u0Var.d());
        long j4 = r0(this.f4822b0.f4750a, u0Var.f4908g.f4919a) ? this.P.f4728h : -9223372036854775807L;
        v1.f1 f1Var = this.f4822b0.f4750a;
        float f = this.J.d().f12968a;
        boolean z10 = this.f4822b0.f4759l;
        this.A.f(new p0(this.R, jP, f, this.f4827g0, j4), uVar.f13130c);
    }

    public final void x(v1.q0 q0Var, float f, boolean z10, boolean z11) {
        int i;
        if (z10) {
            if (z11) {
                this.f4823c0.f(1);
            }
            this.f4822b0 = this.f4822b0.g(q0Var);
        }
        float f10 = q0Var.f12968a;
        u0 u0Var = this.N.i;
        while (true) {
            i = 0;
            if (u0Var == null) {
                break;
            }
            v2.q[] qVarArr = u0Var.f4915o.f13130c;
            int length = qVarArr.length;
            while (i < length) {
                v2.q qVar = qVarArr[i];
                if (qVar != null) {
                    qVar.o(f10);
                }
                i++;
            }
            u0Var = u0Var.f4913m;
        }
        p1[] p1VarArr = this.f4841v;
        int length2 = p1VarArr.length;
        while (i < length2) {
            p1 p1Var = p1VarArr[i];
            float f11 = q0Var.f12968a;
            ((e) p1Var.f4884e).z(f, f11);
            e eVar = (e) p1Var.f;
            if (eVar != null) {
                eVar.z(f, f11);
            }
            i++;
        }
    }

    public final void x0(int i, int i10, List list) throws Throwable {
        this.f4823c0.f(1);
        h1 h1Var = this.O;
        h1Var.getClass();
        ArrayList arrayList = (ArrayList) h1Var.f4738c;
        y1.d.b(i >= 0 && i <= i10 && i10 <= arrayList.size());
        y1.d.b(list.size() == i10 - i);
        for (int i11 = i; i11 < i10; i11++) {
            ((g1) arrayList.get(i11)).f4717a.t((v1.g0) list.get(i11 - i));
        }
        v(h1Var.c(), false);
    }

    public final i1 y(s2.c0 c0Var, long j4, long j7, long j10, boolean z10, int i) {
        ua.z0 z0VarG;
        boolean z11;
        this.f4839t0 = (!this.f4839t0 && j4 == this.f4822b0.f4766s && c0Var.equals(this.f4822b0.f4751b)) ? false : true;
        P();
        i1 i1Var = this.f4822b0;
        s2.l1 l1Var = i1Var.f4756h;
        v2.u uVar = i1Var.i;
        List list = i1Var.f4757j;
        if (this.O.f4736a) {
            u0 u0Var = this.N.i;
            l1Var = u0Var == null ? s2.l1.f11260d : u0Var.f4914n;
            uVar = u0Var == null ? this.f4849z : u0Var.f4915o;
            v2.q[] qVarArr = uVar.f13130c;
            ua.f0 f0Var = new ua.f0(4);
            boolean z12 = false;
            for (v2.q qVar : qVarArr) {
                if (qVar != null) {
                    v1.l0 l0Var = qVar.c(0).f12944l;
                    if (l0Var == null) {
                        f0Var.a(new v1.l0(new v1.k0[0]));
                    } else {
                        f0Var.a(l0Var);
                        z12 = true;
                    }
                }
            }
            if (z12) {
                z0VarG = f0Var.g();
            } else {
                ua.g0 g0Var = ua.i0.f12341w;
                z0VarG = ua.z0.f12413z;
            }
            list = z0VarG;
            if (u0Var != null) {
                v0 v0Var = u0Var.f4908g;
                if (v0Var.f4921c != j7) {
                    u0Var.f4908g = v0Var.a(j7);
                }
            }
            p1[] p1VarArr = this.f4841v;
            w0 w0Var = this.N;
            u0 u0Var2 = w0Var.i;
            if (u0Var2 == w0Var.f4937j && u0Var2 != null) {
                v2.u uVar2 = u0Var2.f4915o;
                int i10 = 0;
                boolean z13 = false;
                while (true) {
                    if (i10 >= p1VarArr.length) {
                        z11 = true;
                        break;
                    }
                    if (uVar2.b(i10)) {
                        if (((e) p1VarArr[i10].f4884e).f4658w != 1) {
                            z11 = false;
                            break;
                        }
                        if (uVar2.f13129b[i10].f4852a != 0) {
                            z13 = true;
                        }
                    }
                    i10++;
                }
                boolean z14 = z13 && z11;
                if (z14 != this.f4834n0) {
                    this.f4834n0 = z14;
                    if (!z14 && this.f4822b0.f4763p) {
                        this.C.e(2);
                    }
                }
            }
        } else if (!c0Var.equals(i1Var.f4751b)) {
            l1Var = s2.l1.f11260d;
            uVar = this.f4849z;
            list = ua.z0.f12413z;
        }
        s2.l1 l1Var2 = l1Var;
        v2.u uVar3 = uVar;
        List list2 = list;
        if (z10) {
            l0 l0Var2 = this.f4823c0;
            if (!l0Var2.f4795d || l0Var2.f4796e == 5) {
                l0Var2.f4794c = true;
                l0Var2.f4795d = true;
                l0Var2.f4796e = i;
            } else {
                y1.d.b(i == 5);
            }
        }
        i1 i1Var2 = this.f4822b0;
        return i1Var2.d(c0Var, j4, j7, j10, p(i1Var2.f4764q), l1Var2, uVar3, list2);
    }

    public final void y0(int i, int i10, int i11, boolean z10) {
        boolean z11 = z10 && i != -1;
        if (i == -1) {
            i11 = 2;
        } else if (i11 == 2) {
            i11 = 1;
        }
        if (i == 0) {
            i10 = 1;
        } else if (i10 == 1) {
            i10 = 0;
        }
        i1 i1Var = this.f4822b0;
        if (i1Var.f4759l == z11 && i1Var.f4761n == i10 && i1Var.f4760m == i11) {
            return;
        }
        this.f4822b0 = i1Var.e(i11, i10, z11);
        B0(false, false);
        w0 w0Var = this.N;
        for (u0 u0Var = w0Var.i; u0Var != null; u0Var = u0Var.f4913m) {
            for (v2.q qVar : u0Var.f4915o.f13130c) {
                if (qVar != null) {
                    qVar.a(z11);
                }
            }
        }
        if (!q0()) {
            u0();
            z0();
            i1 i1Var2 = this.f4822b0;
            if (i1Var2.f4763p) {
                this.f4822b0 = i1Var2.i(false);
            }
            w0Var.m(this.f4836q0);
            return;
        }
        int i12 = this.f4822b0.f4754e;
        y1.x xVar = this.C;
        if (i12 != 3) {
            if (i12 == 2) {
                xVar.e(2);
            }
        } else {
            k kVar = this.J;
            kVar.f4780w = true;
            ((f9.e1) kVar.f4781x).b();
            s0();
            xVar.e(2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.Object, s2.a0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z0() {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.o0.z0():void");
    }
}
