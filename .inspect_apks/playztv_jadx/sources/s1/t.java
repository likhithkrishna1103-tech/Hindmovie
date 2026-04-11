package s1;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f11703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11706e;

    public t() {
        this.f11702a = 0;
        this.f11703b = b0.f11649c;
    }

    public void a() {
        int i;
        int i10;
        switch (this.f11702a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i11 = this.f11704c;
                d.g(i11 >= 0 && (i11 < (i = this.f11706e) || (i11 == i && this.f11705d == 0)));
                break;
            default:
                int i12 = this.f11705d;
                d.g(i12 >= 0 && (i12 < (i10 = this.f11704c) || (i12 == i10 && this.f11706e == 0)));
                break;
        }
    }

    public int b() {
        return ((this.f11706e - this.f11704c) * 8) - this.f11705d;
    }

    public void c() {
        if (this.f11705d == 0) {
            return;
        }
        this.f11705d = 0;
        this.f11704c++;
        a();
    }

    public boolean d(int i) {
        int i10 = this.f11705d;
        int i11 = i / 8;
        int i12 = i10 + i11;
        int i13 = (this.f11706e + i) - (i11 * 8);
        if (i13 > 7) {
            i12++;
            i13 -= 8;
        }
        while (true) {
            i10++;
            if (i10 > i12 || i12 >= this.f11704c) {
                break;
            }
            if (r(i10)) {
                i12++;
                i10 += 2;
            }
        }
        int i14 = this.f11704c;
        if (i12 >= i14) {
            return i12 == i14 && i13 == 0;
        }
        return true;
    }

    public boolean e() {
        int i = this.f11705d;
        int i10 = this.f11706e;
        int i11 = 0;
        while (this.f11705d < this.f11704c && !h()) {
            i11++;
        }
        boolean z2 = this.f11705d == this.f11704c;
        this.f11705d = i;
        this.f11706e = i10;
        return !z2 && d((i11 * 2) + 1);
    }

    public int f() {
        d.g(this.f11705d == 0);
        return this.f11704c;
    }

    public int g() {
        return (this.f11704c * 8) + this.f11705d;
    }

    public boolean h() {
        switch (this.f11702a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                boolean z2 = (this.f11703b[this.f11704c] & (128 >> this.f11705d)) != 0;
                s();
                return z2;
            case 1:
                boolean z10 = (this.f11703b[this.f11705d] & (128 >> this.f11706e)) != 0;
                s();
                return z10;
            default:
                boolean z11 = (((this.f11703b[this.f11705d] & 255) >> this.f11706e) & 1) == 1;
                t(1);
                return z11;
        }
    }

    public int i(int i) {
        switch (this.f11702a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i == 0) {
                    return 0;
                }
                this.f11705d += i;
                int i10 = 0;
                while (true) {
                    int i11 = this.f11705d;
                    if (i11 <= 8) {
                        byte[] bArr = this.f11703b;
                        int i12 = this.f11704c;
                        int i13 = ((-1) >>> (32 - i)) & (i10 | ((bArr[i12] & 255) >> (8 - i11)));
                        if (i11 == 8) {
                            this.f11705d = 0;
                            this.f11704c = i12 + 1;
                        }
                        a();
                        return i13;
                    }
                    int i14 = i11 - 8;
                    this.f11705d = i14;
                    byte[] bArr2 = this.f11703b;
                    int i15 = this.f11704c;
                    this.f11704c = i15 + 1;
                    i10 |= (bArr2[i15] & 255) << i14;
                }
                break;
            case 1:
                this.f11706e += i;
                int i16 = 0;
                while (true) {
                    int i17 = this.f11706e;
                    if (i17 <= 8) {
                        byte[] bArr3 = this.f11703b;
                        int i18 = this.f11705d;
                        int i19 = ((-1) >>> (32 - i)) & (i16 | ((bArr3[i18] & 255) >> (8 - i17)));
                        if (i17 == 8) {
                            this.f11706e = 0;
                            this.f11705d = i18 + (r(i18 + 1) ? 2 : 1);
                        }
                        a();
                        return i19;
                    }
                    int i20 = i17 - 8;
                    this.f11706e = i20;
                    byte[] bArr4 = this.f11703b;
                    int i21 = this.f11705d;
                    i16 |= (bArr4[i21] & 255) << i20;
                    if (!r(i21 + 1)) {
                        i = 1;
                    }
                    this.f11705d = i21 + i;
                }
                break;
            default:
                int i22 = this.f11705d;
                int iMin = Math.min(i, 8 - this.f11706e);
                byte[] bArr5 = this.f11703b;
                int i23 = i22 + 1;
                int i24 = ((bArr5[i22] & 255) >> this.f11706e) & (255 >> (8 - iMin));
                while (iMin < i) {
                    i24 |= (bArr5[i23] & 255) << iMin;
                    iMin += 8;
                    i23++;
                }
                int i25 = i24 & ((-1) >>> (32 - i));
                t(i);
                return i25;
        }
    }

    public void j(int i, byte[] bArr) {
        int i10 = i >> 3;
        for (int i11 = 0; i11 < i10; i11++) {
            byte[] bArr2 = this.f11703b;
            int i12 = this.f11704c;
            int i13 = i12 + 1;
            this.f11704c = i13;
            byte b10 = bArr2[i12];
            int i14 = this.f11705d;
            byte b11 = (byte) (b10 << i14);
            bArr[i11] = b11;
            bArr[i11] = (byte) (((255 & bArr2[i13]) >> (8 - i14)) | b11);
        }
        int i15 = i & 7;
        if (i15 == 0) {
            return;
        }
        byte b12 = (byte) (bArr[i10] & (255 >> i15));
        bArr[i10] = b12;
        int i16 = this.f11705d;
        if (i16 + i15 > 8) {
            byte[] bArr3 = this.f11703b;
            int i17 = this.f11704c;
            this.f11704c = i17 + 1;
            bArr[i10] = (byte) (b12 | ((bArr3[i17] & 255) << i16));
            this.f11705d = i16 - 8;
        }
        int i18 = this.f11705d + i15;
        this.f11705d = i18;
        byte[] bArr4 = this.f11703b;
        int i19 = this.f11704c;
        bArr[i10] = (byte) (((byte) (((255 & bArr4[i19]) >> (8 - i18)) << (8 - i15))) | bArr[i10]);
        if (i18 == 8) {
            this.f11705d = 0;
            this.f11704c = i19 + 1;
        }
        a();
    }

    public long k(int i) {
        if (i <= 32) {
            int i10 = i(i);
            int i11 = b0.f11647a;
            return 4294967295L & ((long) i10);
        }
        int i12 = i(i - 32);
        int i13 = i(32);
        int i14 = b0.f11647a;
        return (4294967295L & ((long) i13)) | ((((long) i12) & 4294967295L) << 32);
    }

    public void l(int i, byte[] bArr) {
        d.g(this.f11705d == 0);
        System.arraycopy(this.f11703b, this.f11704c, bArr, 0, i);
        this.f11704c += i;
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
        this.f11703b = bArr;
        this.f11704c = 0;
        this.f11705d = 0;
        this.f11706e = i;
    }

    public void p(u uVar) {
        o(uVar.f11711c, uVar.f11709a);
        q(uVar.f11710b * 8);
    }

    public void q(int i) {
        int i10 = i / 8;
        this.f11704c = i10;
        this.f11705d = i - (i10 * 8);
        a();
    }

    public boolean r(int i) {
        if (2 > i || i >= this.f11704c) {
            return false;
        }
        byte[] bArr = this.f11703b;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i - 1] == 0;
    }

    public void s() {
        switch (this.f11702a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f11705d + 1;
                this.f11705d = i;
                if (i == 8) {
                    this.f11705d = 0;
                    this.f11704c++;
                }
                a();
                break;
            default:
                int i10 = this.f11706e + 1;
                this.f11706e = i10;
                if (i10 == 8) {
                    this.f11706e = 0;
                    int i11 = this.f11705d;
                    this.f11705d = i11 + (r(i11 + 1) ? 2 : 1);
                }
                a();
                break;
        }
    }

    public void t(int i) {
        int i10;
        switch (this.f11702a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i11 = i / 8;
                int i12 = this.f11704c + i11;
                this.f11704c = i12;
                int i13 = (i - (i11 * 8)) + this.f11705d;
                this.f11705d = i13;
                if (i13 > 7) {
                    this.f11704c = i12 + 1;
                    this.f11705d = i13 - 8;
                }
                a();
                break;
            case 1:
                int i14 = this.f11705d;
                int i15 = i / 8;
                int i16 = i14 + i15;
                this.f11705d = i16;
                int i17 = (i - (i15 * 8)) + this.f11706e;
                this.f11706e = i17;
                if (i17 > 7) {
                    this.f11705d = i16 + 1;
                    this.f11706e = i17 - 8;
                }
                while (true) {
                    i14++;
                    if (i14 > this.f11705d) {
                        a();
                        break;
                    } else if (r(i14)) {
                        this.f11705d++;
                        i14 += 2;
                    }
                }
                break;
            default:
                int i18 = i / 8;
                int i19 = this.f11705d + i18;
                this.f11705d = i19;
                int i20 = (i - (i18 * 8)) + this.f11706e;
                this.f11706e = i20;
                boolean z2 = true;
                if (i20 > 7) {
                    this.f11705d = i19 + 1;
                    this.f11706e = i20 - 8;
                }
                int i21 = this.f11705d;
                if (i21 < 0 || (i21 >= (i10 = this.f11704c) && (i21 != i10 || this.f11706e != 0))) {
                    z2 = false;
                }
                d.g(z2);
                break;
        }
    }

    public void u(int i) {
        d.g(this.f11705d == 0);
        this.f11704c += i;
        a();
    }

    public t(byte[] bArr) {
        this.f11702a = 3;
        this.f11703b = bArr;
        this.f11704c = bArr.length;
    }

    public t(byte[] bArr, int i, int i10) {
        this.f11702a = 1;
        this.f11703b = bArr;
        this.f11705d = i;
        this.f11704c = i10;
        this.f11706e = 0;
        a();
    }

    public t(int i, byte[] bArr) {
        this.f11702a = 0;
        this.f11703b = bArr;
        this.f11706e = i;
    }

    public t(int i, int i10) {
        this.f11702a = 2;
        this.f11704c = i;
        this.f11705d = i10;
        this.f11703b = new byte[(i10 * 2) - 1];
        this.f11706e = 0;
    }
}
