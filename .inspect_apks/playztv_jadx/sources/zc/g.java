package zc;

import id.h;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f14962u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f14963v;

    public g(f fVar) {
        this.f14962u = fVar;
        h hVar = fVar.f14956u;
        this.f14963v = new Object();
    }

    public final nd.f F(e eVar) {
        nd.f fVarH;
        synchronized (this.f14963v) {
            fVarH = this.f14962u.H(eVar);
        }
        return fVarH;
    }

    public final void G(e eVar) {
        be.h.e(eVar, "downloadInfo");
        synchronized (this.f14963v) {
            this.f14962u.g0(eVar);
        }
    }

    public final e a(String str) {
        e eVarX;
        be.h.e(str, "file");
        synchronized (this.f14963v) {
            eVarX = this.f14962u.x(str);
        }
        return eVarX;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f14963v) {
            this.f14962u.close();
        }
    }

    public final List d(int i) {
        List listF;
        synchronized (this.f14963v) {
            listF = this.f14962u.F(i);
        }
        return listF;
    }

    public final rc.b v() {
        rc.b bVar;
        synchronized (this.f14963v) {
            bVar = this.f14962u.f14960y;
        }
        return bVar;
    }

    public final List x(yc.h hVar) {
        List listG;
        be.h.e(hVar, "prioritySort");
        synchronized (this.f14963v) {
            listG = this.f14962u.G(hVar);
        }
        return listG;
    }
}
