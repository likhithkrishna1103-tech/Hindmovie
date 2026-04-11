package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a(3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f492v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f493w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f494x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f495y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f496z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f492v);
        parcel.writeInt(this.f494x);
        parcel.writeInt(this.f495y);
        parcel.writeInt(this.f496z);
        parcel.writeInt(this.f493w);
    }
}
