package k3;

import aa.c1;
import aa.g0;
import aa.j0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import p1.l0;
import p1.m0;
import s1.b0;
import s1.t;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends com.bumptech.glide.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ia.b f6999e = new ia.b(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ia.b f7000d;

    public h(ia.b bVar) {
        this.f7000d = bVar;
    }

    public static c A(u uVar, int i, int i10, boolean z2, int i11, ia.b bVar) throws Throwable {
        int i12 = uVar.f11710b;
        int iR = R(i12, uVar.f11709a);
        String str = new String(uVar.f11709a, i12, iR - i12, StandardCharsets.ISO_8859_1);
        uVar.J(iR + 1);
        int iJ = uVar.j();
        int iJ2 = uVar.j();
        long jZ = uVar.z();
        if (jZ == 4294967295L) {
            jZ = -1;
        }
        long jZ2 = uVar.z();
        long j5 = jZ2 == 4294967295L ? -1L : jZ2;
        ArrayList arrayList = new ArrayList();
        int i13 = i12 + i;
        while (uVar.f11710b < i13) {
            i iVarD = D(i10, uVar, z2, i11, bVar);
            if (iVarD != null) {
                arrayList.add(iVarD);
            }
        }
        return new c(str, iJ, iJ2, jZ, j5, (i[]) arrayList.toArray(new i[0]));
    }

    public static d B(u uVar, int i, int i10, boolean z2, int i11, ia.b bVar) throws Throwable {
        int i12 = uVar.f11710b;
        int iR = R(i12, uVar.f11709a);
        String str = new String(uVar.f11709a, i12, iR - i12, StandardCharsets.ISO_8859_1);
        uVar.J(iR + 1);
        int iX = uVar.x();
        boolean z10 = (iX & 2) != 0;
        boolean z11 = (iX & 1) != 0;
        int iX2 = uVar.x();
        String[] strArr = new String[iX2];
        for (int i13 = 0; i13 < iX2; i13++) {
            int i14 = uVar.f11710b;
            int iR2 = R(i14, uVar.f11709a);
            strArr[i13] = new String(uVar.f11709a, i14, iR2 - i14, StandardCharsets.ISO_8859_1);
            uVar.J(iR2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = i12 + i;
        while (uVar.f11710b < i15) {
            i iVarD = D(i10, uVar, z2, i11, bVar);
            if (iVarD != null) {
                arrayList.add(iVarD);
            }
        }
        return new d(str, z10, z11, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    public static e C(int i, u uVar) {
        if (i < 4) {
            return null;
        }
        int iX = uVar.x();
        Charset charsetO = O(iX);
        byte[] bArr = new byte[3];
        uVar.h(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i10 = i - 4;
        byte[] bArr2 = new byte[i10];
        uVar.h(bArr2, 0, i10);
        int iQ = Q(bArr2, 0, iX);
        String str2 = new String(bArr2, 0, iQ, charsetO);
        int iN = N(iX) + iQ;
        return new e(str, str2, H(bArr2, iN, Q(bArr2, iN, iX), charsetO));
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
    public static k3.i D(int r19, s1.u r20, boolean r21, int r22, ia.b r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.h.D(int, s1.u, boolean, int, ia.b):k3.i");
    }

    public static f E(int i, u uVar) {
        int iX = uVar.x();
        Charset charsetO = O(iX);
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        uVar.h(bArr, 0, i10);
        int iR = R(0, bArr);
        String strP = m0.p(new String(bArr, 0, iR, StandardCharsets.ISO_8859_1));
        int i11 = iR + 1;
        int iQ = Q(bArr, i11, iX);
        String strH = H(bArr, i11, iQ, charsetO);
        int iN = N(iX) + iQ;
        int iQ2 = Q(bArr, iN, iX);
        String strH2 = H(bArr, iN, iQ2, charsetO);
        int iN2 = N(iX) + iQ2;
        return new f(strP, strH, strH2, i10 <= iN2 ? b0.f11649c : Arrays.copyOfRange(bArr, iN2, i10));
    }

    public static l F(int i, u uVar) {
        int iD = uVar.D();
        int iA = uVar.A();
        int iA2 = uVar.A();
        int iX = uVar.x();
        int iX2 = uVar.x();
        t tVar = new t();
        tVar.p(uVar);
        int i10 = ((i - 10) * 8) / (iX + iX2);
        int[] iArr = new int[i10];
        int[] iArr2 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = tVar.i(iX);
            int i13 = tVar.i(iX2);
            iArr[i11] = i12;
            iArr2[i11] = i13;
        }
        return new l(iD, iA, iA2, iArr, iArr2);
    }

    public static m G(int i, u uVar) {
        byte[] bArr = new byte[i];
        uVar.h(bArr, 0, i);
        int iR = R(0, bArr);
        String str = new String(bArr, 0, iR, StandardCharsets.ISO_8859_1);
        int i10 = iR + 1;
        return new m(str, i <= i10 ? b0.f11649c : Arrays.copyOfRange(bArr, i10, i));
    }

    public static String H(byte[] bArr, int i, int i10, Charset charset) {
        return (i10 <= i || i10 > bArr.length) ? "" : new String(bArr, i, i10 - i, charset);
    }

    public static n I(int i, String str, u uVar) {
        if (i < 1) {
            return null;
        }
        int iX = uVar.x();
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        uVar.h(bArr, 0, i10);
        return new n(str, null, J(bArr, iX, 0));
    }

    public static c1 J(byte[] bArr, int i, int i10) {
        if (i10 >= bArr.length) {
            return j0.v("");
        }
        g0 g0VarN = j0.n();
        int iQ = Q(bArr, i10, i);
        while (i10 < iQ) {
            g0VarN.a(new String(bArr, i10, iQ - i10, O(i)));
            i10 = N(i) + iQ;
            iQ = Q(bArr, i10, i);
        }
        c1 c1VarG = g0VarN.g();
        return c1VarG.isEmpty() ? j0.v("") : c1VarG;
    }

    public static n K(int i, u uVar) {
        if (i < 1) {
            return null;
        }
        int iX = uVar.x();
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        uVar.h(bArr, 0, i10);
        int iQ = Q(bArr, 0, iX);
        return new n("TXXX", new String(bArr, 0, iQ, O(iX)), J(bArr, iX, N(iX) + iQ));
    }

    public static o L(int i, String str, u uVar) {
        byte[] bArr = new byte[i];
        uVar.h(bArr, 0, i);
        return new o(str, null, new String(bArr, 0, R(0, bArr), StandardCharsets.ISO_8859_1));
    }

    public static o M(int i, u uVar) {
        if (i < 1) {
            return null;
        }
        int iX = uVar.x();
        int i10 = i - 1;
        byte[] bArr = new byte[i10];
        uVar.h(bArr, 0, i10);
        int iQ = Q(bArr, 0, iX);
        String str = new String(bArr, 0, iQ, O(iX));
        int iN = N(iX) + iQ;
        return new o("WXXX", str, H(bArr, iN, R(iN, bArr), StandardCharsets.ISO_8859_1));
    }

    public static int N(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static Charset O(int i) {
        return i != 1 ? i != 2 ? i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    public static String P(int i, int i10, int i11, int i12, int i13) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static int Q(byte[] bArr, int i, int i10) {
        int iR = R(i, bArr);
        if (i10 == 0 || i10 == 3) {
            return iR;
        }
        while (iR < bArr.length - 1) {
            if ((iR - i) % 2 == 0 && bArr[iR + 1] == 0) {
                return iR;
            }
            iR = R(iR + 1, bArr);
        }
        return bArr.length;
    }

    public static int R(int i, byte[] bArr) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int S(int i, u uVar) {
        byte[] bArr = uVar.f11709a;
        int i10 = uVar.f11710b;
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
    public static boolean T(s1.u r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f11710b
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
        throw new UnsupportedOperationException("Method not decompiled: k3.h.T(s1.u, int, int, boolean):boolean");
    }

    public static a z(u uVar, int i, int i10) {
        int iR;
        String strConcat;
        int iX = uVar.x();
        Charset charsetO = O(iX);
        int i11 = i - 1;
        byte[] bArr = new byte[i11];
        uVar.h(bArr, 0, i11);
        if (i10 == 2) {
            strConcat = "image/" + com.bumptech.glide.d.X(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(strConcat)) {
                strConcat = "image/jpeg";
            }
            iR = 2;
        } else {
            iR = R(0, bArr);
            String strX = com.bumptech.glide.d.X(new String(bArr, 0, iR, StandardCharsets.ISO_8859_1));
            strConcat = strX.indexOf(47) == -1 ? "image/".concat(strX) : strX;
        }
        int i12 = bArr[iR + 1] & 255;
        int i13 = iR + 2;
        int iQ = Q(bArr, i13, iX);
        String str = new String(bArr, i13, iQ - i13, charsetO);
        int iN = N(iX) + iQ;
        return new a(strConcat, str, i12, i11 <= iN ? b0.f11649c : Arrays.copyOfRange(bArr, iN, i11));
    }

    @Override // com.bumptech.glide.c
    public final l0 i(f3.a aVar, ByteBuffer byteBuffer) {
        return y(byteBuffer.limit(), byteBuffer.array());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p1.l0 y(int r13, byte[] r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.h.y(int, byte[]):p1.l0");
    }
}
