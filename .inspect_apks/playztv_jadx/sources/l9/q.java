package l9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends x0.b {
    public static final Parcelable.Creator<q> CREATOR = new c0.g(6);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bundle f8062w;

    public q(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8062w = parcel.readBundle(classLoader);
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.f8062w);
    }
}
