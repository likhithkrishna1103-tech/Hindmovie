package w8;

import a9.j;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends a9.a {
    public final v8.a N(v8.b bVar, String str, int i) {
        Parcel parcelF = f();
        j.b(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        Parcel parcelB = b(parcelF, 2);
        v8.a aVarM = v8.b.M(parcelB.readStrongBinder());
        parcelB.recycle();
        return aVarM;
    }

    public final v8.a O(v8.b bVar, String str, int i) {
        Parcel parcelF = f();
        j.b(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        Parcel parcelB = b(parcelF, 4);
        v8.a aVarM = v8.b.M(parcelB.readStrongBinder());
        parcelB.recycle();
        return aVarM;
    }

    public final v8.a P(v8.b bVar, String str, boolean z10, long j4) {
        Parcel parcelF = f();
        j.b(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(z10 ? 1 : 0);
        parcelF.writeLong(j4);
        Parcel parcelB = b(parcelF, 7);
        v8.a aVarM = v8.b.M(parcelB.readStrongBinder());
        parcelB.recycle();
        return aVarM;
    }

    public final v8.a Q(v8.b bVar, String str, int i, v8.b bVar2) {
        Parcel parcelF = f();
        j.b(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        j.b(parcelF, bVar2);
        Parcel parcelB = b(parcelF, 8);
        v8.a aVarM = v8.b.M(parcelB.readStrongBinder());
        parcelB.recycle();
        return aVarM;
    }
}
