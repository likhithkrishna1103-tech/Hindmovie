package of;

import f9.x0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements Cloneable {
    public Object A;
    public h B;
    public o C;
    public boolean D;
    public com.bumptech.glide.l E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public volatile boolean K;
    public volatile com.bumptech.glide.l L;
    public final CopyOnWriteArrayList M;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final kf.u f9817v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c2.o f9818w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final x0 f9819x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m f9820y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicBoolean f9821z;

    public n(kf.u uVar, c2.o oVar) {
        this.f9817v = uVar;
        this.f9818w = oVar;
        this.f9819x = (x0) uVar.A.f7483w;
        uVar.f7551d.getClass();
        m mVar = new m(this);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        mVar.g(0);
        this.f9820y = mVar;
        this.f9821z = new AtomicBoolean();
        this.J = true;
        this.M = new CopyOnWriteArrayList();
        new AtomicReference((lf.a) oVar.f);
    }

    public static final String a(n nVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(nVar.K ? "canceled " : "");
        sb.append("call");
        sb.append(" to ");
        sb.append(((kf.q) nVar.f9818w.f2035b).f());
        return sb.toString();
    }

    public final void b(o oVar) {
        ge.i.e(oVar, "connection");
        TimeZone timeZone = lf.f.f7964a;
        if (this.C != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.C = oVar;
        oVar.f9834p.add(new l(this, this.A));
    }

    public final IOException c(IOException iOException) {
        IOException interruptedIOException;
        Socket socketJ;
        TimeZone timeZone = lf.f.f7964a;
        o oVar = this.C;
        if (oVar != null) {
            synchronized (oVar) {
                socketJ = j();
            }
            if (this.C == null) {
                if (socketJ != null) {
                    lf.f.b(socketJ);
                }
            } else if (socketJ != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (!this.D && this.f9820y.i()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            ge.i.b(interruptedIOException);
        }
        return interruptedIOException;
    }

    public final Object clone() {
        return new n(this.f9817v, this.f9818w);
    }

    public final void d() {
        if (this.K) {
            return;
        }
        this.K = true;
        com.bumptech.glide.l lVar = this.L;
        if (lVar != null) {
            ((pf.f) lVar.f2225y).cancel();
        }
        Iterator it = this.M.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((s) it.next()).cancel();
        }
    }

    public final void e(kf.e eVar) {
        if (!this.f9821z.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        uf.f fVar = uf.f.f12506a;
        this.A = uf.f.f12506a.h();
        nc.p pVar = this.f9817v.f7548a;
        k kVar = new k(this, eVar);
        pVar.getClass();
        nc.p.x(pVar, kVar, null, 6);
    }

    public final void f(boolean z10) {
        com.bumptech.glide.l lVar;
        synchronized (this) {
            if (!this.J) {
                throw new IllegalStateException("released");
            }
        }
        if (z10 && (lVar = this.L) != null) {
            ((pf.f) lVar.f2225y).cancel();
            ((n) lVar.f2223w).h(lVar, true, true, true, true, null);
        }
        this.E = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kf.z g() {
        /*
            r9 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            kf.u r0 = r9.f9817v
            java.util.List r0 = r0.f7549b
            sd.j.g0(r0, r2)
            pf.a r0 = new pf.a
            kf.u r1 = r9.f9817v
            r0.<init>(r1)
            r2.add(r0)
            pf.a r0 = new pf.a
            kf.u r1 = r9.f9817v
            kf.b r1 = r1.f7555j
            r0.<init>(r1)
            r2.add(r0)
            mf.a r0 = new mf.a
            r0.<init>()
            r2.add(r0)
            of.a r0 = of.a.f9775a
            r2.add(r0)
            kf.u r0 = r9.f9817v
            java.util.List r0 = r0.f7550c
            sd.j.g0(r0, r2)
            pf.c r0 = pf.c.f10294a
            r2.add(r0)
            pf.h r0 = new pf.h
            c2.o r5 = r9.f9818w
            kf.u r1 = r9.f9817v
            int r6 = r1.f7567v
            int r7 = r1.f7568w
            int r8 = r1.f7569x
            r3 = 0
            r4 = 0
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r2 = 0
            r3 = 0
            kf.z r0 = r0.b(r5)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            boolean r4 = r1.K     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            if (r4 != 0) goto L5b
            r9.i(r2)
            return r0
        L5b:
            lf.d.b(r0)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.lang.String r4 = "Canceled"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            throw r0     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
        L66:
            r0 = move-exception
            goto L74
        L68:
            r0 = move-exception
            r3 = 1
            java.io.IOException r0 = r9.i(r0)     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Throwable"
            ge.i.c(r0, r4)     // Catch: java.lang.Throwable -> L66
            throw r0     // Catch: java.lang.Throwable -> L66
        L74:
            if (r3 != 0) goto L79
            r9.i(r2)
        L79:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: of.n.g():kf.z");
    }

    public final IOException h(com.bumptech.glide.l lVar, boolean z10, boolean z11, boolean z12, boolean z13, IOException iOException) {
        boolean z14;
        boolean z15;
        ge.i.e(lVar, "exchange");
        if (lVar.equals(this.L)) {
            synchronized (this) {
                z14 = false;
                if (z10) {
                    try {
                        if (!this.F) {
                            if ((z11 || !this.G) && ((!z13 || !this.H) && (!z12 || !this.I))) {
                            }
                        }
                        if (z10) {
                            this.F = false;
                        }
                        if (z11) {
                            this.G = false;
                        }
                        if (z13) {
                            this.H = false;
                        }
                        if (z12) {
                            this.I = false;
                        }
                        boolean z16 = (this.F || this.G || this.H || this.I) ? false : true;
                        if (z16) {
                            if (!this.J) {
                                z14 = true;
                            }
                        }
                        boolean z17 = z16;
                        z15 = z14;
                        z14 = z17;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    z15 = z11 ? false : false;
                }
            }
            if (z14) {
                this.L = null;
                o oVar = this.C;
                if (oVar != null) {
                    oVar.e();
                }
            }
            if (z15) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException i(IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.J) {
                this.J = false;
                if (!this.F && !this.G && !this.H) {
                    if (!this.I) {
                        z10 = true;
                    }
                }
            }
        }
        return z10 ? c(iOException) : iOException;
    }

    public final Socket j() {
        o oVar = this.C;
        ge.i.b(oVar);
        TimeZone timeZone = lf.f.f7964a;
        ArrayList arrayList = oVar.f9834p;
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i = -1;
                break;
            }
            Object obj = arrayList.get(i10);
            i10++;
            if (ge.i.a(((Reference) obj).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i);
        this.C = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        oVar.f9835q = System.nanoTime();
        x0 x0Var = this.f9819x;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) x0Var.f4474e;
        nf.c cVar = (nf.c) x0Var.f4472c;
        TimeZone timeZone2 = lf.f.f7964a;
        if (!oVar.f9828j) {
            cVar.d((nf.b) x0Var.f4473d, 0L);
            return null;
        }
        oVar.f9828j = true;
        concurrentLinkedQueue.remove(oVar);
        if (concurrentLinkedQueue.isEmpty()) {
            cVar.a();
        }
        return oVar.f9825e;
    }
}
