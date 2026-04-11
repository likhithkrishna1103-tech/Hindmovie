package cf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements gf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509TrustManager f2730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f2731b;

    public b(X509TrustManager x509TrustManager, Method method) {
        this.f2730a = x509TrustManager;
        this.f2731b = method;
    }

    @Override // gf.d
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            Object objInvoke = this.f2731b.invoke(this.f2730a, x509Certificate);
            be.h.c(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
            return ((TrustAnchor) objInvoke).getTrustedCert();
        } catch (IllegalAccessException e10) {
            throw new AssertionError("unable to get issues and signature", e10);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return be.h.a(this.f2730a, bVar.f2730a) && be.h.a(this.f2731b, bVar.f2731b);
    }

    public final int hashCode() {
        return this.f2731b.hashCode() + (this.f2730a.hashCode() * 31);
    }

    public final String toString() {
        return "CustomTrustRootIndex(trustManager=" + this.f2730a + ", findByIssuerAndSignatureMethod=" + this.f2731b + ')';
    }
}
