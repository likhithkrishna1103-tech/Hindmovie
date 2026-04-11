package a2;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Handler.Callback, o2.a0, v1, u2.u {

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final long f478z0 = s1.b0.b0(10000);
    public final s2.d A;
    public final s1.y B;
    public final p7.m C;
    public final Looper D;
    public final p1.e1 E;
    public final p1.c1 F;
    public final long G;
    public final boolean H;
    public final m I;
    public final ArrayList J;
    public final s1.w K;
    public final e0 L;
    public final h1 M;
    public final t1 N;
    public final j O;
    public final long P;
    public final b2.o Q;
    public final b2.h R;
    public final s1.y S;
    public final boolean T;
    public final f U;
    public d2 V;
    public c2 W;
    public boolean X;
    public boolean Y;
    public w0 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public u1 f479a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public u0 f480b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f481c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f482d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f483e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f484f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f485g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f486h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f487i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f488j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f489k0;
    public boolean l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f490m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f491n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public w0 f492o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public long f493p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public long f494q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f495r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f496s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public q f497t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b2[] f498u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public long f499u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g[] f500v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public v f501v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean[] f502w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public long f503w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final r2.u f504x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f505x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r2.v f506y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public float f507y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a1 f508z;

    public x0(Context context, g[] gVarArr, g[] gVarArr2, r2.u uVar, r2.v vVar, a1 a1Var, s2.d dVar, int i, boolean z2, b2.h hVar, d2 d2Var, j jVar, long j5, Looper looper, s1.w wVar, e0 e0Var, b2.o oVar, final u2.u uVar2) {
        v vVar2 = v.f466a;
        this.f503w0 = -9223372036854775807L;
        this.L = e0Var;
        this.f504x = uVar;
        this.f506y = vVar;
        this.f508z = a1Var;
        this.A = dVar;
        this.f487i0 = i;
        this.f488j0 = z2;
        this.V = d2Var;
        this.O = jVar;
        this.P = j5;
        this.f482d0 = false;
        this.K = wVar;
        this.Q = oVar;
        this.f501v0 = vVar2;
        this.R = hVar;
        this.f507y0 = 1.0f;
        this.W = c2.f181b;
        this.f499u0 = -9223372036854775807L;
        this.f485g0 = -9223372036854775807L;
        this.G = a1Var.i();
        this.H = a1Var.c();
        p1.b1 b1Var = p1.f1.f9741a;
        u1 u1VarK = u1.k(vVar);
        this.f479a0 = u1VarK;
        this.f480b0 = new u0(u1VarK);
        this.f500v = new g[gVarArr.length];
        this.f502w = new boolean[gVarArr.length];
        r2.p pVar = (r2.p) uVar;
        pVar.getClass();
        this.f498u = new b2[gVarArr.length];
        boolean z10 = false;
        for (int i10 = 0; i10 < gVarArr.length; i10++) {
            g gVar = gVarArr[i10];
            gVar.f235y = i10;
            gVar.f236z = oVar;
            gVar.A = wVar;
            this.f500v[i10] = gVar;
            g gVar2 = this.f500v[i10];
            synchronized (gVar2.f231u) {
                gVar2.L = pVar;
            }
            g gVar3 = gVarArr2[i10];
            if (gVar3 != null) {
                gVar3.f235y = i10;
                gVar3.f236z = oVar;
                gVar3.A = wVar;
                z10 = true;
            }
            b2[] b2VarArr = this.f498u;
            g gVar4 = gVarArr[i10];
            b2 b2Var = new b2();
            b2Var.f171e = gVar4;
            b2Var.f169c = i10;
            b2Var.f = gVar3;
            b2Var.f170d = 0;
            b2Var.f167a = false;
            b2Var.f168b = false;
            b2VarArr[i10] = b2Var;
        }
        this.T = z10;
        this.I = new m(this, wVar);
        this.J = new ArrayList();
        this.E = new p1.e1();
        this.F = new p1.c1();
        s1.d.g(uVar.f11355a == null);
        uVar.f11355a = this;
        uVar.f11356b = dVar;
        this.f496s0 = true;
        s1.y yVarA = wVar.a(looper, null);
        this.S = yVarA;
        this.M = new h1(hVar, yVarA, new f0(5, this));
        this.N = new t1(this, hVar, yVarA, oVar);
        p7.m mVar = new p7.m();
        mVar.f10284v = new Object();
        mVar.f10285w = null;
        mVar.f10286x = null;
        mVar.f10283u = 0;
        this.C = mVar;
        Looper looperB = mVar.b();
        this.D = looperB;
        s1.y yVarA2 = wVar.a(looperB, this);
        this.B = yVarA2;
        this.U = new f(context, looperB, this);
        yVarA2.a(35, new u2.u() { // from class: a2.q0
            @Override // u2.u
            public final void c(long j8, long j10, p1.q qVar, MediaFormat mediaFormat) {
                x0 x0Var = this.f386u;
                x0Var.getClass();
                uVar2.c(j8, j10, qVar, mediaFormat);
                x0Var.c(j8, j10, qVar, mediaFormat);
            }
        }).b();
    }

    public static Pair S(p1.f1 f1Var, w0 w0Var, boolean z2, int i, boolean z10, p1.e1 e1Var, p1.c1 c1Var) {
        int iT;
        p1.f1 f1Var2 = w0Var.f472a;
        if (f1Var.p()) {
            return null;
        }
        p1.f1 f1Var3 = f1Var2.p() ? f1Var : f1Var2;
        try {
            Pair pairI = f1Var3.i(e1Var, c1Var, w0Var.f473b, w0Var.f474c);
            if (!f1Var.equals(f1Var3)) {
                if (f1Var.b(pairI.first) == -1) {
                    if (!z2 || (iT = T(e1Var, c1Var, i, z10, pairI.first, f1Var3, f1Var)) == -1) {
                        return null;
                    }
                    return f1Var.i(e1Var, c1Var, iT, -9223372036854775807L);
                }
                if (f1Var3.g(pairI.first, c1Var).f && f1Var3.m(c1Var.f9678c, e1Var, 0L).f9724n == f1Var3.b(pairI.first)) {
                    return f1Var.i(e1Var, c1Var, f1Var.g(pairI.first, c1Var).f9678c, w0Var.f474c);
                }
            }
            return pairI;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static int T(p1.e1 e1Var, p1.c1 c1Var, int i, boolean z2, Object obj, p1.f1 f1Var, p1.f1 f1Var2) {
        p1.e1 e1Var2 = e1Var;
        p1.f1 f1Var3 = f1Var;
        Object obj2 = f1Var3.m(f1Var3.g(obj, c1Var).f9678c, e1Var, 0L).f9713a;
        for (int i10 = 0; i10 < f1Var2.o(); i10++) {
            if (f1Var2.m(i10, e1Var, 0L).f9713a.equals(obj2)) {
                return i10;
            }
        }
        int iB = f1Var3.b(obj);
        int iH = f1Var3.h();
        int iB2 = -1;
        int i11 = 0;
        while (i11 < iH && iB2 == -1) {
            p1.f1 f1Var4 = f1Var3;
            int iD = f1Var4.d(iB, c1Var, e1Var2, i, z2);
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
        return f1Var2.f(iB2, c1Var, false).f9678c;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, o2.b0, o2.e1] */
    public static boolean z(e1 e1Var) {
        if (e1Var != null) {
            try {
                ?? r12 = e1Var.f193a;
                if (e1Var.f197e) {
                    for (o2.c1 c1Var : e1Var.f195c) {
                        if (c1Var != null) {
                            c1Var.b();
                        }
                    }
                } else {
                    r12.s();
                }
                if ((!e1Var.f197e ? 0L : r12.g()) != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public final boolean A(int i, o2.d0 d0Var) {
        h1 h1Var = this.M;
        e1 e1Var = h1Var.f265k;
        if (e1Var != null && e1Var.f198g.f221a.equals(d0Var)) {
            b2 b2Var = this.f498u[i];
            e1 e1Var2 = h1Var.f265k;
            int i10 = b2Var.f170d;
            boolean z2 = (i10 == 2 || i10 == 4) && b2Var.d(e1Var2) == ((g) b2Var.f171e);
            boolean z10 = b2Var.f170d == 3 && b2Var.d(e1Var2) == ((g) b2Var.f);
            if (z2 || z10) {
                return true;
            }
        }
        return false;
    }

    public final void A0(p1.f1 f1Var, o2.d0 d0Var, p1.f1 f1Var2, o2.d0 d0Var2, long j5, boolean z2) {
        boolean zR0 = r0(f1Var, d0Var);
        Object obj = d0Var.f9090a;
        if (!zR0) {
            p1.q0 q0Var = d0Var.b() ? p1.q0.f10036d : this.f479a0.f460o;
            m mVar = this.I;
            if (mVar.h().equals(q0Var)) {
                return;
            }
            this.B.d(16);
            mVar.e(q0Var);
            x(this.f479a0.f460o, q0Var.f10038a, false, false);
            return;
        }
        p1.c1 c1Var = this.F;
        int i = f1Var.g(obj, c1Var).f9678c;
        p1.e1 e1Var = this.E;
        f1Var.n(i, e1Var);
        p1.b0 b0Var = e1Var.f9720j;
        j jVar = this.O;
        jVar.getClass();
        jVar.f284c = s1.b0.O(b0Var.f9653a);
        jVar.f = s1.b0.O(b0Var.f9654b);
        jVar.f287g = s1.b0.O(b0Var.f9655c);
        float f = b0Var.f9656d;
        if (f == -3.4028235E38f) {
            f = 0.97f;
        }
        jVar.f289j = f;
        float f4 = b0Var.f9657e;
        if (f4 == -3.4028235E38f) {
            f4 = 1.03f;
        }
        jVar.i = f4;
        if (f == 1.0f && f4 == 1.0f) {
            jVar.f284c = -9223372036854775807L;
        }
        jVar.a();
        if (j5 != -9223372036854775807L) {
            jVar.f285d = l(f1Var, obj, j5);
            jVar.a();
            return;
        }
        if (!Objects.equals(!f1Var2.p() ? f1Var2.m(f1Var2.g(d0Var2.f9090a, c1Var).f9678c, e1Var, 0L).f9713a : null, e1Var.f9713a) || z2) {
            jVar.f285d = -9223372036854775807L;
            jVar.a();
        }
    }

    public final boolean B() {
        e1 e1Var = this.M.i;
        long j5 = e1Var.f198g.f225e;
        if (e1Var.f197e) {
            return j5 == -9223372036854775807L || this.f479a0.f464s < j5 || !q0();
        }
        return false;
    }

    public final void B0(boolean z2, boolean z10) {
        long jElapsedRealtime;
        this.f484f0 = z2;
        if (!z2 || z10) {
            jElapsedRealtime = -9223372036854775807L;
        } else {
            this.K.getClass();
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.f485g0 = jElapsedRealtime;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object, o2.b0] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.Object, o2.e1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, o2.e1] */
    public final void C() {
        boolean zJ;
        if (z(this.M.f266l)) {
            e1 e1Var = this.M.f266l;
            long jP = p(!e1Var.f197e ? 0L : e1Var.f193a.g());
            e1 e1Var2 = this.M.i;
            long j5 = r0(this.f479a0.f448a, e1Var.f198g.f221a) ? this.O.f288h : -9223372036854775807L;
            b2.o oVar = this.Q;
            p1.f1 f1Var = this.f479a0.f448a;
            float f = this.I.h().f10038a;
            boolean z2 = this.f479a0.f457l;
            z0 z0Var = new z0(oVar, jP, f, this.f484f0, j5);
            zJ = this.f508z.j(z0Var);
            e1 e1Var3 = this.M.i;
            if (!zJ && e1Var3.f197e && jP < 500000 && (this.G > 0 || this.H)) {
                e1Var3.f193a.h(false, this.f479a0.f464s);
                zJ = this.f508z.j(z0Var);
            }
        } else {
            zJ = false;
        }
        this.f486h0 = zJ;
        if (zJ) {
            e1 e1Var4 = this.M.f266l;
            e1Var4.getClass();
            b1 b1Var = new b1();
            b1Var.f164a = this.f493p0 - e1Var4.f206p;
            float f4 = this.I.h().f10038a;
            s1.d.b(f4 > 0.0f || f4 == -3.4028235E38f);
            b1Var.f165b = f4;
            long j8 = this.f485g0;
            s1.d.b(j8 >= 0 || j8 == -9223372036854775807L);
            b1Var.f166c = j8;
            c1 c1Var = new c1(b1Var);
            s1.d.g(e1Var4.f203m == null);
            e1Var4.f193a.l(c1Var);
        }
        v0();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, o2.b0, o2.e1] */
    public final void D() {
        h1 h1Var = this.M;
        h1Var.k();
        e1 e1Var = h1Var.f267m;
        if (e1Var != null) {
            ?? r12 = e1Var.f193a;
            if ((!e1Var.f196d || e1Var.f197e) && !r12.c()) {
                p1.f1 f1Var = this.f479a0.f448a;
                if (e1Var.f197e) {
                    r12.r();
                }
                if (this.f508z.e()) {
                    if (!e1Var.f196d) {
                        long j5 = e1Var.f198g.f222b;
                        e1Var.f196d = true;
                        r12.o(this, j5);
                        return;
                    }
                    b1 b1Var = new b1();
                    b1Var.f164a = this.f493p0 - e1Var.f206p;
                    float f = this.I.h().f10038a;
                    s1.d.b(f > 0.0f || f == -3.4028235E38f);
                    b1Var.f165b = f;
                    long j8 = this.f485g0;
                    s1.d.b(j8 >= 0 || j8 == -9223372036854775807L);
                    b1Var.f166c = j8;
                    c1 c1Var = new c1(b1Var);
                    s1.d.g(e1Var.f203m == null);
                    r12.l(c1Var);
                }
            }
        }
    }

    public final void E() {
        u0 u0Var = this.f480b0;
        u1 u1Var = this.f479a0;
        boolean z2 = u0Var.f444c | (((u1) u0Var.f) != u1Var);
        u0Var.f444c = z2;
        u0Var.f = u1Var;
        if (z2) {
            o0 o0Var = this.L.f192v;
            o0Var.E.c(new g0(o0Var, 0, u0Var));
            this.f480b0 = new u0(this.f479a0);
        }
    }

    public final void F(int i) {
        b2 b2Var = this.f498u[i];
        try {
            e1 e1Var = this.M.i;
            e1Var.getClass();
            g gVarD = b2Var.d(e1Var);
            gVarD.getClass();
            o2.c1 c1Var = gVarD.C;
            c1Var.getClass();
            c1Var.b();
        } catch (IOException | RuntimeException e10) {
            int i10 = ((g) b2Var.f171e).f232v;
            if (i10 != 3 && i10 != 5) {
                throw e10;
            }
            r2.v vVar = this.M.i.f205o;
            s1.b.h("ExoPlayerImplInternal", "Disabling track due to error: " + p1.q.c(vVar.f11359c[i].l()), e10);
            r2.v vVar2 = new r2.v((a2[]) vVar.f11358b.clone(), (r2.r[]) vVar.f11359c.clone(), vVar.f11360d, vVar.f11361e);
            vVar2.f11358b[i] = null;
            vVar2.f11359c[i] = null;
            h(i);
            e1 e1Var2 = this.M.i;
            e1Var2.a(vVar2, this.f479a0.f464s, false, new boolean[e1Var2.f200j.length]);
        }
    }

    public final void G(int i, boolean z2) {
        boolean[] zArr = this.f502w;
        if (zArr[i] != z2) {
            zArr[i] = z2;
            this.S.c(new p0(this, i, z2));
        }
    }

    public final void H() throws Throwable {
        v(this.N.c(), true);
    }

    public final void I(t0 t0Var) throws Throwable {
        p1.f1 f1VarC;
        this.f480b0.f(1);
        int i = t0Var.f407a;
        int i10 = t0Var.f408b;
        int i11 = t0Var.f409c;
        o2.f1 f1Var = t0Var.f410d;
        t1 t1Var = this.N;
        ArrayList arrayList = (ArrayList) t1Var.f413c;
        s1.d.b(i >= 0 && i <= i10 && i10 <= arrayList.size() && i11 >= 0);
        t1Var.f419k = f1Var;
        if (i == i10 || i == i11) {
            f1VarC = t1Var.c();
        } else {
            int iMin = Math.min(i, i11);
            int iMax = Math.max(((i10 - i) + i11) - 1, i10 - 1);
            int iO = ((s1) arrayList.get(iMin)).f404d;
            s1.b0.N(arrayList, i, i10, i11);
            while (iMin <= iMax) {
                s1 s1Var = (s1) arrayList.get(iMin);
                s1Var.f404d = iO;
                iO += s1Var.f401a.I.f9206e.o();
                iMin++;
            }
            f1VarC = t1Var.c();
        }
        v(f1VarC, false);
    }

    public final void J() {
        this.f480b0.f(1);
        O(false, false, false, true);
        this.f508z.h(this.Q);
        m0(this.f479a0.f448a.p() ? 4 : 2);
        u1 u1Var = this.f479a0;
        boolean z2 = u1Var.f457l;
        y0(this.U.d(u1Var.f452e, z2), u1Var.f459n, u1Var.f458m, z2);
        s2.g gVar = (s2.g) this.A;
        gVar.getClass();
        t1 t1Var = this.N;
        ArrayList arrayList = (ArrayList) t1Var.f413c;
        s1.d.g(!t1Var.f411a);
        t1Var.f420l = gVar;
        for (int i = 0; i < arrayList.size(); i++) {
            s1 s1Var = (s1) arrayList.get(i);
            t1Var.g(s1Var);
            ((HashSet) t1Var.f417h).add(s1Var);
        }
        t1Var.f411a = true;
        this.B.e(2);
    }

    public final void K(s1.g gVar) {
        p7.m mVar = this.C;
        s1.y yVar = this.B;
        try {
            O(true, false, true, false);
            L();
            this.f508z.b(this.Q);
            f fVar = this.U;
            fVar.f214c = null;
            fVar.a();
            fVar.c(0);
            this.f504x.a();
            m0(1);
        } finally {
            yVar.f11718a.removeCallbacksAndMessages(null);
            mVar.c();
            gVar.e();
        }
    }

    public final void L() {
        for (int i = 0; i < this.f498u.length; i++) {
            g gVar = this.f500v[i];
            synchronized (gVar.f231u) {
                gVar.L = null;
            }
            b2 b2Var = this.f498u[i];
            g gVar2 = (g) b2Var.f171e;
            s1.d.g(gVar2.B == 0);
            gVar2.r();
            b2Var.f167a = false;
            g gVar3 = (g) b2Var.f;
            if (gVar3 != null) {
                s1.d.g(gVar3.B == 0);
                gVar3.r();
                b2Var.f168b = false;
            }
        }
    }

    public final void M(int i, int i10, o2.f1 f1Var) throws Throwable {
        this.f480b0.f(1);
        t1 t1Var = this.N;
        t1Var.getClass();
        s1.d.b(i >= 0 && i <= i10 && i10 <= ((ArrayList) t1Var.f413c).size());
        t1Var.f419k = f1Var;
        t1Var.i(i, i10);
        v(t1Var.c(), false);
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
        throw new UnsupportedOperationException("Method not decompiled: a2.x0.N():void");
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
        throw new UnsupportedOperationException("Method not decompiled: a2.x0.O(boolean, boolean, boolean, boolean):void");
    }

    public final void P() {
        e1 e1Var = this.M.i;
        this.f483e0 = e1Var != null && e1Var.f198g.i && this.f482d0;
    }

    public final void Q(long j5) {
        e1 e1Var = this.M.i;
        long j8 = j5 + (e1Var == null ? 1000000000000L : e1Var.f206p);
        this.f493p0 = j8;
        ((e2) this.I.f318w).a(j8);
        for (b2 b2Var : this.f498u) {
            long j10 = this.f493p0;
            g gVarD = b2Var.d(e1Var);
            if (gVarD != null) {
                gVarD.H = false;
                gVarD.F = j10;
                gVarD.G = j10;
                gVarD.q(false, j10);
            }
        }
        for (e1 e1Var2 = r0.i; e1Var2 != null; e1Var2 = e1Var2.f203m) {
            for (r2.r rVar : e1Var2.f205o.f11359c) {
                if (rVar != null) {
                    rVar.r();
                }
            }
        }
    }

    public final void R(p1.f1 f1Var, p1.f1 f1Var2) {
        if (f1Var.p() && f1Var2.p()) {
            return;
        }
        ArrayList arrayList = this.J;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            l4.a.t(arrayList.get(size));
            throw null;
        }
    }

    public final void U(long j5) {
        boolean z2 = this.X;
        long j8 = f478z0;
        if (z2) {
            this.W.getClass();
            jMin = this.f479a0.f452e != 3 ? j8 : 1000L;
            for (b2 b2Var : this.f498u) {
                long j10 = this.f493p0;
                long j11 = this.f494q0;
                g gVar = (g) b2Var.f;
                g gVar2 = (g) b2Var.f171e;
                long jD = b2.h(gVar2) ? gVar2.d(j10, j11) : Long.MAX_VALUE;
                if (gVar != null && gVar.B != 0) {
                    jD = Math.min(jD, gVar.d(j10, j11));
                }
                jMin = Math.min(jMin, s1.b0.b0(jD));
            }
            if (this.f479a0.m()) {
                e1 e1Var = this.M.i;
                if ((e1Var != null ? e1Var.f203m : null) != null) {
                    if ((s1.b0.O(jMin) * this.f479a0.f460o.f10038a) + this.f493p0 >= r1.e()) {
                        jMin = Math.min(jMin, j8);
                    }
                }
            }
        } else if (this.f479a0.f452e != 3 || q0()) {
            jMin = j8;
        }
        this.B.f11718a.sendEmptyMessageAtTime(2, j5 + jMin);
    }

    public final void V(boolean z2) {
        o2.d0 d0Var = this.M.i.f198g.f221a;
        long jX = X(d0Var, this.f479a0.f464s, true, false);
        if (jX != this.f479a0.f464s) {
            u1 u1Var = this.f479a0;
            this.f479a0 = y(d0Var, jX, u1Var.f450c, u1Var.f451d, z2, 5);
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
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Object, o2.b0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W(a2.w0 r18, boolean r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.x0.W(a2.w0, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object, o2.b0] */
    public final long X(o2.d0 d0Var, long j5, boolean z2, boolean z10) {
        b2[] b2VarArr;
        u0();
        B0(false, true);
        if (z10 || this.f479a0.f452e == 3) {
            m0(2);
        }
        h1 h1Var = this.M;
        e1 e1Var = h1Var.i;
        e1 e1Var2 = e1Var;
        while (e1Var2 != null && !d0Var.equals(e1Var2.f198g.f221a)) {
            e1Var2 = e1Var2.f203m;
        }
        if (z2 || e1Var != e1Var2 || (e1Var2 != null && e1Var2.f206p + j5 < 0)) {
            int i = 0;
            while (true) {
                b2VarArr = this.f498u;
                if (i >= b2VarArr.length) {
                    break;
                }
                h(i);
                i++;
            }
            this.f503w0 = -9223372036854775807L;
            if (e1Var2 != null) {
                while (h1Var.i != e1Var2) {
                    h1Var.a();
                }
                h1Var.n(e1Var2);
                e1Var2.f206p = 1000000000000L;
                k(new boolean[b2VarArr.length], h1Var.f264j.e());
                e1Var2.f199h = true;
            }
        }
        g();
        if (e1Var2 != null) {
            ?? r10 = e1Var2.f193a;
            h1Var.n(e1Var2);
            if (!e1Var2.f197e) {
                e1Var2.f198g = e1Var2.f198g.b(j5);
            } else if (e1Var2.f) {
                j5 = r10.t(j5);
                r10.h(this.H, j5 - this.G);
            }
            Q(j5);
            C();
        } else {
            h1Var.b();
            Q(j5);
        }
        u(false);
        this.B.e(2);
        return j5;
    }

    public final void Y(x1 x1Var) {
        x1Var.getClass();
        s1.y yVar = this.B;
        if (x1Var.f513e != this.D) {
            yVar.a(15, x1Var).b();
            return;
        }
        synchronized (x1Var) {
        }
        try {
            x1Var.f509a.b(x1Var.f511c, x1Var.f512d);
            x1Var.a(true);
            int i = this.f479a0.f452e;
            if (i == 3 || i == 2) {
                yVar.e(2);
            }
        } catch (Throwable th) {
            x1Var.a(true);
            throw th;
        }
    }

    public final void Z(x1 x1Var) {
        Looper looper = x1Var.f513e;
        if (looper.getThread().isAlive()) {
            this.K.a(looper, null).c(new a(this, x1Var));
        } else {
            s1.b.p("TAG", "Trying to send message on a dead thread.");
            x1Var.a(false);
        }
    }

    public final void a(s0 s0Var, int i) throws Throwable {
        this.f480b0.f(1);
        t1 t1Var = this.N;
        if (i == -1) {
            i = ((ArrayList) t1Var.f413c).size();
        }
        v(t1Var.a(i, s0Var.f397a, s0Var.f398b), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(p1.d r7, boolean r8) {
        /*
            r6 = this;
            r2.u r0 = r6.f504x
            r2.p r0 = (r2.p) r0
            p1.d r1 = r0.i
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
            a2.f r8 = r6.U
            p1.d r0 = r8.f215d
            boolean r0 = java.util.Objects.equals(r0, r7)
            if (r0 != 0) goto L53
            r8.f215d = r7
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L28
        L26:
            r3 = r0
            goto L47
        L28:
            int r2 = r7.f9690c
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
            e6.j.p(r2, r7, r5)
            goto L26
        L37:
            r3 = 4
            goto L47
        L39:
            int r7 = r7.f9688a
            if (r7 != r1) goto L47
        L3d:
            r3 = r4
            goto L47
        L3f:
            r3 = r1
            goto L47
        L41:
            java.lang.String r7 = "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default."
            s1.b.p(r5, r7)
            goto L3f
        L47:
            r8.f = r3
            if (r3 == r1) goto L4d
            if (r3 != 0) goto L4e
        L4d:
            r0 = r1
        L4e:
            java.lang.String r7 = "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME."
            s1.d.a(r7, r0)
        L53:
            a2.u1 r7 = r6.f479a0
            boolean r0 = r7.f457l
            int r1 = r7.f459n
            int r2 = r7.f458m
            int r7 = r7.f452e
            int r7 = r8.d(r7, r0)
            r6.y0(r7, r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.x0.a0(p1.d, boolean):void");
    }

    public final void b() {
        for (b2 b2Var : this.f498u) {
            c2 c2Var = this.X ? this.W : null;
            ((g) b2Var.f171e).b(18, c2Var);
            g gVar = (g) b2Var.f;
            if (gVar != null) {
                gVar.b(18, c2Var);
            }
        }
    }

    public final void b0(boolean z2, s1.g gVar) {
        if (this.f489k0 != z2) {
            this.f489k0 = z2;
            if (!z2) {
                for (b2 b2Var : this.f498u) {
                    b2Var.k();
                }
            }
        }
        if (gVar != null) {
            gVar.e();
        }
    }

    @Override // u2.u
    public final void c(long j5, long j8, p1.q qVar, MediaFormat mediaFormat) {
        if (this.Y) {
            s1.y yVar = this.B;
            yVar.getClass();
            s1.x xVarB = s1.y.b();
            xVarB.f11716a = yVar.f11718a.obtainMessage(37);
            xVarB.b();
        }
    }

    public final void c0(s0 s0Var) throws Throwable {
        this.f480b0.f(1);
        int i = s0Var.f399c;
        o2.f1 f1Var = s0Var.f398b;
        ArrayList arrayList = s0Var.f397a;
        if (i != -1) {
            this.f492o0 = new w0(new z1(arrayList, f1Var), s0Var.f399c, s0Var.f400d);
        }
        t1 t1Var = this.N;
        ArrayList arrayList2 = (ArrayList) t1Var.f413c;
        t1Var.i(0, arrayList2.size());
        v(t1Var.a(arrayList2.size(), arrayList, f1Var), false);
    }

    @Override // o2.d1
    public final void d(o2.e1 e1Var) {
        this.B.a(9, (o2.b0) e1Var).b();
    }

    public final void d0(boolean z2) {
        this.f482d0 = z2;
        P();
        if (this.f483e0) {
            h1 h1Var = this.M;
            if (h1Var.f264j != h1Var.i) {
                V(true);
                u(false);
            }
        }
    }

    public final boolean e() {
        if (!this.T) {
            return false;
        }
        for (b2 b2Var : this.f498u) {
            if (b2Var.f()) {
                return true;
            }
        }
        return false;
    }

    public final void e0(p1.q0 q0Var) {
        this.B.d(16);
        m mVar = this.I;
        mVar.e(q0Var);
        p1.q0 q0VarH = mVar.h();
        x(q0VarH, q0VarH.f10038a, true, true);
    }

    public final void f() {
        N();
        V(true);
    }

    public final void f0(v vVar) {
        this.f501v0 = vVar;
        p1.f1 f1Var = this.f479a0.f448a;
        h1 h1Var = this.M;
        h1Var.getClass();
        vVar.getClass();
        if (h1Var.f271q.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < h1Var.f271q.size(); i++) {
            ((e1) h1Var.f271q.get(i)).i();
        }
        h1Var.f271q = arrayList;
        h1Var.f267m = null;
        h1Var.k();
    }

    public final void g() {
        g gVar;
        if (this.T && e()) {
            for (b2 b2Var : this.f498u) {
                int iC = b2Var.c();
                if (b2Var.f()) {
                    int i = b2Var.f170d;
                    boolean z2 = i == 4 || i == 2;
                    int i10 = i != 4 ? 0 : 1;
                    if (z2) {
                        gVar = (g) b2Var.f171e;
                    } else {
                        gVar = (g) b2Var.f;
                        gVar.getClass();
                    }
                    b2Var.a(gVar, this.I);
                    b2Var.i(z2);
                    b2Var.f170d = i10;
                }
                this.f491n0 -= iC - b2Var.c();
            }
            this.f503w0 = -9223372036854775807L;
        }
    }

    public final void g0(int i) {
        this.f487i0 = i;
        p1.f1 f1Var = this.f479a0.f448a;
        h1 h1Var = this.M;
        h1Var.f262g = i;
        int iR = h1Var.r(f1Var);
        if ((iR & 1) != 0) {
            V(true);
        } else if ((iR & 2) != 0) {
            g();
        }
        u(false);
    }

    public final void h(int i) {
        b2[] b2VarArr = this.f498u;
        int iC = b2VarArr[i].c();
        b2 b2Var = b2VarArr[i];
        g gVar = (g) b2Var.f171e;
        m mVar = this.I;
        b2Var.a(gVar, mVar);
        g gVar2 = (g) b2Var.f;
        if (gVar2 != null) {
            boolean z2 = (gVar2.B == 0 || b2Var.f170d == 3) ? false : true;
            b2Var.a(gVar2, mVar);
            b2Var.i(false);
            if (z2) {
                g gVar3 = (g) b2Var.f171e;
                gVar2.getClass();
                gVar2.b(17, gVar3);
            }
        }
        b2Var.f170d = 0;
        G(i, false);
        this.f491n0 -= iC;
    }

    public final void h0(boolean z2) throws Throwable {
        if (!z2) {
            this.Y = false;
            this.B.d(37);
            w0 w0Var = this.Z;
            if (w0Var != null) {
                W(w0Var, false);
                this.Z = null;
            }
        }
        this.X = z2;
        b();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        int i;
        int i10;
        e1 e1Var;
        o2.d0 d0Var;
        e1 e1Var2;
        try {
            switch (message.what) {
                case 1:
                    boolean z2 = message.arg1 != 0;
                    int i11 = message.arg2;
                    this.f480b0.f(1);
                    y0(this.U.d(this.f479a0.f452e, z2), i11 >> 4, i11 & 15, z2);
                    break;
                case 2:
                    i();
                    break;
                case 3:
                    W((w0) message.obj, true);
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    e0((p1.q0) message.obj);
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    j0((d2) message.obj);
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    t0(false, true);
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    K((s1.g) message.obj);
                    return true;
                case 8:
                    w((o2.b0) message.obj);
                    break;
                case 9:
                    s((o2.b0) message.obj);
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
                    b0(message.arg1 != 0, (s1.g) message.obj);
                    break;
                case 14:
                    Y((x1) message.obj);
                    break;
                case 15:
                    Z((x1) message.obj);
                    break;
                case 16:
                    p1.q0 q0Var = (p1.q0) message.obj;
                    x(q0Var, q0Var.f10038a, true, false);
                    break;
                case 17:
                    c0((s0) message.obj);
                    break;
                case 18:
                    a((s0) message.obj, message.arg1);
                    break;
                case 19:
                    I((t0) message.obj);
                    break;
                case 20:
                    M(message.arg1, message.arg2, (o2.f1) message.obj);
                    break;
                case 21:
                    l0((o2.f1) message.obj);
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
                    f();
                    break;
                case 26:
                    N();
                    V(true);
                    break;
                case 27:
                    x0(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    f0((v) message.obj);
                    break;
                case 29:
                    J();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    o0(pair.first, (s1.g) pair.second);
                    break;
                case 31:
                    a0((p1.d) message.obj, message.arg1 != 0);
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
                    n0((u2.u) message.obj);
                    break;
                case 36:
                    h0(((Boolean) message.obj).booleanValue());
                    break;
                case 37:
                    this.Y = false;
                    w0 w0Var = this.Z;
                    if (w0Var != null) {
                        W(w0Var, false);
                        this.Z = null;
                    }
                    break;
                case 38:
                    i0((c2) message.obj);
                    break;
            }
        } catch (q e10) {
            e = e10;
            int i12 = e.D;
            h1 h1Var = this.M;
            if (i12 == 1 && (e1Var2 = h1Var.f264j) != null && e.I == null) {
                e = e.a(e1Var2.f198g.f221a);
            }
            int i13 = e.D;
            s1.y yVar = this.B;
            if (i13 == 1 && (d0Var = e.I) != null && A(e.F, d0Var)) {
                this.f505x0 = true;
                g();
                e1 e1VarG = h1Var.g();
                e1 e1Var3 = h1Var.i;
                if (e1Var3 != e1VarG) {
                    while (e1Var3 != null) {
                        e1 e1Var4 = e1Var3.f203m;
                        if (e1Var4 == e1VarG) {
                            break;
                        }
                        e1Var3 = e1Var4;
                    }
                }
                h1Var.n(e1Var3);
                if (this.f479a0.f452e != 4) {
                    C();
                    yVar.e(2);
                }
            } else {
                q qVar = this.f497t0;
                if (qVar != null) {
                    qVar.addSuppressed(e);
                    e = this.f497t0;
                }
                if (e.D == 1 && h1Var.i != h1Var.f264j) {
                    while (true) {
                        e1Var = h1Var.i;
                        if (e1Var == h1Var.f264j) {
                            break;
                        }
                        h1Var.a();
                    }
                    s1.d.d(e1Var);
                    E();
                    f1 f1Var = e1Var.f198g;
                    o2.d0 d0Var2 = f1Var.f221a;
                    long j5 = f1Var.f222b;
                    this.f479a0 = y(d0Var2, j5, f1Var.f223c, j5, true, 0);
                }
                if (e.J && (this.f497t0 == null || (i10 = e.f9984u) == 5004 || i10 == 5003)) {
                    s1.b.q("ExoPlayerImplInternal", "Recoverable renderer error", e);
                    if (this.f497t0 == null) {
                        this.f497t0 = e;
                    }
                    s1.x xVarA = yVar.a(25, e);
                    Handler handler = yVar.f11718a;
                    Message message2 = xVarA.f11716a;
                    message2.getClass();
                    handler.sendMessageAtFrontOfQueue(message2);
                    xVarA.a();
                } else {
                    s1.b.h("ExoPlayerImplInternal", "Playback error", e);
                    t0(true, false);
                    this.f479a0 = this.f479a0.f(e);
                }
            }
        } catch (f2.g e11) {
            t(e11.f4733u, e11);
        } catch (RuntimeException e12) {
            q qVar2 = new q(2, e12, ((e12 instanceof IllegalStateException) || (e12 instanceof IllegalArgumentException)) ? 1004 : 1000);
            s1.b.h("ExoPlayerImplInternal", "Playback error", qVar2);
            t0(true, false);
            this.f479a0 = this.f479a0.f(qVar2);
        } catch (o2.b e13) {
            t(1002, e13);
        } catch (p1.n0 e14) {
            boolean z10 = e14.f9948u;
            int i14 = e14.f9949v;
            if (i14 == 1) {
                i = z10 ? 3001 : 3003;
            } else {
                if (i14 == 4) {
                    i = z10 ? 3002 : 3004;
                }
                t(i, e14);
            }
            i = i;
            t(i, e14);
        } catch (v1.j e15) {
            t(e15.f13144u, e15);
        } catch (IOException e16) {
            t(2000, e16);
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
    /* JADX WARN: Type inference failed for: r1v74, types: [java.lang.Object, o2.b0] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, o2.b0] */
    /* JADX WARN: Type inference failed for: r2v70, types: [java.lang.Object, o2.b0] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, o2.b0] */
    /* JADX WARN: Type inference failed for: r4v33, types: [java.lang.Object, o2.b0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 2244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.x0.i():void");
    }

    public final void i0(c2 c2Var) {
        this.W = c2Var;
        b();
    }

    public final void j(e1 e1Var, int i, boolean z2, long j5) {
        b2 b2Var = this.f498u[i];
        boolean zG = b2Var.g();
        g gVar = (g) b2Var.f171e;
        if (zG) {
            return;
        }
        boolean z10 = e1Var == this.M.i;
        r2.v vVar = e1Var.f205o;
        a2 a2Var = vVar.f11358b[i];
        r2.r rVar = vVar.f11359c[i];
        boolean z11 = q0() && this.f479a0.f452e == 3;
        boolean z12 = !z2 && z11;
        this.f491n0++;
        o2.c1 c1Var = e1Var.f195c[i];
        long j8 = e1Var.f206p;
        o2.d0 d0Var = e1Var.f198g.f221a;
        g gVar2 = (g) b2Var.f;
        int length = rVar != null ? rVar.length() : 0;
        p1.q[] qVarArr = new p1.q[length];
        for (int i10 = 0; i10 < length; i10++) {
            rVar.getClass();
            qVarArr[i10] = rVar.c(i10);
        }
        int i11 = b2Var.f170d;
        m mVar = this.I;
        if (i11 == 0 || i11 == 2 || i11 == 4) {
            b2Var.f167a = true;
            s1.d.g(gVar.B == 0);
            gVar.f234x = a2Var;
            gVar.K = d0Var;
            gVar.B = 1;
            gVar.p(z12, z10);
            gVar.y(qVarArr, c1Var, j5, j8, d0Var);
            gVar.H = false;
            gVar.F = j5;
            gVar.G = j5;
            gVar.q(z12, j5);
            mVar.a(gVar);
        } else {
            b2Var.f168b = true;
            gVar2.getClass();
            s1.d.g(gVar2.B == 0);
            gVar2.f234x = a2Var;
            gVar2.K = d0Var;
            gVar2.B = 1;
            gVar2.p(z12, z10);
            gVar2.y(qVarArr, c1Var, j5, j8, d0Var);
            gVar2.H = false;
            gVar2.F = j5;
            gVar2.G = j5;
            gVar2.q(z12, j5);
            mVar.a(gVar2);
        }
        r0 r0Var = new r0(this);
        g gVarD = b2Var.d(e1Var);
        gVarD.getClass();
        gVarD.b(11, r0Var);
        if (z11 && z10) {
            b2Var.m();
        }
    }

    public final void j0(d2 d2Var) {
        this.V = d2Var;
    }

    public final void k(boolean[] zArr, long j5) {
        b2[] b2VarArr;
        long j8;
        e1 e1Var = this.M.f264j;
        r2.v vVar = e1Var.f205o;
        int i = 0;
        while (true) {
            b2VarArr = this.f498u;
            if (i >= b2VarArr.length) {
                break;
            }
            if (!vVar.b(i)) {
                b2VarArr[i].k();
            }
            i++;
        }
        int i10 = 0;
        while (i10 < b2VarArr.length) {
            if (vVar.b(i10) && b2VarArr[i10].d(e1Var) == null) {
                j8 = j5;
                j(e1Var, i10, zArr[i10], j8);
            } else {
                j8 = j5;
            }
            i10++;
            j5 = j8;
        }
    }

    public final void k0(boolean z2) {
        this.f488j0 = z2;
        p1.f1 f1Var = this.f479a0.f448a;
        h1 h1Var = this.M;
        h1Var.f263h = z2;
        int iR = h1Var.r(f1Var);
        if ((iR & 1) != 0) {
            V(true);
        } else if ((iR & 2) != 0) {
            g();
        }
        u(false);
    }

    public final long l(p1.f1 f1Var, Object obj, long j5) {
        p1.c1 c1Var = this.F;
        int i = f1Var.g(obj, c1Var).f9678c;
        p1.e1 e1Var = this.E;
        f1Var.n(i, e1Var);
        if (e1Var.f != -9223372036854775807L && e1Var.a() && e1Var.i) {
            return s1.b0.O(s1.b0.y(e1Var.f9718g) - e1Var.f) - (j5 + c1Var.f9680e);
        }
        return -9223372036854775807L;
    }

    public final void l0(o2.f1 f1Var) throws Throwable {
        this.f480b0.f(1);
        t1 t1Var = this.N;
        int size = ((ArrayList) t1Var.f413c).size();
        if (f1Var.f9109b.length != size) {
            f1Var = new o2.f1(new Random(f1Var.f9108a.nextLong())).a(0, size);
        }
        t1Var.f419k = f1Var;
        v(t1Var.c(), false);
    }

    @Override // o2.a0
    public final void m(o2.b0 b0Var) {
        this.B.a(8, b0Var).b();
    }

    public final void m0(int i) {
        u1 u1Var = this.f479a0;
        if (u1Var.f452e != i) {
            if (i != 2) {
                this.f499u0 = -9223372036854775807L;
            }
            if (i != 3 && u1Var.f461p) {
                this.f479a0 = u1Var.i(false);
            }
            this.f479a0 = this.f479a0.h(i);
        }
    }

    public final long n(e1 e1Var) {
        if (e1Var == null) {
            return 0L;
        }
        long jMax = e1Var.f206p;
        if (!e1Var.f197e) {
            return jMax;
        }
        int i = 0;
        while (true) {
            b2[] b2VarArr = this.f498u;
            if (i >= b2VarArr.length) {
                return jMax;
            }
            if (b2VarArr[i].d(e1Var) != null) {
                g gVarD = b2VarArr[i].d(e1Var);
                Objects.requireNonNull(gVarD);
                long j5 = gVarD.G;
                if (j5 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(j5, jMax);
            }
            i++;
        }
    }

    public final void n0(u2.u uVar) {
        for (b2 b2Var : this.f498u) {
            g gVar = (g) b2Var.f171e;
            if (gVar.f232v == 2) {
                gVar.b(7, uVar);
                g gVar2 = (g) b2Var.f;
                if (gVar2 != null) {
                    gVar2.b(7, uVar);
                }
            }
        }
    }

    public final Pair o(p1.f1 f1Var) {
        long j5 = 0;
        if (f1Var.p()) {
            return Pair.create(u1.f447u, 0L);
        }
        int iA = f1Var.a(this.f488j0);
        Pair pairI = f1Var.i(this.E, this.F, iA, -9223372036854775807L);
        o2.d0 d0VarP = this.M.p(f1Var, pairI.first, 0L);
        long jLongValue = ((Long) pairI.second).longValue();
        if (d0VarP.b()) {
            Object obj = d0VarP.f9090a;
            p1.c1 c1Var = this.F;
            f1Var.g(obj, c1Var);
            if (d0VarP.f9092c == c1Var.e(d0VarP.f9091b)) {
                c1Var.f9681g.getClass();
            }
        } else {
            j5 = jLongValue;
        }
        return Pair.create(d0VarP, Long.valueOf(j5));
    }

    public final void o0(Object obj, s1.g gVar) {
        for (b2 b2Var : this.f498u) {
            g gVar2 = (g) b2Var.f171e;
            if (gVar2.f232v == 2) {
                int i = b2Var.f170d;
                if (i == 4 || i == 1) {
                    g gVar3 = (g) b2Var.f;
                    gVar3.getClass();
                    gVar3.b(1, obj);
                } else {
                    gVar2.b(1, obj);
                }
            }
        }
        int i10 = this.f479a0.f452e;
        if (i10 == 3 || i10 == 2) {
            this.B.e(2);
        }
        if (gVar != null) {
            gVar.e();
        }
    }

    public final long p(long j5) {
        e1 e1Var = this.M.f266l;
        if (e1Var == null) {
            return 0L;
        }
        return Math.max(0L, j5 - (this.f493p0 - e1Var.f206p));
    }

    public final void p0(float f) {
        this.f507y0 = f;
        float f4 = f * this.U.f217g;
        for (b2 b2Var : this.f498u) {
            g gVar = (g) b2Var.f171e;
            if (gVar.f232v == 1) {
                gVar.b(2, Float.valueOf(f4));
                g gVar2 = (g) b2Var.f;
                if (gVar2 != null) {
                    gVar2.b(2, Float.valueOf(f4));
                }
            }
        }
    }

    public final void q(int i) {
        u1 u1Var = this.f479a0;
        y0(i, u1Var.f459n, u1Var.f458m, u1Var.f457l);
    }

    public final boolean q0() {
        u1 u1Var = this.f479a0;
        return u1Var.f457l && u1Var.f459n == 0;
    }

    public final void r() {
        p0(this.f507y0);
    }

    public final boolean r0(p1.f1 f1Var, o2.d0 d0Var) {
        if (d0Var.b() || f1Var.p()) {
            return false;
        }
        int i = f1Var.g(d0Var.f9090a, this.F).f9678c;
        p1.e1 e1Var = this.E;
        f1Var.n(i, e1Var);
        return e1Var.a() && e1Var.i && e1Var.f != -9223372036854775807L;
    }

    public final void s(o2.b0 b0Var) {
        h1 h1Var = this.M;
        e1 e1Var = h1Var.f266l;
        if (e1Var != null && e1Var.f193a == b0Var) {
            h1Var.m(this.f493p0);
            C();
            return;
        }
        e1 e1Var2 = h1Var.f267m;
        if (e1Var2 == null || e1Var2.f193a != b0Var) {
            return;
        }
        D();
    }

    public final void s0() {
        e1 e1Var = this.M.i;
        if (e1Var == null) {
            return;
        }
        r2.v vVar = e1Var.f205o;
        int i = 0;
        while (true) {
            b2[] b2VarArr = this.f498u;
            if (i >= b2VarArr.length) {
                return;
            }
            if (vVar.b(i)) {
                b2VarArr[i].m();
            }
            i++;
        }
    }

    public final void t(int i, IOException iOException) {
        q qVar = new q(0, iOException, i);
        e1 e1Var = this.M.i;
        if (e1Var != null) {
            qVar = qVar.a(e1Var.f198g.f221a);
        }
        s1.b.h("ExoPlayerImplInternal", "Playback error", qVar);
        t0(false, false);
        this.f479a0 = this.f479a0.f(qVar);
    }

    public final void t0(boolean z2, boolean z10) {
        O(z2 || !this.f489k0, false, true, false);
        this.f480b0.f(z10 ? 1 : 0);
        this.f508z.a(this.Q);
        this.U.d(1, this.f479a0.f457l);
        m0(1);
    }

    public final void u(boolean z2) {
        e1 e1Var = this.M.f266l;
        o2.d0 d0Var = e1Var == null ? this.f479a0.f449b : e1Var.f198g.f221a;
        boolean zEquals = this.f479a0.f456k.equals(d0Var);
        if (!zEquals) {
            this.f479a0 = this.f479a0.c(d0Var);
        }
        u1 u1Var = this.f479a0;
        u1Var.f462q = e1Var == null ? u1Var.f464s : e1Var.d();
        u1 u1Var2 = this.f479a0;
        u1Var2.f463r = p(u1Var2.f462q);
        if ((!zEquals || z2) && e1Var != null && e1Var.f197e) {
            w0(e1Var.f204n, e1Var.f205o);
        }
    }

    public final void u0() {
        m mVar = this.I;
        mVar.f317v = false;
        e2 e2Var = (e2) mVar.f318w;
        if (e2Var.f208v) {
            e2Var.a(e2Var.j());
            e2Var.f208v = false;
        }
        for (b2 b2Var : this.f498u) {
            g gVar = (g) b2Var.f;
            g gVar2 = (g) b2Var.f171e;
            if (b2.h(gVar2)) {
                b2.b(gVar2);
            }
            if (gVar != null && gVar.B != 0) {
                b2.b(gVar);
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
    /* JADX WARN: Type inference failed for: r11v8, types: [p1.f1] */
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
    /* JADX WARN: Type inference failed for: r2v10, types: [p1.f1] */
    /* JADX WARN: Type inference failed for: r2v15, types: [a2.u1] */
    /* JADX WARN: Type inference failed for: r2v35, types: [a2.h1] */
    /* JADX WARN: Type inference failed for: r35v0, types: [a2.x0] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v25, types: [p1.f1] */
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
    public final void v(p1.f1 r36, boolean r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1091
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.x0.v(p1.f1, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, o2.e1] */
    public final void v0() {
        e1 e1Var = this.M.f266l;
        boolean z2 = this.f486h0 || (e1Var != null && e1Var.f193a.c());
        u1 u1Var = this.f479a0;
        if (z2 != u1Var.f453g) {
            this.f479a0 = u1Var.b(z2);
        }
    }

    public final void w(o2.b0 b0Var) {
        e1 e1Var;
        h1 h1Var = this.M;
        e1 e1Var2 = h1Var.f266l;
        m mVar = this.I;
        if (e1Var2 != null && e1Var2.f193a == b0Var) {
            e1Var2.getClass();
            if (!e1Var2.f197e) {
                float f = mVar.h().f10038a;
                u1 u1Var = this.f479a0;
                e1Var2.f(f, u1Var.f448a, u1Var.f457l);
            }
            w0(e1Var2.f204n, e1Var2.f205o);
            if (e1Var2 == h1Var.i) {
                Q(e1Var2.f198g.f222b);
                k(new boolean[this.f498u.length], h1Var.f264j.e());
                e1Var2.f199h = true;
                u1 u1Var2 = this.f479a0;
                o2.d0 d0Var = u1Var2.f449b;
                long j5 = e1Var2.f198g.f222b;
                this.f479a0 = y(d0Var, j5, u1Var2.f450c, j5, false, 5);
            }
            C();
            return;
        }
        int i = 0;
        while (true) {
            if (i >= h1Var.f271q.size()) {
                e1Var = null;
                break;
            }
            e1Var = (e1) h1Var.f271q.get(i);
            if (e1Var.f193a == b0Var) {
                break;
            } else {
                i++;
            }
        }
        if (e1Var != null) {
            s1.d.g(true ^ e1Var.f197e);
            float f4 = mVar.h().f10038a;
            u1 u1Var3 = this.f479a0;
            e1Var.f(f4, u1Var3.f448a, u1Var3.f457l);
            e1 e1Var3 = h1Var.f267m;
            if (e1Var3 == null || e1Var3.f193a != b0Var) {
                return;
            }
            D();
        }
    }

    public final void w0(o2.n1 n1Var, r2.v vVar) {
        e1 e1Var = this.M.f266l;
        e1Var.getClass();
        long jP = p(e1Var.d());
        long j5 = r0(this.f479a0.f448a, e1Var.f198g.f221a) ? this.O.f288h : -9223372036854775807L;
        p1.f1 f1Var = this.f479a0.f448a;
        float f = this.I.h().f10038a;
        boolean z2 = this.f479a0.f457l;
        this.f508z.d(new z0(this.Q, jP, f, this.f484f0, j5), vVar.f11359c);
    }

    public final void x(p1.q0 q0Var, float f, boolean z2, boolean z10) {
        int i;
        if (z2) {
            if (z10) {
                this.f480b0.f(1);
            }
            this.f479a0 = this.f479a0.g(q0Var);
        }
        float f4 = q0Var.f10038a;
        e1 e1Var = this.M.i;
        while (true) {
            i = 0;
            if (e1Var == null) {
                break;
            }
            r2.r[] rVarArr = e1Var.f205o.f11359c;
            int length = rVarArr.length;
            while (i < length) {
                r2.r rVar = rVarArr[i];
                if (rVar != null) {
                    rVar.p(f4);
                }
                i++;
            }
            e1Var = e1Var.f203m;
        }
        b2[] b2VarArr = this.f498u;
        int length2 = b2VarArr.length;
        while (i < length2) {
            b2 b2Var = b2VarArr[i];
            float f10 = q0Var.f10038a;
            ((g) b2Var.f171e).z(f, f10);
            g gVar = (g) b2Var.f;
            if (gVar != null) {
                gVar.z(f, f10);
            }
            i++;
        }
    }

    public final void x0(int i, int i10, List list) throws Throwable {
        this.f480b0.f(1);
        t1 t1Var = this.N;
        t1Var.getClass();
        ArrayList arrayList = (ArrayList) t1Var.f413c;
        s1.d.b(i >= 0 && i <= i10 && i10 <= arrayList.size());
        s1.d.b(list.size() == i10 - i);
        for (int i11 = i; i11 < i10; i11++) {
            ((s1) arrayList.get(i11)).f401a.x((p1.g0) list.get(i11 - i));
        }
        v(t1Var.c(), false);
    }

    public final u1 y(o2.d0 d0Var, long j5, long j8, long j10, boolean z2, int i) {
        aa.c1 c1VarG;
        boolean z10;
        this.f496s0 = (!this.f496s0 && j5 == this.f479a0.f464s && d0Var.equals(this.f479a0.f449b)) ? false : true;
        P();
        u1 u1Var = this.f479a0;
        o2.n1 n1Var = u1Var.f454h;
        r2.v vVar = u1Var.i;
        List list = u1Var.f455j;
        if (this.N.f411a) {
            e1 e1Var = this.M.i;
            n1Var = e1Var == null ? o2.n1.f9176d : e1Var.f204n;
            vVar = e1Var == null ? this.f506y : e1Var.f205o;
            r2.r[] rVarArr = vVar.f11359c;
            aa.g0 g0Var = new aa.g0(4);
            boolean z11 = false;
            for (r2.r rVar : rVarArr) {
                if (rVar != null) {
                    p1.l0 l0Var = rVar.c(0).f10021l;
                    if (l0Var == null) {
                        g0Var.a(new p1.l0(new p1.k0[0]));
                    } else {
                        g0Var.a(l0Var);
                        z11 = true;
                    }
                }
            }
            if (z11) {
                c1VarG = g0Var.g();
            } else {
                aa.h0 h0Var = aa.j0.f690v;
                c1VarG = aa.c1.f650y;
            }
            list = c1VarG;
            if (e1Var != null) {
                f1 f1Var = e1Var.f198g;
                if (f1Var.f223c != j8) {
                    e1Var.f198g = f1Var.a(j8);
                }
            }
            b2[] b2VarArr = this.f498u;
            h1 h1Var = this.M;
            e1 e1Var2 = h1Var.i;
            if (e1Var2 == h1Var.f264j && e1Var2 != null) {
                r2.v vVar2 = e1Var2.f205o;
                int i10 = 0;
                boolean z12 = false;
                while (true) {
                    if (i10 >= b2VarArr.length) {
                        z10 = true;
                        break;
                    }
                    if (vVar2.b(i10)) {
                        if (((g) b2VarArr[i10].f171e).f232v != 1) {
                            z10 = false;
                            break;
                        }
                        if (vVar2.f11358b[i10].f156a != 0) {
                            z12 = true;
                        }
                    }
                    i10++;
                }
                boolean z13 = z12 && z10;
                if (z13 != this.f490m0) {
                    this.f490m0 = z13;
                    if (!z13 && this.f479a0.f461p) {
                        this.B.e(2);
                    }
                }
            }
        } else if (!d0Var.equals(u1Var.f449b)) {
            n1Var = o2.n1.f9176d;
            vVar = this.f506y;
            list = aa.c1.f650y;
        }
        o2.n1 n1Var2 = n1Var;
        r2.v vVar3 = vVar;
        List list2 = list;
        if (z2) {
            u0 u0Var = this.f480b0;
            if (!u0Var.f445d || u0Var.f446e == 5) {
                u0Var.f444c = true;
                u0Var.f445d = true;
                u0Var.f446e = i;
            } else {
                s1.d.b(i == 5);
            }
        }
        u1 u1Var2 = this.f479a0;
        return u1Var2.d(d0Var, j5, j8, j10, p(u1Var2.f462q), n1Var2, vVar3, list2);
    }

    public final void y0(int i, int i10, int i11, boolean z2) {
        boolean z10 = z2 && i != -1;
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
        u1 u1Var = this.f479a0;
        if (u1Var.f457l == z10 && u1Var.f459n == i10 && u1Var.f458m == i11) {
            return;
        }
        this.f479a0 = u1Var.e(i11, i10, z10);
        B0(false, false);
        h1 h1Var = this.M;
        for (e1 e1Var = h1Var.i; e1Var != null; e1Var = e1Var.f203m) {
            for (r2.r rVar : e1Var.f205o.f11359c) {
                if (rVar != null) {
                    rVar.a(z10);
                }
            }
        }
        if (!q0()) {
            u0();
            z0();
            u1 u1Var2 = this.f479a0;
            if (u1Var2.f461p) {
                this.f479a0 = u1Var2.i(false);
            }
            h1Var.m(this.f493p0);
            return;
        }
        int i12 = this.f479a0.f452e;
        s1.y yVar = this.B;
        if (i12 != 3) {
            if (i12 == 2) {
                yVar.e(2);
            }
        } else {
            m mVar = this.I;
            mVar.f317v = true;
            ((e2) mVar.f318w).b();
            s0();
            yVar.e(2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.Object, o2.b0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z0() {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.x0.z0():void");
    }
}
