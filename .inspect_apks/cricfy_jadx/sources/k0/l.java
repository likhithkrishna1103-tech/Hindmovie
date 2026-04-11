package k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f6777k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f6782e;
    public final float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f6783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f6784h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f6785j;

    static {
        float[] fArr = b.f6753c;
        float fN = (float) ((((double) b.n()) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f6751a;
        float f = fArr[0];
        float[] fArr3 = fArr2[0];
        float f10 = fArr3[0] * f;
        float f11 = fArr[1];
        float f12 = (fArr3[1] * f11) + f10;
        float f13 = fArr[2];
        float f14 = (fArr3[2] * f13) + f12;
        float[] fArr4 = fArr2[1];
        float f15 = (fArr4[2] * f13) + (fArr4[1] * f11) + (fArr4[0] * f);
        float[] fArr5 = fArr2[2];
        float f16 = (f13 * fArr5[2]) + (f11 * fArr5[1]) + (f * fArr5[0]);
        float f17 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fN) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d10 = fExp;
        if (d10 > 1.0d) {
            fExp = 1.0f;
        } else if (d10 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f14) * fExp) + 1.0f) - fExp, (((100.0f / f15) * fExp) + 1.0f) - fExp, (((100.0f / f16) * fExp) + 1.0f) - fExp};
        float f18 = 1.0f / ((5.0f * fN) + 1.0f);
        float f19 = f18 * f18 * f18 * f18;
        float f20 = 1.0f - f19;
        float fCbrt = (0.1f * f20 * f20 * ((float) Math.cbrt(((double) fN) * 5.0d))) + (f19 * fN);
        float fN2 = b.n() / fArr[1];
        double d11 = fN2;
        float fSqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f14)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f15)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f16)) / 100.0d, 0.42d)};
        float f21 = fArr7[0];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr7[1];
        float f24 = (f23 * 400.0f) / (f23 + 27.13f);
        float f25 = fArr7[2];
        float[] fArr8 = {f22, f24, (400.0f * f25) / (f25 + 27.13f)};
        f6777k = new l(fN2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, f17, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public l(float f, float f10, float f11, float f12, float f13, float f14, float[] fArr, float f15, float f16, float f17) {
        this.f = f;
        this.f6778a = f10;
        this.f6779b = f11;
        this.f6780c = f12;
        this.f6781d = f13;
        this.f6782e = f14;
        this.f6783g = fArr;
        this.f6784h = f15;
        this.i = f16;
        this.f6785j = f17;
    }
}
