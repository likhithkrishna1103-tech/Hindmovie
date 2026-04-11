package id;

import androidx.emoji2.text.w;
import cd.g;
import cd.i;
import d8.j;
import i2.x;
import java.io.Closeable;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable {
    public final j A;
    public final i B;
    public final Object C;
    public volatile g D;
    public volatile boolean E;
    public volatile boolean F;
    public volatile long G;
    public final c H;
    public final w I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final md.j f6444v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f6445w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final fd.a f6446x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final x f6447y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d5.a f6448z;

    public d(md.j jVar, a aVar, fd.a aVar2, x xVar, d5.a aVar3, j jVar2, i iVar) {
        ge.i.e(aVar3, "logger");
        ge.i.e(iVar, "prioritySort");
        this.f6444v = jVar;
        this.f6445w = aVar;
        this.f6446x = aVar2;
        this.f6447y = xVar;
        this.f6448z = aVar3;
        this.A = jVar2;
        this.B = iVar;
        this.C = new Object();
        this.D = g.f2168x;
        this.F = true;
        this.G = 500L;
        c cVar = new c(this);
        this.H = cVar;
        synchronized (xVar.f6145c) {
            ((HashSet) xVar.f6146d).add(cVar);
        }
        this.I = new w(16, this);
    }

    public final void A() {
        synchronized (this.C) {
            C();
            this.E = false;
            this.F = true;
            this.f6446x.g();
            this.f6448z.getClass();
        }
    }

    public final void C() {
        md.j jVar = this.f6444v;
        w wVar = this.I;
        ge.i.e(wVar, "runnable");
        synchronized (jVar.f8441a) {
            if (!jVar.f8442b) {
                jVar.f8444d.removeCallbacks(wVar);
            }
        }
    }

    public final boolean a() {
        return (this.F || this.E) ? false : true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.C) {
            this.f6447y.d(this.H);
        }
    }

    public final void g() {
        md.j jVar = this.f6444v;
        w wVar = this.I;
        long j4 = this.G;
        ge.i.e(wVar, "runnable");
        synchronized (jVar.f8441a) {
            if (!jVar.f8442b) {
                jVar.f8444d.postDelayed(wVar, j4);
            }
        }
    }

    public final void q() {
        synchronized (this.C) {
            this.G = 500L;
            C();
            g();
            this.f6448z.b("PriorityIterator backoffTime reset to " + this.G + " milliseconds");
        }
    }

    public final void s() {
        synchronized (this.C) {
            q();
            this.E = false;
            this.F = false;
            g();
            this.f6448z.getClass();
        }
    }

    public final void z() {
        synchronized (this.C) {
            q();
            this.F = false;
            this.E = false;
            g();
            this.f6448z.getClass();
        }
    }
}
