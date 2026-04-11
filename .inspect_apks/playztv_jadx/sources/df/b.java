package df;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends com.bumptech.glide.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final X509TrustManager f4196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final X509TrustManagerExtensions f4197e;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f4196d = x509TrustManager;
        this.f4197e = x509TrustManagerExtensions;
    }

    @Override // com.bumptech.glide.c
    public final List e(String str, List list) throws SSLPeerUnverifiedException {
        be.h.e(list, "chain");
        be.h.e(str, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f4197e.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            be.h.d(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e10) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
            sSLPeerUnverifiedException.initCause(e10);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f4196d == this.f4196d;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f4196d);
    }
}
