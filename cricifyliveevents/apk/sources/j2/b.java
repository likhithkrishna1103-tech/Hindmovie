package j2;

import android.util.Pair;
import android.util.SparseArray;
import b2.h0;
import com.google.android.gms.internal.measurement.o4;
import f9.z;
import g2.s0;
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
import nc.p;
import s2.a0;
import s2.a1;
import s2.b1;
import s2.c1;
import s2.l1;
import ua.g0;
import ua.i0;
import ua.q;
import ua.z0;
import v1.g1;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a0, b1, t2.g {
    public static final Pattern U = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern V = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    public final p A;
    public final long B;
    public final w2.p C;
    public final w2.e D;
    public final l1 E;
    public final a[] F;
    public final z G;
    public final o H;
    public final f3.a J;
    public final l2.k K;
    public s2.z L;
    public s2.n O;
    public k2.c P;
    public int Q;
    public List R;
    public long T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f6521v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f3.a f6522w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h0 f6523x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l2.n f6524y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f9.a0 f6525z;
    public boolean S = true;
    public t2.h[] M = new t2.h[0];
    public l[] N = new l[0];
    public final IdentityHashMap I = new IdentityHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i, k2.c cVar, p pVar, int i10, f3.a aVar, h0 h0Var, l2.n nVar, l2.k kVar, f9.a0 a0Var, f3.a aVar2, long j4, w2.p pVar2, w2.e eVar, z zVar, f fVar, h2.l lVar) {
        int i11;
        int i12;
        int[][] iArr;
        boolean[] zArr;
        v1.p[][] pVarArr;
        v1.p[] pVarArrN;
        k2.f fVarC;
        Integer num;
        l2.n nVar2 = nVar;
        this.f6521v = i;
        this.P = cVar;
        this.A = pVar;
        this.Q = i10;
        this.f6522w = aVar;
        this.f6523x = h0Var;
        this.f6524y = nVar2;
        this.K = kVar;
        this.f6525z = a0Var;
        this.J = aVar2;
        this.B = j4;
        this.C = pVar2;
        this.D = eVar;
        this.G = zVar;
        boolean z10 = true;
        this.H = new o(cVar, fVar, eVar);
        int i13 = 0;
        zVar.getClass();
        g0 g0Var = i0.f12341w;
        z0 z0Var = z0.f12413z;
        this.O = new s2.n(z0Var, z0Var);
        k2.h hVarB = cVar.b(i10);
        List list = hVarB.f6862d;
        this.R = list;
        List list2 = hVarB.f6861c;
        int size = list2.size();
        HashMap map = new HashMap(q.a(size));
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i14 = 0; i14 < size; i14++) {
            map.put(Long.valueOf(((k2.a) list2.get(i14)).f6822a), Integer.valueOf(i14));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i14));
            arrayList.add(arrayList2);
            sparseArray.put(i14, arrayList2);
        }
        int i15 = 0;
        while (i15 < size) {
            k2.a aVar3 = (k2.a) list2.get(i15);
            List list3 = aVar3.f6826e;
            List list4 = aVar3.f;
            boolean z11 = z10;
            k2.f fVarC2 = c("http://dashif.org/guidelines/trickmode", list3);
            fVarC2 = fVarC2 == null ? c("http://dashif.org/guidelines/trickmode", list4) : fVarC2;
            int iIntValue = (fVarC2 == null || (num = (Integer) map.get(Long.valueOf(Long.parseLong(fVarC2.f6853b)))) == null || !b(aVar3, (k2.a) list2.get(num.intValue()))) ? i15 : num.intValue();
            if (iIntValue == i15 && (fVarC = c("urn:mpeg:dash:adaptation-set-switching:2016", list4)) != null) {
                String str = fVarC.f6853b;
                int i16 = y1.a0.f14551a;
                String[] strArrSplit = str.split(",", -1);
                int length = strArrSplit.length;
                for (int i17 = i13; i17 < length; i17++) {
                    Integer num2 = (Integer) map.get(Long.valueOf(Long.parseLong(strArrSplit[i17])));
                    if (num2 != null && b(aVar3, (k2.a) list2.get(num2.intValue()))) {
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
            z10 = z11;
            i13 = 0;
        }
        boolean z12 = z10;
        int size2 = arrayList.size();
        int[][] iArr2 = new int[size2][];
        for (int i18 = 0; i18 < size2; i18++) {
            int[] iArrC = com.bumptech.glide.d.C((Collection) arrayList.get(i18));
            iArr2[i18] = iArrC;
            Arrays.sort(iArrC);
        }
        boolean[] zArr2 = new boolean[size2];
        v1.p[][] pVarArr2 = new v1.p[size2][];
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
                List list7 = ((k2.a) list2.get(iArr3[i21])).f6824c;
                iArr = iArr2;
                for (int i22 = 0; i22 < list7.size(); i22++) {
                    if (!((k2.m) list7.get(i22)).f6875y.isEmpty()) {
                        zArr2[i19] = z12;
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
                    pVarArr = pVarArr2;
                    pVarArrN = new v1.p[0];
                    break;
                }
                int i24 = iArr4[i23];
                k2.a aVar4 = (k2.a) list2.get(i24);
                List list8 = ((k2.a) list2.get(i24)).f6825d;
                int[] iArr5 = iArr4;
                int i25 = 0;
                while (i25 < list8.size()) {
                    k2.f fVar2 = (k2.f) list8.get(i25);
                    zArr = zArr2;
                    pVarArr = pVarArr2;
                    if ("urn:scte:dash:cc:cea-608:2015".equals(fVar2.f6852a)) {
                        v1.o oVar = new v1.o();
                        oVar.f12893m = m0.p("application/cea-608");
                        oVar.f12883a = q4.a.p(new StringBuilder(), aVar4.f6822a, ":cea608");
                        pVarArrN = n(fVar2, U, new v1.p(oVar));
                        break;
                    }
                    if ("urn:scte:dash:cc:cea-708:2015".equals(fVar2.f6852a)) {
                        v1.o oVar2 = new v1.o();
                        oVar2.f12893m = m0.p("application/cea-708");
                        oVar2.f12883a = q4.a.p(new StringBuilder(), aVar4.f6822a, ":cea708");
                        pVarArrN = n(fVar2, V, new v1.p(oVar2));
                        break;
                    }
                    i25++;
                    pVarArr2 = pVarArr;
                    zArr2 = zArr;
                }
                i23++;
                iArr4 = iArr5;
            }
            pVarArr[i19] = pVarArrN;
            if (pVarArrN.length != 0) {
                i20++;
            }
            i19++;
            pVarArr2 = pVarArr;
            iArr2 = iArr;
            zArr2 = zArr;
        }
        int[][] iArr6 = iArr2;
        boolean[] zArr3 = zArr2;
        v1.p[][] pVarArr3 = pVarArr2;
        int size3 = list.size() + i20 + size2;
        g1[] g1VarArr = new g1[size3];
        a[] aVarArr = new a[size3];
        int i26 = 0;
        int i27 = 0;
        while (i27 < size2) {
            int[] iArr7 = iArr6[i27];
            ArrayList arrayList3 = new ArrayList();
            for (int i28 : iArr7) {
                arrayList3.addAll(((k2.a) list2.get(i28)).f6824c);
            }
            int size4 = arrayList3.size();
            v1.p[] pVarArr4 = new v1.p[size4];
            int i29 = 0;
            while (i29 < size4) {
                int i30 = size2;
                v1.p pVar3 = ((k2.m) arrayList3.get(i29)).f6872v;
                int i31 = i26;
                v1.o oVarA = pVar3.a();
                oVarA.N = nVar2.h(pVar3);
                pVarArr4[i29] = new v1.p(oVarA);
                i29++;
                size2 = i30;
                i26 = i31;
            }
            int i32 = size2;
            int i33 = i26;
            k2.a aVar5 = (k2.a) list2.get(iArr7[0]);
            long j7 = aVar5.f6822a;
            String string = j7 != -1 ? Long.toString(j7) : l0.e.g(i27, "unset:");
            int i34 = i33 + 1;
            if (zArr3[i27]) {
                i11 = i33 + 2;
            } else {
                i11 = i34;
                i34 = -1;
            }
            if (pVarArr3[i27].length != 0) {
                i12 = i11 + 1;
            } else {
                i12 = i11;
                i11 = -1;
            }
            g(aVar, pVarArr4);
            List list9 = list2;
            g1VarArr[i33] = new g1(string, pVarArr4);
            int i35 = aVar5.f6823b;
            g0 g0Var2 = i0.f12341w;
            z0 z0Var2 = z0.f12413z;
            a aVar6 = new a(i35, 0, iArr7, i33, i34, i11, -1, z0Var2);
            int[] iArr8 = iArr7;
            int i36 = i33;
            aVarArr[i36] = aVar6;
            int i37 = -1;
            if (i34 != -1) {
                String strJ = l0.e.j(string, ":emsg");
                v1.o oVar3 = new v1.o();
                oVar3.f12883a = strJ;
                oVar3.f12893m = m0.p("application/x-emsg");
                v1.p[] pVarArr5 = new v1.p[z12];
                pVarArr5[0] = new v1.p(oVar3);
                g1VarArr[i34] = new g1(strJ, pVarArr5);
                a aVar7 = new a(5, 1, iArr8, i36, -1, -1, -1, z0Var2);
                iArr8 = iArr8;
                i36 = i36;
                aVarArr[i34] = aVar7;
                i37 = -1;
            }
            if (i11 != i37) {
                String strJ2 = l0.e.j(string, ":cc");
                aVarArr[i11] = new a(3, 1, iArr8, i36, -1, -1, -1, i0.l(pVarArr3[i27]));
                g(aVar, pVarArr3[i27]);
                g1VarArr[i11] = new g1(strJ2, pVarArr3[i27]);
            }
            i27++;
            size2 = i32;
            nVar2 = nVar;
            i26 = i12;
            list2 = list9;
            z12 = true;
        }
        int i38 = 0;
        while (i38 < list.size()) {
            k2.g gVar = (k2.g) list.get(i38);
            v1.o oVar4 = new v1.o();
            oVar4.f12883a = gVar.a();
            oVar4.f12893m = m0.p("application/x-emsg");
            g1VarArr[i26] = new g1(gVar.a() + ":" + i38, new v1.p(oVar4));
            g0 g0Var3 = i0.f12341w;
            aVarArr[i26] = new a(5, 2, new int[0], -1, -1, -1, i38, z0.f12413z);
            i38++;
            i26++;
        }
        Pair pairCreate = Pair.create(new l1(g1VarArr), aVarArr);
        this.E = (l1) pairCreate.first;
        this.F = (a[]) pairCreate.second;
    }

    public static boolean b(k2.a aVar, k2.a aVar2) {
        int i = aVar.f6823b;
        List list = aVar.f6824c;
        int i10 = aVar2.f6823b;
        List list2 = aVar2.f6824c;
        if (i == i10) {
            if (list.isEmpty() || list2.isEmpty()) {
                return true;
            }
            v1.p pVar = ((k2.m) list.get(0)).f6872v;
            v1.p pVar2 = ((k2.m) list2.get(0)).f6872v;
            int i11 = pVar.f & (-16385);
            int i12 = pVar2.f & (-16385);
            if (Objects.equals(pVar.f12938d, pVar2.f12938d) && i11 == i12) {
                return true;
            }
        }
        return false;
    }

    public static k2.f c(String str, List list) {
        for (int i = 0; i < list.size(); i++) {
            k2.f fVar = (k2.f) list.get(i);
            if (str.equals(fVar.f6852a)) {
                return fVar;
            }
        }
        return null;
    }

    public static void g(f3.a aVar, v1.p[] pVarArr) {
        for (int i = 0; i < pVarArr.length; i++) {
            v1.p pVar = pVarArr[i];
            o4 o4Var = (o4) aVar.f3937y;
            if (o4Var.f2560v && ((x3.e) o4Var.f2561w).e(pVar)) {
                v1.o oVarA = pVar.a();
                String str = pVar.f12943k;
                oVarA.f12893m = m0.p("application/x-media3-cues");
                oVarA.K = ((x3.e) o4Var.f2561w).b(pVar);
                StringBuilder sb = new StringBuilder();
                sb.append(pVar.f12946n);
                sb.append(str != null ? " ".concat(str) : "");
                oVarA.f12890j = sb.toString();
                oVarA.f12898r = Long.MAX_VALUE;
                pVar = new v1.p(oVarA);
            }
            pVarArr[i] = pVar;
        }
    }

    public static v1.p[] n(k2.f fVar, Pattern pattern, v1.p pVar) {
        String str = fVar.f6853b;
        if (str == null) {
            return new v1.p[]{pVar};
        }
        int i = y1.a0.f14551a;
        String[] strArrSplit = str.split(";", -1);
        v1.p[] pVarArr = new v1.p[strArrSplit.length];
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            Matcher matcher = pattern.matcher(strArrSplit[i10]);
            if (!matcher.matches()) {
                return new v1.p[]{pVar};
            }
            int i11 = Integer.parseInt(matcher.group(1));
            v1.o oVarA = pVar.a();
            oVarA.f12883a = pVar.f12935a + ":" + i11;
            oVarA.J = i11;
            oVarA.f12886d = matcher.group(2);
            pVarArr[i10] = new v1.p(oVarA);
        }
        return pVarArr;
    }

    @Override // s2.c1
    public final boolean a() {
        return this.O.a();
    }

    @Override // s2.a0
    public final void d(s2.z zVar, long j4) {
        this.L = zVar;
        zVar.k(this);
    }

    public final int e(int[] iArr, int i) {
        int i10 = iArr[i];
        if (i10 != -1) {
            a[] aVarArr = this.F;
            int i11 = aVarArr[i10].f6518e;
            for (int i12 = 0; i12 < iArr.length; i12++) {
                int i13 = iArr[i12];
                if (i13 == i11 && aVarArr[i13].f6516c == 0) {
                    return i12;
                }
            }
        }
        return -1;
    }

    @Override // s2.b1
    public final void f(c1 c1Var) {
        this.L.f(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    @Override // s2.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long h(long r20, g2.r1 r22) {
        /*
            r19 = this;
            r1 = r20
            r7 = r19
            t2.h[] r0 = r7.M
            int r3 = r0.length
            r4 = 0
            r5 = r4
        L9:
            if (r5 >= r3) goto L78
            r6 = r0[r5]
            int r8 = r6.f11858v
            r9 = 2
            if (r8 != r9) goto L73
            j2.k r0 = r6.f11862z
            f9.r[] r0 = r0.i
            int r3 = r0.length
        L17:
            if (r4 >= r3) goto L78
            r5 = r0[r4]
            java.lang.Object r6 = r5.B
            j2.i r6 = (j2.i) r6
            long r8 = r5.f4360x
            java.lang.Object r10 = r5.B
            j2.i r10 = (j2.i) r10
            if (r6 == 0) goto L6e
            long r11 = r5.e()
            r13 = 0
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 != 0) goto L32
            goto L6e
        L32:
            y1.d.h(r10)
            long r3 = r5.f4359w
            long r3 = r10.c(r1, r3)
            long r3 = r3 + r8
            r13 = r3
            long r3 = r5.g(r13)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L67
            r15 = -1
            int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            r15 = 1
            if (r0 == 0) goto L5e
            y1.d.h(r10)
            long r17 = r10.q()
            long r17 = r17 + r8
            long r17 = r17 + r11
            long r17 = r17 - r15
            int r0 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r0 >= 0) goto L67
        L5e:
            long r8 = r13 + r15
            long r5 = r5.g(r8)
        L64:
            r0 = r22
            goto L69
        L67:
            r5 = r3
            goto L64
        L69:
            long r0 = r0.a(r1, r3, r5)
            return r0
        L6e:
            int r4 = r4 + 1
            r1 = r20
            goto L17
        L73:
            int r5 = r5 + 1
            r1 = r20
            goto L9
        L78:
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.b.h(long, g2.r1):long");
    }

    @Override // s2.c1
    public final boolean i(s0 s0Var) {
        return this.O.i(s0Var);
    }

    @Override // s2.c1
    public final long j() {
        return this.O.j();
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) throws Throwable {
        long j7;
        for (t2.h hVar : this.M) {
            if (!hVar.y()) {
                s2.z0 z0Var = hVar.H;
                int i = z0Var.f11387q;
                z0Var.j(j4, z10, true);
                s2.z0 z0Var2 = hVar.H;
                int i10 = z0Var2.f11387q;
                if (i10 > i) {
                    synchronized (z0Var2) {
                        j7 = z0Var2.f11386p == 0 ? Long.MIN_VALUE : z0Var2.f11384n[z0Var2.f11388r];
                    }
                    int i11 = 0;
                    while (true) {
                        s2.z0[] z0VarArr = hVar.I;
                        if (i11 >= z0VarArr.length) {
                            break;
                        }
                        z0VarArr[i11].j(j7, z10, hVar.f11861y[i11]);
                        i11++;
                    }
                }
                int iMin = Math.min(hVar.A(i10, 0), hVar.P);
                if (iMin > 0) {
                    y1.a0.T(hVar.F, 0, iMin);
                    hVar.P -= iMin;
                }
            }
        }
    }

    @Override // s2.a0
    public final long m() {
        t2.h[] hVarArr = this.M;
        int length = hVarArr.length;
        for (int i = 0; i < length; i++) {
            t2.h hVar = hVarArr[i];
            hVar.getClass();
            try {
                if (hVar.S) {
                    return this.T;
                }
            } finally {
                hVar.S = false;
            }
        }
        return -9223372036854775807L;
    }

    @Override // s2.a0
    public final l1 o() {
        return this.E;
    }

    @Override // s2.c1
    public final long q() {
        return this.O.q();
    }

    @Override // s2.a0
    public final void r() {
        this.C.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    @Override // s2.a0
    public final long t(long j4) {
        int i;
        t2.a aVar;
        boolean zG;
        boolean z10;
        t2.h[] hVarArr = this.M;
        int length = hVarArr.length;
        boolean z11 = false;
        int i10 = 0;
        while (i10 < length) {
            t2.h hVar = hVarArr[i10];
            s2.z0[] z0VarArr = hVar.I;
            s2.z0 z0Var = hVar.H;
            w2.o oVar = hVar.D;
            ?? r14 = hVar.F;
            hVar.O = j4;
            hVar.R = z11;
            if (hVar.y()) {
                hVar.N = j4;
                z10 = z11;
                i = i10;
            } else {
                ?? r15 = z11;
                while (true) {
                    if (r15 >= r14.size()) {
                        i = i10;
                        break;
                    }
                    aVar = (t2.a) r14.get(r15);
                    long j7 = aVar.B;
                    i = i10;
                    if (j7 == j4 && aVar.F == -9223372036854775807L) {
                        break;
                    }
                    if (j7 > j4) {
                        break;
                    }
                    i10 = i;
                    r15++;
                }
                aVar = null;
                if (aVar != null) {
                    zG = z0Var.F(aVar.e(0));
                } else {
                    long j10 = hVar.j();
                    zG = z0Var.G(j10 == Long.MIN_VALUE || j4 < j10, j4);
                }
                if (zG) {
                    hVar.P = hVar.A(z0Var.t(), 0);
                    for (s2.z0 z0Var2 : z0VarArr) {
                        z0Var2.G(true, j4);
                    }
                } else {
                    hVar.N = j4;
                    hVar.T = false;
                    r14.clear();
                    hVar.P = 0;
                    if (oVar.d()) {
                        z0Var.k();
                        for (s2.z0 z0Var3 : z0VarArr) {
                            z0Var3.k();
                        }
                        oVar.a();
                    } else {
                        oVar.f13886c = null;
                        z10 = false;
                        z0Var.D(false);
                        for (s2.z0 z0Var4 : hVar.I) {
                            z0Var4.D(false);
                        }
                    }
                }
                z10 = false;
            }
            i10 = i + 1;
            z11 = z10;
        }
        l[] lVarArr = this.N;
        int length2 = lVarArr.length;
        for (?? r52 = z11; r52 < length2; r52++) {
            l lVar = lVarArr[r52];
            int iA = y1.a0.a(lVar.f6572x, j4, true);
            lVar.B = iA;
            lVar.C = (lVar.f6573y && iA == lVar.f6572x.length) ? j4 : -9223372036854775807L;
        }
        return j4;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    @Override // s2.c1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(long r20) {
        /*
            r19 = this;
            r0 = r19
            t2.h[] r1 = r0.M
            int r2 = r1.length
            r4 = 0
        L6:
            if (r4 >= r2) goto L94
            r5 = r1[r4]
            w2.o r6 = r5.D
            boolean r6 = r6.d()
            if (r6 != 0) goto L8e
            k2.c r6 = r0.P
            int r7 = r0.Q
            long r10 = r6.d(r7)
            s2.z0 r6 = r5.H
            w2.o r7 = r5.D
            boolean r7 = r7.d()
            r7 = r7 ^ 1
            y1.d.g(r7)
            boolean r7 = r5.y()
            if (r7 != 0) goto L8e
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r9 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r9 == 0) goto L8e
            java.util.ArrayList r9 = r5.F
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L3f
            goto L8e
        L3f:
            t2.a r9 = r5.w()
            long r12 = r9.G
            int r7 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r7 == 0) goto L4a
            goto L4c
        L4a:
            long r12 = r9.C
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
            s2.z0[] r6 = r5.I
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
            f3.a r8 = r5.B
            int r9 = r5.f11858v
            r8.z(r9, r10, r12)
            goto L90
        L8e:
            r18 = r4
        L90:
            int r4 = r18 + 1
            goto L6
        L94:
            s2.n r1 = r0.O
            r2 = r20
            r1.u(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.b.u(long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s2.a0
    public final long v(v2.q[] qVarArr, boolean[] zArr, a1[] a1VarArr, boolean[] zArr2, long j4) {
        int i;
        boolean z10;
        int[] iArr;
        int[] iArr2;
        int i10;
        int i11;
        int i12;
        g1 g1VarA;
        i0 i0Var;
        int i13;
        n nVar;
        boolean z11;
        int[] iArr3 = new int[qVarArr.length];
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i = -1;
            if (i15 >= qVarArr.length) {
                break;
            }
            v2.q qVar = qVarArr[i15];
            if (qVar != null) {
                iArr3[i15] = this.E.b(qVar.i());
            } else {
                iArr3[i15] = -1;
            }
            i15++;
        }
        for (int i16 = 0; i16 < qVarArr.length; i16++) {
            if (qVarArr[i16] == null || !zArr[i16]) {
                a1 a1Var = a1VarArr[i16];
                if (a1Var instanceof t2.h) {
                    ((t2.h) a1Var).C(this);
                } else if (a1Var instanceof t2.f) {
                    t2.f fVar = (t2.f) a1Var;
                    t2.h hVar = fVar.f11857z;
                    boolean[] zArr3 = hVar.f11861y;
                    int i17 = fVar.f11855x;
                    y1.d.g(zArr3[i17]);
                    hVar.f11861y[i17] = false;
                }
                a1VarArr[i16] = null;
            }
        }
        int i18 = 0;
        while (true) {
            z10 = true;
            if (i18 >= qVarArr.length) {
                break;
            }
            a1 a1Var2 = a1VarArr[i18];
            if ((a1Var2 instanceof s2.q) || (a1Var2 instanceof t2.f)) {
                int iE = e(iArr3, i18);
                if (iE == -1) {
                    z11 = a1VarArr[i18] instanceof s2.q;
                } else {
                    a1 a1Var3 = a1VarArr[i18];
                    z11 = (a1Var3 instanceof t2.f) && ((t2.f) a1Var3).f11853v == a1VarArr[iE];
                }
                if (!z11) {
                    a1 a1Var4 = a1VarArr[i18];
                    if (a1Var4 instanceof t2.f) {
                        t2.f fVar2 = (t2.f) a1Var4;
                        t2.h hVar2 = fVar2.f11857z;
                        boolean[] zArr4 = hVar2.f11861y;
                        int i19 = fVar2.f11855x;
                        y1.d.g(zArr4[i19]);
                        hVar2.f11861y[i19] = false;
                    }
                    a1VarArr[i18] = null;
                }
            }
            i18++;
        }
        int i20 = 0;
        while (i20 < qVarArr.length) {
            v2.q qVar2 = qVarArr[i20];
            if (qVar2 == null) {
                iArr2 = iArr3;
                i10 = i14;
                i11 = i20;
            } else {
                a1 a1Var5 = a1VarArr[i20];
                if (a1Var5 == null) {
                    zArr2[i20] = z10;
                    a aVar = this.F[iArr3[i20]];
                    int i21 = aVar.f6516c;
                    if (i21 == 0) {
                        int i22 = aVar.f;
                        boolean z12 = i22 != i ? z10 ? 1 : 0 : i14;
                        if (z12 != 0) {
                            g1VarA = this.E.a(i22);
                            i12 = z10 ? 1 : 0;
                        } else {
                            i12 = i14;
                            g1VarA = null;
                        }
                        int i23 = aVar.f6519g;
                        if (i23 != i) {
                            i0Var = this.F[i23].f6520h;
                        } else {
                            g0 g0Var = i0.f12341w;
                            i0Var = z0.f12413z;
                        }
                        int size = i0Var.size() + i12;
                        v1.p[] pVarArr = new v1.p[size];
                        int[] iArr4 = new int[size];
                        if (z12 != 0) {
                            pVarArr[i14] = g1VarA.f12705d[i14];
                            iArr4[i14] = 5;
                            i13 = z10 ? 1 : 0;
                        } else {
                            i13 = i14;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i24 = i14; i24 < i0Var.size(); i24++) {
                            v1.p pVar = (v1.p) i0Var.get(i24);
                            pVarArr[i13] = pVar;
                            iArr4[i13] = 3;
                            arrayList.add(pVar);
                            i13 += z10 ? 1 : 0;
                        }
                        if (!this.P.f6834d || z12 == 0) {
                            nVar = null;
                        } else {
                            o oVar = this.H;
                            nVar = new n(oVar, oVar.f6582v);
                        }
                        f3.a aVar2 = this.f6522w;
                        w2.p pVar2 = this.C;
                        k2.c cVar = this.P;
                        p pVar3 = this.A;
                        int i25 = this.Q;
                        int[] iArr5 = aVar.f6514a;
                        int i26 = aVar.f6515b;
                        iArr2 = iArr3;
                        long j7 = this.B;
                        h0 h0Var = this.f6523x;
                        b2.h hVarH = ((b2.g) aVar2.f3936x).h();
                        if (h0Var != null) {
                            hVarH.d(h0Var);
                        }
                        n nVar2 = nVar;
                        i10 = 0;
                        i11 = i20;
                        t2.h hVar3 = new t2.h(aVar.f6515b, iArr4, pVarArr, new k((o4) aVar2.f3937y, pVar2, cVar, pVar3, i25, iArr5, qVar2, i26, hVarH, j7, aVar2.f3935w, z12, arrayList, nVar), this, this.D, j4, this.f6524y, this.K, this.f6525z, this.J, this.S);
                        synchronized (this) {
                            this.I.put(hVar3, nVar2);
                        }
                        a1VarArr[i11] = hVar3;
                    } else {
                        iArr2 = iArr3;
                        i10 = i14;
                        i11 = i20;
                        if (i21 == 2) {
                            a1VarArr[i11] = new l((k2.g) this.R.get(aVar.f6517d), qVar2.i().f12705d[i10], this.P.f6834d);
                        }
                    }
                } else {
                    iArr2 = iArr3;
                    i10 = i14;
                    i11 = i20;
                    if (a1Var5 instanceof t2.h) {
                        ((t2.h) a1Var5).f11862z.f6565j = qVar2;
                    }
                }
            }
            i20 = i11 + 1;
            i14 = i10;
            iArr3 = iArr2;
            i = -1;
            z10 = true;
        }
        int[] iArr6 = iArr3;
        boolean z13 = i14;
        int i27 = z13 ? 1 : 0;
        while (i27 < qVarArr.length) {
            if (a1VarArr[i27] != null || qVarArr[i27] == null) {
                iArr = iArr6;
            } else {
                a aVar3 = this.F[iArr6[i27]];
                if (aVar3.f6516c == 1) {
                    iArr = iArr6;
                    int iE2 = e(iArr, i27);
                    if (iE2 != -1) {
                        t2.h hVar4 = (t2.h) a1VarArr[iE2];
                        int i28 = aVar3.f6515b;
                        boolean[] zArr5 = hVar4.f11861y;
                        s2.z0[] z0VarArr = hVar4.I;
                        for (int i29 = z13 ? 1 : 0; i29 < z0VarArr.length; i29++) {
                            if (hVar4.f11859w[i29] == i28) {
                                y1.d.g(!zArr5[i29]);
                                zArr5[i29] = true;
                                z0VarArr[i29].G(true, j4);
                                a1VarArr[i27] = new t2.f(hVar4, hVar4, z0VarArr[i29], i29);
                            }
                        }
                        throw new IllegalStateException();
                    }
                    a1VarArr[i27] = new s2.q();
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
        int length = a1VarArr.length;
        for (int i30 = z13 ? 1 : 0; i30 < length; i30++) {
            a1 a1Var6 = a1VarArr[i30];
            if (a1Var6 instanceof t2.h) {
                arrayList2.add((t2.h) a1Var6);
            } else if (a1Var6 instanceof l) {
                arrayList3.add((l) a1Var6);
            }
        }
        t2.h[] hVarArr = new t2.h[arrayList2.size()];
        this.M = hVarArr;
        arrayList2.toArray(hVarArr);
        l[] lVarArr = new l[arrayList3.size()];
        this.N = lVarArr;
        arrayList3.toArray(lVarArr);
        z zVar = this.G;
        AbstractList abstractListW = q.w(arrayList2, new h2.e(15));
        zVar.getClass();
        this.O = new s2.n(arrayList2, abstractListW);
        if (this.S) {
            this.S = z13;
            this.T = j4;
        }
        return j4;
    }
}
