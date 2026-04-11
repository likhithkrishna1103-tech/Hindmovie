package s5;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f11795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f11796b;

    public c(float[] fArr, int[] iArr) {
        this.f11795a = fArr;
        this.f11796b = iArr;
    }

    public final void a(c cVar) {
        int i = 0;
        while (true) {
            int[] iArr = cVar.f11796b;
            if (i >= iArr.length) {
                return;
            }
            this.f11795a[i] = cVar.f11795a[i];
            this.f11796b[i] = iArr[i];
            i++;
        }
    }

    public final c b(float[] fArr) {
        int iK;
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            float f = fArr[i];
            float[] fArr2 = this.f11795a;
            int iBinarySearch = Arrays.binarySearch(fArr2, f);
            int[] iArr2 = this.f11796b;
            if (iBinarySearch >= 0) {
                iK = iArr2[iBinarySearch];
            } else {
                int i10 = -(iBinarySearch + 1);
                if (i10 == 0) {
                    iK = iArr2[0];
                } else if (i10 == iArr2.length - 1) {
                    iK = iArr2[iArr2.length - 1];
                } else {
                    int i11 = i10 - 1;
                    float f4 = fArr2[i11];
                    iK = com.bumptech.glide.d.k((f - f4) / (fArr2[i10] - f4), iArr2[i11], iArr2[i10]);
                }
            }
            iArr[i] = iK;
        }
        return new c(fArr, iArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (Arrays.equals(this.f11795a, cVar.f11795a) && Arrays.equals(this.f11796b, cVar.f11796b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f11796b) + (Arrays.hashCode(this.f11795a) * 31);
    }
}
