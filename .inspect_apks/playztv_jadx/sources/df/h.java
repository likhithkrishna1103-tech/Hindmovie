package df;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4206a = new g();

    @Override // df.n
    public final boolean a(SSLSocket sSLSocket) {
        return false;
    }

    @Override // df.n
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // df.n
    public final boolean c() {
        boolean z2 = cf.e.f2738d;
        return cf.e.f2738d;
    }

    @Override // df.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        be.h.e(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            cf.n nVar = cf.n.f2753a;
            parameters.setApplicationProtocols((String[]) pa.b.d(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
