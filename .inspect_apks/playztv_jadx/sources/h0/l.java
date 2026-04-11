package h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f5602k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f5604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f5605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f5606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f5607e;
    public final float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f5608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f5609h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f5610j;

    static {
        float[] fArr = b.f5578c;
        float fN = (float) ((((double) b.n()) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f5576a;
        float f = fArr[0];
        float[] fArr3 = fArr2[0];
        float f4 = fArr3[0] * f;
        float f10 = fArr[1];
        float f11 = (fArr3[1] * f10) + f4;
        float f12 = fArr[2];
        float f13 = (fArr3[2] * f12) + f11;
        float[] fArr4 = fArr2[1];
        float f14 = (fArr4[2] * f12) + (fArr4[1] * f10) + (fArr4[0] * f);
        float[] fArr5 = fArr2[2];
        float f15 = (f12 * fArr5[2]) + (f10 * fArr5[1]) + (f * fArr5[0]);
        float f16 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fN) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d10 = fExp;
        if (d10 > 1.0d) {
            fExp = 1.0f;
        } else if (d10 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f13) * fExp) + 1.0f) - fExp, (((100.0f / f14) * fExp) + 1.0f) - fExp, (((100.0f / f15) * fExp) + 1.0f) - fExp};
        float f17 = 1.0f / ((5.0f * fN) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float fCbrt = (0.1f * f19 * f19 * ((float) Math.cbrt(((double) fN) * 5.0d))) + (f18 * fN);
        float fN2 = b.n() / fArr[1];
        double d11 = fN2;
        float fSqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f13)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f14)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f15)) / 100.0d, 0.42d)};
        float f20 = fArr7[0];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[1];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr7[2];
        float[] fArr8 = {f21, f23, (400.0f * f24) / (f24 + 27.13f)};
        f5602k = new l(fN2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, f16, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public l(float f, float f4, float f10, float f11, float f12, float f13, float[] fArr, float f14, float f15, float f16) {
        this.f = f;
        this.f5603a = f4;
        this.f5604b = f10;
        this.f5605c = f11;
        this.f5606d = f12;
        this.f5607e = f13;
        this.f5608g = fArr;
        this.f5609h = f14;
        this.i = f15;
        this.f5610j = f16;
    }
}
