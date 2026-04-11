package rf;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Closeable {
    public static final Logger A = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ag.f f11139v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ag.e f11140w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11141x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11142y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f11143z;

    public z(ag.p pVar) {
        ge.i.e(pVar, "sink");
        this.f11139v = pVar;
        ag.e eVar = new ag.e();
        this.f11140w = eVar;
        this.f11141x = 16384;
        this.f11143z = new f(eVar);
    }

    public final void A(int i, int i10, boolean z10) {
        synchronized (this) {
            if (this.f11142y) {
                throw new IOException("closed");
            }
            q(0, 8, 6, z10 ? 1 : 0);
            this.f11139v.writeInt(i);
            this.f11139v.writeInt(i10);
            this.f11139v.flush();
        }
    }

    public final void C(int i, b bVar) {
        synchronized (this) {
            if (this.f11142y) {
                throw new IOException("closed");
            }
            if (bVar.f11052v == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            q(i, 4, 3, 0);
            this.f11139v.writeInt(bVar.f11052v);
            this.f11139v.flush();
        }
    }

    public final void J(c0 c0Var) {
        ge.i.e(c0Var, "settings");
        synchronized (this) {
            try {
                if (this.f11142y) {
                    throw new IOException("closed");
                }
                q(0, Integer.bitCount(c0Var.f11055a) * 6, 4, 0);
                for (int i = 0; i < 10; i++) {
                    boolean z10 = true;
                    if (((1 << i) & c0Var.f11055a) == 0) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f11139v.writeShort(i);
                        this.f11139v.writeInt(c0Var.f11056b[i]);
                    }
                }
                this.f11139v.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void O(int i, long j4) {
        synchronized (this) {
            try {
                if (this.f11142y) {
                    throw new IOException("closed");
                }
                if (j4 == 0 || j4 > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j4).toString());
                }
                Logger logger = A;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(h.c(i, 4, j4, false));
                }
                q(i, 4, 8, 0);
                this.f11139v.writeInt((int) j4);
                this.f11139v.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(c0 c0Var) {
        ge.i.e(c0Var, "peerSettings");
        synchronized (this) {
            try {
                if (this.f11142y) {
                    throw new IOException("closed");
                }
                int i = this.f11141x;
                int i10 = c0Var.f11055a;
                if ((i10 & 32) != 0) {
                    i = c0Var.f11056b[5];
                }
                this.f11141x = i;
                if (((i10 & 2) != 0 ? c0Var.f11056b[1] : -1) != -1) {
                    f fVar = this.f11143z;
                    int i11 = (i10 & 2) != 0 ? c0Var.f11056b[1] : -1;
                    fVar.getClass();
                    int iMin = Math.min(i11, 16384);
                    int i12 = fVar.f11074d;
                    if (i12 != iMin) {
                        if (iMin < i12) {
                            fVar.f11072b = Math.min(fVar.f11072b, iMin);
                        }
                        fVar.f11073c = true;
                        fVar.f11074d = iMin;
                        int i13 = fVar.f11077h;
                        if (iMin < i13) {
                            if (iMin == 0) {
                                d[] dVarArr = fVar.f11075e;
                                sd.i.p(dVarArr, 0, dVarArr.length);
                                fVar.f = fVar.f11075e.length - 1;
                                fVar.f11076g = 0;
                                fVar.f11077h = 0;
                            } else {
                                fVar.a(i13 - iMin);
                            }
                        }
                    }
                }
                q(0, 0, 4, 1);
                this.f11139v.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            this.f11142y = true;
            this.f11139v.close();
        }
    }

    public final void flush() {
        synchronized (this) {
            if (this.f11142y) {
                throw new IOException("closed");
            }
            this.f11139v.flush();
        }
    }

    public final void g(boolean z10, int i, ag.e eVar, int i10) {
        synchronized (this) {
            if (this.f11142y) {
                throw new IOException("closed");
            }
            q(i, i10, 0, z10 ? 1 : 0);
            if (i10 > 0) {
                ag.f fVar = this.f11139v;
                ge.i.b(eVar);
                fVar.a0(i10, eVar);
            }
        }
    }

    public final void q(int i, int i10, int i11, int i12) {
        if (i11 != 8) {
            Level level = Level.FINE;
            Logger logger = A;
            if (logger.isLoggable(level)) {
                logger.fine(h.b(false, i, i10, i11, i12));
            }
        }
        if (i10 > this.f11141x) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f11141x + ": " + i10).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw new IllegalArgumentException(l0.e.g(i, "reserved bit set: ").toString());
        }
        byte[] bArr = lf.d.f7960a;
        ag.f fVar = this.f11139v;
        ge.i.e(fVar, "<this>");
        fVar.writeByte((i10 >>> 16) & 255);
        fVar.writeByte((i10 >>> 8) & 255);
        fVar.writeByte(i10 & 255);
        fVar.writeByte(i11 & 255);
        fVar.writeByte(i12 & 255);
        fVar.writeInt(i & Integer.MAX_VALUE);
    }

    public final void s(int i, b bVar, byte[] bArr) {
        synchronized (this) {
            if (this.f11142y) {
                throw new IOException("closed");
            }
            if (bVar.f11052v == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            q(0, bArr.length + 8, 7, 0);
            this.f11139v.writeInt(i);
            this.f11139v.writeInt(bVar.f11052v);
            if (bArr.length != 0) {
                this.f11139v.write(bArr);
            }
            this.f11139v.flush();
        }
    }

    public final void z(boolean z10, int i, ArrayList arrayList) {
        synchronized (this) {
            if (this.f11142y) {
                throw new IOException("closed");
            }
            this.f11143z.d(arrayList);
            long j4 = this.f11140w.f429w;
            long jMin = Math.min(this.f11141x, j4);
            int i10 = j4 == jMin ? 4 : 0;
            if (z10) {
                i10 |= 1;
            }
            q(i, (int) jMin, 1, i10);
            this.f11139v.a0(jMin, this.f11140w);
            if (j4 > jMin) {
                long j7 = j4 - jMin;
                while (j7 > 0) {
                    long jMin2 = Math.min(this.f11141x, j7);
                    j7 -= jMin2;
                    q(i, (int) jMin2, 9, j7 == 0 ? 4 : 0);
                    this.f11139v.a0(jMin2, this.f11140w);
                }
            }
        }
    }
}
