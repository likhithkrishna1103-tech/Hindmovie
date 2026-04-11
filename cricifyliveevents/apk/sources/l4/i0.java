package l4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new p(4);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7720v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7721w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f7722x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7723y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7724z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7720v);
        parcel.writeInt(this.f7722x);
        parcel.writeInt(this.f7723y);
        parcel.writeInt(this.f7724z);
        parcel.writeInt(this.f7721w);
    }
}
