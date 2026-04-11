package k8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends u7.a {
    public static final Parcelable.Creator<g> CREATOR = new a9.b(28);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Bundle f7184u;

    public g(Bundle bundle) {
        this.f7184u = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.z(parcel, 1, this.f7184u);
        wa.t1.G(parcel, iE);
    }
}
