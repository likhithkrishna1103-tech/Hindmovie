package l8;

import android.os.Parcel;
import android.os.Parcelable;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends p8.a {
    public static final Parcelable.Creator<s> CREATOR = new l4.p(10);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f7915v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f7916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f7917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f7918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f7919z;

    public s(boolean z10, String str, int i, int i10, long j4) {
        this.f7915v = z10;
        this.f7916w = str;
        this.f7917x = com.bumptech.glide.d.G(i) - 1;
        this.f7918y = com.bumptech.glide.c.D(i10) - 1;
        this.f7919z = j4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(this.f7915v ? 1 : 0);
        t1.r(parcel, 2, this.f7916w);
        t1.v(parcel, 3, 4);
        parcel.writeInt(this.f7917x);
        t1.v(parcel, 4, 4);
        parcel.writeInt(this.f7918y);
        t1.v(parcel, 5, 8);
        parcel.writeLong(this.f7919z);
        t1.y(parcel, iW);
    }
}
