package vf;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends w8.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final X509TrustManager f13723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final X509TrustManagerExtensions f13724e;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        super(13);
        this.f13723d = x509TrustManager;
        this.f13724e = x509TrustManagerExtensions;
    }

    @Override // w8.e
    public final List e(String str, List list) throws SSLPeerUnverifiedException {
        ge.i.e(list, "chain");
        ge.i.e(str, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f13724e.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            ge.i.d(listCheckServerTrusted, "checkServerTrusted(...)");
            return listCheckServerTrusted;
        } catch (CertificateException e9) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e9.getMessage());
            sSLPeerUnverifiedException.initCause(e9);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f13723d == this.f13723d;
    }

    @Override // w8.e
    public final int hashCode() {
        return System.identityHashCode(this.f13723d);
    }
}
