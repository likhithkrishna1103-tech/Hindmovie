package b2;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends InputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f1702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final o f1703w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1705y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1706z = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final byte[] f1704x = new byte[1];

    public m(h hVar, o oVar) {
        this.f1702v = hVar;
        this.f1703w = oVar;
    }

    public final void a() {
        if (this.f1705y) {
            return;
        }
        this.f1702v.B(this.f1703w);
        this.f1705y = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f1706z) {
            return;
        }
        this.f1702v.close();
        this.f1706z = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f1704x;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) {
        y1.d.g(!this.f1706z);
        a();
        int i11 = this.f1702v.read(bArr, i, i10);
        if (i11 == -1) {
            return -1;
        }
        return i11;
    }
}
