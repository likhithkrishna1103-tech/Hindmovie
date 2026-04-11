package rd;

import ae.p;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final i f11572u = new i();

    @Override // rd.h
    public final h G(g gVar) {
        be.h.e(gVar, "key");
        return this;
    }

    @Override // rd.h
    public final h K(h hVar) {
        be.h.e(hVar, "context");
        return hVar;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // rd.h
    public final f v(g gVar) {
        be.h.e(gVar, "key");
        return null;
    }

    @Override // rd.h
    public final Object d(Object obj, p pVar) {
        return obj;
    }
}
