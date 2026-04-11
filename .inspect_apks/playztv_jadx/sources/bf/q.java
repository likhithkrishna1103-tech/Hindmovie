package bf;

import aa.l0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements ze.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f2099g = ve.b.j("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f2100h = ve.b.j("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ye.k f2101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.f f2102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f2103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile x f2104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ue.t f2105e;
    public volatile boolean f;

    public q(ue.s sVar, ye.k kVar, ze.f fVar, p pVar) {
        be.h.e(pVar, "http2Connection");
        this.f2101a = kVar;
        this.f2102b = fVar;
        this.f2103c = pVar;
        List list = sVar.L;
        ue.t tVar = ue.t.f13050z;
        this.f2105e = list.contains(tVar) ? tVar : ue.t.f13049y;
    }

    @Override // ze.d
    public final long a(ue.x xVar) {
        if (ze.e.a(xVar)) {
            return ve.b.i(xVar);
        }
        return 0L;
    }

    @Override // ze.d
    public final void b() {
        x xVar = this.f2104d;
        be.h.b(xVar);
        xVar.g().close();
    }

    @Override // ze.d
    public final void c() {
        this.f2103c.flush();
    }

    @Override // ze.d
    public final void cancel() {
        this.f = true;
        x xVar = this.f2104d;
        if (xVar != null) {
            xVar.e(9);
        }
    }

    @Override // ze.d
    public final hf.w d(ue.x xVar) {
        x xVar2 = this.f2104d;
        be.h.b(xVar2);
        return xVar2.i;
    }

    @Override // ze.d
    public final void e(b2.g gVar) throws IOException {
        int i;
        x xVar;
        boolean z2;
        if (this.f2104d != null) {
            return;
        }
        boolean z10 = ((ue.v) gVar.f1740e) != null;
        ue.m mVar = (ue.m) gVar.f1739d;
        ArrayList arrayList = new ArrayList(mVar.size() + 4);
        arrayList.add(new b(b.f, (String) gVar.f1738c));
        hf.i iVar = b.f2050g;
        ue.o oVar = (ue.o) gVar.f1737b;
        be.h.e(oVar, "url");
        String strB = oVar.b();
        String strD = oVar.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new b(iVar, strB));
        String strB2 = ((ue.m) gVar.f1739d).b("Host");
        if (strB2 != null) {
            arrayList.add(new b(b.i, strB2));
        }
        arrayList.add(new b(b.f2051h, oVar.f13008a));
        int size = mVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strD2 = mVar.d(i10);
            Locale locale = Locale.US;
            be.h.d(locale, "US");
            String lowerCase = strD2.toLowerCase(locale);
            be.h.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!f2099g.contains(lowerCase) || (lowerCase.equals("te") && be.h.a(mVar.h(i10), "trailers"))) {
                arrayList.add(new b(lowerCase, mVar.h(i10)));
            }
        }
        p pVar = this.f2103c;
        pVar.getClass();
        boolean z11 = !z10;
        synchronized (pVar.Q) {
            synchronized (pVar) {
                try {
                    if (pVar.f2097y > 1073741823) {
                        pVar.F(8);
                    }
                    if (pVar.f2098z) {
                        throw new a();
                    }
                    i = pVar.f2097y;
                    pVar.f2097y = i + 2;
                    xVar = new x(i, pVar, z11, false, null);
                    z2 = !z10 || pVar.N >= pVar.O || xVar.f2131e >= xVar.f;
                    if (xVar.i()) {
                        pVar.f2094v.put(Integer.valueOf(i), xVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            pVar.Q.F(z11, i, arrayList);
        }
        if (z2) {
            pVar.Q.flush();
        }
        this.f2104d = xVar;
        if (this.f) {
            x xVar2 = this.f2104d;
            be.h.b(xVar2);
            xVar2.e(9);
            throw new IOException("Canceled");
        }
        x xVar3 = this.f2104d;
        be.h.b(xVar3);
        w wVar = xVar3.f2135k;
        long j5 = this.f2102b.f14972g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        wVar.g(j5);
        x xVar4 = this.f2104d;
        be.h.b(xVar4);
        xVar4.f2136l.g(this.f2102b.f14973h);
    }

    @Override // ze.d
    public final hf.u f(b2.g gVar, long j5) {
        x xVar = this.f2104d;
        be.h.b(xVar);
        return xVar.g();
    }

    @Override // ze.d
    public final ue.w g(boolean z2) throws IOException {
        ue.m mVar;
        x xVar = this.f2104d;
        if (xVar == null) {
            throw new IOException("stream wasn't created");
        }
        synchronized (xVar) {
            xVar.f2135k.h();
            while (xVar.f2132g.isEmpty() && xVar.f2137m == 0) {
                try {
                    try {
                        xVar.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    xVar.f2135k.k();
                    throw th;
                }
            }
            xVar.f2135k.k();
            if (xVar.f2132g.isEmpty()) {
                IOException iOException = xVar.f2138n;
                if (iOException != null) {
                    throw iOException;
                }
                int i = xVar.f2137m;
                l4.a.s(i);
                throw new c0(i);
            }
            Object objRemoveFirst = xVar.f2132g.removeFirst();
            be.h.d(objRemoveFirst, "headersQueue.removeFirst()");
            mVar = (ue.m) objRemoveFirst;
        }
        ue.t tVar = this.f2105e;
        be.h.e(tVar, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = mVar.size();
        l0 l0VarU = null;
        for (int i10 = 0; i10 < size; i10++) {
            String strD = mVar.d(i10);
            String strH = mVar.h(i10);
            if (be.h.a(strD, ":status")) {
                l0VarU = b8.h.u("HTTP/1.1 " + strH);
            } else if (!f2100h.contains(strD)) {
                be.h.e(strD, "name");
                be.h.e(strH, "value");
                arrayList.add(strD);
                arrayList.add(ie.e.b0(strH).toString());
            }
        }
        if (l0VarU == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        ue.w wVar = new ue.w();
        wVar.f13056b = tVar;
        wVar.f13057c = l0VarU.f705v;
        wVar.f13058d = (String) l0VarU.f707x;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        q2.d dVar = new q2.d(2);
        ArrayList arrayList2 = dVar.f10591a;
        be.h.e(arrayList2, "<this>");
        be.h.e(strArr, "elements");
        arrayList2.addAll(od.h.Q(strArr));
        wVar.f = dVar;
        if (z2 && wVar.f13057c == 100) {
            return null;
        }
        return wVar;
    }

    @Override // ze.d
    public final ye.k h() {
        return this.f2101a;
    }
}
