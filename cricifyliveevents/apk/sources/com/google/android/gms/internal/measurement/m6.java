package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m6 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Comparable f2530v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f2531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ l6 f2532x;

    public m6(l6 l6Var, Comparable comparable, Object obj) {
        this.f2532x = l6Var;
        this.f2530v = comparable;
        this.f2531w = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f2530v.compareTo(((m6) obj).f2530v);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f2530v;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f2531w;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f2530v;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f2531w;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f2530v;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f2531w;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f2532x.f();
        Object obj2 = this.f2531w;
        this.f2531w = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f2530v);
        String strValueOf2 = String.valueOf(this.f2531w);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        return sb.toString();
    }
}
