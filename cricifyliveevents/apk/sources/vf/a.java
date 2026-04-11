package vf;

import android.net.ssl.SSLSockets;
import android.os.Build;
import f9.b0;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements n {
    @Override // vf.n
    public final String a(SSLSocket sSLSocket) {
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // vf.n
    public final boolean b() {
        uf.f fVar = uf.f.f12506a;
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // vf.n
    public final boolean c(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // vf.n
    public final void d(SSLSocket sSLSocket, String str, List list) throws IOException {
        ge.i.e(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            uf.f fVar = uf.f.f12506a;
            sSLParameters.setApplicationProtocols((String[]) b0.w(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e9) {
            throw new IOException("Android internal error", e9);
        }
    }
}
