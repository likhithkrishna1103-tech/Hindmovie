package v1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Comparable, Parcelable {
    public static final String A;
    public static final Parcelable.Creator<z0> CREATOR = new j(2);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f13062y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f13063z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13064v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f13065w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13066x;

    static {
        int i = y1.a0.f14551a;
        f13062y = Integer.toString(0, 36);
        f13063z = Integer.toString(1, 36);
        A = Integer.toString(2, 36);
    }

    public z0(int i, int i10, int i11) {
        this.f13064v = i;
        this.f13065w = i10;
        this.f13066x = i11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        z0 z0Var = (z0) obj;
        int i = this.f13064v - z0Var.f13064v;
        if (i != 0) {
            return i;
        }
        int i10 = this.f13065w - z0Var.f13065w;
        return i10 == 0 ? this.f13066x - z0Var.f13066x : i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z0.class == obj.getClass()) {
            z0 z0Var = (z0) obj;
            if (this.f13064v == z0Var.f13064v && this.f13065w == z0Var.f13065w && this.f13066x == z0Var.f13066x) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f13064v * 31) + this.f13065w) * 31) + this.f13066x;
    }

    public final String toString() {
        return this.f13064v + "." + this.f13065w + "." + this.f13066x;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13064v);
        parcel.writeInt(this.f13065w);
        parcel.writeInt(this.f13066x);
    }

    public z0(Parcel parcel) {
        this.f13064v = parcel.readInt();
        this.f13065w = parcel.readInt();
        this.f13066x = parcel.readInt();
    }
}
