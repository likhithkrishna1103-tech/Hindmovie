package xa;

import com.bumptech.glide.d;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f14465x = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f14466v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f14467w;

    static {
        new a(new int[0]);
    }

    public a(int[] iArr) {
        int length = iArr.length;
        this.f14466v = iArr;
        this.f14467w = length;
    }

    public final boolean equals(Object obj) {
        a aVar;
        int i;
        int i10;
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a) && (i10 = this.f14467w) == (i = (aVar = (a) obj).f14467w)) {
            for (int i11 = 0; i11 < i10; i11++) {
                d.g(i11, i10);
                int i12 = this.f14466v[i11];
                d.g(i11, i);
                if (i12 == aVar.f14466v[i11]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 1;
        for (int i10 = 0; i10 < this.f14467w; i10++) {
            i = (i * 31) + this.f14466v[i10];
        }
        return i;
    }

    public final String toString() {
        int i = this.f14467w;
        if (i == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(i * 5);
        sb.append('[');
        int[] iArr = this.f14466v;
        sb.append(iArr[0]);
        for (int i10 = 1; i10 < i; i10++) {
            sb.append(", ");
            sb.append(iArr[i10]);
        }
        sb.append(']');
        return sb.toString();
    }
}
