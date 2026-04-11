package pc;

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
import ue.r;
import ue.s;
import ue.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509TrustManager f10312a;

    public b(X509TrustManager x509TrustManager) {
        this.f10312a = x509TrustManager;
    }

    public static String a(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static s b() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            b bVar = new b((X509TrustManager) trustManagerFactory.getTrustManagers()[0]);
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{bVar}, null);
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            r rVar = new r();
            rVar.a(Collections.singletonList(t.f13047w));
            rVar.b(socketFactory, bVar);
            return new s(rVar);
        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException e10) {
            Log.e("getOkHttpClient Error", e10.getMessage());
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
        this.f10312a.checkClientTrusted(x509CertificateArr, str);
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
        this.f10312a.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.f10312a.getAcceptedIssuers();
    }
}
