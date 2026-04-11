package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends ab.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f728b;

    public /* synthetic */ i1(int i) {
        this.f728b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    @Override // ab.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(byte[] r11, int r12, int r13) throws androidx.datastore.preferences.protobuf.z {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i1.f(byte[], int, int):java.lang.String");
    }

    @Override // ab.b
    public final int i(String str, byte[] bArr, int i, int i10) {
        int i11;
        int i12;
        char cCharAt;
        long j4;
        long j7;
        long j10;
        int i13;
        char cCharAt2;
        switch (this.f728b) {
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
                                    throw new j1(i15, length);
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
                            throw new j1(i15 - 1, length);
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
                    j4 = 1;
                    if (i21 < length2 && (cCharAt2 = str.charAt(i21)) < 128) {
                        h1.j(bArr, j11, (byte) cCharAt2);
                        i21++;
                        j11 = 1 + j11;
                    }
                }
                if (i21 != length2) {
                    while (i21 < length2) {
                        char cCharAt5 = str.charAt(i21);
                        if (cCharAt5 < 128 && j11 < j12) {
                            h1.j(bArr, j11, (byte) cCharAt5);
                            j10 = j12;
                            j7 = j4;
                            j11 += j4;
                        } else if (cCharAt5 >= 2048 || j11 > j12 - 2) {
                            j7 = j4;
                            if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j11 > j12 - 3) {
                                j10 = j12;
                                if (j11 > j10 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i13 = i21 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i13)))) {
                                        throw new j1(i21, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j11);
                                }
                                int i22 = i21 + 1;
                                if (i22 != length2) {
                                    char cCharAt6 = str.charAt(i22);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        h1.j(bArr, j11, (byte) ((codePoint2 >>> 18) | 240));
                                        h1.j(bArr, j11 + j7, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j13 = j11 + 3;
                                        h1.j(bArr, j11 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j11 += 4;
                                        h1.j(bArr, j13, (byte) ((codePoint2 & 63) | 128));
                                        i21 = i22;
                                    } else {
                                        i21 = i22;
                                    }
                                }
                                throw new j1(i21 - 1, length2);
                            }
                            h1.j(bArr, j11, (byte) ((cCharAt5 >>> '\f') | 480));
                            j10 = j12;
                            long j14 = j11 + 2;
                            h1.j(bArr, j11 + j7, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j11 += 3;
                            h1.j(bArr, j14, (byte) ((cCharAt5 & '?') | 128));
                        } else {
                            j7 = j4;
                            long j15 = j11 + j7;
                            h1.j(bArr, j11, (byte) ((cCharAt5 >>> 6) | 960));
                            j11 += 2;
                            h1.j(bArr, j15, (byte) ((cCharAt5 & '?') | 128));
                            j10 = j12;
                        }
                        i21++;
                        j4 = j7;
                        j12 = j10;
                    }
                }
                return (int) j11;
        }
    }
}
