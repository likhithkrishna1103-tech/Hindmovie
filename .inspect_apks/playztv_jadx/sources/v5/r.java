package v5;

import android.graphics.Rect;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pb.c f13308a = pb.c.k("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final pb.c f13309b = pb.c.k("id", "layers", "w", "h", "p", "u");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final pb.c f13310c = pb.c.k("list");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final pb.c f13311d = pb.c.k("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0046. Please report as an issue. */
    public static l5.j a(w5.b bVar) throws c6.c, EOFException {
        float f;
        float f4;
        float f10;
        float f11;
        float f12;
        float f13;
        float fC = x5.g.c();
        s.g gVar = new s.g();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        s.j jVar = new s.j();
        l5.j jVar2 = new l5.j();
        bVar.d();
        float fJ = 0.0f;
        int iK = 0;
        int iK2 = 0;
        float fJ2 = 0.0f;
        float fJ3 = 0.0f;
        while (bVar.G()) {
            float f14 = fC;
            switch (bVar.i0(f13308a)) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    iK = bVar.K();
                    fC = f14;
                    break;
                case 1:
                    iK2 = bVar.K();
                    fC = f14;
                    break;
                case 2:
                    f = fJ;
                    fJ2 = (float) bVar.J();
                    fC = f14;
                    fJ = f;
                    break;
                case 3:
                    f = fJ;
                    fJ3 = ((float) bVar.J()) - 0.01f;
                    fC = f14;
                    fJ = f;
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    fJ = (float) bVar.J();
                    fC = f14;
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    f = fJ;
                    f4 = fJ2;
                    f10 = fJ3;
                    String[] strArrSplit = bVar.S().split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    int i10 = Integer.parseInt(strArrSplit[1]);
                    int i11 = Integer.parseInt(strArrSplit[2]);
                    if (i < 4 || (i <= 4 && (i10 < 4 || (i10 <= 4 && i11 < 0)))) {
                        jVar2.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fC = f14;
                    fJ2 = f4;
                    fJ3 = f10;
                    fJ = f;
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    f = fJ;
                    f4 = fJ2;
                    f10 = fJ3;
                    bVar.a();
                    int i12 = 0;
                    while (bVar.G()) {
                        t5.e eVarA = q.a(bVar, jVar2);
                        if (eVarA.f12181e == 3) {
                            i12++;
                        }
                        arrayList.add(eVarA);
                        gVar.h(eVarA.f12180d, eVarA);
                        if (i12 > 4) {
                            x5.b.b("You have " + i12 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    bVar.v();
                    fC = f14;
                    fJ2 = f4;
                    fJ3 = f10;
                    fJ = f;
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    f = fJ;
                    f4 = fJ2;
                    f10 = fJ3;
                    bVar.a();
                    while (bVar.G()) {
                        ArrayList arrayList3 = new ArrayList();
                        s.g gVar2 = new s.g();
                        bVar.d();
                        String strS = null;
                        String strS2 = null;
                        String strS3 = null;
                        int iK3 = 0;
                        int iK4 = 0;
                        while (bVar.G()) {
                            int iI0 = bVar.i0(f13309b);
                            if (iI0 == 0) {
                                strS = bVar.S();
                            } else if (iI0 == 1) {
                                bVar.a();
                                while (bVar.G()) {
                                    t5.e eVarA2 = q.a(bVar, jVar2);
                                    gVar2.h(eVarA2.f12180d, eVarA2);
                                    arrayList3.add(eVarA2);
                                }
                                bVar.v();
                            } else if (iI0 == 2) {
                                iK3 = bVar.K();
                            } else if (iI0 == 3) {
                                iK4 = bVar.K();
                            } else if (iI0 == 4) {
                                strS2 = bVar.S();
                            } else if (iI0 != 5) {
                                bVar.j0();
                                bVar.k0();
                            } else {
                                strS3 = bVar.S();
                            }
                        }
                        bVar.x();
                        if (strS2 != null) {
                            map2.put(strS, new l5.x(iK3, iK4, strS, strS2, strS3));
                        } else {
                            map.put(strS, arrayList3);
                        }
                    }
                    bVar.v();
                    fC = f14;
                    fJ2 = f4;
                    fJ3 = f10;
                    fJ = f;
                    break;
                case 8:
                    f = fJ;
                    f4 = fJ2;
                    float f15 = fJ3;
                    bVar.d();
                    while (bVar.G()) {
                        if (bVar.i0(f13310c) != 0) {
                            bVar.j0();
                            bVar.k0();
                        } else {
                            bVar.a();
                            while (bVar.G()) {
                                pb.c cVar = k.f13294a;
                                bVar.d();
                                String strS4 = null;
                                String strS5 = null;
                                String strS6 = null;
                                while (bVar.G()) {
                                    int iI02 = bVar.i0(k.f13294a);
                                    if (iI02 != 0) {
                                        float f16 = f15;
                                        if (iI02 == 1) {
                                            strS5 = bVar.S();
                                        } else if (iI02 == 2) {
                                            strS6 = bVar.S();
                                        } else if (iI02 != 3) {
                                            bVar.j0();
                                            bVar.k0();
                                        } else {
                                            bVar.J();
                                        }
                                        f15 = f16;
                                    } else {
                                        strS4 = bVar.S();
                                    }
                                }
                                bVar.x();
                                map3.put(strS5, new q5.c(strS4, strS5, strS6));
                                f15 = f15;
                            }
                            bVar.v();
                        }
                    }
                    f10 = f15;
                    bVar.x();
                    fC = f14;
                    fJ2 = f4;
                    fJ3 = f10;
                    fJ = f;
                    break;
                case 9:
                    f = fJ;
                    f4 = fJ2;
                    f11 = fJ3;
                    bVar.a();
                    while (bVar.G()) {
                        pb.c cVar2 = j.f13292a;
                        ArrayList arrayList4 = new ArrayList();
                        bVar.d();
                        double dJ = 0.0d;
                        String strS7 = null;
                        String strS8 = null;
                        char cCharAt = 0;
                        while (bVar.G()) {
                            int iI03 = bVar.i0(j.f13292a);
                            if (iI03 == 0) {
                                cCharAt = bVar.S().charAt(0);
                            } else if (iI03 == 1) {
                                bVar.J();
                            } else if (iI03 == 2) {
                                dJ = bVar.J();
                            } else if (iI03 == 3) {
                                strS7 = bVar.S();
                            } else if (iI03 == 4) {
                                strS8 = bVar.S();
                            } else if (iI03 != 5) {
                                bVar.j0();
                                bVar.k0();
                            } else {
                                bVar.d();
                                while (bVar.G()) {
                                    if (bVar.i0(j.f13293b) != 0) {
                                        bVar.j0();
                                        bVar.k0();
                                    } else {
                                        bVar.a();
                                        while (bVar.G()) {
                                            arrayList4.add((s5.m) g.a(bVar, jVar2));
                                        }
                                        bVar.v();
                                    }
                                }
                                bVar.x();
                            }
                        }
                        bVar.x();
                        q5.d dVar = new q5.d(arrayList4, cCharAt, dJ, strS7, strS8);
                        jVar.d(dVar.hashCode(), dVar);
                    }
                    bVar.v();
                    f10 = f11;
                    fC = f14;
                    fJ2 = f4;
                    fJ3 = f10;
                    fJ = f;
                    break;
                case 10:
                    bVar.a();
                    while (bVar.G()) {
                        bVar.d();
                        String strS9 = null;
                        float fJ4 = 0.0f;
                        float fJ5 = 0.0f;
                        while (bVar.G()) {
                            int iI04 = bVar.i0(f13311d);
                            if (iI04 != 0) {
                                f12 = fJ;
                                if (iI04 == 1) {
                                    f13 = fJ2;
                                    fJ3 = fJ3;
                                    fJ4 = (float) bVar.J();
                                } else if (iI04 != 2) {
                                    bVar.j0();
                                    bVar.k0();
                                } else {
                                    f13 = fJ2;
                                    fJ3 = fJ3;
                                    fJ5 = (float) bVar.J();
                                }
                                fJ = f12;
                                fJ2 = f13;
                            } else {
                                f12 = fJ;
                                strS9 = bVar.S();
                            }
                            fJ = f12;
                        }
                        bVar.x();
                        arrayList2.add(new q5.h(strS9, fJ4, fJ5));
                        fJ3 = fJ3;
                        fJ2 = fJ2;
                        fJ = fJ;
                    }
                    f = fJ;
                    f4 = fJ2;
                    f11 = fJ3;
                    bVar.v();
                    f10 = f11;
                    fC = f14;
                    fJ2 = f4;
                    fJ3 = f10;
                    fJ = f;
                    break;
                default:
                    bVar.j0();
                    bVar.k0();
                    f = fJ;
                    f4 = fJ2;
                    f10 = fJ3;
                    fC = f14;
                    fJ2 = f4;
                    fJ3 = f10;
                    fJ = f;
                    break;
            }
        }
        float f17 = fC;
        float f18 = fJ;
        Rect rect = new Rect(0, 0, (int) (iK * f17), (int) (iK2 * f17));
        float fC2 = x5.g.c();
        jVar2.f7865k = rect;
        jVar2.f7866l = fJ2;
        jVar2.f7867m = fJ3;
        jVar2.f7868n = f18;
        jVar2.f7864j = arrayList;
        jVar2.i = gVar;
        jVar2.f7859c = map;
        jVar2.f7860d = map2;
        jVar2.f7861e = fC2;
        jVar2.f7863h = jVar;
        jVar2.f = map3;
        jVar2.f7862g = arrayList2;
        return jVar2;
    }
}
