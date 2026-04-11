package o8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends p8.a {
    public static final Parcelable.Creator<c0> CREATOR = new l4.p(21);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Bundle f9613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public l8.d[] f9614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9615x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f9616y;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.o(parcel, 1, this.f9613v);
        t1.s(parcel, 2, this.f9614w, i);
        int i10 = this.f9615x;
        t1.v(parcel, 3, 4);
        parcel.writeInt(i10);
        t1.q(parcel, 4, this.f9616y, i);
        t1.y(parcel, iW);
    }
}
