package af;

import aa.l0;
import e6.j;
import hf.p;
import hf.q;
import hf.u;
import hf.w;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import ue.m;
import ue.o;
import ue.s;
import ue.t;
import ue.x;
import ye.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements ze.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f817e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f818g;

    public h(s sVar, k kVar, q qVar, p pVar) {
        be.h.e(qVar, "source");
        be.h.e(pVar, "sink");
        this.f814b = sVar;
        this.f815c = kVar;
        this.f816d = qVar;
        this.f817e = pVar;
        this.f = new a(qVar);
    }

    @Override // ze.d
    public long a(x xVar) {
        if (!ze.e.a(xVar)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(x.a("Transfer-Encoding", xVar))) {
            return -1L;
        }
        return ve.b.i(xVar);
    }

    @Override // ze.d
    public void b() {
        ((hf.g) this.f817e).flush();
    }

    @Override // ze.d
    public void c() {
        ((hf.g) this.f817e).flush();
    }

    @Override // ze.d
    public void cancel() {
        Socket socket = ((k) this.f815c).f14729c;
        if (socket != null) {
            ve.b.d(socket);
        }
    }

    @Override // ze.d
    public w d(x xVar) {
        if (!ze.e.a(xVar)) {
            return j(0L);
        }
        if ("chunked".equalsIgnoreCase(x.a("Transfer-Encoding", xVar))) {
            o oVar = (o) xVar.f13066u.f1737b;
            if (this.f813a == 4) {
                this.f813a = 5;
                return new d(this, oVar);
            }
            throw new IllegalStateException(("state: " + this.f813a).toString());
        }
        long jI = ve.b.i(xVar);
        if (jI != -1) {
            return j(jI);
        }
        if (this.f813a == 4) {
            this.f813a = 5;
            ((k) this.f815c).l();
            return new g(this);
        }
        throw new IllegalStateException(("state: " + this.f813a).toString());
    }

    @Override // ze.d
    public void e(b2.g gVar) {
        Proxy.Type type = ((k) this.f815c).f14728b.f12932b.type();
        be.h.d(type, "connection.route().proxy.type()");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((String) gVar.f1738c);
        sb2.append(' ');
        o oVar = (o) gVar.f1737b;
        if (oVar.i || type != Proxy.Type.HTTP) {
            String strB = oVar.b();
            String strD = oVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb2.append(strB);
        } else {
            sb2.append(oVar);
        }
        sb2.append(" HTTP/1.1");
        String string = sb2.toString();
        be.h.d(string, "StringBuilder().apply(builderAction).toString()");
        k((m) gVar.f1739d, string);
    }

    @Override // ze.d
    public u f(b2.g gVar, long j5) {
        if ("chunked".equalsIgnoreCase(((m) gVar.f1739d).b("Transfer-Encoding"))) {
            if (this.f813a == 1) {
                this.f813a = 2;
                return new c(this);
            }
            throw new IllegalStateException(("state: " + this.f813a).toString());
        }
        if (j5 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f813a == 1) {
            this.f813a = 2;
            return new f(this);
        }
        throw new IllegalStateException(("state: " + this.f813a).toString());
    }

    @Override // ze.d
    public ue.w g(boolean z2) throws IOException {
        a aVar = (a) this.f;
        int i = this.f813a;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.f813a).toString());
        }
        try {
            String strM = ((hf.h) aVar.f797w).M(aVar.f796v);
            aVar.f796v -= (long) strM.length();
            l0 l0VarU = b8.h.u(strM);
            int i10 = l0VarU.f705v;
            ue.w wVar = new ue.w();
            wVar.f13056b = (t) l0VarU.f706w;
            wVar.f13057c = i10;
            wVar.f13058d = (String) l0VarU.f707x;
            wVar.f = aVar.I().e();
            if (z2 && i10 == 100) {
                return null;
            }
            if (i10 == 100) {
                this.f813a = 3;
                return wVar;
            }
            if (102 > i10 || i10 >= 200) {
                this.f813a = 4;
                return wVar;
            }
            this.f813a = 3;
            return wVar;
        } catch (EOFException e10) {
            throw new IOException("unexpected end of stream on ".concat(((k) this.f815c).f14728b.f12931a.f12929h.f()), e10);
        }
    }

    @Override // ze.d
    public k h() {
        return (k) this.f815c;
    }

    public pb.a i() {
        String strM = this.f813a == 0 ? " registrationStatus" : "";
        if (((Long) this.f817e) == null) {
            strM = strM.concat(" expiresInSecs");
        }
        if (((Long) this.f) == null) {
            strM = j.m(strM, " tokenCreationEpochInSecs");
        }
        if (strM.isEmpty()) {
            return new pb.a((String) this.f814b, this.f813a, (String) this.f815c, (String) this.f816d, ((Long) this.f817e).longValue(), ((Long) this.f).longValue(), (String) this.f818g);
        }
        throw new IllegalStateException("Missing required properties:".concat(strM));
    }

    public e j(long j5) {
        if (this.f813a == 4) {
            this.f813a = 5;
            return new e(this, j5);
        }
        throw new IllegalStateException(("state: " + this.f813a).toString());
    }

    public void k(m mVar, String str) {
        hf.g gVar = (hf.g) this.f817e;
        be.h.e(str, "requestLine");
        if (this.f813a != 0) {
            throw new IllegalStateException(("state: " + this.f813a).toString());
        }
        gVar.Y(str).Y("\r\n");
        int size = mVar.size();
        for (int i = 0; i < size; i++) {
            gVar.Y(mVar.d(i)).Y(": ").Y(mVar.h(i)).Y("\r\n");
        }
        gVar.Y("\r\n");
        this.f813a = 1;
    }
}
