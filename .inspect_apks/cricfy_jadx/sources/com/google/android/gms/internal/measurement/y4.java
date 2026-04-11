package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y4 extends k {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final androidx.emoji2.text.v f2734w;

    public y4(androidx.emoji2.text.v vVar) {
        this.f2734w = vVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.measurement.k, com.google.android.gms.internal.measurement.n
    public final n h(String str, b6.f fVar, ArrayList arrayList) {
        int iHashCode = str.hashCode();
        androidx.emoji2.text.v vVar = this.f2734w;
        switch (iHashCode) {
            case 21624207:
                if (str.equals("getEventName")) {
                    n5.a.R("getEventName", 0, arrayList);
                    return new q(((b) vVar.f889x).f2323a);
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    n5.a.R("getTimestamp", 0, arrayList);
                    return new g(Double.valueOf(((b) vVar.f889x).f2324b));
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    n5.a.R("getParamValue", 1, arrayList);
                    String strI = ((t) fVar.f1801x).c(fVar, (n) arrayList.get(0)).i();
                    HashMap map = ((b) vVar.f889x).f2325c;
                    return qb.t1.u(map.containsKey(strI) ? map.get(strI) : null);
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    n5.a.R("getParams", 0, arrayList);
                    HashMap map2 = ((b) vVar.f889x).f2325c;
                    k kVar = new k();
                    for (String str2 : map2.keySet()) {
                        kVar.f(str2, qb.t1.u(map2.get(str2)));
                    }
                    return kVar;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    n5.a.R("setParamValue", 2, arrayList);
                    String strI2 = ((t) fVar.f1801x).c(fVar, (n) arrayList.get(0)).i();
                    n nVarC = ((t) fVar.f1801x).c(fVar, (n) arrayList.get(1));
                    b bVar = (b) vVar.f889x;
                    Object objA0 = n5.a.a0(nVarC);
                    HashMap map3 = bVar.f2325c;
                    if (objA0 == null) {
                        map3.remove(strI2);
                        return nVarC;
                    }
                    map3.put(strI2, b.b(map3.get(strI2), objA0, strI2));
                    return nVarC;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    n5.a.R("setEventName", 1, arrayList);
                    n nVarC2 = ((t) fVar.f1801x).c(fVar, (n) arrayList.get(0));
                    if (n.f2536b.equals(nVarC2) || n.f2537c.equals(nVarC2)) {
                        throw new IllegalArgumentException("Illegal event name");
                    }
                    ((b) vVar.f889x).f2323a = nVarC2.i();
                    return new q(nVarC2.i());
                }
                break;
        }
        return super.h(str, fVar, arrayList);
    }
}
