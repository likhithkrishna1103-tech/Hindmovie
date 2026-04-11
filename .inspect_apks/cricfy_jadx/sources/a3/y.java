package a3;

import java.util.Collections;
import java.util.List;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f249e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f251h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f255m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f256n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b6.f f257o;

    public y(List list, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f, int i19, String str, b6.f fVar) {
        this.f245a = list;
        this.f246b = i;
        this.f247c = i10;
        this.f248d = i11;
        this.f249e = i12;
        this.f = i13;
        this.f250g = i14;
        this.f251h = i15;
        this.i = i16;
        this.f252j = i17;
        this.f253k = i18;
        this.f254l = f;
        this.f255m = i19;
        this.f256n = str;
        this.f257o = fVar;
    }

    public static y a(y1.t tVar, boolean z10, b6.f fVar) {
        boolean z11;
        q6.l lVarG;
        int i;
        int i10 = 4;
        try {
            if (z10) {
                tVar.K(4);
            } else {
                tVar.K(21);
            }
            int iX = tVar.x() & 3;
            int iX2 = tVar.x();
            int i11 = tVar.f14610b;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                z11 = true;
                if (i13 >= iX2) {
                    break;
                }
                tVar.K(1);
                int iD = tVar.D();
                for (int i15 = 0; i15 < iD; i15++) {
                    int iD2 = tVar.D();
                    i14 += iD2 + 4;
                    tVar.K(iD2);
                }
                i13++;
            }
            tVar.J(i11);
            byte[] bArr = new byte[i14];
            b6.f fVar2 = fVar;
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
                int iX3 = tVar.x() & 63;
                int iD3 = tVar.D();
                int i28 = i12;
                b6.f fVarI = fVar2;
                while (i28 < iD3) {
                    boolean z12 = z11;
                    int iD4 = tVar.D();
                    int i29 = iX;
                    System.arraycopy(z1.o.f15122a, i12, bArr, i27, i10);
                    int i30 = i27 + 4;
                    System.arraycopy(tVar.f14609a, tVar.f14610b, bArr, i30, iD4);
                    if (iX3 == 32 && i28 == 0) {
                        fVarI = z1.o.i(bArr, i30, i30 + iD4);
                    } else {
                        if (iX3 == 33 && i28 == 0) {
                            z1.k kVarH = z1.o.h(bArr, i30, i30 + iD4, fVarI);
                            i16 = kVarH.f15089a + 1;
                            i17 = kVarH.f15094g;
                            int i31 = kVarH.f15095h;
                            i19 = kVarH.f15091c + 8;
                            i20 = kVarH.f15092d + 8;
                            int i32 = kVarH.f15097k;
                            i18 = i31;
                            int i33 = kVarH.f15098l;
                            int i34 = kVarH.f15099m;
                            float f10 = kVarH.i;
                            int i35 = kVarH.f15096j;
                            z1.h hVar = kVarH.f15090b;
                            if (hVar != null) {
                                i = i35;
                                strA = y1.e.a(hVar.f15077a, hVar.f15078b, hVar.f15079c, hVar.f15080d, hVar.f15081e, hVar.f);
                            } else {
                                i = i35;
                            }
                            i25 = i;
                            f = f10;
                            i23 = i34;
                            i22 = i33;
                            i21 = i32;
                        } else if (iX3 == 39 && i28 == 0 && (lVarG = z1.o.g(bArr, i30, i30 + iD4)) != null && fVarI != null) {
                            i12 = 0;
                            i24 = lVarG.f10418v == ((z1.g) ((ua.i0) fVarI.f1800w).get(0)).f15076b ? 4 : 5;
                        }
                        i12 = 0;
                    }
                    i27 = i30 + iD4;
                    tVar.K(iD4);
                    i28++;
                    z11 = z12;
                    iX = i29;
                    i10 = 4;
                }
                i26++;
                fVar2 = fVarI;
                i10 = 4;
            }
            return new y(i14 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), iX + 1, i16, i17, i18, i19, i20, i21, i22, i23, i24, f, i25, strA, fVar2);
        } catch (ArrayIndexOutOfBoundsException e9) {
            throw n0.a(e9, "Error parsing".concat(z10 ? "L-HEVC config" : "HEVC config"));
        }
    }
}
