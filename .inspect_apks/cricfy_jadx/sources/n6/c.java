package n6;

import com.google.android.gms.internal.measurement.z3;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f8779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f8780b;

    public c(float[] fArr, int[] iArr) {
        this.f8779a = fArr;
        this.f8780b = iArr;
    }

    public final void a(c cVar) {
        int i = 0;
        while (true) {
            int[] iArr = cVar.f8780b;
            if (i >= iArr.length) {
                return;
            }
            this.f8779a[i] = cVar.f8779a[i];
            this.f8780b[i] = iArr[i];
            i++;
        }
    }

    public final c b(float[] fArr) {
        int iK;
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            float f = fArr[i];
            float[] fArr2 = this.f8779a;
            int iBinarySearch = Arrays.binarySearch(fArr2, f);
            int[] iArr2 = this.f8780b;
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
                    float f10 = fArr2[i11];
                    iK = z3.k((f - f10) / (fArr2[i10] - f10), iArr2[i11], iArr2[i10]);
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
            if (Arrays.equals(this.f8779a, cVar.f8779a) && Arrays.equals(this.f8780b, cVar.f8780b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8780b) + (Arrays.hashCode(this.f8779a) * 31);
    }
}
