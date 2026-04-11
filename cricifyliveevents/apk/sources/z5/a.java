package z5;

import android.util.Log;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kf.t;
import kf.u;
import kf.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements X509TrustManager {
    public static u a() {
        try {
            a aVar = new a();
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            try {
                sSLContext.init(null, new TrustManager[]{aVar}, null);
                SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                t tVar = new t();
                tVar.a(Collections.singletonList(v.f7574y));
                tVar.b(socketFactory, aVar);
                return new u(tVar);
            } catch (KeyManagementException e9) {
                e = e9;
                Log.e("getOkHttpClient Error", e.getMessage());
                return new u();
            }
        } catch (KeyManagementException | NoSuchAlgorithmException e10) {
            e = e10;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }
}
