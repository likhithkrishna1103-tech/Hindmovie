package of;

import ag.y;
import com.google.android.gms.internal.measurement.j4;
import f9.x0;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kf.c0;
import kf.v;
import kf.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements s, pf.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nf.d f9780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x0 f9781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9784e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f9786h;
    public final p i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f9787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f9788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c2.o f9789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f9790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f9791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f9792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Socket f9793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Socket f9794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public kf.n f9795r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public v f9796s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l7.a f9797t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public o f9798u;

    public d(nf.d dVar, x0 x0Var, int i, int i10, int i11, int i12, boolean z10, n nVar, p pVar, c0 c0Var, List list, c2.o oVar, int i13, boolean z11) {
        ge.i.e(dVar, "taskRunner");
        ge.i.e(x0Var, "connectionPool");
        ge.i.e(c0Var, "route");
        this.f9780a = dVar;
        this.f9781b = x0Var;
        this.f9782c = i;
        this.f9783d = i10;
        this.f9784e = i11;
        this.f = i12;
        this.f9785g = z10;
        this.f9786h = nVar;
        this.i = pVar;
        this.f9787j = c0Var;
        this.f9788k = list;
        this.f9789l = oVar;
        this.f9790m = i13;
        this.f9791n = z11;
    }

    @Override // of.s
    public final boolean b() {
        return this.f9796s != null;
    }

    @Override // of.s
    public final s c() {
        return new d(this.f9780a, this.f9781b, this.f9782c, this.f9783d, this.f9784e, this.f, this.f9785g, this.f9786h, this.i, this.f9787j, this.f9788k, this.f9789l, this.f9790m, this.f9791n);
    }

    @Override // of.s, pf.e
    public final void cancel() {
        this.f9792o = true;
        Socket socket = this.f9793p;
        if (socket != null) {
            lf.f.b(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0171  */
    @Override // of.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final of.r d() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: of.d.d():of.r");
    }

    @Override // of.s
    public final o e() {
        this.f9786h.f9817v.f7570y.r(this.f9787j);
        o oVar = this.f9798u;
        ge.i.b(oVar);
        ge.i.e(this.f9787j, "route");
        q qVarE = this.i.e(this, this.f9788k);
        if (qVarE != null) {
            return qVarE.f9850a;
        }
        synchronized (oVar) {
            x0 x0Var = this.f9781b;
            x0Var.getClass();
            TimeZone timeZone = lf.f.f7964a;
            ((ConcurrentLinkedQueue) x0Var.f4474e).add(oVar);
            ((nf.c) x0Var.f4472c).d((nf.b) x0Var.f4473d, 0L);
            this.f9786h.b(oVar);
        }
        return oVar;
    }

    @Override // pf.e
    public final c0 f() {
        return this.f9787j;
    }

    @Override // of.s
    public final r g() {
        Socket socket;
        Socket socket2;
        x0 x0Var = this.f9781b;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f9786h.M;
        c0 c0Var = this.f9787j;
        if (this.f9793p != null) {
            throw new IllegalStateException("TCP already connected");
        }
        copyOnWriteArrayList.add(this);
        boolean z10 = false;
        try {
            try {
                ge.i.e(c0Var.f7454c, "inetSocketAddress");
                x0Var.getClass();
                i();
                z10 = true;
                r rVar = new r(this, (Throwable) null, 6);
                copyOnWriteArrayList.remove(this);
                return rVar;
            } catch (IOException e9) {
                kf.a aVar = c0Var.f7452a;
                if (c0Var.f7453b.type() != Proxy.Type.DIRECT) {
                    kf.a aVar2 = c0Var.f7452a;
                    aVar2.f7431g.connectFailed(aVar2.f7432h.g(), c0Var.f7453b.address(), e9);
                }
                ge.i.e(c0Var.f7454c, "inetSocketAddress");
                x0Var.getClass();
                r rVar2 = new r(this, e9, 2);
                copyOnWriteArrayList.remove(this);
                if (!z10 && (socket = this.f9793p) != null) {
                    lf.f.b(socket);
                }
                return rVar2;
            }
        } catch (Throwable th) {
            copyOnWriteArrayList.remove(this);
            if (!z10 && (socket2 = this.f9793p) != null) {
                lf.f.b(socket2);
            }
            throw th;
        }
    }

    public final void i() throws IOException {
        Socket socketCreateSocket;
        Proxy.Type type = this.f9787j.f7453b.type();
        int i = type == null ? -1 : c.f9779a[type.ordinal()];
        if (i == 1 || i == 2) {
            socketCreateSocket = this.f9787j.f7452a.f7427b.createSocket();
            ge.i.b(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(this.f9787j.f7453b);
        }
        this.f9793p = socketCreateSocket;
        if (this.f9792o) {
            throw new IOException("canceled");
        }
        socketCreateSocket.setSoTimeout(this.f);
        try {
            uf.f fVar = uf.f.f12506a;
            uf.f.f12506a.f(socketCreateSocket, this.f9787j.f7454c, this.f9784e);
            try {
                this.f9797t = new l7.a(new b6.f(socketCreateSocket));
            } catch (NullPointerException e9) {
                if (ge.i.a(e9.getMessage(), "throw with null exception")) {
                    throw new IOException(e9);
                }
            }
        } catch (ConnectException e10) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f9787j.f7454c);
            connectException.initCause(e10);
            throw connectException;
        }
    }

    public final void j(SSLSocket sSLSocket, kf.k kVar) {
        String strG;
        v vVarD;
        final kf.a aVar = this.f9787j.f7452a;
        try {
            if (kVar.f7490b) {
                uf.f fVar = uf.f.f12506a;
                uf.f.f12506a.e(sSLSocket, aVar.f7432h.f7518d, aVar.i);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            ge.i.b(session);
            final kf.n nVarN = n5.a.n(session);
            HostnameVerifier hostnameVerifier = aVar.f7429d;
            ge.i.b(hostnameVerifier);
            if (hostnameVerifier.verify(aVar.f7432h.f7518d, session)) {
                final kf.f fVar2 = aVar.f7430e;
                ge.i.b(fVar2);
                this.f9795r = new kf.n(nVarN.f7508a, nVarN.f7509b, nVarN.f7510c, new fe.a() { // from class: of.b
                    @Override // fe.a
                    public final Object b() {
                        w8.e eVar = fVar2.f7463b;
                        ge.i.b(eVar);
                        return eVar.e(aVar.f7432h.f7518d, nVarN.a());
                    }
                });
                ge.i.e(aVar.f7432h.f7518d, "hostname");
                Iterator it = fVar2.f7462a.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                if (kVar.f7490b) {
                    uf.f fVar3 = uf.f.f12506a;
                    strG = uf.f.f12506a.g(sSLSocket);
                } else {
                    strG = null;
                }
                this.f9794q = sSLSocket;
                this.f9797t = new l7.a(new b6.f(sSLSocket));
                if (strG != null) {
                    v.f7572w.getClass();
                    vVarD = kf.b.d(strG);
                } else {
                    vVarD = v.f7574y;
                }
                this.f9796s = vVarD;
                uf.f fVar4 = uf.f.f12506a;
                uf.f.f12506a.getClass();
                return;
            }
            List listA = nVarN.a();
            if (listA.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + aVar.f7432h.f7518d + " not verified (no certificates)");
            }
            Object obj = listA.get(0);
            ge.i.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            StringBuilder sb = new StringBuilder("\n            |Hostname ");
            sb.append(aVar.f7432h.f7518d);
            sb.append(" not verified:\n            |    certificate: ");
            kf.f fVar5 = kf.f.f7461c;
            sb.append(j4.A(x509Certificate));
            sb.append("\n            |    DN: ");
            sb.append(x509Certificate.getSubjectDN().getName());
            sb.append("\n            |    subjectAltNames: ");
            List listA2 = yf.c.a(x509Certificate, 7);
            List listA3 = yf.c.a(x509Certificate, 2);
            ArrayList arrayList = new ArrayList(listA3.size() + listA2.size());
            arrayList.addAll(listA2);
            arrayList.addAll(listA3);
            sb.append(arrayList);
            sb.append("\n            ");
            throw new SSLPeerUnverifiedException(ne.i.U(sb.toString()));
        } catch (Throwable th) {
            uf.f fVar6 = uf.f.f12506a;
            uf.f.f12506a.getClass();
            lf.f.b(sSLSocket);
            throw th;
        }
    }

    public final r k() throws IOException {
        c2.o oVar = this.f9789l;
        ge.i.b(oVar);
        c0 c0Var = this.f9787j;
        String str = "CONNECT " + lf.f.h(c0Var.f7452a.f7432h, true) + " HTTP/1.1";
        l7.a aVar = this.f9797t;
        if (aVar == null) {
            ge.i.i("socket");
            throw null;
        }
        qf.g gVar = new qf.g(null, this, aVar);
        l7.a aVar2 = this.f9797t;
        if (aVar2 == null) {
            ge.i.i("socket");
            throw null;
        }
        y yVarD = ((ag.q) aVar2.f7867x).f459v.d();
        long j4 = this.f9782c;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        yVarD.g(j4);
        l7.a aVar3 = this.f9797t;
        if (aVar3 == null) {
            ge.i.i("socket");
            throw null;
        }
        ((ag.p) aVar3.f7868y).f456v.d().g(this.f9783d);
        gVar.l((kf.p) oVar.f2037d, str);
        gVar.b();
        kf.y yVarI = gVar.i(false);
        ge.i.b(yVarI);
        yVarI.f7581a = oVar;
        z zVarA = yVarI.a();
        int i = zVarA.f7597y;
        long jD = lf.f.d(zVarA);
        if (jD != -1) {
            qf.d dVarK = gVar.k((kf.q) zVarA.f7594v.f2035b, jD);
            lf.f.f(dVarK, Integer.MAX_VALUE);
            dVarK.close();
        }
        if (i == 200) {
            return new r(this, (Throwable) null, 6);
        }
        if (i != 407) {
            throw new IOException(l0.e.g(i, "Unexpected response code for CONNECT: "));
        }
        c0Var.f7452a.f.getClass();
        throw new IOException("Failed to authenticate with proxy");
    }

    public final d l(List list, SSLSocket sSLSocket) {
        String[] strArr;
        String[] strArr2;
        ge.i.e(list, "connectionSpecs");
        int i = this.f9790m;
        int size = list.size();
        for (int i10 = i + 1; i10 < size; i10++) {
            kf.k kVar = (kf.k) list.get(i10);
            kVar.getClass();
            if (kVar.f7489a && (((strArr = kVar.f7492d) == null || lf.d.e(strArr, sSLSocket.getEnabledProtocols(), ud.a.f12450w)) && ((strArr2 = kVar.f7491c) == null || lf.d.e(strArr2, sSLSocket.getEnabledCipherSuites(), kf.h.f7465c)))) {
                return new d(this.f9780a, this.f9781b, this.f9782c, this.f9783d, this.f9784e, this.f, this.f9785g, this.f9786h, this.i, this.f9787j, this.f9788k, this.f9789l, i10, i != -1);
            }
        }
        return null;
    }

    public final d m(List list, SSLSocket sSLSocket) throws UnknownServiceException {
        ge.i.e(list, "connectionSpecs");
        if (this.f9790m != -1) {
            return this;
        }
        d dVarL = l(list, sSLSocket);
        if (dVarL != null) {
            return dVarL;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f9791n);
        sb.append(", modes=");
        sb.append(list);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        ge.i.b(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        ge.i.d(string, "toString(...)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // pf.e
    public final void h() {
    }

    @Override // pf.e
    public final void a(n nVar, IOException iOException) {
    }
}
