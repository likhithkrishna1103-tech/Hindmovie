package ye;

import java.io.IOException;
import ue.p;
import ue.s;
import ue.x;
import w1.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14693a = new a();

    @Override // ue.p
    public final x a(ze.f fVar) throws IOException {
        h hVar = fVar.f14967a;
        synchronized (hVar) {
            try {
                if (!hVar.F) {
                    throw new IllegalStateException("released");
                }
                if (hVar.E) {
                    throw new IllegalStateException("Check failed.");
                }
                if (hVar.D) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        d dVar = hVar.A;
        be.h.b(dVar);
        s sVar = hVar.f14718u;
        try {
            m mVar = new m(hVar, dVar, dVar.a(fVar.f, fVar.f14972g, fVar.f14973h, sVar.f13045z, !be.h.a((String) fVar.f14971e.f1738c, "GET")).k(sVar, fVar));
            hVar.C = mVar;
            hVar.H = mVar;
            synchronized (hVar) {
                hVar.D = true;
                hVar.E = true;
            }
            if (hVar.G) {
                throw new IOException("Canceled");
            }
            return ze.f.a(fVar, 0, mVar, null, 61).b(fVar.f14971e);
        } catch (IOException e10) {
            dVar.c(e10);
            throw new l(e10);
        } catch (l e11) {
            dVar.c(e11.f14743v);
            throw e11;
        }
    }
}
