package z1;

import a3.k0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f15122a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f15123b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f15124c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int[] f15125d = new int[10];

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int b(byte[] bArr, int i, int i10, boolean[] zArr) {
        int i11 = i10 - i;
        y1.d.g(i11 >= 0);
        if (i11 == 0) {
            return i10;
        }
        if (zArr[0]) {
            a(zArr);
            return i - 3;
        }
        if (i11 > 1 && zArr[1] && bArr[i] == 1) {
            a(zArr);
            return i - 2;
        }
        if (i11 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            a(zArr);
            return i - 1;
        }
        int i12 = i10 - 1;
        int i13 = i + 2;
        while (i13 < i12) {
            byte b8 = bArr[i13];
            if ((b8 & 254) == 0) {
                int i14 = i13 - 2;
                if (bArr[i14] == 0 && bArr[i13 - 1] == 0 && b8 == 1) {
                    a(zArr);
                    return i14;
                }
                i13 -= 2;
            }
            i13 += 3;
        }
        zArr[0] = i11 <= 2 ? !(i11 != 2 ? !(zArr[1] && bArr[i12] == 1) : !(zArr[2] && bArr[i10 + (-2)] == 0 && bArr[i12] == 1)) : bArr[i10 + (-3)] == 0 && bArr[i10 + (-2)] == 0 && bArr[i12] == 1;
        zArr[1] = i11 <= 1 ? zArr[2] && bArr[i12] == 0 : bArr[i10 + (-2)] == 0 && bArr[i12] == 0;
        zArr[2] = bArr[i12] == 0;
        return i10;
    }

    public static boolean c(byte[] bArr, int i, v1.p pVar) {
        int i10;
        if (Objects.equals(pVar.f12946n, "video/avc")) {
            byte b8 = bArr[4];
            if (((b8 & 96) >> 5) == 0 && ((i10 = b8 & 31) == 1 || i10 == 9 || i10 == 14)) {
                return false;
            }
        } else if (Objects.equals(pVar.f12946n, "video/hevc")) {
            a3.d dVarE = e(new k0(bArr, 4, i + 4));
            int i11 = dVarE.f154a;
            if (i11 == 35) {
                return false;
            }
            if (i11 <= 14 && i11 % 2 == 0 && dVarE.f156c == pVar.E - 1) {
                return false;
            }
        }
        return true;
    }

    public static int d(v1.p pVar) {
        if (Objects.equals(pVar.f12946n, "video/avc")) {
            return 1;
        }
        return (Objects.equals(pVar.f12946n, "video/hevc") || m0.c(pVar.f12943k, "video/hevc") != null) ? 2 : 0;
    }

    public static a3.d e(k0 k0Var) {
        k0Var.s();
        return new a3.d(k0Var.i(6), k0Var.i(6), k0Var.i(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z1.h f(a3.k0 r19, boolean r20, int r21, z1.h r22) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = 6
            int[] r4 = new int[r3]
            r5 = 2
            r6 = 8
            r7 = 0
            if (r20 == 0) goto L42
            int r2 = r0.i(r5)
            boolean r8 = r0.h()
            r9 = 5
            int r9 = r0.i(r9)
            r10 = r7
            r11 = r10
        L1e:
            r12 = 32
            if (r10 >= r12) goto L2e
            boolean r12 = r0.h()
            if (r12 == 0) goto L2b
            r12 = 1
            int r12 = r12 << r10
            r11 = r11 | r12
        L2b:
            int r10 = r10 + 1
            goto L1e
        L2e:
            r10 = r7
        L2f:
            if (r10 >= r3) goto L3a
            int r12 = r0.i(r6)
            r4[r10] = r12
            int r10 = r10 + 1
            goto L2f
        L3a:
            r13 = r2
        L3b:
            r17 = r4
            r14 = r8
            r15 = r9
            r16 = r11
            goto L57
        L42:
            if (r2 == 0) goto L50
            int r3 = r2.f15077a
            boolean r8 = r2.f15078b
            int r9 = r2.f15079c
            int r11 = r2.f15080d
            int[] r4 = r2.f15081e
            r13 = r3
            goto L3b
        L50:
            r17 = r4
            r13 = r7
            r14 = r13
            r15 = r14
            r16 = r15
        L57:
            int r18 = r0.i(r6)
            r2 = r7
        L5c:
            if (r7 >= r1) goto L71
            boolean r3 = r0.h()
            if (r3 == 0) goto L66
            int r2 = r2 + 88
        L66:
            boolean r3 = r0.h()
            if (r3 == 0) goto L6e
            int r2 = r2 + 8
        L6e:
            int r7 = r7 + 1
            goto L5c
        L71:
            r0.t(r2)
            if (r1 <= 0) goto L7b
            int r6 = r6 - r1
            int r6 = r6 * r5
            r0.t(r6)
        L7b:
            z1.h r12 = new z1.h
            r12.<init>(r13, r14, r15, r16, r17, r18)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.o.f(a3.k0, boolean, int, z1.h):z1.h");
    }

    public static q6.l g(byte[] bArr, int i, int i10) {
        byte b8;
        int i11 = i + 2;
        do {
            i10--;
            b8 = bArr[i10];
            if (b8 != 0) {
                break;
            }
        } while (i10 > i11);
        if (b8 == 0 || i10 <= i11) {
            return null;
        }
        k0 k0Var = new k0(bArr, i11, i10 + 1);
        while (k0Var.d(16)) {
            int i12 = k0Var.i(8);
            int i13 = 0;
            while (i12 == 255) {
                i13 += 255;
                i12 = k0Var.i(8);
            }
            int i14 = i13 + i12;
            int i15 = k0Var.i(8);
            int i16 = 0;
            while (i15 == 255) {
                i16 += 255;
                i15 = k0Var.i(8);
            }
            int i17 = i16 + i15;
            if (i17 == 0 || !k0Var.d(i17)) {
                return null;
            }
            if (i14 == 176) {
                int iM = k0Var.m();
                boolean zH = k0Var.h();
                int iM2 = zH ? k0Var.m() : 0;
                int iM3 = k0Var.m();
                int iM4 = -1;
                for (int i18 = 0; i18 <= iM3; i18++) {
                    iM4 = k0Var.m();
                    k0Var.m();
                    int i19 = k0Var.i(6);
                    if (i19 == 63) {
                        return null;
                    }
                    k0Var.i(i19 == 0 ? Math.max(0, iM - 30) : Math.max(0, (i19 + iM) - 31));
                    if (zH) {
                        int i20 = k0Var.i(6);
                        if (i20 == 63) {
                            return null;
                        }
                        k0Var.i(i20 == 0 ? Math.max(0, iM2 - 30) : Math.max(0, (i20 + iM2) - 31));
                    }
                    if (k0Var.h()) {
                        k0Var.t(10);
                    }
                }
                return new q6.l(iM4);
            }
            k0Var.t(i17 * 8);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z1.k h(byte[] r32, int r33, int r34, b6.f r35) {
        /*
            Method dump skipped, instruction units count: 999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.o.h(byte[], int, int, b6.f):z1.k");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b6.f i(byte[] r40, int r41, int r42) {
        /*
            Method dump skipped, instruction units count: 2160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.o.i(byte[], int, int):b6.f");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z1.n j(byte[] r30, int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.o.j(byte[], int, int):z1.n");
    }

    public static void k(k0 k0Var) {
        int iM = k0Var.m() + 1;
        k0Var.t(8);
        for (int i = 0; i < iM; i++) {
            k0Var.m();
            k0Var.m();
            k0Var.s();
        }
        k0Var.t(20);
    }

    public static ArrayList l(ByteBuffer byteBuffer) {
        int iRemaining;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (byteBufferAsReadOnlyBuffer.hasRemaining()) {
            byte b8 = byteBufferAsReadOnlyBuffer.get();
            int i = (b8 >> 3) & 15;
            if (((b8 >> 2) & 1) != 0) {
                byteBufferAsReadOnlyBuffer.get();
            }
            if (((b8 >> 1) & 1) != 0) {
                iRemaining = 0;
                for (int i10 = 0; i10 < 8; i10++) {
                    byte b10 = byteBufferAsReadOnlyBuffer.get();
                    iRemaining |= (b10 & 127) << (i10 * 7);
                    if ((b10 & 128) == 0) {
                        break;
                    }
                }
            } else {
                iRemaining = byteBufferAsReadOnlyBuffer.remaining();
            }
            ByteBuffer byteBufferDuplicate = byteBufferAsReadOnlyBuffer.duplicate();
            byteBufferDuplicate.limit(byteBufferAsReadOnlyBuffer.position() + iRemaining);
            arrayList.add(new q(i, byteBufferDuplicate));
            byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.position() + iRemaining);
        }
        return arrayList;
    }

    public static int m(int i, byte[] bArr) {
        int i10;
        synchronized (f15124c) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i) {
                while (true) {
                    if (i11 >= i - 2) {
                        i11 = i;
                        break;
                    }
                    try {
                        if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                            break;
                        }
                        i11++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i11 < i) {
                    int[] iArr = f15125d;
                    if (iArr.length <= i12) {
                        f15125d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f15125d[i12] = i11;
                    i11 += 3;
                    i12++;
                }
            }
            i10 = i - i12;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < i12; i15++) {
                int i16 = f15125d[i15] - i14;
                System.arraycopy(bArr, i14, bArr, i13, i16);
                int i17 = i13 + i16;
                int i18 = i17 + 1;
                bArr[i17] = 0;
                i13 = i17 + 2;
                bArr[i18] = 0;
                i14 += i16 + 3;
            }
            System.arraycopy(bArr, i14, bArr, i13, i10 - i13);
        }
        return i10;
    }
}
