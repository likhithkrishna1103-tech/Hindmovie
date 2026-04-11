package i8;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import k8.e4;
import k8.g2;
import k8.h1;
import k8.h4;
import k8.k1;
import k8.l2;
import k8.q;
import k8.v1;
import k8.v2;
import k8.w2;
import q9.e;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f6465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2 f6466b;

    public c(k1 k1Var) {
        v.h(k1Var);
        this.f6465a = k1Var;
        g2 g2Var = k1Var.J;
        k1.e(g2Var);
        this.f6466b = g2Var;
    }

    @Override // k8.s2
    public final void b(String str, String str2, Bundle bundle) {
        g2 g2Var = this.f6465a.J;
        k1.e(g2Var);
        g2Var.B1(str, str2, bundle);
    }

    @Override // k8.s2
    public final List c(String str, String str2) {
        g2 g2Var = this.f6466b;
        if (g2Var.x().A1()) {
            g2Var.g().A.d("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (e.n()) {
            g2Var.g().A.d("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        h1 h1Var = ((k1) g2Var.f2454v).D;
        k1.f(h1Var);
        h1Var.t1(atomicReference, 5000L, "get conditional user properties", new l2((Object) g2Var, (Object) atomicReference, str, str2, 1));
        List list = (List) atomicReference.get();
        if (list != null) {
            return h4.k2(list);
        }
        g2Var.g().A.c(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }

    @Override // k8.s2
    public final int d(String str) {
        v.d(str);
        return 25;
    }

    @Override // k8.s2
    public final void e(String str) {
        k1 k1Var = this.f6465a;
        q qVarK = k1Var.k();
        k1Var.H.getClass();
        qVarK.y1(str, SystemClock.elapsedRealtime());
    }

    @Override // k8.s2
    public final String f() {
        v2 v2Var = ((k1) this.f6466b.f2454v).I;
        k1.e(v2Var);
        w2 w2Var = v2Var.f7460x;
        if (w2Var != null) {
            return w2Var.f7527b;
        }
        return null;
    }

    @Override // k8.s2
    public final String g() {
        return (String) this.f6466b.B.get();
    }

    @Override // k8.s2
    public final void h(Bundle bundle) {
        g2 g2Var = this.f6466b;
        ((k1) g2Var.f2454v).H.getClass();
        g2Var.R1(bundle, System.currentTimeMillis());
    }

    @Override // k8.s2
    public final long i() {
        h4 h4Var = this.f6465a.F;
        k1.d(h4Var);
        return h4Var.z2();
    }

    @Override // k8.s2
    public final void j(String str) {
        k1 k1Var = this.f6465a;
        q qVarK = k1Var.k();
        k1Var.H.getClass();
        qVarK.v1(str, SystemClock.elapsedRealtime());
    }

    @Override // k8.s2
    public final Map k(String str, String str2, boolean z2) {
        g2 g2Var = this.f6466b;
        if (g2Var.x().A1()) {
            g2Var.g().A.d("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (e.n()) {
            g2Var.g().A.d("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        h1 h1Var = ((k1) g2Var.f2454v).D;
        k1.f(h1Var);
        h1Var.t1(atomicReference, 5000L, "get user properties", new v1(g2Var, atomicReference, str, str2, z2, 1));
        List<e4> list = (List) atomicReference.get();
        if (list == null) {
            g2Var.g().A.c(Boolean.valueOf(z2), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.EMPTY_MAP;
        }
        s.e eVar = new s.e(list.size());
        for (e4 e4Var : list) {
            Object objA = e4Var.a();
            if (objA != null) {
                eVar.put(e4Var.f7164v, objA);
            }
        }
        return eVar;
    }

    @Override // k8.s2
    public final String l() {
        v2 v2Var = ((k1) this.f6466b.f2454v).I;
        k1.e(v2Var);
        w2 w2Var = v2Var.f7460x;
        if (w2Var != null) {
            return w2Var.f7526a;
        }
        return null;
    }

    @Override // k8.s2
    public final void m(String str, String str2, Bundle bundle) {
        g2 g2Var = this.f6466b;
        ((k1) g2Var.f2454v).H.getClass();
        g2Var.C1(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    @Override // k8.s2
    public final String n() {
        return (String) this.f6466b.B.get();
    }
}
