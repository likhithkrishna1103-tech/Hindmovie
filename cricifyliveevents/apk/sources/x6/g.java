package x6;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x3.b f14398e = new x3.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f14400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile byte[] f14402d;

    public g(String str, Object obj, f fVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f14401c = str;
        this.f14399a = obj;
        this.f14400b = fVar;
    }

    public static g a(Object obj, String str) {
        return new g(str, obj, f14398e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f14401c.equals(((g) obj).f14401c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f14401c.hashCode();
    }

    public final String toString() {
        return q4.a.q(new StringBuilder("Option{key='"), this.f14401c, "'}");
    }
}
