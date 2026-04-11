package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c2.f f2911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f2912b = {1, 2, 3, 4, 5, 6, 7};

    public static double a(double d10) {
        if (Double.isNaN(d10)) {
            return 0.0d;
        }
        if (Double.isInfinite(d10) || d10 == 0.0d || d10 == -0.0d) {
            return d10;
        }
        return Math.floor(Math.abs(d10)) * ((double) (d10 > 0.0d ? 1 : -1));
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static g0 d(String str) {
        g0 g0Var;
        if (str == null || str.isEmpty()) {
            g0Var = null;
        } else {
            g0Var = (g0) g0.F0.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (g0Var != null) {
            return g0Var;
        }
        throw new IllegalArgumentException(l4.a.m("Unsupported commandId ", str));
    }

    public static Object e(n nVar) {
        if (n.f3107b.equals(nVar)) {
            return null;
        }
        if (n.f3106a.equals(nVar)) {
            return "";
        }
        if (nVar instanceof m) {
            return f((m) nVar);
        }
        if (!(nVar instanceof e)) {
            return !nVar.n().isNaN() ? nVar.n() : nVar.i();
        }
        ArrayList arrayList = new ArrayList();
        e eVar = (e) nVar;
        int i = 0;
        while (i < eVar.t()) {
            if (i >= eVar.t()) {
                throw new NoSuchElementException(e6.j.l("Out of bounds index: ", i));
            }
            int i10 = i + 1;
            Object objE = e(eVar.r(i));
            if (objE != null) {
                arrayList.add(objE);
            }
            i = i10;
        }
        return arrayList;
    }

    public static HashMap f(m mVar) {
        HashMap map = new HashMap();
        mVar.getClass();
        ArrayList arrayList = new ArrayList(mVar.f3093u.keySet());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            Object objE = e(mVar.d(str));
            if (objE != null) {
                map.put(str, objE);
            }
        }
        return map;
    }

    public static synchronized void g(c2.f fVar) {
        if (f2911a != null) {
            throw new IllegalStateException("init() already called");
        }
        f2911a = fVar;
    }

    public static void h(g0 g0Var, int i, List list) {
        i(g0Var.name(), i, list);
    }

    public static void i(String str, int i, List list) {
        if (list.size() == i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires " + i + " parameters found " + list.size());
    }

    public static void j(ub.o oVar) {
        int iM = m(oVar.Z("runtime.counter").n().doubleValue() + 1.0d);
        if (iM > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        oVar.f0("runtime.counter", new g(Double.valueOf(iM)));
    }

    public static boolean k(byte b10) {
        return b10 > -65;
    }

    public static boolean l(n nVar, n nVar2) {
        if (!nVar.getClass().equals(nVar2.getClass())) {
            return false;
        }
        if ((nVar instanceof t) || (nVar instanceof l)) {
            return true;
        }
        if (!(nVar instanceof g)) {
            return nVar instanceof p ? nVar.i().equals(nVar2.i()) : nVar instanceof f ? nVar.b().equals(nVar2.b()) : nVar == nVar2;
        }
        if (Double.isNaN(nVar.n().doubleValue()) || Double.isNaN(nVar2.n().doubleValue())) {
            return false;
        }
        return nVar.n().equals(nVar2.n());
    }

    public static int m(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10) || d10 == 0.0d) {
            return 0;
        }
        return (int) ((Math.floor(Math.abs(d10)) * ((double) (d10 > 0.0d ? 1 : -1))) % 4.294967296E9d);
    }

    public static void n(g0 g0Var, int i, List list) {
        o(g0Var.name(), i, list);
    }

    public static void o(String str, int i, List list) {
        if (list.size() >= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at least " + i + " parameters found " + list.size());
    }

    public static boolean p(n nVar) {
        if (nVar == null) {
            return false;
        }
        Double dN = nVar.n();
        return !dN.isNaN() && dN.doubleValue() >= 0.0d && dN.equals(Double.valueOf(Math.floor(dN.doubleValue())));
    }

    public static void q(String str, int i, ArrayList arrayList) {
        if (arrayList.size() <= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at most " + i + " parameters found " + arrayList.size());
    }
}
