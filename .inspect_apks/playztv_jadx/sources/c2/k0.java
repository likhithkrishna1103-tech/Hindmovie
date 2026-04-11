package c2;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends q1.h {
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2357k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f2359m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2361o;

    @Override // q1.h, q1.g
    public final boolean b() {
        return super.b() && this.f2360n == 0;
    }

    @Override // q1.h, q1.g
    public final ByteBuffer c() {
        int i;
        if (super.b() && (i = this.f2360n) > 0) {
            k(i).put(this.f2359m, 0, this.f2360n).flip();
            this.f2360n = 0;
        }
        return super.c();
    }

    @Override // q1.g
    public final void e(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.f2358l);
        this.f2361o += (long) (iMin / this.f10548b.f10546d);
        this.f2358l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f2358l > 0) {
            return;
        }
        int i10 = i - iMin;
        int length = (this.f2360n + i10) - this.f2359m.length;
        ByteBuffer byteBufferK = k(length);
        int i11 = s1.b0.i(length, 0, this.f2360n);
        byteBufferK.put(this.f2359m, 0, i11);
        int i12 = s1.b0.i(length - i11, 0, i10);
        byteBuffer.limit(byteBuffer.position() + i12);
        byteBufferK.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i13 = i10 - i12;
        int i14 = this.f2360n - i11;
        this.f2360n = i14;
        byte[] bArr = this.f2359m;
        System.arraycopy(bArr, i11, bArr, 0, i14);
        byteBuffer.get(this.f2359m, this.f2360n, i13);
        this.f2360n += i13;
        byteBufferK.flip();
    }

    @Override // q1.h
    public final q1.e g(q1.e eVar) throws q1.f {
        if (!s1.b0.J(eVar.f10545c)) {
            throw new q1.f(eVar);
        }
        this.f2357k = true;
        return (this.i == 0 && this.f2356j == 0) ? q1.e.f10542e : eVar;
    }

    @Override // q1.h
    public final void h() {
        if (this.f2357k) {
            this.f2357k = false;
            int i = this.f2356j;
            int i10 = this.f10548b.f10546d;
            this.f2359m = new byte[i * i10];
            this.f2358l = this.i * i10;
        }
        this.f2360n = 0;
    }

    @Override // q1.h
    public final void i() {
        if (this.f2357k) {
            int i = this.f2360n;
            if (i > 0) {
                this.f2361o += (long) (i / this.f10548b.f10546d);
            }
            this.f2360n = 0;
        }
    }

    @Override // q1.h
    public final void j() {
        this.f2359m = s1.b0.f11649c;
    }
}
