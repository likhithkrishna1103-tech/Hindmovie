package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends rd.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final s f7731w = new s();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7732v;

    public t() {
        super(f7731w);
        this.f7732v = "Room Invalidation Tracker Refresh";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && be.h.a(this.f7732v, ((t) obj).f7732v);
    }

    public final int hashCode() {
        return this.f7732v.hashCode();
    }

    public final String toString() {
        return "CoroutineName(" + this.f7732v + ')';
    }
}
