package ag;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends h {
    public final transient int[] A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient byte[][] f471z;

    public t(byte[][] bArr, int[] iArr) {
        super(h.f430y.f431v);
        this.f471z = bArr;
        this.A = iArr;
    }

    @Override // ag.h
    public final int a() {
        return this.A[this.f471z.length - 1];
    }

    @Override // ag.h
    public final String b() {
        return new h(l()).b();
    }

    @Override // ag.h
    public final byte[] c() {
        return l();
    }

    @Override // ag.h
    public final byte d(int i) {
        byte[][] bArr = this.f471z;
        int length = bArr.length - 1;
        int[] iArr = this.A;
        u8.a.f(iArr[length], i, 1L);
        int iB = bg.b.b(this, i);
        return bArr[iB][(i - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // ag.h
    public final boolean e(int i, int i10, int i11, byte[] bArr) {
        ge.i.e(bArr, "other");
        if (i < 0 || i > a() - i11 || i10 < 0 || i10 > bArr.length - i11) {
            return false;
        }
        int i12 = i11 + i;
        int iB = bg.b.b(this, i);
        while (i < i12) {
            int[] iArr = this.A;
            int i13 = iB == 0 ? 0 : iArr[iB - 1];
            int i14 = iArr[iB] - i13;
            byte[][] bArr2 = this.f471z;
            int i15 = iArr[bArr2.length + iB];
            int iMin = Math.min(i12, i14 + i13) - i;
            if (!u8.a.c((i - i13) + i15, i10, iMin, bArr2[iB], bArr)) {
                return false;
            }
            i10 += iMin;
            i += iMin;
            iB++;
        }
        return true;
    }

    @Override // ag.h
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return hVar.a() == a() && f(hVar, a());
    }

    @Override // ag.h
    public final boolean f(h hVar, int i) {
        ge.i.e(hVar, "other");
        if (a() - i >= 0) {
            int iB = bg.b.b(this, 0);
            int i10 = 0;
            int i11 = 0;
            while (i10 < i) {
                int[] iArr = this.A;
                int i12 = iB == 0 ? 0 : iArr[iB - 1];
                int i13 = iArr[iB] - i12;
                byte[][] bArr = this.f471z;
                int i14 = iArr[bArr.length + iB];
                int iMin = Math.min(i, i13 + i12) - i10;
                if (hVar.e(i11, (i10 - i12) + i14, iMin, bArr[iB])) {
                    i11 += iMin;
                    i10 += iMin;
                    iB++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // ag.h
    public final String g(Charset charset) {
        ge.i.e(charset, "charset");
        return new h(l()).g(charset);
    }

    @Override // ag.h
    public final h h(int i, int i10) {
        if (i10 == -1234567890) {
            i10 = a();
        }
        if (i < 0) {
            throw new IllegalArgumentException(l0.e.h(i, "beginIndex=", " < 0").toString());
        }
        if (i10 > a()) {
            StringBuilder sbM = l0.e.m(i10, "endIndex=", " > length(");
            sbM.append(a());
            sbM.append(')');
            throw new IllegalArgumentException(sbM.toString().toString());
        }
        int i11 = i10 - i;
        if (i11 < 0) {
            throw new IllegalArgumentException(q4.a.m(i10, i, "endIndex=", " < beginIndex=").toString());
        }
        if (i == 0 && i10 == a()) {
            return this;
        }
        if (i == i10) {
            return h.f430y;
        }
        int iB = bg.b.b(this, i);
        int iB2 = bg.b.b(this, i10 - 1);
        byte[][] bArr = this.f471z;
        byte[][] bArr2 = (byte[][]) sd.i.k(bArr, iB, iB2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.A;
        if (iB <= iB2) {
            int i12 = iB;
            int i13 = 0;
            while (true) {
                iArr[i13] = Math.min(iArr2[i12] - i, i11);
                int i14 = i13 + 1;
                iArr[i13 + bArr2.length] = iArr2[bArr.length + i12];
                if (i12 == iB2) {
                    break;
                }
                i12++;
                i13 = i14;
            }
        }
        int i15 = iB != 0 ? iArr2[iB - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i - i15) + iArr[length];
        return new t(bArr2, iArr);
    }

    @Override // ag.h
    public final int hashCode() {
        int i = this.f432w;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.f471z;
        int length = bArr.length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int[] iArr = this.A;
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
        this.f432w = i11;
        return i11;
    }

    @Override // ag.h
    public final h i() {
        return new h(l()).i();
    }

    @Override // ag.h
    public final void k(e eVar, int i) {
        int iB = bg.b.b(this, 0);
        int i10 = 0;
        while (i10 < i) {
            int[] iArr = this.A;
            int i11 = iB == 0 ? 0 : iArr[iB - 1];
            int i12 = iArr[iB] - i11;
            byte[][] bArr = this.f471z;
            int i13 = iArr[bArr.length + iB];
            int iMin = Math.min(i, i12 + i11) - i10;
            int i14 = (i10 - i11) + i13;
            r rVar = new r(bArr[iB], i14, i14 + iMin, true);
            r rVar2 = eVar.f428v;
            if (rVar2 == null) {
                rVar.f467g = rVar;
                rVar.f = rVar;
                eVar.f428v = rVar;
            } else {
                r rVar3 = rVar2.f467g;
                ge.i.b(rVar3);
                rVar3.b(rVar);
            }
            i10 += iMin;
            iB++;
        }
        eVar.f429w += (long) i;
    }

    public final byte[] l() {
        byte[] bArr = new byte[a()];
        byte[][] bArr2 = this.f471z;
        int length = bArr2.length;
        int i = 0;
        int i10 = 0;
        int i11 = 0;
        while (i < length) {
            int[] iArr = this.A;
            int i12 = iArr[length + i];
            int i13 = iArr[i];
            int i14 = i13 - i10;
            sd.i.f(i11, i12, i12 + i14, bArr2[i], bArr);
            i11 += i14;
            i++;
            i10 = i13;
        }
        return bArr;
    }

    @Override // ag.h
    public final String toString() {
        return new h(l()).toString();
    }
}
