package n1;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f8590v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ f f8591w;

    public a(f fVar) {
        this.f8591w = fVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j4, byte[] bArr, int i, int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (j4 < 0) {
            return -1;
        }
        try {
            long j7 = this.f8590v;
            f fVar = this.f8591w;
            if (j7 != j4) {
                if (j7 >= 0 && j4 >= j7 + ((long) fVar.f8593v.available())) {
                    return -1;
                }
                fVar.g(j4);
                this.f8590v = j4;
            }
            if (i10 > fVar.f8593v.available()) {
                i10 = fVar.f8593v.available();
            }
            int i11 = fVar.read(bArr, i, i10);
            if (i11 >= 0) {
                this.f8590v += (long) i11;
                return i11;
            }
        } catch (IOException unused) {
        }
        this.f8590v = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
