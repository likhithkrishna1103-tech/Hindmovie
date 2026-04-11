package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends x0.b {
    public static final Parcelable.Creator<q0> CREATOR = new c0.g(9);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Parcelable f10901w;

    public q0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f10901w = parcel.readParcelable(classLoader == null ? h0.class.getClassLoader() : classLoader);
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f10901w, 0);
    }
}
