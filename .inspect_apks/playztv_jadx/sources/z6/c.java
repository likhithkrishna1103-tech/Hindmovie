package z6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14890a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f14890a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f14890a.equals(((c) obj).f14890a);
    }

    public final int hashCode() {
        return this.f14890a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return l4.a.o(new StringBuilder("Encoding{name=\""), this.f14890a, "\"}");
    }
}
