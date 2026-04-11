package o2;

import a2.d2;
import android.net.Uri;
import android.os.Handler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u0 implements b0, w2.q, s2.h, s2.k, a1 {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final Map f9218k0;
    public static final p1.q l0;
    public final x0 A;
    public final s2.e B;
    public final String C;
    public final long D;
    public final p1.q E;
    public final long F;
    public final s2.m G;
    public final kc.b H;
    public final s1.g I;
    public final p0 J;
    public final p0 K;
    public final Handler L;
    public a0 M;
    public j3.b N;
    public b1[] O;
    public t0[] P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public ub.o U;
    public w2.b0 V;
    public long W;
    public boolean X;
    public int Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f9219a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f9220b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f9221c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f9222d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f9223e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f9224f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f9225g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f9226h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f9227i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f9228j0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Uri f9229u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.h f9230v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f2.n f9231w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k8.a0 f9232x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final aa.l0 f9233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f2.k f9234z;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        f9218k0 = Collections.unmodifiableMap(map);
        p1.p pVar = new p1.p();
        pVar.f9957a = "icy";
        pVar.f9967m = p1.m0.p("application/x-icy");
        l0 = new p1.q(pVar);
    }

    public u0(Uri uri, v1.h hVar, kc.b bVar, f2.n nVar, f2.k kVar, k8.a0 a0Var, aa.l0 l0Var, x0 x0Var, s2.e eVar, String str, int i, p1.q qVar, long j5, t2.a aVar) {
        this.f9229u = uri;
        this.f9230v = hVar;
        this.f9231w = nVar;
        this.f9234z = kVar;
        this.f9232x = a0Var;
        this.f9233y = l0Var;
        this.A = x0Var;
        this.B = eVar;
        this.C = str;
        this.D = i;
        this.E = qVar;
        this.G = aVar != null ? new s2.m(aVar) : new s2.m("ProgressiveMediaPeriod");
        this.H = bVar;
        this.F = j5;
        this.I = new s1.g();
        this.J = new p0(this, 1);
        this.K = new p0(this, 2);
        this.L = s1.b0.n(null);
        this.P = new t0[0];
        this.O = new b1[0];
        this.f9224f0 = -9223372036854775807L;
        this.Y = 1;
    }

    public final void A() {
        long j5 = this.F;
        if (this.f9228j0 || this.R || !this.Q || this.V == null) {
            return;
        }
        for (b1 b1Var : this.O) {
            if (b1Var.w() == null) {
                return;
            }
        }
        s1.g gVar = this.I;
        synchronized (gVar) {
            gVar.f11670b = false;
        }
        int length = this.O.length;
        p1.g1[] g1VarArr = new p1.g1[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            p1.q qVarW = this.O[i].w();
            qVarW.getClass();
            String str = qVarW.f10023n;
            boolean zK = p1.m0.k(str);
            boolean z2 = zK || p1.m0.o(str);
            zArr[i] = z2;
            this.S = z2 | this.S;
            this.T = j5 != -9223372036854775807L && length == 1 && p1.m0.m(str);
            j3.b bVar = this.N;
            if (bVar != null) {
                int i10 = bVar.f6762a;
                if (zK || this.P[i].f9215b) {
                    p1.l0 l0Var = qVarW.f10021l;
                    p1.l0 l0Var2 = l0Var == null ? new p1.l0(bVar) : l0Var.a(bVar);
                    p1.p pVarA = qVarW.a();
                    pVarA.f9965k = l0Var2;
                    qVarW = new p1.q(pVarA);
                }
                if (zK && qVarW.f10018h == -1 && qVarW.i == -1 && i10 != -1) {
                    p1.p pVarA2 = qVarW.a();
                    pVarA2.f9963h = i10;
                    qVarW = new p1.q(pVarA2);
                }
            }
            int iF = this.f9231w.f(qVarW);
            p1.p pVarA3 = qVarW.a();
            pVarA3.N = iF;
            p1.q qVar = new p1.q(pVarA3);
            g1VarArr[i] = new p1.g1(Integer.toString(i), qVar);
            this.f9220b0 = qVar.f10029t | this.f9220b0;
        }
        this.U = new ub.o(new n1(g1VarArr), zArr);
        if (this.T && this.W == -9223372036854775807L) {
            this.W = j5;
            this.V = new q0(this, this.V);
        }
        this.A.z(this.W, this.V, this.X);
        this.R = true;
        a0 a0Var = this.M;
        a0Var.getClass();
        a0Var.m(this);
    }

    public final void B(int i) {
        w();
        ub.o oVar = this.U;
        boolean[] zArr = (boolean[]) oVar.f12871y;
        if (zArr[i]) {
            return;
        }
        p1.q qVar = ((n1) oVar.f12868v).a(i).f9765d[0];
        this.f9233y.g(p1.m0.i(qVar.f10023n), qVar, 0, null, this.f9223e0);
        zArr[i] = true;
    }

    public final void C(int i) {
        w();
        if (this.f9225g0) {
            if ((!this.S || ((boolean[]) this.U.f12869w)[i]) && !this.O[i].x(false)) {
                this.f9224f0 = 0L;
                this.f9225g0 = false;
                this.f9219a0 = true;
                this.f9223e0 = 0L;
                this.f9226h0 = 0;
                for (b1 b1Var : this.O) {
                    b1Var.D(false);
                }
                a0 a0Var = this.M;
                a0Var.getClass();
                a0Var.d(this);
            }
        }
    }

    public final w2.h0 D(t0 t0Var) {
        int length = this.O.length;
        for (int i = 0; i < length; i++) {
            if (t0Var.equals(this.P[i])) {
                return this.O[i];
            }
        }
        if (this.Q) {
            s1.b.p("ProgressiveMediaPeriod", "Extractor added new track (id=" + t0Var.f9214a + ") after finishing tracks.");
            return new w2.n();
        }
        f2.n nVar = this.f9231w;
        nVar.getClass();
        b1 b1Var = new b1(this.B, nVar, this.f9234z);
        b1Var.f = this;
        int i10 = length + 1;
        t0[] t0VarArr = (t0[]) Arrays.copyOf(this.P, i10);
        t0VarArr[length] = t0Var;
        int i11 = s1.b0.f11647a;
        this.P = t0VarArr;
        b1[] b1VarArr = (b1[]) Arrays.copyOf(this.O, i10);
        b1VarArr[length] = b1Var;
        this.O = b1VarArr;
        return b1Var;
    }

    public final void E(w2.b0 b0Var) {
        this.V = this.N == null ? b0Var : new w2.t(-9223372036854775807L);
        this.W = b0Var.k();
        boolean z2 = !this.f9222d0 && b0Var.k() == -9223372036854775807L;
        this.X = z2;
        this.Y = z2 ? 7 : 1;
        if (this.R) {
            this.A.z(this.W, b0Var, z2);
        } else {
            A();
        }
    }

    public final void F() {
        r0 r0Var = new r0(this, this.f9229u, this.f9230v, this.H, this, this.I);
        if (this.R) {
            s1.d.g(z());
            long j5 = this.W;
            if (j5 != -9223372036854775807L && this.f9224f0 > j5) {
                this.f9227i0 = true;
                this.f9224f0 = -9223372036854775807L;
                return;
            }
            w2.b0 b0Var = this.V;
            b0Var.getClass();
            long j8 = b0Var.i(this.f9224f0).f13569a.f13602b;
            long j10 = this.f9224f0;
            r0Var.f9205z.f13664a = j8;
            r0Var.C = j10;
            r0Var.B = true;
            r0Var.F = false;
            for (b1 b1Var : this.O) {
                b1Var.f9074t = this.f9224f0;
            }
            this.f9224f0 = -9223372036854775807L;
        }
        this.f9226h0 = x();
        this.G.f(r0Var, this, this.f9232x.k(this.Y));
    }

    public final boolean G() {
        return this.f9219a0 || z();
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        w();
        if (!this.V.h()) {
            return 0L;
        }
        w2.a0 a0VarI = this.V.i(j5);
        return d2Var.a(j5, a0VarI.f13569a.f13601a, a0VarI.f13570b.f13601a);
    }

    @Override // o2.a1
    public final void b() {
        this.L.post(this.J);
    }

    @Override // o2.e1
    public final boolean c() {
        boolean z2;
        if (!this.G.d()) {
            return false;
        }
        s1.g gVar = this.I;
        synchronized (gVar) {
            z2 = gVar.f11670b;
        }
        return z2;
    }

    @Override // s2.h
    public final void d(s2.j jVar, long j5, long j8) {
        r0 r0Var = (r0) jVar;
        if (this.W == -9223372036854775807L && this.V != null) {
            long jY = y(true);
            long j10 = jY == Long.MIN_VALUE ? 0L : jY + 10000;
            this.W = j10;
            this.A.z(j10, this.V, this.X);
        }
        Uri uri = r0Var.f9201v.f13128w;
        u uVar = new u(j8);
        this.f9232x.getClass();
        this.f9233y.o(uVar, 1, -1, null, 0, null, r0Var.C, this.W);
        this.f9227i0 = true;
        a0 a0Var = this.M;
        a0Var.getClass();
        a0Var.d(this);
    }

    @Override // w2.q
    public final void e() {
        this.Q = true;
        this.L.post(this.J);
    }

    @Override // s2.k
    public final void f() {
        for (b1 b1Var : this.O) {
            b1Var.D(true);
            f2.h hVar = b1Var.f9063h;
            if (hVar != null) {
                hVar.c(b1Var.f9061e);
                b1Var.f9063h = null;
                b1Var.f9062g = null;
            }
        }
        kc.b bVar = this.H;
        w2.o oVar = (w2.o) bVar.f7621w;
        if (oVar != null) {
            oVar.release();
            bVar.f7621w = null;
        }
        bVar.f7622x = null;
    }

    @Override // o2.e1
    public final long g() {
        return r();
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        if (this.T) {
            return;
        }
        w();
        if (z()) {
            return;
        }
        boolean[] zArr = (boolean[]) this.U.f12870x;
        int length = this.O.length;
        for (int i = 0; i < length; i++) {
            this.O[i].j(j5, z2, zArr[i]);
        }
    }

    @Override // o2.b0
    public final long i() {
        if (this.f9220b0) {
            this.f9220b0 = false;
            return this.f9223e0;
        }
        if (!this.f9219a0) {
            return -9223372036854775807L;
        }
        if (!this.f9227i0 && x() <= this.f9226h0) {
            return -9223372036854775807L;
        }
        this.f9219a0 = false;
        return this.f9223e0;
    }

    @Override // w2.q
    public final void j(w2.b0 b0Var) {
        this.L.post(new i0(this, 1, b0Var));
    }

    @Override // s2.h
    public final void k(s2.j jVar, long j5, long j8, int i) {
        u uVar;
        r0 r0Var = (r0) jVar;
        v1.c0 c0Var = r0Var.f9201v;
        if (i == 0) {
            uVar = new u(r0Var.D);
        } else {
            Uri uri = c0Var.f13128w;
            uVar = new u(j8);
        }
        this.f9233y.t(uVar, 1, -1, null, 0, null, r0Var.C, this.W, i);
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        if (this.f9227i0) {
            return false;
        }
        s2.m mVar = this.G;
        if (mVar.c() || this.f9225g0) {
            return false;
        }
        if ((this.R || this.E != null) && this.f9221c0 == 0) {
            return false;
        }
        boolean zE = this.I.e();
        if (mVar.d()) {
            return zE;
        }
        F();
        return true;
    }

    @Override // s2.h
    public final e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        long jMin;
        e4.f fVar;
        w2.b0 b0Var;
        r0 r0Var = (r0) jVar;
        Uri uri = r0Var.f9201v.f13128w;
        u uVar = new u(j8);
        int i10 = s1.b0.f11647a;
        this.f9232x.getClass();
        if ((iOException instanceof p1.n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof v1.u) || (iOException instanceof s2.l)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = v1.j.f13143v;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof v1.j) && ((v1.j) cause).f13144u == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        if (jMin == -9223372036854775807L) {
            fVar = s2.m.f11766z;
        } else {
            int iX = x();
            int i12 = iX > this.f9226h0 ? 1 : 0;
            if (this.f9222d0 || !((b0Var = this.V) == null || b0Var.k() == -9223372036854775807L)) {
                this.f9226h0 = iX;
            } else if (!this.R || G()) {
                this.f9219a0 = this.R;
                this.f9223e0 = 0L;
                this.f9226h0 = 0;
                for (b1 b1Var : this.O) {
                    b1Var.D(false);
                }
                r0Var.f9205z.f13664a = 0L;
                r0Var.C = 0L;
                r0Var.B = true;
                r0Var.F = false;
            } else {
                this.f9225g0 = true;
                fVar = s2.m.f11765y;
            }
            fVar = new e4.f(i12, jMin, false);
        }
        e4.f fVar2 = fVar;
        this.f9233y.q(uVar, 1, -1, null, 0, null, r0Var.C, this.W, iOException, !fVar2.a());
        return fVar2;
    }

    @Override // o2.b0
    public final long n(r2.r[] rVarArr, boolean[] zArr, c1[] c1VarArr, boolean[] zArr2, long j5) {
        r2.r rVar;
        w();
        ub.o oVar = this.U;
        n1 n1Var = (n1) oVar.f12868v;
        boolean[] zArr3 = (boolean[]) oVar.f12870x;
        int i = this.f9221c0;
        int i10 = 0;
        for (int i11 = 0; i11 < rVarArr.length; i11++) {
            c1 c1Var = c1VarArr[i11];
            if (c1Var != null && (rVarArr[i11] == null || !zArr[i11])) {
                int i12 = ((s0) c1Var).f9207u;
                s1.d.g(zArr3[i12]);
                this.f9221c0--;
                zArr3[i12] = false;
                c1VarArr[i11] = null;
            }
        }
        boolean z2 = !this.Z ? j5 == 0 || this.T : i != 0;
        for (int i13 = 0; i13 < rVarArr.length; i13++) {
            if (c1VarArr[i13] == null && (rVar = rVarArr[i13]) != null) {
                s1.d.g(rVar.length() == 1);
                s1.d.g(rVar.e(0) == 0);
                int iB = n1Var.b(rVar.k());
                s1.d.g(!zArr3[iB]);
                this.f9221c0++;
                zArr3[iB] = true;
                this.f9220b0 = rVar.l().f10029t | this.f9220b0;
                c1VarArr[i13] = new s0(this, iB);
                zArr2[i13] = true;
                if (!z2) {
                    b1 b1Var = this.O[iB];
                    z2 = (b1Var.t() == 0 || b1Var.G(true, j5)) ? false : true;
                }
            }
        }
        if (this.f9221c0 == 0) {
            this.f9225g0 = false;
            this.f9219a0 = false;
            this.f9220b0 = false;
            s2.m mVar = this.G;
            if (mVar.d()) {
                b1[] b1VarArr = this.O;
                int length = b1VarArr.length;
                while (i10 < length) {
                    b1VarArr[i10].k();
                    i10++;
                }
                mVar.a();
            } else {
                this.f9227i0 = false;
                for (b1 b1Var2 : this.O) {
                    b1Var2.D(false);
                }
            }
        } else if (z2) {
            j5 = t(j5);
            while (i10 < c1VarArr.length) {
                if (c1VarArr[i10] != null) {
                    zArr2[i10] = true;
                }
                i10++;
            }
        }
        this.Z = true;
        return j5;
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        this.M = a0Var;
        p1.q qVar = this.E;
        if (qVar == null) {
            this.I.e();
            F();
        } else {
            q(0, 3).d(qVar);
            E(new w2.y(-9223372036854775807L, new long[]{0}, new long[]{0}));
            e();
            this.f9224f0 = j5;
        }
    }

    @Override // o2.b0
    public final n1 p() {
        w();
        return (n1) this.U.f12868v;
    }

    @Override // w2.q
    public final w2.h0 q(int i, int i10) {
        return D(new t0(i, false));
    }

    @Override // o2.e1
    public final long r() {
        long jY;
        boolean z2;
        w();
        if (this.f9227i0 || this.f9221c0 == 0) {
            return Long.MIN_VALUE;
        }
        if (z()) {
            return this.f9224f0;
        }
        if (this.S) {
            int length = this.O.length;
            jY = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                ub.o oVar = this.U;
                if (((boolean[]) oVar.f12869w)[i] && ((boolean[]) oVar.f12870x)[i]) {
                    b1 b1Var = this.O[i];
                    synchronized (b1Var) {
                        z2 = b1Var.f9077w;
                    }
                    if (!z2) {
                        jY = Math.min(jY, this.O[i].q());
                    }
                }
            }
        } else {
            jY = Long.MAX_VALUE;
        }
        if (jY == Long.MAX_VALUE) {
            jY = y(false);
        }
        return jY == Long.MIN_VALUE ? this.f9223e0 : jY;
    }

    @Override // o2.b0
    public final void s() throws IOException {
        int iK = this.f9232x.k(this.Y);
        s2.m mVar = this.G;
        IOException iOException = mVar.f11769w;
        if (iOException != null) {
            throw iOException;
        }
        s2.i iVar = mVar.f11768v;
        if (iVar != null) {
            if (iK == Integer.MIN_VALUE) {
                iK = iVar.f11758u;
            }
            IOException iOException2 = iVar.f11762y;
            if (iOException2 != null && iVar.f11763z > iK) {
                throw iOException2;
            }
        }
        if (this.f9227i0 && !this.R) {
            throw p1.n0.a(null, "Loading finished before preparation is complete.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    @Override // o2.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long t(long r10) {
        /*
            r9 = this;
            r9.w()
            ub.o r0 = r9.U
            java.lang.Object r0 = r0.f12869w
            boolean[] r0 = (boolean[]) r0
            w2.b0 r1 = r9.V
            boolean r1 = r1.h()
            if (r1 == 0) goto L12
            goto L14
        L12:
            r10 = 0
        L14:
            r1 = 0
            r9.f9219a0 = r1
            long r2 = r9.f9223e0
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            r3 = 1
            if (r2 != 0) goto L20
            r2 = r3
            goto L21
        L20:
            r2 = r1
        L21:
            r9.f9223e0 = r10
            boolean r4 = r9.z()
            if (r4 == 0) goto L2c
            r9.f9224f0 = r10
            return r10
        L2c:
            int r4 = r9.Y
            r5 = 7
            s2.m r6 = r9.G
            if (r4 == r5) goto L73
            boolean r4 = r9.f9227i0
            if (r4 != 0) goto L3d
            boolean r4 = r6.d()
            if (r4 == 0) goto L73
        L3d:
            o2.b1[] r4 = r9.O
            int r4 = r4.length
            r5 = r1
        L41:
            if (r5 >= r4) goto L70
            o2.b1[] r7 = r9.O
            r7 = r7[r5]
            int r8 = r7.t()
            if (r8 != 0) goto L50
            if (r2 == 0) goto L50
            goto L6d
        L50:
            boolean r8 = r9.T
            if (r8 == 0) goto L5b
            int r8 = r7.f9071q
            boolean r7 = r7.F(r8)
            goto L61
        L5b:
            boolean r8 = r9.f9227i0
            boolean r7 = r7.G(r8, r10)
        L61:
            if (r7 != 0) goto L6d
            boolean r7 = r0[r5]
            if (r7 != 0) goto L6b
            boolean r7 = r9.S
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
            r9.f9225g0 = r1
            r9.f9224f0 = r10
            r9.f9227i0 = r1
            r9.f9220b0 = r1
            boolean r0 = r6.d()
            if (r0 == 0) goto L92
            o2.b1[] r0 = r9.O
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
            r6.f11769w = r0
            o2.b1[] r0 = r9.O
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
        throw new UnsupportedOperationException("Method not decompiled: o2.u0.t(long):long");
    }

    @Override // s2.h
    public final void u(s2.j jVar, long j5, long j8, boolean z2) {
        r0 r0Var = (r0) jVar;
        Uri uri = r0Var.f9201v.f13128w;
        u uVar = new u(j8);
        this.f9232x.getClass();
        this.f9233y.m(uVar, 1, -1, null, 0, null, r0Var.C, this.W);
        if (z2) {
            return;
        }
        for (b1 b1Var : this.O) {
            b1Var.D(false);
        }
        if (this.f9221c0 > 0) {
            a0 a0Var = this.M;
            a0Var.getClass();
            a0Var.d(this);
        }
    }

    public final void w() {
        s1.d.g(this.R);
        this.U.getClass();
        this.V.getClass();
    }

    public final int x() {
        int i = 0;
        for (b1 b1Var : this.O) {
            i += b1Var.f9071q + b1Var.f9070p;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long y(boolean r6) {
        /*
            r5 = this;
            r0 = -9223372036854775808
            r2 = 0
        L3:
            o2.b1[] r3 = r5.O
            int r3 = r3.length
            if (r2 >= r3) goto L26
            if (r6 != 0) goto L17
            ub.o r3 = r5.U
            r3.getClass()
            java.lang.Object r3 = r3.f12870x
            boolean[] r3 = (boolean[]) r3
            boolean r3 = r3[r2]
            if (r3 == 0) goto L23
        L17:
            o2.b1[] r3 = r5.O
            r3 = r3[r2]
            long r3 = r3.q()
            long r0 = java.lang.Math.max(r0, r3)
        L23:
            int r2 = r2 + 1
            goto L3
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.u0.y(boolean):long");
    }

    public final boolean z() {
        return this.f9224f0 != -9223372036854775807L;
    }

    @Override // o2.e1
    public final void v(long j5) {
    }
}
