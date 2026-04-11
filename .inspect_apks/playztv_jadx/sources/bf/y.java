package bf;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Closeable {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Logger f2139z = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final hf.g f2140u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final hf.f f2141v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2142w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2143x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f2144y;

    public y(hf.p pVar) {
        be.h.e(pVar, "sink");
        this.f2140u = pVar;
        hf.f fVar = new hf.f();
        this.f2141v = fVar;
        this.f2142w = 16384;
        this.f2144y = new d(fVar);
    }

    public final synchronized void F(boolean z2, int i, ArrayList arrayList) {
        if (this.f2143x) {
            throw new IOException("closed");
        }
        this.f2144y.d(arrayList);
        long j5 = this.f2141v.f6113v;
        long jMin = Math.min(this.f2142w, j5);
        int i10 = j5 == jMin ? 4 : 0;
        if (z2) {
            i10 |= 1;
        }
        v(i, (int) jMin, 1, i10);
        this.f2140u.b0(jMin, this.f2141v);
        if (j5 > jMin) {
            long j8 = j5 - jMin;
            while (j8 > 0) {
                long jMin2 = Math.min(this.f2142w, j8);
                j8 -= jMin2;
                v(i, (int) jMin2, 9, j8 == 0 ? 4 : 0);
                this.f2140u.b0(jMin2, this.f2141v);
            }
        }
    }

    public final synchronized void G(int i, int i10, boolean z2) {
        if (this.f2143x) {
            throw new IOException("closed");
        }
        v(0, 8, 6, z2 ? 1 : 0);
        this.f2140u.writeInt(i);
        this.f2140u.writeInt(i10);
        this.f2140u.flush();
    }

    public final synchronized void H(int i, int i10) {
        l4.a.u("errorCode", i10);
        if (this.f2143x) {
            throw new IOException("closed");
        }
        if (v.e.c(i10) == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        v(i, 4, 3, 0);
        this.f2140u.writeInt(v.e.c(i10));
        this.f2140u.flush();
    }

    public final synchronized void J(b0 b0Var) {
        try {
            be.h.e(b0Var, "settings");
            if (this.f2143x) {
                throw new IOException("closed");
            }
            v(0, Integer.bitCount(b0Var.f2055a) * 6, 4, 0);
            int i = 0;
            while (i < 10) {
                boolean z2 = true;
                if (((1 << i) & b0Var.f2055a) == 0) {
                    z2 = false;
                }
                if (z2) {
                    this.f2140u.writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                    this.f2140u.writeInt(b0Var.f2056b[i]);
                }
                i++;
            }
            this.f2140u.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void K(int i, long j5) {
        if (this.f2143x) {
            throw new IOException("closed");
        }
        if (j5 == 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j5).toString());
        }
        v(i, 4, 8, 0);
        this.f2140u.writeInt((int) j5);
        this.f2140u.flush();
    }

    public final synchronized void a(b0 b0Var) {
        try {
            be.h.e(b0Var, "peerSettings");
            if (this.f2143x) {
                throw new IOException("closed");
            }
            int i = this.f2142w;
            int i10 = b0Var.f2055a;
            if ((i10 & 32) != 0) {
                i = b0Var.f2056b[5];
            }
            this.f2142w = i;
            if (((i10 & 2) != 0 ? b0Var.f2056b[1] : -1) != -1) {
                d dVar = this.f2144y;
                int i11 = (i10 & 2) != 0 ? b0Var.f2056b[1] : -1;
                dVar.getClass();
                int iMin = Math.min(i11, 16384);
                int i12 = dVar.f2067d;
                if (i12 != iMin) {
                    if (iMin < i12) {
                        dVar.f2065b = Math.min(dVar.f2065b, iMin);
                    }
                    dVar.f2066c = true;
                    dVar.f2067d = iMin;
                    int i13 = dVar.f2070h;
                    if (iMin < i13) {
                        if (iMin == 0) {
                            b[] bVarArr = dVar.f2068e;
                            od.h.W(bVarArr, 0, bVarArr.length);
                            dVar.f = dVar.f2068e.length - 1;
                            dVar.f2069g = 0;
                            dVar.f2070h = 0;
                        } else {
                            dVar.a(i13 - iMin);
                        }
                    }
                }
            }
            v(0, 0, 4, 1);
            this.f2140u.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f2143x = true;
        this.f2140u.close();
    }

    public final synchronized void d(boolean z2, int i, hf.f fVar, int i10) {
        if (this.f2143x) {
            throw new IOException("closed");
        }
        v(i, i10, 0, z2 ? 1 : 0);
        if (i10 > 0) {
            hf.g gVar = this.f2140u;
            be.h.b(fVar);
            gVar.b0(i10, fVar);
        }
    }

    public final synchronized void flush() {
        if (this.f2143x) {
            throw new IOException("closed");
        }
        this.f2140u.flush();
    }

    public final void v(int i, int i10, int i11, int i12) {
        Level level = Level.FINE;
        Logger logger = f2139z;
        if (logger.isLoggable(level)) {
            logger.fine(f.a(false, i, i10, i11, i12));
        }
        if (i10 > this.f2142w) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f2142w + ": " + i10).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw new IllegalArgumentException(e6.j.l("reserved bit set: ", i).toString());
        }
        byte[] bArr = ve.b.f13497a;
        hf.g gVar = this.f2140u;
        be.h.e(gVar, "<this>");
        gVar.writeByte((i10 >>> 16) & 255);
        gVar.writeByte((i10 >>> 8) & 255);
        gVar.writeByte(i10 & 255);
        gVar.writeByte(i11 & 255);
        gVar.writeByte(i12 & 255);
        gVar.writeInt(i & Integer.MAX_VALUE);
    }

    public final synchronized void x(byte[] bArr, int i, int i10) {
        l4.a.u("errorCode", i10);
        if (this.f2143x) {
            throw new IOException("closed");
        }
        if (v.e.c(i10) == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        v(0, bArr.length + 8, 7, 0);
        this.f2140u.writeInt(i);
        this.f2140u.writeInt(v.e.c(i10));
        if (bArr.length != 0) {
            this.f2140u.write(bArr);
        }
        this.f2140u.flush();
    }
}
