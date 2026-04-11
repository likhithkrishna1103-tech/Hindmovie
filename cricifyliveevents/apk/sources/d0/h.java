package d0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f3120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f3121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f3123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f3124e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f3125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f3126h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f3127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f3128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3129l;

    public final void a(int i, float f) {
        int i10 = this.f;
        int[] iArr = this.f3123d;
        if (i10 >= iArr.length) {
            this.f3123d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f3124e;
            this.f3124e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f3123d;
        int i11 = this.f;
        iArr2[i11] = i;
        float[] fArr2 = this.f3124e;
        this.f = i11 + 1;
        fArr2[i11] = f;
    }

    public final void b(int i, int i10) {
        int i11 = this.f3122c;
        int[] iArr = this.f3120a;
        if (i11 >= iArr.length) {
            this.f3120a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f3121b;
            this.f3121b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f3120a;
        int i12 = this.f3122c;
        iArr3[i12] = i;
        int[] iArr4 = this.f3121b;
        this.f3122c = i12 + 1;
        iArr4[i12] = i10;
    }

    public final void c(int i, String str) {
        int i10 = this.i;
        int[] iArr = this.f3125g;
        if (i10 >= iArr.length) {
            this.f3125g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f3126h;
            this.f3126h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f3125g;
        int i11 = this.i;
        iArr2[i11] = i;
        String[] strArr2 = this.f3126h;
        this.i = i11 + 1;
        strArr2[i11] = str;
    }

    public final void d(int i, boolean z10) {
        int i10 = this.f3129l;
        int[] iArr = this.f3127j;
        if (i10 >= iArr.length) {
            this.f3127j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f3128k;
            this.f3128k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f3127j;
        int i11 = this.f3129l;
        iArr2[i11] = i;
        boolean[] zArr2 = this.f3128k;
        this.f3129l = i11 + 1;
        zArr2[i11] = z10;
    }
}
