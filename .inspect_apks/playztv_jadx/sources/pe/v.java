package pe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements rd.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ThreadLocal f10405u;

    public v(ThreadLocal threadLocal) {
        this.f10405u = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && be.h.a(this.f10405u, ((v) obj).f10405u);
    }

    public final int hashCode() {
        return this.f10405u.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f10405u + ')';
    }
}
