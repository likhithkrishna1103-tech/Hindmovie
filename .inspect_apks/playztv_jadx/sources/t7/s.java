package t7;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends com.google.android.gms.internal.measurement.f0 implements u {
    public final boolean I() {
        Parcel parcelE = e(f(), 7);
        int i = f8.a.f4810a;
        boolean z2 = parcelE.readInt() != 0;
        parcelE.recycle();
        return z2;
    }
}
