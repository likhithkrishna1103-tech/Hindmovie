package jd;

import android.os.Parcel;
import android.os.Parcelable;
import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        h.e(parcel, "source");
        int i = parcel.readInt();
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        long j5 = parcel.readLong();
        long j8 = parcel.readLong();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        return new e(i, i10, i11, j5, j8, string, string2 == null ? "" : string2);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new e[i];
    }
}
