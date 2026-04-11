package rf;

import java.io.InterruptedIOException;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements ag.u {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f11124v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ag.e f11125w = new ag.e();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11126x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ y f11127y;

    public v(y yVar, boolean z10) {
        this.f11127y = yVar;
        this.f11124v = z10;
    }

    /* JADX WARN: Finally extract failed */
    public final void a(boolean z10) {
        long jMin;
        boolean z11;
        y yVar = this.f11127y;
        synchronized (yVar) {
            yVar.F.h();
            while (yVar.f11137y >= yVar.f11138z && !this.f11124v && !this.f11126x && yVar.g() == null) {
                try {
                    try {
                        yVar.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    yVar.F.l();
                    throw th;
                }
            }
            yVar.F.l();
            yVar.b();
            jMin = Math.min(yVar.f11138z - yVar.f11137y, this.f11125w.f429w);
            yVar.f11137y += jMin;
            z11 = z10 && jMin == this.f11125w.f429w;
        }
        this.f11127y.F.h();
        try {
            y yVar2 = this.f11127y;
            yVar2.f11135w.C(yVar2.f11134v, z11, this.f11125w, jMin);
        } finally {
            this.f11127y.F.l();
        }
    }

    @Override // ag.u
    public final void a0(long j4, ag.e eVar) {
        TimeZone timeZone = lf.f.f7964a;
        ag.e eVar2 = this.f11125w;
        eVar2.a0(j4, eVar);
        while (eVar2.f429w >= 16384) {
            a(false);
        }
    }

    @Override // ag.u, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        y yVar = this.f11127y;
        TimeZone timeZone = lf.f.f7964a;
        synchronized (yVar) {
            if (this.f11126x) {
                return;
            }
            boolean z10 = yVar.g() == null;
            y yVar2 = this.f11127y;
            if (!yVar2.D.f11124v) {
                if (this.f11125w.f429w > 0) {
                    while (this.f11125w.f429w > 0) {
                        a(true);
                    }
                } else if (z10) {
                    yVar2.f11135w.C(yVar2.f11134v, true, null, 0L);
                }
            }
            y yVar3 = this.f11127y;
            synchronized (yVar3) {
                this.f11126x = true;
                yVar3.notifyAll();
            }
            this.f11127y.f11135w.flush();
            this.f11127y.a();
        }
    }

    @Override // ag.u
    public final ag.y d() {
        return this.f11127y.F;
    }

    @Override // ag.u, java.io.Flushable
    public final void flush() {
        y yVar = this.f11127y;
        TimeZone timeZone = lf.f.f7964a;
        synchronized (yVar) {
            yVar.b();
        }
        while (this.f11125w.f429w > 0) {
            a(false);
            this.f11127y.f11135w.flush();
        }
    }
}
