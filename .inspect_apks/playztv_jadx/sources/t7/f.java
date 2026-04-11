package t7;

import android.os.Parcel;
import android.os.Parcelable;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends u7.a {
    public static final Parcelable.Creator<f> CREATOR = new k8.x(23);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f12294u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f12295v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f12296w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f12297x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f12298y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f12299z;

    public f(k kVar, boolean z2, boolean z10, int[] iArr, int i, int[] iArr2) {
        this.f12294u = kVar;
        this.f12295v = z2;
        this.f12296w = z10;
        this.f12297x = iArr;
        this.f12298y = i;
        this.f12299z = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.B(parcel, 1, this.f12294u, i);
        t1.H(parcel, 2, 4);
        parcel.writeInt(this.f12295v ? 1 : 0);
        t1.H(parcel, 3, 4);
        parcel.writeInt(this.f12296w ? 1 : 0);
        int[] iArr = this.f12297x;
        if (iArr != null) {
            int iE2 = t1.E(parcel, 4);
            parcel.writeIntArray(iArr);
            t1.G(parcel, iE2);
        }
        t1.H(parcel, 5, 4);
        parcel.writeInt(this.f12298y);
        int[] iArr2 = this.f12299z;
        if (iArr2 != null) {
            int iE3 = t1.E(parcel, 6);
            parcel.writeIntArray(iArr2);
            t1.G(parcel, iE3);
        }
        t1.G(parcel, iE);
    }
}
