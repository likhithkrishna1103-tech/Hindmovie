package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13918a;

    public j1(String str) {
        this.f13918a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        return this.f13918a.equals(((j1) ((l2) obj)).f13918a);
    }

    public final int hashCode() {
        return this.f13918a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return l4.a.o(new StringBuilder("User{identifier="), this.f13918a, "}");
    }
}
