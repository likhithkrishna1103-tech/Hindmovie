package v4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new l4.p(25);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13337v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13338w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13339x;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13337v);
        parcel.writeInt(this.f13338w);
        parcel.writeInt(this.f13339x ? 1 : 0);
    }
}
