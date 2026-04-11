package nc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends p8.a {
    public static final Parcelable.Creator<o> CREATOR = new l4.p(15);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Bundle f9066v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public v.e f9067w;

    public o(Bundle bundle) {
        this.f9066v = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.o(parcel, 2, this.f9066v);
        t1.y(parcel, iW);
    }
}
