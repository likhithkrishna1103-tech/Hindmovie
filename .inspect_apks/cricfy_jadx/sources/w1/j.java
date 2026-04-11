package w1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f13805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f13806e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13808h;
    public final short[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public short[] f13809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short[] f13811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public short[] f13813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13819t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public double f13822w;

    public j(int i, int i10, float f, float f10, int i11) {
        this.f13802a = i;
        this.f13803b = i10;
        this.f13804c = f;
        this.f13805d = f10;
        this.f13806e = i / i11;
        this.f = i / 400;
        int i12 = i / 65;
        this.f13807g = i12;
        int i13 = i12 * 2;
        this.f13808h = i13;
        this.i = new short[i13];
        this.f13809j = new short[i13 * i10];
        this.f13811l = new short[i13 * i10];
        this.f13813n = new short[i13 * i10];
    }

    public static void e(int i, int i10, short[] sArr, int i11, short[] sArr2, int i12, short[] sArr3, int i13) {
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = (i11 * i10) + i14;
            int i16 = (i13 * i10) + i14;
            int i17 = (i12 * i10) + i14;
            for (int i18 = 0; i18 < i; i18++) {
                sArr[i15] = (short) (((sArr3[i16] * i18) + ((i - i18) * sArr2[i17])) / i);
                i15 += i10;
                i17 += i10;
                i16 += i10;
            }
        }
    }

    public final void a(short[] sArr, int i, int i10) {
        short[] sArrC = c(this.f13811l, this.f13812m, i10);
        this.f13811l = sArrC;
        int i11 = this.f13803b;
        System.arraycopy(sArr, i * i11, sArrC, this.f13812m * i11, i11 * i10);
        this.f13812m += i10;
    }

    public final void b(short[] sArr, int i, int i10) {
        int i11 = this.f13808h / i10;
        int i12 = this.f13803b;
        int i13 = i10 * i12;
        int i14 = i * i12;
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = 0;
            for (int i17 = 0; i17 < i13; i17++) {
                i16 += sArr[(i15 * i13) + i14 + i17];
            }
            this.i[i15] = (short) (i16 / i13);
        }
    }

    public final short[] c(short[] sArr, int i, int i10) {
        int length = sArr.length;
        int i11 = this.f13803b;
        int i12 = length / i11;
        return i + i10 <= i12 ? sArr : Arrays.copyOf(sArr, (((i12 * 3) / 2) + i10) * i11);
    }

    public final int d(short[] sArr, int i, int i10, int i11) {
        int i12 = i * this.f13803b;
        int i13 = 255;
        int i14 = 1;
        int i15 = 0;
        int i16 = 0;
        while (i10 <= i11) {
            int iAbs = 0;
            for (int i17 = 0; i17 < i10; i17++) {
                iAbs += Math.abs(sArr[i12 + i17] - sArr[(i12 + i10) + i17]);
            }
            if (iAbs * i15 < i14 * i10) {
                i15 = i10;
                i14 = iAbs;
            }
            if (iAbs * i13 > i16 * i10) {
                i13 = i10;
                i16 = iAbs;
            }
            i10++;
        }
        this.f13820u = i14 / i15;
        this.f13821v = i16 / i13;
        return i15;
    }

    public final void f() {
        float f;
        double d10;
        int iD;
        int i;
        int i10;
        int i11;
        int iRound;
        int i12;
        int i13;
        int i14;
        long j4;
        long j7;
        int i15 = this.f13812m;
        float f10 = this.f13804c;
        float f11 = this.f13805d;
        double d11 = f10 / f11;
        float f12 = this.f13806e * f11;
        int i16 = this.f13802a;
        int i17 = 1;
        int i18 = this.f13803b;
        int i19 = 0;
        if (d11 > 1.0000100135803223d || d11 < 0.9999899864196777d) {
            int i20 = this.f13810k;
            int i21 = this.f13808h;
            if (i20 >= i21) {
                int i22 = 0;
                while (true) {
                    int i23 = this.f13817r;
                    if (i23 > 0) {
                        int iMin = Math.min(i21, i23);
                        a(this.f13809j, i22, iMin);
                        this.f13817r -= iMin;
                        i22 += iMin;
                        f = f12;
                        d10 = d11;
                        i10 = i21;
                    } else {
                        short[] sArr = this.f13809j;
                        int i24 = i16 > 4000 ? i16 / 4000 : i17;
                        int i25 = this.f13807g;
                        int i26 = this.f;
                        if (i18 == i17 && i24 == i17) {
                            iD = d(sArr, i22, i26, i25);
                            f = f12;
                            d10 = d11;
                        } else {
                            b(sArr, i22, i24);
                            f = f12;
                            d10 = d11;
                            short[] sArr2 = this.i;
                            int iD2 = d(sArr2, i19, i26 / i24, i25 / i24);
                            if (i24 != 1) {
                                int i27 = iD2 * i24;
                                int i28 = i24 * 4;
                                int i29 = i27 - i28;
                                int i30 = i27 + i28;
                                if (i29 >= i26) {
                                    i26 = i29;
                                }
                                if (i30 <= i25) {
                                    i25 = i30;
                                }
                                if (i18 == 1) {
                                    iD = d(sArr, i22, i26, i25);
                                } else {
                                    b(sArr, i22, 1);
                                    iD = d(sArr2, i19, i26, i25);
                                }
                            } else {
                                iD = iD2;
                            }
                        }
                        int i31 = this.f13820u;
                        int i32 = this.f13821v;
                        if (i31 == 0 || (i = this.f13818s) == 0 || i32 > i31 * 3 || i31 * 2 <= this.f13819t * 3) {
                            i = iD;
                        }
                        this.f13819t = i31;
                        this.f13818s = iD;
                        if (d10 > 1.0d) {
                            short[] sArr3 = this.f13809j;
                            if (d10 >= 2.0d) {
                                i10 = i21;
                                double d12 = (((double) i) / (d10 - 1.0d)) + this.f13822w;
                                iRound = (int) Math.round(d12);
                                this.f13822w = d12 - ((double) iRound);
                            } else {
                                i10 = i21;
                                double d13 = (((2.0d - d10) * ((double) i)) / (d10 - 1.0d)) + this.f13822w;
                                int iRound2 = (int) Math.round(d13);
                                this.f13817r = iRound2;
                                this.f13822w = d13 - ((double) iRound2);
                                iRound = i;
                            }
                            short[] sArrC = c(this.f13811l, this.f13812m, iRound);
                            this.f13811l = sArrC;
                            int i33 = i22 + i;
                            int i34 = i22;
                            int i35 = iRound;
                            e(i35, this.f13803b, sArrC, this.f13812m, sArr3, i34, sArr3, i33);
                            this.f13812m += i35;
                            i22 = i + i35 + i34;
                        } else {
                            i10 = i21;
                            int i36 = i22;
                            short[] sArr4 = this.f13809j;
                            if (d10 < 0.5d) {
                                double d14 = ((((double) i) * d10) / (1.0d - d10)) + this.f13822w;
                                int iRound3 = (int) Math.round(d14);
                                this.f13822w = d14 - ((double) iRound3);
                                i11 = iRound3;
                            } else {
                                double d15 = ((((d10 * 2.0d) - 1.0d) * ((double) i)) / (1.0d - d10)) + this.f13822w;
                                int iRound4 = (int) Math.round(d15);
                                this.f13817r = iRound4;
                                this.f13822w = d15 - ((double) iRound4);
                                i11 = i;
                            }
                            int i37 = i + i11;
                            short[] sArrC2 = c(this.f13811l, this.f13812m, i37);
                            this.f13811l = sArrC2;
                            System.arraycopy(sArr4, i36 * i18, sArrC2, this.f13812m * i18, i * i18);
                            e(i11, this.f13803b, this.f13811l, this.f13812m + i, sArr4, i36 + i, sArr4, i36);
                            this.f13812m += i37;
                            i22 = i36 + i11;
                        }
                    }
                    if (i22 + i10 > i20) {
                        break;
                    }
                    i19 = 0;
                    i21 = i10;
                    i17 = 1;
                    f12 = f;
                    d11 = d10;
                }
                int i38 = this.f13810k - i22;
                short[] sArr5 = this.f13809j;
                System.arraycopy(sArr5, i22 * i18, sArr5, 0, i38 * i18);
                this.f13810k = i38;
            }
            if (f != 1.0f || this.f13812m == i15) {
            }
            long j10 = (long) (i16 / f);
            long j11 = i16;
            while (j10 != 0 && j11 != 0 && j10 % 2 == 0 && j11 % 2 == 0) {
                j10 /= 2;
                j11 /= 2;
            }
            int i39 = this.f13812m - i15;
            short[] sArrC3 = c(this.f13813n, this.f13814o, i39);
            this.f13813n = sArrC3;
            System.arraycopy(this.f13811l, i15 * i18, sArrC3, this.f13814o * i18, i39 * i18);
            this.f13812m = i15;
            this.f13814o += i39;
            int i40 = 0;
            while (true) {
                i12 = this.f13814o;
                i13 = i12 - 1;
                if (i40 >= i13) {
                    break;
                }
                while (true) {
                    i14 = this.f13815p + 1;
                    j4 = i14;
                    long j12 = j4 * j10;
                    j7 = this.f13816q;
                    if (j12 <= j7 * j11) {
                        break;
                    }
                    this.f13811l = c(this.f13811l, this.f13812m, 1);
                    int i41 = 0;
                    while (i41 < i18) {
                        short[] sArr6 = this.f13811l;
                        int i42 = (this.f13812m * i18) + i41;
                        short[] sArr7 = this.f13813n;
                        int i43 = (i40 * i18) + i41;
                        short s10 = sArr7[i43];
                        short s11 = sArr7[i43 + i18];
                        long j13 = ((long) this.f13816q) * j11;
                        int i44 = this.f13815p;
                        long j14 = j10;
                        int i45 = i40;
                        long j15 = ((long) (i44 + 1)) * j14;
                        long j16 = j15 - j13;
                        long j17 = j15 - (((long) i44) * j14);
                        sArr6[i42] = (short) ((((j17 - j16) * ((long) s11)) + (((long) s10) * j16)) / j17);
                        i41++;
                        i40 = i45;
                        j10 = j14;
                    }
                    this.f13816q++;
                    this.f13812m++;
                    i40 = i40;
                    j10 = j10;
                }
                long j18 = j10;
                int i46 = i40;
                this.f13815p = i14;
                if (j4 == j11) {
                    this.f13815p = 0;
                    y1.d.g(j7 == j18);
                    this.f13816q = 0;
                }
                i40 = i46 + 1;
                j10 = j18;
            }
            if (i13 == 0) {
                return;
            }
            short[] sArr8 = this.f13813n;
            System.arraycopy(sArr8, i13 * i18, sArr8, 0, (i12 - i13) * i18);
            this.f13814o -= i13;
            return;
        }
        a(this.f13809j, 0, this.f13810k);
        this.f13810k = 0;
        f = f12;
        if (f != 1.0f) {
        }
    }
}
