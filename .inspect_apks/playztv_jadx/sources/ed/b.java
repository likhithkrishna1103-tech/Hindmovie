package ed;

import be.h;
import dd.p;
import java.util.List;
import yc.k;
import zc.e;
import zc.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f4678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f4679c;

    public b(a aVar, p pVar) {
        h.e(pVar, "fetchListener");
        this.f4677a = aVar;
        this.f4678b = pVar;
    }

    public final void a(e eVar) {
        if (this.f4679c) {
            return;
        }
        eVar.D = k.A;
        this.f4677a.b(eVar);
        this.f4678b.c(eVar);
    }

    public final void b(e eVar, id.b bVar, int i) {
        h.e(eVar, "download");
        h.e(bVar, "downloadBlock");
        if (this.f4679c) {
            return;
        }
        this.f4678b.d(eVar, bVar, i);
    }

    public final void c(e eVar, yc.b bVar, Exception exc) {
        k kVar = k.f14689x;
        h.e(eVar, "download");
        if (this.f4679c) {
            return;
        }
        int i = eVar.M;
        if (eVar.E == yc.b.E) {
            eVar.D = kVar;
            eVar.e(hd.a.f6071d);
            this.f4677a.b(eVar);
            this.f4678b.h(eVar, true);
            return;
        }
        int i10 = eVar.N;
        if (i10 >= i) {
            eVar.D = k.C;
            this.f4677a.b(eVar);
            this.f4678b.f(eVar, bVar, exc);
        } else {
            eVar.N = i10 + 1;
            eVar.D = kVar;
            eVar.e(hd.a.f6071d);
            this.f4677a.b(eVar);
            this.f4678b.h(eVar, true);
        }
    }

    public final void d(e eVar, long j5, long j8) {
        h.e(eVar, "download");
        if (this.f4679c) {
            return;
        }
        this.f4678b.g(eVar, j5, j8);
    }

    public final void e(e eVar, List list, int i) {
        h.e(eVar, "download");
        if (this.f4679c) {
            return;
        }
        eVar.D = k.f14690y;
        this.f4677a.b(eVar);
        this.f4678b.j(eVar, list, i);
    }

    public final void f(e eVar) {
        h.e(eVar, "download");
        if (this.f4679c) {
            return;
        }
        eVar.D = k.f14690y;
        g gVar = this.f4677a.f4676a;
        gVar.getClass();
        h.e(eVar, "downloadInfo");
        synchronized (gVar.f14963v) {
            gVar.f14962u.h0(eVar);
        }
    }
}
