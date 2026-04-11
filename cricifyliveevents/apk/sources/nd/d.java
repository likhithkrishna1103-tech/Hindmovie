package nd;

import android.os.Parcel;
import android.os.Parcelable;
import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        i.e(parcel, "source");
        int i = parcel.readInt();
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        long j4 = parcel.readLong();
        long j7 = parcel.readLong();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        return new e(i, i10, i11, j4, j7, string, string2 == null ? "" : string2);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new e[i];
    }
}
