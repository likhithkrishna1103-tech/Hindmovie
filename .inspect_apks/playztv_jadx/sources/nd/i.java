package nd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ae.a f8986u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile Object f8987v = j.f8989a;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f8988w = this;

    public i(ae.a aVar) {
        this.f8986u = aVar;
    }

    @Override // nd.c
    public final Object getValue() {
        Object objB;
        Object obj = this.f8987v;
        j jVar = j.f8989a;
        if (obj != jVar) {
            return obj;
        }
        synchronized (this.f8988w) {
            objB = this.f8987v;
            if (objB == jVar) {
                ae.a aVar = this.f8986u;
                be.h.b(aVar);
                objB = aVar.b();
                this.f8987v = objB;
                this.f8986u = null;
            }
        }
        return objB;
    }

    public final String toString() {
        return this.f8987v != j.f8989a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
