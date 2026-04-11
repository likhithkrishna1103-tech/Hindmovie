package id;

import cd.e;
import dd.g;
import ge.i;
import hd.l;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f6441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6442c;

    public b(a aVar, l lVar) {
        i.e(lVar, "fetchListener");
        this.f6440a = aVar;
        this.f6441b = lVar;
    }

    public final void a(dd.e eVar) {
        if (this.f6442c) {
            return;
        }
        eVar.E = cd.l.B;
        this.f6440a.b(eVar);
        this.f6441b.b(eVar);
    }

    public final void b(dd.e eVar, md.b bVar, int i) {
        i.e(eVar, "download");
        i.e(bVar, "downloadBlock");
        if (this.f6442c) {
            return;
        }
        this.f6441b.g(eVar, bVar, i);
    }

    public final void c(dd.e eVar, cd.b bVar, Exception exc) {
        cd.l lVar = cd.l.f2187y;
        i.e(eVar, "download");
        if (this.f6442c) {
            return;
        }
        int i = eVar.N;
        if (eVar.F == cd.b.F) {
            eVar.E = lVar;
            eVar.e(ld.a.f7951d);
            this.f6440a.b(eVar);
            this.f6441b.f(eVar, true);
            return;
        }
        int i10 = eVar.O;
        if (i10 >= i) {
            eVar.E = cd.l.D;
            this.f6440a.b(eVar);
            this.f6441b.a(eVar, bVar, exc);
        } else {
            eVar.O = i10 + 1;
            eVar.E = lVar;
            eVar.e(ld.a.f7951d);
            this.f6440a.b(eVar);
            this.f6441b.f(eVar, true);
        }
    }

    public final void d(dd.e eVar, long j4, long j7) {
        i.e(eVar, "download");
        if (this.f6442c) {
            return;
        }
        this.f6441b.c(eVar, j4, j7);
    }

    public final void e(dd.e eVar, List list, int i) {
        i.e(eVar, "download");
        if (this.f6442c) {
            return;
        }
        eVar.E = cd.l.f2188z;
        this.f6440a.b(eVar);
        this.f6441b.d(eVar, list, i);
    }

    public final void f(dd.e eVar) {
        i.e(eVar, "download");
        if (this.f6442c) {
            return;
        }
        eVar.E = cd.l.f2188z;
        g gVar = this.f6440a.f6439a;
        gVar.getClass();
        i.e(eVar, "downloadInfo");
        synchronized (gVar.f3687w) {
            gVar.f3686v.R(eVar);
        }
    }
}
