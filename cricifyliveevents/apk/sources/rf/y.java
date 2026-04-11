package rf;

import h.i0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements ag.v {
    public final ArrayDeque A;
    public boolean B;
    public final w C;
    public final v D;
    public final x E;
    public final x F;
    public b G;
    public IOException H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11134v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q f11135w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i0 f11136x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f11137y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f11138z;

    public y(int i, q qVar, boolean z10, boolean z11, kf.p pVar) {
        ge.i.e(qVar, "connection");
        this.f11134v = i;
        this.f11135w = qVar;
        this.f11136x = new i0(i);
        this.f11138z = qVar.M.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.A = arrayDeque;
        this.C = new w(this, qVar.L.a(), z11);
        this.D = new v(this, z10);
        this.E = new x(this);
        this.F = new x(this);
        if (pVar == null) {
            if (!h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (h()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(pVar);
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
            java.util.TimeZone r0 = lf.f.f7964a
            monitor-enter(r2)
            rf.w r0 = r2.C     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f11129w     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1c
            boolean r0 = r0.f11132z     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            rf.v r0 = r2.D     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f11124v     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            boolean r0 = r0.f11126x     // Catch: java.lang.Throwable -> L18
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
            rf.b r0 = rf.b.C
            r1 = 0
            r2.c(r0, r1)
            return
        L2b:
            if (r1 != 0) goto L34
            rf.q r0 = r2.f11135w
            int r1 = r2.f11134v
            r0.s(r1)
        L34:
            return
        L35:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.y.a():void");
    }

    public final void b() throws IOException {
        v vVar = this.D;
        if (vVar.f11126x) {
            throw new IOException("stream closed");
        }
        if (vVar.f11124v) {
            throw new IOException("stream finished");
        }
        if (g() != null) {
            IOException iOException = this.H;
            if (iOException != null) {
                throw iOException;
            }
            b bVarG = g();
            ge.i.b(bVarG);
            throw new d0(bVarG);
        }
    }

    public final void c(b bVar, IOException iOException) {
        if (e(bVar, iOException)) {
            this.f11135w.R.C(this.f11134v, bVar);
        }
    }

    @Override // ag.v
    public final ag.w d() {
        return this.C;
    }

    public final boolean e(b bVar, IOException iOException) {
        TimeZone timeZone = lf.f.f7964a;
        synchronized (this) {
            if (g() != null) {
                return false;
            }
            this.G = bVar;
            this.H = iOException;
            notifyAll();
            if (this.C.f11129w) {
                if (this.D.f11124v) {
                    return false;
                }
            }
            this.f11135w.s(this.f11134v);
            return true;
        }
    }

    public final void f(b bVar) {
        if (e(bVar, null)) {
            this.f11135w.J(this.f11134v, bVar);
        }
    }

    public final b g() {
        b bVar;
        synchronized (this) {
            bVar = this.G;
        }
        return bVar;
    }

    public final boolean h() {
        boolean z10 = (this.f11134v & 1) == 1;
        this.f11135w.getClass();
        return true == z10;
    }

    public final boolean i() {
        synchronized (this) {
            try {
                if (g() != null) {
                    return false;
                }
                w wVar = this.C;
                if (wVar.f11129w || wVar.f11132z) {
                    v vVar = this.D;
                    if (vVar.f11124v || vVar.f11126x) {
                        if (this.B) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(kf.p pVar, boolean z10) {
        boolean zI;
        ge.i.e(pVar, "headers");
        TimeZone timeZone = lf.f.f7964a;
        synchronized (this) {
            try {
                if (this.B && pVar.a(":status") == null && pVar.a(":method") == null) {
                    this.C.getClass();
                } else {
                    this.B = true;
                    this.A.add(pVar);
                }
                if (z10) {
                    this.C.f11129w = true;
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
        this.f11135w.s(this.f11134v);
    }

    public final void k(b bVar) {
        synchronized (this) {
            if (g() == null) {
                this.G = bVar;
                notifyAll();
            }
        }
    }

    @Override // ag.v
    public final ag.u s() {
        return this.D;
    }
}
