package ye;

import hf.w;
import hf.y;
import java.io.IOException;
import java.net.ProtocolException;
import w1.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements w {
    public final /* synthetic */ m A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final w f14700u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f14701v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f14702w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14703x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14704y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f14705z;

    public c(m mVar, w wVar, long j5) {
        be.h.e(wVar, "delegate");
        this.A = mVar;
        this.f14700u = wVar;
        this.f14701v = j5;
        this.f14703x = true;
        if (j5 == 0) {
            d(null);
        }
    }

    public final void a() throws IOException {
        this.f14700u.close();
    }

    @Override // hf.w
    public final y c() {
        return this.f14700u.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f14705z) {
            return;
        }
        this.f14705z = true;
        try {
            a();
            d(null);
        } catch (IOException e10) {
            throw d(e10);
        }
    }

    public final IOException d(IOException iOException) {
        if (this.f14704y) {
            return iOException;
        }
        this.f14704y = true;
        if (iOException == null && this.f14703x) {
            this.f14703x = false;
        }
        return this.A.i(true, false, iOException);
    }

    @Override // hf.w
    public final long l(long j5, hf.f fVar) throws IOException {
        be.h.e(fVar, "sink");
        if (this.f14705z) {
            throw new IllegalStateException("closed");
        }
        try {
            long jL = this.f14700u.l(8192L, fVar);
            if (this.f14703x) {
                this.f14703x = false;
            }
            if (jL == -1) {
                d(null);
                return -1L;
            }
            long j8 = this.f14702w + jL;
            long j10 = this.f14701v;
            if (j10 == -1 || j8 <= j10) {
                this.f14702w = j8;
                if (j8 == j10) {
                    d(null);
                }
                return jL;
            }
            throw new ProtocolException("expected " + j10 + " bytes but received " + j8);
        } catch (IOException e10) {
            throw d(e10);
        }
    }

    public final String toString() {
        return c.class.getSimpleName() + '(' + this.f14700u + ')';
    }
}
