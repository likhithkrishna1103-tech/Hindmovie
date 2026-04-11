package w8;

import a9.j;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends a9.a {
    public final v8.a N(v8.b bVar, String str, int i, v8.b bVar2) {
        Parcel parcelF = f();
        j.b(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        j.b(parcelF, bVar2);
        Parcel parcelB = b(parcelF, 2);
        v8.a aVarM = v8.b.M(parcelB.readStrongBinder());
        parcelB.recycle();
        return aVarM;
    }

    public final v8.a O(v8.b bVar, String str, int i, v8.b bVar2) {
        Parcel parcelF = f();
        j.b(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        j.b(parcelF, bVar2);
        Parcel parcelB = b(parcelF, 3);
        v8.a aVarM = v8.b.M(parcelB.readStrongBinder());
        parcelB.recycle();
        return aVarM;
    }
}
