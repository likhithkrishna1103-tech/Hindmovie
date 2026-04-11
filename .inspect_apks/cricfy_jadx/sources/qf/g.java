package qf;

import ag.q;
import ag.v;
import ag.w;
import c2.o;
import f9.s0;
import ge.i;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.util.Arrays;
import kf.p;
import kf.u;
import kf.y;
import kf.z;
import ne.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements pf.f {
    public static final p f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f10823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pf.e f10824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l7.a f10825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s0 f10827e;

    static {
        p pVar = p.f7513w;
        String[] strArr = (String[]) Arrays.copyOf(new String[]{"OkHttp-Response-Body", "Truncated"}, 2);
        i.e(strArr, "inputNamesAndValues");
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        int length = strArr2.length;
        int i = 0;
        for (int i10 = 0; i10 < length; i10++) {
            if (strArr2[i10] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i10] = h.t0(strArr[i10]).toString();
        }
        int iR = com.bumptech.glide.c.r(0, strArr2.length - 1, 2);
        if (iR >= 0) {
            while (true) {
                String str = strArr2[i];
                String str2 = strArr2[i + 1];
                n5.a.t(str);
                n5.a.u(str2, str);
                if (i == iR) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        f = new p(strArr2);
    }

    public g(u uVar, pf.e eVar, l7.a aVar) {
        i.e(aVar, "socket");
        this.f10823a = uVar;
        this.f10824b = eVar;
        this.f10825c = aVar;
        this.f10827e = new s0((q) aVar.f7867x);
    }

    @Override // pf.f
    public final long a(z zVar) {
        if (!pf.g.a(zVar)) {
            return 0L;
        }
        String strA = zVar.A.a("Transfer-Encoding");
        if (strA == null) {
            strA = null;
        }
        if ("chunked".equalsIgnoreCase(strA)) {
            return -1L;
        }
        return lf.f.d(zVar);
    }

    @Override // pf.f
    public final void b() {
        ((ag.p) this.f10825c.f7868y).flush();
    }

    @Override // pf.f
    public final boolean c() {
        return this.f10826d == 6;
    }

    @Override // pf.f
    public final void cancel() {
        this.f10824b.cancel();
    }

    @Override // pf.f
    public final void d() {
        ((ag.p) this.f10825c.f7868y).flush();
    }

    @Override // pf.f
    public final v e() {
        return this.f10825c;
    }

    @Override // pf.f
    public final pf.e f() {
        return this.f10824b;
    }

    @Override // pf.f
    public final void g(o oVar) {
        Proxy.Type type = this.f10824b.f().f7453b.type();
        i.d(type, "type(...)");
        StringBuilder sb = new StringBuilder();
        sb.append((String) oVar.f2036c);
        sb.append(' ');
        kf.q qVar = (kf.q) oVar.f2035b;
        if (i.a(qVar.f7515a, "https") || type != Proxy.Type.HTTP) {
            String strB = qVar.b();
            String strD = qVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        } else {
            sb.append(qVar);
        }
        sb.append(" HTTP/1.1");
        l((p) oVar.f2037d, sb.toString());
    }

    @Override // pf.f
    public final w h(z zVar) {
        o oVar = zVar.f7594v;
        if (!pf.g.a(zVar)) {
            return k((kf.q) oVar.f2035b, 0L);
        }
        String strA = zVar.A.a("Transfer-Encoding");
        if (strA == null) {
            strA = null;
        }
        if ("chunked".equalsIgnoreCase(strA)) {
            kf.q qVar = (kf.q) oVar.f2035b;
            if (this.f10826d == 4) {
                this.f10826d = 5;
                return new c(this, qVar);
            }
            throw new IllegalStateException(("state: " + this.f10826d).toString());
        }
        long jD = lf.f.d(zVar);
        if (jD != -1) {
            return k((kf.q) oVar.f2035b, jD);
        }
        kf.q qVar2 = (kf.q) oVar.f2035b;
        if (this.f10826d != 4) {
            throw new IllegalStateException(("state: " + this.f10826d).toString());
        }
        this.f10826d = 5;
        this.f10824b.h();
        i.e(qVar2, "url");
        return new f(this, qVar2);
    }

    @Override // pf.f
    public final y i(boolean z10) {
        s0 s0Var = this.f10827e;
        int i = this.f10826d;
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.f10826d).toString());
        }
        try {
            String strI = ((ag.g) s0Var.f4391x).I(s0Var.f4390w);
            s0Var.f4390w -= (long) strI.length();
            f3.a aVarO = w4.v.o(strI);
            int i10 = aVarO.f3935w;
            y yVar = new y();
            yVar.f7582b = (kf.v) aVarO.f3936x;
            yVar.f7583c = i10;
            yVar.f7584d = (String) aVarO.f3937y;
            yVar.f = s0Var.I().c();
            if (z10 && i10 == 100) {
                return null;
            }
            if (i10 == 100) {
                this.f10826d = 3;
                return yVar;
            }
            if (102 > i10 || i10 >= 200) {
                this.f10826d = 4;
                return yVar;
            }
            this.f10826d = 3;
            return yVar;
        } catch (EOFException e9) {
            throw new IOException(q4.a.n("unexpected end of stream on ", this.f10824b.f().f7452a.f7432h.f()), e9);
        }
    }

    @Override // pf.f
    public final ag.u j(o oVar, long j4) {
        if ("chunked".equalsIgnoreCase(((p) oVar.f2037d).a("Transfer-Encoding"))) {
            if (this.f10826d == 1) {
                this.f10826d = 2;
                return new b(this);
            }
            throw new IllegalStateException(("state: " + this.f10826d).toString());
        }
        if (j4 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f10826d == 1) {
            this.f10826d = 2;
            return new e(this);
        }
        throw new IllegalStateException(("state: " + this.f10826d).toString());
    }

    public final d k(kf.q qVar, long j4) {
        if (this.f10826d == 4) {
            this.f10826d = 5;
            return new d(this, qVar, j4);
        }
        throw new IllegalStateException(("state: " + this.f10826d).toString());
    }

    public final void l(p pVar, String str) {
        i.e(pVar, "headers");
        i.e(str, "requestLine");
        if (this.f10826d != 0) {
            throw new IllegalStateException(("state: " + this.f10826d).toString());
        }
        l7.a aVar = this.f10825c;
        ag.p pVar2 = (ag.p) aVar.f7868y;
        ag.p pVar3 = (ag.p) aVar.f7868y;
        pVar2.g(str);
        pVar2.g("\r\n");
        int size = pVar.size();
        for (int i = 0; i < size; i++) {
            pVar3.g(pVar.b(i));
            pVar3.g(": ");
            pVar3.g(pVar.f(i));
            pVar3.g("\r\n");
        }
        pVar3.g("\r\n");
        this.f10826d = 1;
    }
}
