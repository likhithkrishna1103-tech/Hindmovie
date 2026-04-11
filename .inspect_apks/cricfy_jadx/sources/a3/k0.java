package a3;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f211e;

    public k0() {
        this.f207a = 1;
        this.f208b = y1.a0.f14553c;
    }

    public void a() {
        int i;
        int i10;
        switch (this.f207a) {
            case 1:
                int i11 = this.f209c;
                y1.d.g(i11 >= 0 && (i11 < (i = this.f211e) || (i11 == i && this.f210d == 0)));
                break;
            default:
                int i12 = this.f210d;
                y1.d.g(i12 >= 0 && (i12 < (i10 = this.f209c) || (i12 == i10 && this.f211e == 0)));
                break;
        }
    }

    public int b() {
        return ((this.f211e - this.f209c) * 8) - this.f210d;
    }

    public void c() {
        if (this.f210d == 0) {
            return;
        }
        this.f210d = 0;
        this.f209c++;
        a();
    }

    public boolean d(int i) {
        int i10 = this.f210d;
        int i11 = i / 8;
        int i12 = i10 + i11;
        int i13 = (this.f211e + i) - (i11 * 8);
        if (i13 > 7) {
            i12++;
            i13 -= 8;
        }
        while (true) {
            i10++;
            if (i10 > i12 || i12 >= this.f209c) {
                break;
            }
            if (r(i10)) {
                i12++;
                i10 += 2;
            }
        }
        int i14 = this.f209c;
        if (i12 >= i14) {
            return i12 == i14 && i13 == 0;
        }
        return true;
    }

    public boolean e() {
        int i = this.f210d;
        int i10 = this.f211e;
        int i11 = 0;
        while (this.f210d < this.f209c && !h()) {
            i11++;
        }
        boolean z10 = this.f210d == this.f209c;
        this.f210d = i;
        this.f211e = i10;
        return !z10 && d((i11 * 2) + 1);
    }

    public int f() {
        y1.d.g(this.f210d == 0);
        return this.f209c;
    }

    public int g() {
        return (this.f209c * 8) + this.f210d;
    }

    public boolean h() {
        switch (this.f207a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                boolean z10 = (((this.f208b[this.f210d] & 255) >> this.f211e) & 1) == 1;
                t(1);
                return z10;
            case 1:
                boolean z11 = (this.f208b[this.f209c] & (128 >> this.f210d)) != 0;
                s();
                return z11;
            default:
                boolean z12 = (this.f208b[this.f210d] & (128 >> this.f211e)) != 0;
                s();
                return z12;
        }
    }

    public int i(int i) {
        switch (this.f207a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i10 = this.f210d;
                int iMin = Math.min(i, 8 - this.f211e);
                byte[] bArr = this.f208b;
                int i11 = i10 + 1;
                int i12 = ((bArr[i10] & 255) >> this.f211e) & (255 >> (8 - iMin));
                while (iMin < i) {
                    i12 |= (bArr[i11] & 255) << iMin;
                    iMin += 8;
                    i11++;
                }
                int i13 = i12 & ((-1) >>> (32 - i));
                t(i);
                return i13;
            case 1:
                if (i == 0) {
                    return 0;
                }
                this.f210d += i;
                int i14 = 0;
                while (true) {
                    int i15 = this.f210d;
                    if (i15 <= 8) {
                        byte[] bArr2 = this.f208b;
                        int i16 = this.f209c;
                        int i17 = ((-1) >>> (32 - i)) & (i14 | ((bArr2[i16] & 255) >> (8 - i15)));
                        if (i15 == 8) {
                            this.f210d = 0;
                            this.f209c = i16 + 1;
                        }
                        a();
                        return i17;
                    }
                    int i18 = i15 - 8;
                    this.f210d = i18;
                    byte[] bArr3 = this.f208b;
                    int i19 = this.f209c;
                    this.f209c = i19 + 1;
                    i14 |= (bArr3[i19] & 255) << i18;
                }
                break;
            default:
                this.f211e += i;
                int i20 = 0;
                while (true) {
                    int i21 = this.f211e;
                    if (i21 <= 8) {
                        byte[] bArr4 = this.f208b;
                        int i22 = this.f210d;
                        int i23 = ((-1) >>> (32 - i)) & (i20 | ((bArr4[i22] & 255) >> (8 - i21)));
                        if (i21 == 8) {
                            this.f211e = 0;
                            this.f210d = i22 + (r(i22 + 1) ? 2 : 1);
                        }
                        a();
                        return i23;
                    }
                    int i24 = i21 - 8;
                    this.f211e = i24;
                    byte[] bArr5 = this.f208b;
                    int i25 = this.f210d;
                    i20 |= (bArr5[i25] & 255) << i24;
                    if (!r(i25 + 1)) {
                        i = 1;
                    }
                    this.f210d = i25 + i;
                }
                break;
        }
    }

    public void j(int i, byte[] bArr) {
        int i10 = i >> 3;
        for (int i11 = 0; i11 < i10; i11++) {
            byte[] bArr2 = this.f208b;
            int i12 = this.f209c;
            int i13 = i12 + 1;
            this.f209c = i13;
            byte b8 = bArr2[i12];
            int i14 = this.f210d;
            byte b10 = (byte) (b8 << i14);
            bArr[i11] = b10;
            bArr[i11] = (byte) (((255 & bArr2[i13]) >> (8 - i14)) | b10);
        }
        int i15 = i & 7;
        if (i15 == 0) {
            return;
        }
        byte b11 = (byte) (bArr[i10] & (255 >> i15));
        bArr[i10] = b11;
        int i16 = this.f210d;
        if (i16 + i15 > 8) {
            byte[] bArr3 = this.f208b;
            int i17 = this.f209c;
            this.f209c = i17 + 1;
            bArr[i10] = (byte) (b11 | ((bArr3[i17] & 255) << i16));
            this.f210d = i16 - 8;
        }
        int i18 = this.f210d + i15;
        this.f210d = i18;
        byte[] bArr4 = this.f208b;
        int i19 = this.f209c;
        bArr[i10] = (byte) (((byte) (((255 & bArr4[i19]) >> (8 - i18)) << (8 - i15))) | bArr[i10]);
        if (i18 == 8) {
            this.f210d = 0;
            this.f209c = i19 + 1;
        }
        a();
    }

    public long k(int i) {
        if (i <= 32) {
            int i10 = i(i);
            int i11 = y1.a0.f14551a;
            return 4294967295L & ((long) i10);
        }
        int i12 = i(i - 32);
        int i13 = i(32);
        int i14 = y1.a0.f14551a;
        return (4294967295L & ((long) i13)) | ((((long) i12) & 4294967295L) << 32);
    }

    public void l(int i, byte[] bArr) {
        y1.d.g(this.f210d == 0);
        System.arraycopy(this.f208b, this.f209c, bArr, 0, i);
        this.f209c += i;
        a();
    }

    public int m() {
        int i = 0;
        while (!h()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? i(i) : 0);
    }

    public int n() {
        int iM = m();
        return ((iM + 1) / 2) * (iM % 2 == 0 ? -1 : 1);
    }

    public void o(int i, byte[] bArr) {
        this.f208b = bArr;
        this.f209c = 0;
        this.f210d = 0;
        this.f211e = i;
    }

    public void p(y1.t tVar) {
        o(tVar.f14611c, tVar.f14609a);
        q(tVar.f14610b * 8);
    }

    public void q(int i) {
        int i10 = i / 8;
        this.f209c = i10;
        this.f210d = i - (i10 * 8);
        a();
    }

    public boolean r(int i) {
        if (2 > i || i >= this.f209c) {
            return false;
        }
        byte[] bArr = this.f208b;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i - 1] == 0;
    }

    public void s() {
        switch (this.f207a) {
            case 1:
                int i = this.f210d + 1;
                this.f210d = i;
                if (i == 8) {
                    this.f210d = 0;
                    this.f209c++;
                }
                a();
                break;
            default:
                int i10 = this.f211e + 1;
                this.f211e = i10;
                if (i10 == 8) {
                    this.f211e = 0;
                    int i11 = this.f210d;
                    this.f210d = i11 + (r(i11 + 1) ? 2 : 1);
                }
                a();
                break;
        }
    }

    public void t(int i) {
        int i10;
        switch (this.f207a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i11 = i / 8;
                int i12 = this.f210d + i11;
                this.f210d = i12;
                int i13 = (i - (i11 * 8)) + this.f211e;
                this.f211e = i13;
                boolean z10 = true;
                if (i13 > 7) {
                    this.f210d = i12 + 1;
                    this.f211e = i13 - 8;
                }
                int i14 = this.f210d;
                if (i14 < 0 || (i14 >= (i10 = this.f209c) && (i14 != i10 || this.f211e != 0))) {
                    z10 = false;
                }
                y1.d.g(z10);
                break;
            case 1:
                int i15 = i / 8;
                int i16 = this.f209c + i15;
                this.f209c = i16;
                int i17 = (i - (i15 * 8)) + this.f210d;
                this.f210d = i17;
                if (i17 > 7) {
                    this.f209c = i16 + 1;
                    this.f210d = i17 - 8;
                }
                a();
                break;
            default:
                int i18 = this.f210d;
                int i19 = i / 8;
                int i20 = i18 + i19;
                this.f210d = i20;
                int i21 = (i - (i19 * 8)) + this.f211e;
                this.f211e = i21;
                if (i21 > 7) {
                    this.f210d = i20 + 1;
                    this.f211e = i21 - 8;
                }
                while (true) {
                    i18++;
                    if (i18 > this.f210d) {
                        a();
                        break;
                    } else if (r(i18)) {
                        this.f210d++;
                        i18 += 2;
                    }
                }
                break;
        }
    }

    public void u(int i) {
        y1.d.g(this.f210d == 0);
        this.f209c += i;
        a();
    }

    public k0(byte[] bArr) {
        this.f207a = 0;
        this.f208b = bArr;
        this.f209c = bArr.length;
    }

    public k0(byte[] bArr, int i, int i10) {
        this.f207a = 3;
        this.f208b = bArr;
        this.f210d = i;
        this.f209c = i10;
        this.f211e = 0;
        a();
    }

    public k0(int i, byte[] bArr) {
        this.f207a = 1;
        this.f208b = bArr;
        this.f211e = i;
    }

    public k0(int i, int i10) {
        this.f207a = 2;
        this.f209c = i;
        this.f210d = i10;
        this.f208b = new byte[(i10 * 2) - 1];
        this.f211e = 0;
    }
}
