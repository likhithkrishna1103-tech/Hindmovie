package bf;

import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f2128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2131e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f2132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2133h;
    public final v i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f2134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final w f2135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final w f2136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IOException f2138n;

    public x(int i, p pVar, boolean z2, boolean z10, ue.m mVar) {
        be.h.e(pVar, "connection");
        this.f2127a = i;
        this.f2128b = pVar;
        this.f = pVar.K.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f2132g = arrayDeque;
        this.i = new v(this, pVar.J.a(), z10);
        this.f2134j = new u(this, z2);
        this.f2135k = new w(this);
        this.f2136l = new w(this);
        if (mVar == null) {
            if (!h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (h()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(mVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            byte[] r0 = ve.b.f13497a
            monitor-enter(r2)
            bf.v r0 = r2.i     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f2121v     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1c
            boolean r0 = r0.f2124y     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            bf.u r0 = r2.f2134j     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f2116u     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            boolean r0 = r0.f2118w     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L35
        L1a:
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            boolean r1 = r2.i()     // Catch: java.lang.Throwable -> L18
            monitor-exit(r2)
            if (r0 == 0) goto L2b
            r0 = 9
            r1 = 0
            r2.c(r0, r1)
            return
        L2b:
            if (r1 != 0) goto L34
            bf.p r0 = r2.f2128b
            int r1 = r2.f2127a
            r0.x(r1)
        L34:
            return
        L35:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.x.a():void");
    }

    public final void b() throws IOException {
        u uVar = this.f2134j;
        if (uVar.f2118w) {
            throw new IOException("stream closed");
        }
        if (uVar.f2116u) {
            throw new IOException("stream finished");
        }
        if (this.f2137m != 0) {
            IOException iOException = this.f2138n;
            if (iOException != null) {
                throw iOException;
            }
            int i = this.f2137m;
            l4.a.s(i);
            throw new c0(i);
        }
    }

    public final void c(int i, IOException iOException) {
        l4.a.u("rstStatusCode", i);
        if (d(i, iOException)) {
            p pVar = this.f2128b;
            pVar.getClass();
            l4.a.u("statusCode", i);
            pVar.Q.H(this.f2127a, i);
        }
    }

    public final boolean d(int i, IOException iOException) {
        byte[] bArr = ve.b.f13497a;
        synchronized (this) {
            if (this.f2137m != 0) {
                return false;
            }
            this.f2137m = i;
            this.f2138n = iOException;
            notifyAll();
            if (this.i.f2121v) {
                if (this.f2134j.f2116u) {
                    return false;
                }
            }
            this.f2128b.x(this.f2127a);
            return true;
        }
    }

    public final void e(int i) {
        l4.a.u("errorCode", i);
        if (d(i, null)) {
            this.f2128b.J(this.f2127a, i);
        }
    }

    public final synchronized int f() {
        return this.f2137m;
    }

    public final u g() {
        synchronized (this) {
            if (!this.f2133h && !h()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f2134j;
    }

    public final boolean h() {
        boolean z2 = (this.f2127a & 1) == 1;
        this.f2128b.getClass();
        return true == z2;
    }

    public final synchronized boolean i() {
        try {
            if (this.f2137m != 0) {
                return false;
            }
            v vVar = this.i;
            if (vVar.f2121v || vVar.f2124y) {
                u uVar = this.f2134j;
                if (uVar.f2116u || uVar.f2118w) {
                    if (this.f2133h) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j(ue.m mVar, boolean z2) {
        boolean zI;
        be.h.e(mVar, "headers");
        byte[] bArr = ve.b.f13497a;
        synchronized (this) {
            try {
                if (this.f2133h && z2) {
                    this.i.getClass();
                } else {
                    this.f2133h = true;
                    this.f2132g.add(mVar);
                }
                if (z2) {
                    this.i.f2121v = true;
                }
                zI = i();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zI) {
            return;
        }
        this.f2128b.x(this.f2127a);
    }

    public final synchronized void k(int i) {
        l4.a.u("errorCode", i);
        if (this.f2137m == 0) {
            this.f2137m = i;
            notifyAll();
        }
    }
}
