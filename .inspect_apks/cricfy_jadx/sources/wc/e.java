package wc;

import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14142a;

    public e(String str) {
        i.e(str, "sessionId");
        this.f14142a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && i.a(this.f14142a, ((e) obj).f14142a);
    }

    public final int hashCode() {
        return this.f14142a.hashCode();
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f14142a + ')';
    }
}
