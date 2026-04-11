package t7;

import android.os.Parcel;
import android.os.Parcelable;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends u7.a {
    public static final Parcelable.Creator<k> CREATOR = new k8.x(21);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f12315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f12316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f12317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f12318y;

    public k(int i, int i10, int i11, boolean z2, boolean z10) {
        this.f12314u = i;
        this.f12315v = z2;
        this.f12316w = z10;
        this.f12317x = i10;
        this.f12318y = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.H(parcel, 1, 4);
        parcel.writeInt(this.f12314u);
        t1.H(parcel, 2, 4);
        parcel.writeInt(this.f12315v ? 1 : 0);
        t1.H(parcel, 3, 4);
        parcel.writeInt(this.f12316w ? 1 : 0);
        t1.H(parcel, 4, 4);
        parcel.writeInt(this.f12317x);
        t1.H(parcel, 5, 4);
        parcel.writeInt(this.f12318y);
        t1.G(parcel, iE);
    }
}
