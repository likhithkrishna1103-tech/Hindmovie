package ue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ub.o f13019a = new ub.o(28);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0.e f13020b = new q0.e(13);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f13021c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f13022d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r2.h f13023e = new r2.h(12);
    public final boolean f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f13024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f13025h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f13026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f13027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f13028l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SocketFactory f13029m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SSLSocketFactory f13030n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public X509TrustManager f13031o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f13032p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f13033q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final gf.c f13034r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f13035s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bumptech.glide.c f13036t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f13037u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13038v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f13039w;

    public r() {
        b bVar = b.f12934a;
        this.f13024g = bVar;
        this.f13025h = true;
        this.i = true;
        this.f13026j = b.f12935b;
        this.f13027k = b.f12936c;
        this.f13028l = bVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        be.h.d(socketFactory, "getDefault()");
        this.f13029m = socketFactory;
        this.f13032p = s.U;
        this.f13033q = s.T;
        this.f13034r = gf.c.f5393a;
        this.f13035s = f.f12955c;
        this.f13037u = 10000;
        this.f13038v = 10000;
        this.f13039w = 10000;
    }

    public final void a(List list) {
        be.h.e(list, "protocols");
        ArrayList arrayList = new ArrayList(list);
        t tVar = t.f13050z;
        if (!arrayList.contains(tVar) && !arrayList.contains(t.f13047w)) {
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList).toString());
        }
        if (arrayList.contains(tVar) && arrayList.size() > 1) {
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList).toString());
        }
        if (arrayList.contains(t.f13046v)) {
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + arrayList).toString());
        }
        if (arrayList.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        }
        arrayList.remove(t.f13048x);
        arrayList.equals(this.f13033q);
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        be.h.d(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
        this.f13033q = listUnmodifiableList;
    }

    public final void b(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        be.h.e(sSLSocketFactory, "sslSocketFactory");
        if (sSLSocketFactory.equals(this.f13030n)) {
            x509TrustManager.equals(this.f13031o);
        }
        this.f13030n = sSLSocketFactory;
        cf.n nVar = cf.n.f2753a;
        this.f13036t = cf.n.f2753a.b(x509TrustManager);
        this.f13031o = x509TrustManager;
    }
}
