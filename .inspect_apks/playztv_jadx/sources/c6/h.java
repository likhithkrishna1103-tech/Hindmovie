package c6;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final pa.b f2516e = new pa.b(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f2518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile byte[] f2520d;

    public h(String str, Object obj, g gVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f2519c = str;
        this.f2517a = obj;
        this.f2518b = gVar;
    }

    public static h a(Object obj, String str) {
        return new h(str, obj, f2516e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f2519c.equals(((h) obj).f2519c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2519c.hashCode();
    }

    public final String toString() {
        return l4.a.o(new StringBuilder("Option{key='"), this.f2519c, "'}");
    }
}
