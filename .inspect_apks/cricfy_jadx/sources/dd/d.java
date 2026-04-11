package dd;

import android.os.Parcel;
import android.os.Parcelable;
import cd.h;
import cd.l;
import ge.i;
import java.io.Serializable;
import java.util.Map;
import o8.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        i.e(parcel, "source");
        int i = parcel.readInt();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        if (string2 == null) {
            string2 = "";
        }
        String string3 = parcel.readString();
        String str = string3 != null ? string3 : "";
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        h.f2172w.getClass();
        h hVarJ = fc.e.j(i11);
        Serializable serializable = parcel.readSerializable();
        i.c(serializable, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Map map = (Map) serializable;
        long j4 = parcel.readLong();
        long j7 = parcel.readLong();
        int i12 = parcel.readInt();
        l.f2185w.getClass();
        l lVarH = jb.b.h(i12);
        int i13 = parcel.readInt();
        cd.b.f2150w.getClass();
        cd.b bVarG = jb.b.g(i13);
        int i14 = parcel.readInt();
        cd.g.f2167w.getClass();
        cd.g gVarJ = j.j(i14);
        long j10 = parcel.readLong();
        String string4 = parcel.readString();
        int i15 = parcel.readInt();
        cd.a.f2142w.getClass();
        cd.a aVarI = fc.e.i(i15);
        long j11 = parcel.readLong();
        boolean z10 = parcel.readInt() == 1;
        long j12 = parcel.readLong();
        long j13 = parcel.readLong();
        Serializable serializable2 = parcel.readSerializable();
        i.c(serializable2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        int i16 = parcel.readInt();
        int i17 = parcel.readInt();
        e eVar = new e();
        eVar.f3676v = i;
        eVar.f3677w = string;
        eVar.f3678x = string2;
        eVar.f3679y = str;
        eVar.f3680z = i10;
        eVar.A = hVarJ;
        eVar.B = map;
        eVar.C = j4;
        eVar.D = j7;
        eVar.E = lVarH;
        eVar.F = bVarG;
        eVar.G = gVarJ;
        eVar.H = j10;
        eVar.I = string4;
        eVar.J = aVarI;
        eVar.K = j11;
        eVar.L = z10;
        eVar.P = j12;
        eVar.Q = j13;
        eVar.M = new md.g((Map) serializable2);
        eVar.N = i16;
        eVar.O = i17;
        return eVar;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new e[i];
    }
}
