package dc;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f3654v;

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f3654v++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f3654v += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i10) {
        int i11;
        if (i >= 0 && i <= bArr.length && i10 >= 0 && (i11 = i + i10) <= bArr.length && i11 >= 0) {
            this.f3654v += (long) i10;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
