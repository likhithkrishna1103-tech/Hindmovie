package k8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends u7.a implements Iterable {
    public static final Parcelable.Creator<u> CREATOR = new a9.b(29);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Bundle f7434u;

    public u(Bundle bundle) {
        this.f7434u = bundle;
    }

    public final Double b() {
        return Double.valueOf(this.f7434u.getDouble("value"));
    }

    public final Bundle d() {
        return new Bundle(this.f7434u);
    }

    public final String e() {
        return this.f7434u.getString("currency");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        t tVar = new t();
        tVar.f7424u = this.f7434u.keySet().iterator();
        return tVar;
    }

    public final String toString() {
        return this.f7434u.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.z(parcel, 2, d());
        wa.t1.G(parcel, iE);
    }
}
