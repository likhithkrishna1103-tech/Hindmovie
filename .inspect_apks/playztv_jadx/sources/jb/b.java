package jb;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f6924u;

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f6924u++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f6924u += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i10) {
        int i11;
        if (i >= 0 && i <= bArr.length && i10 >= 0 && (i11 = i + i10) <= bArr.length && i11 >= 0) {
            this.f6924u += (long) i10;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
