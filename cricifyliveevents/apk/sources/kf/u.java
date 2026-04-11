package kf;

import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import k4.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements d {
    public static final List B = lf.f.j(new v[]{v.A, v.f7574y});
    public static final List C = lf.f.j(new k[]{k.f7488e, k.f});
    public final i A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nc.p f7548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f7550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f7551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f7552e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f7553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7554h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f7555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f7556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ProxySelector f7557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f7558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SocketFactory f7559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SSLSocketFactory f7560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final X509TrustManager f7561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f7562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f7563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final yf.c f7564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f7565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final w8.e f7566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7568w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f7569x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m2.e f7570y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final nf.d f7571z;

    public u(t tVar) throws NoSuchAlgorithmException, KeyStoreException {
        this.f7548a = tVar.f7526a;
        this.f7549b = lf.f.i(tVar.f7528c);
        this.f7550c = lf.f.i(tVar.f7529d);
        this.f7551d = tVar.f7530e;
        this.f7552e = tVar.f;
        this.f = tVar.f7531g;
        this.f7553g = tVar.f7532h;
        this.f7554h = tVar.i;
        this.i = tVar.f7533j;
        this.f7555j = tVar.f7534k;
        this.f7556k = tVar.f7535l;
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.f7557l = proxySelector == null ? wf.a.f14179a : proxySelector;
        this.f7558m = tVar.f7536m;
        this.f7559n = tVar.f7537n;
        List list = tVar.f7540q;
        this.f7562q = list;
        this.f7563r = tVar.f7541r;
        this.f7564s = tVar.f7542s;
        this.f7567v = tVar.f7545v;
        this.f7568w = tVar.f7546w;
        this.f7569x = tVar.f7547x;
        this.f7570y = new m2.e(11);
        this.f7571z = nf.d.f9159l;
        i iVar = tVar.f7527b;
        if (iVar == null) {
            iVar = new i(0);
            tVar.f7527b = iVar;
        }
        this.A = iVar;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((k) it.next()).f7489a) {
                    SSLSocketFactory sSLSocketFactory = tVar.f7538o;
                    if (sSLSocketFactory == null) {
                        uf.f fVar = uf.f.f12506a;
                        uf.f.f12506a.getClass();
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                        ge.i.b(trustManagers);
                        if (trustManagers.length == 1) {
                            TrustManager trustManager = trustManagers[0];
                            if (trustManager instanceof X509TrustManager) {
                                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                                this.f7561p = x509TrustManager;
                                uf.f fVar2 = uf.f.f12506a;
                                fVar2.getClass();
                                try {
                                    SSLContext sSLContextL = fVar2.l();
                                    sSLContextL.init(null, new TrustManager[]{x509TrustManager}, null);
                                    SSLSocketFactory socketFactory = sSLContextL.getSocketFactory();
                                    ge.i.d(socketFactory, "getSocketFactory(...)");
                                    this.f7560o = socketFactory;
                                    w8.e eVarC = uf.f.f12506a.c(x509TrustManager);
                                    this.f7566u = eVarC;
                                    f fVar3 = tVar.f7543t;
                                    fVar3.getClass();
                                    this.f7565t = ge.i.a(fVar3.f7463b, eVarC) ? fVar3 : new f(fVar3.f7462a, eVarC);
                                } catch (GeneralSecurityException e9) {
                                    throw new AssertionError("No System TLS: " + e9, e9);
                                }
                            }
                        }
                        String string = Arrays.toString(trustManagers);
                        ge.i.d(string, "toString(...)");
                        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
                    }
                    this.f7560o = sSLSocketFactory;
                    w8.e eVar = tVar.f7544u;
                    ge.i.b(eVar);
                    this.f7566u = eVar;
                    X509TrustManager x509TrustManager2 = tVar.f7539p;
                    ge.i.b(x509TrustManager2);
                    this.f7561p = x509TrustManager2;
                    f fVar4 = tVar.f7543t;
                    fVar4.getClass();
                    this.f7565t = ge.i.a(fVar4.f7463b, eVar) ? fVar4 : new f(fVar4.f7462a, eVar);
                }
            }
            this.f7560o = null;
            this.f7566u = null;
            this.f7561p = null;
            this.f7565t = f.f7461c;
        } else {
            this.f7560o = null;
            this.f7566u = null;
            this.f7561p = null;
            this.f7565t = f.f7461c;
        }
        X509TrustManager x509TrustManager3 = this.f7561p;
        w8.e eVar2 = this.f7566u;
        SSLSocketFactory sSLSocketFactory2 = this.f7560o;
        List list2 = this.f7550c;
        List list3 = this.f7549b;
        ge.i.c(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        ge.i.c(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list2).toString());
        }
        List list4 = this.f7562q;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((k) it2.next()).f7489a) {
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (eVar2 == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (x509TrustManager3 == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (sSLSocketFactory2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (eVar2 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager3 != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!ge.i.a(this.f7565t, f.f7461c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public u() {
        this(new t());
    }
}
