package f9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i4 extends p8.a {
    public static final Parcelable.Creator<i4> CREATOR = new android.support.v4.media.a(22);
    public final long A;
    public String B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f4222v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f4223w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f4224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Bundle f4225y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f4226z;

    public i4(long j4, byte[] bArr, String str, Bundle bundle, int i, long j7, String str2) {
        this.f4222v = j4;
        this.f4223w = bArr;
        this.f4224x = str;
        this.f4225y = bundle;
        this.f4226z = i;
        this.A = j7;
        this.B = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.v(parcel, 1, 8);
        parcel.writeLong(this.f4222v);
        byte[] bArr = this.f4223w;
        if (bArr != null) {
            int iW2 = qb.t1.w(parcel, 2);
            parcel.writeByteArray(bArr);
            qb.t1.y(parcel, iW2);
        }
        qb.t1.r(parcel, 3, this.f4224x);
        qb.t1.o(parcel, 4, this.f4225y);
        qb.t1.v(parcel, 5, 4);
        parcel.writeInt(this.f4226z);
        qb.t1.v(parcel, 6, 8);
        parcel.writeLong(this.A);
        qb.t1.r(parcel, 7, this.B);
        qb.t1.y(parcel, iW);
    }
}
