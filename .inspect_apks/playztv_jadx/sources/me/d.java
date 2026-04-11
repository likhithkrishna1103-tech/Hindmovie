package me;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f8337a;

    public d(Throwable th) {
        this.f8337a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return be.h.a(this.f8337a, ((d) obj).f8337a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f8337a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // me.e
    public final String toString() {
        return "Closed(" + this.f8337a + ')';
    }
}
