package g2;

import a2.b1;
import a2.c1;
import aa.j0;
import aa.l0;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k8.a0;
import o2.a1;
import o2.e1;
import o2.n1;
import o2.u;
import p1.g1;
import p1.m0;
import s1.b0;
import v1.x;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements s2.h, s2.k, e1, w2.q, a1 {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Set f4905s0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public final f2.n A;
    public final f2.k B;
    public final a0 C;
    public final s2.m D = new s2.m("Loader:HlsSampleStreamWrapper");
    public final l0 E;
    public final int F;
    public final com.bumptech.glide.manager.s G;
    public final ArrayList H;
    public final List I;
    public final n J;
    public final n K;
    public final Handler L;
    public final ArrayList M;
    public final Map N;
    public p2.f O;
    public p[] P;
    public int[] Q;
    public final HashSet R;
    public final SparseIntArray S;
    public o T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public int Y;
    public p1.q Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public p1.q f4906a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f4907b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public n1 f4908c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Set f4909d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int[] f4910e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f4911f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f4912g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean[] f4913h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean[] f4914i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public long f4915j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public long f4916k0;
    public boolean l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f4917m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f4918n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f4919o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public long f4920p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public p1.m f4921q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public j f4922r0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f4923u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4924v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u5.c f4925w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i f4926x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s2.e f4927y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final p1.q f4928z;

    /* JADX WARN: Type inference failed for: r1v12, types: [g2.n] */
    /* JADX WARN: Type inference failed for: r1v13, types: [g2.n] */
    public q(String str, int i, u5.c cVar, i iVar, Map map, s2.e eVar, long j5, p1.q qVar, f2.n nVar, f2.k kVar, a0 a0Var, l0 l0Var, int i10) {
        this.f4923u = str;
        this.f4924v = i;
        this.f4925w = cVar;
        this.f4926x = iVar;
        this.N = map;
        this.f4927y = eVar;
        this.f4928z = qVar;
        this.A = nVar;
        this.B = kVar;
        this.C = a0Var;
        this.E = l0Var;
        this.F = i10;
        com.bumptech.glide.manager.s sVar = new com.bumptech.glide.manager.s(2);
        sVar.f2863x = null;
        final int i11 = 0;
        sVar.f2862w = false;
        sVar.f2861v = null;
        this.G = sVar;
        this.Q = new int[0];
        Set set = f4905s0;
        this.R = new HashSet(set.size());
        this.S = new SparseIntArray(set.size());
        this.P = new p[0];
        this.f4914i0 = new boolean[0];
        this.f4913h0 = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.H = arrayList;
        this.I = Collections.unmodifiableList(arrayList);
        this.M = new ArrayList();
        this.J = new Runnable(this) { // from class: g2.n

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ q f4898v;

            {
                this.f4898v = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f4898v.F();
                        break;
                    default:
                        q qVar2 = this.f4898v;
                        qVar2.W = true;
                        qVar2.F();
                        break;
                }
            }
        };
        final int i12 = 1;
        this.K = new Runnable(this) { // from class: g2.n

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ q f4898v;

            {
                this.f4898v = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f4898v.F();
                        break;
                    default:
                        q qVar2 = this.f4898v;
                        qVar2.W = true;
                        qVar2.F();
                        break;
                }
            }
        };
        this.L = b0.n(null);
        this.f4915j0 = j5;
        this.f4916k0 = j5;
    }

    public static p1.q A(p1.q qVar, p1.q qVar2, boolean z2) {
        String strC;
        if (qVar == null) {
            return qVar2;
        }
        String str = qVar.f10020k;
        String strE = qVar2.f10023n;
        int i = m0.i(strE);
        if (b0.s(str, i) == 1) {
            strC = b0.t(str, i);
            strE = m0.e(strC);
        } else {
            strC = m0.c(str, strE);
        }
        p1.p pVarA = qVar2.a();
        pVarA.f9957a = qVar.f10012a;
        pVarA.f9958b = qVar.f10013b;
        pVarA.f9959c = j0.r(qVar.f10014c);
        pVarA.f9960d = qVar.f10015d;
        pVarA.f9961e = qVar.f10016e;
        pVarA.f = qVar.f;
        pVarA.f9963h = z2 ? qVar.f10018h : -1;
        pVarA.i = z2 ? qVar.i : -1;
        pVarA.f9964j = strC;
        if (i == 2) {
            pVarA.f9974t = qVar.f10030u;
            pVarA.f9975u = qVar.f10031v;
            pVarA.f9978x = qVar.f10034y;
        }
        if (strE != null) {
            pVarA.f9967m = m0.p(strE);
        }
        int i10 = qVar.F;
        if (i10 != -1 && i == 1) {
            pVarA.E = i10;
        }
        p1.l0 l0VarB = qVar.f10021l;
        if (l0VarB != null) {
            p1.l0 l0Var = qVar2.f10021l;
            if (l0Var != null) {
                l0VarB = l0Var.b(l0VarB);
            }
            pVarA.f9965k = l0VarB;
        }
        return new p1.q(pVarA);
    }

    public static int D(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    public static w2.n y(int i, int i10) {
        s1.b.p("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i10);
        return new w2.n();
    }

    public final void B(int i) {
        ArrayList arrayList;
        s1.d.g(!this.D.d());
        while (true) {
            arrayList = this.H;
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (x(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j5 = C().B;
        j jVar = (j) arrayList.get(i);
        b0.T(arrayList, i, arrayList.size());
        for (int i10 = 0; i10 < this.P.length; i10++) {
            this.P[i10].n(jVar.g(i10));
        }
        if (arrayList.isEmpty()) {
            this.f4916k0 = this.f4915j0;
        } else {
            ((j) aa.q.k(arrayList)).f4885d0 = true;
        }
        this.f4918n0 = false;
        this.E.y(this.U, jVar.A, j5);
    }

    public final j C() {
        return (j) this.H.get(r0.size() - 1);
    }

    public final boolean E() {
        return this.f4916k0 != -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F() {
        int i;
        if (!this.f4907b0 && this.f4910e0 == null && this.W) {
            int i10 = 0;
            for (p pVar : this.P) {
                if (pVar.w() == null) {
                    return;
                }
            }
            n1 n1Var = this.f4908c0;
            if (n1Var != null) {
                int i11 = n1Var.f9178a;
                int[] iArr = new int[i11];
                this.f4910e0 = iArr;
                Arrays.fill(iArr, -1);
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = 0;
                    while (true) {
                        p[] pVarArr = this.P;
                        if (i13 < pVarArr.length) {
                            p1.q qVarW = pVarArr[i13].w();
                            s1.d.h(qVarW);
                            p1.q qVar = this.f4908c0.a(i12).f9765d[0];
                            String str = qVarW.f10023n;
                            String str2 = qVar.f10023n;
                            int i14 = m0.i(str);
                            if (i14 != 3) {
                                if (i14 == m0.i(str2)) {
                                    break;
                                } else {
                                    i13++;
                                }
                            } else if (Objects.equals(str, str2) && (!("application/cea-608".equals(str) || "application/cea-708".equals(str)) || qVarW.K == qVar.K)) {
                                break;
                            } else {
                                i13++;
                            }
                        }
                    }
                    this.f4910e0[i12] = i13;
                }
                ArrayList arrayList = this.M;
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((m) obj).a();
                }
                return;
            }
            int length = this.P.length;
            int i15 = 0;
            int i16 = -1;
            int i17 = -2;
            while (true) {
                int i18 = 1;
                if (i15 >= length) {
                    break;
                }
                p1.q qVarW2 = this.P[i15].w();
                s1.d.h(qVarW2);
                String str3 = qVarW2.f10023n;
                if (m0.o(str3)) {
                    i18 = 2;
                } else if (!m0.k(str3)) {
                    i18 = m0.n(str3) ? 3 : -2;
                }
                if (D(i18) > D(i17)) {
                    i16 = i15;
                    i17 = i18;
                } else if (i18 == i17 && i16 != -1) {
                    i16 = -1;
                }
                i15++;
            }
            g1 g1Var = this.f4926x.f4870h;
            int i19 = g1Var.f9762a;
            this.f4911f0 = -1;
            this.f4910e0 = new int[length];
            for (int i20 = 0; i20 < length; i20++) {
                this.f4910e0[i20] = i20;
            }
            g1[] g1VarArr = new g1[length];
            int i21 = 0;
            while (i21 < length) {
                p1.q qVarW3 = this.P[i21].w();
                s1.d.h(qVarW3);
                String str4 = this.f4923u;
                p1.q qVar2 = this.f4928z;
                if (i21 == i16) {
                    p1.q[] qVarArr = new p1.q[i19];
                    for (int i22 = i10; i22 < i19; i22++) {
                        p1.q qVarD = g1Var.f9765d[i22];
                        if (i17 == 1 && qVar2 != null) {
                            qVarD = qVarD.d(qVar2);
                        }
                        qVarArr[i22] = i19 == 1 ? qVarW3.d(qVarD) : A(qVarD, qVarW3, true);
                    }
                    g1VarArr[i21] = new g1(str4, qVarArr);
                    this.f4911f0 = i21;
                    i = 0;
                } else {
                    if (i17 != 2 || !m0.k(qVarW3.f10023n)) {
                        qVar2 = null;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append(":muxed:");
                    sb2.append(i21 < i16 ? i21 : i21 - 1);
                    i = 0;
                    g1VarArr[i21] = new g1(sb2.toString(), A(qVar2, qVarW3, false));
                }
                i21++;
                i10 = i;
            }
            int i23 = i10;
            this.f4908c0 = z(g1VarArr);
            s1.d.g(this.f4909d0 == null ? 1 : i23);
            this.f4909d0 = Collections.EMPTY_SET;
            this.X = true;
            this.f4925w.i();
        }
    }

    public final void G() throws IOException {
        this.D.b();
        i iVar = this.f4926x;
        o2.b bVar = iVar.f4875n;
        if (bVar != null) {
            throw bVar;
        }
        Uri uri = iVar.f4876o;
        if (uri == null || !uri.equals(iVar.f4877p)) {
            return;
        }
        h2.c cVar = iVar.f4869g;
        h2.b bVar2 = (h2.b) cVar.f5663x.get(iVar.f4876o);
        bVar2.f5655v.b();
        IOException iOException = bVar2.D;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final void H(g1[] g1VarArr, int... iArr) {
        this.f4908c0 = z(g1VarArr);
        this.f4909d0 = new HashSet();
        for (int i : iArr) {
            this.f4909d0.add(this.f4908c0.a(i));
        }
        this.f4911f0 = 0;
        this.L.post(new a2.a(16, this.f4925w));
        this.X = true;
    }

    public final void I() {
        for (p pVar : this.P) {
            pVar.D(this.l0);
        }
        this.l0 = false;
    }

    public final boolean J(boolean z2, long j5) {
        j jVar;
        boolean z10;
        boolean zG;
        this.f4915j0 = j5;
        if (E()) {
            this.f4916k0 = j5;
            return true;
        }
        boolean z11 = this.f4926x.f4878q;
        ArrayList arrayList = this.H;
        if (z11) {
            for (int i = 0; i < arrayList.size(); i++) {
                jVar = (j) arrayList.get(i);
                if (jVar.A == j5) {
                    break;
                }
            }
            jVar = null;
        } else {
            jVar = null;
        }
        if (this.W && !z2 && !arrayList.isEmpty()) {
            int length = this.P.length;
            for (int i10 = 0; i10 < length; i10++) {
                p pVar = this.P[i10];
                if (jVar != null) {
                    zG = pVar.F(jVar.g(i10));
                } else {
                    long jG = g();
                    zG = pVar.G(jG == Long.MIN_VALUE || j5 < jG, j5);
                }
                if (!zG && (this.f4914i0[i10] || !this.f4912g0)) {
                    z10 = false;
                    break;
                }
            }
            z10 = true;
            if (z10) {
                return false;
            }
        }
        this.f4916k0 = j5;
        this.f4918n0 = false;
        arrayList.clear();
        s2.m mVar = this.D;
        if (!mVar.d()) {
            mVar.f11769w = null;
            I();
            return true;
        }
        if (this.W) {
            for (p pVar2 : this.P) {
                pVar2.k();
            }
        }
        mVar.a();
        return true;
    }

    @Override // o2.a1
    public final void b() {
        this.L.post(this.J);
    }

    @Override // o2.e1
    public final boolean c() {
        return this.D.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s2.h
    public final void d(s2.j jVar, long j5, long j8) {
        p2.f fVar = (p2.f) jVar;
        this.O = null;
        if (fVar instanceof e) {
            e eVar = (e) fVar;
            byte[] bArr = eVar.D;
            i iVar = this.f4926x;
            iVar.f4874m = bArr;
            rc.b bVar = iVar.f4871j;
            Uri uri = eVar.f10144v.f13157a;
            byte[] bArr2 = eVar.F;
            bArr2.getClass();
            d dVar = (d) bVar.f11562v;
            uri.getClass();
        }
        long j10 = fVar.f10143u;
        Uri uri2 = fVar.C.f13128w;
        u uVar = new u(j8);
        this.C.getClass();
        this.E.o(uVar, fVar.f10145w, this.f4924v, fVar.f10146x, fVar.f10147y, fVar.f10148z, fVar.A, fVar.B);
        if (this.X) {
            this.f4925w.d(this);
            return;
        }
        b1 b1Var = new b1();
        b1Var.f164a = this.f4915j0;
        l(new c1(b1Var));
    }

    @Override // w2.q
    public final void e() {
        this.f4919o0 = true;
        this.L.post(this.K);
    }

    @Override // s2.k
    public final void f() {
        for (p pVar : this.P) {
            pVar.D(true);
            f2.h hVar = pVar.f9063h;
            if (hVar != null) {
                hVar.c(pVar.f9061e);
                pVar.f9063h = null;
                pVar.f9062g = null;
            }
        }
    }

    @Override // o2.e1
    public final long g() {
        if (E()) {
            return this.f4916k0;
        }
        if (this.f4918n0) {
            return Long.MIN_VALUE;
        }
        return C().B;
    }

    @Override // s2.h
    public final void k(s2.j jVar, long j5, long j8, int i) {
        u uVar;
        p2.f fVar = (p2.f) jVar;
        if (i == 0) {
            long j10 = fVar.f10143u;
            uVar = new u(fVar.f10144v);
        } else {
            long j11 = fVar.f10143u;
            Uri uri = fVar.C.f13128w;
            uVar = new u(j8);
        }
        u uVar2 = uVar;
        this.E.t(uVar2, fVar.f10145w, this.f4924v, fVar.f10146x, fVar.f10147y, fVar.f10148z, fVar.A, fVar.B, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0203  */
    @Override // o2.e1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(a2.c1 r75) {
        /*
            Method dump skipped, instruction units count: 1343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.q.l(a2.c1):boolean");
    }

    @Override // s2.h
    public final e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        boolean zO;
        e4.f fVar;
        int i10;
        p2.f fVar2 = (p2.f) jVar;
        boolean z2 = fVar2 instanceof j;
        if (z2 && !((j) fVar2).h() && (iOException instanceof x) && ((i10 = ((x) iOException).f13177x) == 410 || i10 == 404)) {
            return s2.m.f11764x;
        }
        long j10 = fVar2.C.f13127v;
        Uri uri = fVar2.C.f13128w;
        u uVar = new u(j8);
        b0.b0(fVar2.A);
        b0.b0(fVar2.B);
        e6.i iVar = new e6.i(i, iOException);
        i iVar2 = this.f4926x;
        j9.j0 j0VarF = b8.h.f(iVar2.f4879r);
        this.C.getClass();
        e4.f fVarJ = a0.j(j0VarF, iVar);
        if (fVarJ == null || fVarJ.f4419a != 2) {
            zO = false;
        } else {
            long j11 = fVarJ.f4420b;
            r2.r rVar = iVar2.f4879r;
            zO = rVar.o(rVar.u(iVar2.f4870h.a(fVar2.f10146x)), j11);
        }
        if (zO) {
            if (z2 && j10 == 0) {
                ArrayList arrayList = this.H;
                s1.d.g(((j) arrayList.remove(arrayList.size() - 1)) == fVar2);
                if (arrayList.isEmpty()) {
                    this.f4916k0 = this.f4915j0;
                } else {
                    ((j) aa.q.k(arrayList)).f4885d0 = true;
                }
            }
            fVar = s2.m.f11765y;
        } else {
            long jN = a0.n(iVar);
            fVar = jN != -9223372036854775807L ? new e4.f(0, jN, false) : s2.m.f11766z;
        }
        e4.f fVar3 = fVar;
        boolean zA = fVar3.a();
        this.E.q(uVar, fVar2.f10145w, this.f4924v, fVar2.f10146x, fVar2.f10147y, fVar2.f10148z, fVar2.A, fVar2.B, iOException, !zA);
        if (!zA) {
            this.O = null;
        }
        if (zO) {
            if (!this.X) {
                b1 b1Var = new b1();
                b1Var.f164a = this.f4915j0;
                l(new c1(b1Var));
                return fVar3;
            }
            this.f4925w.d(this);
        }
        return fVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [g2.p[]] */
    /* JADX WARN: Type inference failed for: r1v1, types: [g2.p[]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [w2.h0] */
    /* JADX WARN: Type inference failed for: r5v4, types: [g2.p, o2.b1] */
    /* JADX WARN: Type inference failed for: r5v6, types: [w2.n] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // w2.q
    public final h0 q(int i, int i10) {
        Integer numValueOf = Integer.valueOf(i10);
        Set set = f4905s0;
        boolean zContains = set.contains(numValueOf);
        HashSet hashSet = this.R;
        SparseIntArray sparseIntArray = this.S;
        ?? pVar = 0;
        pVar = 0;
        if (zContains) {
            s1.d.b(set.contains(Integer.valueOf(i10)));
            int i11 = sparseIntArray.get(i10, -1);
            if (i11 != -1) {
                if (hashSet.add(Integer.valueOf(i10))) {
                    this.Q[i11] = i;
                }
                pVar = this.Q[i11] == i ? this.P[i11] : y(i, i10);
            }
        } else {
            int i12 = 0;
            while (true) {
                ?? r12 = this.P;
                if (i12 >= r12.length) {
                    break;
                }
                if (this.Q[i12] == i) {
                    pVar = r12[i12];
                    break;
                }
                i12++;
            }
        }
        if (pVar == 0) {
            if (this.f4919o0) {
                return y(i, i10);
            }
            int length = this.P.length;
            boolean z2 = i10 == 1 || i10 == 2;
            pVar = new p(this.f4927y, this.A, this.B, this.N);
            pVar.f9074t = this.f4915j0;
            if (z2) {
                pVar.I = this.f4921q0;
                pVar.f9080z = true;
            }
            long j5 = this.f4920p0;
            if (pVar.F != j5) {
                pVar.F = j5;
                pVar.f9080z = true;
            }
            if (this.f4922r0 != null) {
                pVar.C = r6.E;
            }
            pVar.f = this;
            int i13 = length + 1;
            int[] iArrCopyOf = Arrays.copyOf(this.Q, i13);
            this.Q = iArrCopyOf;
            iArrCopyOf[length] = i;
            p[] pVarArr = this.P;
            int i14 = b0.f11647a;
            ?? CopyOf = Arrays.copyOf(pVarArr, pVarArr.length + 1);
            CopyOf[pVarArr.length] = pVar;
            this.P = (p[]) CopyOf;
            boolean[] zArrCopyOf = Arrays.copyOf(this.f4914i0, i13);
            this.f4914i0 = zArrCopyOf;
            zArrCopyOf[length] = z2;
            this.f4912g0 |= z2;
            hashSet.add(Integer.valueOf(i10));
            sparseIntArray.append(i10, length);
            if (D(i10) > D(this.U)) {
                this.V = length;
                this.U = i10;
            }
            this.f4913h0 = Arrays.copyOf(this.f4913h0, i13);
        }
        if (i10 != 5) {
            return pVar;
        }
        if (this.T == null) {
            this.T = new o(pVar, this.F);
        }
        return this.T;
    }

    @Override // o2.e1
    public final long r() {
        if (this.f4918n0) {
            return Long.MIN_VALUE;
        }
        if (E()) {
            return this.f4916k0;
        }
        long jMax = this.f4915j0;
        j jVarC = C();
        if (!jVarC.f4883b0) {
            ArrayList arrayList = this.H;
            jVarC = arrayList.size() > 1 ? (j) arrayList.get(arrayList.size() - 2) : null;
        }
        if (jVarC != null) {
            jMax = Math.max(jMax, jVarC.B);
        }
        if (this.W) {
            for (p pVar : this.P) {
                jMax = Math.max(jMax, pVar.q());
            }
        }
        return jMax;
    }

    @Override // s2.h
    public final void u(s2.j jVar, long j5, long j8, boolean z2) {
        p2.f fVar = (p2.f) jVar;
        this.O = null;
        long j10 = fVar.f10143u;
        Uri uri = fVar.C.f13128w;
        u uVar = new u(j8);
        this.C.getClass();
        this.E.m(uVar, fVar.f10145w, this.f4924v, fVar.f10146x, fVar.f10147y, fVar.f10148z, fVar.A, fVar.B);
        if (z2) {
            return;
        }
        if (E() || this.Y == 0) {
            I();
        }
        if (this.Y > 0) {
            this.f4925w.d(this);
        }
    }

    @Override // o2.e1
    public final void v(long j5) {
        s2.m mVar = this.D;
        if (mVar.c() || E()) {
            return;
        }
        boolean zD = mVar.d();
        i iVar = this.f4926x;
        List list = this.I;
        if (zD) {
            this.O.getClass();
            if (iVar.f4875n != null ? false : iVar.f4879r.i(j5, this.O, list)) {
                mVar.a();
                return;
            }
            return;
        }
        int size = list.size();
        while (size > 0 && iVar.b((j) list.get(size - 1)) == 2) {
            size--;
        }
        if (size < list.size()) {
            B(size);
        }
        int size2 = (iVar.f4875n != null || iVar.f4879r.length() < 2) ? list.size() : iVar.f4879r.f(j5, list);
        if (size2 < this.H.size()) {
            B(size2);
        }
    }

    public final void w() {
        s1.d.g(this.X);
        this.f4908c0.getClass();
        this.f4909d0.getClass();
    }

    public final boolean x(int i) {
        int i10 = i;
        while (true) {
            ArrayList arrayList = this.H;
            if (i10 >= arrayList.size()) {
                j jVar = (j) arrayList.get(i);
                for (int i11 = 0; i11 < this.P.length; i11++) {
                    if (this.P[i11].t() > jVar.g(i11)) {
                        return false;
                    }
                }
                return true;
            }
            if (((j) arrayList.get(i10)).f4887f0) {
                return false;
            }
            i10++;
        }
    }

    public final n1 z(g1[] g1VarArr) {
        for (int i = 0; i < g1VarArr.length; i++) {
            g1 g1Var = g1VarArr[i];
            p1.q[] qVarArr = new p1.q[g1Var.f9762a];
            for (int i10 = 0; i10 < g1Var.f9762a; i10++) {
                p1.q qVar = g1Var.f9765d[i10];
                int iF = this.A.f(qVar);
                p1.p pVarA = qVar.a();
                pVarA.N = iF;
                qVarArr[i10] = new p1.q(pVarA);
            }
            g1VarArr[i] = new g1(g1Var.f9763b, qVarArr);
        }
        return new n1(g1VarArr);
    }

    @Override // w2.q
    public final void j(w2.b0 b0Var) {
    }
}
