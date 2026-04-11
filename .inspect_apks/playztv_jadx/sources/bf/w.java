package bf;

import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends hf.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ x f2126m;

    public w(x xVar) {
        this.f2126m = xVar;
    }

    @Override // hf.d
    public final void j() {
        this.f2126m.e(9);
        p pVar = this.f2126m.f2128b;
        synchronized (pVar) {
            long j5 = pVar.H;
            long j8 = pVar.G;
            if (j5 < j8) {
                return;
            }
            pVar.G = j8 + 1;
            pVar.I = System.nanoTime() + ((long) 1000000000);
            pVar.B.c(new n(l4.a.o(new StringBuilder(), pVar.f2095w, " ping"), pVar, 0), 0L);
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
