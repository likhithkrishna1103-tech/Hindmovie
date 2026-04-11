package a3;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements q {
    public int A;
    public int B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v1.h f213w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f214x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f215y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public byte[] f216z = new byte[65536];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte[] f212v = new byte[4096];

    static {
        v1.h0.a("media3.extractor");
    }

    public l(v1.h hVar, long j4, long j7) {
        this.f213w = hVar;
        this.f215y = j4;
        this.f214x = j7;
    }

    @Override // a3.q
    public final void A(int i) throws EOFException, InterruptedIOException {
        b(i, false);
    }

    @Override // a3.q
    public final int a(int i) throws EOFException, InterruptedIOException {
        l lVar;
        int iMin = Math.min(this.B, i);
        f(iMin);
        if (iMin == 0) {
            byte[] bArr = this.f212v;
            lVar = this;
            iMin = lVar.e(bArr, 0, Math.min(i, bArr.length), 0, true);
        } else {
            lVar = this;
        }
        if (iMin != -1) {
            lVar.f215y += (long) iMin;
        }
        return iMin;
    }

    public final boolean b(int i, boolean z10) throws EOFException, InterruptedIOException {
        c(i);
        int iE = this.B - this.A;
        while (iE < i) {
            int i10 = i;
            boolean z11 = z10;
            iE = e(this.f216z, this.A, i10, iE, z11);
            if (iE == -1) {
                return false;
            }
            this.B = this.A + iE;
            i = i10;
            z10 = z11;
        }
        this.A += i;
        return true;
    }

    public final void c(int i) {
        int i10 = this.A + i;
        byte[] bArr = this.f216z;
        if (i10 > bArr.length) {
            this.f216z = Arrays.copyOf(this.f216z, y1.a0.i(bArr.length * 2, 65536 + i10, i10 + 524288));
        }
    }

    public final int e(byte[] bArr, int i, int i10, int i11, boolean z10) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i12 = this.f213w.read(bArr, i + i11, i10 - i11);
        if (i12 != -1) {
            return i11 + i12;
        }
        if (i11 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    public final void f(int i) {
        int i10 = this.B - i;
        this.B = i10;
        this.A = 0;
        byte[] bArr = this.f216z;
        byte[] bArr2 = i10 < bArr.length - 524288 ? new byte[65536 + i10] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i10);
        this.f216z = bArr2;
    }

    @Override // a3.q
    public final boolean g(byte[] bArr, int i, int i10, boolean z10) throws EOFException, InterruptedIOException {
        int iMin;
        int i11 = this.B;
        if (i11 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i11, i10);
            System.arraycopy(this.f216z, 0, bArr, i, iMin);
            f(iMin);
        }
        int iE = iMin;
        while (iE < i10 && iE != -1) {
            iE = e(bArr, i, i10, iE, z10);
        }
        if (iE != -1) {
            this.f215y += (long) iE;
        }
        return iE != -1;
    }

    @Override // a3.q
    public final long getLength() {
        return this.f214x;
    }

    @Override // a3.q
    public final long getPosition() {
        return this.f215y;
    }

    @Override // a3.q
    public final int i(byte[] bArr, int i, int i10) throws EOFException, InterruptedIOException {
        l lVar;
        int iMin;
        c(i10);
        int i11 = this.B;
        int i12 = this.A;
        int i13 = i11 - i12;
        if (i13 == 0) {
            lVar = this;
            iMin = lVar.e(this.f216z, i12, i10, 0, true);
            if (iMin == -1) {
                return -1;
            }
            lVar.B += iMin;
        } else {
            lVar = this;
            iMin = Math.min(i10, i13);
        }
        System.arraycopy(lVar.f216z, lVar.A, bArr, i, iMin);
        lVar.A += iMin;
        return iMin;
    }

    @Override // a3.q
    public final void k() {
        this.A = 0;
    }

    @Override // a3.q
    public final void n(int i) throws EOFException, InterruptedIOException {
        r(i, false);
    }

    @Override // a3.q
    public final boolean r(int i, boolean z10) throws EOFException, InterruptedIOException {
        int iMin = Math.min(this.B, i);
        f(iMin);
        int iE = iMin;
        while (iE < i && iE != -1) {
            byte[] bArr = this.f212v;
            iE = e(bArr, -iE, Math.min(i, bArr.length + iE), iE, z10);
        }
        if (iE != -1) {
            this.f215y += (long) iE;
        }
        return iE != -1;
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws EOFException, InterruptedIOException {
        l lVar;
        int i11 = this.B;
        int iE = 0;
        if (i11 != 0) {
            int iMin = Math.min(i11, i10);
            System.arraycopy(this.f216z, 0, bArr, i, iMin);
            f(iMin);
            iE = iMin;
        }
        if (iE == 0) {
            lVar = this;
            iE = lVar.e(bArr, i, i10, 0, true);
        } else {
            lVar = this;
        }
        if (iE != -1) {
            lVar.f215y += (long) iE;
        }
        return iE;
    }

    @Override // a3.q
    public final void readFully(byte[] bArr, int i, int i10) throws EOFException, InterruptedIOException {
        g(bArr, i, i10, false);
    }

    @Override // a3.q
    public final boolean v(byte[] bArr, int i, int i10, boolean z10) {
        if (!b(i10, z10)) {
            return false;
        }
        System.arraycopy(this.f216z, this.A - i10, bArr, i, i10);
        return true;
    }

    @Override // a3.q
    public final long x() {
        return this.f215y + ((long) this.A);
    }

    @Override // a3.q
    public final void z(byte[] bArr, int i, int i10) {
        v(bArr, i, i10, false);
    }
}
