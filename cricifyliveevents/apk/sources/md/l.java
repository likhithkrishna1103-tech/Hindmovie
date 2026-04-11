package md;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ge.i.e(parcel, "source");
        Serializable serializable = parcel.readSerializable();
        ge.i.c(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
        return new m(s.D((HashMap) serializable));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new m[i];
    }
}
