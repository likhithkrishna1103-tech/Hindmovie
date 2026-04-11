package q6;

import android.graphics.Rect;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nb.w f10433a = nb.w.I("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final nb.w f10434b = nb.w.I("id", "layers", "w", "h", "p", "u");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final nb.w f10435c = nb.w.I("list");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final nb.w f10436d = nb.w.I("cm", "tm", "dr");

    public static g6.i a(r6.b bVar) throws a2.a, EOFException {
        float f;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float fC = s6.i.c();
        v.h hVar = new v.h();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        v.l lVar = new v.l();
        g6.i iVar = new g6.i();
        bVar.g();
        float fJ = 0.0f;
        int iJ = 0;
        int iJ2 = 0;
        float fJ2 = 0.0f;
        float fJ3 = 0.0f;
        while (bVar.A()) {
            float f15 = fC;
            switch (bVar.g0(f10433a)) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    f = fJ;
                    iJ = (int) bVar.J();
                    fC = f15;
                    fJ = f;
                    break;
                case 1:
                    f = fJ;
                    iJ2 = (int) bVar.J();
                    fC = f15;
                    fJ = f;
                    break;
                case 2:
                    f = fJ;
                    fJ2 = (float) bVar.J();
                    fC = f15;
                    fJ = f;
                    break;
                case 3:
                    f = fJ;
                    fJ3 = ((float) bVar.J()) - 0.01f;
                    fC = f15;
                    fJ = f;
                    break;
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    fJ = (float) bVar.J();
                    fC = f15;
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    f = fJ;
                    f10 = fJ2;
                    f11 = fJ3;
                    String[] strArrSplit = bVar.Q().split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    int i10 = Integer.parseInt(strArrSplit[1]);
                    int i11 = Integer.parseInt(strArrSplit[2]);
                    if (i < 4 || (i <= 4 && (i10 < 4 || (i10 <= 4 && i11 < 0)))) {
                        iVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fC = f15;
                    fJ2 = f10;
                    fJ3 = f11;
                    fJ = f;
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    f = fJ;
                    f10 = fJ2;
                    f11 = fJ3;
                    bVar.a();
                    int i12 = 0;
                    while (bVar.A()) {
                        o6.d dVarA = r.a(bVar, iVar);
                        if (dVarA.f9536e == 3) {
                            i12++;
                        }
                        arrayList.add(dVarA);
                        hVar.h(dVarA.f9535d, dVarA);
                        if (i12 > 4) {
                            s6.c.b("You have " + i12 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    bVar.q();
                    fC = f15;
                    fJ2 = f10;
                    fJ3 = f11;
                    fJ = f;
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    f = fJ;
                    f10 = fJ2;
                    f11 = fJ3;
                    bVar.a();
                    while (bVar.A()) {
                        ArrayList arrayList3 = new ArrayList();
                        v.h hVar2 = new v.h();
                        bVar.g();
                        String strQ = null;
                        String strQ2 = null;
                        String strQ3 = null;
                        int iO = 0;
                        int iO2 = 0;
                        while (bVar.A()) {
                            int iG0 = bVar.g0(f10434b);
                            if (iG0 == 0) {
                                strQ = bVar.Q();
                            } else if (iG0 == 1) {
                                bVar.a();
                                while (bVar.A()) {
                                    o6.d dVarA2 = r.a(bVar, iVar);
                                    hVar2.h(dVarA2.f9535d, dVarA2);
                                    arrayList3.add(dVarA2);
                                }
                                bVar.q();
                            } else if (iG0 == 2) {
                                iO = bVar.O();
                            } else if (iG0 == 3) {
                                iO2 = bVar.O();
                            } else if (iG0 == 4) {
                                strQ2 = bVar.Q();
                            } else if (iG0 != 5) {
                                bVar.h0();
                                bVar.i0();
                            } else {
                                strQ3 = bVar.Q();
                            }
                        }
                        bVar.s();
                        if (strQ2 != null) {
                            map2.put(strQ, new g6.y(iO, iO2, strQ, strQ2, strQ3));
                        } else {
                            map.put(strQ, arrayList3);
                        }
                    }
                    bVar.q();
                    fC = f15;
                    fJ2 = f10;
                    fJ3 = f11;
                    fJ = f;
                    break;
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                    f = fJ;
                    f10 = fJ2;
                    float f16 = fJ3;
                    bVar.g();
                    while (bVar.A()) {
                        if (bVar.g0(f10435c) != 0) {
                            bVar.h0();
                            bVar.i0();
                        } else {
                            bVar.a();
                            while (bVar.A()) {
                                nb.w wVar = k.f10417a;
                                bVar.g();
                                String strQ4 = null;
                                String strQ5 = null;
                                String strQ6 = null;
                                while (bVar.A()) {
                                    int iG02 = bVar.g0(k.f10417a);
                                    if (iG02 != 0) {
                                        float f17 = f16;
                                        if (iG02 == 1) {
                                            strQ5 = bVar.Q();
                                        } else if (iG02 == 2) {
                                            strQ6 = bVar.Q();
                                        } else if (iG02 != 3) {
                                            bVar.h0();
                                            bVar.i0();
                                        } else {
                                            bVar.J();
                                        }
                                        f16 = f17;
                                    } else {
                                        strQ4 = bVar.Q();
                                    }
                                }
                                bVar.s();
                                map3.put(strQ5, new l6.c(strQ4, strQ5, strQ6));
                                f16 = f16;
                            }
                            bVar.q();
                        }
                    }
                    f11 = f16;
                    bVar.s();
                    fC = f15;
                    fJ2 = f10;
                    fJ3 = f11;
                    fJ = f;
                    break;
                case 9:
                    f = fJ;
                    f10 = fJ2;
                    f12 = fJ3;
                    bVar.a();
                    while (bVar.A()) {
                        nb.w wVar2 = j.f10415a;
                        ArrayList arrayList4 = new ArrayList();
                        bVar.g();
                        double dJ = 0.0d;
                        String strQ7 = null;
                        String strQ8 = null;
                        char cCharAt = 0;
                        while (bVar.A()) {
                            int iG03 = bVar.g0(j.f10415a);
                            if (iG03 == 0) {
                                cCharAt = bVar.Q().charAt(0);
                            } else if (iG03 == 1) {
                                bVar.J();
                            } else if (iG03 == 2) {
                                dJ = bVar.J();
                            } else if (iG03 == 3) {
                                strQ7 = bVar.Q();
                            } else if (iG03 == 4) {
                                strQ8 = bVar.Q();
                            } else if (iG03 != 5) {
                                bVar.h0();
                                bVar.i0();
                            } else {
                                bVar.g();
                                while (bVar.A()) {
                                    if (bVar.g0(j.f10416b) != 0) {
                                        bVar.h0();
                                        bVar.i0();
                                    } else {
                                        bVar.a();
                                        while (bVar.A()) {
                                            arrayList4.add((n6.m) g.a(bVar, iVar));
                                        }
                                        bVar.q();
                                    }
                                }
                                bVar.s();
                            }
                        }
                        bVar.s();
                        l6.d dVar = new l6.d(arrayList4, cCharAt, dJ, strQ7, strQ8);
                        lVar.d(dVar.hashCode(), dVar);
                    }
                    bVar.q();
                    f11 = f12;
                    fC = f15;
                    fJ2 = f10;
                    fJ3 = f11;
                    fJ = f;
                    break;
                case 10:
                    bVar.a();
                    while (bVar.A()) {
                        bVar.g();
                        String strQ9 = null;
                        float fJ4 = 0.0f;
                        float fJ5 = 0.0f;
                        while (bVar.A()) {
                            int iG04 = bVar.g0(f10436d);
                            if (iG04 != 0) {
                                f13 = fJ;
                                if (iG04 == 1) {
                                    f14 = fJ2;
                                    fJ3 = fJ3;
                                    fJ4 = (float) bVar.J();
                                } else if (iG04 != 2) {
                                    bVar.h0();
                                    bVar.i0();
                                } else {
                                    f14 = fJ2;
                                    fJ3 = fJ3;
                                    fJ5 = (float) bVar.J();
                                }
                                fJ = f13;
                                fJ2 = f14;
                            } else {
                                f13 = fJ;
                                strQ9 = bVar.Q();
                            }
                            fJ = f13;
                        }
                        bVar.s();
                        arrayList2.add(new l6.h(strQ9, fJ4, fJ5));
                        fJ3 = fJ3;
                        fJ2 = fJ2;
                        fJ = fJ;
                    }
                    f = fJ;
                    f10 = fJ2;
                    f12 = fJ3;
                    bVar.q();
                    f11 = f12;
                    fC = f15;
                    fJ2 = f10;
                    fJ3 = f11;
                    fJ = f;
                    break;
                default:
                    bVar.h0();
                    bVar.i0();
                    f = fJ;
                    f10 = fJ2;
                    f11 = fJ3;
                    fC = f15;
                    fJ2 = f10;
                    fJ3 = f11;
                    fJ = f;
                    break;
            }
        }
        float f18 = fC;
        float f19 = fJ;
        Rect rect = new Rect(0, 0, (int) (iJ * f18), (int) (iJ2 * f18));
        float fC2 = s6.i.c();
        iVar.f5094k = rect;
        iVar.f5095l = fJ2;
        iVar.f5096m = fJ3;
        iVar.f5097n = f19;
        iVar.f5093j = arrayList;
        iVar.i = hVar;
        iVar.f5088c = map;
        iVar.f5089d = map2;
        iVar.f5090e = fC2;
        iVar.f5092h = lVar;
        iVar.f = map3;
        iVar.f5091g = arrayList2;
        return iVar;
    }
}
