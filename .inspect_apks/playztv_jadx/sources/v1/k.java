package v1;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends InputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f13145u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final m f13146v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13148x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f13149y = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f13147w = new byte[1];

    public k(h hVar, m mVar) {
        this.f13145u = hVar;
        this.f13146v = mVar;
    }

    public final void a() {
        if (this.f13148x) {
            return;
        }
        this.f13145u.h(this.f13146v);
        this.f13148x = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f13149y) {
            return;
        }
        this.f13145u.close();
        this.f13149y = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f13147w;
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
        s1.d.g(!this.f13149y);
        a();
        int i11 = this.f13145u.read(bArr, i, i10);
        if (i11 == -1) {
            return -1;
        }
        return i11;
    }
}
