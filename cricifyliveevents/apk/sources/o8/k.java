package o8;

import android.os.Parcel;
import android.os.Parcelable;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends p8.a {
    public static final Parcelable.Creator<k> CREATOR = new l4.p(20);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9674v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f9675w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f9676x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f9677y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f9678z;

    public k(int i, boolean z10, boolean z11, int i10, int i11) {
        this.f9674v = i;
        this.f9675w = z10;
        this.f9676x = z11;
        this.f9677y = i10;
        this.f9678z = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(this.f9674v);
        t1.v(parcel, 2, 4);
        parcel.writeInt(this.f9675w ? 1 : 0);
        t1.v(parcel, 3, 4);
        parcel.writeInt(this.f9676x ? 1 : 0);
        t1.v(parcel, 4, 4);
        parcel.writeInt(this.f9677y);
        t1.v(parcel, 5, 4);
        parcel.writeInt(this.f9678z);
        t1.y(parcel, iW);
    }
}
