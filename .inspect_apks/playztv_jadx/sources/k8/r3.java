package k8;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r3 extends u7.a {
    public static final Parcelable.Creator<r3> CREATOR = new x(1);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f7404u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f7405v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7406w;

    public r3(int i, long j5, String str) {
        this.f7404u = str;
        this.f7405v = j5;
        this.f7406w = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.C(parcel, 1, this.f7404u);
        wa.t1.H(parcel, 2, 8);
        parcel.writeLong(this.f7405v);
        wa.t1.H(parcel, 3, 4);
        parcel.writeInt(this.f7406w);
        wa.t1.G(parcel, iE);
    }
}
