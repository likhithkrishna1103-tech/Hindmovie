package o8;

import android.os.Parcel;
import android.os.Parcelable;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends p8.a {
    public static final Parcelable.Creator<i> CREATOR = new l4.p(19);
    public final String A;
    public final String B;
    public final int C;
    public final int D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9664v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f9665w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f9666x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f9667y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f9668z;

    public i(int i, int i10, int i11, long j4, long j7, String str, String str2, int i12, int i13) {
        this.f9664v = i;
        this.f9665w = i10;
        this.f9666x = i11;
        this.f9667y = j4;
        this.f9668z = j7;
        this.A = str;
        this.B = str2;
        this.C = i12;
        this.D = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(this.f9664v);
        t1.v(parcel, 2, 4);
        parcel.writeInt(this.f9665w);
        t1.v(parcel, 3, 4);
        parcel.writeInt(this.f9666x);
        t1.v(parcel, 4, 8);
        parcel.writeLong(this.f9667y);
        t1.v(parcel, 5, 8);
        parcel.writeLong(this.f9668z);
        t1.r(parcel, 6, this.A);
        t1.r(parcel, 7, this.B);
        t1.v(parcel, 8, 4);
        parcel.writeInt(this.C);
        t1.v(parcel, 9, 4);
        parcel.writeInt(this.D);
        t1.y(parcel, iW);
    }
}
