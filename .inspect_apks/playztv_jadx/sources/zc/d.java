package zc;

import android.os.Parcel;
import android.os.Parcelable;
import be.h;
import java.io.Serializable;
import java.util.Map;
import yc.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        h.e(parcel, "source");
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
        yc.g.f14672v.getClass();
        yc.g gVarF = va.e.f(i11);
        Serializable serializable = parcel.readSerializable();
        h.c(serializable, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Map map = (Map) serializable;
        long j5 = parcel.readLong();
        long j8 = parcel.readLong();
        int i12 = parcel.readInt();
        k.f14687v.getClass();
        k kVarB = w2.f.b(i12);
        int i13 = parcel.readInt();
        yc.b.f14648v.getClass();
        yc.b bVarA = w2.f.a(i13);
        int i14 = parcel.readInt();
        yc.f.f14666v.getClass();
        yc.f fVarA = v8.c.a(i14);
        long j10 = parcel.readLong();
        String string4 = parcel.readString();
        int i15 = parcel.readInt();
        yc.a.f14640v.getClass();
        yc.a aVarE = va.e.e(i15);
        long j11 = parcel.readLong();
        boolean z2 = parcel.readInt() == 1;
        long j12 = parcel.readLong();
        long j13 = parcel.readLong();
        Serializable serializable2 = parcel.readSerializable();
        h.c(serializable2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        int i16 = parcel.readInt();
        int i17 = parcel.readInt();
        e eVar = new e();
        eVar.f14950u = i;
        eVar.f14951v = string;
        eVar.f14952w = string2;
        eVar.f14953x = str;
        eVar.f14954y = i10;
        eVar.f14955z = gVarF;
        eVar.A = map;
        eVar.B = j5;
        eVar.C = j8;
        eVar.D = kVarB;
        eVar.E = bVarA;
        eVar.F = fVarA;
        eVar.G = j10;
        eVar.H = string4;
        eVar.I = aVarE;
        eVar.J = j11;
        eVar.K = z2;
        eVar.O = j12;
        eVar.P = j13;
        eVar.L = new id.g((Map) serializable2);
        eVar.M = i16;
        eVar.N = i17;
        return eVar;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new e[i];
    }
}
