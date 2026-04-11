package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3185a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3186b;

    public s(int i) {
        this.f3186b = i;
    }

    public static n a(c0 c0Var, Iterator it, n nVar) {
        if (it != null) {
            while (it.hasNext()) {
                n nVarX = c0Var.w((n) it.next()).X((e) nVar);
                if (nVarX instanceof h) {
                    h hVar = (h) nVarX;
                    String str = hVar.f3032v;
                    if ("break".equals(str)) {
                        return n.f3106a;
                    }
                    if ("return".equals(str)) {
                        return hVar;
                    }
                }
            }
        }
        return n.f3106a;
    }

    public static o b(ub.o oVar, List list) {
        c4.n(g0.S, 2, list);
        n nVarL0 = ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(0));
        n nVarL02 = ((h4.z) oVar.f12869w).l0(oVar, (n) list.get(1));
        if (!(nVarL02 instanceof e)) {
            throw new IllegalArgumentException(l4.a.m("FN requires an ArrayValue of parameter names found ", nVarL02.getClass().getCanonicalName()));
        }
        ArrayList arrayListZ = ((e) nVarL02).z();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new o(nVarL0.i(), arrayListZ, arrayList, oVar);
    }

    public static boolean d(n nVar, n nVar2) {
        n gVar;
        n gVar2;
        while (!nVar.getClass().equals(nVar2.getClass())) {
            if (((nVar instanceof t) || (nVar instanceof l)) && ((nVar2 instanceof t) || (nVar2 instanceof l))) {
                return true;
            }
            boolean z2 = nVar instanceof g;
            if (z2 && (nVar2 instanceof p)) {
                gVar2 = new g(nVar2.n());
            } else {
                boolean z10 = nVar instanceof p;
                if (z10 && (nVar2 instanceof g)) {
                    gVar = new g(nVar.n());
                } else if (nVar instanceof f) {
                    gVar = new g(nVar.n());
                } else if (nVar2 instanceof f) {
                    gVar2 = new g(nVar2.n());
                } else if ((z10 || z2) && (nVar2 instanceof i)) {
                    gVar2 = new p(nVar2.i());
                } else {
                    if (!(nVar instanceof i) || (!(nVar2 instanceof p) && !(nVar2 instanceof g))) {
                        return false;
                    }
                    gVar = new p(nVar.i());
                }
                nVar = gVar;
            }
            nVar2 = gVar2;
        }
        if ((nVar instanceof t) || (nVar instanceof l)) {
            return true;
        }
        return nVar instanceof g ? (Double.isNaN(nVar.n().doubleValue()) || Double.isNaN(nVar2.n().doubleValue()) || nVar.n().doubleValue() != nVar2.n().doubleValue()) ? false : true : nVar instanceof p ? nVar.i().equals(nVar2.i()) : nVar instanceof f ? nVar.b().equals(nVar2.b()) : nVar == nVar2;
    }

    public static n e(c0 c0Var, n nVar, n nVar2) {
        if (nVar instanceof Iterable) {
            return a(c0Var, ((Iterable) nVar).iterator(), nVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    public static boolean f(n nVar, n nVar2) {
        if (nVar instanceof i) {
            nVar = new p(nVar.i());
        }
        if (nVar2 instanceof i) {
            nVar2 = new p(nVar2.i());
        }
        if ((nVar instanceof p) && (nVar2 instanceof p)) {
            return ((p) nVar).f3145u.compareTo(((p) nVar2).f3145u) < 0;
        }
        double dDoubleValue = nVar.n().doubleValue();
        double dDoubleValue2 = nVar2.n().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == -0.0d) || ((dDoubleValue == -0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static boolean g(n nVar, n nVar2) {
        if (nVar instanceof i) {
            nVar = new p(nVar.i());
        }
        if (nVar2 instanceof i) {
            nVar2 = new p(nVar2.i());
        }
        return (((nVar instanceof p) && (nVar2 instanceof p)) || !(Double.isNaN(nVar.n().doubleValue()) || Double.isNaN(nVar2.n().doubleValue()))) && !f(nVar2, nVar);
    }

    public final void c(String str) {
        if (!this.f3185a.contains(c4.d(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException(l4.a.m("Command not implemented: ", str));
    }
}
