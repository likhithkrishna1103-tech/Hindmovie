package nd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements c, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ae.a f8991u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f8992v;

    @Override // nd.c
    public final Object getValue() {
        if (this.f8992v == j.f8989a) {
            ae.a aVar = this.f8991u;
            be.h.b(aVar);
            this.f8992v = aVar.b();
            this.f8991u = null;
        }
        return this.f8992v;
    }

    public final String toString() {
        return this.f8992v != j.f8989a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
