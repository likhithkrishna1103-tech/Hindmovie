package w2;

import aa.j0;
import java.util.Collections;
import java.util.List;
import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13686e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13688h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13690k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f13691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f13692m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f13693n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ub.o f13694o;

    public x(List list, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f, int i19, String str, ub.o oVar) {
        this.f13682a = list;
        this.f13683b = i;
        this.f13684c = i10;
        this.f13685d = i11;
        this.f13686e = i12;
        this.f = i13;
        this.f13687g = i14;
        this.f13688h = i15;
        this.i = i16;
        this.f13689j = i17;
        this.f13690k = i18;
        this.f13691l = f;
        this.f13692m = i19;
        this.f13693n = str;
        this.f13694o = oVar;
    }

    public static x a(s1.u uVar, boolean z2, ub.o oVar) {
        boolean z10;
        b8.l lVarG;
        int i;
        int i10 = 4;
        try {
            if (z2) {
                uVar.K(4);
            } else {
                uVar.K(21);
            }
            int iX = uVar.x() & 3;
            int iX2 = uVar.x();
            int i11 = uVar.f11710b;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                z10 = true;
                if (i13 >= iX2) {
                    break;
                }
                uVar.K(1);
                int iD = uVar.D();
                for (int i15 = 0; i15 < iD; i15++) {
                    int iD2 = uVar.D();
                    i14 += iD2 + 4;
                    uVar.K(iD2);
                }
                i13++;
            }
            uVar.J(i11);
            byte[] bArr = new byte[i14];
            ub.o oVar2 = oVar;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i20 = -1;
            int i21 = -1;
            int i22 = -1;
            int i23 = -1;
            int i24 = -1;
            int i25 = -1;
            float f = 1.0f;
            String strA = null;
            int i26 = 0;
            int i27 = 0;
            while (i26 < iX2) {
                int iX3 = uVar.x() & 63;
                int iD3 = uVar.D();
                int i28 = i12;
                ub.o oVarI = oVar2;
                while (i28 < iD3) {
                    boolean z11 = z10;
                    int iD4 = uVar.D();
                    int i29 = iX;
                    System.arraycopy(t1.p.f12057a, i12, bArr, i27, i10);
                    int i30 = i27 + 4;
                    System.arraycopy(uVar.f11709a, uVar.f11710b, bArr, i30, iD4);
                    if (iX3 == 32 && i28 == 0) {
                        oVarI = t1.p.i(bArr, i30, i30 + iD4);
                    } else {
                        if (iX3 == 33 && i28 == 0) {
                            t1.l lVarH = t1.p.h(bArr, i30, i30 + iD4, oVarI);
                            i16 = lVarH.f12024a + 1;
                            i17 = lVarH.f12029g;
                            int i31 = lVarH.f12030h;
                            i19 = lVarH.f12026c + 8;
                            i20 = lVarH.f12027d + 8;
                            int i32 = lVarH.f12032k;
                            i18 = i31;
                            int i33 = lVarH.f12033l;
                            int i34 = lVarH.f12034m;
                            float f4 = lVarH.i;
                            int i35 = lVarH.f12031j;
                            t1.i iVar = lVarH.f12025b;
                            if (iVar != null) {
                                i = i35;
                                strA = s1.e.a(iVar.f12012a, iVar.f12013b, iVar.f12014c, iVar.f12015d, iVar.f12016e, iVar.f);
                            } else {
                                i = i35;
                            }
                            i25 = i;
                            f = f4;
                            i23 = i34;
                            i22 = i33;
                            i21 = i32;
                        } else if (iX3 == 39 && i28 == 0 && (lVarG = t1.p.g(bArr, i30, i30 + iD4)) != null && oVarI != null) {
                            i12 = 0;
                            i24 = lVarG.f1942u == ((t1.h) ((j0) oVarI.f12868v).get(0)).f12011b ? 4 : 5;
                        }
                        i12 = 0;
                    }
                    i27 = i30 + iD4;
                    uVar.K(iD4);
                    i28++;
                    z10 = z11;
                    iX = i29;
                    i10 = 4;
                }
                i26++;
                oVar2 = oVarI;
                i10 = 4;
            }
            return new x(i14 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), iX + 1, i16, i17, i18, i19, i20, i21, i22, i23, i24, f, i25, strA, oVar2);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw n0.a(e10, "Error parsing".concat(z2 ? "L-HEVC config" : "HEVC config"));
        }
    }
}
