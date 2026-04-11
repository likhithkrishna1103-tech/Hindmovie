package ub;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends u7.a {
    public static final Parcelable.Creator<n> CREATOR = new k8.x(26);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Bundle f12864u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public s.e f12865v;

    public n(Bundle bundle) {
        this.f12864u = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.z(parcel, 2, this.f12864u);
        t1.G(parcel, iE);
    }
}
