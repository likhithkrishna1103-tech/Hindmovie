package u4;

import ae.p;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t4.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o4.c f12763u;

    public b(o4.c cVar) {
        this.f12763u = cVar;
    }

    @Override // t4.b
    public final Object I(boolean z2, p pVar, td.c cVar) {
        z4.b bVar = (z4.b) this.f12763u.f9349u;
        bVar.getClass();
        return pVar.i(new d(new a(bVar.Z())), cVar);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        ((z4.b) this.f12763u.f9349u).close();
    }
}
