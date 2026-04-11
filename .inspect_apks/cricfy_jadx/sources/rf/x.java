package rf;

import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends ag.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ y f11133n;

    public x(y yVar) {
        this.f11133n = yVar;
    }

    @Override // ag.c
    public final IOException j(IOException iOException) {
        return new SocketTimeoutException("timeout");
    }

    @Override // ag.c
    public final void k() {
        this.f11133n.f(b.C);
        q qVar = this.f11133n.f11135w;
        synchronized (qVar) {
            long j4 = qVar.I;
            long j7 = qVar.H;
            if (j4 < j7) {
                return;
            }
            qVar.H = j7 + 1;
            qVar.J = System.nanoTime() + ((long) 1000000000);
            nf.c.c(qVar.C, q4.a.q(new StringBuilder(), qVar.f11105x, " ping"), new c.d0(8, qVar));
        }
    }

    public final void l() {
        if (i()) {
            throw j(null);
        }
    }
}
