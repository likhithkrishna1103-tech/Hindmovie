package va;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends InputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13449u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13450v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l f13451w;

    public j(l lVar, i iVar) {
        this.f13451w = lVar;
        this.f13449u = lVar.h0(iVar.f13447a + 4);
        this.f13450v = iVar.f13448b;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        if ((i | i10) < 0 || i10 > bArr.length - i) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = this.f13450v;
        if (i11 <= 0) {
            return -1;
        }
        if (i10 > i11) {
            i10 = i11;
        }
        int i12 = this.f13449u;
        l lVar = this.f13451w;
        lVar.K(i12, i, i10, bArr);
        this.f13449u = lVar.h0(this.f13449u + i10);
        this.f13450v -= i10;
        return i10;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f13450v == 0) {
            return -1;
        }
        l lVar = this.f13451w;
        lVar.f13452u.seek(this.f13449u);
        int i = lVar.f13452u.read();
        this.f13449u = lVar.h0(this.f13449u + 1);
        this.f13450v--;
        return i;
    }
}
