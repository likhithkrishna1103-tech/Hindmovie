package ue;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f12932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f12933c;

    public a0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        be.h.e(inetSocketAddress, "socketAddress");
        this.f12931a = aVar;
        this.f12932b = proxy;
        this.f12933c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return be.h.a(a0Var.f12931a, this.f12931a) && be.h.a(a0Var.f12932b, this.f12932b) && be.h.a(a0Var.f12933c, this.f12933c);
    }

    public final int hashCode() {
        return this.f12933c.hashCode() + ((this.f12932b.hashCode() + ((this.f12931a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f12933c + '}';
    }
}
