package af;

import hf.j;
import hf.w;
import hf.y;
import java.io.IOException;
import ye.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f798u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f799v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h f800w;

    public b(h hVar) {
        this.f800w = hVar;
        this.f798u = new j(((hf.h) hVar.f816d).c());
    }

    public final void a() {
        h hVar = this.f800w;
        int i = hVar.f813a;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + hVar.f813a);
        }
        j jVar = this.f798u;
        y yVar = jVar.f6118e;
        jVar.f6118e = y.f6155d;
        yVar.a();
        yVar.b();
        hVar.f813a = 6;
    }

    @Override // hf.w
    public final y c() {
        return this.f798u;
    }

    @Override // hf.w
    public long l(long j5, hf.f fVar) throws IOException {
        h hVar = this.f800w;
        be.h.e(fVar, "sink");
        try {
            return ((hf.h) hVar.f816d).l(j5, fVar);
        } catch (IOException e10) {
            ((k) hVar.f815c).l();
            a();
            throw e10;
        }
    }
}
