package m2;

import a3.c0;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.emoji2.text.w;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.i4;
import f9.a0;
import g2.r0;
import g2.s0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import qb.t1;
import s2.c1;
import s2.l1;
import s2.y0;
import ua.i0;
import v1.g1;
import v1.l0;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements w2.i, w2.l, c1, a3.r, y0 {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Set f8110t0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public final v1.p A;
    public final l2.n B;
    public final l2.k C;
    public final a0 D;
    public final w2.o E = new w2.o("Loader:HlsSampleStreamWrapper");
    public final f3.a F;
    public final int G;
    public final i4 H;
    public final ArrayList I;
    public final List J;
    public final o K;
    public final o L;
    public final Handler M;
    public final ArrayList N;
    public final Map O;
    public t2.e P;
    public q[] Q;
    public int[] R;
    public final HashSet S;
    public final SparseIntArray T;
    public p U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public v1.p f8111a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public v1.p f8112b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f8113c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public l1 f8114d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Set f8115e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int[] f8116f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f8117g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f8118h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean[] f8119i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean[] f8120j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public long f8121k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public long f8122l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f8123m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f8124n0;
    public boolean o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f8125p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public long f8126q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public v1.l f8127r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public k f8128s0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f8129v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f8130w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final kf.i f8131x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j f8132y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final w2.e f8133z;

    /* JADX WARN: Type inference failed for: r1v12, types: [m2.o] */
    /* JADX WARN: Type inference failed for: r1v13, types: [m2.o] */
    public r(String str, int i, kf.i iVar, j jVar, Map map, w2.e eVar, long j4, v1.p pVar, l2.n nVar, l2.k kVar, a0 a0Var, f3.a aVar, int i10) {
        this.f8129v = str;
        this.f8130w = i;
        this.f8131x = iVar;
        this.f8132y = jVar;
        this.O = map;
        this.f8133z = eVar;
        this.A = pVar;
        this.B = nVar;
        this.C = kVar;
        this.D = a0Var;
        this.F = aVar;
        this.G = i10;
        i4 i4Var = new i4(3);
        i4Var.f2483x = null;
        final int i11 = 0;
        i4Var.f2482w = false;
        i4Var.f2484y = null;
        this.H = i4Var;
        this.R = new int[0];
        Set set = f8110t0;
        this.S = new HashSet(set.size());
        this.T = new SparseIntArray(set.size());
        this.Q = new q[0];
        this.f8120j0 = new boolean[0];
        this.f8119i0 = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.I = arrayList;
        this.J = Collections.unmodifiableList(arrayList);
        this.N = new ArrayList();
        this.K = new Runnable(this) { // from class: m2.o

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ r f8103w;

            {
                this.f8103w = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f8103w.F();
                        break;
                    default:
                        r rVar = this.f8103w;
                        rVar.X = true;
                        rVar.F();
                        break;
                }
            }
        };
        final int i12 = 1;
        this.L = new Runnable(this) { // from class: m2.o

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ r f8103w;

            {
                this.f8103w = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f8103w.F();
                        break;
                    default:
                        r rVar = this.f8103w;
                        rVar.X = true;
                        rVar.F();
                        break;
                }
            }
        };
        this.M = y1.a0.n(null);
        this.f8121k0 = j4;
        this.f8122l0 = j4;
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

    public static a3.o x(int i, int i10) {
        y1.b.p("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i10);
        return new a3.o();
    }

    public static v1.p z(v1.p pVar, v1.p pVar2, boolean z10) {
        String strC;
        if (pVar == null) {
            return pVar2;
        }
        String str = pVar.f12943k;
        String strE = pVar2.f12946n;
        int i = m0.i(strE);
        if (y1.a0.s(i, str) == 1) {
            strC = y1.a0.t(i, str);
            strE = m0.e(strC);
        } else {
            strC = m0.c(str, strE);
        }
        v1.o oVarA = pVar2.a();
        oVarA.f12883a = pVar.f12935a;
        oVarA.f12884b = pVar.f12936b;
        oVarA.f12885c = i0.k(pVar.f12937c);
        oVarA.f12886d = pVar.f12938d;
        oVarA.f12887e = pVar.f12939e;
        oVarA.f = pVar.f;
        oVarA.f12889h = z10 ? pVar.f12941h : -1;
        oVarA.i = z10 ? pVar.i : -1;
        oVarA.f12890j = strC;
        if (i == 2) {
            oVarA.f12900t = pVar.f12953u;
            oVarA.f12901u = pVar.f12954v;
            oVarA.f12904x = pVar.f12957y;
        }
        if (strE != null) {
            oVarA.f12893m = m0.p(strE);
        }
        int i10 = pVar.F;
        if (i10 != -1 && i == 1) {
            oVarA.E = i10;
        }
        l0 l0VarB = pVar.f12944l;
        if (l0VarB != null) {
            l0 l0Var = pVar2.f12944l;
            if (l0Var != null) {
                l0VarB = l0Var.b(l0VarB);
            }
            oVarA.f12891k = l0VarB;
        }
        return new v1.p(oVarA);
    }

    public final void A(int i) {
        ArrayList arrayList;
        y1.d.g(!this.E.d());
        while (true) {
            arrayList = this.I;
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (w(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j4 = C().C;
        k kVar = (k) arrayList.get(i);
        y1.a0.T(arrayList, i, arrayList.size());
        for (int i10 = 0; i10 < this.Q.length; i10++) {
            this.Q[i10].n(kVar.g(i10));
        }
        if (arrayList.isEmpty()) {
            this.f8122l0 = this.f8121k0;
        } else {
            ((k) ua.q.l(arrayList)).f8080e0 = true;
        }
        this.o0 = false;
        this.F.z(this.V, kVar.B, j4);
    }

    @Override // w2.i
    public final void B(w2.k kVar, long j4, long j7, int i) {
        s2.t tVar;
        t2.e eVar = (t2.e) kVar;
        if (i == 0) {
            long j10 = eVar.f11848v;
            tVar = new s2.t(eVar.f11849w);
        } else {
            long j11 = eVar.f11848v;
            Uri uri = eVar.D.f1686x;
            tVar = new s2.t(j7);
        }
        s2.t tVar2 = tVar;
        this.F.s(tVar2, eVar.f11850x, this.f8130w, eVar.f11851y, eVar.f11852z, eVar.A, eVar.B, eVar.C, i);
    }

    public final k C() {
        return (k) this.I.get(r0.size() - 1);
    }

    public final boolean E() {
        return this.f8122l0 != -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F() {
        int i;
        if (!this.f8113c0 && this.f8116f0 == null && this.X) {
            int i10 = 0;
            for (q qVar : this.Q) {
                if (qVar.w() == null) {
                    return;
                }
            }
            l1 l1Var = this.f8114d0;
            if (l1Var != null) {
                int i11 = l1Var.f11262a;
                int[] iArr = new int[i11];
                this.f8116f0 = iArr;
                Arrays.fill(iArr, -1);
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = 0;
                    while (true) {
                        q[] qVarArr = this.Q;
                        if (i13 < qVarArr.length) {
                            v1.p pVarW = qVarArr[i13].w();
                            y1.d.h(pVarW);
                            v1.p pVar = this.f8114d0.a(i12).f12705d[0];
                            String str = pVarW.f12946n;
                            String str2 = pVar.f12946n;
                            int i14 = m0.i(str);
                            if (i14 != 3) {
                                if (i14 == m0.i(str2)) {
                                    break;
                                } else {
                                    i13++;
                                }
                            } else if (Objects.equals(str, str2) && (!("application/cea-608".equals(str) || "application/cea-708".equals(str)) || pVarW.K == pVar.K)) {
                                break;
                            } else {
                                i13++;
                            }
                        }
                    }
                    this.f8116f0[i12] = i13;
                }
                ArrayList arrayList = this.N;
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((n) obj).a();
                }
                return;
            }
            int length = this.Q.length;
            int i15 = 0;
            int i16 = -1;
            int i17 = -2;
            while (true) {
                int i18 = 1;
                if (i15 >= length) {
                    break;
                }
                v1.p pVarW2 = this.Q[i15].w();
                y1.d.h(pVarW2);
                String str3 = pVarW2.f12946n;
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
            g1 g1Var = this.f8132y.f8064h;
            int i19 = g1Var.f12702a;
            this.f8117g0 = -1;
            this.f8116f0 = new int[length];
            for (int i20 = 0; i20 < length; i20++) {
                this.f8116f0[i20] = i20;
            }
            g1[] g1VarArr = new g1[length];
            int i21 = 0;
            while (i21 < length) {
                v1.p pVarW3 = this.Q[i21].w();
                y1.d.h(pVarW3);
                String str4 = this.f8129v;
                v1.p pVar2 = this.A;
                if (i21 == i16) {
                    v1.p[] pVarArr = new v1.p[i19];
                    for (int i22 = i10; i22 < i19; i22++) {
                        v1.p pVarD = g1Var.f12705d[i22];
                        if (i17 == 1 && pVar2 != null) {
                            pVarD = pVarD.d(pVar2);
                        }
                        pVarArr[i22] = i19 == 1 ? pVarW3.d(pVarD) : z(pVarD, pVarW3, true);
                    }
                    g1VarArr[i21] = new g1(str4, pVarArr);
                    this.f8117g0 = i21;
                    i = 0;
                } else {
                    if (i17 != 2 || !m0.k(pVarW3.f12946n)) {
                        pVar2 = null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(":muxed:");
                    sb.append(i21 < i16 ? i21 : i21 - 1);
                    i = 0;
                    g1VarArr[i21] = new g1(sb.toString(), z(pVar2, pVarW3, false));
                }
                i21++;
                i10 = i;
            }
            int i23 = i10;
            this.f8114d0 = y(g1VarArr);
            y1.d.g(this.f8115e0 == null ? 1 : i23);
            this.f8115e0 = Collections.EMPTY_SET;
            this.Y = true;
            this.f8131x.I();
        }
    }

    public final void G() throws IOException {
        this.E.c();
        j jVar = this.f8132y;
        s2.b bVar = jVar.f8069n;
        if (bVar != null) {
            throw bVar;
        }
        Uri uri = jVar.f8070o;
        if (uri == null || !uri.equals(jVar.f8071p)) {
            return;
        }
        n2.c cVar = jVar.f8063g;
        n2.b bVar2 = (n2.b) cVar.f8640y.get(jVar.f8070o);
        bVar2.f8633w.c();
        IOException iOException = bVar2.E;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final void H(g1[] g1VarArr, int... iArr) {
        this.f8114d0 = y(g1VarArr);
        this.f8115e0 = new HashSet();
        for (int i : iArr) {
            this.f8115e0.add(this.f8114d0.a(i));
        }
        this.f8117g0 = 0;
        this.M.post(new w(23, this.f8131x));
        this.Y = true;
    }

    public final void I() {
        for (q qVar : this.Q) {
            qVar.D(this.f8123m0);
        }
        this.f8123m0 = false;
    }

    public final boolean J(boolean z10, long j4) {
        k kVar;
        boolean z11;
        boolean zG;
        this.f8121k0 = j4;
        if (E()) {
            this.f8122l0 = j4;
            return true;
        }
        boolean z12 = this.f8132y.f8072q;
        ArrayList arrayList = this.I;
        if (z12) {
            for (int i = 0; i < arrayList.size(); i++) {
                kVar = (k) arrayList.get(i);
                if (kVar.B == j4) {
                    break;
                }
            }
            kVar = null;
        } else {
            kVar = null;
        }
        if (this.X && !z10 && !arrayList.isEmpty()) {
            int length = this.Q.length;
            for (int i10 = 0; i10 < length; i10++) {
                q qVar = this.Q[i10];
                if (kVar != null) {
                    zG = qVar.F(kVar.g(i10));
                } else {
                    long j7 = j();
                    zG = qVar.G(j7 == Long.MIN_VALUE || j4 < j7, j4);
                }
                if (!zG && (this.f8120j0[i10] || !this.f8118h0)) {
                    z11 = false;
                    break;
                }
            }
            z11 = true;
            if (z11) {
                return false;
            }
        }
        this.f8122l0 = j4;
        this.o0 = false;
        arrayList.clear();
        w2.o oVar = this.E;
        if (!oVar.d()) {
            oVar.f13886c = null;
            I();
            return true;
        }
        if (this.X) {
            for (q qVar2 : this.Q) {
                qVar2.k();
            }
        }
        oVar.a();
        return true;
    }

    @Override // s2.c1
    public final boolean a() {
        return this.E.d();
    }

    @Override // s2.y0
    public final void b() {
        this.M.post(this.K);
    }

    public final void c() {
        y1.d.g(this.Y);
        this.f8114d0.getClass();
        this.f8115e0.getClass();
    }

    @Override // a3.r
    public final void e() {
        this.f8125p0 = true;
        this.M.post(this.L);
    }

    @Override // w2.l
    public final void f() {
        for (q qVar : this.Q) {
            qVar.D(true);
            l2.h hVar = qVar.f11379h;
            if (hVar != null) {
                hVar.c(qVar.f11377e);
                qVar.f11379h = null;
                qVar.f11378g = null;
            }
        }
    }

    @Override // w2.i
    public final i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        boolean zM;
        i4.e eVar;
        int i10;
        t2.e eVar2 = (t2.e) kVar;
        boolean z10 = eVar2 instanceof k;
        if (z10 && !((k) eVar2).h() && (iOException instanceof b2.a0) && ((i10 = ((b2.a0) iOException).f1671y) == 410 || i10 == 404)) {
            return w2.o.f13882d;
        }
        long j10 = eVar2.D.f1685w;
        Uri uri = eVar2.D.f1686x;
        s2.t tVar = new s2.t(j7);
        y1.a0.b0(eVar2.B);
        y1.a0.b0(eVar2.C);
        ag.o oVar = new ag.o(i, 10, iOException);
        j jVar = this.f8132y;
        w2.h hVarC = t1.c(jVar.f8073r);
        this.D.getClass();
        i4.e eVarK = a0.k(hVarC, oVar);
        if (eVarK == null || eVarK.f6206a != 2) {
            zM = false;
        } else {
            long j11 = eVarK.f6207b;
            v2.q qVar = jVar.f8073r;
            zM = qVar.m(qVar.u(jVar.f8064h.a(eVar2.f11851y)), j11);
        }
        if (zM) {
            if (z10 && j10 == 0) {
                ArrayList arrayList = this.I;
                y1.d.g(((k) arrayList.remove(arrayList.size() - 1)) == eVar2);
                if (arrayList.isEmpty()) {
                    this.f8122l0 = this.f8121k0;
                } else {
                    ((k) ua.q.l(arrayList)).f8080e0 = true;
                }
            }
            eVar = w2.o.f13883e;
        } else {
            long jQ = a0.q(oVar);
            eVar = jQ != -9223372036854775807L ? new i4.e(0, jQ, false) : w2.o.f;
        }
        i4.e eVar3 = eVar;
        boolean zA = eVar3.a();
        this.F.p(tVar, eVar2.f11850x, this.f8130w, eVar2.f11851y, eVar2.f11852z, eVar2.A, eVar2.B, eVar2.C, iOException, !zA);
        if (!zA) {
            this.P = null;
        }
        if (zM) {
            if (!this.Y) {
                r0 r0Var = new r0();
                r0Var.f4888a = this.f8121k0;
                i(new s0(r0Var));
                return eVar3;
            }
            this.f8131x.f(this);
        }
        return eVar3;
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
    @Override // s2.c1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(g2.s0 r75) {
        /*
            Method dump skipped, instruction units count: 1343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.r.i(g2.s0):boolean");
    }

    @Override // s2.c1
    public final long j() {
        if (E()) {
            return this.f8122l0;
        }
        if (this.o0) {
            return Long.MIN_VALUE;
        }
        return C().C;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.i
    public final void k(w2.k kVar, long j4, long j7) {
        t2.e eVar = (t2.e) kVar;
        this.P = null;
        if (eVar instanceof f) {
            f fVar = (f) eVar;
            byte[] bArr = fVar.E;
            j jVar = this.f8132y;
            jVar.f8068m = bArr;
            e eVar2 = jVar.f8065j;
            Uri uri = fVar.f11849w.f1714a;
            byte[] bArr2 = fVar.G;
            bArr2.getClass();
            d dVar = (d) eVar2.f8050v;
            uri.getClass();
        }
        long j10 = eVar.f11848v;
        Uri uri2 = eVar.D.f1686x;
        s2.t tVar = new s2.t(j7);
        this.D.getClass();
        this.F.o(tVar, eVar.f11850x, this.f8130w, eVar.f11851y, eVar.f11852z, eVar.A, eVar.B, eVar.C);
        if (this.Y) {
            this.f8131x.f(this);
            return;
        }
        r0 r0Var = new r0();
        r0Var.f4888a = this.f8121k0;
        i(new s0(r0Var));
    }

    @Override // w2.i
    public final void n(w2.k kVar, long j4, long j7, boolean z10) {
        t2.e eVar = (t2.e) kVar;
        this.P = null;
        long j10 = eVar.f11848v;
        Uri uri = eVar.D.f1686x;
        s2.t tVar = new s2.t(j7);
        this.D.getClass();
        this.F.n(tVar, eVar.f11850x, this.f8130w, eVar.f11851y, eVar.f11852z, eVar.A, eVar.B, eVar.C);
        if (z10) {
            return;
        }
        if (E() || this.Z == 0) {
            I();
        }
        if (this.Z > 0) {
            this.f8131x.f(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [m2.q[]] */
    /* JADX WARN: Type inference failed for: r1v1, types: [m2.q[]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [a3.i0] */
    /* JADX WARN: Type inference failed for: r5v4, types: [m2.q, s2.z0] */
    /* JADX WARN: Type inference failed for: r5v6, types: [a3.o] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // a3.r
    public final a3.i0 p(int i, int i10) {
        Integer numValueOf = Integer.valueOf(i10);
        Set set = f8110t0;
        boolean zContains = set.contains(numValueOf);
        HashSet hashSet = this.S;
        SparseIntArray sparseIntArray = this.T;
        ?? qVar = 0;
        qVar = 0;
        if (zContains) {
            y1.d.b(set.contains(Integer.valueOf(i10)));
            int i11 = sparseIntArray.get(i10, -1);
            if (i11 != -1) {
                if (hashSet.add(Integer.valueOf(i10))) {
                    this.R[i11] = i;
                }
                qVar = this.R[i11] == i ? this.Q[i11] : x(i, i10);
            }
        } else {
            int i12 = 0;
            while (true) {
                ?? r12 = this.Q;
                if (i12 >= r12.length) {
                    break;
                }
                if (this.R[i12] == i) {
                    qVar = r12[i12];
                    break;
                }
                i12++;
            }
        }
        if (qVar == 0) {
            if (this.f8125p0) {
                return x(i, i10);
            }
            int length = this.Q.length;
            boolean z10 = i10 == 1 || i10 == 2;
            qVar = new q(this.f8133z, this.B, this.C, this.O);
            qVar.f11390t = this.f8121k0;
            if (z10) {
                qVar.I = this.f8127r0;
                qVar.f11396z = true;
            }
            long j4 = this.f8126q0;
            if (qVar.F != j4) {
                qVar.F = j4;
                qVar.f11396z = true;
            }
            if (this.f8128s0 != null) {
                qVar.C = r6.F;
            }
            qVar.f = this;
            int i13 = length + 1;
            int[] iArrCopyOf = Arrays.copyOf(this.R, i13);
            this.R = iArrCopyOf;
            iArrCopyOf[length] = i;
            q[] qVarArr = this.Q;
            int i14 = y1.a0.f14551a;
            ?? CopyOf = Arrays.copyOf(qVarArr, qVarArr.length + 1);
            CopyOf[qVarArr.length] = qVar;
            this.Q = (q[]) CopyOf;
            boolean[] zArrCopyOf = Arrays.copyOf(this.f8120j0, i13);
            this.f8120j0 = zArrCopyOf;
            zArrCopyOf[length] = z10;
            this.f8118h0 |= z10;
            hashSet.add(Integer.valueOf(i10));
            sparseIntArray.append(i10, length);
            if (D(i10) > D(this.V)) {
                this.W = length;
                this.V = i10;
            }
            this.f8119i0 = Arrays.copyOf(this.f8119i0, i13);
        }
        if (i10 != 5) {
            return qVar;
        }
        if (this.U == null) {
            this.U = new p(qVar, this.G);
        }
        return this.U;
    }

    @Override // s2.c1
    public final long q() {
        if (this.o0) {
            return Long.MIN_VALUE;
        }
        if (E()) {
            return this.f8122l0;
        }
        long jMax = this.f8121k0;
        k kVarC = C();
        if (!kVarC.f8078c0) {
            ArrayList arrayList = this.I;
            kVarC = arrayList.size() > 1 ? (k) arrayList.get(arrayList.size() - 2) : null;
        }
        if (kVarC != null) {
            jMax = Math.max(jMax, kVarC.C);
        }
        if (this.X) {
            for (q qVar : this.Q) {
                jMax = Math.max(jMax, qVar.q());
            }
        }
        return jMax;
    }

    @Override // s2.c1
    public final void u(long j4) {
        w2.o oVar = this.E;
        if (oVar.b() || E()) {
            return;
        }
        boolean zD = oVar.d();
        j jVar = this.f8132y;
        List list = this.J;
        if (zD) {
            this.P.getClass();
            if (jVar.f8069n != null ? false : jVar.f8073r.t(j4, this.P, list)) {
                oVar.a();
                return;
            }
            return;
        }
        int size = list.size();
        while (size > 0 && jVar.b((k) list.get(size - 1)) == 2) {
            size--;
        }
        if (size < list.size()) {
            A(size);
        }
        int size2 = (jVar.f8069n != null || jVar.f8073r.length() < 2) ? list.size() : jVar.f8073r.f(j4, list);
        if (size2 < this.I.size()) {
            A(size2);
        }
    }

    public final boolean w(int i) {
        int i10 = i;
        while (true) {
            ArrayList arrayList = this.I;
            if (i10 >= arrayList.size()) {
                k kVar = (k) arrayList.get(i);
                for (int i11 = 0; i11 < this.Q.length; i11++) {
                    if (this.Q[i11].t() > kVar.g(i11)) {
                        return false;
                    }
                }
                return true;
            }
            if (((k) arrayList.get(i10)).f8082g0) {
                return false;
            }
            i10++;
        }
    }

    public final l1 y(g1[] g1VarArr) {
        for (int i = 0; i < g1VarArr.length; i++) {
            g1 g1Var = g1VarArr[i];
            v1.p[] pVarArr = new v1.p[g1Var.f12702a];
            for (int i10 = 0; i10 < g1Var.f12702a; i10++) {
                v1.p pVar = g1Var.f12705d[i10];
                int iH = this.B.h(pVar);
                v1.o oVarA = pVar.a();
                oVarA.N = iH;
                pVarArr[i10] = new v1.p(oVarA);
            }
            g1VarArr[i] = new g1(g1Var.f12703b, pVarArr);
        }
        return new l1(g1VarArr);
    }

    @Override // a3.r
    public final void s(c0 c0Var) {
    }
}
