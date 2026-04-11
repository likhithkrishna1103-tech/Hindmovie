package bf;

import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u implements hf.u {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f2116u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final hf.f f2117v = new hf.f();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2118w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ x f2119x;

    public u(x xVar, boolean z2) {
        this.f2119x = xVar;
        this.f2116u = z2;
    }

    /* JADX WARN: Finally extract failed */
    public final void a(boolean z2) {
        long jMin;
        boolean z10;
        x xVar = this.f2119x;
        synchronized (xVar) {
            xVar.f2136l.h();
            while (xVar.f2131e >= xVar.f && !this.f2116u && !this.f2118w && xVar.f() == 0) {
                try {
                    try {
                        xVar.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    xVar.f2136l.k();
                    throw th;
                }
            }
            xVar.f2136l.k();
            xVar.b();
            jMin = Math.min(xVar.f - xVar.f2131e, this.f2117v.f6113v);
            xVar.f2131e += jMin;
            z10 = z2 && jMin == this.f2117v.f6113v;
        }
        this.f2119x.f2136l.h();
        try {
            x xVar2 = this.f2119x;
            xVar2.f2128b.H(xVar2.f2127a, z10, this.f2117v, jMin);
        } finally {
            this.f2119x.f2136l.k();
        }
    }

    @Override // hf.u
    public final void b0(long j5, hf.f fVar) {
        byte[] bArr = ve.b.f13497a;
        hf.f fVar2 = this.f2117v;
        fVar2.b0(j5, fVar);
        while (fVar2.f6113v >= 16384) {
            a(false);
        }
    }

    @Override // hf.u
    public final hf.y c() {
        return this.f2119x.f2136l;
    }

    @Override // hf.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        x xVar = this.f2119x;
        byte[] bArr = ve.b.f13497a;
        synchronized (xVar) {
            if (this.f2118w) {
                return;
            }
            boolean z2 = xVar.f() == 0;
            x xVar2 = this.f2119x;
            if (!xVar2.f2134j.f2116u) {
                if (this.f2117v.f6113v > 0) {
                    while (this.f2117v.f6113v > 0) {
                        a(true);
                    }
                } else if (z2) {
                    xVar2.f2128b.H(xVar2.f2127a, true, null, 0L);
                }
            }
            synchronized (this.f2119x) {
                this.f2118w = true;
            }
            this.f2119x.f2128b.flush();
            this.f2119x.a();
        }
    }

    @Override // hf.u, java.io.Flushable
    public final void flush() {
        x xVar = this.f2119x;
        byte[] bArr = ve.b.f13497a;
        synchronized (xVar) {
            xVar.b();
        }
        while (this.f2117v.f6113v > 0) {
            a(false);
            this.f2119x.f2128b.flush();
        }
    }
}
