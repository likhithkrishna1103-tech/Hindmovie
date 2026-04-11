package i2;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends w1.i {
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f6090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f6092o;

    @Override // w1.i, w1.h
    public final boolean b() {
        return super.b() && this.f6091n == 0;
    }

    @Override // w1.i, w1.h
    public final ByteBuffer c() {
        int i;
        if (super.b() && (i = this.f6091n) > 0) {
            k(i).put(this.f6090m, 0, this.f6091n).flip();
            this.f6091n = 0;
        }
        return super.c();
    }

    @Override // w1.h
    public final void f(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.f6089l);
        this.f6092o += (long) (iMin / this.f13796b.f13794d);
        this.f6089l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f6089l > 0) {
            return;
        }
        int i10 = i - iMin;
        int length = (this.f6091n + i10) - this.f6090m.length;
        ByteBuffer byteBufferK = k(length);
        int i11 = y1.a0.i(length, 0, this.f6091n);
        byteBufferK.put(this.f6090m, 0, i11);
        int i12 = y1.a0.i(length - i11, 0, i10);
        byteBuffer.limit(byteBuffer.position() + i12);
        byteBufferK.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i13 = i10 - i12;
        int i14 = this.f6091n - i11;
        this.f6091n = i14;
        byte[] bArr = this.f6090m;
        System.arraycopy(bArr, i11, bArr, 0, i14);
        byteBuffer.get(this.f6090m, this.f6091n, i13);
        this.f6091n += i13;
        byteBufferK.flip();
    }

    @Override // w1.i
    public final w1.f g(w1.f fVar) throws w1.g {
        if (!y1.a0.J(fVar.f13793c)) {
            throw new w1.g(fVar);
        }
        this.f6088k = true;
        return (this.i == 0 && this.f6087j == 0) ? w1.f.f13790e : fVar;
    }

    @Override // w1.i
    public final void h() {
        if (this.f6088k) {
            this.f6088k = false;
            int i = this.f6087j;
            int i10 = this.f13796b.f13794d;
            this.f6090m = new byte[i * i10];
            this.f6089l = this.i * i10;
        }
        this.f6091n = 0;
    }

    @Override // w1.i
    public final void i() {
        if (this.f6088k) {
            int i = this.f6091n;
            if (i > 0) {
                this.f6092o += (long) (i / this.f13796b.f13794d);
            }
            this.f6091n = 0;
        }
    }

    @Override // w1.i
    public final void j() {
        this.f6090m = y1.a0.f14553c;
    }
}
