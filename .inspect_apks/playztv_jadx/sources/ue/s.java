package ue;

import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Cloneable, d {
    public static final List T = ve.b.j(t.f13049y, t.f13047w);
    public static final List U = ve.b.j(i.f12976e, i.f);
    public final b A;
    public final boolean B;
    public final boolean C;
    public final b D;
    public final b E;
    public final ProxySelector F;
    public final b G;
    public final SocketFactory H;
    public final SSLSocketFactory I;
    public final X509TrustManager J;
    public final List K;
    public final List L;
    public final gf.c M;
    public final f N;
    public final com.bumptech.glide.c O;
    public final int P;
    public final int Q;
    public final int R;
    public final o4.c S;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ub.o f13040u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q0.e f13041v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List f13042w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f13043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r2.h f13044y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f13045z;

    public s(r rVar) throws NoSuchAlgorithmException, KeyStoreException {
        this.f13040u = rVar.f13019a;
        this.f13041v = rVar.f13020b;
        this.f13042w = ve.b.v(rVar.f13021c);
        this.f13043x = ve.b.v(rVar.f13022d);
        this.f13044y = rVar.f13023e;
        this.f13045z = rVar.f;
        this.A = rVar.f13024g;
        this.B = rVar.f13025h;
        this.C = rVar.i;
        this.D = rVar.f13026j;
        this.E = rVar.f13027k;
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.F = proxySelector == null ? ef.a.f4687a : proxySelector;
        this.G = rVar.f13028l;
        this.H = rVar.f13029m;
        List list = rVar.f13032p;
        this.K = list;
        this.L = rVar.f13033q;
        this.M = rVar.f13034r;
        this.P = rVar.f13037u;
        this.Q = rVar.f13038v;
        this.R = rVar.f13039w;
        this.S = new o4.c(17);
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            this.I = null;
            this.O = null;
            this.J = null;
            this.N = f.f12955c;
        } else {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).f12977a) {
                    SSLSocketFactory sSLSocketFactory = rVar.f13030n;
                    if (sSLSocketFactory != null) {
                        this.I = sSLSocketFactory;
                        com.bumptech.glide.c cVar = rVar.f13036t;
                        be.h.b(cVar);
                        this.O = cVar;
                        X509TrustManager x509TrustManager = rVar.f13031o;
                        be.h.b(x509TrustManager);
                        this.J = x509TrustManager;
                        f fVar = rVar.f13035s;
                        fVar.getClass();
                        this.N = be.h.a(fVar.f12957b, cVar) ? fVar : new f(fVar.f12956a, cVar);
                    } else {
                        cf.n nVar = cf.n.f2753a;
                        X509TrustManager x509TrustManagerM = cf.n.f2753a.m();
                        this.J = x509TrustManagerM;
                        this.I = cf.n.f2753a.l(x509TrustManagerM);
                        com.bumptech.glide.c cVarB = cf.n.f2753a.b(x509TrustManagerM);
                        this.O = cVarB;
                        f fVar2 = rVar.f13035s;
                        fVar2.getClass();
                        this.N = be.h.a(fVar2.f12957b, cVarB) ? fVar2 : new f(fVar2.f12956a, cVarB);
                    }
                }
            }
            this.I = null;
            this.O = null;
            this.J = null;
            this.N = f.f12955c;
        }
        X509TrustManager x509TrustManager2 = this.J;
        com.bumptech.glide.c cVar2 = this.O;
        SSLSocketFactory sSLSocketFactory2 = this.I;
        List list3 = this.f13043x;
        List list4 = this.f13042w;
        be.h.c(list4, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list4.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list4).toString());
        }
        be.h.c(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list3).toString());
        }
        List list5 = this.K;
        if (!(list5 instanceof Collection) || !list5.isEmpty()) {
            Iterator it2 = list5.iterator();
            while (it2.hasNext()) {
                if (((i) it2.next()).f12977a) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (cVar2 == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (x509TrustManager2 == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (sSLSocketFactory2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (cVar2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!be.h.a(this.N, f.f12955c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final Object clone() {
        return super.clone();
    }

    public s() {
        this(new r());
    }
}
