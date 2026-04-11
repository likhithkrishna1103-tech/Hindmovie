package f9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends p8.a {
    public static final Parcelable.Creator<i> CREATOR = new android.support.v4.media.a(18);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Bundle f4216v;

    public i(Bundle bundle) {
        this.f4216v = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.o(parcel, 1, this.f4216v);
        qb.t1.y(parcel, iW);
    }
}
