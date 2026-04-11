package dd;

import android.os.Handler;
import b7.s;
import c2.x;
import h4.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final id.k f4158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zc.g f4159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ed.a f4160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a7.b f4161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f4162e;
    public final z f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s f4163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f4164h;

    public i(id.k kVar, zc.g gVar, ed.a aVar, a7.b bVar, Handler handler, z zVar, s sVar, x xVar) {
        be.h.e(handler, "uiHandler");
        be.h.e(xVar, "networkInfoProvider");
        this.f4158a = kVar;
        this.f4159b = gVar;
        this.f4160c = aVar;
        this.f4161d = bVar;
        this.f4162e = handler;
        this.f = zVar;
        this.f4163g = sVar;
        this.f4164h = xVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return be.h.a(this.f4158a, iVar.f4158a) && be.h.a(this.f4159b, iVar.f4159b) && be.h.a(this.f4160c, iVar.f4160c) && be.h.a(this.f4161d, iVar.f4161d) && be.h.a(this.f4162e, iVar.f4162e) && be.h.a(this.f, iVar.f) && be.h.a(this.f4163g, iVar.f4163g) && be.h.a(this.f4164h, iVar.f4164h);
    }

    public final int hashCode() {
        return this.f4164h.hashCode() + ((this.f4163g.hashCode() + ((this.f.hashCode() + ((this.f4162e.hashCode() + ((this.f4161d.hashCode() + ((this.f4160c.hashCode() + ((this.f4159b.hashCode() + 73373293) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Holder(handlerWrapper=" + this.f4158a + ", fetchDatabaseManagerWrapper=" + this.f4159b + ", downloadProvider=" + this.f4160c + ", groupInfoProvider=" + this.f4161d + ", uiHandler=" + this.f4162e + ", downloadManagerCoordinator=" + this.f + ", listenerCoordinator=" + this.f4163g + ", networkInfoProvider=" + this.f4164h + ")";
    }
}
