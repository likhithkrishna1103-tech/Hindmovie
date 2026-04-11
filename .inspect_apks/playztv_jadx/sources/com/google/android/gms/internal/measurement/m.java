package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class m implements i, n {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap f3093u = new HashMap();

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean b() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final n d(String str) {
        HashMap map = this.f3093u;
        return map.containsKey(str) ? (n) map.get(str) : n.f3106a;
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final boolean e(String str) {
        return this.f3093u.containsKey(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            return this.f3093u.equals(((m) obj).f3093u);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator f() {
        return new k(this.f3093u.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.i
    public final void h(String str, n nVar) {
        HashMap map = this.f3093u;
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    public final int hashCode() {
        return this.f3093u.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return "[object Object]";
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        m mVar = new m();
        for (Map.Entry entry : this.f3093u.entrySet()) {
            boolean z2 = entry.getValue() instanceof i;
            HashMap map = mVar.f3093u;
            if (z2) {
                map.put((String) entry.getKey(), (n) entry.getValue());
            } else {
                map.put((String) entry.getKey(), ((n) entry.getValue()).j());
            }
        }
        return mVar;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public n l(String str, ub.o oVar, ArrayList arrayList) {
        return "toString".equals(str) ? new p(toString()) : g5.g(this, new p(str), oVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double n() {
        return Double.valueOf(Double.NaN);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        HashMap map = this.f3093u;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb2.append(String.format("%s: %s,", str, map.get(str)));
            }
            sb2.deleteCharAt(sb2.lastIndexOf(","));
        }
        sb2.append("}");
        return sb2.toString();
    }
}
