package d2;

import a2.d2;
import aa.c1;
import aa.h0;
import aa.j0;
import aa.l0;
import android.util.Pair;
import android.util.SparseArray;
import e6.f0;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k8.c0;
import o2.a0;
import o2.b0;
import o2.b1;
import o2.d1;
import o2.e1;
import o2.n1;
import p1.g1;
import p1.m0;
import p1.p;
import p1.q;
import r2.r;
import v1.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements b0, d1, p2.h {
    public static final Pattern T = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern U = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    public final long A;
    public final s2.n B;
    public final s2.e C;
    public final n1 D;
    public final a[] E;
    public final c0 F;
    public final o G;
    public final l0 I;
    public final f2.k J;
    public a0 K;
    public o2.n N;
    public e2.c O;
    public int P;
    public List Q;
    public long S;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f3700u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l0 f3701v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e0 f3702w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f2.n f3703x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final k8.a0 f3704y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ub.o f3705z;
    public boolean R = true;
    public p2.i[] L = new p2.i[0];
    public l[] M = new l[0];
    public final IdentityHashMap H = new IdentityHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i, e2.c cVar, ub.o oVar, int i10, l0 l0Var, e0 e0Var, f2.n nVar, f2.k kVar, k8.a0 a0Var, l0 l0Var2, long j5, s2.n nVar2, s2.e eVar, c0 c0Var, wb.c cVar2, b2.o oVar2) {
        int i11;
        int i12;
        int[][] iArr;
        boolean[] zArr;
        q[][] qVarArr;
        q[] qVarArrK;
        e2.f fVarE;
        Integer num;
        f2.n nVar3 = nVar;
        this.f3700u = i;
        this.O = cVar;
        this.f3705z = oVar;
        this.P = i10;
        this.f3701v = l0Var;
        this.f3702w = e0Var;
        this.f3703x = nVar3;
        this.J = kVar;
        this.f3704y = a0Var;
        this.I = l0Var2;
        this.A = j5;
        this.B = nVar2;
        this.C = eVar;
        this.F = c0Var;
        boolean z2 = true;
        this.G = new o(cVar, cVar2, eVar);
        int i13 = 0;
        c0Var.getClass();
        h0 h0Var = j0.f690v;
        c1 c1Var = c1.f650y;
        this.N = new o2.n(c1Var, c1Var);
        e2.h hVarB = cVar.b(i10);
        List list = hVarB.f4331d;
        this.Q = list;
        List list2 = hVarB.f4330c;
        int size = list2.size();
        HashMap map = new HashMap(aa.q.a(size));
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i14 = 0; i14 < size; i14++) {
            map.put(Long.valueOf(((e2.a) list2.get(i14)).f4290a), Integer.valueOf(i14));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i14));
            arrayList.add(arrayList2);
            sparseArray.put(i14, arrayList2);
        }
        int i15 = 0;
        while (i15 < size) {
            e2.a aVar = (e2.a) list2.get(i15);
            List list3 = aVar.f4294e;
            List list4 = aVar.f;
            boolean z10 = z2;
            e2.f fVarE2 = e("http://dashif.org/guidelines/trickmode", list3);
            fVarE2 = fVarE2 == null ? e("http://dashif.org/guidelines/trickmode", list4) : fVarE2;
            int iIntValue = (fVarE2 == null || (num = (Integer) map.get(Long.valueOf(Long.parseLong(fVarE2.f4322b)))) == null || !b(aVar, (e2.a) list2.get(num.intValue()))) ? i15 : num.intValue();
            if (iIntValue == i15 && (fVarE = e("urn:mpeg:dash:adaptation-set-switching:2016", list4)) != null) {
                String str = fVarE.f4322b;
                int i16 = s1.b0.f11647a;
                String[] strArrSplit = str.split(",", -1);
                int length = strArrSplit.length;
                for (int i17 = i13; i17 < length; i17++) {
                    Integer num2 = (Integer) map.get(Long.valueOf(Long.parseLong(strArrSplit[i17])));
                    if (num2 != null && b(aVar, (e2.a) list2.get(num2.intValue()))) {
                        iIntValue = Math.min(iIntValue, num2.intValue());
                    }
                }
            }
            if (iIntValue != i15) {
                List list5 = (List) sparseArray.get(i15);
                List list6 = (List) sparseArray.get(iIntValue);
                list6.addAll(list5);
                sparseArray.put(i15, list6);
                arrayList.remove(list5);
            }
            i15++;
            z2 = z10;
            i13 = 0;
        }
        boolean z11 = z2;
        int size2 = arrayList.size();
        int[][] iArr2 = new int[size2][];
        for (int i18 = 0; i18 < size2; i18++) {
            int[] iArrS = q1.c.S((Collection) arrayList.get(i18));
            iArr2[i18] = iArrS;
            Arrays.sort(iArrS);
        }
        boolean[] zArr2 = new boolean[size2];
        q[][] qVarArr2 = new q[size2][];
        int i19 = 0;
        int i20 = 0;
        while (i19 < size2) {
            int[] iArr3 = iArr2[i19];
            int length2 = iArr3.length;
            int i21 = 0;
            while (true) {
                if (i21 >= length2) {
                    iArr = iArr2;
                    break;
                }
                List list7 = ((e2.a) list2.get(iArr3[i21])).f4292c;
                iArr = iArr2;
                for (int i22 = 0; i22 < list7.size(); i22++) {
                    if (!((e2.m) list7.get(i22)).f4346x.isEmpty()) {
                        zArr2[i19] = z11;
                        i20++;
                        break;
                    }
                }
                i21++;
                iArr2 = iArr;
            }
            int[] iArr4 = iArr[i19];
            int length3 = iArr4.length;
            int i23 = 0;
            while (true) {
                if (i23 >= length3) {
                    zArr = zArr2;
                    qVarArr = qVarArr2;
                    qVarArrK = new q[0];
                    break;
                }
                int i24 = iArr4[i23];
                e2.a aVar2 = (e2.a) list2.get(i24);
                List list8 = ((e2.a) list2.get(i24)).f4293d;
                int[] iArr5 = iArr4;
                int i25 = 0;
                while (i25 < list8.size()) {
                    e2.f fVar = (e2.f) list8.get(i25);
                    zArr = zArr2;
                    qVarArr = qVarArr2;
                    if ("urn:scte:dash:cc:cea-608:2015".equals(fVar.f4321a)) {
                        p pVar = new p();
                        pVar.f9967m = m0.p("application/cea-608");
                        pVar.f9957a = l4.a.n(new StringBuilder(), aVar2.f4290a, ":cea608");
                        qVarArrK = k(fVar, T, new q(pVar));
                        break;
                    }
                    if ("urn:scte:dash:cc:cea-708:2015".equals(fVar.f4321a)) {
                        p pVar2 = new p();
                        pVar2.f9967m = m0.p("application/cea-708");
                        pVar2.f9957a = l4.a.n(new StringBuilder(), aVar2.f4290a, ":cea708");
                        qVarArrK = k(fVar, U, new q(pVar2));
                        break;
                    }
                    i25++;
                    qVarArr2 = qVarArr;
                    zArr2 = zArr;
                }
                i23++;
                iArr4 = iArr5;
            }
            qVarArr[i19] = qVarArrK;
            if (qVarArrK.length != 0) {
                i20++;
            }
            i19++;
            qVarArr2 = qVarArr;
            iArr2 = iArr;
            zArr2 = zArr;
        }
        int[][] iArr6 = iArr2;
        boolean[] zArr3 = zArr2;
        q[][] qVarArr3 = qVarArr2;
        int size3 = list.size() + i20 + size2;
        g1[] g1VarArr = new g1[size3];
        a[] aVarArr = new a[size3];
        int i26 = 0;
        int i27 = 0;
        while (i27 < size2) {
            int[] iArr7 = iArr6[i27];
            ArrayList arrayList3 = new ArrayList();
            for (int i28 : iArr7) {
                arrayList3.addAll(((e2.a) list2.get(i28)).f4292c);
            }
            int size4 = arrayList3.size();
            q[] qVarArr4 = new q[size4];
            int i29 = 0;
            while (i29 < size4) {
                int i30 = size2;
                q qVar = ((e2.m) arrayList3.get(i29)).f4343u;
                int i31 = i26;
                p pVarA = qVar.a();
                pVarA.N = nVar3.f(qVar);
                qVarArr4[i29] = new q(pVarA);
                i29++;
                size2 = i30;
                i26 = i31;
            }
            int i32 = size2;
            int i33 = i26;
            e2.a aVar3 = (e2.a) list2.get(iArr7[0]);
            long j8 = aVar3.f4290a;
            String string = j8 != -1 ? Long.toString(j8) : e6.j.l("unset:", i27);
            int i34 = i33 + 1;
            if (zArr3[i27]) {
                i11 = i33 + 2;
            } else {
                i11 = i34;
                i34 = -1;
            }
            if (qVarArr3[i27].length != 0) {
                i12 = i11 + 1;
            } else {
                i12 = i11;
                i11 = -1;
            }
            j(l0Var, qVarArr4);
            List list9 = list2;
            g1VarArr[i33] = new g1(string, qVarArr4);
            int i35 = aVar3.f4291b;
            h0 h0Var2 = j0.f690v;
            c1 c1Var2 = c1.f650y;
            a aVar4 = new a(i35, 0, iArr7, i33, i34, i11, -1, c1Var2);
            int[] iArr8 = iArr7;
            int i36 = i33;
            aVarArr[i36] = aVar4;
            int i37 = -1;
            if (i34 != -1) {
                String strM = e6.j.m(string, ":emsg");
                p pVar3 = new p();
                pVar3.f9957a = strM;
                pVar3.f9967m = m0.p("application/x-emsg");
                q[] qVarArr5 = new q[z11];
                qVarArr5[0] = new q(pVar3);
                g1VarArr[i34] = new g1(strM, qVarArr5);
                a aVar5 = new a(5, 1, iArr8, i36, -1, -1, -1, c1Var2);
                iArr8 = iArr8;
                i36 = i36;
                aVarArr[i34] = aVar5;
                i37 = -1;
            }
            if (i11 != i37) {
                String strM2 = e6.j.m(string, ":cc");
                aVarArr[i11] = new a(3, 1, iArr8, i36, -1, -1, -1, j0.s(qVarArr3[i27]));
                j(l0Var, qVarArr3[i27]);
                g1VarArr[i11] = new g1(strM2, qVarArr3[i27]);
            }
            i27++;
            size2 = i32;
            nVar3 = nVar;
            i26 = i12;
            list2 = list9;
            z11 = true;
        }
        int i38 = 0;
        while (i38 < list.size()) {
            e2.g gVar = (e2.g) list.get(i38);
            p pVar4 = new p();
            pVar4.f9957a = gVar.a();
            pVar4.f9967m = m0.p("application/x-emsg");
            g1VarArr[i26] = new g1(gVar.a() + ":" + i38, new q(pVar4));
            h0 h0Var3 = j0.f690v;
            aVarArr[i26] = new a(5, 2, new int[0], -1, -1, -1, i38, c1.f650y);
            i38++;
            i26++;
        }
        Pair pairCreate = Pair.create(new n1(g1VarArr), aVarArr);
        this.D = (n1) pairCreate.first;
        this.E = (a[]) pairCreate.second;
    }

    public static boolean b(e2.a aVar, e2.a aVar2) {
        int i = aVar.f4291b;
        List list = aVar.f4292c;
        int i10 = aVar2.f4291b;
        List list2 = aVar2.f4292c;
        if (i == i10) {
            if (list.isEmpty() || list2.isEmpty()) {
                return true;
            }
            q qVar = ((e2.m) list.get(0)).f4343u;
            q qVar2 = ((e2.m) list2.get(0)).f4343u;
            int i11 = qVar.f & (-16385);
            int i12 = qVar2.f & (-16385);
            if (Objects.equals(qVar.f10015d, qVar2.f10015d) && i11 == i12) {
                return true;
            }
        }
        return false;
    }

    public static e2.f e(String str, List list) {
        for (int i = 0; i < list.size(); i++) {
            e2.f fVar = (e2.f) list.get(i);
            if (str.equals(fVar.f4321a)) {
                return fVar;
            }
        }
        return null;
    }

    public static void j(l0 l0Var, q[] qVarArr) {
        for (int i = 0; i < qVarArr.length; i++) {
            q qVar = qVarArr[i];
            f0 f0Var = (f0) l0Var.f707x;
            if (f0Var.f4498u && ((k8.b0) f0Var.f4499v).d(qVar)) {
                p pVarA = qVar.a();
                String str = qVar.f10020k;
                pVarA.f9967m = m0.p("application/x-media3-cues");
                pVarA.K = ((k8.b0) f0Var.f4499v).e(qVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(qVar.f10023n);
                sb2.append(str != null ? " ".concat(str) : "");
                pVarA.f9964j = sb2.toString();
                pVarA.f9972r = Long.MAX_VALUE;
                qVar = new q(pVarA);
            }
            qVarArr[i] = qVar;
        }
    }

    public static q[] k(e2.f fVar, Pattern pattern, q qVar) {
        String str = fVar.f4322b;
        if (str == null) {
            return new q[]{qVar};
        }
        int i = s1.b0.f11647a;
        String[] strArrSplit = str.split(";", -1);
        q[] qVarArr = new q[strArrSplit.length];
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            Matcher matcher = pattern.matcher(strArrSplit[i10]);
            if (!matcher.matches()) {
                return new q[]{qVar};
            }
            int i11 = Integer.parseInt(matcher.group(1));
            p pVarA = qVar.a();
            pVarA.f9957a = qVar.f10012a + ":" + i11;
            pVarA.J = i11;
            pVarA.f9960d = matcher.group(2);
            qVarArr[i10] = new q(pVarA);
        }
        return qVarArr;
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        for (p2.i iVar : this.L) {
            if (iVar.f10154u == 2) {
                return iVar.f10158y.a(j5, d2Var);
            }
        }
        return j5;
    }

    @Override // o2.e1
    public final boolean c() {
        return this.N.c();
    }

    @Override // o2.d1
    public final void d(e1 e1Var) {
        this.K.d(this);
    }

    public final int f(int[] iArr, int i) {
        int i10 = iArr[i];
        if (i10 != -1) {
            a[] aVarArr = this.E;
            int i11 = aVarArr[i10].f3697e;
            for (int i12 = 0; i12 < iArr.length; i12++) {
                int i13 = iArr[i12];
                if (i13 == i11 && aVarArr[i13].f3695c == 0) {
                    return i12;
                }
            }
        }
        return -1;
    }

    @Override // o2.e1
    public final long g() {
        return this.N.g();
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        for (p2.i iVar : this.L) {
            iVar.h(z2, j5);
        }
    }

    @Override // o2.b0
    public final long i() {
        p2.i[] iVarArr = this.L;
        int length = iVarArr.length;
        for (int i = 0; i < length; i++) {
            p2.i iVar = iVarArr[i];
            iVar.getClass();
            try {
                if (iVar.R) {
                    return this.S;
                }
            } finally {
                iVar.R = false;
            }
        }
        return -9223372036854775807L;
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        return this.N.l(c1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o2.b0
    public final long n(r[] rVarArr, boolean[] zArr, o2.c1[] c1VarArr, boolean[] zArr2, long j5) {
        int i;
        boolean z2;
        int[] iArr;
        int[] iArr2;
        int i10;
        int i11;
        int i12;
        g1 g1VarA;
        j0 j0Var;
        int i13;
        n nVar;
        boolean z10;
        int[] iArr3 = new int[rVarArr.length];
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i = -1;
            if (i15 >= rVarArr.length) {
                break;
            }
            r rVar = rVarArr[i15];
            if (rVar != null) {
                iArr3[i15] = this.D.b(rVar.k());
            } else {
                iArr3[i15] = -1;
            }
            i15++;
        }
        for (int i16 = 0; i16 < rVarArr.length; i16++) {
            if (rVarArr[i16] == null || !zArr[i16]) {
                o2.c1 c1Var = c1VarArr[i16];
                if (c1Var instanceof p2.i) {
                    ((p2.i) c1Var).C(this);
                } else if (c1Var instanceof p2.g) {
                    p2.g gVar = (p2.g) c1Var;
                    p2.i iVar = gVar.f10153y;
                    boolean[] zArr3 = iVar.f10157x;
                    int i17 = gVar.f10151w;
                    s1.d.g(zArr3[i17]);
                    iVar.f10157x[i17] = false;
                }
                c1VarArr[i16] = null;
            }
        }
        int i18 = 0;
        while (true) {
            z2 = true;
            if (i18 >= rVarArr.length) {
                break;
            }
            o2.c1 c1Var2 = c1VarArr[i18];
            if ((c1Var2 instanceof o2.r) || (c1Var2 instanceof p2.g)) {
                int iF = f(iArr3, i18);
                if (iF == -1) {
                    z10 = c1VarArr[i18] instanceof o2.r;
                } else {
                    o2.c1 c1Var3 = c1VarArr[i18];
                    z10 = (c1Var3 instanceof p2.g) && ((p2.g) c1Var3).f10149u == c1VarArr[iF];
                }
                if (!z10) {
                    o2.c1 c1Var4 = c1VarArr[i18];
                    if (c1Var4 instanceof p2.g) {
                        p2.g gVar2 = (p2.g) c1Var4;
                        p2.i iVar2 = gVar2.f10153y;
                        boolean[] zArr4 = iVar2.f10157x;
                        int i19 = gVar2.f10151w;
                        s1.d.g(zArr4[i19]);
                        iVar2.f10157x[i19] = false;
                    }
                    c1VarArr[i18] = null;
                }
            }
            i18++;
        }
        int i20 = 0;
        while (i20 < rVarArr.length) {
            r rVar2 = rVarArr[i20];
            if (rVar2 == null) {
                iArr2 = iArr3;
                i10 = i14;
                i11 = i20;
            } else {
                o2.c1 c1Var5 = c1VarArr[i20];
                if (c1Var5 == null) {
                    zArr2[i20] = z2;
                    a aVar = this.E[iArr3[i20]];
                    int i21 = aVar.f3695c;
                    if (i21 == 0) {
                        int i22 = aVar.f;
                        boolean z11 = i22 != i ? z2 ? 1 : 0 : i14;
                        if (z11 != 0) {
                            g1VarA = this.D.a(i22);
                            i12 = z2 ? 1 : 0;
                        } else {
                            i12 = i14;
                            g1VarA = null;
                        }
                        int i23 = aVar.f3698g;
                        if (i23 != i) {
                            j0Var = this.E[i23].f3699h;
                        } else {
                            h0 h0Var = j0.f690v;
                            j0Var = c1.f650y;
                        }
                        int size = j0Var.size() + i12;
                        q[] qVarArr = new q[size];
                        int[] iArr4 = new int[size];
                        if (z11 != 0) {
                            qVarArr[i14] = g1VarA.f9765d[i14];
                            iArr4[i14] = 5;
                            i13 = z2 ? 1 : 0;
                        } else {
                            i13 = i14;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i24 = i14; i24 < j0Var.size(); i24++) {
                            q qVar = (q) j0Var.get(i24);
                            qVarArr[i13] = qVar;
                            iArr4[i13] = 3;
                            arrayList.add(qVar);
                            i13 += z2 ? 1 : 0;
                        }
                        if (!this.O.f4302d || z11 == 0) {
                            nVar = null;
                        } else {
                            o oVar = this.G;
                            nVar = new n(oVar, oVar.f3761u);
                        }
                        l0 l0Var = this.f3701v;
                        s2.n nVar2 = this.B;
                        e2.c cVar = this.O;
                        ub.o oVar2 = this.f3705z;
                        int i25 = this.P;
                        int[] iArr5 = aVar.f3693a;
                        int i26 = aVar.f3694b;
                        iArr2 = iArr3;
                        long j8 = this.A;
                        e0 e0Var = this.f3702w;
                        v1.h hVarG = ((v1.g) l0Var.f706w).g();
                        if (e0Var != null) {
                            hVarG.g(e0Var);
                        }
                        n nVar3 = nVar;
                        i10 = 0;
                        i11 = i20;
                        p2.i iVar3 = new p2.i(aVar.f3694b, iArr4, qVarArr, new k((f0) l0Var.f707x, nVar2, cVar, oVar2, i25, iArr5, rVar2, i26, hVarG, j8, l0Var.f705v, z11, arrayList, nVar), this, this.C, j5, this.f3703x, this.J, this.f3704y, this.I, this.R);
                        synchronized (this) {
                            this.H.put(iVar3, nVar3);
                        }
                        c1VarArr[i11] = iVar3;
                    } else {
                        iArr2 = iArr3;
                        i10 = i14;
                        i11 = i20;
                        if (i21 == 2) {
                            c1VarArr[i11] = new l((e2.g) this.Q.get(aVar.f3696d), rVar2.k().f9765d[i10], this.O.f4302d);
                        }
                    }
                } else {
                    iArr2 = iArr3;
                    i10 = i14;
                    i11 = i20;
                    if (c1Var5 instanceof p2.i) {
                        ((k) ((p2.i) c1Var5).f10158y).f3743j = rVar2;
                    }
                }
            }
            i20 = i11 + 1;
            i14 = i10;
            iArr3 = iArr2;
            i = -1;
            z2 = true;
        }
        int[] iArr6 = iArr3;
        boolean z12 = i14;
        int i27 = z12 ? 1 : 0;
        while (i27 < rVarArr.length) {
            if (c1VarArr[i27] != null || rVarArr[i27] == null) {
                iArr = iArr6;
            } else {
                a aVar2 = this.E[iArr6[i27]];
                if (aVar2.f3695c == 1) {
                    iArr = iArr6;
                    int iF2 = f(iArr, i27);
                    if (iF2 != -1) {
                        p2.i iVar4 = (p2.i) c1VarArr[iF2];
                        int i28 = aVar2.f3694b;
                        boolean[] zArr5 = iVar4.f10157x;
                        b1[] b1VarArr = iVar4.H;
                        for (int i29 = z12 ? 1 : 0; i29 < b1VarArr.length; i29++) {
                            if (iVar4.f10155v[i29] == i28) {
                                s1.d.g(!zArr5[i29]);
                                zArr5[i29] = true;
                                b1VarArr[i29].G(true, j5);
                                c1VarArr[i27] = new p2.g(iVar4, iVar4, b1VarArr[i29], i29);
                            }
                        }
                        throw new IllegalStateException();
                    }
                    c1VarArr[i27] = new o2.r();
                    i27++;
                    iArr6 = iArr;
                } else {
                    iArr = iArr6;
                }
            }
            i27++;
            iArr6 = iArr;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int length = c1VarArr.length;
        for (int i30 = z12 ? 1 : 0; i30 < length; i30++) {
            o2.c1 c1Var6 = c1VarArr[i30];
            if (c1Var6 instanceof p2.i) {
                arrayList2.add((p2.i) c1Var6);
            } else if (c1Var6 instanceof l) {
                arrayList3.add((l) c1Var6);
            }
        }
        p2.i[] iVarArr = new p2.i[arrayList2.size()];
        this.L = iVarArr;
        arrayList2.toArray(iVarArr);
        l[] lVarArr = new l[arrayList3.size()];
        this.M = lVarArr;
        arrayList3.toArray(lVarArr);
        c0 c0Var = this.F;
        AbstractList abstractListV = aa.q.v(arrayList2, new b2.f(10));
        c0Var.getClass();
        this.N = new o2.n(arrayList2, abstractListV);
        if (this.R) {
            this.R = z12;
            this.S = j5;
        }
        return j5;
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        this.K = a0Var;
        a0Var.m(this);
    }

    @Override // o2.b0
    public final n1 p() {
        return this.D;
    }

    @Override // o2.e1
    public final long r() {
        return this.N.r();
    }

    @Override // o2.b0
    public final void s() {
        this.B.b();
    }

    @Override // o2.b0
    public final long t(long j5) {
        for (p2.i iVar : this.L) {
            iVar.D(j5);
        }
        for (l lVar : this.M) {
            int iA = s1.b0.a(lVar.f3750w, j5, true);
            lVar.A = iA;
            lVar.B = (lVar.f3751x && iA == lVar.f3750w.length) ? j5 : -9223372036854775807L;
        }
        return j5;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    @Override // o2.e1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(long r20) {
        /*
            r19 = this;
            r0 = r19
            p2.i[] r1 = r0.L
            int r2 = r1.length
            r4 = 0
        L6:
            if (r4 >= r2) goto L94
            r5 = r1[r4]
            s2.m r6 = r5.C
            boolean r6 = r6.d()
            if (r6 != 0) goto L8e
            e2.c r6 = r0.O
            int r7 = r0.P
            long r10 = r6.d(r7)
            o2.b1 r6 = r5.G
            s2.m r7 = r5.C
            boolean r7 = r7.d()
            r7 = r7 ^ 1
            s1.d.g(r7)
            boolean r7 = r5.z()
            if (r7 != 0) goto L8e
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r9 == 0) goto L8e
            java.util.ArrayList r9 = r5.E
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L3f
            goto L8e
        L3f:
            p2.a r9 = r5.x()
            long r12 = r9.F
            int r7 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r7 == 0) goto L4a
            goto L4c
        L4a:
            long r12 = r9.B
        L4c:
            int r7 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r7 > 0) goto L51
            goto L8e
        L51:
            long r12 = r6.q()
            int r7 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r7 > 0) goto L5a
            goto L8e
        L5a:
            long r7 = r6.r()
            r14 = 1
            long r7 = r7 + r14
            long r7 = java.lang.Math.max(r10, r7)
            r6.l(r7)
            o2.b1[] r6 = r5.H
            int r7 = r6.length
            r8 = 0
        L6c:
            if (r8 >= r7) goto L84
            r9 = r6[r8]
            long r16 = r9.r()
            r18 = r4
            long r3 = r16 + r14
            long r3 = java.lang.Math.max(r10, r3)
            r9.l(r3)
            int r8 = r8 + 1
            r4 = r18
            goto L6c
        L84:
            r18 = r4
            aa.l0 r8 = r5.A
            int r9 = r5.f10154u
            r8.y(r9, r10, r12)
            goto L90
        L8e:
            r18 = r4
        L90:
            int r4 = r18 + 1
            goto L6
        L94:
            o2.n r1 = r0.N
            r2 = r20
            r1.v(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.b.v(long):void");
    }
}
