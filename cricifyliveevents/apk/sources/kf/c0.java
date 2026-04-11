package kf;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f7453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f7454c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        ge.i.e(inetSocketAddress, "socketAddress");
        this.f7452a = aVar;
        this.f7453b = proxy;
        this.f7454c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return ge.i.a(c0Var.f7452a, this.f7452a) && ge.i.a(c0Var.f7453b, this.f7453b) && ge.i.a(c0Var.f7454c, this.f7454c);
    }

    public final int hashCode() {
        return this.f7454c.hashCode() + ((this.f7453b.hashCode() + ((this.f7452a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        q qVar = this.f7452a.f7432h;
        String str = qVar.f7518d;
        InetSocketAddress inetSocketAddress = this.f7454c;
        InetAddress address = inetSocketAddress.getAddress();
        String strB = (address == null || (hostAddress = address.getHostAddress()) == null) ? null : lf.c.b(hostAddress);
        if (ne.h.d0(str, ':')) {
            sb.append("[");
            sb.append(str);
            sb.append("]");
        } else {
            sb.append(str);
        }
        if (qVar.f7519e != inetSocketAddress.getPort() || str.equals(strB)) {
            sb.append(":");
            sb.append(qVar.f7519e);
        }
        if (!str.equals(strB)) {
            if (this.f7453b.equals(Proxy.NO_PROXY)) {
                sb.append(" at ");
            } else {
                sb.append(" via proxy ");
            }
            if (strB == null) {
                sb.append("<unresolved>");
            } else if (ne.h.d0(strB, ':')) {
                sb.append("[");
                sb.append(strB);
                sb.append("]");
            } else {
                sb.append(strB);
            }
            sb.append(":");
            sb.append(inetSocketAddress.getPort());
        }
        return sb.toString();
    }
}
