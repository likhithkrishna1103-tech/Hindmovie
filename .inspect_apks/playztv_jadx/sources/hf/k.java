package hf;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte f6119u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f6120v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Inflater f6121w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l f6122x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CRC32 f6123y;

    public k(w wVar) {
        be.h.e(wVar, "source");
        q qVar = new q(wVar);
        this.f6120v = qVar;
        Inflater inflater = new Inflater(true);
        this.f6121w = inflater;
        this.f6122x = new l(qVar, inflater);
        this.f6123y = new CRC32();
    }

    public static void a(int i, int i10, String str) throws IOException {
        if (i10 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i10), Integer.valueOf(i)}, 3)));
        }
    }

    @Override // hf.w
    public final y c() {
        return this.f6120v.f6140u.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6122x.close();
    }

    public final void d(f fVar, long j5, long j8) {
        r rVar = fVar.f6112u;
        be.h.b(rVar);
        while (true) {
            int i = rVar.f6145c;
            int i10 = rVar.f6144b;
            if (j5 < i - i10) {
                break;
            }
            j5 -= (long) (i - i10);
            rVar = rVar.f;
            be.h.b(rVar);
        }
        while (j8 > 0) {
            int i11 = (int) (((long) rVar.f6144b) + j5);
            int iMin = (int) Math.min(rVar.f6145c - i11, j8);
            this.f6123y.update(rVar.f6143a, i11, iMin);
            j8 -= (long) iMin;
            rVar = rVar.f;
            be.h.b(rVar);
            j5 = 0;
        }
    }

    @Override // hf.w
    public final long l(long j5, f fVar) throws IOException {
        long j8;
        k kVar = this;
        be.h.e(fVar, "sink");
        byte b10 = kVar.f6119u;
        CRC32 crc32 = kVar.f6123y;
        q qVar = kVar.f6120v;
        if (b10 == 0) {
            qVar.X(10L);
            f fVar2 = qVar.f6141v;
            byte bX = fVar2.x(3L);
            boolean z2 = ((bX >> 1) & 1) == 1;
            if (z2) {
                kVar.d(fVar2, 0L, 10L);
            }
            a(8075, qVar.readShort(), "ID1ID2");
            qVar.skip(8L);
            if (((bX >> 2) & 1) == 1) {
                qVar.X(2L);
                if (z2) {
                    d(fVar2, 0L, 2L);
                }
                short s3 = fVar2.readShort();
                long j10 = ((short) (((s3 & 255) << 8) | ((s3 & 65280) >>> 8))) & 65535;
                qVar.X(j10);
                if (z2) {
                    d(fVar2, 0L, j10);
                }
                qVar.skip(j10);
            }
            if (((bX >> 3) & 1) == 1) {
                long jD = qVar.d((byte) 0, 0L, Long.MAX_VALUE);
                if (jD == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    j8 = 2;
                    d(fVar2, 0L, jD + 1);
                } else {
                    j8 = 2;
                }
                qVar.skip(jD + 1);
            } else {
                j8 = 2;
            }
            if (((bX >> 4) & 1) == 1) {
                long j11 = j8;
                long jD2 = qVar.d((byte) 0, 0L, Long.MAX_VALUE);
                if (jD2 == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    j8 = j11;
                    kVar = this;
                    kVar.d(fVar2, 0L, jD2 + 1);
                } else {
                    kVar = this;
                    j8 = j11;
                }
                qVar.skip(jD2 + 1);
            } else {
                kVar = this;
            }
            if (z2) {
                qVar.X(j8);
                short s10 = fVar2.readShort();
                a((short) (((s10 & 255) << 8) | ((s10 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            kVar.f6119u = (byte) 1;
        }
        if (kVar.f6119u == 1) {
            long j12 = fVar.f6113v;
            long jL = kVar.f6122x.l(8192L, fVar);
            if (jL != -1) {
                kVar.d(fVar, j12, jL);
                return jL;
            }
            kVar.f6119u = (byte) 2;
        }
        if (kVar.f6119u == 2) {
            a(qVar.x(), (int) crc32.getValue(), "CRC");
            a(qVar.x(), (int) kVar.f6121w.getBytesWritten(), "ISIZE");
            kVar.f6119u = (byte) 3;
            if (!qVar.a()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
