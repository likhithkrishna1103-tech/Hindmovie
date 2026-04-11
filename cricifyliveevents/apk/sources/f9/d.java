package f9;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p8.a {
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.a(16);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f4062v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4063w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f4064x;

    public d(int i, long j4, long j7) {
        this.f4062v = j4;
        this.f4063w = i;
        this.f4064x = j7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.v(parcel, 1, 8);
        parcel.writeLong(this.f4062v);
        qb.t1.v(parcel, 2, 4);
        parcel.writeInt(this.f4063w);
        qb.t1.v(parcel, 3, 8);
        parcel.writeLong(this.f4064x);
        qb.t1.y(parcel, iW);
    }
}
