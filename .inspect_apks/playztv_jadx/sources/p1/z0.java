package p1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Comparable, Parcelable {
    public static final Parcelable.Creator<z0> CREATOR = new k(2);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f10120x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f10121y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f10122z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f10123u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10124v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f10125w;

    static {
        int i = s1.b0.f11647a;
        f10120x = Integer.toString(0, 36);
        f10121y = Integer.toString(1, 36);
        f10122z = Integer.toString(2, 36);
    }

    public z0(int i, int i10, int i11) {
        this.f10123u = i;
        this.f10124v = i10;
        this.f10125w = i11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        z0 z0Var = (z0) obj;
        int i = this.f10123u - z0Var.f10123u;
        if (i != 0) {
            return i;
        }
        int i10 = this.f10124v - z0Var.f10124v;
        return i10 == 0 ? this.f10125w - z0Var.f10125w : i10;
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
            if (this.f10123u == z0Var.f10123u && this.f10124v == z0Var.f10124v && this.f10125w == z0Var.f10125w) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f10123u * 31) + this.f10124v) * 31) + this.f10125w;
    }

    public final String toString() {
        return this.f10123u + "." + this.f10124v + "." + this.f10125w;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10123u);
        parcel.writeInt(this.f10124v);
        parcel.writeInt(this.f10125w);
    }

    public z0(Parcel parcel) {
        this.f10123u = parcel.readInt();
        this.f10124v = parcel.readInt();
        this.f10125w = parcel.readInt();
    }
}
