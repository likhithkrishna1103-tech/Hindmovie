package of;

import ag.w;
import ag.y;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements w {
    public boolean A;
    public boolean B;
    public final /* synthetic */ com.bumptech.glide.l C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w f9805v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f9806w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f9807x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f9808y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9809z;

    public g(com.bumptech.glide.l lVar, w wVar, long j4, boolean z10) {
        ge.i.e(wVar, "delegate");
        this.C = lVar;
        this.f9805v = wVar;
        this.f9806w = j4;
        this.f9807x = z10;
        this.f9809z = true;
        if (j4 == 0) {
            g(null);
        }
    }

    @Override // ag.w
    public final long U(long j4, ag.e eVar) throws IOException {
        com.bumptech.glide.l lVar = this.C;
        ge.i.e(eVar, "sink");
        if (this.B) {
            throw new IllegalStateException("closed");
        }
        try {
            long jU = this.f9805v.U(8192L, eVar);
            if (this.f9809z) {
                this.f9809z = false;
            }
            if (jU == -1) {
                g(null);
                return -1L;
            }
            long j7 = this.f9808y + jU;
            long j10 = this.f9806w;
            if (j10 == -1 || j7 <= j10) {
                this.f9808y = j7;
                if (((pf.f) lVar.f2225y).c()) {
                    g(null);
                }
                return jU;
            }
            throw new ProtocolException("expected " + j10 + " bytes but received " + j7);
        } catch (IOException e9) {
            IOException iOExceptionG = g(e9);
            ge.i.b(iOExceptionG);
            throw iOExceptionG;
        }
    }

    public final void a() throws IOException {
        this.f9805v.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.B) {
            return;
        }
        this.B = true;
        try {
            a();
            g(null);
        } catch (IOException e9) {
            IOException iOExceptionG = g(e9);
            ge.i.b(iOExceptionG);
            throw iOExceptionG;
        }
    }

    @Override // ag.w, ag.u
    public final y d() {
        return this.f9805v.d();
    }

    public final IOException g(IOException iOException) {
        if (this.A) {
            return iOException;
        }
        this.A = true;
        if (iOException == null && this.f9809z) {
            this.f9809z = false;
        }
        return com.bumptech.glide.l.d(this.C, this.f9807x, iOException, 8);
    }

    public final String toString() {
        return g.class.getSimpleName() + '(' + this.f9805v + ')';
    }
}
