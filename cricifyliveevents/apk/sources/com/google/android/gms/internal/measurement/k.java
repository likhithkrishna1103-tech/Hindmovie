package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class k implements n, j {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f2501v = new HashMap();

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean a() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n b(String str) {
        HashMap map = this.f2501v;
        return map.containsKey(str) ? (n) map.get(str) : n.f2536b;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean c(String str) {
        return this.f2501v.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double d() {
        return Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return this.f2501v.equals(((k) obj).f2501v);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void f(String str, n nVar) {
        HashMap map = this.f2501v;
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator g() {
        return new i(this.f2501v.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.n
    public n h(String str, b6.f fVar, ArrayList arrayList) {
        return "toString".equals(str) ? new q(toString()) : q4.a.A(this, new q(str), fVar, arrayList);
    }

    public final int hashCode() {
        return this.f2501v.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return "[object Object]";
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        k kVar = new k();
        for (Map.Entry entry : this.f2501v.entrySet()) {
            boolean z10 = entry.getValue() instanceof j;
            HashMap map = kVar.f2501v;
            if (z10) {
                map.put((String) entry.getKey(), (n) entry.getValue());
            } else {
                map.put((String) entry.getKey(), ((n) entry.getValue()).j());
            }
        }
        return kVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        HashMap map = this.f2501v;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(String.format("%s: %s,", str, map.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
