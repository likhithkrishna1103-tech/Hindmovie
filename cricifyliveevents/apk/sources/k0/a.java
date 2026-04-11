package k0;

import android.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f6750e;
    public final float f;

    public a(float f, float f10, float f11, float f12, float f13, float f14) {
        this.f6746a = f;
        this.f6747b = f10;
        this.f6748c = f11;
        this.f6749d = f12;
        this.f6750e = f13;
        this.f = f14;
    }

    public static a a(int i) {
        l lVar = l.f6777k;
        float f = b.f(Color.red(i));
        float f10 = b.f(Color.green(i));
        float f11 = b.f(Color.blue(i));
        float[][] fArr = b.f6754d;
        float[] fArr2 = fArr[0];
        float f12 = (fArr2[2] * f11) + (fArr2[1] * f10) + (fArr2[0] * f);
        float[] fArr3 = fArr[1];
        float f13 = (fArr3[2] * f11) + (fArr3[1] * f10) + (fArr3[0] * f);
        float[] fArr4 = fArr[2];
        float f14 = (f11 * fArr4[2]) + (f10 * fArr4[1]) + (f * fArr4[0]);
        float[][] fArr5 = b.f6751a;
        float[] fArr6 = fArr5[0];
        float f15 = (fArr6[2] * f14) + (fArr6[1] * f13) + (fArr6[0] * f12);
        float[] fArr7 = fArr5[1];
        float f16 = (fArr7[2] * f14) + (fArr7[1] * f13) + (fArr7[0] * f12);
        float[] fArr8 = fArr5[2];
        float f17 = (f14 * fArr8[2]) + (f13 * fArr8[1]) + (f12 * fArr8[0]);
        float[] fArr9 = lVar.f6783g;
        float f18 = lVar.i;
        float f19 = lVar.f6781d;
        float f20 = lVar.f6778a;
        float f21 = fArr9[0] * f15;
        float f22 = fArr9[1] * f16;
        float f23 = fArr9[2] * f17;
        float f24 = lVar.f6784h;
        float fPow = (float) Math.pow(((double) (Math.abs(f21) * f24)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f22) * f24)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f23) * f24)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f21) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f22) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f23) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f25 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d10)) / 11.0f;
        float f26 = ((float) (((double) (fSignum + fSignum2)) - (d10 * 2.0d))) / 9.0f;
        float f27 = fSignum2 * 20.0f;
        float f28 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f27)) / 20.0f;
        float f29 = (((fSignum * 40.0f) + f27) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f26, f25)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f30 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f29 * lVar.f6779b) / f20, lVar.f6785j * f19)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f31 = f20 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.f6782e) * lVar.f6780c) * ((float) Math.sqrt((f26 * f26) + (f25 * f25)))) / (f28 + 0.305f), 0.9d)) * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        Math.sqrt((r0 * f19) / f31);
        float f32 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f18 * fPow5 * 0.0228f) + 1.0f)) * 43.85965f;
        double d11 = f30;
        return new a(fAtan2, fPow5, fPow4, f32, fLog * ((float) Math.cos(d11)), fLog * ((float) Math.sin(d11)));
    }

    public static a b(float f, float f10, float f11) {
        l lVar = l.f6777k;
        float f12 = lVar.f6781d;
        Math.sqrt(((double) f) / 100.0d);
        float f13 = lVar.f6778a + 4.0f;
        float f14 = lVar.i * f10;
        Math.sqrt(((f10 / ((float) Math.sqrt(r1))) * lVar.f6781d) / f13);
        float f15 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog = ((float) Math.log((((double) f14) * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f11) / 180.0f;
        return new a(f11, f10, f, f15, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(k0.l r20) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.a.c(k0.l):int");
    }
}
