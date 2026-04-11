package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13815a;

    public c1(String str) {
        this.f13815a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        return this.f13815a.equals(((c1) ((f2) obj)).f13815a);
    }

    public final int hashCode() {
        return this.f13815a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return l4.a.o(new StringBuilder("Log{content="), this.f13815a, "}");
    }
}
