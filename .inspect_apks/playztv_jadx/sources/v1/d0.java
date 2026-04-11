package v1;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f13129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w1.d f13130v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13131w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f13132x;

    public d0(h hVar, w1.d dVar) {
        hVar.getClass();
        this.f13129u = hVar;
        dVar.getClass();
        this.f13130v = dVar;
    }

    @Override // v1.h
    public final void close() throws w1.c {
        w1.d dVar = this.f13130v;
        try {
            this.f13129u.close();
            if (this.f13131w) {
                this.f13131w = false;
                if (dVar.f13510d == null) {
                    return;
                }
                try {
                    dVar.a();
                } catch (IOException e10) {
                    throw new w1.c(e10);
                }
            }
        } catch (Throwable th) {
            if (this.f13131w) {
                this.f13131w = false;
                if (dVar.f13510d != null) {
                    try {
                        dVar.a();
                    } catch (IOException e11) {
                        throw new w1.c(e11);
                    }
                }
            }
            throw th;
        }
    }

    @Override // v1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f13129u.g(e0Var);
    }

    @Override // v1.h
    public final long h(m mVar) throws w1.c {
        long jH = this.f13129u.h(mVar);
        this.f13132x = jH;
        if (jH == 0) {
            return 0L;
        }
        if (mVar.f13162g == -1 && jH != -1) {
            mVar = mVar.d(0L, jH);
        }
        int i = mVar.i;
        this.f13131w = true;
        w1.d dVar = this.f13130v;
        dVar.getClass();
        mVar.f13163h.getClass();
        if (mVar.f13162g == -1 && (i & 2) == 2) {
            dVar.f13510d = null;
        } else {
            dVar.f13510d = mVar;
            dVar.f13511e = (i & 4) == 4 ? dVar.f13508b : Long.MAX_VALUE;
            dVar.i = 0L;
            try {
                dVar.b(mVar);
            } catch (IOException e10) {
                throw new w1.c(e10);
            }
        }
        return this.f13132x;
    }

    @Override // v1.h
    public final Map k() {
        return this.f13129u.k();
    }

    @Override // v1.h
    public final Uri o() {
        return this.f13129u.o();
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws w1.c {
        if (this.f13132x == 0) {
            return -1;
        }
        int i11 = this.f13129u.read(bArr, i, i10);
        if (i11 > 0) {
            w1.d dVar = this.f13130v;
            m mVar = dVar.f13510d;
            if (mVar != null) {
                int i12 = 0;
                while (i12 < i11) {
                    try {
                        if (dVar.f13513h == dVar.f13511e) {
                            dVar.a();
                            dVar.b(mVar);
                        }
                        int iMin = (int) Math.min(i11 - i12, dVar.f13511e - dVar.f13513h);
                        OutputStream outputStream = dVar.f13512g;
                        int i13 = s1.b0.f11647a;
                        outputStream.write(bArr, i + i12, iMin);
                        i12 += iMin;
                        long j5 = iMin;
                        dVar.f13513h += j5;
                        dVar.i += j5;
                    } catch (IOException e10) {
                        throw new w1.c(e10);
                    }
                }
            }
            long j8 = this.f13132x;
            if (j8 != -1) {
                this.f13132x = j8 - ((long) i11);
            }
        }
        return i11;
    }
}
