package rf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements pf.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f11108g = lf.f.j(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f11109h = lf.f.j(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final of.o f11110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pf.h f11111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f11112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile y f11113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kf.v f11114e;
    public volatile boolean f;

    public r(kf.u uVar, of.o oVar, pf.h hVar, q qVar) {
        ge.i.e(qVar, "http2Connection");
        this.f11110a = oVar;
        this.f11111b = hVar;
        this.f11112c = qVar;
        List list = uVar.f7563r;
        kf.v vVar = kf.v.B;
        this.f11114e = list.contains(vVar) ? vVar : kf.v.A;
    }

    @Override // pf.f
    public final long a(kf.z zVar) {
        if (pf.g.a(zVar)) {
            return lf.f.d(zVar);
        }
        return 0L;
    }

    @Override // pf.f
    public final void b() {
        y yVar = this.f11113d;
        ge.i.b(yVar);
        yVar.D.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    @Override // pf.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r5 = this;
            rf.y r0 = r5.f11113d
            r1 = 0
            if (r0 == 0) goto L21
            monitor-enter(r0)
            rf.w r2 = r0.C     // Catch: java.lang.Throwable -> L17
            boolean r3 = r2.f11129w     // Catch: java.lang.Throwable -> L17
            r4 = 1
            if (r3 == 0) goto L19
            ag.e r2 = r2.f11131y     // Catch: java.lang.Throwable -> L17
            boolean r2 = r2.q()     // Catch: java.lang.Throwable -> L17
            if (r2 == 0) goto L19
            r2 = r4
            goto L1a
        L17:
            r1 = move-exception
            goto L1f
        L19:
            r2 = r1
        L1a:
            monitor-exit(r0)
            if (r2 != r4) goto L1e
            return r4
        L1e:
            return r1
        L1f:
            monitor-exit(r0)
            throw r1
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.r.c():boolean");
    }

    @Override // pf.f
    public final void cancel() {
        this.f = true;
        y yVar = this.f11113d;
        if (yVar != null) {
            yVar.f(b.C);
        }
    }

    @Override // pf.f
    public final void d() {
        this.f11112c.flush();
    }

    @Override // pf.f
    public final ag.v e() {
        y yVar = this.f11113d;
        ge.i.b(yVar);
        return yVar;
    }

    @Override // pf.f
    public final pf.e f() {
        return this.f11110a;
    }

    @Override // pf.f
    public final void g(c2.o oVar) throws IOException {
        int i;
        y yVar;
        boolean z10;
        if (this.f11113d != null) {
            return;
        }
        boolean z11 = ((kf.x) oVar.f2038e) != null;
        kf.p pVar = (kf.p) oVar.f2037d;
        ArrayList arrayList = new ArrayList(pVar.size() + 4);
        arrayList.add(new d(d.f, (String) oVar.f2036c));
        ag.h hVar = d.f11059g;
        kf.q qVar = (kf.q) oVar.f2035b;
        ge.i.e(qVar, "url");
        String strB = qVar.b();
        String strD = qVar.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new d(hVar, strB));
        String strA = ((kf.p) oVar.f2037d).a("Host");
        if (strA != null) {
            arrayList.add(new d(d.i, strA));
        }
        arrayList.add(new d(d.f11060h, qVar.f7515a));
        int size = pVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strB2 = pVar.b(i10);
            Locale locale = Locale.US;
            ge.i.d(locale, "US");
            String lowerCase = strB2.toLowerCase(locale);
            ge.i.d(lowerCase, "toLowerCase(...)");
            if (!f11108g.contains(lowerCase) || (lowerCase.equals("te") && pVar.f(i10).equals("trailers"))) {
                arrayList.add(new d(lowerCase, pVar.f(i10)));
            }
        }
        q qVar2 = this.f11112c;
        qVar2.getClass();
        boolean z12 = !z11;
        synchronized (qVar2.R) {
            synchronized (qVar2) {
                try {
                    if (qVar2.f11107z > 1073741823) {
                        qVar2.z(b.B);
                    }
                    if (qVar2.A) {
                        throw new a();
                    }
                    i = qVar2.f11107z;
                    qVar2.f11107z = i + 2;
                    yVar = new y(i, qVar2, z12, false, null);
                    z10 = !z11 || qVar2.O >= qVar2.P || yVar.f11137y >= yVar.f11138z;
                    if (yVar.i()) {
                        qVar2.f11104w.put(Integer.valueOf(i), yVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            qVar2.R.z(z12, i, arrayList);
        }
        if (z10) {
            qVar2.R.flush();
        }
        this.f11113d = yVar;
        if (this.f) {
            y yVar2 = this.f11113d;
            ge.i.b(yVar2);
            yVar2.f(b.C);
            throw new IOException("Canceled");
        }
        y yVar3 = this.f11113d;
        ge.i.b(yVar3);
        x xVar = yVar3.E;
        long j4 = this.f11111b.f10301g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        xVar.g(j4);
        y yVar4 = this.f11113d;
        ge.i.b(yVar4);
        yVar4.F.g(this.f11111b.f10302h);
    }

    @Override // pf.f
    public final ag.w h(kf.z zVar) {
        y yVar = this.f11113d;
        ge.i.b(yVar);
        return yVar.C;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    @Override // pf.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kf.y i(boolean r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.r.i(boolean):kf.y");
    }

    @Override // pf.f
    public final ag.u j(c2.o oVar, long j4) {
        y yVar = this.f11113d;
        ge.i.b(yVar);
        return yVar.D;
    }
}
