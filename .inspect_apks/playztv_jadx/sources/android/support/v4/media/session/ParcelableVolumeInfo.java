package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a(3);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f835u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f836v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f837w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f838x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f839y;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f835u);
        parcel.writeInt(this.f837w);
        parcel.writeInt(this.f838x);
        parcel.writeInt(this.f839y);
        parcel.writeInt(this.f836v);
    }
}
