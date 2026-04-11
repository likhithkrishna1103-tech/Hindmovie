package ag;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f426v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g f427w;

    public /* synthetic */ d(g gVar, int i) {
        this.f426v = i;
        this.f427w = gVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jMin;
        switch (this.f426v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                jMin = Math.min(((e) this.f427w).f429w, Integer.MAX_VALUE);
                break;
            default:
                q qVar = (q) this.f427w;
                if (qVar.f461x) {
                    throw new IOException("closed");
                }
                jMin = Math.min(qVar.f460w.f429w, Integer.MAX_VALUE);
                break;
        }
        return (int) jMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f426v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                ((q) this.f427w).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f426v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = (e) this.f427w;
                if (eVar.f429w > 0) {
                    return eVar.readByte() & 255;
                }
                return -1;
            default:
                q qVar = (q) this.f427w;
                e eVar2 = qVar.f460w;
                if (qVar.f461x) {
                    throw new IOException("closed");
                }
                if (eVar2.f429w == 0 && qVar.f459v.U(8192L, eVar2) == -1) {
                    return -1;
                }
                return eVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f426v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((e) this.f427w) + ".inputStream()";
            default:
                return ((q) this.f427w) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public long transferTo(OutputStream outputStream) throws IOException {
        switch (this.f426v) {
            case 1:
                ge.i.e(outputStream, "out");
                q qVar = (q) this.f427w;
                e eVar = qVar.f460w;
                if (qVar.f461x) {
                    throw new IOException("closed");
                }
                long j4 = 0;
                long j7 = 0;
                while (true) {
                    if (eVar.f429w == j4 && qVar.f459v.U(8192L, eVar) == -1) {
                        return j7;
                    }
                    long j10 = eVar.f429w;
                    j7 += j10;
                    u8.a.f(j10, 0L, j10);
                    r rVar = eVar.f428v;
                    while (j10 > j4) {
                        ge.i.b(rVar);
                        int iMin = (int) Math.min(j10, rVar.f464c - rVar.f463b);
                        outputStream.write(rVar.f462a, rVar.f463b, iMin);
                        int i = rVar.f463b + iMin;
                        rVar.f463b = i;
                        long j11 = iMin;
                        eVar.f429w -= j11;
                        j10 -= j11;
                        if (i == rVar.f464c) {
                            r rVarA = rVar.a();
                            eVar.f428v = rVarA;
                            s.a(rVar);
                            rVar = rVarA;
                        }
                        j4 = 0;
                    }
                }
                break;
            default:
                return super.transferTo(outputStream);
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        switch (this.f426v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ge.i.e(bArr, "sink");
                return ((e) this.f427w).read(bArr, i, i10);
            default:
                ge.i.e(bArr, "data");
                q qVar = (q) this.f427w;
                e eVar = qVar.f460w;
                if (!qVar.f461x) {
                    u8.a.f(bArr.length, i, i10);
                    if (eVar.f429w == 0 && qVar.f459v.U(8192L, eVar) == -1) {
                        return -1;
                    }
                    return eVar.read(bArr, i, i10);
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }
}
