package m2;

import android.net.Uri;
import android.util.SparseArray;
import b2.h0;
import f9.z;
import g2.r0;
import g2.r1;
import g2.s0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import s2.a0;
import s2.l1;
import ua.g0;
import ua.i0;
import ua.z0;
import v1.g1;
import v1.l0;
import v1.m0;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements a0, n2.t {
    public final l2.k A;
    public final f9.a0 B;
    public final f3.a C;
    public final w2.e D;
    public final IdentityHashMap E;
    public final l4.a F;
    public final z G;
    public final boolean H;
    public final int I;
    public final h2.l J;
    public final kf.i K = new kf.i(5, this);
    public s2.z L;
    public int M;
    public l1 N;
    public r[] O;
    public r[] P;
    public int Q;
    public s2.n R;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f8083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final n2.c f8084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l4.a f8085x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h0 f8086y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final l2.n f8087z;

    public l(c cVar, n2.c cVar2, l4.a aVar, h0 h0Var, l2.n nVar, l2.k kVar, f9.a0 a0Var, f3.a aVar2, w2.e eVar, z zVar, boolean z10, int i, h2.l lVar) {
        this.f8083v = cVar;
        this.f8084w = cVar2;
        this.f8085x = aVar;
        this.f8086y = h0Var;
        this.f8087z = nVar;
        this.A = kVar;
        this.B = a0Var;
        this.C = aVar2;
        this.D = eVar;
        this.G = zVar;
        this.H = z10;
        this.I = i;
        this.J = lVar;
        zVar.getClass();
        g0 g0Var = i0.f12341w;
        z0 z0Var = z0.f12413z;
        this.R = new s2.n(z0Var, z0Var);
        this.E = new IdentityHashMap();
        this.F = new l4.a(4, false);
        this.O = new r[0];
        this.P = new r[0];
    }

    public static v1.p f(v1.p pVar, v1.p pVar2, boolean z10) {
        l0 l0Var;
        int i;
        String str;
        String str2;
        i0 i0Var;
        int i10;
        int i11;
        String str3;
        g0 g0Var = i0.f12341w;
        z0 z0Var = z0.f12413z;
        if (pVar2 != null) {
            str2 = pVar2.f12943k;
            l0Var = pVar2.f12944l;
            i10 = pVar2.F;
            i = pVar2.f12939e;
            i11 = pVar2.f;
            str = pVar2.f12938d;
            str3 = pVar2.f12936b;
            i0Var = pVar2.f12937c;
        } else {
            String strT = y1.a0.t(1, pVar.f12943k);
            l0Var = pVar.f12944l;
            if (z10) {
                i10 = pVar.F;
                i = pVar.f12939e;
                i11 = pVar.f;
                str = pVar.f12938d;
                str3 = pVar.f12936b;
                str2 = strT;
                i0Var = pVar.f12937c;
            } else {
                i = 0;
                str = null;
                str2 = strT;
                i0Var = z0Var;
                i10 = -1;
                i11 = 0;
                str3 = null;
            }
        }
        String strE = m0.e(str2);
        int i12 = z10 ? pVar.f12941h : -1;
        int i13 = z10 ? pVar.i : -1;
        v1.o oVar = new v1.o();
        oVar.f12883a = pVar.f12935a;
        oVar.f12884b = str3;
        oVar.f12885c = i0.k(i0Var);
        oVar.f12892l = m0.p(pVar.f12945m);
        oVar.f12893m = m0.p(strE);
        oVar.f12890j = str2;
        oVar.f12891k = l0Var;
        oVar.f12889h = i12;
        oVar.i = i13;
        oVar.E = i10;
        oVar.f12887e = i;
        oVar.f = i11;
        oVar.f12886d = str;
        return new v1.p(oVar);
    }

    @Override // s2.c1
    public final boolean a() {
        return this.R.a();
    }

    @Override // n2.t
    public final void b() {
        for (r rVar : this.O) {
            w2.o oVar = rVar.E;
            j jVar = rVar.f8132y;
            ArrayList arrayList = rVar.I;
            if (!arrayList.isEmpty()) {
                k kVar = (k) ua.q.l(arrayList);
                int iB = jVar.b(kVar);
                int i = kVar.J;
                if (iB == 1) {
                    if (!kVar.h()) {
                        y1.d.g(i != -1);
                        n2.l lVarA = jVar.f8063g.a(jVar.f8062e[jVar.f8064h.a(kVar.f11851y)], false);
                        lVarA.getClass();
                        i0 i0Var = lVarA.f8701r;
                        int i10 = (int) (kVar.E - lVarA.f8694k);
                        kVar.f8081f0 = i10 < 0 ? 0L : ((n2.g) (i10 < i0Var.size() ? ((n2.i) i0Var.get(i10)).H : lVarA.f8702s).get(i)).f8681x;
                    }
                } else if (iB == 0) {
                    rVar.M.post(new androidx.fragment.app.d(27, rVar, kVar));
                } else if (iB == 2 && !rVar.o0 && oVar.d()) {
                    oVar.a();
                }
            }
        }
        this.L.f(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0056 A[SYNTHETIC] */
    @Override // n2.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.net.Uri r18, ag.o r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            m2.r[] r2 = r0.O
            int r3 = r2.length
            r6 = 0
            r7 = 1
        L9:
            if (r6 >= r3) goto L90
            r8 = r2[r6]
            m2.j r9 = r8.f8132y
            android.net.Uri[] r10 = r9.f8062e
            boolean r11 = y1.a0.l(r10, r1)
            if (r11 != 0) goto L1e
            r8 = r19
            r4 = 1
            r16 = 1
            goto L8b
        L1e:
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r20 != 0) goto L40
            f9.a0 r8 = r8.D
            v2.q r13 = r9.f8073r
            w2.h r13 = qb.t1.c(r13)
            r8.getClass()
            r8 = r19
            i4.e r13 = f9.a0.k(r13, r8)
            if (r13 == 0) goto L42
            int r14 = r13.f6206a
            r15 = 2
            if (r14 != r15) goto L42
            long r13 = r13.f6207b
            goto L43
        L40:
            r8 = r19
        L42:
            r13 = r11
        L43:
            r15 = 0
            r16 = 1
        L46:
            int r4 = r10.length
            r5 = -1
            if (r15 >= r4) goto L56
            r4 = r10[r15]
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L53
            goto L57
        L53:
            int r15 = r15 + 1
            goto L46
        L56:
            r15 = r5
        L57:
            if (r15 != r5) goto L5a
            goto L87
        L5a:
            v2.q r4 = r9.f8073r
            int r4 = r4.u(r15)
            if (r4 != r5) goto L63
            goto L87
        L63:
            r9.f8070o = r1
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 == 0) goto L8a
            v2.q r5 = r9.f8073r
            boolean r4 = r5.m(r4, r13)
            if (r4 == 0) goto L8a
            n2.c r4 = r9.f8063g
            java.util.HashMap r4 = r4.f8640y
            java.lang.Object r4 = r4.get(r1)
            n2.b r4 = (n2.b) r4
            if (r4 == 0) goto L84
            boolean r4 = n2.b.a(r4, r13)
            r4 = r4 ^ 1
            goto L85
        L84:
            r4 = 0
        L85:
            if (r4 == 0) goto L8a
        L87:
            r4 = r16
            goto L8b
        L8a:
            r4 = 0
        L8b:
            r7 = r7 & r4
            int r6 = r6 + 1
            goto L9
        L90:
            s2.z r1 = r0.L
            r1.f(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.l.c(android.net.Uri, ag.o, boolean):boolean");
    }

    @Override // s2.a0
    public final void d(s2.z zVar, long j4) {
        c cVar;
        boolean z10;
        List list;
        List list2;
        int i;
        HashSet hashSet;
        HashSet hashSet2;
        int i10;
        boolean z11;
        c cVar2;
        int i11;
        boolean z12;
        Uri[] uriArr;
        this.L = zVar;
        n2.c cVar3 = this.f8084w;
        cVar3.getClass();
        cVar3.f8641z.add(this);
        n2.o oVar = cVar3.E;
        oVar.getClass();
        List list3 = oVar.f;
        List list4 = oVar.f8717e;
        Map map = Collections.EMPTY_MAP;
        boolean zIsEmpty = list4.isEmpty();
        List list5 = oVar.f8718g;
        int i12 = 0;
        this.M = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c cVar4 = this.f8083v;
        boolean z13 = this.H;
        if (zIsEmpty) {
            cVar = cVar4;
            z10 = z13;
            list = list3;
            list2 = list5;
        } else {
            v1.p pVar = oVar.f8719h;
            int size = list4.size();
            int[] iArr = new int[size];
            int i13 = 0;
            int i14 = 0;
            while (true) {
                list2 = list5;
                if (i13 >= list4.size()) {
                    break;
                }
                v1.p pVar2 = ((n2.n) list4.get(i13)).f8711b;
                int i15 = pVar2.f12954v;
                String str = pVar2.f12943k;
                if (i15 > 0 || y1.a0.t(2, str) != null) {
                    iArr[i13] = 2;
                    i14++;
                } else if (y1.a0.t(1, str) != null) {
                    iArr[i13] = 1;
                    i12++;
                } else {
                    iArr[i13] = -1;
                }
                i13++;
                list5 = list2;
            }
            if (i14 > 0) {
                z12 = false;
                cVar2 = cVar4;
                i11 = i14;
                z11 = true;
            } else if (i12 < size) {
                z11 = false;
                cVar2 = cVar4;
                i11 = size - i12;
                z12 = true;
            } else {
                z11 = false;
                cVar2 = cVar4;
                i11 = size;
                z12 = false;
            }
            Uri[] uriArr2 = new Uri[i11];
            v1.p[] pVarArr = new v1.p[i11];
            int[] iArr2 = new int[i11];
            int i16 = 0;
            int i17 = 0;
            while (i16 < list4.size()) {
                if (z11) {
                    uriArr = uriArr2;
                    if (iArr[i16] == 2) {
                    }
                    i16++;
                    uriArr2 = uriArr;
                } else {
                    uriArr = uriArr2;
                }
                if (!z12 || iArr[i16] != 1) {
                    n2.n nVar = (n2.n) list4.get(i16);
                    uriArr[i17] = nVar.f8710a;
                    pVarArr[i17] = nVar.f8711b;
                    iArr2[i17] = i16;
                    i17++;
                }
                i16++;
                uriArr2 = uriArr;
            }
            Uri[] uriArr3 = uriArr2;
            String str2 = pVarArr[0].f12943k;
            int iS = y1.a0.s(2, str2);
            int iS2 = y1.a0.s(1, str2);
            boolean z14 = (iS2 == 1 || (iS2 == 0 && list3.isEmpty())) && iS <= 1 && iS2 + iS > 0;
            c cVar5 = cVar2;
            list = list3;
            z10 = z13;
            r rVarE = e("main", (z11 || iS2 <= 0) ? 0 : 1, uriArr3, pVarArr, oVar.f8719h, oVar.i, map, j4);
            arrayList.add(rVarE);
            arrayList2.add(iArr2);
            if (z10 && z14) {
                ArrayList arrayList3 = new ArrayList();
                if (iS > 0) {
                    v1.p[] pVarArr2 = new v1.p[i11];
                    int i18 = 0;
                    while (i18 < i11) {
                        v1.p pVar3 = pVarArr[i18];
                        String strT = y1.a0.t(2, pVar3.f12943k);
                        String strE = m0.e(strT);
                        v1.o oVar2 = new v1.o();
                        oVar2.f12883a = pVar3.f12935a;
                        oVar2.f12884b = pVar3.f12936b;
                        oVar2.f12885c = i0.k(pVar3.f12937c);
                        oVar2.f12892l = m0.p(pVar3.f12945m);
                        oVar2.f12893m = m0.p(strE);
                        oVar2.f12890j = strT;
                        oVar2.f12891k = pVar3.f12944l;
                        oVar2.f12889h = pVar3.f12941h;
                        oVar2.i = pVar3.i;
                        oVar2.f12900t = pVar3.f12953u;
                        oVar2.f12901u = pVar3.f12954v;
                        oVar2.f12904x = pVar3.f12957y;
                        oVar2.f12887e = pVar3.f12939e;
                        oVar2.f = pVar3.f;
                        pVarArr2[i18] = new v1.p(oVar2);
                        i18++;
                        pVarArr = pVarArr;
                    }
                    v1.p[] pVarArr3 = pVarArr;
                    arrayList3.add(new g1("main", pVarArr2));
                    if (iS2 > 0 && (pVar != null || list.isEmpty())) {
                        arrayList3.add(new g1("main:audio", f(pVarArr3[0], pVar, false)));
                    }
                    List list6 = oVar.i;
                    if (list6 != null) {
                        for (int i19 = 0; i19 < list6.size(); i19++) {
                            arrayList3.add(new g1(l0.e.g(i19, "main:cc:"), cVar5.b((v1.p) list6.get(i19))));
                        }
                    }
                    cVar = cVar5;
                } else {
                    cVar = cVar5;
                    v1.p[] pVarArr4 = new v1.p[i11];
                    for (int i20 = 0; i20 < i11; i20++) {
                        pVarArr4[i20] = f(pVarArr[i20], pVar, true);
                    }
                    arrayList3.add(new g1("main", pVarArr4));
                }
                v1.o oVar3 = new v1.o();
                oVar3.f12883a = "ID3";
                oVar3.f12893m = m0.p("application/id3");
                g1 g1Var = new g1("main:id3", new v1.p(oVar3));
                arrayList3.add(g1Var);
                rVarE.H((g1[]) arrayList3.toArray(new g1[0]), arrayList3.indexOf(g1Var));
            } else {
                cVar = cVar5;
            }
        }
        ArrayList arrayList4 = new ArrayList(list.size());
        ArrayList arrayList5 = new ArrayList(list.size());
        ArrayList arrayList6 = new ArrayList(list.size());
        HashSet hashSet3 = new HashSet();
        int i21 = 0;
        while (i21 < list.size()) {
            List list7 = list;
            String str3 = ((n2.m) list7.get(i21)).f8709c;
            if (hashSet3.add(str3)) {
                arrayList4.clear();
                arrayList5.clear();
                arrayList6.clear();
                boolean z15 = true;
                for (int i22 = 0; i22 < list7.size(); i22++) {
                    if (str3.equals(((n2.m) list7.get(i22)).f8709c)) {
                        n2.m mVar = (n2.m) list7.get(i22);
                        arrayList6.add(Integer.valueOf(i22));
                        Uri uri = mVar.f8707a;
                        v1.p pVar4 = mVar.f8708b;
                        arrayList4.add(uri);
                        arrayList5.add(pVar4);
                        z15 &= y1.a0.s(1, pVar4.f12943k) == 1;
                    }
                }
                String strConcat = "audio:".concat(str3);
                int i23 = y1.a0.f14551a;
                list = list7;
                hashSet2 = hashSet3;
                i10 = i21;
                r rVarE2 = e(strConcat, 1, (Uri[]) arrayList4.toArray(new Uri[0]), (v1.p[]) arrayList5.toArray(new v1.p[0]), null, Collections.EMPTY_LIST, map, j4);
                arrayList2.add(com.bumptech.glide.d.C(arrayList6));
                arrayList.add(rVarE2);
                if (z10 && z15) {
                    rVarE2.H(new g1[]{new g1(strConcat, (v1.p[]) arrayList5.toArray(new v1.p[0]))}, new int[0]);
                }
            } else {
                hashSet2 = hashSet3;
                i10 = i21;
                list = list7;
            }
            i21 = i10 + 1;
            hashSet3 = hashSet2;
        }
        this.Q = arrayList.size();
        ArrayList arrayList7 = new ArrayList(list2.size());
        ArrayList arrayList8 = new ArrayList(list2.size());
        ArrayList arrayList9 = new ArrayList(list2.size());
        HashSet hashSet4 = new HashSet();
        int i24 = 0;
        while (i24 < list2.size()) {
            List list8 = list2;
            String str4 = ((n2.m) list8.get(i24)).f8709c;
            if (hashSet4.add(str4)) {
                arrayList7.clear();
                arrayList8.clear();
                arrayList9.clear();
                for (int i25 = 0; i25 < list8.size(); i25++) {
                    if (str4.equals(((n2.m) list8.get(i25)).f8709c)) {
                        n2.m mVar2 = (n2.m) list8.get(i25);
                        arrayList9.add(Integer.valueOf(i25));
                        arrayList7.add(mVar2.f8707a);
                        arrayList8.add(mVar2.f8708b);
                    }
                }
                String strConcat2 = "subtitle:".concat(str4);
                v1.p[] pVarArr5 = (v1.p[]) arrayList8.toArray(new v1.p[0]);
                int i26 = y1.a0.f14551a;
                Uri[] uriArr4 = (Uri[]) arrayList7.toArray(new Uri[0]);
                g0 g0Var = i0.f12341w;
                list2 = list8;
                i = i24;
                hashSet = hashSet4;
                r rVarE3 = e(strConcat2, 3, uriArr4, pVarArr5, null, z0.f12413z, map, j4);
                arrayList2.add(com.bumptech.glide.d.C(arrayList9));
                arrayList.add(rVarE3);
                int length = pVarArr5.length;
                v1.p[] pVarArr6 = new v1.p[length];
                for (int i27 = 0; i27 < length; i27++) {
                    pVarArr6[i27] = cVar.b(pVarArr5[i27]);
                }
                rVarE3.H(new g1[]{new g1(strConcat2, pVarArr6)}, new int[0]);
            } else {
                hashSet = hashSet4;
                i = i24;
                list2 = list8;
            }
            i24 = i + 1;
            hashSet4 = hashSet;
        }
        this.O = (r[]) arrayList.toArray(new r[0]);
        this.M = this.O.length;
        for (int i28 = 0; i28 < this.Q; i28++) {
            this.O[i28].f8132y.f8067l = true;
        }
        for (r rVar : this.O) {
            if (!rVar.Y) {
                r0 r0Var = new r0();
                r0Var.f4888a = rVar.f8121k0;
                rVar.i(new s0(r0Var));
            }
        }
        this.P = this.O;
    }

    public final r e(String str, int i, Uri[] uriArr, v1.p[] pVarArr, v1.p pVar, List list, Map map, long j4) {
        return new r(str, i, this.K, new j(this.f8083v, this.f8084w, uriArr, pVarArr, this.f8085x, this.f8086y, this.F, list, this.J), map, this.D, j4, pVar, this.f8087z, this.A, this.B, this.C, this.I);
    }

    @Override // s2.a0
    public final long h(long j4, r1 r1Var) {
        r[] rVarArr = this.P;
        int length = rVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            r rVar = rVarArr[i];
            if (rVar.V == 2) {
                j jVar = rVar.f8132y;
                n2.c cVar = jVar.f8063g;
                int iL = jVar.f8073r.l();
                Uri[] uriArr = jVar.f8062e;
                n2.l lVarA = (iL >= uriArr.length || iL == -1) ? null : cVar.a(uriArr[jVar.f8073r.h()], true);
                if (lVarA != null) {
                    i0 i0Var = lVarA.f8701r;
                    if (!i0Var.isEmpty()) {
                        long j7 = lVarA.f8692h - cVar.I;
                        long j10 = j4 - j7;
                        int iC = y1.a0.c(i0Var, Long.valueOf(j10), true);
                        long j11 = ((n2.i) i0Var.get(iC)).f8683z;
                        return r1Var.a(j10, j11, (!lVarA.f8724c || iC == i0Var.size() - 1) ? j11 : ((n2.i) i0Var.get(iC + 1)).f8683z) + j7;
                    }
                }
            } else {
                i++;
            }
        }
        return j4;
    }

    @Override // s2.c1
    public final boolean i(s0 s0Var) {
        if (this.N != null) {
            return this.R.i(s0Var);
        }
        for (r rVar : this.O) {
            if (!rVar.Y) {
                r0 r0Var = new r0();
                r0Var.f4888a = rVar.f8121k0;
                rVar.i(new s0(r0Var));
            }
        }
        return false;
    }

    @Override // s2.c1
    public final long j() {
        return this.R.j();
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) throws Throwable {
        for (r rVar : this.P) {
            if (rVar.X && !rVar.E()) {
                int length = rVar.Q.length;
                for (int i = 0; i < length; i++) {
                    rVar.Q[i].j(j4, z10, rVar.f8119i0[i]);
                }
            }
        }
    }

    @Override // s2.a0
    public final long m() {
        return -9223372036854775807L;
    }

    @Override // s2.a0
    public final l1 o() {
        l1 l1Var = this.N;
        l1Var.getClass();
        return l1Var;
    }

    @Override // s2.c1
    public final long q() {
        return this.R.q();
    }

    @Override // s2.a0
    public final void r() throws IOException {
        for (r rVar : this.O) {
            rVar.G();
            if (rVar.o0 && !rVar.Y) {
                throw n0.a(null, "Loading finished before preparation is complete.");
            }
        }
    }

    @Override // s2.a0
    public final long t(long j4) {
        r[] rVarArr = this.P;
        if (rVarArr.length > 0) {
            boolean zJ = rVarArr[0].J(false, j4);
            int i = 1;
            while (true) {
                r[] rVarArr2 = this.P;
                if (i >= rVarArr2.length) {
                    break;
                }
                rVarArr2[i].J(zJ, j4);
                i++;
            }
            if (zJ) {
                ((SparseArray) this.F.f7697v).clear();
            }
        }
        return j4;
    }

    @Override // s2.c1
    public final void u(long j4) {
        this.R.u(j4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0199  */
    /* JADX WARN: Type inference failed for: r30v0 */
    /* JADX WARN: Type inference failed for: r30v2 */
    /* JADX WARN: Type inference failed for: r30v3, types: [int] */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v40 */
    /* JADX WARN: Type inference failed for: r9v5 */
    @Override // s2.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long v(v2.q[] r40, boolean[] r41, s2.a1[] r42, boolean[] r43, long r44) {
        /*
            Method dump skipped, instruction units count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.l.v(v2.q[], boolean[], s2.a1[], boolean[], long):long");
    }
}
