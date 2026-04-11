package af;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import ye.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f807x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ h f808y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, long j5) {
        super(hVar);
        this.f808y = hVar;
        this.f807x = j5;
        if (j5 == 0) {
            a();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zS;
        if (this.f799v) {
            return;
        }
        if (this.f807x != 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            byte[] bArr = ve.b.f13497a;
            be.h.e(timeUnit, "timeUnit");
            try {
                zS = ve.b.s(this, 100);
            } catch (IOException unused) {
                zS = false;
            }
            if (!zS) {
                ((k) this.f808y.f815c).l();
                a();
            }
        }
        this.f799v = true;
    }

    @Override // af.b, hf.w
    public final long l(long j5, hf.f fVar) throws IOException {
        be.h.e(fVar, "sink");
        if (this.f799v) {
            throw new IllegalStateException("closed");
        }
        long j8 = this.f807x;
        if (j8 == 0) {
            return -1L;
        }
        long jL = super.l(Math.min(j8, 8192L), fVar);
        if (jL == -1) {
            ((k) this.f808y.f815c).l();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
        long j10 = this.f807x - jL;
        this.f807x = j10;
        if (j10 == 0) {
            a();
        }
        return jL;
    }
}
