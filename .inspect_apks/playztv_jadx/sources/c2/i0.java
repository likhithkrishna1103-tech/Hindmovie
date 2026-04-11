package c2;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends q1.h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f2345q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte[] f2347s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f2350v;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2346r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2348t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2349u = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f2340l = 100000;
    public final float i = 0.2f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f2341m = 2000000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2339k = 10;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short f2338j = 1024;

    public i0() {
        byte[] bArr = s1.b0.f11649c;
        this.f2347s = bArr;
        this.f2350v = bArr;
    }

    @Override // q1.h, q1.g
    public final boolean a() {
        return super.a() && this.f2343o;
    }

    @Override // q1.g
    public final void e(ByteBuffer byteBuffer) {
        int iLimit;
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.f10552g.hasRemaining()) {
            int i = this.f2344p;
            short s3 = this.f2338j;
            if (i == 0) {
                int iLimit2 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit2, byteBuffer.position() + this.f2347s.length));
                int iLimit3 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit3 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iLimit3) << 8) | (byteBuffer.get(iLimit3 - 1) & 255)) > s3) {
                        int i10 = this.f2342n;
                        iPosition = ((iLimit3 / i10) * i10) + i10;
                        break;
                    }
                    iLimit3 -= 2;
                }
                if (iPosition == byteBuffer.position()) {
                    this.f2344p = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    k(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit2);
            } else {
                if (i != 1) {
                    throw new IllegalStateException();
                }
                s1.d.g(this.f2348t < this.f2347s.length);
                int iLimit4 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iPosition2) << 8) | (byteBuffer.get(iPosition2 - 1) & 255)) > s3) {
                        int i11 = this.f2342n;
                        iLimit = (iPosition2 / i11) * i11;
                        break;
                    }
                    iPosition2 += 2;
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int length = this.f2348t;
                int i12 = this.f2349u;
                int length2 = length + i12;
                byte[] bArr = this.f2347s;
                if (length2 < bArr.length) {
                    length = bArr.length;
                } else {
                    length2 = i12 - (bArr.length - length);
                }
                int i13 = length - length2;
                boolean z2 = iLimit < iLimit4;
                int iMin = Math.min(iPosition3, i13);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.f2347s, length2, iMin);
                int i14 = this.f2349u + iMin;
                this.f2349u = i14;
                s1.d.g(i14 <= this.f2347s.length);
                boolean z10 = z2 && iPosition3 < i13;
                m(z10);
                if (z10) {
                    this.f2344p = 0;
                    this.f2346r = 0;
                }
                byteBuffer.limit(iLimit4);
            }
        }
    }

    @Override // q1.h
    public final q1.e g(q1.e eVar) throws q1.f {
        if (eVar.f10545c == 2) {
            return eVar.f10543a == -1 ? q1.e.f10542e : eVar;
        }
        throw new q1.f(eVar);
    }

    @Override // q1.h
    public final void h() {
        if (a()) {
            q1.e eVar = this.f10548b;
            int i = eVar.f10544b * 2;
            this.f2342n = i;
            int i10 = ((((int) ((this.f2340l * ((long) eVar.f10543a)) / 1000000)) / 2) / i) * i * 2;
            if (this.f2347s.length != i10) {
                this.f2347s = new byte[i10];
                this.f2350v = new byte[i10];
            }
        }
        this.f2344p = 0;
        this.f2345q = 0L;
        this.f2346r = 0;
        this.f2348t = 0;
        this.f2349u = 0;
    }

    @Override // q1.h
    public final void i() {
        if (this.f2349u > 0) {
            m(true);
            this.f2346r = 0;
        }
    }

    @Override // q1.h
    public final void j() {
        this.f2343o = false;
        byte[] bArr = s1.b0.f11649c;
        this.f2347s = bArr;
        this.f2350v = bArr;
    }

    public final int l(int i) {
        int length = ((((int) ((this.f2341m * ((long) this.f10548b.f10543a)) / 1000000)) - this.f2346r) * this.f2342n) - (this.f2347s.length / 2);
        s1.d.g(length >= 0);
        int iMin = (int) Math.min((i * this.i) + 0.5f, length);
        int i10 = this.f2342n;
        return (iMin / i10) * i10;
    }

    public final void m(boolean z2) {
        int length;
        int iL;
        int i = this.f2349u;
        byte[] bArr = this.f2347s;
        if (i == bArr.length || z2) {
            if (this.f2346r == 0) {
                if (z2) {
                    n(i, 3);
                    length = i;
                } else {
                    s1.d.g(i >= bArr.length / 2);
                    length = this.f2347s.length / 2;
                    n(length, 0);
                }
                iL = length;
            } else if (z2) {
                int length2 = i - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iL2 = l(length2) + (this.f2347s.length / 2);
                n(iL2, 2);
                iL = iL2;
                length = length3;
            } else {
                length = i - (bArr.length / 2);
                iL = l(length);
                n(iL, 1);
            }
            s1.d.f("bytesConsumed is not aligned to frame size: %s" + length, length % this.f2342n == 0);
            s1.d.g(i >= iL);
            this.f2349u -= length;
            int i10 = this.f2348t + length;
            this.f2348t = i10;
            this.f2348t = i10 % this.f2347s.length;
            int i11 = this.f2346r;
            int i12 = this.f2342n;
            this.f2346r = (iL / i12) + i11;
            this.f2345q += (long) ((length - iL) / i12);
        }
    }

    public final void n(int i, int i10) {
        if (i == 0) {
            return;
        }
        s1.d.b(this.f2349u >= i);
        if (i10 == 2) {
            int i11 = this.f2348t;
            int i12 = this.f2349u;
            int i13 = i11 + i12;
            byte[] bArr = this.f2347s;
            if (i13 <= bArr.length) {
                System.arraycopy(bArr, i13 - i, this.f2350v, 0, i);
            } else {
                int length = i12 - (bArr.length - i11);
                if (length >= i) {
                    System.arraycopy(bArr, length - i, this.f2350v, 0, i);
                } else {
                    int i14 = i - length;
                    System.arraycopy(bArr, bArr.length - i14, this.f2350v, 0, i14);
                    System.arraycopy(this.f2347s, 0, this.f2350v, i14, length);
                }
            }
        } else {
            int i15 = this.f2348t;
            int i16 = i15 + i;
            byte[] bArr2 = this.f2347s;
            if (i16 <= bArr2.length) {
                System.arraycopy(bArr2, i15, this.f2350v, 0, i);
            } else {
                int length2 = bArr2.length - i15;
                System.arraycopy(bArr2, i15, this.f2350v, 0, length2);
                System.arraycopy(this.f2347s, 0, this.f2350v, length2, i - length2);
            }
        }
        s1.d.a("sizeToOutput is not aligned to frame size: " + i, i % this.f2342n == 0);
        s1.d.g(this.f2348t < this.f2347s.length);
        byte[] bArr3 = this.f2350v;
        s1.d.a("byteOutput size is not aligned to frame size " + i, i % this.f2342n == 0);
        if (i10 != 3) {
            for (int i17 = 0; i17 < i; i17 += 2) {
                int i18 = i17 + 1;
                int i19 = (bArr3[i18] << 8) | (bArr3[i17] & 255);
                int i20 = this.f2339k;
                if (i10 == 0) {
                    i20 = ((((i17 * 1000) / (i - 1)) * (i20 - 100)) / 1000) + 100;
                } else if (i10 == 2) {
                    i20 += (((i17 * 1000) * (100 - i20)) / (i - 1)) / 1000;
                }
                int i21 = (i19 * i20) / 100;
                if (i21 >= 32767) {
                    bArr3[i17] = -1;
                    bArr3[i18] = 127;
                } else if (i21 <= -32768) {
                    bArr3[i17] = 0;
                    bArr3[i18] = -128;
                } else {
                    bArr3[i17] = (byte) (i21 & 255);
                    bArr3[i18] = (byte) (i21 >> 8);
                }
            }
        }
        k(i).put(bArr3, 0, i).flip();
    }
}
