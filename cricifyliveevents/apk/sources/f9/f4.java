package f9;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f4 extends p8.a {
    public static final Parcelable.Creator<f4> CREATOR = new android.support.v4.media.a(21);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f4180v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f4181w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f4182x;

    public f4(int i, long j4, String str) {
        this.f4180v = str;
        this.f4181w = j4;
        this.f4182x = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.r(parcel, 1, this.f4180v);
        qb.t1.v(parcel, 2, 8);
        parcel.writeLong(this.f4181w);
        qb.t1.v(parcel, 3, 4);
        parcel.writeInt(this.f4182x);
        qb.t1.y(parcel, iW);
    }
}
