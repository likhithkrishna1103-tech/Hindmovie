package com.google.android.gms.internal.measurement;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ua.m0 f2322d = ua.m0.j(3, "_syn", "_err", "_el");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f2325c;

    public b(String str, long j4, HashMap map) {
        this.f2323a = str;
        this.f2324b = j4;
        HashMap map2 = new HashMap();
        this.f2325c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public static Object b(Object obj, Object obj2, String str) {
        if (f2322d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else if (!(obj instanceof Double)) {
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final b clone() {
        return new b(this.f2323a, this.f2324b, new HashMap(this.f2325c));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2324b == bVar.f2324b && this.f2323a.equals(bVar.f2323a)) {
            return this.f2325c.equals(bVar.f2325c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f2323a.hashCode() * 31;
        long j4 = this.f2324b;
        return this.f2325c.hashCode() + ((iHashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31);
    }

    public final String toString() {
        String str = this.f2323a;
        String string = this.f2325c.toString();
        int length = String.valueOf(str).length();
        long j4 = this.f2324b;
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(j4).length() + 9 + string.length() + 1);
        sb.append("Event{name='");
        sb.append(str);
        sb.append("', timestamp=");
        sb.append(j4);
        sb.append(", params=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
