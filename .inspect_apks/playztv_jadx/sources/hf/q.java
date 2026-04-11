package hf;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final w f6140u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f6141v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6142w;

    public q(w wVar) {
        be.h.e(wVar, "source");
        this.f6140u = wVar;
        this.f6141v = new f();
    }

    @Override // hf.h
    public final f B() {
        return this.f6141v;
    }

    @Override // hf.h
    public final String M(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j5).toString());
        }
        long j8 = j5 == Long.MAX_VALUE ? Long.MAX_VALUE : j5 + 1;
        long jD = d((byte) 10, 0L, j8);
        f fVar = this.f6141v;
        if (jD != -1) {
            return jf.a.a(jD, fVar);
        }
        if (j8 < Long.MAX_VALUE && q(j8) && fVar.x(j8 - 1) == 13 && q(j8 + 1) && fVar.x(j8) == 10) {
            return jf.a.a(j8, fVar);
        }
        f fVar2 = new f();
        fVar.d(fVar2, 0L, Math.min(32, fVar.f6113v));
        throw new EOFException("\\n not found: limit=" + Math.min(fVar.f6113v, j5) + " content=" + fVar2.m(fVar2.f6113v).b() + (char) 8230);
    }

    @Override // hf.h
    public final void X(long j5) throws EOFException {
        if (!q(j5)) {
            throw new EOFException();
        }
    }

    public final boolean a() {
        if (this.f6142w) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f6141v;
        return fVar.v() && this.f6140u.l(8192L, fVar) == -1;
    }

    @Override // hf.w
    public final y c() {
        return this.f6140u.c();
    }

    @Override // hf.h
    public final long c0() throws EOFException {
        f fVar;
        byte bX;
        X(1L);
        int i = 0;
        while (true) {
            int i10 = i + 1;
            boolean zQ = q(i10);
            fVar = this.f6141v;
            if (!zQ) {
                break;
            }
            bX = fVar.x(i);
            if ((bX < 48 || bX > 57) && ((bX < 97 || bX > 102) && (bX < 65 || bX > 70))) {
                break;
            }
            i = i10;
        }
        if (i == 0) {
            cf.d.e(16);
            cf.d.e(16);
            String string = Integer.toString(bX, 16);
            be.h.d(string, "toString(this, checkRadix(radix))");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return fVar.c0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f6142w) {
            return;
        }
        this.f6142w = true;
        this.f6140u.close();
        this.f6141v.a();
    }

    public final long d(byte b10, long j5, long j8) {
        if (this.f6142w) {
            throw new IllegalStateException("closed");
        }
        if (0 > j8) {
            throw new IllegalArgumentException(("fromIndex=0 toIndex=" + j8).toString());
        }
        long jMax = 0;
        while (jMax < j8) {
            f fVar = this.f6141v;
            byte b11 = b10;
            long j10 = j8;
            long jF = fVar.F(b11, jMax, j10);
            if (jF != -1) {
                return jF;
            }
            long j11 = fVar.f6113v;
            if (j11 >= j10 || this.f6140u.l(8192L, fVar) == -1) {
                break;
            }
            jMax = Math.max(jMax, j11);
            b10 = b11;
            j8 = j10;
        }
        return -1L;
    }

    @Override // hf.h
    public final String d0(Charset charset) {
        w wVar = this.f6140u;
        f fVar = this.f6141v;
        fVar.i0(wVar);
        return fVar.H(fVar.f6113v, charset);
    }

    @Override // hf.h
    public final InputStream f0() {
        return new e(this, 1);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f6142w;
    }

    @Override // hf.w
    public final long l(long j5, f fVar) {
        be.h.e(fVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        if (this.f6142w) {
            throw new IllegalStateException("closed");
        }
        f fVar2 = this.f6141v;
        if (fVar2.f6113v == 0 && this.f6140u.l(8192L, fVar2) == -1) {
            return -1L;
        }
        return fVar2.l(Math.min(j5, fVar2.f6113v), fVar);
    }

    @Override // hf.h
    public final i m(long j5) throws EOFException {
        X(j5);
        return this.f6141v.m(j5);
    }

    @Override // hf.h
    public final int o(n nVar) throws EOFException {
        be.h.e(nVar, "options");
        if (this.f6142w) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            f fVar = this.f6141v;
            int iB = jf.a.b(fVar, nVar, true);
            if (iB != -2) {
                if (iB != -1) {
                    fVar.skip(nVar.f6129u[iB].a());
                    return iB;
                }
            } else if (this.f6140u.l(8192L, fVar) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // hf.h
    public final boolean q(long j5) {
        f fVar;
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        if (this.f6142w) {
            throw new IllegalStateException("closed");
        }
        do {
            fVar = this.f6141v;
            if (fVar.f6113v >= j5) {
                return true;
            }
        } while (this.f6140u.l(8192L, fVar) != -1);
        return false;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        be.h.e(byteBuffer, "sink");
        f fVar = this.f6141v;
        if (fVar.f6113v == 0 && this.f6140u.l(8192L, fVar) == -1) {
            return -1;
        }
        return fVar.read(byteBuffer);
    }

    @Override // hf.h
    public final byte readByte() {
        X(1L);
        return this.f6141v.readByte();
    }

    @Override // hf.h
    public final int readInt() throws EOFException {
        X(4L);
        return this.f6141v.readInt();
    }

    @Override // hf.h
    public final short readShort() throws EOFException {
        X(2L);
        return this.f6141v.readShort();
    }

    @Override // hf.h
    public final void skip(long j5) throws EOFException {
        if (this.f6142w) {
            throw new IllegalStateException("closed");
        }
        while (j5 > 0) {
            f fVar = this.f6141v;
            if (fVar.f6113v == 0 && this.f6140u.l(8192L, fVar) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j5, fVar.f6113v);
            fVar.skip(jMin);
            j5 -= jMin;
        }
    }

    public final String toString() {
        return "buffer(" + this.f6140u + ')';
    }

    public final long v(i iVar) {
        int i;
        int i10;
        long j5;
        int i11;
        int i12;
        be.h.e(iVar, "targetBytes");
        if (this.f6142w) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            f fVar = this.f6141v;
            fVar.getClass();
            be.h.e(iVar, "targetBytes");
            long j8 = 0;
            if (jMax < 0) {
                throw new IllegalArgumentException(("fromIndex < 0: " + jMax).toString());
            }
            r rVar = fVar.f6112u;
            if (rVar == null) {
                j5 = -1;
            } else {
                long j10 = fVar.f6113v;
                int i13 = 0;
                if (j10 - jMax < jMax) {
                    while (j10 > jMax) {
                        rVar = rVar.f6148g;
                        be.h.b(rVar);
                        j10 -= (long) (rVar.f6145c - rVar.f6144b);
                    }
                    if (iVar.a() == 2) {
                        byte bD = iVar.d(0);
                        byte bD2 = iVar.d(1);
                        long j11 = jMax;
                        while (j10 < fVar.f6113v) {
                            byte[] bArr = rVar.f6143a;
                            i11 = (int) ((((long) rVar.f6144b) + j11) - j10);
                            int i14 = rVar.f6145c;
                            while (i11 < i14) {
                                byte b10 = bArr[i11];
                                if (b10 == bD || b10 == bD2) {
                                    i12 = rVar.f6144b;
                                    j5 = ((long) (i11 - i12)) + j10;
                                    break;
                                }
                                i11++;
                            }
                            j11 = j10 + ((long) (rVar.f6145c - rVar.f6144b));
                            rVar = rVar.f;
                            be.h.b(rVar);
                            j10 = j11;
                        }
                        j5 = -1;
                    } else {
                        byte[] bArrC = iVar.c();
                        long j12 = jMax;
                        while (j10 < fVar.f6113v) {
                            byte[] bArr2 = rVar.f6143a;
                            i11 = (int) ((((long) rVar.f6144b) + j12) - j10);
                            int i15 = rVar.f6145c;
                            while (i11 < i15) {
                                byte b11 = bArr2[i11];
                                int length = bArrC.length;
                                for (int i16 = i13; i16 < length; i16++) {
                                    if (b11 == bArrC[i16]) {
                                        i12 = rVar.f6144b;
                                        j5 = ((long) (i11 - i12)) + j10;
                                        break;
                                    }
                                }
                                i11++;
                                i13 = 0;
                            }
                            j12 = ((long) (rVar.f6145c - rVar.f6144b)) + j10;
                            rVar = rVar.f;
                            be.h.b(rVar);
                            j10 = j12;
                            i13 = 0;
                        }
                        j5 = -1;
                    }
                } else {
                    while (true) {
                        long j13 = ((long) (rVar.f6145c - rVar.f6144b)) + j8;
                        if (j13 > jMax) {
                            break;
                        }
                        rVar = rVar.f;
                        be.h.b(rVar);
                        j8 = j13;
                    }
                    if (iVar.a() == 2) {
                        byte bD3 = iVar.d(0);
                        byte bD4 = iVar.d(1);
                        long j14 = jMax;
                        while (j8 < fVar.f6113v) {
                            byte[] bArr3 = rVar.f6143a;
                            i = (int) ((((long) rVar.f6144b) + j14) - j8);
                            int i17 = rVar.f6145c;
                            while (i < i17) {
                                byte b12 = bArr3[i];
                                if (b12 == bD3 || b12 == bD4) {
                                    i10 = rVar.f6144b;
                                    j5 = j8 + ((long) (i - i10));
                                    break;
                                }
                                i++;
                            }
                            j14 = ((long) (rVar.f6145c - rVar.f6144b)) + j8;
                            rVar = rVar.f;
                            be.h.b(rVar);
                            j8 = j14;
                        }
                        j5 = -1;
                    } else {
                        int i18 = 0;
                        byte[] bArrC2 = iVar.c();
                        long j15 = jMax;
                        while (j8 < fVar.f6113v) {
                            byte[] bArr4 = rVar.f6143a;
                            i = (int) ((((long) rVar.f6144b) + j15) - j8);
                            int i19 = rVar.f6145c;
                            while (i < i19) {
                                byte b13 = bArr4[i];
                                int length2 = bArrC2.length;
                                for (int i20 = i18; i20 < length2; i20++) {
                                    if (b13 == bArrC2[i20]) {
                                        i10 = rVar.f6144b;
                                        j5 = j8 + ((long) (i - i10));
                                        break;
                                    }
                                }
                                i++;
                                i18 = 0;
                            }
                            j15 = ((long) (rVar.f6145c - rVar.f6144b)) + j8;
                            rVar = rVar.f;
                            be.h.b(rVar);
                            j8 = j15;
                            i18 = 0;
                        }
                        j5 = -1;
                    }
                }
            }
            if (j5 != -1) {
                return j5;
            }
            long j16 = fVar.f6113v;
            if (this.f6140u.l(8192L, fVar) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j16);
        }
    }

    public final int x() throws EOFException {
        X(4L);
        int i = this.f6141v.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // hf.h
    public final String y() {
        return M(Long.MAX_VALUE);
    }
}
