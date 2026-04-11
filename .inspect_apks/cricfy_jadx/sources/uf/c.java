package uf;

import ge.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements yf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509TrustManager f12501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f12502b;

    public c(X509TrustManager x509TrustManager, Method method) {
        this.f12501a = x509TrustManager;
        this.f12502b = method;
    }

    @Override // yf.d
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            Object objInvoke = this.f12502b.invoke(this.f12501a, x509Certificate);
            i.c(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
            return ((TrustAnchor) objInvoke).getTrustedCert();
        } catch (IllegalAccessException e9) {
            throw new AssertionError("unable to get issues and signature", e9);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return i.a(this.f12501a, cVar.f12501a) && i.a(this.f12502b, cVar.f12502b);
    }

    public final int hashCode() {
        return this.f12502b.hashCode() + (this.f12501a.hashCode() * 31);
    }

    public final String toString() {
        return "CustomTrustRootIndex(trustManager=" + this.f12501a + ", findByIssuerAndSignatureMethod=" + this.f12502b + ')';
    }
}
