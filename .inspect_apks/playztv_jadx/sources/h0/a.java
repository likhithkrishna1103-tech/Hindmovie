package h0;

import android.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f5572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f5573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f5574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f5575e;
    public final float f;

    public a(float f, float f4, float f10, float f11, float f12, float f13) {
        this.f5571a = f;
        this.f5572b = f4;
        this.f5573c = f10;
        this.f5574d = f11;
        this.f5575e = f12;
        this.f = f13;
    }

    public static a a(int i) {
        l lVar = l.f5602k;
        float f = b.f(Color.red(i));
        float f4 = b.f(Color.green(i));
        float f10 = b.f(Color.blue(i));
        float[][] fArr = b.f5579d;
        float[] fArr2 = fArr[0];
        float f11 = (fArr2[2] * f10) + (fArr2[1] * f4) + (fArr2[0] * f);
        float[] fArr3 = fArr[1];
        float f12 = (fArr3[2] * f10) + (fArr3[1] * f4) + (fArr3[0] * f);
        float[] fArr4 = fArr[2];
        float f13 = (f10 * fArr4[2]) + (f4 * fArr4[1]) + (f * fArr4[0]);
        float[][] fArr5 = b.f5576a;
        float[] fArr6 = fArr5[0];
        float f14 = (fArr6[2] * f13) + (fArr6[1] * f12) + (fArr6[0] * f11);
        float[] fArr7 = fArr5[1];
        float f15 = (fArr7[2] * f13) + (fArr7[1] * f12) + (fArr7[0] * f11);
        float[] fArr8 = fArr5[2];
        float f16 = (f13 * fArr8[2]) + (f12 * fArr8[1]) + (f11 * fArr8[0]);
        float[] fArr9 = lVar.f5608g;
        float f17 = lVar.i;
        float f18 = lVar.f5606d;
        float f19 = lVar.f5603a;
        float f20 = fArr9[0] * f14;
        float f21 = fArr9[1] * f15;
        float f22 = fArr9[2] * f16;
        float f23 = lVar.f5609h;
        float fPow = (float) Math.pow(((double) (Math.abs(f20) * f23)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f21) * f23)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f22) * f23)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f20) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f21) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f22) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f24 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d10)) / 11.0f;
        float f25 = ((float) (((double) (fSignum + fSignum2)) - (d10 * 2.0d))) / 9.0f;
        float f26 = fSignum2 * 20.0f;
        float f27 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f26)) / 20.0f;
        float f28 = (((fSignum * 40.0f) + f26) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f25, f24)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f29 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f28 * lVar.f5604b) / f19, lVar.f5610j * f18)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f30 = f19 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.f5607e) * lVar.f5605c) * ((float) Math.sqrt((f25 * f25) + (f24 * f24)))) / (f27 + 0.305f), 0.9d)) * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        Math.sqrt((r0 * f18) / f30);
        float f31 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f17 * fPow5 * 0.0228f) + 1.0f)) * 43.85965f;
        double d11 = f29;
        return new a(fAtan2, fPow5, fPow4, f31, fLog * ((float) Math.cos(d11)), fLog * ((float) Math.sin(d11)));
    }

    public static a b(float f, float f4, float f10) {
        l lVar = l.f5602k;
        float f11 = lVar.f5606d;
        Math.sqrt(((double) f) / 100.0d);
        float f12 = lVar.f5603a + 4.0f;
        float f13 = lVar.i * f4;
        Math.sqrt(((f4 / ((float) Math.sqrt(r1))) * lVar.f5606d) / f12);
        float f14 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog = ((float) Math.log((((double) f13) * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f10) / 180.0f;
        return new a(f10, f4, f, f14, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(h0.l r20) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.a.c(h0.l):int");
    }
}
