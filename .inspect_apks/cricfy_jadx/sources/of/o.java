package of;

import f9.x0;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import kf.c0;
import kf.v;
import rf.d0;
import rf.y;
import rf.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends rf.n implements pf.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nf.d f9822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f9823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Socket f9824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Socket f9825e;
    public final kf.n f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f9826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l7.a f9827h;
    public rf.q i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9832n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9833o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f9834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f9835q;

    public o(nf.d dVar, x0 x0Var, c0 c0Var, Socket socket, Socket socket2, kf.n nVar, v vVar, l7.a aVar) {
        ge.i.e(dVar, "taskRunner");
        ge.i.e(x0Var, "connectionPool");
        ge.i.e(c0Var, "route");
        ge.i.e(socket, "rawSocket");
        ge.i.e(socket2, "javaNetSocket");
        ge.i.e(vVar, "protocol");
        ge.i.e(aVar, "socket");
        this.f9822b = dVar;
        this.f9823c = c0Var;
        this.f9824d = socket;
        this.f9825e = socket2;
        this.f = nVar;
        this.f9826g = vVar;
        this.f9827h = aVar;
        this.f9833o = 1;
        this.f9834p = new ArrayList();
        this.f9835q = Long.MAX_VALUE;
    }

    public static void d(kf.u uVar, c0 c0Var, IOException iOException) {
        ge.i.e(c0Var, "failedRoute");
        ge.i.e(iOException, "failure");
        if (c0Var.f7453b.type() != Proxy.Type.DIRECT) {
            kf.a aVar = c0Var.f7452a;
            aVar.f7431g.connectFailed(aVar.f7432h.g(), c0Var.f7453b.address(), iOException);
        }
        m2.e eVar = uVar.f7570y;
        synchronized (eVar) {
            ((LinkedHashSet) eVar.f8050v).add(c0Var);
        }
    }

    @Override // pf.e
    public final void a(n nVar, IOException iOException) {
        synchronized (this) {
            try {
                if (!(iOException instanceof d0)) {
                    if (!(this.i != null) || (iOException instanceof rf.a)) {
                        this.f9828j = true;
                        if (this.f9831m == 0) {
                            if (iOException != null) {
                                d(nVar.f9817v, this.f9823c, iOException);
                            }
                            this.f9830l++;
                        }
                    }
                } else if (((d0) iOException).f11064v == rf.b.B) {
                    int i = this.f9832n + 1;
                    this.f9832n = i;
                    if (i > 1) {
                        this.f9828j = true;
                        this.f9830l++;
                    }
                } else if (((d0) iOException).f11064v != rf.b.C || !nVar.K) {
                    this.f9828j = true;
                    this.f9830l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // rf.n
    public final void b(rf.q qVar, rf.c0 c0Var) {
        ge.i.e(c0Var, "settings");
        synchronized (this) {
            this.f9833o = (c0Var.f11055a & 8) != 0 ? c0Var.f11056b[3] : Integer.MAX_VALUE;
        }
    }

    @Override // rf.n
    public final void c(y yVar) {
        yVar.c(rf.b.B, null);
    }

    @Override // pf.e
    public final void cancel() {
        lf.f.b(this.f9824d);
    }

    public final void e() {
        synchronized (this) {
            this.f9831m++;
        }
    }

    @Override // pf.e
    public final c0 f() {
        return this.f9823c;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(kf.a r11, java.util.List r12) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: of.o.g(kf.a, java.util.List):boolean");
    }

    @Override // pf.e
    public final void h() {
        synchronized (this) {
            this.f9828j = true;
        }
    }

    public final boolean i(boolean z10) {
        long j4;
        TimeZone timeZone = lf.f.f7964a;
        long jNanoTime = System.nanoTime();
        if (this.f9824d.isClosed() || this.f9825e.isClosed() || this.f9825e.isInputShutdown() || this.f9825e.isOutputShutdown()) {
            return false;
        }
        rf.q qVar = this.i;
        if (qVar != null) {
            return qVar.q(jNanoTime);
        }
        synchronized (this) {
            j4 = jNanoTime - this.f9835q;
        }
        if (j4 < 10000000000L || !z10) {
            return true;
        }
        Socket socket = this.f9825e;
        ag.q qVar2 = (ag.q) this.f9827h.f7867x;
        ge.i.e(socket, "<this>");
        ge.i.e(qVar2, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !qVar2.a();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final void j() throws SocketException {
        this.f9835q = System.nanoTime();
        v vVar = this.f9826g;
        if (vVar == v.A || vVar == v.B) {
            this.f9825e.setSoTimeout(0);
            rf.c cVar = rf.c.f11054a;
            dd.c cVar2 = new dd.c(this.f9822b);
            l7.a aVar = this.f9827h;
            String str = this.f9823c.f7452a.f7432h.f7518d;
            ge.i.e(aVar, "socket");
            ge.i.e(str, "peerName");
            cVar2.f3673x = aVar;
            String str2 = lf.f.f7965b + ' ' + str;
            ge.i.e(str2, "<set-?>");
            cVar2.f3674y = str2;
            cVar2.f3675z = this;
            cVar2.A = cVar;
            rf.q qVar = new rf.q(cVar2);
            this.i = qVar;
            rf.c0 c0Var = rf.q.U;
            this.f9833o = (c0Var.f11055a & 8) != 0 ? c0Var.f11056b[3] : Integer.MAX_VALUE;
            z zVar = qVar.R;
            synchronized (zVar) {
                try {
                    if (zVar.f11142y) {
                        throw new IOException("closed");
                    }
                    Logger logger = z.A;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(lf.f.c(">> CONNECTION " + rf.h.f11080a.b(), new Object[0]));
                    }
                    zVar.f11139v.u(rf.h.f11080a);
                    zVar.f11139v.flush();
                } catch (Throwable th) {
                    throw th;
                }
            }
            qVar.R.J(qVar.L);
            if (qVar.L.a() != 65535) {
                qVar.R.O(0, r2 - 65535);
            }
            nf.c.c(qVar.B.d(), qVar.f11105x, qVar.S);
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        c0 c0Var = this.f9823c;
        sb.append(c0Var.f7452a.f7432h.f7518d);
        sb.append(':');
        sb.append(c0Var.f7452a.f7432h.f7519e);
        sb.append(", proxy=");
        sb.append(c0Var.f7453b);
        sb.append(" hostAddress=");
        sb.append(c0Var.f7454c);
        sb.append(" cipherSuite=");
        kf.n nVar = this.f;
        if (nVar == null || (obj = nVar.f7509b) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f9826g);
        sb.append('}');
        return sb.toString();
    }
}
