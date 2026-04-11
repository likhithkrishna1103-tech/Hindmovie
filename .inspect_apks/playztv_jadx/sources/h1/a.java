package h1;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f5611u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f f5612v;

    public a(f fVar) {
        this.f5612v = fVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j5, byte[] bArr, int i, int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (j5 < 0) {
            return -1;
        }
        try {
            long j8 = this.f5611u;
            f fVar = this.f5612v;
            if (j8 != j5) {
                if (j8 >= 0 && j5 >= j8 + ((long) fVar.f5615u.available())) {
                    return -1;
                }
                fVar.d(j5);
                this.f5611u = j5;
            }
            if (i10 > fVar.f5615u.available()) {
                i10 = fVar.f5615u.available();
            }
            int i11 = fVar.read(bArr, i, i10);
            if (i11 >= 0) {
                this.f5611u += (long) i11;
                return i11;
            }
        } catch (IOException unused) {
        }
        this.f5611u = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
