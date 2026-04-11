package f9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends p8.a implements Iterable {
    public static final Parcelable.Creator<u> CREATOR = new android.support.v4.media.a(19);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Bundle f4426v;

    public u(Bundle bundle) {
        this.f4426v = bundle;
    }

    public final Object a(String str) {
        return this.f4426v.get(str);
    }

    public final Double b() {
        return Double.valueOf(this.f4426v.getDouble("value"));
    }

    public final String c() {
        return this.f4426v.getString("currency");
    }

    public final Bundle d() {
        return new Bundle(this.f4426v);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new t(this);
    }

    public final String toString() {
        return this.f4426v.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.o(parcel, 2, d());
        qb.t1.y(parcel, iW);
    }
}
