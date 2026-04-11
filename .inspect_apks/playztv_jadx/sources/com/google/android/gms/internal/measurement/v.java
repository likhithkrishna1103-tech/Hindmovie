package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ub.o f3213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ub.o f3214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a7.b f3215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k4 f3216d;

    public v() {
        ub.o oVar = new ub.o(8);
        this.f3213a = oVar;
        this.f3214b = ((ub.o) oVar.f12869w).b0();
        a7.b bVar = new a7.b(9, false);
        bVar.f618v = new c("", 0L, null);
        bVar.f619w = new c("", 0L, null);
        bVar.f620x = new ArrayList();
        this.f3215c = bVar;
        this.f3216d = new k4(8);
        a aVar = new a(0);
        aVar.f2876b = this;
        x5 x5Var = (x5) oVar.f12871y;
        ((HashMap) x5Var.f3235a).put("internal.registerCallback", aVar);
        a aVar2 = new a(1);
        aVar2.f2876b = this;
        ((HashMap) x5Var.f3235a).put("internal.eventLogger", aVar2);
    }

    public final void a(x3 x3Var) {
        j jVar;
        ub.o oVar = this.f3213a;
        try {
            this.f3214b = ((ub.o) oVar.f12869w).b0();
            if (oVar.a0(this.f3214b, (y3[]) x3Var.o().toArray(new y3[0])) instanceof h) {
                throw new IllegalStateException("Program loading failed");
            }
            for (w3 w3Var : x3Var.n().p()) {
                s5 s5VarO = w3Var.o();
                String strN = w3Var.n();
                Iterator it = s5VarO.iterator();
                while (it.hasNext()) {
                    n nVarA0 = oVar.a0(this.f3214b, (y3) it.next());
                    if (!(nVarA0 instanceof m)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    ub.o oVar2 = this.f3214b;
                    if (oVar2.e0(strN)) {
                        n nVarZ = oVar2.Z(strN);
                        if (!(nVarZ instanceof j)) {
                            throw new IllegalStateException("Invalid function name: " + strN);
                        }
                        jVar = (j) nVarZ;
                    } else {
                        jVar = null;
                    }
                    if (jVar == null) {
                        throw new IllegalStateException("Rule function is undefined: " + strN);
                    }
                    jVar.a(this.f3214b, Collections.singletonList(nVarA0));
                }
            }
        } catch (Throwable th) {
            throw new l0(th);
        }
    }

    public final boolean b(c cVar) {
        a7.b bVar = this.f3215c;
        try {
            bVar.f618v = cVar;
            bVar.f619w = (c) cVar.clone();
            ((ArrayList) bVar.f620x).clear();
            ((ub.o) this.f3213a.f12870x).f0("runtime.counter", new g(Double.valueOf(0.0d)));
            this.f3216d.E(this.f3214b.b0(), bVar);
            if (((c) bVar.f619w).equals((c) bVar.f618v)) {
                return !((ArrayList) bVar.f620x).isEmpty();
            }
            return true;
        } catch (Throwable th) {
            throw new l0(th);
        }
    }
}
