package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k5 f3152a;

    static {
        if (n6.f3123e) {
            boolean z2 = n6.f3122d;
        }
        f3152a = new k5(9);
    }

    public static int a(String str) {
        int length = str.length();
        int i = 0;
        int i10 = 0;
        while (i10 < length && str.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt < 2048) {
                i11 += (127 - cCharAt) >>> 31;
                i10++;
            } else {
                int length2 = str.length();
                while (i10 < length2) {
                    char cCharAt2 = str.charAt(i10);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i10) < 65536) {
                                throw new q6(i10, length2);
                            }
                            i10++;
                        }
                    }
                    i10++;
                }
                i11 += i;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i11) + 4294967296L));
    }

    public static int b(String str, byte[] bArr, int i, int i10) {
        int i11;
        int i12;
        char cCharAt;
        f3152a.getClass();
        int length = str.length();
        int i13 = i10 + i;
        int i14 = 0;
        while (i14 < length && (i12 = i14 + i) < i13 && (cCharAt = str.charAt(i14)) < 128) {
            bArr[i12] = (byte) cCharAt;
            i14++;
        }
        if (i14 == length) {
            return i + length;
        }
        int i15 = i + i14;
        while (i14 < length) {
            char cCharAt2 = str.charAt(i14);
            if (cCharAt2 < 128 && i15 < i13) {
                bArr[i15] = (byte) cCharAt2;
                i15++;
            } else if (cCharAt2 < 2048 && i15 <= i13 - 2) {
                int i16 = i15 + 1;
                bArr[i15] = (byte) ((cCharAt2 >>> 6) | 960);
                i15 += 2;
                bArr[i16] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i15 > i13 - 3) {
                    if (i15 > i13 - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i11 = i14 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i11)))) {
                            throw new q6(i14, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i15);
                    }
                    int i17 = i14 + 1;
                    if (i17 != str.length()) {
                        char cCharAt3 = str.charAt(i17);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i15] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i15 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i18 = i15 + 3;
                            bArr[i15 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i15 += 4;
                            bArr[i18] = (byte) ((codePoint & 63) | 128);
                            i14 = i17;
                        } else {
                            i14 = i17;
                        }
                    }
                    throw new q6(i14 - 1, length);
                }
                bArr[i15] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i19 = i15 + 2;
                bArr[i15 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i15 += 3;
                bArr[i19] = (byte) ((cCharAt2 & '?') | 128);
            }
            i14++;
        }
        return i15;
    }

    public static /* synthetic */ int c(byte[] bArr, int i, int i10) {
        byte b10 = bArr[i - 1];
        int i11 = i10 - i;
        if (i11 == 0) {
            if (b10 > -12) {
                return -1;
            }
            return b10;
        }
        if (i11 == 1) {
            byte b11 = bArr[i];
            if (b10 > -12 || b11 > -65) {
                return -1;
            }
            return (b11 << 8) ^ b10;
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        byte b12 = bArr[i];
        byte b13 = bArr[i + 1];
        if (b10 > -12 || b12 > -65 || b13 > -65) {
            return -1;
        }
        return (b13 << 16) ^ ((b12 << 8) ^ b10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(byte[] bArr, int i, int i10) {
        int iC;
        f3152a.getClass();
        while (i < i10 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i10) {
            iC = 0;
        } else {
            while (i < i10) {
                int i11 = i + 1;
                iC = bArr[i];
                if (iC < 0) {
                    if (iC >= -32) {
                        if (iC >= -16) {
                            if (i11 < i10 - 2) {
                                int i12 = i + 2;
                                int i13 = bArr[i11];
                                if (i13 <= -65) {
                                    if ((((i13 + 112) + (iC << 28)) >> 30) == 0) {
                                        int i14 = i + 3;
                                        if (bArr[i12] <= -65) {
                                            i += 4;
                                            if (bArr[i14] > -65) {
                                            }
                                        }
                                    }
                                }
                                iC = -1;
                                break;
                            }
                            iC = c(bArr, i11, i10);
                            break;
                        }
                        if (i11 < i10 - 1) {
                            int i15 = i + 2;
                            char c9 = bArr[i11];
                            if (c9 <= -65 && ((iC != -32 || c9 >= -96) && (iC != -19 || c9 < -96))) {
                                i += 3;
                                if (bArr[i15] > -65) {
                                }
                            }
                            iC = -1;
                            break;
                        }
                        iC = c(bArr, i11, i10);
                        break;
                    }
                    if (i11 >= i10) {
                        break;
                    }
                    if (iC >= -62) {
                        i += 2;
                        if (bArr[i11] > -65) {
                        }
                    }
                    iC = -1;
                    break;
                }
                i = i11;
            }
            iC = 0;
        }
        return iC == 0;
    }
}
