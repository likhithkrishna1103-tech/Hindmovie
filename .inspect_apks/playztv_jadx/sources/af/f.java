package af;

import hf.j;
import hf.u;
import hf.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements u {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f809u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f810v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h f811w;

    public f(h hVar) {
        this.f811w = hVar;
        this.f809u = new j(((hf.g) hVar.f817e).c());
    }

    @Override // hf.u
    public final void b0(long j5, hf.f fVar) {
        if (this.f810v) {
            throw new IllegalStateException("closed");
        }
        ve.b.b(fVar.f6113v, 0L, j5);
        ((hf.g) this.f811w.f817e).b0(j5, fVar);
    }

    @Override // hf.u
    public final y c() {
        return this.f809u;
    }

    @Override // hf.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f810v) {
            return;
        }
        this.f810v = true;
        j jVar = this.f809u;
        y yVar = jVar.f6118e;
        jVar.f6118e = y.f6155d;
        yVar.a();
        yVar.b();
        this.f811w.f813a = 3;
    }

    @Override // hf.u, java.io.Flushable
    public final void flush() {
        if (this.f810v) {
            return;
        }
        ((hf.g) this.f811w.f817e).flush();
    }
}
