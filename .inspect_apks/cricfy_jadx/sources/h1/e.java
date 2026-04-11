package h1;

import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5477a;

    public e(String str) {
        i.e(str, "name");
        this.f5477a = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        return i.a(this.f5477a, ((e) obj).f5477a);
    }

    public final int hashCode() {
        return this.f5477a.hashCode();
    }

    public final String toString() {
        return this.f5477a;
    }
}
