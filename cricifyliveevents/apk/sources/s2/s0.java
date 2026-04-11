package s2;

import android.net.Uri;
import android.os.Handler;
import g2.r1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements a0, a3.r, w2.i, w2.l, y0 {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final Map f11307l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final v1.p f11308m0;
    public final l2.k A;
    public final v0 B;
    public final w2.e C;
    public final String D;
    public final long E;
    public final v1.p F;
    public final long G;
    public final w2.o H;
    public final l7.a I;
    public final y1.g J;
    public final n0 K;
    public final n0 L;
    public final Handler M;
    public z N;
    public n3.b O;
    public z0[] P;
    public r0[] Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public b6.f V;
    public a3.c0 W;
    public long X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f11309a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f11310b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f11311c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f11312d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f11313e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f11314f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f11315g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f11316h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f11317i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f11318j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f11319k0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Uri f11320v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b2.h f11321w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l2.n f11322x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f9.a0 f11323y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f3.a f11324z;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        f11307l0 = Collections.unmodifiableMap(map);
        v1.o oVar = new v1.o();
        oVar.f12883a = "icy";
        oVar.f12893m = v1.m0.p("application/x-icy");
        f11308m0 = new v1.p(oVar);
    }

    public s0(Uri uri, b2.h hVar, l7.a aVar, l2.n nVar, l2.k kVar, f9.a0 a0Var, f3.a aVar2, v0 v0Var, w2.e eVar, String str, int i, v1.p pVar, long j4, x2.a aVar3) {
        this.f11320v = uri;
        this.f11321w = hVar;
        this.f11322x = nVar;
        this.A = kVar;
        this.f11323y = a0Var;
        this.f11324z = aVar2;
        this.B = v0Var;
        this.C = eVar;
        this.D = str;
        this.E = i;
        this.F = pVar;
        this.H = aVar3 != null ? new w2.o(aVar3) : new w2.o("ProgressiveMediaPeriod");
        this.I = aVar;
        this.G = j4;
        this.J = new y1.g();
        this.K = new n0(this, 1);
        this.L = new n0(this, 2);
        this.M = y1.a0.n(null);
        this.Q = new r0[0];
        this.P = new z0[0];
        this.f11315g0 = -9223372036854775807L;
        this.Z = 1;
    }

    public final void A(int i) {
        c();
        b6.f fVar = this.V;
        boolean[] zArr = (boolean[]) fVar.f1803z;
        if (zArr[i]) {
            return;
        }
        v1.p pVar = ((l1) fVar.f1800w).a(i).f12705d[0];
        this.f11324z.f(v1.m0.i(pVar.f12946n), pVar, 0, null, this.f11314f0);
        zArr[i] = true;
    }

    @Override // w2.i
    public final void B(w2.k kVar, long j4, long j7, int i) {
        t tVar;
        p0 p0Var = (p0) kVar;
        b2.f0 f0Var = p0Var.f11293w;
        if (i == 0) {
            tVar = new t(p0Var.E);
        } else {
            Uri uri = f0Var.f1686x;
            tVar = new t(j7);
        }
        this.f11324z.s(tVar, 1, -1, null, 0, null, p0Var.D, this.X, i);
    }

    public final void C(int i) {
        c();
        if (this.f11316h0) {
            if ((!this.T || ((boolean[]) this.V.f1801x)[i]) && !this.P[i].x(false)) {
                this.f11315g0 = 0L;
                this.f11316h0 = false;
                this.f11310b0 = true;
                this.f11314f0 = 0L;
                this.f11317i0 = 0;
                for (z0 z0Var : this.P) {
                    z0Var.D(false);
                }
                z zVar = this.N;
                zVar.getClass();
                zVar.f(this);
            }
        }
    }

    public final a3.i0 D(r0 r0Var) {
        int length = this.P.length;
        for (int i = 0; i < length; i++) {
            if (r0Var.equals(this.Q[i])) {
                return this.P[i];
            }
        }
        if (this.R) {
            y1.b.p("ProgressiveMediaPeriod", "Extractor added new track (id=" + r0Var.f11300a + ") after finishing tracks.");
            return new a3.o();
        }
        l2.n nVar = this.f11322x;
        nVar.getClass();
        z0 z0Var = new z0(this.C, nVar, this.A);
        z0Var.f = this;
        int i10 = length + 1;
        r0[] r0VarArr = (r0[]) Arrays.copyOf(this.Q, i10);
        r0VarArr[length] = r0Var;
        int i11 = y1.a0.f14551a;
        this.Q = r0VarArr;
        z0[] z0VarArr = (z0[]) Arrays.copyOf(this.P, i10);
        z0VarArr[length] = z0Var;
        this.P = z0VarArr;
        return z0Var;
    }

    public final void E(a3.c0 c0Var) {
        this.W = this.O == null ? c0Var : new a3.u(-9223372036854775807L);
        this.X = c0Var.l();
        boolean z10 = !this.f11313e0 && c0Var.l() == -9223372036854775807L;
        this.Y = z10;
        this.Z = z10 ? 7 : 1;
        if (this.S) {
            this.B.v(this.X, c0Var, z10);
        } else {
            z();
        }
    }

    public final void F() {
        p0 p0Var = new p0(this, this.f11320v, this.f11321w, this.I, this, this.J);
        if (this.S) {
            y1.d.g(y());
            long j4 = this.X;
            if (j4 != -9223372036854775807L && this.f11315g0 > j4) {
                this.f11318j0 = true;
                this.f11315g0 = -9223372036854775807L;
                return;
            }
            a3.c0 c0Var = this.W;
            c0Var.getClass();
            long j7 = c0Var.j(this.f11315g0).f146a.f159b;
            long j10 = this.f11315g0;
            p0Var.A.f227a = j7;
            p0Var.D = j10;
            p0Var.C = true;
            p0Var.G = false;
            for (z0 z0Var : this.P) {
                z0Var.f11390t = this.f11315g0;
            }
            this.f11315g0 = -9223372036854775807L;
        }
        this.f11317i0 = w();
        this.H.f(p0Var, this, this.f11323y.m(this.Z));
    }

    public final boolean G() {
        return this.f11310b0 || y();
    }

    @Override // s2.c1
    public final boolean a() {
        boolean z10;
        if (!this.H.d()) {
            return false;
        }
        y1.g gVar = this.J;
        synchronized (gVar) {
            z10 = gVar.f14576b;
        }
        return z10;
    }

    @Override // s2.y0
    public final void b() {
        this.M.post(this.K);
    }

    public final void c() {
        y1.d.g(this.S);
        this.V.getClass();
        this.W.getClass();
    }

    @Override // s2.a0
    public final void d(z zVar, long j4) {
        this.N = zVar;
        v1.p pVar = this.F;
        if (pVar == null) {
            this.J.e();
            F();
        } else {
            p(0, 3).f(pVar);
            E(new a3.z(-9223372036854775807L, new long[]{0}, new long[]{0}));
            e();
            this.f11315g0 = j4;
        }
    }

    @Override // a3.r
    public final void e() {
        this.R = true;
        this.M.post(this.K);
    }

    @Override // w2.l
    public final void f() {
        for (z0 z0Var : this.P) {
            z0Var.D(true);
            l2.h hVar = z0Var.f11379h;
            if (hVar != null) {
                hVar.c(z0Var.f11377e);
                z0Var.f11379h = null;
                z0Var.f11378g = null;
            }
        }
        l7.a aVar = this.I;
        a3.p pVar = (a3.p) aVar.f7867x;
        if (pVar != null) {
            pVar.release();
            aVar.f7867x = null;
        }
        aVar.f7868y = null;
    }

    @Override // w2.i
    public final i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        long jMin;
        i4.e eVar;
        a3.c0 c0Var;
        p0 p0Var = (p0) kVar;
        Uri uri = p0Var.f11293w.f1686x;
        t tVar = new t(j7);
        int i10 = y1.a0.f14551a;
        this.f11323y.getClass();
        if ((iOException instanceof v1.n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof b2.x) || (iOException instanceof w2.n)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = b2.l.f1700w;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof b2.l) && ((b2.l) cause).f1701v == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        if (jMin == -9223372036854775807L) {
            eVar = w2.o.f;
        } else {
            int iW = w();
            int i12 = iW > this.f11317i0 ? 1 : 0;
            if (this.f11313e0 || !((c0Var = this.W) == null || c0Var.l() == -9223372036854775807L)) {
                this.f11317i0 = iW;
            } else if (!this.S || G()) {
                this.f11310b0 = this.S;
                this.f11314f0 = 0L;
                this.f11317i0 = 0;
                for (z0 z0Var : this.P) {
                    z0Var.D(false);
                }
                p0Var.A.f227a = 0L;
                p0Var.D = 0L;
                p0Var.C = true;
                p0Var.G = false;
            } else {
                this.f11316h0 = true;
                eVar = w2.o.f13883e;
            }
            eVar = new i4.e(i12, jMin, false);
        }
        i4.e eVar2 = eVar;
        this.f11324z.p(tVar, 1, -1, null, 0, null, p0Var.D, this.X, iOException, !eVar2.a());
        return eVar2;
    }

    @Override // s2.a0
    public final long h(long j4, r1 r1Var) {
        c();
        if (!this.W.g()) {
            return 0L;
        }
        a3.b0 b0VarJ = this.W.j(j4);
        return r1Var.a(j4, b0VarJ.f146a.f158a, b0VarJ.f147b.f158a);
    }

    @Override // s2.c1
    public final boolean i(g2.s0 s0Var) {
        if (this.f11318j0) {
            return false;
        }
        w2.o oVar = this.H;
        if (oVar.b() || this.f11316h0) {
            return false;
        }
        if ((this.S || this.F != null) && this.f11312d0 == 0) {
            return false;
        }
        boolean zE = this.J.e();
        if (oVar.d()) {
            return zE;
        }
        F();
        return true;
    }

    @Override // s2.c1
    public final long j() {
        return q();
    }

    @Override // w2.i
    public final void k(w2.k kVar, long j4, long j7) {
        p0 p0Var = (p0) kVar;
        if (this.X == -9223372036854775807L && this.W != null) {
            long jX = x(true);
            long j10 = jX == Long.MIN_VALUE ? 0L : jX + 10000;
            this.X = j10;
            this.B.v(j10, this.W, this.Y);
        }
        Uri uri = p0Var.f11293w.f1686x;
        t tVar = new t(j7);
        this.f11323y.getClass();
        this.f11324z.o(tVar, 1, -1, null, 0, null, p0Var.D, this.X);
        this.f11318j0 = true;
        z zVar = this.N;
        zVar.getClass();
        zVar.f(this);
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) throws Throwable {
        if (this.U) {
            return;
        }
        c();
        if (y()) {
            return;
        }
        boolean[] zArr = (boolean[]) this.V.f1802y;
        int length = this.P.length;
        for (int i = 0; i < length; i++) {
            this.P[i].j(j4, z10, zArr[i]);
        }
    }

    @Override // s2.a0
    public final long m() {
        if (this.f11311c0) {
            this.f11311c0 = false;
            return this.f11314f0;
        }
        if (!this.f11310b0) {
            return -9223372036854775807L;
        }
        if (!this.f11318j0 && w() <= this.f11317i0) {
            return -9223372036854775807L;
        }
        this.f11310b0 = false;
        return this.f11314f0;
    }

    @Override // w2.i
    public final void n(w2.k kVar, long j4, long j7, boolean z10) {
        p0 p0Var = (p0) kVar;
        Uri uri = p0Var.f11293w.f1686x;
        t tVar = new t(j7);
        this.f11323y.getClass();
        this.f11324z.n(tVar, 1, -1, null, 0, null, p0Var.D, this.X);
        if (z10) {
            return;
        }
        for (z0 z0Var : this.P) {
            z0Var.D(false);
        }
        if (this.f11312d0 > 0) {
            z zVar = this.N;
            zVar.getClass();
            zVar.f(this);
        }
    }

    @Override // s2.a0
    public final l1 o() {
        c();
        return (l1) this.V.f1800w;
    }

    @Override // a3.r
    public final a3.i0 p(int i, int i10) {
        return D(new r0(i, false));
    }

    @Override // s2.c1
    public final long q() {
        long jX;
        boolean z10;
        c();
        if (this.f11318j0 || this.f11312d0 == 0) {
            return Long.MIN_VALUE;
        }
        if (y()) {
            return this.f11315g0;
        }
        if (this.T) {
            int length = this.P.length;
            jX = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                b6.f fVar = this.V;
                if (((boolean[]) fVar.f1801x)[i] && ((boolean[]) fVar.f1802y)[i]) {
                    z0 z0Var = this.P[i];
                    synchronized (z0Var) {
                        z10 = z0Var.f11393w;
                    }
                    if (!z10) {
                        jX = Math.min(jX, this.P[i].q());
                    }
                }
            }
        } else {
            jX = Long.MAX_VALUE;
        }
        if (jX == Long.MAX_VALUE) {
            jX = x(false);
        }
        return jX == Long.MIN_VALUE ? this.f11314f0 : jX;
    }

    @Override // s2.a0
    public final void r() throws IOException {
        int iM = this.f11323y.m(this.Z);
        w2.o oVar = this.H;
        IOException iOException = oVar.f13886c;
        if (iOException != null) {
            throw iOException;
        }
        w2.j jVar = oVar.f13885b;
        if (jVar != null) {
            if (iM == Integer.MIN_VALUE) {
                iM = jVar.f13875v;
            }
            IOException iOException2 = jVar.f13879z;
            if (iOException2 != null && jVar.A > iM) {
                throw iOException2;
            }
        }
        if (this.f11318j0 && !this.S) {
            throw v1.n0.a(null, "Loading finished before preparation is complete.");
        }
    }

    @Override // a3.r
    public final void s(a3.c0 c0Var) {
        this.M.post(new nc.i(5, this, c0Var));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    @Override // s2.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long t(long r10) {
        /*
            r9 = this;
            r9.c()
            b6.f r0 = r9.V
            java.lang.Object r0 = r0.f1801x
            boolean[] r0 = (boolean[]) r0
            a3.c0 r1 = r9.W
            boolean r1 = r1.g()
            if (r1 == 0) goto L12
            goto L14
        L12:
            r10 = 0
        L14:
            r1 = 0
            r9.f11310b0 = r1
            long r2 = r9.f11314f0
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            r3 = 1
            if (r2 != 0) goto L20
            r2 = r3
            goto L21
        L20:
            r2 = r1
        L21:
            r9.f11314f0 = r10
            boolean r4 = r9.y()
            if (r4 == 0) goto L2c
            r9.f11315g0 = r10
            return r10
        L2c:
            int r4 = r9.Z
            r5 = 7
            w2.o r6 = r9.H
            if (r4 == r5) goto L73
            boolean r4 = r9.f11318j0
            if (r4 != 0) goto L3d
            boolean r4 = r6.d()
            if (r4 == 0) goto L73
        L3d:
            s2.z0[] r4 = r9.P
            int r4 = r4.length
            r5 = r1
        L41:
            if (r5 >= r4) goto L70
            s2.z0[] r7 = r9.P
            r7 = r7[r5]
            int r8 = r7.t()
            if (r8 != 0) goto L50
            if (r2 == 0) goto L50
            goto L6d
        L50:
            boolean r8 = r9.U
            if (r8 == 0) goto L5b
            int r8 = r7.f11387q
            boolean r7 = r7.F(r8)
            goto L61
        L5b:
            boolean r8 = r9.f11318j0
            boolean r7 = r7.G(r8, r10)
        L61:
            if (r7 != 0) goto L6d
            boolean r7 = r0[r5]
            if (r7 != 0) goto L6b
            boolean r7 = r9.T
            if (r7 != 0) goto L6d
        L6b:
            r3 = r1
            goto L70
        L6d:
            int r5 = r5 + 1
            goto L41
        L70:
            if (r3 == 0) goto L73
            goto La3
        L73:
            r9.f11316h0 = r1
            r9.f11315g0 = r10
            r9.f11318j0 = r1
            r9.f11311c0 = r1
            boolean r0 = r6.d()
            if (r0 == 0) goto L92
            s2.z0[] r0 = r9.P
            int r2 = r0.length
        L84:
            if (r1 >= r2) goto L8e
            r3 = r0[r1]
            r3.k()
            int r1 = r1 + 1
            goto L84
        L8e:
            r6.a()
            return r10
        L92:
            r0 = 0
            r6.f13886c = r0
            s2.z0[] r0 = r9.P
            int r2 = r0.length
            r3 = r1
        L99:
            if (r3 >= r2) goto La3
            r4 = r0[r3]
            r4.D(r1)
            int r3 = r3 + 1
            goto L99
        La3:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.s0.t(long):long");
    }

    @Override // s2.a0
    public final long v(v2.q[] qVarArr, boolean[] zArr, a1[] a1VarArr, boolean[] zArr2, long j4) {
        v2.q qVar;
        c();
        b6.f fVar = this.V;
        l1 l1Var = (l1) fVar.f1800w;
        boolean[] zArr3 = (boolean[]) fVar.f1802y;
        int i = this.f11312d0;
        int i10 = 0;
        for (int i11 = 0; i11 < qVarArr.length; i11++) {
            a1 a1Var = a1VarArr[i11];
            if (a1Var != null && (qVarArr[i11] == null || !zArr[i11])) {
                int i12 = ((q0) a1Var).f11297v;
                y1.d.g(zArr3[i12]);
                this.f11312d0--;
                zArr3[i12] = false;
                a1VarArr[i11] = null;
            }
        }
        boolean z10 = !this.f11309a0 ? j4 == 0 || this.U : i != 0;
        for (int i13 = 0; i13 < qVarArr.length; i13++) {
            if (a1VarArr[i13] == null && (qVar = qVarArr[i13]) != null) {
                y1.d.g(qVar.length() == 1);
                y1.d.g(qVar.e(0) == 0);
                int iB = l1Var.b(qVar.i());
                y1.d.g(!zArr3[iB]);
                this.f11312d0++;
                zArr3[iB] = true;
                this.f11311c0 = qVar.j().f12952t | this.f11311c0;
                a1VarArr[i13] = new q0(this, iB);
                zArr2[i13] = true;
                if (!z10) {
                    z0 z0Var = this.P[iB];
                    z10 = (z0Var.t() == 0 || z0Var.G(true, j4)) ? false : true;
                }
            }
        }
        if (this.f11312d0 == 0) {
            this.f11316h0 = false;
            this.f11310b0 = false;
            this.f11311c0 = false;
            w2.o oVar = this.H;
            if (oVar.d()) {
                z0[] z0VarArr = this.P;
                int length = z0VarArr.length;
                while (i10 < length) {
                    z0VarArr[i10].k();
                    i10++;
                }
                oVar.a();
            } else {
                this.f11318j0 = false;
                for (z0 z0Var2 : this.P) {
                    z0Var2.D(false);
                }
            }
        } else if (z10) {
            j4 = t(j4);
            while (i10 < a1VarArr.length) {
                if (a1VarArr[i10] != null) {
                    zArr2[i10] = true;
                }
                i10++;
            }
        }
        this.f11309a0 = true;
        return j4;
    }

    public final int w() {
        int i = 0;
        for (z0 z0Var : this.P) {
            i += z0Var.f11387q + z0Var.f11386p;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long x(boolean r6) {
        /*
            r5 = this;
            r0 = -9223372036854775808
            r2 = 0
        L3:
            s2.z0[] r3 = r5.P
            int r3 = r3.length
            if (r2 >= r3) goto L26
            if (r6 != 0) goto L17
            b6.f r3 = r5.V
            r3.getClass()
            java.lang.Object r3 = r3.f1802y
            boolean[] r3 = (boolean[]) r3
            boolean r3 = r3[r2]
            if (r3 == 0) goto L23
        L17:
            s2.z0[] r3 = r5.P
            r3 = r3[r2]
            long r3 = r3.q()
            long r0 = java.lang.Math.max(r0, r3)
        L23:
            int r2 = r2 + 1
            goto L3
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.s0.x(boolean):long");
    }

    public final boolean y() {
        return this.f11315g0 != -9223372036854775807L;
    }

    public final void z() {
        long j4 = this.G;
        if (this.f11319k0 || this.S || !this.R || this.W == null) {
            return;
        }
        for (z0 z0Var : this.P) {
            if (z0Var.w() == null) {
                return;
            }
        }
        y1.g gVar = this.J;
        synchronized (gVar) {
            gVar.f14576b = false;
        }
        int length = this.P.length;
        v1.g1[] g1VarArr = new v1.g1[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            v1.p pVarW = this.P[i].w();
            pVarW.getClass();
            String str = pVarW.f12946n;
            boolean zK = v1.m0.k(str);
            boolean z10 = zK || v1.m0.o(str);
            zArr[i] = z10;
            this.T = z10 | this.T;
            this.U = j4 != -9223372036854775807L && length == 1 && v1.m0.m(str);
            n3.b bVar = this.O;
            if (bVar != null) {
                int i10 = bVar.f8757a;
                if (zK || this.Q[i].f11301b) {
                    v1.l0 l0Var = pVarW.f12944l;
                    v1.l0 l0Var2 = l0Var == null ? new v1.l0(bVar) : l0Var.a(bVar);
                    v1.o oVarA = pVarW.a();
                    oVarA.f12891k = l0Var2;
                    pVarW = new v1.p(oVarA);
                }
                if (zK && pVarW.f12941h == -1 && pVarW.i == -1 && i10 != -1) {
                    v1.o oVarA2 = pVarW.a();
                    oVarA2.f12889h = i10;
                    pVarW = new v1.p(oVarA2);
                }
            }
            int iH = this.f11322x.h(pVarW);
            v1.o oVarA3 = pVarW.a();
            oVarA3.N = iH;
            v1.p pVar = new v1.p(oVarA3);
            g1VarArr[i] = new v1.g1(Integer.toString(i), pVar);
            this.f11311c0 = pVar.f12952t | this.f11311c0;
        }
        this.V = new b6.f(new l1(g1VarArr), zArr);
        if (this.U && this.X == -9223372036854775807L) {
            this.X = j4;
            this.W = new o0(this, this.W);
        }
        this.B.v(this.X, this.W, this.Y);
        this.S = true;
        z zVar = this.N;
        zVar.getClass();
        zVar.k(this);
    }

    @Override // s2.c1
    public final void u(long j4) {
    }
}
