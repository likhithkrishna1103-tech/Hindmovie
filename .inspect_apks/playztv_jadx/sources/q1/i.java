package q1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f10557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f10558e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10560h;
    public final short[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public short[] f10561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short[] f10563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public short[] f10565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10566o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10567p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10568q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10569r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10570s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10571t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10572u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10573v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public double f10574w;

    public i(int i, int i10, float f, float f4, int i11) {
        this.f10554a = i;
        this.f10555b = i10;
        this.f10556c = f;
        this.f10557d = f4;
        this.f10558e = i / i11;
        this.f = i / 400;
        int i12 = i / 65;
        this.f10559g = i12;
        int i13 = i12 * 2;
        this.f10560h = i13;
        this.i = new short[i13];
        this.f10561j = new short[i13 * i10];
        this.f10563l = new short[i13 * i10];
        this.f10565n = new short[i13 * i10];
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
        short[] sArrC = c(this.f10563l, this.f10564m, i10);
        this.f10563l = sArrC;
        int i11 = this.f10555b;
        System.arraycopy(sArr, i * i11, sArrC, this.f10564m * i11, i11 * i10);
        this.f10564m += i10;
    }

    public final void b(short[] sArr, int i, int i10) {
        int i11 = this.f10560h / i10;
        int i12 = this.f10555b;
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
        int i11 = this.f10555b;
        int i12 = length / i11;
        return i + i10 <= i12 ? sArr : Arrays.copyOf(sArr, (((i12 * 3) / 2) + i10) * i11);
    }

    public final int d(short[] sArr, int i, int i10, int i11) {
        int i12 = i * this.f10555b;
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
        this.f10572u = i14 / i15;
        this.f10573v = i16 / i13;
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
        long j5;
        long j8;
        int i15 = this.f10564m;
        float f4 = this.f10556c;
        float f10 = this.f10557d;
        double d11 = f4 / f10;
        float f11 = this.f10558e * f10;
        int i16 = this.f10554a;
        int i17 = 1;
        int i18 = this.f10555b;
        int i19 = 0;
        if (d11 > 1.0000100135803223d || d11 < 0.9999899864196777d) {
            int i20 = this.f10562k;
            int i21 = this.f10560h;
            if (i20 >= i21) {
                int i22 = 0;
                while (true) {
                    int i23 = this.f10569r;
                    if (i23 > 0) {
                        int iMin = Math.min(i21, i23);
                        a(this.f10561j, i22, iMin);
                        this.f10569r -= iMin;
                        i22 += iMin;
                        f = f11;
                        d10 = d11;
                        i10 = i21;
                    } else {
                        short[] sArr = this.f10561j;
                        int i24 = i16 > 4000 ? i16 / 4000 : i17;
                        int i25 = this.f10559g;
                        int i26 = this.f;
                        if (i18 == i17 && i24 == i17) {
                            iD = d(sArr, i22, i26, i25);
                            f = f11;
                            d10 = d11;
                        } else {
                            b(sArr, i22, i24);
                            f = f11;
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
                        int i31 = this.f10572u;
                        int i32 = this.f10573v;
                        if (i31 == 0 || (i = this.f10570s) == 0 || i32 > i31 * 3 || i31 * 2 <= this.f10571t * 3) {
                            i = iD;
                        }
                        this.f10571t = i31;
                        this.f10570s = iD;
                        if (d10 > 1.0d) {
                            short[] sArr3 = this.f10561j;
                            if (d10 >= 2.0d) {
                                i10 = i21;
                                double d12 = (((double) i) / (d10 - 1.0d)) + this.f10574w;
                                iRound = (int) Math.round(d12);
                                this.f10574w = d12 - ((double) iRound);
                            } else {
                                i10 = i21;
                                double d13 = (((2.0d - d10) * ((double) i)) / (d10 - 1.0d)) + this.f10574w;
                                int iRound2 = (int) Math.round(d13);
                                this.f10569r = iRound2;
                                this.f10574w = d13 - ((double) iRound2);
                                iRound = i;
                            }
                            short[] sArrC = c(this.f10563l, this.f10564m, iRound);
                            this.f10563l = sArrC;
                            int i33 = i22 + i;
                            int i34 = i22;
                            int i35 = iRound;
                            e(i35, this.f10555b, sArrC, this.f10564m, sArr3, i34, sArr3, i33);
                            this.f10564m += i35;
                            i22 = i + i35 + i34;
                        } else {
                            i10 = i21;
                            int i36 = i22;
                            short[] sArr4 = this.f10561j;
                            if (d10 < 0.5d) {
                                double d14 = ((((double) i) * d10) / (1.0d - d10)) + this.f10574w;
                                int iRound3 = (int) Math.round(d14);
                                this.f10574w = d14 - ((double) iRound3);
                                i11 = iRound3;
                            } else {
                                double d15 = ((((d10 * 2.0d) - 1.0d) * ((double) i)) / (1.0d - d10)) + this.f10574w;
                                int iRound4 = (int) Math.round(d15);
                                this.f10569r = iRound4;
                                this.f10574w = d15 - ((double) iRound4);
                                i11 = i;
                            }
                            int i37 = i + i11;
                            short[] sArrC2 = c(this.f10563l, this.f10564m, i37);
                            this.f10563l = sArrC2;
                            System.arraycopy(sArr4, i36 * i18, sArrC2, this.f10564m * i18, i * i18);
                            e(i11, this.f10555b, this.f10563l, this.f10564m + i, sArr4, i36 + i, sArr4, i36);
                            this.f10564m += i37;
                            i22 = i36 + i11;
                        }
                    }
                    if (i22 + i10 > i20) {
                        break;
                    }
                    i19 = 0;
                    i21 = i10;
                    i17 = 1;
                    f11 = f;
                    d11 = d10;
                }
                int i38 = this.f10562k - i22;
                short[] sArr5 = this.f10561j;
                System.arraycopy(sArr5, i22 * i18, sArr5, 0, i38 * i18);
                this.f10562k = i38;
            }
            if (f != 1.0f || this.f10564m == i15) {
            }
            long j10 = (long) (i16 / f);
            long j11 = i16;
            while (j10 != 0 && j11 != 0 && j10 % 2 == 0 && j11 % 2 == 0) {
                j10 /= 2;
                j11 /= 2;
            }
            int i39 = this.f10564m - i15;
            short[] sArrC3 = c(this.f10565n, this.f10566o, i39);
            this.f10565n = sArrC3;
            System.arraycopy(this.f10563l, i15 * i18, sArrC3, this.f10566o * i18, i39 * i18);
            this.f10564m = i15;
            this.f10566o += i39;
            int i40 = 0;
            while (true) {
                i12 = this.f10566o;
                i13 = i12 - 1;
                if (i40 >= i13) {
                    break;
                }
                while (true) {
                    i14 = this.f10567p + 1;
                    j5 = i14;
                    long j12 = j5 * j10;
                    j8 = this.f10568q;
                    if (j12 <= j8 * j11) {
                        break;
                    }
                    this.f10563l = c(this.f10563l, this.f10564m, 1);
                    int i41 = 0;
                    while (i41 < i18) {
                        short[] sArr6 = this.f10563l;
                        int i42 = (this.f10564m * i18) + i41;
                        short[] sArr7 = this.f10565n;
                        int i43 = (i40 * i18) + i41;
                        short s3 = sArr7[i43];
                        short s10 = sArr7[i43 + i18];
                        long j13 = ((long) this.f10568q) * j11;
                        int i44 = this.f10567p;
                        long j14 = j10;
                        int i45 = i40;
                        long j15 = ((long) (i44 + 1)) * j14;
                        long j16 = j15 - j13;
                        long j17 = j15 - (((long) i44) * j14);
                        sArr6[i42] = (short) ((((j17 - j16) * ((long) s10)) + (((long) s3) * j16)) / j17);
                        i41++;
                        i40 = i45;
                        j10 = j14;
                    }
                    this.f10568q++;
                    this.f10564m++;
                    i40 = i40;
                    j10 = j10;
                }
                long j18 = j10;
                int i46 = i40;
                this.f10567p = i14;
                if (j5 == j11) {
                    this.f10567p = 0;
                    s1.d.g(j8 == j18);
                    this.f10568q = 0;
                }
                i40 = i46 + 1;
                j10 = j18;
            }
            if (i13 == 0) {
                return;
            }
            short[] sArr8 = this.f10565n;
            System.arraycopy(sArr8, i13 * i18, sArr8, 0, (i12 - i13) * i18);
            this.f10566o -= i13;
            return;
        }
        a(this.f10561j, 0, this.f10562k);
        this.f10562k = 0;
        f = f11;
        if (f != 1.0f) {
        }
    }
}
