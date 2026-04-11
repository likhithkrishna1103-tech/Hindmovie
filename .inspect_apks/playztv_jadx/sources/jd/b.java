package jd;

import android.os.Parcel;
import android.os.Parcelable;
import be.h;
import id.g;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        h.e(parcel, "source");
        int i = parcel.readInt();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        long j5 = parcel.readLong();
        long j8 = parcel.readLong();
        String string2 = parcel.readString();
        if (string2 == null) {
            string2 = "";
        }
        String string3 = parcel.readString();
        if (string3 == null) {
            string3 = "";
        }
        Serializable serializable = parcel.readSerializable();
        h.c(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
        return new c(i, string, j5, j8, string2, string3, new g((HashMap) serializable), parcel.readInt(), parcel.readInt(), parcel.readInt() == 1);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new c[i];
    }
}
