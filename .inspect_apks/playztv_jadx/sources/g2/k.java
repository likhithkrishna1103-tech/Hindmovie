package g2;

import a2.b1;
import a2.d2;
import a2.g0;
import aa.c1;
import aa.h0;
import aa.j0;
import aa.l0;
import android.net.Uri;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import k8.a0;
import k8.c0;
import o2.b0;
import o2.n1;
import p1.g1;
import p1.m0;
import p1.n0;
import v1.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements b0, h2.t {
    public final a0 A;
    public final l0 B;
    public final s2.e C;
    public final IdentityHashMap D;
    public final u5.d E;
    public final c0 F;
    public final boolean G;
    public final int H;
    public final b2.o I;
    public final u5.c J = new u5.c(14, this);
    public o2.a0 K;
    public int L;
    public n1 M;
    public q[] N;
    public q[] O;
    public int P;
    public o2.n Q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f4888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h2.c f4889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final wb.c f4890w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e0 f4891x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f2.n f4892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f2.k f4893z;

    public k(c cVar, h2.c cVar2, wb.c cVar3, e0 e0Var, f2.n nVar, f2.k kVar, a0 a0Var, l0 l0Var, s2.e eVar, c0 c0Var, boolean z2, int i, b2.o oVar) {
        this.f4888u = cVar;
        this.f4889v = cVar2;
        this.f4890w = cVar3;
        this.f4891x = e0Var;
        this.f4892y = nVar;
        this.f4893z = kVar;
        this.A = a0Var;
        this.B = l0Var;
        this.C = eVar;
        this.F = c0Var;
        this.G = z2;
        this.H = i;
        this.I = oVar;
        c0Var.getClass();
        h0 h0Var = j0.f690v;
        c1 c1Var = c1.f650y;
        this.Q = new o2.n(c1Var, c1Var);
        this.D = new IdentityHashMap();
        this.E = new u5.d(11);
        this.N = new q[0];
        this.O = new q[0];
    }

    public static p1.q f(p1.q qVar, p1.q qVar2, boolean z2) {
        p1.l0 l0Var;
        int i;
        String str;
        String str2;
        j0 j0Var;
        int i10;
        int i11;
        String str3;
        h0 h0Var = j0.f690v;
        c1 c1Var = c1.f650y;
        if (qVar2 != null) {
            str2 = qVar2.f10020k;
            l0Var = qVar2.f10021l;
            i10 = qVar2.F;
            i = qVar2.f10016e;
            i11 = qVar2.f;
            str = qVar2.f10015d;
            str3 = qVar2.f10013b;
            j0Var = qVar2.f10014c;
        } else {
            String strT = s1.b0.t(qVar.f10020k, 1);
            l0Var = qVar.f10021l;
            if (z2) {
                i10 = qVar.F;
                i = qVar.f10016e;
                i11 = qVar.f;
                str = qVar.f10015d;
                str3 = qVar.f10013b;
                str2 = strT;
                j0Var = qVar.f10014c;
            } else {
                i = 0;
                str = null;
                str2 = strT;
                j0Var = c1Var;
                i10 = -1;
                i11 = 0;
                str3 = null;
            }
        }
        String strE = m0.e(str2);
        int i12 = z2 ? qVar.f10018h : -1;
        int i13 = z2 ? qVar.i : -1;
        p1.p pVar = new p1.p();
        pVar.f9957a = qVar.f10012a;
        pVar.f9958b = str3;
        pVar.f9959c = j0.r(j0Var);
        pVar.f9966l = m0.p(qVar.f10022m);
        pVar.f9967m = m0.p(strE);
        pVar.f9964j = str2;
        pVar.f9965k = l0Var;
        pVar.f9963h = i12;
        pVar.i = i13;
        pVar.E = i10;
        pVar.f9961e = i;
        pVar.f = i11;
        pVar.f9960d = str;
        return new p1.q(pVar);
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        q[] qVarArr = this.O;
        int length = qVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            q qVar = qVarArr[i];
            if (qVar.U == 2) {
                i iVar = qVar.f4926x;
                h2.c cVar = iVar.f4869g;
                int iN = iVar.f4879r.n();
                Uri[] uriArr = iVar.f4868e;
                h2.l lVarA = (iN >= uriArr.length || iN == -1) ? null : cVar.a(uriArr[iVar.f4879r.j()], true);
                if (lVarA != null) {
                    j0 j0Var = lVarA.f5726r;
                    if (!j0Var.isEmpty()) {
                        long j8 = lVarA.f5717h - cVar.H;
                        long j10 = j5 - j8;
                        int iC = s1.b0.c(j0Var, Long.valueOf(j10), true);
                        long j11 = ((h2.i) j0Var.get(iC)).f5707y;
                        return d2Var.a(j10, j11, (!lVarA.f5749c || iC == j0Var.size() - 1) ? j11 : ((h2.i) j0Var.get(iC + 1)).f5707y) + j8;
                    }
                }
            } else {
                i++;
            }
        }
        return j5;
    }

    @Override // h2.t
    public final void b() {
        for (q qVar : this.N) {
            s2.m mVar = qVar.D;
            i iVar = qVar.f4926x;
            ArrayList arrayList = qVar.H;
            if (!arrayList.isEmpty()) {
                j jVar = (j) aa.q.k(arrayList);
                int iB = iVar.b(jVar);
                int i = jVar.I;
                if (iB == 1) {
                    if (!jVar.h()) {
                        s1.d.g(i != -1);
                        h2.l lVarA = iVar.f4869g.a(iVar.f4868e[iVar.f4870h.a(jVar.f10146x)], false);
                        lVarA.getClass();
                        j0 j0Var = lVarA.f5726r;
                        int i10 = (int) (jVar.D - lVarA.f5719k);
                        jVar.f4886e0 = i10 < 0 ? 0L : ((h2.g) (i10 < j0Var.size() ? ((h2.i) j0Var.get(i10)).G : lVarA.f5727s).get(i)).f5705w;
                    }
                } else if (iB == 0) {
                    qVar.L.post(new g0(qVar, 14, jVar));
                } else if (iB == 2 && !qVar.f4918n0 && mVar.d()) {
                    mVar.a();
                }
            }
        }
        this.K.d(this);
    }

    @Override // o2.e1
    public final boolean c() {
        return this.Q.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0056 A[SYNTHETIC] */
    @Override // h2.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.net.Uri r18, e6.i r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            g2.q[] r2 = r0.N
            int r3 = r2.length
            r6 = 0
            r7 = 1
        L9:
            if (r6 >= r3) goto L90
            r8 = r2[r6]
            g2.i r9 = r8.f4926x
            android.net.Uri[] r10 = r9.f4868e
            boolean r11 = s1.b0.l(r10, r1)
            if (r11 != 0) goto L1e
            r8 = r19
            r4 = 1
            r16 = 1
            goto L8b
        L1e:
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r20 != 0) goto L40
            k8.a0 r8 = r8.C
            r2.r r13 = r9.f4879r
            j9.j0 r13 = b8.h.f(r13)
            r8.getClass()
            r8 = r19
            e4.f r13 = k8.a0.j(r13, r8)
            if (r13 == 0) goto L42
            int r14 = r13.f4419a
            r15 = 2
            if (r14 != r15) goto L42
            long r13 = r13.f4420b
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
            r2.r r4 = r9.f4879r
            int r4 = r4.u(r15)
            if (r4 != r5) goto L63
            goto L87
        L63:
            r9.f4876o = r1
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 == 0) goto L8a
            r2.r r5 = r9.f4879r
            boolean r4 = r5.o(r4, r13)
            if (r4 == 0) goto L8a
            h2.c r4 = r9.f4869g
            java.util.HashMap r4 = r4.f5663x
            java.lang.Object r4 = r4.get(r1)
            h2.b r4 = (h2.b) r4
            if (r4 == 0) goto L84
            boolean r4 = h2.b.a(r4, r13)
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
            o2.a0 r1 = r0.K
            r1.d(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.k.d(android.net.Uri, e6.i, boolean):boolean");
    }

    public final q e(String str, int i, Uri[] uriArr, p1.q[] qVarArr, p1.q qVar, List list, Map map, long j5) {
        return new q(str, i, this.J, new i(this.f4888u, this.f4889v, uriArr, qVarArr, this.f4890w, this.f4891x, this.E, list, this.I), map, this.C, j5, qVar, this.f4892y, this.f4893z, this.A, this.B, this.H);
    }

    @Override // o2.e1
    public final long g() {
        return this.Q.g();
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        for (q qVar : this.O) {
            if (qVar.W && !qVar.E()) {
                int length = qVar.P.length;
                for (int i = 0; i < length; i++) {
                    qVar.P[i].j(j5, z2, qVar.f4913h0[i]);
                }
            }
        }
    }

    @Override // o2.b0
    public final long i() {
        return -9223372036854775807L;
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        if (this.M != null) {
            return this.Q.l(c1Var);
        }
        for (q qVar : this.N) {
            if (!qVar.X) {
                b1 b1Var = new b1();
                b1Var.f164a = qVar.f4915j0;
                qVar.l(new a2.c1(b1Var));
            }
        }
        return false;
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
    @Override // o2.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long n(r2.r[] r40, boolean[] r41, o2.c1[] r42, boolean[] r43, long r44) {
        /*
            Method dump skipped, instruction units count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.k.n(r2.r[], boolean[], o2.c1[], boolean[], long):long");
    }

    @Override // o2.b0
    public final void o(o2.a0 a0Var, long j5) {
        c cVar;
        boolean z2;
        List list;
        List list2;
        int i;
        HashSet hashSet;
        HashSet hashSet2;
        int i10;
        boolean z10;
        c cVar2;
        int i11;
        boolean z11;
        Uri[] uriArr;
        this.K = a0Var;
        h2.c cVar3 = this.f4889v;
        cVar3.getClass();
        cVar3.f5664y.add(this);
        h2.o oVar = cVar3.D;
        oVar.getClass();
        List list3 = oVar.f;
        List list4 = oVar.f5742e;
        Map map = Collections.EMPTY_MAP;
        boolean zIsEmpty = list4.isEmpty();
        List list5 = oVar.f5743g;
        int i12 = 0;
        this.L = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c cVar4 = this.f4888u;
        boolean z12 = this.G;
        if (zIsEmpty) {
            cVar = cVar4;
            z2 = z12;
            list = list3;
            list2 = list5;
        } else {
            p1.q qVar = oVar.f5744h;
            int size = list4.size();
            int[] iArr = new int[size];
            int i13 = 0;
            int i14 = 0;
            while (true) {
                list2 = list5;
                if (i13 >= list4.size()) {
                    break;
                }
                p1.q qVar2 = ((h2.n) list4.get(i13)).f5736b;
                int i15 = qVar2.f10031v;
                String str = qVar2.f10020k;
                if (i15 > 0 || s1.b0.t(str, 2) != null) {
                    iArr[i13] = 2;
                    i14++;
                } else if (s1.b0.t(str, 1) != null) {
                    iArr[i13] = 1;
                    i12++;
                } else {
                    iArr[i13] = -1;
                }
                i13++;
                list5 = list2;
            }
            if (i14 > 0) {
                z11 = false;
                cVar2 = cVar4;
                i11 = i14;
                z10 = true;
            } else if (i12 < size) {
                z10 = false;
                cVar2 = cVar4;
                i11 = size - i12;
                z11 = true;
            } else {
                z10 = false;
                cVar2 = cVar4;
                i11 = size;
                z11 = false;
            }
            Uri[] uriArr2 = new Uri[i11];
            p1.q[] qVarArr = new p1.q[i11];
            int[] iArr2 = new int[i11];
            int i16 = 0;
            int i17 = 0;
            while (i16 < list4.size()) {
                if (z10) {
                    uriArr = uriArr2;
                    if (iArr[i16] == 2) {
                    }
                    i16++;
                    uriArr2 = uriArr;
                } else {
                    uriArr = uriArr2;
                }
                if (!z11 || iArr[i16] != 1) {
                    h2.n nVar = (h2.n) list4.get(i16);
                    uriArr[i17] = nVar.f5735a;
                    qVarArr[i17] = nVar.f5736b;
                    iArr2[i17] = i16;
                    i17++;
                }
                i16++;
                uriArr2 = uriArr;
            }
            Uri[] uriArr3 = uriArr2;
            String str2 = qVarArr[0].f10020k;
            int iS = s1.b0.s(str2, 2);
            int iS2 = s1.b0.s(str2, 1);
            boolean z13 = (iS2 == 1 || (iS2 == 0 && list3.isEmpty())) && iS <= 1 && iS2 + iS > 0;
            c cVar5 = cVar2;
            list = list3;
            z2 = z12;
            q qVarE = e("main", (z10 || iS2 <= 0) ? 0 : 1, uriArr3, qVarArr, oVar.f5744h, oVar.i, map, j5);
            arrayList.add(qVarE);
            arrayList2.add(iArr2);
            if (z2 && z13) {
                ArrayList arrayList3 = new ArrayList();
                if (iS > 0) {
                    p1.q[] qVarArr2 = new p1.q[i11];
                    int i18 = 0;
                    while (i18 < i11) {
                        p1.q qVar3 = qVarArr[i18];
                        String strT = s1.b0.t(qVar3.f10020k, 2);
                        String strE = m0.e(strT);
                        p1.p pVar = new p1.p();
                        pVar.f9957a = qVar3.f10012a;
                        pVar.f9958b = qVar3.f10013b;
                        pVar.f9959c = j0.r(qVar3.f10014c);
                        pVar.f9966l = m0.p(qVar3.f10022m);
                        pVar.f9967m = m0.p(strE);
                        pVar.f9964j = strT;
                        pVar.f9965k = qVar3.f10021l;
                        pVar.f9963h = qVar3.f10018h;
                        pVar.i = qVar3.i;
                        pVar.f9974t = qVar3.f10030u;
                        pVar.f9975u = qVar3.f10031v;
                        pVar.f9978x = qVar3.f10034y;
                        pVar.f9961e = qVar3.f10016e;
                        pVar.f = qVar3.f;
                        qVarArr2[i18] = new p1.q(pVar);
                        i18++;
                        qVarArr = qVarArr;
                    }
                    p1.q[] qVarArr3 = qVarArr;
                    arrayList3.add(new g1("main", qVarArr2));
                    if (iS2 > 0 && (qVar != null || list.isEmpty())) {
                        arrayList3.add(new g1("main:audio", f(qVarArr3[0], qVar, false)));
                    }
                    List list6 = oVar.i;
                    if (list6 != null) {
                        for (int i19 = 0; i19 < list6.size(); i19++) {
                            arrayList3.add(new g1(e6.j.l("main:cc:", i19), cVar5.b((p1.q) list6.get(i19))));
                        }
                    }
                    cVar = cVar5;
                } else {
                    cVar = cVar5;
                    p1.q[] qVarArr4 = new p1.q[i11];
                    for (int i20 = 0; i20 < i11; i20++) {
                        qVarArr4[i20] = f(qVarArr[i20], qVar, true);
                    }
                    arrayList3.add(new g1("main", qVarArr4));
                }
                p1.p pVar2 = new p1.p();
                pVar2.f9957a = "ID3";
                pVar2.f9967m = m0.p("application/id3");
                g1 g1Var = new g1("main:id3", new p1.q(pVar2));
                arrayList3.add(g1Var);
                qVarE.H((g1[]) arrayList3.toArray(new g1[0]), arrayList3.indexOf(g1Var));
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
            String str3 = ((h2.m) list7.get(i21)).f5734c;
            if (hashSet3.add(str3)) {
                arrayList4.clear();
                arrayList5.clear();
                arrayList6.clear();
                boolean z14 = true;
                for (int i22 = 0; i22 < list7.size(); i22++) {
                    if (str3.equals(((h2.m) list7.get(i22)).f5734c)) {
                        h2.m mVar = (h2.m) list7.get(i22);
                        arrayList6.add(Integer.valueOf(i22));
                        Uri uri = mVar.f5732a;
                        p1.q qVar4 = mVar.f5733b;
                        arrayList4.add(uri);
                        arrayList5.add(qVar4);
                        z14 &= s1.b0.s(qVar4.f10020k, 1) == 1;
                    }
                }
                String strConcat = "audio:".concat(str3);
                int i23 = s1.b0.f11647a;
                list = list7;
                hashSet2 = hashSet3;
                i10 = i21;
                q qVarE2 = e(strConcat, 1, (Uri[]) arrayList4.toArray(new Uri[0]), (p1.q[]) arrayList5.toArray(new p1.q[0]), null, Collections.EMPTY_LIST, map, j5);
                arrayList2.add(q1.c.S(arrayList6));
                arrayList.add(qVarE2);
                if (z2 && z14) {
                    qVarE2.H(new g1[]{new g1(strConcat, (p1.q[]) arrayList5.toArray(new p1.q[0]))}, new int[0]);
                }
            } else {
                hashSet2 = hashSet3;
                i10 = i21;
                list = list7;
            }
            i21 = i10 + 1;
            hashSet3 = hashSet2;
        }
        this.P = arrayList.size();
        ArrayList arrayList7 = new ArrayList(list2.size());
        ArrayList arrayList8 = new ArrayList(list2.size());
        ArrayList arrayList9 = new ArrayList(list2.size());
        HashSet hashSet4 = new HashSet();
        int i24 = 0;
        while (i24 < list2.size()) {
            List list8 = list2;
            String str4 = ((h2.m) list8.get(i24)).f5734c;
            if (hashSet4.add(str4)) {
                arrayList7.clear();
                arrayList8.clear();
                arrayList9.clear();
                for (int i25 = 0; i25 < list8.size(); i25++) {
                    if (str4.equals(((h2.m) list8.get(i25)).f5734c)) {
                        h2.m mVar2 = (h2.m) list8.get(i25);
                        arrayList9.add(Integer.valueOf(i25));
                        arrayList7.add(mVar2.f5732a);
                        arrayList8.add(mVar2.f5733b);
                    }
                }
                String strConcat2 = "subtitle:".concat(str4);
                p1.q[] qVarArr5 = (p1.q[]) arrayList8.toArray(new p1.q[0]);
                int i26 = s1.b0.f11647a;
                Uri[] uriArr4 = (Uri[]) arrayList7.toArray(new Uri[0]);
                h0 h0Var = j0.f690v;
                list2 = list8;
                i = i24;
                hashSet = hashSet4;
                q qVarE3 = e(strConcat2, 3, uriArr4, qVarArr5, null, c1.f650y, map, j5);
                arrayList2.add(q1.c.S(arrayList9));
                arrayList.add(qVarE3);
                int length = qVarArr5.length;
                p1.q[] qVarArr6 = new p1.q[length];
                for (int i27 = 0; i27 < length; i27++) {
                    qVarArr6[i27] = cVar.b(qVarArr5[i27]);
                }
                qVarE3.H(new g1[]{new g1(strConcat2, qVarArr6)}, new int[0]);
            } else {
                hashSet = hashSet4;
                i = i24;
                list2 = list8;
            }
            i24 = i + 1;
            hashSet4 = hashSet;
        }
        this.N = (q[]) arrayList.toArray(new q[0]);
        this.L = this.N.length;
        for (int i28 = 0; i28 < this.P; i28++) {
            this.N[i28].f4926x.f4873l = true;
        }
        for (q qVar5 : this.N) {
            if (!qVar5.X) {
                b1 b1Var = new b1();
                b1Var.f164a = qVar5.f4915j0;
                qVar5.l(new a2.c1(b1Var));
            }
        }
        this.O = this.N;
    }

    @Override // o2.b0
    public final n1 p() {
        n1 n1Var = this.M;
        n1Var.getClass();
        return n1Var;
    }

    @Override // o2.e1
    public final long r() {
        return this.Q.r();
    }

    @Override // o2.b0
    public final void s() throws IOException {
        for (q qVar : this.N) {
            qVar.G();
            if (qVar.f4918n0 && !qVar.X) {
                throw n0.a(null, "Loading finished before preparation is complete.");
            }
        }
    }

    @Override // o2.b0
    public final long t(long j5) {
        q[] qVarArr = this.O;
        if (qVarArr.length > 0) {
            boolean zJ = qVarArr[0].J(false, j5);
            int i = 1;
            while (true) {
                q[] qVarArr2 = this.O;
                if (i >= qVarArr2.length) {
                    break;
                }
                qVarArr2[i].J(zJ, j5);
                i++;
            }
            if (zJ) {
                ((SparseArray) this.E.f12784v).clear();
            }
        }
        return j5;
    }

    @Override // o2.e1
    public final void v(long j5) {
        this.Q.v(j5);
    }
}
