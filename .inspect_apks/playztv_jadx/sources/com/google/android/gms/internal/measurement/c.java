package com.google.android.gms.internal.measurement;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final aa.o0 f2907d = aa.o0.n(3, "_syn", "_err", "_el");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f2910c;

    public c(String str, long j5, HashMap map) {
        this.f2908a = str;
        this.f2909b = j5;
        HashMap map2 = new HashMap();
        this.f2910c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public static Object a(Object obj, Object obj2, String str) {
        if (f2907d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else {
            if (obj instanceof Double) {
                return obj2;
            }
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    public final /* synthetic */ Object clone() {
        return new c(this.f2908a, this.f2909b, new HashMap(this.f2910c));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2909b == cVar.f2909b && this.f2908a.equals(cVar.f2908a)) {
            return this.f2910c.equals(cVar.f2910c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f2908a.hashCode() * 31;
        long j5 = this.f2909b;
        return this.f2910c.hashCode() + ((iHashCode + ((int) (j5 ^ (j5 >>> 32)))) * 31);
    }

    public final String toString() {
        return "Event{name='" + this.f2908a + "', timestamp=" + this.f2909b + ", params=" + String.valueOf(this.f2910c) + "}";
    }
}
