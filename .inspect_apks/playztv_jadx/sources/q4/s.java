package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new k8.x(10);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10918u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10919v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10920w;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10918u);
        parcel.writeInt(this.f10919v);
        parcel.writeInt(this.f10920w ? 1 : 0);
    }
}
