package hf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends InputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6110u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h f6111v;

    public /* synthetic */ e(h hVar, int i) {
        this.f6110u = i;
        this.f6111v = hVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jMin;
        switch (this.f6110u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                jMin = Math.min(((f) this.f6111v).f6113v, Integer.MAX_VALUE);
                break;
            default:
                q qVar = (q) this.f6111v;
                if (qVar.f6142w) {
                    throw new IOException("closed");
                }
                jMin = Math.min(qVar.f6141v.f6113v, Integer.MAX_VALUE);
                break;
        }
        return (int) jMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f6110u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                ((q) this.f6111v).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f6110u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f fVar = (f) this.f6111v;
                if (fVar.f6113v > 0) {
                    return fVar.readByte() & 255;
                }
                return -1;
            default:
                q qVar = (q) this.f6111v;
                f fVar2 = qVar.f6141v;
                if (qVar.f6142w) {
                    throw new IOException("closed");
                }
                if (fVar2.f6113v == 0 && qVar.f6140u.l(8192L, fVar2) == -1) {
                    return -1;
                }
                return fVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f6110u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((f) this.f6111v) + ".inputStream()";
            default:
                return ((q) this.f6111v) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        switch (this.f6110u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(bArr, "sink");
                return ((f) this.f6111v).read(bArr, i, i10);
            default:
                be.h.e(bArr, "data");
                q qVar = (q) this.f6111v;
                f fVar = qVar.f6141v;
                if (!qVar.f6142w) {
                    b8.h.c(bArr.length, i, i10);
                    if (fVar.f6113v == 0 && qVar.f6140u.l(8192L, fVar) == -1) {
                        return -1;
                    }
                    return fVar.read(bArr, i, i10);
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }
}
