package ye;

import cf.n;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k8.t0;
import ue.o;
import ue.s;
import w1.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Cloneable {
    public d A;
    public k B;
    public m C;
    public boolean D;
    public boolean E;
    public boolean F;
    public volatile boolean G;
    public volatile m H;
    public volatile k I;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s f14718u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b2.g f14719v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t0 f14720w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f14721x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicBoolean f14722y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f14723z;

    public h(s sVar, b2.g gVar) {
        this.f14718u = sVar;
        this.f14719v = gVar;
        this.f14720w = (t0) sVar.f13041v.f10436v;
        sVar.f13044y.getClass();
        g gVar2 = new g(this);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        gVar2.g(0);
        this.f14721x = gVar2;
        this.f14722y = new AtomicBoolean();
        this.F = true;
    }

    public static final String a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hVar.G ? "canceled " : "");
        sb2.append("call");
        sb2.append(" to ");
        sb2.append(((o) hVar.f14719v.f1737b).f());
        return sb2.toString();
    }

    public final void b(k kVar) {
        byte[] bArr = ve.b.f13497a;
        if (this.B != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.B = kVar;
        kVar.f14740p.add(new f(this, this.f14723z));
    }

    public final IOException c(IOException iOException) {
        IOException interruptedIOException;
        Socket socketJ;
        byte[] bArr = ve.b.f13497a;
        k kVar = this.B;
        if (kVar != null) {
            synchronized (kVar) {
                socketJ = j();
            }
            if (this.B == null) {
                if (socketJ != null) {
                    ve.b.d(socketJ);
                }
            } else if (socketJ != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (this.f14721x.i()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            be.h.b(interruptedIOException);
        }
        return interruptedIOException;
    }

    public final Object clone() {
        return new h(this.f14718u, this.f14719v);
    }

    public final void d() {
        Socket socket;
        if (this.G) {
            return;
        }
        this.G = true;
        m mVar = this.H;
        if (mVar != null) {
            ((ze.d) mVar.f13548d).cancel();
        }
        k kVar = this.I;
        if (kVar == null || (socket = kVar.f14729c) == null) {
            return;
        }
        ve.b.d(socket);
    }

    public final void e(ue.e eVar) {
        e eVar2;
        if (!this.f14722y.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        n nVar = n.f2753a;
        this.f14723z = n.f2753a.g();
        ub.o oVar = this.f14718u.f13040u;
        e eVar3 = new e(this, eVar);
        oVar.getClass();
        synchronized (oVar) {
            ((ArrayDeque) oVar.f12871y).add(eVar3);
            String str = ((o) this.f14719v.f1737b).f13011d;
            Iterator it = ((ArrayDeque) oVar.f12869w).iterator();
            while (true) {
                if (!it.hasNext()) {
                    Iterator it2 = ((ArrayDeque) oVar.f12871y).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            eVar2 = null;
                            break;
                        } else {
                            eVar2 = (e) it2.next();
                            if (be.h.a(((o) eVar2.f14715w.f14719v.f1737b).f13011d, str)) {
                                break;
                            }
                        }
                    }
                } else {
                    eVar2 = (e) it.next();
                    if (be.h.a(((o) eVar2.f14715w.f14719v.f1737b).f13011d, str)) {
                        break;
                    }
                }
            }
            if (eVar2 != null) {
                eVar3.f14714v = eVar2.f14714v;
            }
        }
        oVar.N();
    }

    public final void f(boolean z2) {
        m mVar;
        synchronized (this) {
            if (!this.F) {
                throw new IllegalStateException("released");
            }
        }
        if (z2 && (mVar = this.H) != null) {
            ((ze.d) mVar.f13548d).cancel();
            ((h) mVar.f13546b).h(mVar, true, true, null);
        }
        this.C = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ue.x g() {
        /*
            r9 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            ue.s r0 = r9.f14718u
            java.util.List r0 = r0.f13042w
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            od.o.V(r2, r0)
            ze.a r0 = new ze.a
            ue.s r1 = r9.f14718u
            r0.<init>(r1)
            r2.add(r0)
            ze.a r0 = new ze.a
            ue.s r1 = r9.f14718u
            ue.b r1 = r1.D
            r0.<init>(r1)
            r2.add(r0)
            we.b r0 = new we.b
            r0.<init>()
            r2.add(r0)
            ye.a r0 = ye.a.f14693a
            r2.add(r0)
            ue.s r0 = r9.f14718u
            java.util.List r0 = r0.f13043x
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            od.o.V(r2, r0)
            ze.b r0 = new ze.b
            r0.<init>()
            r2.add(r0)
            ze.f r0 = new ze.f
            b2.g r5 = r9.f14719v
            ue.s r1 = r9.f14718u
            int r6 = r1.P
            int r7 = r1.Q
            int r8 = r1.R
            r3 = 0
            r4 = 0
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r2 = 0
            r3 = 0
            ue.x r0 = r0.b(r5)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            boolean r4 = r1.G     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            if (r4 != 0) goto L62
            r9.i(r2)
            return r0
        L62:
            ve.b.c(r0)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            java.lang.String r4 = "Canceled"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
            throw r0     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L6f
        L6d:
            r0 = move-exception
            goto L7b
        L6f:
            r0 = move-exception
            r3 = 1
            java.io.IOException r0 = r9.i(r0)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Throwable"
            be.h.c(r0, r4)     // Catch: java.lang.Throwable -> L6d
            throw r0     // Catch: java.lang.Throwable -> L6d
        L7b:
            if (r3 != 0) goto L80
            r9.i(r2)
        L80:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ye.h.g():ue.x");
    }

    public final IOException h(m mVar, boolean z2, boolean z10, IOException iOException) {
        boolean z11;
        boolean z12;
        be.h.e(mVar, "exchange");
        if (mVar.equals(this.H)) {
            synchronized (this) {
                z11 = false;
                if (z2) {
                    try {
                        if (!this.D) {
                            if (z10 || !this.E) {
                                z12 = false;
                            }
                        }
                        if (z2) {
                            this.D = false;
                        }
                        if (z10) {
                            this.E = false;
                        }
                        boolean z13 = this.D;
                        boolean z14 = (z13 || this.E) ? false : true;
                        if (!z13 && !this.E) {
                            if (!this.F) {
                                z11 = true;
                            }
                        }
                        z12 = z11;
                        z11 = z14;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z10) {
                    }
                    z12 = false;
                }
            }
            if (z11) {
                this.H = null;
                k kVar = this.B;
                if (kVar != null) {
                    kVar.h();
                }
            }
            if (z12) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException i(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.F) {
                this.F = false;
                if (!this.D) {
                    if (!this.E) {
                        z2 = true;
                    }
                }
            }
        }
        return z2 ? c(iOException) : iOException;
    }

    public final Socket j() {
        k kVar = this.B;
        be.h.b(kVar);
        byte[] bArr = ve.b.f13497a;
        ArrayList arrayList = kVar.f14740p;
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
            if (be.h.a(((Reference) obj).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i);
        this.B = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        kVar.f14741q = System.nanoTime();
        t0 t0Var = this.f14720w;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) t0Var.f7429e;
        xe.b bVar = (xe.b) t0Var.f7427c;
        byte[] bArr2 = ve.b.f13497a;
        if (!kVar.f14734j) {
            bVar.c((bf.n) t0Var.f7428d, 0L);
            return null;
        }
        kVar.f14734j = true;
        concurrentLinkedQueue.remove(kVar);
        if (concurrentLinkedQueue.isEmpty()) {
            bVar.a();
        }
        Socket socket = kVar.f14730d;
        be.h.b(socket);
        return socket;
    }
}
