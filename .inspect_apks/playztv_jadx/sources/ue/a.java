package ue;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SocketFactory f12924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f12925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HostnameVerifier f12926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f12927e;
    public final b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f12928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f12929h;
    public final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f12930j;

    public a(String str, int i, b bVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f fVar, b bVar2, List list, List list2, ProxySelector proxySelector) {
        be.h.e(str, "uriHost");
        be.h.e(bVar, "dns");
        be.h.e(socketFactory, "socketFactory");
        be.h.e(bVar2, "proxyAuthenticator");
        be.h.e(list, "protocols");
        be.h.e(list2, "connectionSpecs");
        be.h.e(proxySelector, "proxySelector");
        this.f12923a = bVar;
        this.f12924b = socketFactory;
        this.f12925c = sSLSocketFactory;
        this.f12926d = hostnameVerifier;
        this.f12927e = fVar;
        this.f = bVar2;
        this.f12928g = proxySelector;
        n nVar = new n();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            nVar.f13000a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
            }
            nVar.f13000a = "https";
        }
        String strT = q1.c.T(b.e(str, 0, 0, 7));
        if (strT == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        nVar.f13003d = strT;
        if (1 > i || i >= 65536) {
            throw new IllegalArgumentException(e6.j.l("unexpected port: ", i).toString());
        }
        nVar.f13004e = i;
        this.f12929h = nVar.a();
        this.i = ve.b.v(list);
        this.f12930j = ve.b.v(list2);
    }

    public final boolean a(a aVar) {
        be.h.e(aVar, "that");
        return be.h.a(this.f12923a, aVar.f12923a) && be.h.a(this.f, aVar.f) && be.h.a(this.i, aVar.i) && be.h.a(this.f12930j, aVar.f12930j) && be.h.a(this.f12928g, aVar.f12928g) && be.h.a(this.f12925c, aVar.f12925c) && be.h.a(this.f12926d, aVar.f12926d) && be.h.a(this.f12927e, aVar.f12927e) && this.f12929h.f13012e == aVar.f12929h.f13012e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return be.h.a(this.f12929h, aVar.f12929h) && a(aVar);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f12927e) + ((Objects.hashCode(this.f12926d) + ((Objects.hashCode(this.f12925c) + ((this.f12928g.hashCode() + ((this.f12930j.hashCode() + ((this.i.hashCode() + ((this.f.hashCode() + ((this.f12923a.hashCode() + e6.j.h(527, 31, this.f12929h.f13014h)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Address{");
        o oVar = this.f12929h;
        sb2.append(oVar.f13011d);
        sb2.append(':');
        sb2.append(oVar.f13012e);
        sb2.append(", ");
        sb2.append("proxySelector=" + this.f12928g);
        sb2.append('}');
        return sb2.toString();
    }
}
