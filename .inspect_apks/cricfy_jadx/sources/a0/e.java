package a0;

import androidx.emoji2.text.v;
import b0.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends d {
    public int A0;
    public b[] B0;
    public b[] C0;
    public int D0;
    public boolean E0;
    public boolean F0;
    public WeakReference G0;
    public WeakReference H0;
    public WeakReference I0;
    public WeakReference J0;
    public final HashSet K0;
    public final b0.b L0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ArrayList f65q0 = new ArrayList();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final v f66r0 = new v(this);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final b0.e f67s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f68t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public d0.f f69u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f70v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final y.c f71w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f72x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f73y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f74z0;

    public e() {
        b0.e eVar = new b0.e();
        eVar.f1595a = true;
        eVar.f1596b = true;
        eVar.f1599e = new ArrayList();
        new ArrayList();
        eVar.f1600g = null;
        eVar.f1601h = new b0.b();
        eVar.f = new ArrayList();
        eVar.f1597c = this;
        eVar.f1598d = this;
        this.f67s0 = eVar;
        this.f69u0 = null;
        this.f70v0 = false;
        this.f71w0 = new y.c();
        this.f74z0 = 0;
        this.A0 = 0;
        this.B0 = new b[4];
        this.C0 = new b[4];
        this.D0 = 257;
        this.E0 = false;
        this.F0 = false;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = new HashSet();
        this.L0 = new b0.b();
    }

    public static void V(d dVar, d0.f fVar, b0.b bVar) {
        int i;
        int i10;
        if (fVar == null) {
            return;
        }
        int i11 = dVar.f38g0;
        int[] iArr = dVar.f58t;
        if (i11 == 8 || (dVar instanceof h) || (dVar instanceof a)) {
            bVar.f1589e = 0;
            bVar.f = 0;
            return;
        }
        int[] iArr2 = dVar.f54p0;
        bVar.f1585a = iArr2[0];
        bVar.f1586b = iArr2[1];
        bVar.f1587c = dVar.q();
        bVar.f1588d = dVar.k();
        bVar.i = false;
        bVar.f1592j = 0;
        boolean z10 = bVar.f1585a == 3;
        boolean z11 = bVar.f1586b == 3;
        boolean z12 = z10 && dVar.W > 0.0f;
        boolean z13 = z11 && dVar.W > 0.0f;
        if (z10 && dVar.t(0) && dVar.f56r == 0 && !z12) {
            bVar.f1585a = 2;
            if (z11 && dVar.f57s == 0) {
                bVar.f1585a = 1;
            }
            z10 = false;
        }
        if (z11 && dVar.t(1) && dVar.f57s == 0 && !z13) {
            bVar.f1586b = 2;
            if (z10 && dVar.f56r == 0) {
                bVar.f1586b = 1;
            }
            z11 = false;
        }
        if (dVar.A()) {
            bVar.f1585a = 1;
            z10 = false;
        }
        if (dVar.B()) {
            bVar.f1586b = 1;
            z11 = false;
        }
        if (z12) {
            if (iArr[0] == 4) {
                bVar.f1585a = 1;
            } else if (!z11) {
                if (bVar.f1586b == 1) {
                    i10 = bVar.f1588d;
                } else {
                    bVar.f1585a = 2;
                    fVar.b(dVar, bVar);
                    i10 = bVar.f;
                }
                bVar.f1585a = 1;
                bVar.f1587c = (int) (dVar.W * i10);
            }
        }
        if (z13) {
            if (iArr[1] == 4) {
                bVar.f1586b = 1;
            } else if (!z10) {
                if (bVar.f1585a == 1) {
                    i = bVar.f1587c;
                } else {
                    bVar.f1586b = 2;
                    fVar.b(dVar, bVar);
                    i = bVar.f1589e;
                }
                bVar.f1586b = 1;
                if (dVar.X == -1) {
                    bVar.f1588d = (int) (i / dVar.W);
                } else {
                    bVar.f1588d = (int) (dVar.W * i);
                }
            }
        }
        fVar.b(dVar, bVar);
        dVar.O(bVar.f1589e);
        dVar.L(bVar.f);
        dVar.E = bVar.f1591h;
        dVar.I(bVar.f1590g);
        bVar.f1592j = 0;
    }

    @Override // a0.d
    public final void C() {
        this.f71w0.t();
        this.f72x0 = 0;
        this.f73y0 = 0;
        this.f65q0.clear();
        super.C();
    }

    @Override // a0.d
    public final void F(l7.a aVar) {
        super.F(aVar);
        int size = this.f65q0.size();
        for (int i = 0; i < size; i++) {
            ((d) this.f65q0.get(i)).F(aVar);
        }
    }

    @Override // a0.d
    public final void P(boolean z10, boolean z11) {
        super.P(z10, z11);
        int size = this.f65q0.size();
        for (int i = 0; i < size; i++) {
            ((d) this.f65q0.get(i)).P(z10, z11);
        }
    }

    public final void R(d dVar, int i) {
        if (i == 0) {
            int i10 = this.f74z0 + 1;
            b[] bVarArr = this.C0;
            if (i10 >= bVarArr.length) {
                this.C0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.C0;
            int i11 = this.f74z0;
            bVarArr2[i11] = new b(dVar, 0, this.f70v0);
            this.f74z0 = i11 + 1;
            return;
        }
        if (i == 1) {
            int i12 = this.A0 + 1;
            b[] bVarArr3 = this.B0;
            if (i12 >= bVarArr3.length) {
                this.B0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.B0;
            int i13 = this.A0;
            bVarArr4[i13] = new b(dVar, 1, this.f70v0);
            this.A0 = i13 + 1;
        }
    }

    public final void S(y.c cVar) {
        e eVar;
        y.c cVar2;
        boolean zW = W(64);
        b(cVar, zW);
        int size = this.f65q0.size();
        boolean z10 = false;
        for (int i = 0; i < size; i++) {
            d dVar = (d) this.f65q0.get(i);
            boolean[] zArr = dVar.S;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i10 = 0; i10 < size; i10++) {
                d dVar2 = (d) this.f65q0.get(i10);
                if (dVar2 instanceof a) {
                    a aVar = (a) dVar2;
                    for (int i11 = 0; i11 < aVar.f108r0; i11++) {
                        d dVar3 = aVar.f107q0[i11];
                        if (aVar.f1t0 || dVar3.c()) {
                            int i12 = aVar.f0s0;
                            if (i12 == 0 || i12 == 1) {
                                dVar3.S[0] = true;
                            } else if (i12 == 2 || i12 == 3) {
                                dVar3.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.K0;
        hashSet.clear();
        for (int i13 = 0; i13 < size; i13++) {
            d dVar4 = (d) this.f65q0.get(i13);
            dVar4.getClass();
            boolean z11 = dVar4 instanceof g;
            if (z11 || (dVar4 instanceof h)) {
                if (z11) {
                    hashSet.add(dVar4);
                } else {
                    dVar4.b(cVar, zW);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) ((d) it.next());
                for (int i14 = 0; i14 < gVar.f108r0; i14++) {
                    if (hashSet.contains(gVar.f107q0[i14])) {
                        gVar.b(cVar, zW);
                        hashSet.remove(gVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).b(cVar, zW);
                }
                hashSet.clear();
            }
        }
        if (y.c.f14520q) {
            HashSet<d> hashSet2 = new HashSet();
            for (int i15 = 0; i15 < size; i15++) {
                d dVar5 = (d) this.f65q0.get(i15);
                dVar5.getClass();
                if (!(dVar5 instanceof g) && !(dVar5 instanceof h)) {
                    hashSet2.add(dVar5);
                }
            }
            eVar = this;
            cVar2 = cVar;
            eVar.a(this, cVar2, hashSet2, this.f54p0[0] == 2 ? 0 : 1, false);
            for (d dVar6 : hashSet2) {
                j.b(this, cVar2, dVar6);
                dVar6.b(cVar2, zW);
            }
        } else {
            eVar = this;
            cVar2 = cVar;
            for (int i16 = 0; i16 < size; i16++) {
                d dVar7 = (d) eVar.f65q0.get(i16);
                if (dVar7 instanceof e) {
                    int[] iArr = dVar7.f54p0;
                    int i17 = iArr[0];
                    int i18 = iArr[1];
                    if (i17 == 2) {
                        dVar7.M(1);
                    }
                    if (i18 == 2) {
                        dVar7.N(1);
                    }
                    dVar7.b(cVar2, zW);
                    if (i17 == 2) {
                        dVar7.M(i17);
                    }
                    if (i18 == 2) {
                        dVar7.N(i18);
                    }
                } else {
                    j.b(this, cVar2, dVar7);
                    if (!(dVar7 instanceof g) && !(dVar7 instanceof h)) {
                        dVar7.b(cVar2, zW);
                    }
                }
            }
        }
        if (eVar.f74z0 > 0) {
            j.a(this, cVar2, null, 0);
        }
        if (eVar.A0 > 0) {
            j.a(this, cVar2, null, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean T(int i, boolean z10) {
        int i10;
        int i11;
        boolean z11;
        boolean z12;
        b0.e eVar = this.f67s0;
        ArrayList arrayList = (ArrayList) eVar.f1599e;
        e eVar2 = (e) eVar.f1597c;
        int iJ = eVar2.j(0);
        int[] iArr = eVar2.f54p0;
        int iJ2 = eVar2.j(1);
        int iR = eVar2.r();
        int iS = eVar2.s();
        if (z10 && (iJ == 2 || iJ2 == 2)) {
            int size = arrayList.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z12 = z10;
                    break;
                }
                Object obj = arrayList.get(i12);
                i12++;
                o oVar = (o) obj;
                if (oVar.f == i && !oVar.k()) {
                    z12 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z12 && iJ == 2) {
                    eVar2.M(1);
                    eVar2.O(eVar.e(eVar2, 0));
                    eVar2.f32d.f1628e.d(eVar2.q());
                }
            } else if (z12 && iJ2 == 2) {
                eVar2.N(1);
                eVar2.L(eVar.e(eVar2, 1));
                eVar2.f34e.f1628e.d(eVar2.k());
            }
        }
        if (i == 0) {
            i10 = 0;
            int i13 = iArr[0];
            if (i13 == 1 || i13 == 4) {
                int iQ = eVar2.q() + iR;
                eVar2.f32d.i.d(iQ);
                eVar2.f32d.f1628e.d(iQ - iR);
                i11 = 1;
            }
            i11 = i10;
        } else {
            i10 = 0;
            int i14 = iArr[1];
            if (i14 == 1 || i14 == 4) {
                int iK = eVar2.k() + iS;
                eVar2.f34e.i.d(iK);
                eVar2.f34e.f1628e.d(iK - iS);
                i11 = 1;
            }
            i11 = i10;
        }
        eVar.i();
        int size2 = arrayList.size();
        int i15 = i10;
        while (i15 < size2) {
            Object obj2 = arrayList.get(i15);
            i15++;
            o oVar2 = (o) obj2;
            if (oVar2.f == i && (oVar2.f1625b != eVar2 || oVar2.f1629g)) {
                oVar2.e();
            }
        }
        int size3 = arrayList.size();
        int i16 = i10;
        while (i16 < size3) {
            Object obj3 = arrayList.get(i16);
            i16++;
            o oVar3 = (o) obj3;
            if (oVar3.f == i && (i11 != 0 || oVar3.f1625b != eVar2)) {
                if (!oVar3.f1630h.f1609j || !oVar3.i.f1609j || (!(oVar3 instanceof b0.c) && !oVar3.f1628e.f1609j)) {
                    z11 = i10;
                    break;
                }
            }
        }
        z11 = 1;
        eVar2.M(iJ);
        eVar2.N(iJ2);
        return z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0671 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x081d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:489:0x082a A[LOOP:14: B:488:0x0828->B:489:0x082a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:492:0x085e  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x08bb  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x08f8  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x090b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0127  */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v102 */
    /* JADX WARN: Type inference failed for: r0v103 */
    /* JADX WARN: Type inference failed for: r0v104 */
    /* JADX WARN: Type inference failed for: r0v105 */
    /* JADX WARN: Type inference failed for: r0v106 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r24v15 */
    /* JADX WARN: Type inference failed for: r24v16 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r32v0, types: [a0.d, a0.e] */
    /* JADX WARN: Type inference failed for: r4v55, types: [int] */
    /* JADX WARN: Type inference failed for: r5v57, types: [int] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v74, types: [int] */
    /* JADX WARN: Type inference failed for: r7v22, types: [int] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U() {
        /*
            Method dump skipped, instruction units count: 2329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.e.U():void");
    }

    public final boolean W(int i) {
        return (this.D0 & i) == i;
    }

    @Override // a0.d
    public final void n(StringBuilder sb) {
        sb.append(this.f42j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.V);
        sb.append("\n");
        ArrayList arrayList = this.f65q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((d) obj).n(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
