package x0;

import android.os.Parcel;
import android.os.Parcelable;
import c0.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Parcelable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Parcelable f14205u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f14204v = new a();
    public static final Parcelable.Creator<b> CREATOR = new g(14);

    public b() {
        this.f14205u = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14205u, i);
    }

    public b(Parcelable parcelable) {
        if (parcelable != null) {
            this.f14205u = parcelable == f14204v ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public b(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f14205u = parcelable == null ? f14204v : parcelable;
    }
}
