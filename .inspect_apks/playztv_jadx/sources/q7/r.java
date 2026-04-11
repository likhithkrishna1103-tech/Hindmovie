package q7;

import android.os.Parcel;
import android.os.Parcelable;
import k8.x;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends u7.a {
    public static final Parcelable.Creator<r> CREATOR = new x(15);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f11063u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f11064v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11065w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f11066x;

    public r(int i, int i10, String str, boolean z2) {
        this.f11063u = z2;
        this.f11064v = str;
        this.f11065w = com.bumptech.glide.c.x(i) - 1;
        this.f11066x = cf.l.C(i10) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.H(parcel, 1, 4);
        parcel.writeInt(this.f11063u ? 1 : 0);
        t1.C(parcel, 2, this.f11064v);
        t1.H(parcel, 3, 4);
        parcel.writeInt(this.f11065w);
        t1.H(parcel, 4, 4);
        parcel.writeInt(this.f11066x);
        t1.G(parcel, iE);
    }
}
