package h1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends b {
    public f(byte[] bArr) {
        super(bArr);
        this.f5615u.mark(Integer.MAX_VALUE);
    }

    public final void d(long j5) throws IOException {
        int i = this.f5617w;
        if (i > j5) {
            this.f5617w = 0;
            this.f5615u.reset();
        } else {
            j5 -= (long) i;
        }
        a((int) j5);
    }

    public f(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f5615u.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
