package bf;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Closeable {
    public static final b0 T;
    public final xe.c A;
    public final xe.b B;
    public final xe.b C;
    public final xe.b D;
    public final a0 E;
    public long F;
    public long G;
    public long H;
    public long I;
    public final b0 J;
    public b0 K;
    public long L;
    public long M;
    public long N;
    public long O;
    public final Socket P;
    public final y Q;
    public final k R;
    public final LinkedHashSet S;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f2093u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinkedHashMap f2094v = new LinkedHashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f2095w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2096x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2097y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2098z;

    static {
        b0 b0Var = new b0();
        b0Var.c(7, 65535);
        b0Var.c(5, 16384);
        T = b0Var;
    }

    public p(b2.g gVar) {
        this.f2093u = (h) gVar.f1741g;
        String str = (String) gVar.f1739d;
        if (str == null) {
            be.h.i("connectionName");
            throw null;
        }
        this.f2095w = str;
        this.f2097y = 3;
        xe.c cVar = (xe.c) gVar.f1737b;
        this.A = cVar;
        this.B = cVar.e();
        this.C = cVar.e();
        this.D = cVar.e();
        this.E = a0.f2047a;
        b0 b0Var = new b0();
        b0Var.c(7, 16777216);
        this.J = b0Var;
        this.K = T;
        this.O = r0.a();
        Socket socket = (Socket) gVar.f1738c;
        if (socket == null) {
            be.h.i("socket");
            throw null;
        }
        this.P = socket;
        hf.p pVar = (hf.p) gVar.f;
        if (pVar == null) {
            be.h.i("sink");
            throw null;
        }
        this.Q = new y(pVar);
        hf.q qVar = (hf.q) gVar.f1740e;
        if (qVar == null) {
            be.h.i("source");
            throw null;
        }
        this.R = new k(this, new t(qVar));
        this.S = new LinkedHashSet();
    }

    public final void F(int i) {
        l4.a.u("statusCode", i);
        synchronized (this.Q) {
            synchronized (this) {
                if (this.f2098z) {
                    return;
                }
                this.f2098z = true;
                this.Q.x(ve.b.f13497a, this.f2096x, i);
            }
        }
    }

    public final synchronized void G(long j5) {
        long j8 = this.L + j5;
        this.L = j8;
        long j10 = j8 - this.M;
        if (j10 >= this.J.a() / 2) {
            K(0, j10);
            this.M += j10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.Q.f2142w);
        r6 = r2;
        r8.N += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(int r9, boolean r10, hf.f r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            bf.y r12 = r8.Q
            r12.d(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L68
            monitor-enter(r8)
        L12:
            long r4 = r8.N     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            long r6 = r8.O     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f2094v     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
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
            bf.y r4 = r8.Q     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f2142w     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.N     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.N = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            bf.y r4 = r8.Q
            if (r10 == 0) goto L54
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L54
            r5 = 1
            goto L55
        L54:
            r5 = r3
        L55:
            r4.d(r5, r9, r11, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: bf.p.H(int, boolean, hf.f, long):void");
    }

    public final void J(int i, int i10) {
        l4.a.u("errorCode", i10);
        this.B.c(new j(this.f2095w + '[' + i + "] writeSynReset", this, i, i10, 2), 0L);
    }

    public final void K(int i, long j5) {
        this.B.c(new o(this.f2095w + '[' + i + "] windowUpdate", this, i, j5), 0L);
    }

    public final void a(int i, int i10, IOException iOException) {
        int i11;
        Object[] array;
        l4.a.u("connectionCode", i);
        l4.a.u("streamCode", i10);
        byte[] bArr = ve.b.f13497a;
        try {
            F(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.f2094v.isEmpty()) {
                array = null;
            } else {
                array = this.f2094v.values().toArray(new x[0]);
                this.f2094v.clear();
            }
        }
        x[] xVarArr = (x[]) array;
        if (xVarArr != null) {
            for (x xVar : xVarArr) {
                try {
                    xVar.c(i10, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.Q.close();
        } catch (IOException unused3) {
        }
        try {
            this.P.close();
        } catch (IOException unused4) {
        }
        this.B.e();
        this.C.e();
        this.D.e();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(1, 9, null);
    }

    public final synchronized x d(int i) {
        return (x) this.f2094v.get(Integer.valueOf(i));
    }

    public final void flush() {
        this.Q.flush();
    }

    public final synchronized boolean v(long j5) {
        if (this.f2098z) {
            return false;
        }
        if (this.H < this.G) {
            if (j5 >= this.I) {
                return false;
            }
        }
        return true;
    }

    public final synchronized x x(int i) {
        x xVar;
        xVar = (x) this.f2094v.remove(Integer.valueOf(i));
        notifyAll();
        return xVar;
    }
}
