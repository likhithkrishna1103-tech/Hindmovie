package e1;

import android.os.Parcel;
import android.os.Parcelable;
import c0.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends x0.b {
    public static final Parcelable.Creator<e> CREATOR = new g(1);
    public int A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4282w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4283x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4284y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4285z;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4282w = 0;
        this.f4282w = parcel.readInt();
        this.f4283x = parcel.readInt();
        this.f4284y = parcel.readInt();
        this.f4285z = parcel.readInt();
        this.A = parcel.readInt();
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f4282w);
        parcel.writeInt(this.f4283x);
        parcel.writeInt(this.f4284y);
        parcel.writeInt(this.f4285z);
        parcel.writeInt(this.A);
    }
}
