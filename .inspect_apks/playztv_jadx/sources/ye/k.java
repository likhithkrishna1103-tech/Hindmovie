package ye;

import bf.b0;
import bf.p;
import bf.x;
import cf.n;
import hf.q;
import hf.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k8.r0;
import k8.t0;
import ue.a0;
import ue.m;
import ue.o;
import ue.s;
import ue.t;
import ue.v;
import ue.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends bf.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f14728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Socket f14729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Socket f14730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ue.l f14731e;
    public t f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f14732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f14733h;
    public hf.p i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14738n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14739o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f14740p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f14741q;

    public k(t0 t0Var, a0 a0Var) {
        be.h.e(t0Var, "connectionPool");
        be.h.e(a0Var, "route");
        this.f14728b = a0Var;
        this.f14739o = 1;
        this.f14740p = new ArrayList();
        this.f14741q = Long.MAX_VALUE;
    }

    public static void d(s sVar, a0 a0Var, IOException iOException) {
        be.h.e(a0Var, "failedRoute");
        be.h.e(iOException, "failure");
        if (a0Var.f12932b.type() != Proxy.Type.DIRECT) {
            ue.a aVar = a0Var.f12931a;
            aVar.f12928g.connectFailed(aVar.f12929h.g(), a0Var.f12932b.address(), iOException);
        }
        o4.c cVar = sVar.S;
        synchronized (cVar) {
            ((LinkedHashSet) cVar.f9349u).add(a0Var);
        }
    }

    @Override // bf.h
    public final synchronized void a(p pVar, b0 b0Var) {
        be.h.e(b0Var, "settings");
        this.f14739o = (b0Var.f2055a & 16) != 0 ? b0Var.f2056b[4] : Integer.MAX_VALUE;
    }

    @Override // bf.h
    public final void b(x xVar) {
        xVar.c(8, null);
    }

    public final void c(int i, int i10, int i11, boolean z2, h hVar) throws Throwable {
        a0 a0Var;
        if (this.f != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.f14728b.f12931a.f12930j;
        r0 r0Var = new r0(list);
        ue.a aVar = this.f14728b.f12931a;
        if (aVar.f12925c == null) {
            if (!list.contains(ue.i.f)) {
                throw new l(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.f14728b.f12931a.f12929h.f13011d;
            n nVar = n.f2753a;
            if (!n.f2753a.h(str)) {
                throw new l(new UnknownServiceException(e6.j.n("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (aVar.i.contains(t.f13050z)) {
            throw new l(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        l lVar = null;
        do {
            try {
                a0 a0Var2 = this.f14728b;
                if (a0Var2.f12931a.f12925c != null && a0Var2.f12932b.type() == Proxy.Type.HTTP) {
                    f(i, i10, i11, hVar);
                    if (this.f14729c == null) {
                    }
                    a0Var = this.f14728b;
                    if (a0Var.f12931a.f12925c == null && a0Var.f12932b.type() == Proxy.Type.HTTP && this.f14729c == null) {
                        throw new l(new ProtocolException("Too many tunnel connections attempted: 21"));
                    }
                    this.f14741q = System.nanoTime();
                    return;
                }
                e(i, i10, hVar);
                g(r0Var, hVar);
                be.h.e(this.f14728b.f12933c, "inetSocketAddress");
                a0Var = this.f14728b;
                if (a0Var.f12931a.f12925c == null) {
                }
                this.f14741q = System.nanoTime();
                return;
            } catch (IOException e10) {
                Socket socket = this.f14730d;
                if (socket != null) {
                    ve.b.d(socket);
                }
                Socket socket2 = this.f14729c;
                if (socket2 != null) {
                    ve.b.d(socket2);
                }
                this.f14730d = null;
                this.f14729c = null;
                this.f14733h = null;
                this.i = null;
                this.f14731e = null;
                this.f = null;
                this.f14732g = null;
                this.f14739o = 1;
                be.h.e(this.f14728b.f12933c, "inetSocketAddress");
                if (lVar == null) {
                    lVar = new l(e10);
                } else {
                    com.bumptech.glide.d.d(lVar.f14742u, e10);
                    lVar.f14743v = e10;
                }
                if (!z2) {
                    throw lVar;
                }
                r0Var.f7390c = true;
                if (!r0Var.f7389b) {
                    throw lVar;
                }
                if (e10 instanceof ProtocolException) {
                    throw lVar;
                }
                if (e10 instanceof InterruptedIOException) {
                    throw lVar;
                }
                if ((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) {
                    throw lVar;
                }
                if (e10 instanceof SSLPeerUnverifiedException) {
                    throw lVar;
                }
            }
        } while (e10 instanceof SSLException);
        throw lVar;
    }

    public final void e(int i, int i10, h hVar) throws IOException {
        Socket socketCreateSocket;
        a0 a0Var = this.f14728b;
        Proxy proxy = a0Var.f12932b;
        ue.a aVar = a0Var.f12931a;
        Proxy.Type type = proxy.type();
        int i11 = type == null ? -1 : i.f14724a[type.ordinal()];
        if (i11 == 1 || i11 == 2) {
            socketCreateSocket = aVar.f12924b.createSocket();
            be.h.b(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.f14729c = socketCreateSocket;
        be.h.e(this.f14728b.f12933c, "inetSocketAddress");
        socketCreateSocket.setSoTimeout(i10);
        try {
            n nVar = n.f2753a;
            n.f2753a.e(socketCreateSocket, this.f14728b.f12933c, i);
            try {
                this.f14733h = new q(cf.l.B(socketCreateSocket));
                this.i = new hf.p(cf.l.z(socketCreateSocket));
            } catch (NullPointerException e10) {
                if (be.h.a(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f14728b.f12933c);
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void f(int i, int i10, int i11, h hVar) throws IOException {
        zc.c cVar = new zc.c();
        a0 a0Var = this.f14728b;
        o oVar = a0Var.f12931a.f12929h;
        be.h.e(oVar, "url");
        cVar.f14945u = oVar;
        cVar.q("CONNECT", null);
        ue.a aVar = a0Var.f12931a;
        cVar.p("Host", ve.b.u(aVar.f12929h, true));
        cVar.p("Proxy-Connection", "Keep-Alive");
        cVar.p("User-Agent", "okhttp/4.12.0");
        b2.g gVarM = cVar.m();
        q2.d dVar = new q2.d(2);
        v.a("Proxy-Authenticate");
        v.b("OkHttp-Preemptive", "Proxy-Authenticate");
        dVar.i("Proxy-Authenticate");
        dVar.f("Proxy-Authenticate", "OkHttp-Preemptive");
        dVar.g();
        aVar.f.getClass();
        o oVar2 = (o) gVarM.f1737b;
        e(i, i10, hVar);
        String str = "CONNECT " + ve.b.u(oVar2, true) + " HTTP/1.1";
        q qVar = this.f14733h;
        be.h.b(qVar);
        hf.p pVar = this.i;
        be.h.b(pVar);
        af.h hVar2 = new af.h(null, this, qVar, pVar);
        y yVarC = qVar.f6140u.c();
        long j5 = i10;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        yVarC.g(j5);
        pVar.f6137u.c().g(i11);
        hVar2.k((m) gVarM.f1739d, str);
        hVar2.b();
        w wVarG = hVar2.g(false);
        be.h.b(wVarG);
        wVarG.f13055a = gVarM;
        ue.x xVarA = wVarG.a();
        int i12 = xVarA.f13069x;
        long jI = ve.b.i(xVarA);
        if (jI != -1) {
            af.e eVarJ = hVar2.j(jI);
            ve.b.s(eVarJ, Integer.MAX_VALUE);
            eVarJ.close();
        }
        if (i12 != 200) {
            if (i12 != 407) {
                throw new IOException(e6.j.l("Unexpected response code for CONNECT: ", i12));
            }
            aVar.f.getClass();
            throw new IOException("Failed to authenticate with proxy");
        }
        if (!qVar.f6141v.v() || !pVar.f6138v.v()) {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(r0 r0Var, h hVar) throws Throwable {
        t tVarJ = t.f13047w;
        ue.a aVar = this.f14728b.f12931a;
        SSLSocketFactory sSLSocketFactory = aVar.f12925c;
        if (sSLSocketFactory == null) {
            List list = aVar.i;
            t tVar = t.f13050z;
            if (!list.contains(tVar)) {
                this.f14730d = this.f14729c;
                this.f = tVarJ;
                return;
            } else {
                this.f14730d = this.f14729c;
                this.f = tVar;
                m();
                return;
            }
        }
        SSLSocket sSLSocket = null;
        String strF = null;
        try {
            be.h.b(sSLSocketFactory);
            Socket socket = this.f14729c;
            o oVar = aVar.f12929h;
            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, oVar.f13011d, oVar.f13012e, true);
            be.h.c(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                ue.i iVarA = r0Var.a(sSLSocket2);
                if (iVarA.f12978b) {
                    n nVar = n.f2753a;
                    n.f2753a.d(sSLSocket2, aVar.f12929h.f13011d, aVar.i);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                be.h.d(session, "sslSocketSession");
                ue.l lVarH = v.h(session);
                HostnameVerifier hostnameVerifier = aVar.f12926d;
                be.h.b(hostnameVerifier);
                if (!hostnameVerifier.verify(aVar.f12929h.f13011d, session)) {
                    List listA = lVarH.a();
                    if (listA.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + aVar.f12929h.f13011d + " not verified (no certificates)");
                    }
                    Object obj = listA.get(0);
                    be.h.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate = (X509Certificate) obj;
                    StringBuilder sb2 = new StringBuilder("\n              |Hostname ");
                    sb2.append(aVar.f12929h.f13011d);
                    sb2.append(" not verified:\n              |    certificate: ");
                    ue.f fVar = ue.f.f12955c;
                    sb2.append(v.m(x509Certificate));
                    sb2.append("\n              |    DN: ");
                    sb2.append(x509Certificate.getSubjectDN().getName());
                    sb2.append("\n              |    subjectAltNames: ");
                    sb2.append(gf.c.a(x509Certificate));
                    sb2.append("\n              ");
                    throw new SSLPeerUnverifiedException(ie.g.E(sb2.toString()));
                }
                ue.f fVar2 = aVar.f12927e;
                be.h.b(fVar2);
                this.f14731e = new ue.l(lVarH.f12995a, lVarH.f12996b, lVarH.f12997c, new j(fVar2, lVarH, aVar));
                be.h.e(aVar.f12929h.f13011d, "hostname");
                Iterator it = fVar2.f12956a.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                if (iVarA.f12978b) {
                    n nVar2 = n.f2753a;
                    strF = n.f2753a.f(sSLSocket2);
                }
                this.f14730d = sSLSocket2;
                this.f14733h = new q(cf.l.B(sSLSocket2));
                this.i = new hf.p(cf.l.z(sSLSocket2));
                if (strF != null) {
                    tVarJ = v.j(strF);
                }
                this.f = tVarJ;
                n nVar3 = n.f2753a;
                n.f2753a.a(sSLSocket2);
                if (this.f == t.f13049y) {
                    m();
                }
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    n nVar4 = n.f2753a;
                    n.f2753a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    ve.b.d(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized void h() {
        this.f14737m++;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(ue.a r11, java.util.List r12) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ye.k.i(ue.a, java.util.List):boolean");
    }

    public final boolean j(boolean z2) {
        long j5;
        byte[] bArr = ve.b.f13497a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f14729c;
        be.h.b(socket);
        Socket socket2 = this.f14730d;
        be.h.b(socket2);
        be.h.b(this.f14733h);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        p pVar = this.f14732g;
        if (pVar != null) {
            return pVar.v(jNanoTime);
        }
        synchronized (this) {
            j5 = jNanoTime - this.f14741q;
        }
        if (j5 < 10000000000L || !z2) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !r4.a();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final ze.d k(s sVar, ze.f fVar) throws SocketException {
        int i = fVar.f14972g;
        Socket socket = this.f14730d;
        be.h.b(socket);
        q qVar = this.f14733h;
        be.h.b(qVar);
        hf.p pVar = this.i;
        be.h.b(pVar);
        p pVar2 = this.f14732g;
        if (pVar2 != null) {
            return new bf.q(sVar, this, fVar, pVar2);
        }
        socket.setSoTimeout(i);
        y yVarC = qVar.f6140u.c();
        long j5 = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        yVarC.g(j5);
        pVar.f6137u.c().g(fVar.f14973h);
        return new af.h(sVar, this, qVar, pVar);
    }

    public final synchronized void l() {
        this.f14734j = true;
    }

    public final void m() throws SocketException {
        Socket socket = this.f14730d;
        be.h.b(socket);
        q qVar = this.f14733h;
        be.h.b(qVar);
        hf.p pVar = this.i;
        be.h.b(pVar);
        socket.setSoTimeout(0);
        xe.c cVar = xe.c.i;
        b2.g gVar = new b2.g(cVar);
        String str = this.f14728b.f12931a.f12929h.f13011d;
        be.h.e(str, "peerName");
        gVar.f1738c = socket;
        String str2 = ve.b.f13502g + ' ' + str;
        be.h.e(str2, "<set-?>");
        gVar.f1739d = str2;
        gVar.f1740e = qVar;
        gVar.f = pVar;
        gVar.f1741g = this;
        p pVar2 = new p(gVar);
        this.f14732g = pVar2;
        b0 b0Var = p.T;
        this.f14739o = (b0Var.f2055a & 16) != 0 ? b0Var.f2056b[4] : Integer.MAX_VALUE;
        bf.y yVar = pVar2.Q;
        synchronized (yVar) {
            try {
                if (yVar.f2143x) {
                    throw new IOException("closed");
                }
                Logger logger = bf.y.f2139z;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(ve.b.g(">> CONNECTION " + bf.f.f2073a.b(), new Object[0]));
                }
                yVar.f2140u.g(bf.f.f2073a);
                yVar.f2140u.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
        pVar2.Q.J(pVar2.J);
        if (pVar2.J.a() != 65535) {
            pVar2.Q.K(0, r1 - 65535);
        }
        cVar.e().c(new bf.n(pVar2.f2095w, pVar2.R, 1), 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Connection{");
        a0 a0Var = this.f14728b;
        sb2.append(a0Var.f12931a.f12929h.f13011d);
        sb2.append(':');
        sb2.append(a0Var.f12931a.f12929h.f13012e);
        sb2.append(", proxy=");
        sb2.append(a0Var.f12932b);
        sb2.append(" hostAddress=");
        sb2.append(a0Var.f12933c);
        sb2.append(" cipherSuite=");
        ue.l lVar = this.f14731e;
        if (lVar == null || (obj = lVar.f12996b) == null) {
            obj = "none";
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.f);
        sb2.append('}');
        return sb2.toString();
    }
}
