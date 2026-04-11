package kf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import k4.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f7527b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r0 f7530e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f7532h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f7533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f7534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f7535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f7536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SocketFactory f7537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SSLSocketFactory f7538o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public X509TrustManager f7539p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f7540q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f7541r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final yf.c f7542s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f7543t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public w8.e f7544u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7545v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7546w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f7547x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nc.p f7526a = new nc.p(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7528c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f7529d = new ArrayList();

    public t() {
        TimeZone timeZone = lf.f.f7964a;
        this.f7530e = new r0(24);
        this.f = true;
        this.f7531g = true;
        b bVar = b.f7436b;
        this.f7532h = bVar;
        this.i = true;
        this.f7533j = true;
        this.f7534k = b.f7437c;
        this.f7535l = b.f7438d;
        this.f7536m = bVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        ge.i.d(socketFactory, "getDefault(...)");
        this.f7537n = socketFactory;
        this.f7540q = u.C;
        this.f7541r = u.B;
        this.f7542s = yf.c.f15056a;
        this.f7543t = f.f7461c;
        this.f7545v = 10000;
        this.f7546w = 10000;
        this.f7547x = 10000;
    }

    public final void a(List list) {
        ge.i.e(list, "protocols");
        ArrayList arrayListS0 = sd.j.s0(list);
        v vVar = v.B;
        if (!arrayListS0.contains(vVar) && !arrayListS0.contains(v.f7574y)) {
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + arrayListS0).toString());
        }
        if (arrayListS0.contains(vVar) && arrayListS0.size() > 1) {
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayListS0).toString());
        }
        if (arrayListS0.contains(v.f7573x)) {
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + arrayListS0).toString());
        }
        if (arrayListS0.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        }
        arrayListS0.remove(v.f7575z);
        arrayListS0.equals(this.f7541r);
        List listUnmodifiableList = Collections.unmodifiableList(arrayListS0);
        ge.i.d(listUnmodifiableList, "unmodifiableList(...)");
        this.f7541r = listUnmodifiableList;
    }

    public final void b(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        ge.i.e(sSLSocketFactory, "sslSocketFactory");
        if (sSLSocketFactory.equals(this.f7538o)) {
            x509TrustManager.equals(this.f7539p);
        }
        this.f7538o = sSLSocketFactory;
        uf.f fVar = uf.f.f12506a;
        this.f7544u = uf.f.f12506a.c(x509TrustManager);
        this.f7539p = x509TrustManager;
    }
}
