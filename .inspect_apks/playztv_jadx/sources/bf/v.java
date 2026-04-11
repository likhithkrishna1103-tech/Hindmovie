package bf;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements hf.w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f2120u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2121v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final hf.f f2122w = new hf.f();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final hf.f f2123x = new hf.f();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2124y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ x f2125z;

    public v(x xVar, long j5, boolean z2) {
        this.f2125z = xVar;
        this.f2120u = j5;
        this.f2121v = z2;
    }

    @Override // hf.w
    public final hf.y c() {
        return this.f2125z.f2135k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j5;
        x xVar = this.f2125z;
        synchronized (xVar) {
            this.f2124y = true;
            hf.f fVar = this.f2123x;
            j5 = fVar.f6113v;
            fVar.a();
            xVar.notifyAll();
        }
        if (j5 > 0) {
            x xVar2 = this.f2125z;
            byte[] bArr = ve.b.f13497a;
            xVar2.f2128b.G(j5);
        }
        this.f2125z.a();
    }

    @Override // hf.w
    public final long l(long j5, hf.f fVar) throws Throwable {
        Throwable c0Var;
        boolean z2;
        long jL;
        be.h.e(fVar, "sink");
        do {
            x xVar = this.f2125z;
            synchronized (xVar) {
                xVar.f2135k.h();
                try {
                    if (xVar.f() == 0 || this.f2121v) {
                        c0Var = null;
                    } else {
                        c0Var = xVar.f2138n;
                        if (c0Var == null) {
                            int iF = xVar.f();
                            l4.a.s(iF);
                            c0Var = new c0(iF);
                        }
                    }
                    if (this.f2124y) {
                        throw new IOException("stream closed");
                    }
                    hf.f fVar2 = this.f2123x;
                    long j8 = fVar2.f6113v;
                    z2 = false;
                    if (j8 > 0) {
                        jL = fVar2.l(Math.min(8192L, j8), fVar);
                        long j10 = xVar.f2129c + jL;
                        xVar.f2129c = j10;
                        long j11 = j10 - xVar.f2130d;
                        if (c0Var == null && j11 >= xVar.f2128b.J.a() / 2) {
                            xVar.f2128b.K(xVar.f2127a, j11);
                            xVar.f2130d = xVar.f2129c;
                        }
                    } else {
                        if (!this.f2121v && c0Var == null) {
                            try {
                                xVar.wait();
                                z2 = true;
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw new InterruptedIOException();
                            }
                        }
                        jL = -1;
                    }
                    xVar.f2135k.k();
                } catch (Throwable th) {
                    xVar.f2135k.k();
                    throw th;
                }
            }
        } while (z2);
        if (jL != -1) {
            return jL;
        }
        if (c0Var == null) {
            return -1L;
        }
        throw c0Var;
    }
}
