package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r6 extends m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a7.b f3180v;

    public r6(a7.b bVar) {
        this.f3180v = bVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.measurement.m, com.google.android.gms.internal.measurement.n
    public final n l(String str, ub.o oVar, ArrayList arrayList) {
        byte b10 = -1;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    b10 = 0;
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    b10 = 1;
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    b10 = 2;
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    b10 = 3;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    b10 = 4;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    b10 = 5;
                }
                break;
        }
        a7.b bVar = this.f3180v;
        switch (b10) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c4.i("getEventName", 0, arrayList);
                return new p(((c) bVar.f619w).f2908a);
            case 1:
                c4.i("getTimestamp", 0, arrayList);
                return new g(Double.valueOf(((c) bVar.f619w).f2909b));
            case 2:
                c4.i("getParamValue", 1, arrayList);
                String strI = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i();
                HashMap map = ((c) bVar.f619w).f2910c;
                return m4.b(map.containsKey(strI) ? map.get(strI) : null);
            case 3:
                c4.i("getParams", 0, arrayList);
                HashMap map2 = ((c) bVar.f619w).f2910c;
                m mVar = new m();
                for (String str2 : map2.keySet()) {
                    mVar.h(str2, m4.b(map2.get(str2)));
                }
                return mVar;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                c4.i("setParamValue", 2, arrayList);
                String strI2 = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i();
                n nVarL0 = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(1));
                c cVar = (c) bVar.f619w;
                Object objE = c4.e(nVarL0);
                HashMap map3 = cVar.f2910c;
                if (objE == null) {
                    map3.remove(strI2);
                    return nVarL0;
                }
                map3.put(strI2, c.a(map3.get(strI2), objE, strI2));
                return nVarL0;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                c4.i("setEventName", 1, arrayList);
                n nVarL02 = ((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0));
                if (n.f3106a.equals(nVarL02) || n.f3107b.equals(nVarL02)) {
                    throw new IllegalArgumentException("Illegal event name");
                }
                ((c) bVar.f619w).f2908a = nVarL02.i();
                return new p(nVarL02.i());
            default:
                return super.l(str, oVar, arrayList);
        }
    }
}
