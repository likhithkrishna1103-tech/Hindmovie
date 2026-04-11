package ag;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte f435v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q f436w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Inflater f437x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final k f438y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CRC32 f439z;

    public j(g gVar) {
        ge.i.e(gVar, "source");
        q qVar = new q(gVar);
        this.f436w = qVar;
        Inflater inflater = new Inflater(true);
        this.f437x = inflater;
        this.f438y = new k(qVar, inflater);
        this.f439z = new CRC32();
    }

    public static void a(int i, int i10, String str) throws IOException {
        if (i10 == i) {
            return;
        }
        throw new IOException(str + ": actual 0x" + ne.h.n0(8, u8.a.D(i10)) + " != expected 0x" + ne.h.n0(8, u8.a.D(i)));
    }

    @Override // ag.w
    public final long U(long j4, e eVar) throws IOException {
        long j7;
        j jVar = this;
        ge.i.e(eVar, "sink");
        byte b8 = jVar.f435v;
        CRC32 crc32 = jVar.f439z;
        q qVar = jVar.f436w;
        if (b8 == 0) {
            qVar.W(10L);
            e eVar2 = qVar.f460w;
            byte bS = eVar2.s(3L);
            boolean z10 = ((bS >> 1) & 1) == 1;
            if (z10) {
                jVar.g(eVar2, 0L, 10L);
            }
            a(8075, qVar.readShort(), "ID1ID2");
            qVar.skip(8L);
            if (((bS >> 2) & 1) == 1) {
                qVar.W(2L);
                if (z10) {
                    g(eVar2, 0L, 2L);
                }
                short s10 = eVar2.readShort();
                long j10 = ((short) (((s10 & 255) << 8) | ((s10 & 65280) >>> 8))) & 65535;
                qVar.W(j10);
                if (z10) {
                    g(eVar2, 0L, j10);
                }
                qVar.skip(j10);
            }
            if (((bS >> 3) & 1) == 1) {
                long jG = qVar.g((byte) 0, 0L, Long.MAX_VALUE);
                if (jG == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    j7 = 2;
                    g(eVar2, 0L, jG + 1);
                } else {
                    j7 = 2;
                }
                qVar.skip(jG + 1);
            } else {
                j7 = 2;
            }
            if (((bS >> 4) & 1) == 1) {
                long j11 = j7;
                long jG2 = qVar.g((byte) 0, 0L, Long.MAX_VALUE);
                if (jG2 == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    j7 = j11;
                    jVar = this;
                    jVar.g(eVar2, 0L, jG2 + 1);
                } else {
                    jVar = this;
                    j7 = j11;
                }
                qVar.skip(jG2 + 1);
            } else {
                jVar = this;
            }
            if (z10) {
                qVar.W(j7);
                short s11 = eVar2.readShort();
                a((short) (((s11 & 255) << 8) | ((s11 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            jVar.f435v = (byte) 1;
        }
        if (jVar.f435v == 1) {
            long j12 = eVar.f429w;
            long jU = jVar.f438y.U(8192L, eVar);
            if (jU != -1) {
                jVar.g(eVar, j12, jU);
                return jU;
            }
            jVar.f435v = (byte) 2;
        }
        if (jVar.f435v == 2) {
            a(qVar.s(), (int) crc32.getValue(), "CRC");
            a(qVar.s(), (int) jVar.f437x.getBytesWritten(), "ISIZE");
            jVar.f435v = (byte) 3;
            if (!qVar.a()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f438y.close();
    }

    @Override // ag.w, ag.u
    public final y d() {
        return this.f436w.f459v.d();
    }

    public final void g(e eVar, long j4, long j7) {
        r rVar = eVar.f428v;
        ge.i.b(rVar);
        while (true) {
            int i = rVar.f464c;
            int i10 = rVar.f463b;
            if (j4 < i - i10) {
                break;
            }
            j4 -= (long) (i - i10);
            rVar = rVar.f;
            ge.i.b(rVar);
        }
        while (j7 > 0) {
            int i11 = (int) (((long) rVar.f463b) + j4);
            int iMin = (int) Math.min(rVar.f464c - i11, j7);
            this.f439z.update(rVar.f462a, i11, iMin);
            j7 -= (long) iMin;
            rVar = rVar.f;
            ge.i.b(rVar);
            j4 = 0;
        }
    }
}
