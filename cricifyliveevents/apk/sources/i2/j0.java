package i2;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends w1.i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6076n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f6079q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte[] f6081s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f6084v;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6080r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6082t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6083u = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f6074l = 100000;
    public final float i = 0.2f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f6075m = 2000000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f6073k = 10;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short f6072j = 1024;

    public j0() {
        byte[] bArr = y1.a0.f14553c;
        this.f6081s = bArr;
        this.f6084v = bArr;
    }

    @Override // w1.i, w1.h
    public final boolean a() {
        return super.a() && this.f6077o;
    }

    @Override // w1.h
    public final void f(ByteBuffer byteBuffer) {
        int iLimit;
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.f13800g.hasRemaining()) {
            int i = this.f6078p;
            short s10 = this.f6072j;
            if (i == 0) {
                int iLimit2 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit2, byteBuffer.position() + this.f6081s.length));
                int iLimit3 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit3 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iLimit3) << 8) | (byteBuffer.get(iLimit3 - 1) & 255)) > s10) {
                        int i10 = this.f6076n;
                        iPosition = ((iLimit3 / i10) * i10) + i10;
                        break;
                    }
                    iLimit3 -= 2;
                }
                if (iPosition == byteBuffer.position()) {
                    this.f6078p = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    k(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit2);
            } else {
                if (i != 1) {
                    throw new IllegalStateException();
                }
                y1.d.g(this.f6082t < this.f6081s.length);
                int iLimit4 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iPosition2) << 8) | (byteBuffer.get(iPosition2 - 1) & 255)) > s10) {
                        int i11 = this.f6076n;
                        iLimit = (iPosition2 / i11) * i11;
                        break;
                    }
                    iPosition2 += 2;
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int length = this.f6082t;
                int i12 = this.f6083u;
                int length2 = length + i12;
                byte[] bArr = this.f6081s;
                if (length2 < bArr.length) {
                    length = bArr.length;
                } else {
                    length2 = i12 - (bArr.length - length);
                }
                int i13 = length - length2;
                boolean z10 = iLimit < iLimit4;
                int iMin = Math.min(iPosition3, i13);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.f6081s, length2, iMin);
                int i14 = this.f6083u + iMin;
                this.f6083u = i14;
                y1.d.g(i14 <= this.f6081s.length);
                boolean z11 = z10 && iPosition3 < i13;
                m(z11);
                if (z11) {
                    this.f6078p = 0;
                    this.f6080r = 0;
                }
                byteBuffer.limit(iLimit4);
            }
        }
    }

    @Override // w1.i
    public final w1.f g(w1.f fVar) throws w1.g {
        if (fVar.f13793c == 2) {
            return fVar.f13791a == -1 ? w1.f.f13790e : fVar;
        }
        throw new w1.g(fVar);
    }

    @Override // w1.i
    public final void h() {
        if (a()) {
            w1.f fVar = this.f13796b;
            int i = fVar.f13792b * 2;
            this.f6076n = i;
            int i10 = ((((int) ((this.f6074l * ((long) fVar.f13791a)) / 1000000)) / 2) / i) * i * 2;
            if (this.f6081s.length != i10) {
                this.f6081s = new byte[i10];
                this.f6084v = new byte[i10];
            }
        }
        this.f6078p = 0;
        this.f6079q = 0L;
        this.f6080r = 0;
        this.f6082t = 0;
        this.f6083u = 0;
    }

    @Override // w1.i
    public final void i() {
        if (this.f6083u > 0) {
            m(true);
            this.f6080r = 0;
        }
    }

    @Override // w1.i
    public final void j() {
        this.f6077o = false;
        byte[] bArr = y1.a0.f14553c;
        this.f6081s = bArr;
        this.f6084v = bArr;
    }

    public final int l(int i) {
        int length = ((((int) ((this.f6075m * ((long) this.f13796b.f13791a)) / 1000000)) - this.f6080r) * this.f6076n) - (this.f6081s.length / 2);
        y1.d.g(length >= 0);
        int iMin = (int) Math.min((i * this.i) + 0.5f, length);
        int i10 = this.f6076n;
        return (iMin / i10) * i10;
    }

    public final void m(boolean z10) {
        int length;
        int iL;
        int i = this.f6083u;
        byte[] bArr = this.f6081s;
        if (i == bArr.length || z10) {
            if (this.f6080r == 0) {
                if (z10) {
                    n(i, 3);
                    length = i;
                } else {
                    y1.d.g(i >= bArr.length / 2);
                    length = this.f6081s.length / 2;
                    n(length, 0);
                }
                iL = length;
            } else if (z10) {
                int length2 = i - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iL2 = l(length2) + (this.f6081s.length / 2);
                n(iL2, 2);
                iL = iL2;
                length = length3;
            } else {
                length = i - (bArr.length / 2);
                iL = l(length);
                n(iL, 1);
            }
            y1.d.f("bytesConsumed is not aligned to frame size: %s" + length, length % this.f6076n == 0);
            y1.d.g(i >= iL);
            this.f6083u -= length;
            int i10 = this.f6082t + length;
            this.f6082t = i10;
            this.f6082t = i10 % this.f6081s.length;
            int i11 = this.f6080r;
            int i12 = this.f6076n;
            this.f6080r = (iL / i12) + i11;
            this.f6079q += (long) ((length - iL) / i12);
        }
    }

    public final void n(int i, int i10) {
        if (i == 0) {
            return;
        }
        y1.d.b(this.f6083u >= i);
        if (i10 == 2) {
            int i11 = this.f6082t;
            int i12 = this.f6083u;
            int i13 = i11 + i12;
            byte[] bArr = this.f6081s;
            if (i13 <= bArr.length) {
                System.arraycopy(bArr, i13 - i, this.f6084v, 0, i);
            } else {
                int length = i12 - (bArr.length - i11);
                if (length >= i) {
                    System.arraycopy(bArr, length - i, this.f6084v, 0, i);
                } else {
                    int i14 = i - length;
                    System.arraycopy(bArr, bArr.length - i14, this.f6084v, 0, i14);
                    System.arraycopy(this.f6081s, 0, this.f6084v, i14, length);
                }
            }
        } else {
            int i15 = this.f6082t;
            int i16 = i15 + i;
            byte[] bArr2 = this.f6081s;
            if (i16 <= bArr2.length) {
                System.arraycopy(bArr2, i15, this.f6084v, 0, i);
            } else {
                int length2 = bArr2.length - i15;
                System.arraycopy(bArr2, i15, this.f6084v, 0, length2);
                System.arraycopy(this.f6081s, 0, this.f6084v, length2, i - length2);
            }
        }
        y1.d.a("sizeToOutput is not aligned to frame size: " + i, i % this.f6076n == 0);
        y1.d.g(this.f6082t < this.f6081s.length);
        byte[] bArr3 = this.f6084v;
        y1.d.a("byteOutput size is not aligned to frame size " + i, i % this.f6076n == 0);
        if (i10 != 3) {
            for (int i17 = 0; i17 < i; i17 += 2) {
                int i18 = i17 + 1;
                int i19 = (bArr3[i18] << 8) | (bArr3[i17] & 255);
                int i20 = this.f6073k;
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
