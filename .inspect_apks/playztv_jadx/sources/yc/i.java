package yc;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;
import od.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        be.h.e(parcel, "input");
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        String str = string2 != null ? string2 : "";
        long j5 = parcel.readLong();
        int i = parcel.readInt();
        Serializable serializable = parcel.readSerializable();
        be.h.c(serializable, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Map map = (Map) serializable;
        int i10 = parcel.readInt();
        g.f14672v.getClass();
        g gVarF = va.e.f(i10);
        int i11 = parcel.readInt();
        f.f14666v.getClass();
        f fVarA = v8.c.a(i11);
        String string3 = parcel.readString();
        int i12 = parcel.readInt();
        a.f14640v.getClass();
        a aVarE = va.e.e(i12);
        boolean z2 = parcel.readInt() == 1;
        Serializable serializable2 = parcel.readSerializable();
        be.h.c(serializable2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Map map2 = (Map) serializable2;
        int i13 = parcel.readInt();
        j jVar = new j(string, str);
        jVar.f14681u = j5;
        jVar.f14682v = i;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            be.h.e(str2, "key");
            be.h.e(str3, "value");
            jVar.f14683w.put(str2, str3);
        }
        jVar.f14684x = gVarF;
        jVar.f14685y = fVarA;
        jVar.f14686z = string3;
        jVar.A = aVarE;
        jVar.B = z2;
        jVar.D = new id.g(t.J(map2));
        if (i13 < 0) {
            throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
        }
        jVar.C = i13;
        return jVar;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new j[i];
    }
}
