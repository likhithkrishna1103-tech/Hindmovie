package da;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f4111w = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f4112u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4113v;

    static {
        new a(new int[0]);
    }

    public a(int[] iArr) {
        int length = iArr.length;
        this.f4112u = iArr;
        this.f4113v = length;
    }

    public final boolean equals(Object obj) {
        a aVar;
        int i;
        int i10;
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a) && (i10 = this.f4113v) == (i = (aVar = (a) obj).f4113v)) {
            for (int i11 = 0; i11 < i10; i11++) {
                q1.c.i(i11, i10);
                int i12 = this.f4112u[i11];
                q1.c.i(i11, i);
                if (i12 == aVar.f4112u[i11]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 1;
        for (int i10 = 0; i10 < this.f4113v; i10++) {
            i = (i * 31) + this.f4112u[i10];
        }
        return i;
    }

    public final String toString() {
        int i = this.f4113v;
        if (i == 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder(i * 5);
        sb2.append('[');
        int[] iArr = this.f4112u;
        sb2.append(iArr[0]);
        for (int i10 = 1; i10 < i; i10++) {
            sb2.append(", ");
            sb2.append(iArr[i10]);
        }
        sb2.append(']');
        return sb2.toString();
    }
}
