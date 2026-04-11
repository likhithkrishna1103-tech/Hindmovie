package ag;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w f459v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f460w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f461x;

    public q(w wVar) {
        ge.i.e(wVar, "source");
        this.f459v = wVar;
        this.f460w = new e();
    }

    @Override // ag.g
    public final String I(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j4).toString());
        }
        long j7 = j4 == Long.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
        long jG = g((byte) 10, 0L, j7);
        e eVar = this.f460w;
        if (jG != -1) {
            return bg.a.a(jG, eVar);
        }
        if (j7 < Long.MAX_VALUE && o(j7) && eVar.s(j7 - 1) == 13 && o(j7 + 1) && eVar.s(j7) == 10) {
            return bg.a.a(j7, eVar);
        }
        e eVar2 = new e();
        eVar.g(eVar2, 0L, Math.min(32, eVar.f429w));
        throw new EOFException("\\n not found: limit=" + Math.min(eVar.f429w, j4) + " content=" + eVar2.k(eVar2.f429w).b() + (char) 8230);
    }

    @Override // ag.w
    public final long U(long j4, e eVar) {
        ge.i.e(eVar, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (this.f461x) {
            throw new IllegalStateException("closed");
        }
        e eVar2 = this.f460w;
        if (eVar2.f429w == 0) {
            if (j4 == 0) {
                return 0L;
            }
            if (this.f459v.U(8192L, eVar2) == -1) {
                return -1L;
            }
        }
        return eVar2.U(Math.min(j4, eVar2.f429w), eVar);
    }

    @Override // ag.g
    public final void W(long j4) throws EOFException {
        if (!o(j4)) {
            throw new EOFException();
        }
    }

    public final boolean a() {
        if (this.f461x) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.f460w;
        return eVar.q() && this.f459v.U(8192L, eVar) == -1;
    }

    @Override // ag.g
    public final String b0(Charset charset) {
        ge.i.e(charset, "charset");
        w wVar = this.f459v;
        e eVar = this.f460w;
        eVar.h0(wVar);
        return eVar.b0(charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f461x) {
            return;
        }
        this.f461x = true;
        this.f459v.close();
        this.f460w.a();
    }

    @Override // ag.w, ag.u
    public final y d() {
        return this.f459v.d();
    }

    @Override // ag.g
    public final InputStream d0() {
        return new d(this, 1);
    }

    public final long g(byte b8, long j4, long j7) {
        if (this.f461x) {
            throw new IllegalStateException("closed");
        }
        if (0 > j7) {
            throw new IllegalArgumentException(("fromIndex=0 toIndex=" + j7).toString());
        }
        long jMax = 0;
        while (jMax < j7) {
            e eVar = this.f460w;
            byte b10 = b8;
            long j10 = j7;
            long jZ = eVar.z(b10, jMax, j10);
            if (jZ != -1) {
                return jZ;
            }
            long j11 = eVar.f429w;
            if (j11 >= j10 || this.f459v.U(8192L, eVar) == -1) {
                break;
            }
            jMax = Math.max(jMax, j11);
            b8 = b10;
            j7 = j10;
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f461x;
    }

    @Override // ag.g
    public final h k(long j4) throws EOFException {
        W(j4);
        return this.f460w.k(j4);
    }

    @Override // ag.g
    public final boolean o(long j4) {
        e eVar;
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        if (this.f461x) {
            throw new IllegalStateException("closed");
        }
        do {
            eVar = this.f460w;
            if (eVar.f429w >= j4) {
                return true;
            }
        } while (this.f459v.U(8192L, eVar) != -1);
        return false;
    }

    public final long q(h hVar) {
        int i;
        int i10;
        long j4;
        int i11;
        int i12;
        ge.i.e(hVar, "targetBytes");
        if (this.f461x) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            e eVar = this.f460w;
            eVar.getClass();
            ge.i.e(hVar, "targetBytes");
            long j7 = 0;
            if (jMax < 0) {
                throw new IllegalArgumentException(("fromIndex < 0: " + jMax).toString());
            }
            r rVar = eVar.f428v;
            if (rVar == null) {
                j4 = -1;
            } else {
                long j10 = eVar.f429w;
                int i13 = 0;
                if (j10 - jMax < jMax) {
                    while (j10 > jMax) {
                        rVar = rVar.f467g;
                        ge.i.b(rVar);
                        j10 -= (long) (rVar.f464c - rVar.f463b);
                    }
                    if (hVar.a() == 2) {
                        byte bD = hVar.d(0);
                        byte bD2 = hVar.d(1);
                        long j11 = jMax;
                        while (j10 < eVar.f429w) {
                            byte[] bArr = rVar.f462a;
                            i11 = (int) ((((long) rVar.f463b) + j11) - j10);
                            int i14 = rVar.f464c;
                            while (i11 < i14) {
                                byte b8 = bArr[i11];
                                if (b8 == bD || b8 == bD2) {
                                    i12 = rVar.f463b;
                                    j4 = ((long) (i11 - i12)) + j10;
                                    break;
                                }
                                i11++;
                            }
                            j11 = j10 + ((long) (rVar.f464c - rVar.f463b));
                            rVar = rVar.f;
                            ge.i.b(rVar);
                            j10 = j11;
                        }
                        j4 = -1;
                    } else {
                        byte[] bArrC = hVar.c();
                        long j12 = jMax;
                        while (j10 < eVar.f429w) {
                            byte[] bArr2 = rVar.f462a;
                            i11 = (int) ((((long) rVar.f463b) + j12) - j10);
                            int i15 = rVar.f464c;
                            while (i11 < i15) {
                                byte b10 = bArr2[i11];
                                int length = bArrC.length;
                                for (int i16 = i13; i16 < length; i16++) {
                                    if (b10 == bArrC[i16]) {
                                        i12 = rVar.f463b;
                                        j4 = ((long) (i11 - i12)) + j10;
                                        break;
                                    }
                                }
                                i11++;
                                i13 = 0;
                            }
                            j12 = ((long) (rVar.f464c - rVar.f463b)) + j10;
                            rVar = rVar.f;
                            ge.i.b(rVar);
                            j10 = j12;
                            i13 = 0;
                        }
                        j4 = -1;
                    }
                } else {
                    while (true) {
                        long j13 = ((long) (rVar.f464c - rVar.f463b)) + j7;
                        if (j13 > jMax) {
                            break;
                        }
                        rVar = rVar.f;
                        ge.i.b(rVar);
                        j7 = j13;
                    }
                    if (hVar.a() == 2) {
                        byte bD3 = hVar.d(0);
                        byte bD4 = hVar.d(1);
                        long j14 = jMax;
                        while (j7 < eVar.f429w) {
                            byte[] bArr3 = rVar.f462a;
                            i = (int) ((((long) rVar.f463b) + j14) - j7);
                            int i17 = rVar.f464c;
                            while (i < i17) {
                                byte b11 = bArr3[i];
                                if (b11 == bD3 || b11 == bD4) {
                                    i10 = rVar.f463b;
                                    j4 = j7 + ((long) (i - i10));
                                    break;
                                }
                                i++;
                            }
                            j14 = ((long) (rVar.f464c - rVar.f463b)) + j7;
                            rVar = rVar.f;
                            ge.i.b(rVar);
                            j7 = j14;
                        }
                        j4 = -1;
                    } else {
                        int i18 = 0;
                        byte[] bArrC2 = hVar.c();
                        long j15 = jMax;
                        while (j7 < eVar.f429w) {
                            byte[] bArr4 = rVar.f462a;
                            i = (int) ((((long) rVar.f463b) + j15) - j7);
                            int i19 = rVar.f464c;
                            while (i < i19) {
                                byte b12 = bArr4[i];
                                int length2 = bArrC2.length;
                                for (int i20 = i18; i20 < length2; i20++) {
                                    if (b12 == bArrC2[i20]) {
                                        i10 = rVar.f463b;
                                        j4 = j7 + ((long) (i - i10));
                                        break;
                                    }
                                }
                                i++;
                                i18 = 0;
                            }
                            j15 = ((long) (rVar.f464c - rVar.f463b)) + j7;
                            rVar = rVar.f;
                            ge.i.b(rVar);
                            j7 = j15;
                            i18 = 0;
                        }
                        j4 = -1;
                    }
                }
            }
            if (j4 != -1) {
                return j4;
            }
            long j16 = eVar.f429w;
            if (this.f459v.U(8192L, eVar) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j16);
        }
    }

    @Override // ag.g
    public final int r(m mVar) throws EOFException {
        ge.i.e(mVar, "options");
        if (this.f461x) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            e eVar = this.f460w;
            int iB = bg.a.b(eVar, mVar, true);
            if (iB != -2) {
                if (iB != -1) {
                    eVar.skip(mVar.f446v[iB].a());
                    return iB;
                }
            } else if (this.f459v.U(8192L, eVar) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        ge.i.e(byteBuffer, "sink");
        e eVar = this.f460w;
        if (eVar.f429w == 0 && this.f459v.U(8192L, eVar) == -1) {
            return -1;
        }
        return eVar.read(byteBuffer);
    }

    @Override // ag.g
    public final byte readByte() throws EOFException {
        W(1L);
        return this.f460w.readByte();
    }

    @Override // ag.g
    public final int readInt() throws EOFException {
        W(4L);
        return this.f460w.readInt();
    }

    @Override // ag.g
    public final short readShort() throws EOFException {
        W(2L);
        return this.f460w.readShort();
    }

    public final int s() throws EOFException {
        W(4L);
        int i = this.f460w.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // ag.g
    public final void skip(long j4) throws EOFException {
        if (this.f461x) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            e eVar = this.f460w;
            if (eVar.f429w == 0 && this.f459v.U(8192L, eVar) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j4, eVar.f429w);
            eVar.skip(jMin);
            j4 -= jMin;
        }
    }

    public final String toString() {
        return "buffer(" + this.f459v + ')';
    }

    @Override // ag.g
    public final e w() {
        return this.f460w;
    }
}
