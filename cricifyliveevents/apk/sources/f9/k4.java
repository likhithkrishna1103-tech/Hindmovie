package f9;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k4 extends p8.a {
    public static final Parcelable.Creator<k4> CREATOR = new android.support.v4.media.a(24);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f4258v;

    public k4(ArrayList arrayList) {
        this.f4258v = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.t(parcel, 1, this.f4258v);
        qb.t1.y(parcel, iW);
    }
}
