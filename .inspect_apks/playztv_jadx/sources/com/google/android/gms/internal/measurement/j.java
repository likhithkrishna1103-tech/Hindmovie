package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements i, n {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f3060u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f3061v = new HashMap();

    public j(String str) {
        this.f3060u = str;
    }

    public abstract n a(ub.o oVar, List list);

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean b() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final n d(String str) {
        HashMap map = this.f3061v;
        return map.containsKey(str) ? (n) map.get(str) : n.f3106a;
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final boolean e(String str) {
        return this.f3061v.containsKey(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        String str = this.f3060u;
        if (str != null) {
            return str.equals(jVar.f3060u);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator f() {
        return new k(this.f3061v.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final void h(String str, n nVar) {
        HashMap map = this.f3061v;
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    public final int hashCode() {
        String str = this.f3060u;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return this.f3060u;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l(String str, ub.o oVar, ArrayList arrayList) {
        return "toString".equals(str) ? new p(this.f3060u) : g5.g(this, new p(str), oVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double n() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public n j() {
        return this;
    }
}
