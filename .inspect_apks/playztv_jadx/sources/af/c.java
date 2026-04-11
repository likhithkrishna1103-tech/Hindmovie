package af;

import hf.j;
import hf.u;
import hf.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements u {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f801u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f802v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h f803w;

    public c(h hVar) {
        this.f803w = hVar;
        this.f801u = new j(((hf.g) hVar.f817e).c());
    }

    @Override // hf.u
    public final void b0(long j5, hf.f fVar) {
        hf.g gVar = (hf.g) this.f803w.f817e;
        if (this.f802v) {
            throw new IllegalStateException("closed");
        }
        if (j5 == 0) {
            return;
        }
        gVar.h(j5);
        gVar.Y("\r\n");
        gVar.b0(j5, fVar);
        gVar.Y("\r\n");
    }

    @Override // hf.u
    public final y c() {
        return this.f801u;
    }

    @Override // hf.u, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f802v) {
            return;
        }
        this.f802v = true;
        ((hf.g) this.f803w.f817e).Y("0\r\n\r\n");
        j jVar = this.f801u;
        y yVar = jVar.f6118e;
        jVar.f6118e = y.f6155d;
        yVar.a();
        yVar.b();
        this.f803w.f813a = 3;
    }

    @Override // hf.u, java.io.Flushable
    public final synchronized void flush() {
        if (this.f802v) {
            return;
        }
        ((hf.g) this.f803w.f817e).flush();
    }
}
