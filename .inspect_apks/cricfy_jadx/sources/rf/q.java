package rf;

import h.i0;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Closeable {
    public static final c0 U;
    public boolean A;
    public final nf.d B;
    public final nf.c C;
    public final nf.c D;
    public final nf.c E;
    public final b0 F;
    public long G;
    public long H;
    public long I;
    public long J;
    public final c K;
    public final c0 L;
    public c0 M;
    public final i0 N;
    public long O;
    public long P;
    public final l7.a Q;
    public final z R;
    public final p S;
    public final LinkedHashSet T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final n f11103v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LinkedHashMap f11104w = new LinkedHashMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f11105x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11106y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11107z;

    static {
        c0 c0Var = new c0();
        c0Var.c(4, 65535);
        c0Var.c(5, 16384);
        U = c0Var;
    }

    public q(dd.c cVar) {
        this.f11103v = (n) cVar.f3675z;
        String str = (String) cVar.f3674y;
        if (str == null) {
            ge.i.i("connectionName");
            throw null;
        }
        this.f11105x = str;
        this.f11107z = 3;
        nf.d dVar = (nf.d) cVar.f3672w;
        this.B = dVar;
        this.C = dVar.d();
        this.D = dVar.d();
        this.E = dVar.d();
        this.F = b0.f11053a;
        this.K = (c) cVar.A;
        c0 c0Var = new c0();
        c0Var.c(4, 16777216);
        this.L = c0Var;
        this.M = U;
        this.N = new i0(0);
        this.P = r0.a();
        l7.a aVar = (l7.a) cVar.f3673x;
        if (aVar == null) {
            ge.i.i("socket");
            throw null;
        }
        this.Q = aVar;
        this.R = new z((ag.p) aVar.f7868y);
        this.S = new p(this, new u((ag.q) aVar.f7867x));
        this.T = new LinkedHashSet();
    }

    public final void A(long j4) {
        synchronized (this) {
            try {
                i0.c(this.N, j4, 0L, 2);
                long jB = this.N.b();
                if (jB >= this.L.a() / 2) {
                    O(0, jB);
                    i0.c(this.N, 0L, jB, 1);
                }
                c cVar = this.K;
                i0 i0Var = this.N;
                cVar.getClass();
                ge.i.e(i0Var, "windowCounter");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.R.f11141x);
        r6 = r2;
        r8.O += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(int r9, boolean r10, ag.e r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            rf.z r12 = r8.R
            r12.g(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L68
            monitor-enter(r8)
        L12:
            long r4 = r8.O     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            long r6 = r8.P     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f11104w     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            goto L12
        L2a:
            r9 = move-exception
            goto L66
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            rf.z r4 = r8.R     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f11141x     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.O     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.O = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            rf.z r4 = r8.R
            if (r10 == 0) goto L54
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L54
            r5 = 1
            goto L55
        L54:
            r5 = r3
        L55:
            r4.g(r5, r9, r11, r2)
            goto Ld
        L59:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L66:
            monitor-exit(r8)
            throw r9
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.q.C(int, boolean, ag.e, long):void");
    }

    public final void J(final int i, final b bVar) {
        nf.c.c(this.C, this.f11105x + '[' + i + "] writeSynReset", new fe.a() { // from class: rf.j
            @Override // fe.a
            public final Object b() {
                q qVar = this.f11087v;
                try {
                    qVar.R.C(i, bVar);
                } catch (IOException e9) {
                    b bVar2 = b.f11050y;
                    qVar.a(bVar2, bVar2, e9);
                }
                return rd.l.f11003a;
            }
        });
    }

    public final void O(final int i, final long j4) {
        nf.c.c(this.C, this.f11105x + '[' + i + "] windowUpdate", new fe.a() { // from class: rf.i
            @Override // fe.a
            public final Object b() {
                q qVar = this.f11084v;
                try {
                    qVar.R.O(i, j4);
                } catch (IOException e9) {
                    b bVar = b.f11050y;
                    qVar.a(bVar, bVar, e9);
                }
                return rd.l.f11003a;
            }
        });
    }

    public final void a(b bVar, b bVar2, IOException iOException) {
        int i;
        Object[] array;
        TimeZone timeZone = lf.f.f7964a;
        try {
            z(bVar);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.f11104w.isEmpty()) {
                array = null;
            } else {
                array = this.f11104w.values().toArray(new y[0]);
                this.f11104w.clear();
            }
        }
        y[] yVarArr = (y[]) array;
        if (yVarArr != null) {
            for (y yVar : yVarArr) {
                try {
                    yVar.c(bVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.R.close();
        } catch (IOException unused3) {
        }
        try {
            ((Socket) ((b6.f) this.Q.f7866w).f1800w).close();
        } catch (IOException unused4) {
        }
        this.C.f();
        this.D.f();
        this.E.f();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(b.f11049x, b.C, null);
    }

    public final void flush() {
        this.R.flush();
    }

    public final y g(int i) {
        y yVar;
        synchronized (this) {
            yVar = (y) this.f11104w.get(Integer.valueOf(i));
        }
        return yVar;
    }

    public final boolean q(long j4) {
        synchronized (this) {
            if (this.A) {
                return false;
            }
            if (this.I < this.H) {
                if (j4 >= this.J) {
                    return false;
                }
            }
            return true;
        }
    }

    public final y s(int i) {
        y yVar;
        synchronized (this) {
            yVar = (y) this.f11104w.remove(Integer.valueOf(i));
            notifyAll();
        }
        return yVar;
    }

    public final void z(b bVar) {
        synchronized (this.R) {
            synchronized (this) {
                if (this.A) {
                    return;
                }
                this.A = true;
                this.R.s(this.f11106y, bVar, lf.d.f7960a);
            }
        }
    }
}
