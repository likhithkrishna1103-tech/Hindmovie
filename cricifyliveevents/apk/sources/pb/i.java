package pb;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends InputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10163v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10164w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ k f10165x;

    public i(k kVar, h hVar) {
        this.f10165x = kVar;
        this.f10163v = kVar.e0(hVar.f10161a + 4);
        this.f10164w = hVar.f10162b;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        if ((i | i10) < 0 || i10 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = this.f10164w;
        if (i11 <= 0) {
            return -1;
        }
        if (i10 > i11) {
            i10 = i11;
        }
        int i12 = this.f10163v;
        k kVar = this.f10165x;
        kVar.O(i12, i, i10, bArr);
        this.f10163v = kVar.e0(this.f10163v + i10);
        this.f10164w -= i10;
        return i10;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f10164w == 0) {
            return -1;
        }
        k kVar = this.f10165x;
        kVar.f10166v.seek(this.f10163v);
        int i = kVar.f10166v.read();
        this.f10163v = kVar.e0(this.f10163v + 1);
        this.f10164w--;
        return i;
    }
}
