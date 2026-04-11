package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iV = q1.c.V(parcel);
        long jK = 0;
        long jK2 = 0;
        boolean zI = false;
        String strU = null;
        String strU2 = null;
        String strU3 = null;
        Bundle bundleS = null;
        String strU4 = null;
        while (parcel.dataPosition() < iV) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    jK = q1.c.K(parcel, i);
                    break;
                case 2:
                    jK2 = q1.c.K(parcel, i);
                    break;
                case 3:
                    zI = q1.c.I(parcel, i);
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    strU = q1.c.u(parcel, i);
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    strU2 = q1.c.u(parcel, i);
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    strU3 = q1.c.u(parcel, i);
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    bundleS = q1.c.s(parcel, i);
                    break;
                case '\b':
                    strU4 = q1.c.u(parcel, i);
                    break;
                default:
                    q1.c.R(parcel, i);
                    break;
            }
        }
        q1.c.z(parcel, iV);
        return new d1(jK, jK2, zI, strU, strU2, strU3, bundleS, strU4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new d1[i];
    }
}
