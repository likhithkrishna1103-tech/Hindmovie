package md;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ge.i.e(parcel, "source");
        b bVar = new b();
        bVar.f8419v = parcel.readInt();
        bVar.f8420w = parcel.readInt();
        bVar.f8421x = parcel.readLong();
        bVar.f8422y = parcel.readLong();
        bVar.f8423z = parcel.readLong();
        return bVar;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new b[i];
    }
}
