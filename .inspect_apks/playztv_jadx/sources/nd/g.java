package nd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Throwable f8985u;

    public g(Throwable th) {
        be.h.e(th, "exception");
        this.f8985u = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return be.h.a(this.f8985u, ((g) obj).f8985u);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8985u.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f8985u + ')';
    }
}
