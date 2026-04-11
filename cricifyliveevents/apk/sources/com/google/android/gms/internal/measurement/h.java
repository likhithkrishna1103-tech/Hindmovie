package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements n, j {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f2466v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f2467w = new HashMap();

    public h(String str) {
        this.f2466v = str;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean a() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n b(String str) {
        HashMap map = this.f2467w;
        return map.containsKey(str) ? (n) map.get(str) : n.f2536b;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean c(String str) {
        return this.f2467w.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double d() {
        return Double.valueOf(Double.NaN);
    }

    public abstract n e(b6.f fVar, List list);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        String str = this.f2466v;
        if (str != null) {
            return str.equals(hVar.f2466v);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void f(String str, n nVar) {
        HashMap map = this.f2467w;
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator g() {
        return new i(this.f2467w.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n h(String str, b6.f fVar, ArrayList arrayList) {
        return "toString".equals(str) ? new q(this.f2466v) : q4.a.A(this, new q(str), fVar, arrayList);
    }

    public final int hashCode() {
        String str = this.f2466v;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return this.f2466v;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public n j() {
        return this;
    }
}
