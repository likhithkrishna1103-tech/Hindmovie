package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p5 extends j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3150w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f3151x;

    public /* synthetic */ p5(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n a(ub.o oVar, List list) {
        TreeMap treeMap;
        switch (this.f3150w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c4.i(this.f3060u, 3, list);
                String strI = ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(0)).i();
                n nVar = (n) list.get(1);
                h4.z zVar = (h4.z) oVar.f12869w;
                long jA = (long) c4.a(zVar.l0(oVar, nVar).n().doubleValue());
                n nVarL0 = zVar.l0(oVar, (n) list.get(2));
                HashMap mapF = nVarL0 instanceof m ? c4.f((m) nVarL0) : new HashMap();
                a7.b bVar = (a7.b) this.f3151x;
                bVar.getClass();
                HashMap map = new HashMap();
                for (String str : mapF.keySet()) {
                    HashMap map2 = ((c) bVar.f618v).f2910c;
                    map.put(str, c.a(map2.containsKey(str) ? map2.get(str) : null, mapF.get(str), str));
                }
                ((ArrayList) bVar.f620x).add(new c(strI, jA, map));
                return n.f3106a;
            case 1:
                c4.i("getValue", 2, list);
                n nVarL02 = ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(0));
                n nVarL03 = ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(1));
                String strI2 = nVarL02.i();
                k4 k4Var = (k4) this.f3151x;
                Map map3 = (Map) ((k8.d1) k4Var.f3071v).f7134y.get((String) k4Var.f3070u);
                String str2 = (map3 == null || !map3.containsKey(strI2)) ? null : (String) map3.get(strI2);
                return str2 != null ? new p(str2) : nVarL03;
            case 2:
                return n.f3106a;
            case 3:
                c4.i(this.f3060u, 3, list);
                ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(0)).i();
                n nVar2 = (n) list.get(1);
                h4.z zVar2 = (h4.z) oVar.f12869w;
                n nVarL04 = zVar2.l0(oVar, nVar2);
                if (!(nVarL04 instanceof o)) {
                    throw new IllegalArgumentException("Invalid callback type");
                }
                n nVarL05 = zVar2.l0(oVar, (n) list.get(2));
                if (!(nVarL05 instanceof m)) {
                    throw new IllegalArgumentException("Invalid callback params");
                }
                m mVar = (m) nVarL05;
                HashMap map4 = mVar.f3093u;
                if (!map4.containsKey("type")) {
                    throw new IllegalArgumentException("Undefined rule type");
                }
                String strI3 = mVar.d("type").i();
                int iM = map4.containsKey("priority") ? c4.m(mVar.d("priority").n().doubleValue()) : 1000;
                k4 k4Var2 = (k4) this.f3151x;
                o oVar2 = (o) nVarL04;
                k4Var2.getClass();
                if ("create".equals(strI3)) {
                    treeMap = (TreeMap) k4Var2.f3071v;
                } else {
                    if (!"edit".equals(strI3)) {
                        throw new IllegalStateException(l4.a.m("Unknown callback type: ", strI3));
                    }
                    treeMap = (TreeMap) k4Var2.f3070u;
                }
                if (treeMap.containsKey(Integer.valueOf(iM))) {
                    iM = ((Integer) treeMap.lastKey()).intValue() + 1;
                }
                treeMap.put(Integer.valueOf(iM), oVar2);
                return n.f3106a;
            default:
                try {
                    return m4.b(((k8.c1) this.f3151x).call());
                } catch (Exception unused) {
                    return n.f3106a;
                }
        }
    }

    public p5(rc.b bVar) {
        super("internal.logger");
        this.f3151x = bVar;
        this.f3061v.put("log", new y9(this, false, true));
        this.f3061v.put("silent", new b("silent", 2));
        ((j) this.f3061v.get("silent")).h("log", new y9(this, true, true));
        this.f3061v.put("unmonitored", new b("unmonitored", 3));
        ((j) this.f3061v.get("unmonitored")).h("log", new y9(this, false, false));
    }

    public p5(k8.c1 c1Var) {
        super("internal.appMetadata");
        this.f3151x = c1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p5(k4 k4Var) {
        super("getValue");
        this.f3151x = k4Var;
    }

    public p5(a7.b bVar) {
        super("internal.eventLogger");
        this.f3151x = bVar;
    }
}
