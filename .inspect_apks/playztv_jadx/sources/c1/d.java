package c1;

import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2235a;

    public d(String str) {
        this.f2235a = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        return h.a(this.f2235a, ((d) obj).f2235a);
    }

    public final int hashCode() {
        return this.f2235a.hashCode();
    }

    public final String toString() {
        return this.f2235a;
    }
}
