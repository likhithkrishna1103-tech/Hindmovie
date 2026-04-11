package a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean[] f109a = new boolean[3];

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
    public static void a(a0.e r40, y.c r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instruction units count: 1791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.j.a(a0.e, y.c, java.util.ArrayList, int):void");
    }

    public static void b(e eVar, y.c cVar, d dVar) {
        dVar.f52o = -1;
        c cVar2 = dVar.M;
        int[] iArr = dVar.f54p0;
        c cVar3 = dVar.L;
        c cVar4 = dVar.J;
        c cVar5 = dVar.K;
        c cVar6 = dVar.I;
        dVar.f53p = -1;
        int[] iArr2 = eVar.f54p0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i = cVar6.f24g;
            int iQ = eVar.q() - cVar5.f24g;
            cVar6.i = cVar.k(cVar6);
            cVar5.i = cVar.k(cVar5);
            cVar.d(cVar6.i, i);
            cVar.d(cVar5.i, iQ);
            dVar.f52o = 2;
            dVar.Y = i;
            int i10 = iQ - i;
            dVar.U = i10;
            int i11 = dVar.f29b0;
            if (i10 < i11) {
                dVar.U = i11;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i12 = cVar4.f24g;
        int iK = eVar.k() - cVar3.f24g;
        cVar4.i = cVar.k(cVar4);
        cVar3.i = cVar.k(cVar3);
        cVar.d(cVar4.i, i12);
        cVar.d(cVar3.i, iK);
        if (dVar.f27a0 > 0 || dVar.f38g0 == 8) {
            y.f fVarK = cVar.k(cVar2);
            cVar2.i = fVarK;
            cVar.d(fVarK, dVar.f27a0 + i12);
        }
        dVar.f53p = 2;
        dVar.Z = i12;
        int i13 = iK - i12;
        dVar.V = i13;
        int i14 = dVar.f31c0;
        if (i13 < i14) {
            dVar.V = i14;
        }
    }

    public static final boolean c(int i, int i10) {
        return (i & i10) == i10;
    }
}
