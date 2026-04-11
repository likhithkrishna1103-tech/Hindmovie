package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t1 extends r0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1137c;

    public static int m(long j5, byte[] bArr, int i, int i10) {
        if (i10 == 0) {
            r0 r0Var = v1.f1143a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i10 == 1) {
            return v1.c(i, s1.f(j5, bArr));
        }
        if (i10 == 2) {
            return v1.d(i, s1.f(j5, bArr), s1.f(j5 + 1, bArr));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    @Override // androidx.datastore.preferences.protobuf.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(byte[] r17, int r18, int r19) throws androidx.datastore.preferences.protobuf.b0 {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.t1.e(byte[], int, int):java.lang.String");
    }

    @Override // androidx.datastore.preferences.protobuf.r0
    public final int f(String str, byte[] bArr, int i, int i10) {
        int i11;
        int i12;
        char cCharAt;
        long j5;
        long j8;
        long j10;
        int i13;
        char cCharAt2;
        switch (this.f1137c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int length = str.length();
                int i14 = i10 + i;
                int i15 = 0;
                while (i15 < length && (i12 = i15 + i) < i14 && (cCharAt = str.charAt(i15)) < 128) {
                    bArr[i12] = (byte) cCharAt;
                    i15++;
                }
                if (i15 == length) {
                    return i + length;
                }
                int i16 = i + i15;
                while (i15 < length) {
                    char cCharAt3 = str.charAt(i15);
                    if (cCharAt3 < 128 && i16 < i14) {
                        bArr[i16] = (byte) cCharAt3;
                        i16++;
                    } else if (cCharAt3 < 2048 && i16 <= i14 - 2) {
                        int i17 = i16 + 1;
                        bArr[i16] = (byte) ((cCharAt3 >>> 6) | 960);
                        i16 += 2;
                        bArr[i17] = (byte) ((cCharAt3 & '?') | 128);
                    } else {
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i16 > i14 - 3) {
                            if (i16 > i14 - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i11 = i15 + 1) == str.length() || !Character.isSurrogatePair(cCharAt3, str.charAt(i11)))) {
                                    throw new u1(i15, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt3 + " at index " + i16);
                            }
                            int i18 = i15 + 1;
                            if (i18 != str.length()) {
                                char cCharAt4 = str.charAt(i18);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i19 = i16 + 3;
                                    bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i16 += 4;
                                    bArr[i19] = (byte) ((codePoint & 63) | 128);
                                    i15 = i18;
                                } else {
                                    i15 = i18;
                                }
                            }
                            throw new u1(i15 - 1, length);
                        }
                        bArr[i16] = (byte) ((cCharAt3 >>> '\f') | 480);
                        int i20 = i16 + 2;
                        bArr[i16 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                        i16 += 3;
                        bArr[i20] = (byte) ((cCharAt3 & '?') | 128);
                    }
                    i15++;
                }
                return i16;
            default:
                long j11 = i;
                long j12 = ((long) i10) + j11;
                int length2 = str.length();
                if (length2 > i10 || bArr.length - i10 < i) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i + i10));
                }
                int i21 = 0;
                while (true) {
                    j5 = 1;
                    if (i21 < length2 && (cCharAt2 = str.charAt(i21)) < 128) {
                        s1.j(bArr, j11, (byte) cCharAt2);
                        i21++;
                        j11 = 1 + j11;
                    }
                }
                if (i21 != length2) {
                    while (i21 < length2) {
                        char cCharAt5 = str.charAt(i21);
                        if (cCharAt5 < 128 && j11 < j12) {
                            s1.j(bArr, j11, (byte) cCharAt5);
                            j10 = j12;
                            j8 = j5;
                            j11 += j5;
                        } else if (cCharAt5 >= 2048 || j11 > j12 - 2) {
                            j8 = j5;
                            if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j11 > j12 - 3) {
                                j10 = j12;
                                if (j11 > j10 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i13 = i21 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i13)))) {
                                        throw new u1(i21, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j11);
                                }
                                int i22 = i21 + 1;
                                if (i22 != length2) {
                                    char cCharAt6 = str.charAt(i22);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        s1.j(bArr, j11, (byte) ((codePoint2 >>> 18) | 240));
                                        s1.j(bArr, j11 + j8, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j13 = j11 + 3;
                                        s1.j(bArr, j11 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j11 += 4;
                                        s1.j(bArr, j13, (byte) ((codePoint2 & 63) | 128));
                                        i21 = i22;
                                    } else {
                                        i21 = i22;
                                    }
                                }
                                throw new u1(i21 - 1, length2);
                            }
                            s1.j(bArr, j11, (byte) ((cCharAt5 >>> '\f') | 480));
                            j10 = j12;
                            long j14 = j11 + 2;
                            s1.j(bArr, j11 + j8, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j11 += 3;
                            s1.j(bArr, j14, (byte) ((cCharAt5 & '?') | 128));
                        } else {
                            j8 = j5;
                            long j15 = j11 + j8;
                            s1.j(bArr, j11, (byte) ((cCharAt5 >>> 6) | 960));
                            j11 += 2;
                            s1.j(bArr, j15, (byte) ((cCharAt5 & '?') | 128));
                            j10 = j12;
                        }
                        i21++;
                        j5 = j8;
                        j12 = j10;
                    }
                }
                return (int) j11;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r0
    public final int i(byte[] bArr, int i, int i10) {
        int i11;
        long j5;
        byte b10;
        int i12;
        int i13 = i;
        switch (this.f1137c) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                while (i13 < i10 && bArr[i13] >= 0) {
                    i13++;
                }
                if (i13 < i10) {
                    while (i13 < i10) {
                        int i14 = i13 + 1;
                        byte b11 = bArr[i13];
                        if (b11 >= 0) {
                            i13 = i14;
                        } else if (b11 < -32) {
                            if (i14 >= i10) {
                                return b11;
                            }
                            if (b11 < -62) {
                                return -1;
                            }
                            i13 += 2;
                            if (bArr[i14] > -65) {
                                return -1;
                            }
                        } else if (b11 < -16) {
                            if (i14 >= i10 - 1) {
                                return v1.a(bArr, i14, i10);
                            }
                            int i15 = i13 + 2;
                            byte b12 = bArr[i14];
                            if (b12 > -65) {
                                return -1;
                            }
                            if (b11 == -32 && b12 < -96) {
                                return -1;
                            }
                            if (b11 == -19 && b12 >= -96) {
                                return -1;
                            }
                            i13 += 3;
                            if (bArr[i15] > -65) {
                                return -1;
                            }
                        } else {
                            if (i14 >= i10 - 2) {
                                return v1.a(bArr, i14, i10);
                            }
                            int i16 = i13 + 2;
                            byte b13 = bArr[i14];
                            if (b13 > -65 || (((b13 + 112) + (b11 << 28)) >> 30) != 0) {
                                return -1;
                            }
                            int i17 = i13 + 3;
                            if (bArr[i16] > -65) {
                                return -1;
                            }
                            i13 += 4;
                            if (bArr[i17] > -65) {
                                return -1;
                            }
                        }
                    }
                }
                return 0;
            default:
                int i18 = 2;
                if ((i13 | i10 | (bArr.length - i10)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i13), Integer.valueOf(i10)));
                }
                byte b14 = 0;
                long j8 = i13;
                int i19 = (int) (((long) i10) - j8);
                if (i19 < 16) {
                    i11 = 0;
                    j5 = 1;
                } else {
                    i11 = 0;
                    long j10 = j8;
                    j5 = 1;
                    while (true) {
                        if (i11 < i19) {
                            long j11 = j10 + 1;
                            if (s1.f(j10, bArr) >= 0) {
                                i11++;
                                j10 = j11;
                            }
                        } else {
                            i11 = i19;
                        }
                    }
                }
                int i20 = i19 - i11;
                long j12 = j8 + ((long) i11);
                while (true) {
                    byte bF = b14;
                    while (true) {
                        if (i20 > 0) {
                            long j13 = j12 + j5;
                            bF = s1.f(j12, bArr);
                            if (bF >= 0) {
                                i20--;
                                j12 = j13;
                            } else {
                                j12 = j13;
                            }
                        }
                    }
                    if (i20 == 0) {
                        return b14;
                    }
                    int i21 = i20 - 1;
                    if (bF < -32) {
                        if (i21 == 0) {
                            return bF;
                        }
                        i20 -= 2;
                        if (bF < -62) {
                            return -1;
                        }
                        long j14 = j12 + j5;
                        if (s1.f(j12, bArr) > -65) {
                            return -1;
                        }
                        b10 = b14;
                        i12 = i18;
                        j12 = j14;
                    } else if (bF >= -16) {
                        b10 = b14;
                        i12 = i18;
                        if (i21 < 3) {
                            return m(j12, bArr, bF, i21);
                        }
                        i20 -= 4;
                        long j15 = j12 + j5;
                        byte bF2 = s1.f(j12, bArr);
                        if (bF2 > -65 || (((bF2 + 112) + (bF << 28)) >> 30) != 0) {
                            return -1;
                        }
                        long j16 = j12 + 2;
                        if (s1.f(j15, bArr) > -65) {
                            return -1;
                        }
                        j12 += 3;
                        if (s1.f(j16, bArr) > -65) {
                            return -1;
                        }
                    } else {
                        if (i21 < i18) {
                            return m(j12, bArr, bF, i21);
                        }
                        i20 -= 3;
                        i12 = i18;
                        long j17 = j12 + j5;
                        byte bF3 = s1.f(j12, bArr);
                        if (bF3 > -65) {
                            return -1;
                        }
                        if (bF == -32 && bF3 < -96) {
                            return -1;
                        }
                        b10 = b14;
                        if (bF == -19 && bF3 >= -96) {
                            return -1;
                        }
                        j12 += 2;
                        if (s1.f(j17, bArr) > -65) {
                            return -1;
                        }
                    }
                    i18 = i12;
                    b14 = b10;
                }
                break;
        }
    }
}
