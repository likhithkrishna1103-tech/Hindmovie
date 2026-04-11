package df;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f4211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f4212b;

    public m(l lVar) {
        this.f4211a = lVar;
    }

    @Override // df.n
    public final boolean a(SSLSocket sSLSocket) {
        return this.f4211a.a(sSLSocket);
    }

    @Override // df.n
    public final String b(SSLSocket sSLSocket) {
        n nVarE = e(sSLSocket);
        if (nVarE != null) {
            return nVarE.b(sSLSocket);
        }
        return null;
    }

    @Override // df.n
    public final boolean c() {
        return true;
    }

    @Override // df.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        be.h.e(list, "protocols");
        n nVarE = e(sSLSocket);
        if (nVarE != null) {
            nVarE.d(sSLSocket, str, list);
        }
    }

    public final synchronized n e(SSLSocket sSLSocket) {
        try {
            if (this.f4212b == null && this.f4211a.a(sSLSocket)) {
                this.f4212b = this.f4211a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f4212b;
    }
}
