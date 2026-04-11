package l9;

import android.os.Parcel;
import android.os.Parcelable;
import j9.v;
import k8.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new x(5);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public v f8049v;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8048u);
        parcel.writeParcelable(this.f8049v, 0);
    }
}
