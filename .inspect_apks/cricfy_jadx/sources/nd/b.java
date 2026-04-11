package nd;

import android.os.Parcel;
import android.os.Parcelable;
import ge.i;
import java.io.Serializable;
import java.util.HashMap;
import md.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        i.e(parcel, "source");
        int i = parcel.readInt();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        long j4 = parcel.readLong();
        long j7 = parcel.readLong();
        String string2 = parcel.readString();
        if (string2 == null) {
            string2 = "";
        }
        String string3 = parcel.readString();
        if (string3 == null) {
            string3 = "";
        }
        Serializable serializable = parcel.readSerializable();
        i.c(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
        return new c(i, string, j4, j7, string2, string3, new g((HashMap) serializable), parcel.readInt(), parcel.readInt(), parcel.readInt() == 1);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new c[i];
    }
}
