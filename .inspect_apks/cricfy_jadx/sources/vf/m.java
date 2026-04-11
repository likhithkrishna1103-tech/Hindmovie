package vf;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f13741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f13742b;

    public m(l lVar) {
        this.f13741a = lVar;
    }

    @Override // vf.n
    public final String a(SSLSocket sSLSocket) {
        n nVarE = e(sSLSocket);
        if (nVarE != null) {
            return nVarE.a(sSLSocket);
        }
        return null;
    }

    @Override // vf.n
    public final boolean b() {
        return true;
    }

    @Override // vf.n
    public final boolean c(SSLSocket sSLSocket) {
        return this.f13741a.c(sSLSocket);
    }

    @Override // vf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        ge.i.e(list, "protocols");
        n nVarE = e(sSLSocket);
        if (nVarE != null) {
            nVarE.d(sSLSocket, str, list);
        }
    }

    public final synchronized n e(SSLSocket sSLSocket) {
        try {
            if (this.f13742b == null && this.f13741a.c(sSLSocket)) {
                this.f13742b = this.f13741a.g(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f13742b;
    }
}
