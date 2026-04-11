package o3;

import a3.k0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import ua.f0;
import ua.i0;
import ua.z0;
import v1.l0;
import v1.m0;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends u8.a {
    public static final nc.l f = new nc.l(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nc.l f9465e;

    public h(nc.l lVar) {
        this.f9465e = lVar;
    }

    public static a U(t tVar, int i, int i10) {
        int iM0;
        String strConcat;
        int iX = tVar.x();
        Charset charsetJ0 = j0(iX);
        int i11 = i - 1;
        byte[] bArr = new byte[i11];
        tVar.h(bArr, 0, i11);
        if (i10 == 2) {
            strConcat = "image/" + android.support.v4.media.session.b.O(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(strConcat)) {
                strConcat = "image/jpeg";
            }
            iM0 = 2;
        } else {
            iM0 = m0(0, bArr);
            String strO = android.support.v4.media.session.b.O(new String(bArr, 0, iM0, StandardCharsets.ISO_8859_1));
            strConcat = strO.indexOf(47) == -1 ? "image/".concat(strO) : strO;
        }
        int i12 = bArr[iM0 + 1] & 255;
        int i13 = iM0 + 2;
        int iL0 = l0(bArr, i13, iX);
        String str = new String(bArr, i13, iL0 - i13, charsetJ0);
        int iI0 = i0(iX) + iL0;
        return new a(strConcat, str, i12, i11 <= iI0 ? a0.f14553c : Arrays.copyOfRange(bArr, iI0, i11));
    }

    public static c V(t tVar, int i, int i10, boolean z10, int i11, nc.l lVar) throws Throwable {
        int i12 = tVar.f14610b;
        int iM0 = m0(i12, tVar.f14609a);
        String str = new String(tVar.f14609a, i12, iM0 - i12, StandardCharsets.ISO_8859_1);
        tVar.J(iM0 + 1);
        int iJ = tVar.j();
        int iJ2 = tVar.j();
        long jZ = tVar.z();
        if (jZ == 4294967295L) {
            jZ = -1;
        }
        long jZ2 = tVar.z();
        long j4 = jZ2 == 4294967295L ? -1L : jZ2;
        ArrayList arrayList = new ArrayList();
        int i13 = i12 + i;
        while (tVar.f14610b < i13) {
            i iVarY = Y(i10, tVar, z10, i11, lVar);
            if (iVarY != null) {
                arrayList.add(iVarY);
            }
        }
        return new c(str, iJ, iJ2, jZ, j4, (i[]) arrayList.toArray(new i[0]));
    }

    public static d W(t tVar, int i, int i10, boolean z10, int i11, nc.l lVar) throws Throwable {
        int i12 = tVar.f14610b;
        int iM0 = m0(i12, tVar.f14609a);
        String str = new String(tVar.f14609a, i12, iM0 - i12, StandardCharsets.ISO_8859_1);
        tVar.J(iM0 + 1);
        int iX = tVar.x();
        boolean z11 = (iX & 2) != 0;
        boolean z12 = (iX & 1) != 0;
        int iX2 = tVar.x();
        String[] strArr = new String[iX2];
        for (int i13 = 0; i13 < iX2; i13++) {
            int i14 = tVar.f14610b;
            int iM02 = m0(i14, tVar.f14609a);
            strArr[i13] = new String(tVar.f14609a, i14, iM02 - i14, StandardCharsets.ISO_8859_1);
            tVar.J(iM02 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = i12 + i;
        while (tVar.f14610b < i15) {
            i iVarY = Y(i10, tVar, z10, i11, lVar);
            if (iVarY != null) {
                arrayList.add(iVarY);
            }
        }
        return new d(str, z11, z12, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    public static e X(int i, t tVar) {
        if (i < 4) {
            return null;
        }
        int iX = tVar.x();
        Charset charsetJ0 = j0(iX);
        byte[] bArr = new byte[3];
        tVar.h(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i10 = i - 4;
        byte[] bArr2 = new byte[i10];
        tVar.h(bArr2, 0, i10);
        int iL0 = l0(bArr2, 0, iX);
        String str2 = new String(bArr2, 0, iL0, charsetJ0);
        int iI0 = i0(iX) + iL0;
        return new e(str, str2, c0(bArr2, iI0, l0(bArr2, iI0, iX), charsetJ0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x020c A[Catch: all -> 0x012c, Exception -> 0x012f, OutOfMemoryError -> 0x0132, TRY_LEAVE, TryCatch #3 {Exception -> 0x012f, OutOfMemoryError -> 0x0132, all -> 0x012c, blocks: (B:107:0x0126, B:115:0x0137, B:122:0x014d, B:124:0x0155, B:132:0x016f, B:141:0x0187, B:152:0x01a2, B:159:0x01b4, B:182:0x01f2, B:190:0x0207, B:191:0x020c), top: B:205:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x022e  */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static o3.i Y(int r19, y1.t r20, boolean r21, int r22, nc.l r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.h.Y(int, y1.t, boolean, int, nc.l):o3.i");
    }

    public static f Z(int i, t tVar) {
        int iX = tVar.x();
        Charset charsetJ0 = j0(iX);
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        tVar.h(bArr, 0, i10);
        int iM0 = m0(0, bArr);
        String strP = m0.p(new String(bArr, 0, iM0, StandardCharsets.ISO_8859_1));
        int i11 = iM0 + 1;
        int iL0 = l0(bArr, i11, iX);
        String strC0 = c0(bArr, i11, iL0, charsetJ0);
        int iI0 = i0(iX) + iL0;
        int iL02 = l0(bArr, iI0, iX);
        String strC02 = c0(bArr, iI0, iL02, charsetJ0);
        int iI02 = i0(iX) + iL02;
        return new f(strP, strC0, strC02, i10 <= iI02 ? a0.f14553c : Arrays.copyOfRange(bArr, iI02, i10));
    }

    public static l a0(int i, t tVar) {
        int iD = tVar.D();
        int iA = tVar.A();
        int iA2 = tVar.A();
        int iX = tVar.x();
        int iX2 = tVar.x();
        k0 k0Var = new k0();
        k0Var.p(tVar);
        int i10 = ((i - 10) * 8) / (iX + iX2);
        int[] iArr = new int[i10];
        int[] iArr2 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = k0Var.i(iX);
            int i13 = k0Var.i(iX2);
            iArr[i11] = i12;
            iArr2[i11] = i13;
        }
        return new l(iD, iA, iA2, iArr, iArr2);
    }

    public static m b0(int i, t tVar) {
        byte[] bArr = new byte[i];
        tVar.h(bArr, 0, i);
        int iM0 = m0(0, bArr);
        String str = new String(bArr, 0, iM0, StandardCharsets.ISO_8859_1);
        int i10 = iM0 + 1;
        return new m(str, i <= i10 ? a0.f14553c : Arrays.copyOfRange(bArr, i10, i));
    }

    public static String c0(byte[] bArr, int i, int i10, Charset charset) {
        return (i10 <= i || i10 > bArr.length) ? "" : new String(bArr, i, i10 - i, charset);
    }

    public static n d0(int i, String str, t tVar) {
        if (i < 1) {
            return null;
        }
        int iX = tVar.x();
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        tVar.h(bArr, 0, i10);
        return new n(str, null, e0(bArr, iX, 0));
    }

    public static z0 e0(byte[] bArr, int i, int i10) {
        if (i10 >= bArr.length) {
            return i0.o("");
        }
        f0 f0VarJ = i0.j();
        int iL0 = l0(bArr, i10, i);
        while (i10 < iL0) {
            f0VarJ.a(new String(bArr, i10, iL0 - i10, j0(i)));
            i10 = i0(i) + iL0;
            iL0 = l0(bArr, i10, i);
        }
        z0 z0VarG = f0VarJ.g();
        return z0VarG.isEmpty() ? i0.o("") : z0VarG;
    }

    public static n f0(int i, t tVar) {
        if (i < 1) {
            return null;
        }
        int iX = tVar.x();
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        tVar.h(bArr, 0, i10);
        int iL0 = l0(bArr, 0, iX);
        return new n("TXXX", new String(bArr, 0, iL0, j0(iX)), e0(bArr, iX, i0(iX) + iL0));
    }

    public static o g0(int i, String str, t tVar) {
        byte[] bArr = new byte[i];
        tVar.h(bArr, 0, i);
        return new o(str, null, new String(bArr, 0, m0(0, bArr), StandardCharsets.ISO_8859_1));
    }

    public static o h0(int i, t tVar) {
        if (i < 1) {
            return null;
        }
        int iX = tVar.x();
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        tVar.h(bArr, 0, i10);
        int iL0 = l0(bArr, 0, iX);
        String str = new String(bArr, 0, iL0, j0(iX));
        int iI0 = i0(iX) + iL0;
        return new o("WXXX", str, c0(bArr, iI0, m0(iI0, bArr), StandardCharsets.ISO_8859_1));
    }

    public static int i0(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static Charset j0(int i) {
        return i != 1 ? i != 2 ? i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    public static String k0(int i, int i10, int i11, int i12, int i13) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static int l0(byte[] bArr, int i, int i10) {
        int iM0 = m0(i, bArr);
        if (i10 == 0 || i10 == 3) {
            return iM0;
        }
        while (iM0 < bArr.length - 1) {
            if ((iM0 - i) % 2 == 0 && bArr[iM0 + 1] == 0) {
                return iM0;
            }
            iM0 = m0(iM0 + 1, bArr);
        }
        return bArr.length;
    }

    public static int m0(int i, byte[] bArr) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int n0(int i, t tVar) {
        byte[] bArr = tVar.f14609a;
        int i10 = tVar.f14610b;
        int i11 = i10;
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= i10 + i) {
                return i;
            }
            if ((bArr[i11] & 255) == 255 && bArr[i12] == 0) {
                System.arraycopy(bArr, i11 + 2, bArr, i12, (i - (i11 - i10)) - 2);
                i--;
            }
            i11 = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007a A[PHI: r3
      0x007a: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0087, B:33:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean o0(y1.t r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f14610b
        L6:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L23
            int r7 = r1.j()     // Catch: java.lang.Throwable -> L20
            long r8 = r1.z()     // Catch: java.lang.Throwable -> L20
            int r10 = r1.D()     // Catch: java.lang.Throwable -> L20
            goto L2d
        L20:
            r0 = move-exception
            goto Lb0
        L23:
            int r7 = r1.A()     // Catch: java.lang.Throwable -> L20
            int r8 = r1.A()     // Catch: java.lang.Throwable -> L20
            long r8 = (long) r8
            r10 = r6
        L2d:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 != 0) goto L3b
            r1.J(r2)
            return r4
        L3b:
            r7 = 4
            if (r0 != r7) goto L6c
            if (r21 != 0) goto L6c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4c
            r1.J(r2)
            return r6
        L4c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6c:
            if (r0 != r7) goto L7c
            r3 = r10 & 64
            if (r3 == 0) goto L74
            r3 = r4
            goto L75
        L74:
            r3 = r6
        L75:
            r7 = r10 & 1
            if (r7 == 0) goto L7a
            goto L8c
        L7a:
            r4 = r6
            goto L8c
        L7c:
            if (r0 != r3) goto L8a
            r3 = r10 & 32
            if (r3 == 0) goto L84
            r3 = r4
            goto L85
        L84:
            r3 = r6
        L85:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L7a
            goto L8c
        L8a:
            r3 = r6
            r4 = r3
        L8c:
            if (r4 == 0) goto L90
            int r3 = r3 + 4
        L90:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L99
            r1.J(r2)
            return r6
        L99:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La6
            r1.J(r2)
            return r6
        La6:
            int r3 = (int) r8
            r1.K(r3)     // Catch: java.lang.Throwable -> L20
            goto L6
        Lac:
            r1.J(r2)
            return r4
        Lb0:
            r1.J(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.h.o0(y1.t, int, int, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v1.l0 T(int r13, byte[] r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.h.T(int, byte[]):v1.l0");
    }

    @Override // u8.a
    public final l0 p(j3.a aVar, ByteBuffer byteBuffer) {
        return T(byteBuffer.limit(), byteBuffer.array());
    }
}
