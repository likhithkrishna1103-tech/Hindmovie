package kf;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SocketFactory f7427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f7428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HostnameVerifier f7429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f7430e;
    public final b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f7431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f7432h;
    public final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f7433j;

    public a(String str, int i, b bVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, yf.c cVar, f fVar, b bVar2, List list, List list2, ProxySelector proxySelector) {
        ge.i.e(str, "uriHost");
        ge.i.e(bVar, "dns");
        ge.i.e(socketFactory, "socketFactory");
        ge.i.e(bVar2, "proxyAuthenticator");
        ge.i.e(list, "protocols");
        ge.i.e(list2, "connectionSpecs");
        ge.i.e(proxySelector, "proxySelector");
        this.f7426a = bVar;
        this.f7427b = socketFactory;
        this.f7428c = sSLSocketFactory;
        this.f7429d = cVar;
        this.f7430e = fVar;
        this.f = bVar2;
        this.f7431g = proxySelector;
        ka.c0 c0Var = new ka.c0(1);
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            c0Var.f7293c = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
            }
            c0Var.f7293c = "https";
        }
        String strB = lf.c.b(zf.a.d(str, 0, 0, 7));
        if (strB == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        c0Var.f = strB;
        if (1 > i || i >= 65536) {
            throw new IllegalArgumentException(l0.e.g(i, "unexpected port: ").toString());
        }
        c0Var.f7292b = i;
        this.f7432h = c0Var.b();
        this.i = lf.f.i(list);
        this.f7433j = lf.f.i(list2);
    }

    public final boolean a(a aVar) {
        ge.i.e(aVar, "that");
        return ge.i.a(this.f7426a, aVar.f7426a) && ge.i.a(this.f, aVar.f) && ge.i.a(this.i, aVar.i) && ge.i.a(this.f7433j, aVar.f7433j) && ge.i.a(this.f7431g, aVar.f7431g) && ge.i.a(this.f7428c, aVar.f7428c) && ge.i.a(this.f7429d, aVar.f7429d) && ge.i.a(this.f7430e, aVar.f7430e) && this.f7432h.f7519e == aVar.f7432h.f7519e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return ge.i.a(this.f7432h, aVar.f7432h) && a(aVar);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f7430e) + ((Objects.hashCode(this.f7429d) + ((Objects.hashCode(this.f7428c) + ((this.f7431g.hashCode() + ((this.f7433j.hashCode() + ((this.i.hashCode() + ((this.f.hashCode() + ((this.f7426a.hashCode() + l0.e.e(527, 31, this.f7432h.f7521h)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        q qVar = this.f7432h;
        sb.append(qVar.f7518d);
        sb.append(':');
        sb.append(qVar.f7519e);
        sb.append(", ");
        sb.append("proxySelector=" + this.f7431g);
        sb.append('}');
        return sb.toString();
    }
}
