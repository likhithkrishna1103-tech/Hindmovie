package i0;

import android.graphics.Path;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char f6166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f6167b;

    public f(char c9, float[] fArr) {
        this.f6166a = c9;
        this.f6167b = fArr;
    }

    public static void a(Path path, float f, float f4, float f10, float f11, float f12, float f13, float f14, boolean z2, boolean z10) {
        double d10;
        double d11;
        double radians = Math.toRadians(f14);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d12 = f;
        double d13 = f4;
        double d14 = f12;
        double d15 = ((d13 * dSin) + (d12 * dCos)) / d14;
        double d16 = f13;
        double d17 = ((d13 * dCos) + (((double) (-f)) * dSin)) / d16;
        double d18 = f11;
        double d19 = ((d18 * dSin) + (((double) f10) * dCos)) / d14;
        double d20 = ((d18 * dCos) + (((double) (-f10)) * dSin)) / d16;
        double d21 = d15 - d19;
        double d22 = d17 - d20;
        double d23 = (d15 + d19) / 2.0d;
        double d24 = (d17 + d20) / 2.0d;
        double d25 = (d22 * d22) + (d21 * d21);
        if (d25 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d26 = (1.0d / d25) - 0.25d;
        if (d26 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d25);
            float fSqrt = (float) (Math.sqrt(d25) / 1.99999d);
            a(path, f, f4, f10, f11, f12 * fSqrt, fSqrt * f13, f14, z2, z10);
            return;
        }
        double dSqrt = Math.sqrt(d26);
        double d27 = dSqrt * d21;
        double d28 = dSqrt * d22;
        if (z2 == z10) {
            d10 = d23 - d28;
            d11 = d24 + d27;
        } else {
            d10 = d23 + d28;
            d11 = d24 - d27;
        }
        double dAtan2 = Math.atan2(d17 - d11, d15 - d10);
        double dAtan22 = Math.atan2(d20 - d11, d19 - d10) - dAtan2;
        if (z10 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d29 = d10 * d14;
        double d30 = d11 * d16;
        double d31 = (d29 * dCos) - (d30 * dSin);
        double d32 = (d30 * dCos) + (d29 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d33 = -d14;
        double d34 = d33 * dCos2;
        double d35 = d16 * dSin2;
        double d36 = (d34 * dSin3) - (d35 * dCos3);
        double d37 = d33 * dSin2;
        double d38 = d16 * dCos2;
        double d39 = dAtan22 / ((double) iCeil);
        double d40 = (dCos3 * d38) + (dSin3 * d37);
        double d41 = d12;
        double d42 = d13;
        int i = 0;
        double d43 = dAtan2;
        while (i < iCeil) {
            double d44 = d43 + d39;
            double dSin4 = Math.sin(d44);
            double dCos4 = Math.cos(d44);
            int i10 = iCeil;
            double d45 = (((d14 * dCos2) * dCos4) + d31) - (d35 * dSin4);
            double d46 = (d38 * dSin4) + (d14 * dSin2 * dCos4) + d32;
            double d47 = (d34 * dSin4) - (d35 * dCos4);
            double d48 = (dCos4 * d38) + (dSin4 * d37);
            double d49 = d44 - d43;
            double dTan = Math.tan(d49 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d49)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d36 * dSqrt2) + d41), (float) ((d40 * dSqrt2) + d42), (float) (d45 - (dSqrt2 * d47)), (float) (d46 - (dSqrt2 * d48)), (float) d45, (float) d46);
            i++;
            d42 = d46;
            dCos2 = dCos2;
            d37 = d37;
            d43 = d44;
            d40 = d48;
            d41 = d45;
            iCeil = i10;
            d36 = d47;
            d39 = d39;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(f[] fVarArr, Path path) {
        int i;
        float[] fArr;
        int i10;
        f fVar;
        int i11;
        char c9;
        float f;
        float f4;
        f fVar2;
        boolean z2;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        f[] fVarArr2 = fVarArr;
        Path path2 = path;
        float[] fArr2 = new float[6];
        int length = fVarArr2.length;
        int i12 = 0;
        int i13 = 0;
        char c10 = 'm';
        while (i13 < length) {
            f fVar3 = fVarArr2[i13];
            char c11 = fVar3.f6166a;
            float[] fArr3 = fVar3.f6167b;
            float f18 = fArr2[i12];
            float f19 = fArr2[1];
            float f20 = fArr2[2];
            float f21 = fArr2[3];
            float f22 = fArr2[4];
            int i14 = i12;
            float f23 = fArr2[5];
            switch (c11) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                default:
                    i = 2;
                    break;
            }
            float f24 = f22;
            float f25 = f23;
            float f26 = f18;
            float f27 = f19;
            int i15 = i14;
            while (i15 < fArr3.length) {
                if (c11 == 'A') {
                    fArr = fArr3;
                    i10 = i15;
                    fVar = fVar3;
                    float f28 = f26;
                    float f29 = f27;
                    i11 = i13;
                    c9 = c11;
                    int i16 = i10 + 5;
                    int i17 = i10 + 6;
                    a(path, f28, f29, fArr[i16], fArr[i17], fArr[i10], fArr[i10 + 1], fArr[i10 + 2], fArr[i10 + 3] != 0.0f ? 1 : i14, fArr[i10 + 4] != 0.0f ? 1 : i14);
                    f20 = fArr[i16];
                    f = fArr[i17];
                    f21 = f;
                    f4 = f20;
                } else if (c11 == 'C') {
                    fArr = fArr3;
                    i10 = i15;
                    i11 = i13;
                    fVar = fVar3;
                    c9 = c11;
                    int i18 = i10 + 2;
                    int i19 = i10 + 3;
                    int i20 = i10 + 4;
                    int i21 = i10 + 5;
                    path2.cubicTo(fArr[i10], fArr[i10 + 1], fArr[i18], fArr[i19], fArr[i20], fArr[i21]);
                    float f30 = fArr[i20];
                    float f31 = fArr[i21];
                    f20 = fArr[i18];
                    f21 = fArr[i19];
                    f = f31;
                    f4 = f30;
                } else if (c11 == 'H') {
                    fArr = fArr3;
                    i10 = i15;
                    fVar = fVar3;
                    c9 = c11;
                    f = f27;
                    i11 = i13;
                    path2.lineTo(fArr[i10], f);
                    f4 = fArr[i10];
                } else if (c11 == 'Q') {
                    fArr = fArr3;
                    i10 = i15;
                    i11 = i13;
                    fVar = fVar3;
                    c9 = c11;
                    int i22 = i10 + 1;
                    int i23 = i10 + 2;
                    int i24 = i10 + 3;
                    path2.quadTo(fArr[i10], fArr[i22], fArr[i23], fArr[i24]);
                    float f32 = fArr[i10];
                    float f33 = fArr[i22];
                    float f34 = fArr[i23];
                    float f35 = fArr[i24];
                    f20 = f32;
                    f21 = f33;
                    f4 = f34;
                    f = f35;
                } else if (c11 == 'V') {
                    fArr = fArr3;
                    i10 = i15;
                    i11 = i13;
                    fVar = fVar3;
                    f4 = f26;
                    c9 = c11;
                    path2.lineTo(f4, fArr[i10]);
                    f = fArr[i10];
                } else if (c11 != 'a') {
                    if (c11 == 'c') {
                        fArr = fArr3;
                        i10 = i15;
                        int i25 = i10 + 2;
                        int i26 = i10 + 3;
                        int i27 = i10 + 4;
                        int i28 = i10 + 5;
                        path2.rCubicTo(fArr[i10], fArr[i10 + 1], fArr[i25], fArr[i26], fArr[i27], fArr[i28]);
                        float f36 = fArr[i25] + f26;
                        float f37 = fArr[i26] + f27;
                        f26 += fArr[i27];
                        f27 += fArr[i28];
                        f20 = f36;
                        f21 = f37;
                    } else if (c11 != 'h') {
                        if (c11 != 'q') {
                            if (c11 != 'v') {
                                if (c11 == 'L') {
                                    fArr = fArr3;
                                    i10 = i15;
                                    int i29 = i10 + 1;
                                    path2.lineTo(fArr[i10], fArr[i29]);
                                    f4 = fArr[i10];
                                    f = fArr[i29];
                                } else if (c11 == 'M') {
                                    fArr = fArr3;
                                    i10 = i15;
                                    f4 = fArr[i10];
                                    f = fArr[i10 + 1];
                                    if (i10 > 0) {
                                        path2.lineTo(f4, f);
                                    } else {
                                        path2.moveTo(f4, f);
                                        f24 = f4;
                                        f25 = f;
                                    }
                                } else if (c11 != 'S') {
                                    if (c11 == 'T') {
                                        fArr = fArr3;
                                        i10 = i15;
                                        if (c10 == 'q' || c10 == 't' || c10 == 'Q' || c10 == 'T') {
                                            f26 = (f26 * 2.0f) - f20;
                                            f27 = (f27 * 2.0f) - f21;
                                        }
                                        int i30 = i10 + 1;
                                        path2.quadTo(f26, f27, fArr[i10], fArr[i30]);
                                        f4 = fArr[i10];
                                        f = fArr[i30];
                                        fVar = fVar3;
                                        f20 = f26;
                                        f21 = f27;
                                    } else if (c11 == 'l') {
                                        fArr = fArr3;
                                        i10 = i15;
                                        int i31 = i10 + 1;
                                        path2.rLineTo(fArr[i10], fArr[i31]);
                                        f26 += fArr[i10];
                                        f13 = fArr[i31];
                                    } else if (c11 == 'm') {
                                        fArr = fArr3;
                                        i10 = i15;
                                        float f38 = fArr[i10];
                                        f26 += f38;
                                        float f39 = fArr[i10 + 1];
                                        f27 += f39;
                                        if (i10 > 0) {
                                            path2.rLineTo(f38, f39);
                                        } else {
                                            path2.rMoveTo(f38, f39);
                                            fVar = fVar3;
                                            f4 = f26;
                                            f24 = f4;
                                            f = f27;
                                            f25 = f;
                                        }
                                    } else if (c11 != 's') {
                                        if (c11 != 't') {
                                            fArr = fArr3;
                                            i10 = i15;
                                            fVar = fVar3;
                                            f4 = f26;
                                        } else {
                                            if (c10 == 'q' || c10 == 't' || c10 == 'Q' || c10 == 'T') {
                                                f16 = f26 - f20;
                                                f17 = f27 - f21;
                                            } else {
                                                f17 = 0.0f;
                                                f16 = 0.0f;
                                            }
                                            int i32 = i15 + 1;
                                            path2.rQuadTo(f16, f17, fArr3[i15], fArr3[i32]);
                                            float f40 = f16 + f26;
                                            float f41 = f17 + f27;
                                            float f42 = f26 + fArr3[i15];
                                            f27 += fArr3[i32];
                                            f21 = f41;
                                            fArr = fArr3;
                                            i10 = i15;
                                            fVar = fVar3;
                                            f4 = f42;
                                            f20 = f40;
                                        }
                                        f = f27;
                                    } else {
                                        if (c10 == 'c' || c10 == 's' || c10 == 'C' || c10 == 'S') {
                                            f14 = f27 - f21;
                                            f15 = f26 - f20;
                                        } else {
                                            f15 = 0.0f;
                                            f14 = 0.0f;
                                        }
                                        int i33 = i15;
                                        int i34 = i33 + 1;
                                        int i35 = i33 + 2;
                                        int i36 = i33 + 3;
                                        fArr = fArr3;
                                        i10 = i33;
                                        path2.rCubicTo(f15, f14, fArr3[i33], fArr3[i34], fArr3[i35], fArr3[i36]);
                                        f10 = fArr[i10] + f26;
                                        f11 = fArr[i34] + f27;
                                        f26 += fArr[i35];
                                        f12 = fArr[i36];
                                    }
                                    i11 = i13;
                                    c9 = c11;
                                } else {
                                    fArr = fArr3;
                                    i10 = i15;
                                    if (c10 == 'c' || c10 == 's' || c10 == 'C' || c10 == 'S') {
                                        f26 = (f26 * 2.0f) - f20;
                                        f27 = (f27 * 2.0f) - f21;
                                    }
                                    float f43 = f26;
                                    float f44 = f27;
                                    int i37 = i10 + 1;
                                    int i38 = i10 + 2;
                                    int i39 = i10 + 3;
                                    path2.cubicTo(f43, f44, fArr[i10], fArr[i37], fArr[i38], fArr[i39]);
                                    f20 = fArr[i10];
                                    f21 = fArr[i37];
                                    f4 = fArr[i38];
                                    f = fArr[i39];
                                }
                                i11 = i13;
                                fVar = fVar3;
                                c9 = c11;
                            } else {
                                fArr = fArr3;
                                i10 = i15;
                                path2.rLineTo(0.0f, fArr[i10]);
                                f13 = fArr[i10];
                            }
                            f27 += f13;
                        } else {
                            fArr = fArr3;
                            i10 = i15;
                            int i40 = i10 + 1;
                            int i41 = i10 + 2;
                            int i42 = i10 + 3;
                            path2.rQuadTo(fArr[i10], fArr[i40], fArr[i41], fArr[i42]);
                            f10 = fArr[i10] + f26;
                            f11 = fArr[i40] + f27;
                            f26 += fArr[i41];
                            f12 = fArr[i42];
                        }
                        f27 += f12;
                        f20 = f10;
                        f21 = f11;
                    } else {
                        fArr = fArr3;
                        i10 = i15;
                        path2.rLineTo(fArr[i10], 0.0f);
                        f26 += fArr[i10];
                    }
                    fVar = fVar3;
                    f4 = f26;
                    f = f27;
                    i11 = i13;
                    c9 = c11;
                } else {
                    fArr = fArr3;
                    i10 = i15;
                    int i43 = i10 + 5;
                    float f45 = fArr[i43] + f26;
                    int i44 = i10 + 6;
                    float f46 = fArr[i44] + f27;
                    float f47 = fArr[i10];
                    float f48 = fArr[i10 + 1];
                    float f49 = fArr[i10 + 2];
                    if (fArr[i10 + 3] != 0.0f) {
                        fVar2 = fVar3;
                        z2 = 1;
                    } else {
                        fVar2 = fVar3;
                        z2 = i14;
                    }
                    fVar = fVar2;
                    float f50 = f26;
                    c9 = c11;
                    float f51 = f27;
                    i11 = i13;
                    a(path, f50, f51, f45, f46, f47, f48, f49, z2, fArr[i10 + 4] != 0.0f ? 1 : i14);
                    f4 = f50 + fArr[i43];
                    f = f51 + fArr[i44];
                    f20 = f4;
                    f21 = f;
                }
                i15 = i10 + i;
                path2 = path;
                fVar3 = fVar;
                c11 = c9;
                i13 = i11;
                f26 = f4;
                f27 = f;
                c10 = c11;
                fArr3 = fArr;
            }
            fArr2[i14] = f26;
            fArr2[1] = f27;
            fArr2[2] = f20;
            fArr2[3] = f21;
            fArr2[4] = f24;
            fArr2[5] = f25;
            c10 = fVar3.f6166a;
            i13++;
            fVarArr2 = fVarArr;
            path2 = path;
            i12 = i14;
        }
    }

    public f(f fVar) {
        this.f6166a = fVar.f6166a;
        float[] fArr = fVar.f6167b;
        this.f6167b = ga.b.g(fArr, fArr.length);
    }
}
