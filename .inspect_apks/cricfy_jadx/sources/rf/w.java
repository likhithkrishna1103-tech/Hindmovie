package rf;

import h.i0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements ag.w {
    public final /* synthetic */ y A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f11128v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11129w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ag.e f11130x = new ag.e();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ag.e f11131y = new ag.e();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11132z;

    public w(y yVar, long j4, boolean z10) {
        this.A = yVar;
        this.f11128v = j4;
        this.f11129w = z10;
    }

    @Override // ag.w
    public final long U(long j4, ag.e eVar) throws Throwable {
        boolean z10;
        Throwable d0Var;
        long jU;
        ge.i.e(eVar, "sink");
        do {
            y yVar = this.A;
            synchronized (yVar) {
                yVar.f11135w.getClass();
                v vVar = yVar.D;
                z10 = true;
                boolean z11 = vVar.f11126x || vVar.f11124v;
                if (z11) {
                    yVar.E.h();
                }
                try {
                    if (yVar.g() == null || this.f11129w) {
                        d0Var = null;
                    } else {
                        d0Var = yVar.H;
                        if (d0Var == null) {
                            b bVarG = yVar.g();
                            ge.i.b(bVarG);
                            d0Var = new d0(bVarG);
                        }
                    }
                    if (this.f11132z) {
                        throw new IOException("stream closed");
                    }
                    ag.e eVar2 = this.f11131y;
                    long j7 = eVar2.f429w;
                    if (j7 > 0) {
                        jU = eVar2.U(Math.min(8192L, j7), eVar);
                        i0.c(yVar.f11136x, jU, 0L, 2);
                        long jB = yVar.f11136x.b();
                        if (d0Var == null && jB >= yVar.f11135w.L.a() / 2) {
                            yVar.f11135w.O(yVar.f11134v, jB);
                            i0.c(yVar.f11136x, 0L, jB, 1);
                        }
                        z10 = false;
                    } else {
                        if (this.f11129w || d0Var != null) {
                            z10 = false;
                        } else {
                            try {
                                yVar.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw new InterruptedIOException();
                            }
                        }
                        jU = -1;
                    }
                } finally {
                    if (z11) {
                        yVar.E.l();
                    }
                }
            }
            this.A.f11135w.K.getClass();
        } while (z10);
        if (jU != -1) {
            return jU;
        }
        if (d0Var == null) {
            return -1L;
        }
        throw d0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j4;
        y yVar = this.A;
        synchronized (yVar) {
            this.f11132z = true;
            ag.e eVar = this.f11131y;
            j4 = eVar.f429w;
            eVar.a();
            yVar.notifyAll();
        }
        if (j4 > 0) {
            y yVar2 = this.A;
            TimeZone timeZone = lf.f.f7964a;
            yVar2.f11135w.A(j4);
        }
        this.A.a();
    }

    @Override // ag.w, ag.u
    public final ag.y d() {
        return this.A.E;
    }
}
