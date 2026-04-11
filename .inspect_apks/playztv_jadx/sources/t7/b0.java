package t7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends u7.a {
    public static final Parcelable.Creator<b0> CREATOR = new k8.x(22);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Bundle f12251u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public q7.d[] f12252v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12253w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f f12254x;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.z(parcel, 1, this.f12251u);
        t1.D(parcel, 2, this.f12252v, i);
        int i10 = this.f12253w;
        t1.H(parcel, 3, 4);
        parcel.writeInt(i10);
        t1.B(parcel, 4, this.f12254x, i);
        t1.G(parcel, iE);
    }
}
