package o8;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends p8.a {
    public static final Parcelable.Creator<l> CREATOR = new l4.p(18);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9679v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f9680w;

    public l(int i, List list) {
        this.f9679v = i;
        this.f9680w = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(this.f9679v);
        t1.t(parcel, 2, this.f9680w);
        t1.y(parcel, iW);
    }
}
