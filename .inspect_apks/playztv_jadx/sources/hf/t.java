package hf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends i {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient byte[][] f6152y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient int[] f6153z;

    public t(byte[][] bArr, int[] iArr) {
        super(i.f6114x.f6115u);
        this.f6152y = bArr;
        this.f6153z = iArr;
    }

    @Override // hf.i
    public final int a() {
        return this.f6153z[this.f6152y.length - 1];
    }

    @Override // hf.i
    public final String b() {
        return new i(j()).b();
    }

    @Override // hf.i
    public final byte[] c() {
        return j();
    }

    @Override // hf.i
    public final byte d(int i) {
        byte[][] bArr = this.f6152y;
        int length = bArr.length - 1;
        int[] iArr = this.f6153z;
        b8.h.c(iArr[length], i, 1L);
        int iB = jf.b.b(this, i);
        return bArr[iB][(i - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // hf.i
    public final boolean e(int i, int i10, int i11, byte[] bArr) {
        be.h.e(bArr, "other");
        if (i < 0 || i > a() - i11 || i10 < 0 || i10 > bArr.length - i11) {
            return false;
        }
        int i12 = i11 + i;
        int iB = jf.b.b(this, i);
        while (i < i12) {
            int[] iArr = this.f6153z;
            int i13 = iB == 0 ? 0 : iArr[iB - 1];
            int i14 = iArr[iB] - i13;
            byte[][] bArr2 = this.f6152y;
            int i15 = iArr[bArr2.length + iB];
            int iMin = Math.min(i12, i14 + i13) - i;
            if (!b8.h.b((i - i13) + i15, i10, iMin, bArr2[iB], bArr)) {
                return false;
            }
            i10 += iMin;
            i += iMin;
            iB++;
        }
        return true;
    }

    @Override // hf.i
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return iVar.a() == a() && f(iVar, a());
    }

    @Override // hf.i
    public final boolean f(i iVar, int i) {
        be.h.e(iVar, "other");
        if (a() - i >= 0) {
            int iB = jf.b.b(this, 0);
            int i10 = 0;
            int i11 = 0;
            while (i10 < i) {
                int[] iArr = this.f6153z;
                int i12 = iB == 0 ? 0 : iArr[iB - 1];
                int i13 = iArr[iB] - i12;
                byte[][] bArr = this.f6152y;
                int i14 = iArr[bArr.length + iB];
                int iMin = Math.min(i, i13 + i12) - i10;
                if (iVar.e(i11, (i10 - i12) + i14, iMin, bArr[iB])) {
                    i11 += iMin;
                    i10 += iMin;
                    iB++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // hf.i
    public final i g() {
        return new i(j()).g();
    }

    @Override // hf.i
    public final int hashCode() {
        int i = this.f6116v;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.f6152y;
        int length = bArr.length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int[] iArr = this.f6153z;
            int i13 = iArr[length + i10];
            int i14 = iArr[i10];
            byte[] bArr2 = bArr[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr2[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        this.f6116v = i11;
        return i11;
    }

    @Override // hf.i
    public final void i(f fVar, int i) {
        int iB = jf.b.b(this, 0);
        int i10 = 0;
        while (i10 < i) {
            int[] iArr = this.f6153z;
            int i11 = iB == 0 ? 0 : iArr[iB - 1];
            int i12 = iArr[iB] - i11;
            byte[][] bArr = this.f6152y;
            int i13 = iArr[bArr.length + iB];
            int iMin = Math.min(i, i12 + i11) - i10;
            int i14 = (i10 - i11) + i13;
            r rVar = new r(bArr[iB], i14, i14 + iMin, true);
            r rVar2 = fVar.f6112u;
            if (rVar2 == null) {
                rVar.f6148g = rVar;
                rVar.f = rVar;
                fVar.f6112u = rVar;
            } else {
                r rVar3 = rVar2.f6148g;
                be.h.b(rVar3);
                rVar3.b(rVar);
            }
            i10 += iMin;
            iB++;
        }
        fVar.f6113v += (long) i;
    }

    public final byte[] j() {
        byte[] bArr = new byte[a()];
        byte[][] bArr2 = this.f6152y;
        int length = bArr2.length;
        int i = 0;
        int i10 = 0;
        int i11 = 0;
        while (i < length) {
            int[] iArr = this.f6153z;
            int i12 = iArr[length + i];
            int i13 = iArr[i];
            int i14 = i13 - i10;
            od.h.R(i11, i12, i12 + i14, bArr2[i], bArr);
            i11 += i14;
            i++;
            i10 = i13;
        }
        return bArr;
    }

    @Override // hf.i
    public final String toString() {
        return new i(j()).toString();
    }
}
