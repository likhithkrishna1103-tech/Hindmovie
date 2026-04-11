package x;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import y.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends e {
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
    public final y.b L0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ArrayList f14160q0 = new ArrayList();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final kc.b f14161r0 = new kc.b(this);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final y.e f14162s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f14163t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public a0.f f14164u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f14165v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final v.c f14166w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f14167x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f14168y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f14169z0;

    public f() {
        y.e eVar = new y.e();
        eVar.f14384b = true;
        eVar.f14385c = true;
        eVar.f14387e = new ArrayList();
        new ArrayList();
        eVar.f = null;
        eVar.f14388g = new y.b();
        eVar.f14389h = new ArrayList();
        eVar.f14383a = this;
        eVar.f14386d = this;
        this.f14162s0 = eVar;
        this.f14164u0 = null;
        this.f14165v0 = false;
        this.f14166w0 = new v.c();
        this.f14169z0 = 0;
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
        this.L0 = new y.b();
    }

    public static void V(e eVar, a0.f fVar, y.b bVar) {
        int i;
        int i10;
        if (fVar == null) {
            return;
        }
        int i11 = eVar.f14133g0;
        int[] iArr = eVar.f14153t;
        if (i11 == 8 || (eVar instanceof i) || (eVar instanceof a)) {
            bVar.f14377e = 0;
            bVar.f = 0;
            return;
        }
        int[] iArr2 = eVar.f14149p0;
        bVar.f14373a = iArr2[0];
        bVar.f14374b = iArr2[1];
        bVar.f14375c = eVar.q();
        bVar.f14376d = eVar.k();
        bVar.i = false;
        bVar.f14380j = 0;
        boolean z2 = bVar.f14373a == 3;
        boolean z10 = bVar.f14374b == 3;
        boolean z11 = z2 && eVar.W > 0.0f;
        boolean z12 = z10 && eVar.W > 0.0f;
        if (z2 && eVar.t(0) && eVar.f14151r == 0 && !z11) {
            bVar.f14373a = 2;
            if (z10 && eVar.f14152s == 0) {
                bVar.f14373a = 1;
            }
            z2 = false;
        }
        if (z10 && eVar.t(1) && eVar.f14152s == 0 && !z12) {
            bVar.f14374b = 2;
            if (z2 && eVar.f14151r == 0) {
                bVar.f14374b = 1;
            }
            z10 = false;
        }
        if (eVar.A()) {
            bVar.f14373a = 1;
            z2 = false;
        }
        if (eVar.B()) {
            bVar.f14374b = 1;
            z10 = false;
        }
        if (z11) {
            if (iArr[0] == 4) {
                bVar.f14373a = 1;
            } else if (!z10) {
                if (bVar.f14374b == 1) {
                    i10 = bVar.f14376d;
                } else {
                    bVar.f14373a = 2;
                    fVar.b(eVar, bVar);
                    i10 = bVar.f;
                }
                bVar.f14373a = 1;
                bVar.f14375c = (int) (eVar.W * i10);
            }
        }
        if (z12) {
            if (iArr[1] == 4) {
                bVar.f14374b = 1;
            } else if (!z2) {
                if (bVar.f14373a == 1) {
                    i = bVar.f14375c;
                } else {
                    bVar.f14374b = 2;
                    fVar.b(eVar, bVar);
                    i = bVar.f14377e;
                }
                bVar.f14374b = 1;
                if (eVar.X == -1) {
                    bVar.f14376d = (int) (i / eVar.W);
                } else {
                    bVar.f14376d = (int) (eVar.W * i);
                }
            }
        }
        fVar.b(eVar, bVar);
        eVar.O(bVar.f14377e);
        eVar.L(bVar.f);
        eVar.E = bVar.f14379h;
        eVar.I(bVar.f14378g);
        bVar.f14380j = 0;
    }

    @Override // x.e
    public final void C() {
        this.f14166w0.t();
        this.f14167x0 = 0;
        this.f14168y0 = 0;
        this.f14160q0.clear();
        super.C();
    }

    @Override // x.e
    public final void F(kc.b bVar) {
        super.F(bVar);
        int size = this.f14160q0.size();
        for (int i = 0; i < size; i++) {
            ((e) this.f14160q0.get(i)).F(bVar);
        }
    }

    @Override // x.e
    public final void P(boolean z2, boolean z10) {
        super.P(z2, z10);
        int size = this.f14160q0.size();
        for (int i = 0; i < size; i++) {
            ((e) this.f14160q0.get(i)).P(z2, z10);
        }
    }

    public final void R(e eVar, int i) {
        if (i == 0) {
            int i10 = this.f14169z0 + 1;
            b[] bVarArr = this.C0;
            if (i10 >= bVarArr.length) {
                this.C0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.C0;
            int i11 = this.f14169z0;
            bVarArr2[i11] = new b(eVar, 0, this.f14165v0);
            this.f14169z0 = i11 + 1;
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
            bVarArr4[i13] = new b(eVar, 1, this.f14165v0);
            this.A0 = i13 + 1;
        }
    }

    public final void S(v.c cVar) {
        f fVar;
        v.c cVar2;
        boolean zW = W(64);
        b(cVar, zW);
        int size = this.f14160q0.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            e eVar = (e) this.f14160q0.get(i);
            boolean[] zArr = eVar.S;
            zArr[0] = false;
            zArr[1] = false;
            if (eVar instanceof a) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i10 = 0; i10 < size; i10++) {
                e eVar2 = (e) this.f14160q0.get(i10);
                if (eVar2 instanceof a) {
                    a aVar = (a) eVar2;
                    for (int i11 = 0; i11 < aVar.f14202r0; i11++) {
                        e eVar3 = aVar.f14201q0[i11];
                        if (aVar.f14096t0 || eVar3.c()) {
                            int i12 = aVar.f14095s0;
                            if (i12 == 0 || i12 == 1) {
                                eVar3.S[0] = true;
                            } else if (i12 == 2 || i12 == 3) {
                                eVar3.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.K0;
        hashSet.clear();
        for (int i13 = 0; i13 < size; i13++) {
            e eVar4 = (e) this.f14160q0.get(i13);
            eVar4.getClass();
            boolean z10 = eVar4 instanceof h;
            if (z10 || (eVar4 instanceof i)) {
                if (z10) {
                    hashSet.add(eVar4);
                } else {
                    eVar4.b(cVar, zW);
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
                h hVar = (h) ((e) it.next());
                for (int i14 = 0; i14 < hVar.f14202r0; i14++) {
                    if (hashSet.contains(hVar.f14201q0[i14])) {
                        hVar.b(cVar, zW);
                        hashSet.remove(hVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).b(cVar, zW);
                }
                hashSet.clear();
            }
        }
        if (v.c.f13087p) {
            HashSet<e> hashSet2 = new HashSet();
            for (int i15 = 0; i15 < size; i15++) {
                e eVar5 = (e) this.f14160q0.get(i15);
                eVar5.getClass();
                if (!(eVar5 instanceof h) && !(eVar5 instanceof i)) {
                    hashSet2.add(eVar5);
                }
            }
            fVar = this;
            cVar2 = cVar;
            fVar.a(this, cVar2, hashSet2, this.f14149p0[0] == 2 ? 0 : 1, false);
            for (e eVar6 : hashSet2) {
                k.b(this, cVar2, eVar6);
                eVar6.b(cVar2, zW);
            }
        } else {
            fVar = this;
            cVar2 = cVar;
            for (int i16 = 0; i16 < size; i16++) {
                e eVar7 = (e) fVar.f14160q0.get(i16);
                if (eVar7 instanceof f) {
                    int[] iArr = eVar7.f14149p0;
                    int i17 = iArr[0];
                    int i18 = iArr[1];
                    if (i17 == 2) {
                        eVar7.M(1);
                    }
                    if (i18 == 2) {
                        eVar7.N(1);
                    }
                    eVar7.b(cVar2, zW);
                    if (i17 == 2) {
                        eVar7.M(i17);
                    }
                    if (i18 == 2) {
                        eVar7.N(i18);
                    }
                } else {
                    k.b(this, cVar2, eVar7);
                    if (!(eVar7 instanceof h) && !(eVar7 instanceof i)) {
                        eVar7.b(cVar2, zW);
                    }
                }
            }
        }
        if (fVar.f14169z0 > 0) {
            k.a(this, cVar2, null, 0);
        }
        if (fVar.A0 > 0) {
            k.a(this, cVar2, null, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean T(int i, boolean z2) {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        y.e eVar = this.f14162s0;
        ArrayList arrayList = eVar.f14387e;
        f fVar = eVar.f14383a;
        int iJ = fVar.j(0);
        int[] iArr = fVar.f14149p0;
        int iJ2 = fVar.j(1);
        int iR = fVar.r();
        int iS = fVar.s();
        if (z2 && (iJ == 2 || iJ2 == 2)) {
            int size = arrayList.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z11 = z2;
                    break;
                }
                Object obj = arrayList.get(i12);
                i12++;
                o oVar = (o) obj;
                if (oVar.f == i && !oVar.k()) {
                    z11 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z11 && iJ == 2) {
                    fVar.M(1);
                    fVar.O(eVar.d(fVar, 0));
                    fVar.f14127d.f14416e.d(fVar.q());
                }
            } else if (z11 && iJ2 == 2) {
                fVar.N(1);
                fVar.L(eVar.d(fVar, 1));
                fVar.f14129e.f14416e.d(fVar.k());
            }
        }
        if (i == 0) {
            i10 = 0;
            int i13 = iArr[0];
            if (i13 == 1 || i13 == 4) {
                int iQ = fVar.q() + iR;
                fVar.f14127d.i.d(iQ);
                fVar.f14127d.f14416e.d(iQ - iR);
                i11 = 1;
            }
            i11 = i10;
        } else {
            i10 = 0;
            int i14 = iArr[1];
            if (i14 == 1 || i14 == 4) {
                int iK = fVar.k() + iS;
                fVar.f14129e.i.d(iK);
                fVar.f14129e.f14416e.d(iK - iS);
                i11 = 1;
            }
            i11 = i10;
        }
        eVar.g();
        int size2 = arrayList.size();
        int i15 = i10;
        while (i15 < size2) {
            Object obj2 = arrayList.get(i15);
            i15++;
            o oVar2 = (o) obj2;
            if (oVar2.f == i && (oVar2.f14413b != fVar || oVar2.f14417g)) {
                oVar2.e();
            }
        }
        int size3 = arrayList.size();
        int i16 = i10;
        while (i16 < size3) {
            Object obj3 = arrayList.get(i16);
            i16++;
            o oVar3 = (o) obj3;
            if (oVar3.f == i && (i11 != 0 || oVar3.f14413b != fVar)) {
                if (!oVar3.f14418h.f14397j || !oVar3.i.f14397j || (!(oVar3 instanceof y.c) && !oVar3.f14416e.f14397j)) {
                    z10 = i10;
                    break;
                }
            }
        }
        z10 = 1;
        fVar.M(iJ);
        fVar.N(iJ2);
        return z10;
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
    /* JADX WARN: Type inference failed for: r32v0, types: [x.e, x.f] */
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
        throw new UnsupportedOperationException("Method not decompiled: x.f.U():void");
    }

    public final boolean W(int i) {
        return (this.D0 & i) == i;
    }

    @Override // x.e
    public final void n(StringBuilder sb2) {
        sb2.append(this.f14137j + ":{\n");
        StringBuilder sb3 = new StringBuilder("  actualWidth:");
        sb3.append(this.U);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.V);
        sb2.append("\n");
        ArrayList arrayList = this.f14160q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((e) obj).n(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }
}
