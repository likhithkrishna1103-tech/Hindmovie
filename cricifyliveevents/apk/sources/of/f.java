package of;

import ag.y;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ag.u {
    public boolean A;
    public boolean B;
    public final /* synthetic */ com.bumptech.glide.l C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ag.u f9800v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f9801w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f9802x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9803y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f9804z;

    public f(com.bumptech.glide.l lVar, ag.u uVar, long j4, boolean z10) {
        ge.i.e(uVar, "delegate");
        this.C = lVar;
        this.f9800v = uVar;
        this.f9801w = j4;
        this.f9802x = z10;
        this.A = z10;
    }

    public final void a() {
        this.f9800v.close();
    }

    @Override // ag.u
    public final void a0(long j4, ag.e eVar) throws IOException {
        if (this.B) {
            throw new IllegalStateException("closed");
        }
        long j7 = this.f9801w;
        if (j7 != -1 && this.f9804z + j4 > j7) {
            throw new ProtocolException("expected " + j7 + " bytes but received " + (this.f9804z + j4));
        }
        try {
            if (this.A) {
                this.A = false;
            }
            this.f9800v.a0(j4, eVar);
            this.f9804z += j4;
        } catch (IOException e9) {
            IOException iOExceptionG = g(e9);
            ge.i.b(iOExceptionG);
            throw iOExceptionG;
        }
    }

    @Override // ag.u, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.B) {
            return;
        }
        this.B = true;
        long j4 = this.f9801w;
        if (j4 != -1 && this.f9804z != j4) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            a();
            g(null);
        } catch (IOException e9) {
            IOException iOExceptionG = g(e9);
            ge.i.b(iOExceptionG);
            throw iOExceptionG;
        }
    }

    @Override // ag.u
    public final y d() {
        return this.f9800v.d();
    }

    @Override // ag.u, java.io.Flushable
    public final void flush() throws IOException {
        try {
            q();
        } catch (IOException e9) {
            IOException iOExceptionG = g(e9);
            ge.i.b(iOExceptionG);
            throw iOExceptionG;
        }
    }

    public final IOException g(IOException iOException) {
        if (this.f9803y) {
            return iOException;
        }
        this.f9803y = true;
        return com.bumptech.glide.l.d(this.C, this.f9802x, iOException, 4);
    }

    public final void q() {
        this.f9800v.flush();
    }

    public final String toString() {
        return f.class.getSimpleName() + '(' + this.f9800v + ')';
    }
}
