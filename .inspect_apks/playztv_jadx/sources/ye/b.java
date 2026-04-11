package ye;

import hf.u;
import hf.y;
import java.io.IOException;
import java.net.ProtocolException;
import w1.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u f14694u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f14695v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14696w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f14697x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14698y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ m f14699z;

    public b(m mVar, u uVar, long j5) {
        be.h.e(uVar, "delegate");
        this.f14699z = mVar;
        this.f14694u = uVar;
        this.f14695v = j5;
    }

    public final void a() {
        this.f14694u.close();
    }

    @Override // hf.u
    public final void b0(long j5, hf.f fVar) throws IOException {
        if (this.f14698y) {
            throw new IllegalStateException("closed");
        }
        long j8 = this.f14695v;
        if (j8 == -1 || this.f14697x + j5 <= j8) {
            try {
                this.f14694u.b0(j5, fVar);
                this.f14697x += j5;
                return;
            } catch (IOException e10) {
                throw d(e10);
            }
        }
        throw new ProtocolException("expected " + j8 + " bytes but received " + (this.f14697x + j5));
    }

    @Override // hf.u
    public final y c() {
        return this.f14694u.c();
    }

    @Override // hf.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f14698y) {
            return;
        }
        this.f14698y = true;
        long j5 = this.f14695v;
        if (j5 != -1 && this.f14697x != j5) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            a();
            d(null);
        } catch (IOException e10) {
            throw d(e10);
        }
    }

    public final IOException d(IOException iOException) {
        if (this.f14696w) {
            return iOException;
        }
        this.f14696w = true;
        return this.f14699z.i(false, true, iOException);
    }

    @Override // hf.u, java.io.Flushable
    public final void flush() throws IOException {
        try {
            v();
        } catch (IOException e10) {
            throw d(e10);
        }
    }

    public final String toString() {
        return b.class.getSimpleName() + '(' + this.f14694u + ')';
    }

    public final void v() {
        this.f14694u.flush();
    }
}
