package z5;

import android.util.Base64;
import android.util.Log;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kf.t;
import kf.u;
import kf.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509TrustManager f15205a;

    public c(X509TrustManager x509TrustManager) {
        this.f15205a = x509TrustManager;
    }

    public static String a(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static u b() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            c cVar = new c((X509TrustManager) trustManagerFactory.getTrustManagers()[0]);
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{cVar}, null);
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            t tVar = new t();
            tVar.a(Collections.singletonList(v.f7574y));
            tVar.b(socketFactory, cVar);
            return new u(tVar);
        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException e9) {
            Log.e("getOkHttpClient Error", e9.getMessage());
            return null;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr != null) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                String lowerCase = x509Certificate.getSubjectDN().getName().toLowerCase();
                String[] strArr = {a("SHR0cENhbmFyeQ=="), a("U1NMQ2FwdHVyZQ=="), a("UGFja2V0IENhcHR1cmU=")};
                for (int i = 0; i < 3; i++) {
                    if (lowerCase.contains(strArr[i].toLowerCase())) {
                        throw new CertificateException("cHJvX2lzX3Bybw==");
                    }
                }
            }
        }
        this.f15205a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr != null) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                String lowerCase = x509Certificate.getSubjectDN().getName().toLowerCase();
                String[] strArr = {a("SHR0cENhbmFyeQ=="), a("U1NMQ2FwdHVyZQ=="), a("UGFja2V0IENhcHR1cmU=")};
                for (int i = 0; i < 3; i++) {
                    if (lowerCase.contains(strArr[i].toLowerCase())) {
                        throw new CertificateException("cHJvX2lzX3Bybw==");
                    }
                }
            }
        }
        this.f15205a.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.f15205a.getAcceptedIssuers();
    }
}
