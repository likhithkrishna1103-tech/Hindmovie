package b8;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.f0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends f0 {
    public final a8.a I(a8.b bVar, String str, int i) {
        Parcel parcelF = f();
        f8.a.c(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        Parcel parcelE = e(parcelF, 2);
        a8.a aVarH = a8.b.H(parcelE.readStrongBinder());
        parcelE.recycle();
        return aVarH;
    }

    public final a8.a J(a8.b bVar, String str, int i, a8.b bVar2) {
        Parcel parcelF = f();
        f8.a.c(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        f8.a.c(parcelF, bVar2);
        Parcel parcelE = e(parcelF, 8);
        a8.a aVarH = a8.b.H(parcelE.readStrongBinder());
        parcelE.recycle();
        return aVarH;
    }

    public final a8.a K(a8.b bVar, String str, int i) {
        Parcel parcelF = f();
        f8.a.c(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(i);
        Parcel parcelE = e(parcelF, 4);
        a8.a aVarH = a8.b.H(parcelE.readStrongBinder());
        parcelE.recycle();
        return aVarH;
    }

    public final a8.a L(a8.b bVar, String str, boolean z2, long j5) {
        Parcel parcelF = f();
        f8.a.c(parcelF, bVar);
        parcelF.writeString(str);
        parcelF.writeInt(z2 ? 1 : 0);
        parcelF.writeLong(j5);
        Parcel parcelE = e(parcelF, 7);
        a8.a aVarH = a8.b.H(parcelE.readStrongBinder());
        parcelE.recycle();
        return aVarH;
    }
}
