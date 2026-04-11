package w2;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements p {
    public int A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p1.i f13651v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f13652w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f13653x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13655z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public byte[] f13654y = new byte[65536];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final byte[] f13650u = new byte[4096];

    static {
        p1.h0.a("media3.extractor");
    }

    public l(p1.i iVar, long j5, long j8) {
        this.f13651v = iVar;
        this.f13653x = j5;
        this.f13652w = j8;
    }

    @Override // w2.p
    public final void B(int i) throws EOFException, InterruptedIOException {
        b(i, false);
    }

    @Override // w2.p
    public final int a(int i) throws EOFException, InterruptedIOException {
        l lVar;
        int iMin = Math.min(this.A, i);
        e(iMin);
        if (iMin == 0) {
            byte[] bArr = this.f13650u;
            lVar = this;
            iMin = lVar.d(bArr, 0, Math.min(i, bArr.length), 0, true);
        } else {
            lVar = this;
        }
        if (iMin != -1) {
            lVar.f13653x += (long) iMin;
        }
        return iMin;
    }

    public final boolean b(int i, boolean z2) throws EOFException, InterruptedIOException {
        c(i);
        int iD = this.A - this.f13655z;
        while (iD < i) {
            int i10 = i;
            boolean z10 = z2;
            iD = d(this.f13654y, this.f13655z, i10, iD, z10);
            if (iD == -1) {
                return false;
            }
            this.A = this.f13655z + iD;
            i = i10;
            z2 = z10;
        }
        this.f13655z += i;
        return true;
    }

    public final void c(int i) {
        int i10 = this.f13655z + i;
        byte[] bArr = this.f13654y;
        if (i10 > bArr.length) {
            this.f13654y = Arrays.copyOf(this.f13654y, s1.b0.i(bArr.length * 2, 65536 + i10, i10 + 524288));
        }
    }

    public final int d(byte[] bArr, int i, int i10, int i11, boolean z2) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i12 = this.f13651v.read(bArr, i + i11, i10 - i11);
        if (i12 != -1) {
            return i11 + i12;
        }
        if (i11 == 0 && z2) {
            return -1;
        }
        throw new EOFException();
    }

    public final void e(int i) {
        int i10 = this.A - i;
        this.A = i10;
        this.f13655z = 0;
        byte[] bArr = this.f13654y;
        byte[] bArr2 = i10 < bArr.length - 524288 ? new byte[65536 + i10] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i10);
        this.f13654y = bArr2;
    }

    @Override // w2.p
    public final boolean f(byte[] bArr, int i, int i10, boolean z2) throws EOFException, InterruptedIOException {
        int iMin;
        int i11 = this.A;
        if (i11 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i11, i10);
            System.arraycopy(this.f13654y, 0, bArr, i, iMin);
            e(iMin);
        }
        int iD = iMin;
        while (iD < i10 && iD != -1) {
            iD = d(bArr, i, i10, iD, z2);
        }
        if (iD != -1) {
            this.f13653x += (long) iD;
        }
        return iD != -1;
    }

    @Override // w2.p
    public final long getLength() {
        return this.f13652w;
    }

    @Override // w2.p
    public final long getPosition() {
        return this.f13653x;
    }

    @Override // w2.p
    public final int i(byte[] bArr, int i, int i10) throws EOFException, InterruptedIOException {
        l lVar;
        int iMin;
        c(i10);
        int i11 = this.A;
        int i12 = this.f13655z;
        int i13 = i11 - i12;
        if (i13 == 0) {
            lVar = this;
            iMin = lVar.d(this.f13654y, i12, i10, 0, true);
            if (iMin == -1) {
                return -1;
            }
            lVar.A += iMin;
        } else {
            lVar = this;
            iMin = Math.min(i10, i13);
        }
        System.arraycopy(lVar.f13654y, lVar.f13655z, bArr, i, iMin);
        lVar.f13655z += iMin;
        return iMin;
    }

    @Override // w2.p
    public final void l() {
        this.f13655z = 0;
    }

    @Override // w2.p
    public final void m(int i) throws EOFException, InterruptedIOException {
        n(i, false);
    }

    @Override // w2.p
    public final boolean n(int i, boolean z2) throws EOFException, InterruptedIOException {
        int iMin = Math.min(this.A, i);
        e(iMin);
        int iD = iMin;
        while (iD < i && iD != -1) {
            byte[] bArr = this.f13650u;
            iD = d(bArr, -iD, Math.min(i, bArr.length + iD), iD, z2);
        }
        if (iD != -1) {
            this.f13653x += (long) iD;
        }
        return iD != -1;
    }

    @Override // w2.p
    public final boolean r(byte[] bArr, int i, int i10, boolean z2) {
        if (!b(i10, z2)) {
            return false;
        }
        System.arraycopy(this.f13654y, this.f13655z - i10, bArr, i, i10);
        return true;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws EOFException, InterruptedIOException {
        l lVar;
        int i11 = this.A;
        int iD = 0;
        if (i11 != 0) {
            int iMin = Math.min(i11, i10);
            System.arraycopy(this.f13654y, 0, bArr, i, iMin);
            e(iMin);
            iD = iMin;
        }
        if (iD == 0) {
            lVar = this;
            iD = lVar.d(bArr, i, i10, 0, true);
        } else {
            lVar = this;
        }
        if (iD != -1) {
            lVar.f13653x += (long) iD;
        }
        return iD;
    }

    @Override // w2.p
    public final void readFully(byte[] bArr, int i, int i10) throws EOFException, InterruptedIOException {
        f(bArr, i, i10, false);
    }

    @Override // w2.p
    public final long s() {
        return this.f13653x + ((long) this.f13655z);
    }

    @Override // w2.p
    public final void w(byte[] bArr, int i, int i10) {
        r(bArr, i, i10, false);
    }
}
