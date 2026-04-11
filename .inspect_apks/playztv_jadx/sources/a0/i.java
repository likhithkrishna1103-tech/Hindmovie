package a0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f67a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f68b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f69c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f70d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f71e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f72g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f73h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f74j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f75k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f76l;

    public final void a(int i, float f) {
        int i10 = this.f;
        int[] iArr = this.f70d;
        if (i10 >= iArr.length) {
            this.f70d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f71e;
            this.f71e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f70d;
        int i11 = this.f;
        iArr2[i11] = i;
        float[] fArr2 = this.f71e;
        this.f = i11 + 1;
        fArr2[i11] = f;
    }

    public final void b(int i, int i10) {
        int i11 = this.f69c;
        int[] iArr = this.f67a;
        if (i11 >= iArr.length) {
            this.f67a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f68b;
            this.f68b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f67a;
        int i12 = this.f69c;
        iArr3[i12] = i;
        int[] iArr4 = this.f68b;
        this.f69c = i12 + 1;
        iArr4[i12] = i10;
    }

    public final void c(int i, boolean z2) {
        int i10 = this.f76l;
        int[] iArr = this.f74j;
        if (i10 >= iArr.length) {
            this.f74j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f75k;
            this.f75k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f74j;
        int i11 = this.f76l;
        iArr2[i11] = i;
        boolean[] zArr2 = this.f75k;
        this.f76l = i11 + 1;
        zArr2[i11] = z2;
    }

    public final void d(String str, int i) {
        int i10 = this.i;
        int[] iArr = this.f72g;
        if (i10 >= iArr.length) {
            this.f72g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f73h;
            this.f73h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f72g;
        int i11 = this.i;
        iArr2[i11] = i;
        String[] strArr2 = this.f73h;
        this.i = i11 + 1;
        strArr2[i11] = str;
    }
}
