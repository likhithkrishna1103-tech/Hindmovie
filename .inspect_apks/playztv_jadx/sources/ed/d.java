package ed;

import b7.s;
import c2.x;
import id.k;
import java.io.Closeable;
import java.util.HashSet;
import yc.f;
import yc.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable {
    public final h A;
    public final Object B;
    public volatile f C;
    public volatile boolean D;
    public volatile boolean E;
    public volatile long F;
    public final c G;
    public final a2.a H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f4681u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f4682v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final bd.a f4683w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final x f4684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final id.h f4685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final s f4686z;

    public d(k kVar, a aVar, bd.a aVar2, x xVar, id.h hVar, s sVar, h hVar2) {
        be.h.e(hVar, "logger");
        be.h.e(hVar2, "prioritySort");
        this.f4681u = kVar;
        this.f4682v = aVar;
        this.f4683w = aVar2;
        this.f4684x = xVar;
        this.f4685y = hVar;
        this.f4686z = sVar;
        this.A = hVar2;
        this.B = new Object();
        this.C = f.f14667w;
        this.E = true;
        this.F = 500L;
        c cVar = new c(this);
        this.G = cVar;
        synchronized (xVar.f2414c) {
            ((HashSet) xVar.f2415d).add(cVar);
        }
        this.H = new a2.a(12, this);
    }

    public final void F() {
        synchronized (this.B) {
            v();
            this.E = false;
            this.D = false;
            d();
            this.f4685y.getClass();
        }
    }

    public final void G() {
        synchronized (this.B) {
            H();
            this.D = false;
            this.E = true;
            this.f4683w.d();
            this.f4685y.getClass();
        }
    }

    public final void H() {
        k kVar = this.f4681u;
        a2.a aVar = this.H;
        be.h.e(aVar, "runnable");
        synchronized (kVar.f6586a) {
            if (!kVar.f6587b) {
                kVar.f6589d.removeCallbacks(aVar);
            }
        }
    }

    public final boolean a() {
        return (this.E || this.D) ? false : true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.B) {
            this.f4684x.d(this.G);
        }
    }

    public final void d() {
        k kVar = this.f4681u;
        a2.a aVar = this.H;
        long j5 = this.F;
        be.h.e(aVar, "runnable");
        synchronized (kVar.f6586a) {
            if (!kVar.f6587b) {
                kVar.f6589d.postDelayed(aVar, j5);
            }
        }
    }

    public final void v() {
        synchronized (this.B) {
            this.F = 500L;
            H();
            d();
            this.f4685y.b("PriorityIterator backoffTime reset to " + this.F + " milliseconds");
        }
    }

    public final void x() {
        synchronized (this.B) {
            v();
            this.D = false;
            this.E = false;
            d();
            this.f4685y.getClass();
        }
    }
}
