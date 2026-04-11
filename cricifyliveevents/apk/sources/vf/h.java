package vf;

import f9.b0;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13737a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f13738b;

    static {
        boolean z10 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, g.class.getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f13738b = z10;
    }

    @Override // vf.n
    public final String a(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // vf.n
    public final boolean b() {
        return f13738b;
    }

    @Override // vf.n
    public final boolean c(SSLSocket sSLSocket) {
        return false;
    }

    @Override // vf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        ge.i.e(list, "protocols");
        if (c(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            uf.f fVar = uf.f.f12506a;
            parameters.setApplicationProtocols((String[]) b0.w(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
