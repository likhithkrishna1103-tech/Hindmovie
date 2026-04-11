package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Parcelable {
    public static final Parcelable.Creator<n0> CREATOR = new android.support.v4.media.a(6);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f1024v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1025w;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1024v);
        parcel.writeInt(this.f1025w);
    }
}
