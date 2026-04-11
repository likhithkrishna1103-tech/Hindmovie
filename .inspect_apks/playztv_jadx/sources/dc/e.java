package dc;

import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4128a;

    public e(String str) {
        this.f4128a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && h.a(this.f4128a, ((e) obj).f4128a);
    }

    public final int hashCode() {
        return this.f4128a.hashCode();
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f4128a + ')';
    }
}
