package qf;

import ge.i;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kf.p;
import kf.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    public final /* synthetic */ g A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f10818z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar, q qVar, long j4) {
        super(gVar, qVar);
        i.e(qVar, "url");
        this.A = gVar;
        this.f10818z = j4;
        if (j4 == 0) {
            a(p.f7513w);
        }
    }

    @Override // qf.a, ag.w
    public final long U(long j4, ag.e eVar) throws IOException {
        i.e(eVar, "sink");
        if (this.f10812x) {
            throw new IllegalStateException("closed");
        }
        long j7 = this.f10818z;
        if (j7 == 0) {
            return -1L;
        }
        long jU = super.U(Math.min(j7, 8192L), eVar);
        if (jU == -1) {
            this.A.f10824b.h();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(g.f);
            throw protocolException;
        }
        long j10 = this.f10818z - jU;
        this.f10818z = j10;
        if (j10 == 0) {
            a(p.f7513w);
        }
        return jU;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zF;
        if (this.f10812x) {
            return;
        }
        if (this.f10818z != 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            TimeZone timeZone = lf.f.f7964a;
            i.e(timeUnit, "timeUnit");
            try {
                zF = lf.f.f(this, 100);
            } catch (IOException unused) {
                zF = false;
            }
            if (!zF) {
                this.A.f10824b.h();
                a(g.f);
            }
        }
        this.f10812x = true;
    }
}
