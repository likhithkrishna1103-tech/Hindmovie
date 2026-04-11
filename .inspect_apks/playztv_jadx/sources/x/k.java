package x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean[] f14203a = new boolean[3];

    /* JADX WARN: Removed duplicated region for block: B:188:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x06d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x06f2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(x.f r40, v.c r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instruction units count: 1791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.k.a(x.f, v.c, java.util.ArrayList, int):void");
    }

    public static void b(f fVar, v.c cVar, e eVar) {
        eVar.f14146o = -1;
        d dVar = eVar.M;
        int[] iArr = eVar.f14149p0;
        d dVar2 = eVar.L;
        d dVar3 = eVar.J;
        d dVar4 = eVar.K;
        d dVar5 = eVar.I;
        eVar.f14148p = -1;
        int[] iArr2 = fVar.f14149p0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i = dVar5.f14119g;
            int iQ = fVar.q() - dVar4.f14119g;
            dVar5.i = cVar.k(dVar5);
            dVar4.i = cVar.k(dVar4);
            cVar.d(dVar5.i, i);
            cVar.d(dVar4.i, iQ);
            eVar.f14146o = 2;
            eVar.Y = i;
            int i10 = iQ - i;
            eVar.U = i10;
            int i11 = eVar.f14124b0;
            if (i10 < i11) {
                eVar.U = i11;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i12 = dVar3.f14119g;
        int iK = fVar.k() - dVar2.f14119g;
        dVar3.i = cVar.k(dVar3);
        dVar2.i = cVar.k(dVar2);
        cVar.d(dVar3.i, i12);
        cVar.d(dVar2.i, iK);
        if (eVar.f14122a0 > 0 || eVar.f14133g0 == 8) {
            v.f fVarK = cVar.k(dVar);
            dVar.i = fVarK;
            cVar.d(fVarK, eVar.f14122a0 + i12);
        }
        eVar.f14148p = 2;
        eVar.Z = i12;
        int i13 = iK - i12;
        eVar.V = i13;
        int i14 = eVar.f14126c0;
        if (i13 < i14) {
            eVar.V = i14;
        }
    }

    public static final boolean c(int i, int i10) {
        return (i & i10) == i10;
    }
}
