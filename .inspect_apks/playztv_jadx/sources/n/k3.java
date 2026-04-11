package n;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k3 extends x0.b {
    public static final Parcelable.Creator<k3> CREATOR = new c0.g(8);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8429w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8430x;

    public k3(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8429w = parcel.readInt();
        this.f8430x = parcel.readInt() != 0;
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f8429w);
        parcel.writeInt(this.f8430x ? 1 : 0);
    }
}
