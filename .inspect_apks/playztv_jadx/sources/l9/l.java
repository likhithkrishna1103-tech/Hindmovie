package l9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends x0.b {
    public static final Parcelable.Creator<l> CREATOR = new c0.g(5);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bundle f8053w;

    public l(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8053w = parcel.readBundle(classLoader == null ? l.class.getClassLoader() : classLoader);
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.f8053w);
    }
}
