package id;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        be.h.e(parcel, "source");
        b bVar = new b();
        bVar.f6563u = parcel.readInt();
        bVar.f6564v = parcel.readInt();
        bVar.f6565w = parcel.readLong();
        bVar.f6566x = parcel.readLong();
        bVar.f6567y = parcel.readLong();
        return bVar;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new b[i];
    }
}
