package cd;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ge.i.e(parcel, "input");
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        String str = string2 != null ? string2 : "";
        long j4 = parcel.readLong();
        int i = parcel.readInt();
        Serializable serializable = parcel.readSerializable();
        ge.i.c(serializable, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Map map = (Map) serializable;
        int i10 = parcel.readInt();
        h.f2172w.getClass();
        h hVarJ = fc.e.j(i10);
        int i11 = parcel.readInt();
        g.f2167w.getClass();
        g gVarJ = o8.j.j(i11);
        String string3 = parcel.readString();
        int i12 = parcel.readInt();
        a.f2142w.getClass();
        a aVarI = fc.e.i(i12);
        boolean z10 = parcel.readInt() == 1;
        Serializable serializable2 = parcel.readSerializable();
        ge.i.c(serializable2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Map map2 = (Map) serializable2;
        int i13 = parcel.readInt();
        k kVar = new k(string, str);
        kVar.f2180v = j4;
        kVar.f2181w = i;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            ge.i.e(str2, "key");
            ge.i.e(str3, "value");
            kVar.f2182x.put(str2, str3);
        }
        kVar.f2183y = hVarJ;
        kVar.f2184z = gVarJ;
        kVar.A = string3;
        kVar.B = aVarI;
        kVar.C = z10;
        kVar.E = new md.g(s.C(map2));
        if (i13 < 0) {
            throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
        }
        kVar.D = i13;
        return kVar;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new k[i];
    }
}
