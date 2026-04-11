package b2;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f1687v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c2.d f1688w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1689x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f1690y;

    public g0(h hVar, c2.d dVar) {
        hVar.getClass();
        this.f1687v = hVar;
        dVar.getClass();
        this.f1688w = dVar;
    }

    @Override // b2.h
    public final long B(o oVar) throws c2.c {
        long jB = this.f1687v.B(oVar);
        this.f1690y = jB;
        if (jB == 0) {
            return 0L;
        }
        if (oVar.f1719g == -1 && jB != -1) {
            oVar = oVar.d(0L, jB);
        }
        int i = oVar.i;
        this.f1689x = true;
        c2.d dVar = this.f1688w;
        dVar.getClass();
        oVar.f1720h.getClass();
        if (oVar.f1719g == -1 && (i & 2) == 2) {
            dVar.f1996d = null;
        } else {
            dVar.f1996d = oVar;
            dVar.f1997e = (i & 4) == 4 ? dVar.f1994b : Long.MAX_VALUE;
            dVar.i = 0L;
            try {
                dVar.b(oVar);
            } catch (IOException e9) {
                throw new c2.c(e9);
            }
        }
        return this.f1690y;
    }

    @Override // b2.h
    public final void close() throws c2.c {
        c2.d dVar = this.f1688w;
        try {
            this.f1687v.close();
            if (this.f1689x) {
                this.f1689x = false;
                if (dVar.f1996d == null) {
                    return;
                }
                try {
                    dVar.a();
                } catch (IOException e9) {
                    throw new c2.c(e9);
                }
            }
        } catch (Throwable th) {
            if (this.f1689x) {
                this.f1689x = false;
                if (dVar.f1996d != null) {
                    try {
                        dVar.a();
                    } catch (IOException e10) {
                        throw new c2.c(e10);
                    }
                }
            }
            throw th;
        }
    }

    @Override // b2.h
    public final void d(h0 h0Var) {
        h0Var.getClass();
        this.f1687v.d(h0Var);
    }

    @Override // b2.h
    public final Map j() {
        return this.f1687v.j();
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws c2.c {
        if (this.f1690y == 0) {
            return -1;
        }
        int i11 = this.f1687v.read(bArr, i, i10);
        if (i11 > 0) {
            c2.d dVar = this.f1688w;
            o oVar = dVar.f1996d;
            if (oVar != null) {
                int i12 = 0;
                while (i12 < i11) {
                    try {
                        if (dVar.f1999h == dVar.f1997e) {
                            dVar.a();
                            dVar.b(oVar);
                        }
                        int iMin = (int) Math.min(i11 - i12, dVar.f1997e - dVar.f1999h);
                        OutputStream outputStream = dVar.f1998g;
                        int i13 = y1.a0.f14551a;
                        outputStream.write(bArr, i + i12, iMin);
                        i12 += iMin;
                        long j4 = iMin;
                        dVar.f1999h += j4;
                        dVar.i += j4;
                    } catch (IOException e9) {
                        throw new c2.c(e9);
                    }
                }
            }
            long j7 = this.f1690y;
            if (j7 != -1) {
                this.f1690y = j7 - ((long) i11);
            }
        }
        return i11;
    }

    @Override // b2.h
    public final Uri t() {
        return this.f1687v.t();
    }
}
