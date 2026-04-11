package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k4 extends h {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f2508x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f2509y;

    public k4(androidx.emoji2.text.v vVar) {
        super("internal.eventLogger");
        this.f2509y = vVar;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n e(b6.f fVar, List list) {
        TreeMap treeMap;
        switch (this.f2508x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n5.a.R(this.f2466v, 3, list);
                String strI = ((t) fVar.f1801x).c(fVar, (n) list.get(0)).i();
                n nVar = (n) list.get(1);
                t tVar = (t) fVar.f1801x;
                long jZ = (long) n5.a.Z(tVar.c(fVar, nVar).d().doubleValue());
                n nVarC = tVar.c(fVar, (n) list.get(2));
                HashMap mapB0 = nVarC instanceof k ? n5.a.b0((k) nVarC) : new HashMap();
                androidx.emoji2.text.v vVar = (androidx.emoji2.text.v) this.f2509y;
                vVar.getClass();
                HashMap map = new HashMap();
                for (String str : mapB0.keySet()) {
                    HashMap map2 = ((b) vVar.f888w).f2325c;
                    map.put(str, b.b(map2.containsKey(str) ? map2.get(str) : null, mapB0.get(str), str));
                }
                ((ArrayList) vVar.f890y).add(new b(strI, jZ, map));
                return n.f2536b;
            case 1:
                n5.a.R("getValue", 2, list);
                n nVarC2 = ((t) fVar.f1801x).c(fVar, (n) list.get(0));
                n nVarC3 = ((t) fVar.f1801x).c(fVar, (n) list.get(1));
                String strI2 = nVarC2.i();
                l4.c0 c0Var = (l4.c0) this.f2509y;
                Map map3 = (Map) ((f9.l1) c0Var.f7706x).f4262z.get((String) c0Var.f7705w);
                String str2 = (map3 == null || !map3.containsKey(strI2)) ? null : (String) map3.get(strI2);
                return str2 != null ? new q(str2) : nVarC3;
            case 2:
                return n.f2536b;
            case 3:
                try {
                    return qb.t1.u(((f9.j1) this.f2509y).call());
                } catch (Exception unused) {
                    return n.f2536b;
                }
            default:
                n5.a.R(this.f2466v, 3, list);
                ((t) fVar.f1801x).c(fVar, (n) list.get(0)).i();
                n nVar2 = (n) list.get(1);
                t tVar2 = (t) fVar.f1801x;
                n nVarC4 = tVar2.c(fVar, nVar2);
                if (!(nVarC4 instanceof m)) {
                    throw new IllegalArgumentException("Invalid callback type");
                }
                n nVarC5 = tVar2.c(fVar, (n) list.get(2));
                if (!(nVarC5 instanceof k)) {
                    throw new IllegalArgumentException("Invalid callback params");
                }
                k kVar = (k) nVarC5;
                HashMap map4 = kVar.f2501v;
                if (!map4.containsKey("type")) {
                    throw new IllegalArgumentException("Undefined rule type");
                }
                String strI3 = kVar.b("type").i();
                int iY = map4.containsKey("priority") ? n5.a.Y(kVar.b("priority").d().doubleValue()) : 1000;
                t tVar3 = (t) this.f2509y;
                m mVar = (m) nVarC4;
                tVar3.getClass();
                if ("create".equals(strI3)) {
                    treeMap = (TreeMap) tVar3.f2630b;
                } else {
                    if (!"edit".equals(strI3)) {
                        throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(strI3)));
                    }
                    treeMap = (TreeMap) tVar3.f2629a;
                }
                if (treeMap.containsKey(Integer.valueOf(iY))) {
                    iY = ((Integer) treeMap.lastKey()).intValue() + 1;
                }
                treeMap.put(Integer.valueOf(iY), mVar);
                return n.f2536b;
        }
    }

    public k4(t tVar) {
        super("internal.registerCallback");
        this.f2509y = tVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k4(u5 u5Var, l4.c0 c0Var) {
        super("getValue");
        this.f2509y = c0Var;
    }

    public k4(f9.j1 j1Var) {
        super("internal.appMetadata");
        this.f2509y = j1Var;
    }

    public k4(p6.d dVar) {
        super("internal.logger");
        this.f2509y = dVar;
        this.f2467w.put("log", new u9(this, false, true));
        this.f2467w.put("silent", new u5(1, "silent"));
        ((h) this.f2467w.get("silent")).f("log", new u9(this, true, true));
        this.f2467w.put("unmonitored", new u5(2, "unmonitored"));
        ((h) this.f2467w.get("unmonitored")).f("log", new u9(this, false, false));
    }
}
