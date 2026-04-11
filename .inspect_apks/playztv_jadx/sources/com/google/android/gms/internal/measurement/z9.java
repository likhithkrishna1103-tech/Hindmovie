package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z9 extends j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x5 f3292w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f3293x;

    public z9(x5 x5Var) {
        super("require");
        this.f3293x = new HashMap();
        this.f3292w = x5Var;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n a(ub.o oVar, List list) {
        n nVar;
        c4.i("require", 1, list);
        String strI = ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(0)).i();
        HashMap map = this.f3293x;
        if (map.containsKey(strI)) {
            return (n) map.get(strI);
        }
        HashMap map2 = (HashMap) this.f3292w.f3235a;
        if (map2.containsKey(strI)) {
            try {
                nVar = (n) ((Callable) map2.get(strI)).call();
            } catch (Exception unused) {
                throw new IllegalStateException(l4.a.m("Failed to create API implementation: ", strI));
            }
        } else {
            nVar = n.f3106a;
        }
        if (nVar instanceof j) {
            map.put(strI, (j) nVar);
        }
        return nVar;
    }
}
