package ag;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements g, f, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public r f428v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f429w;

    public final byte[] A(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (this.f429w < j4) {
            throw new EOFException();
        }
        int i = (int) j4;
        byte[] bArr = new byte[i];
        int i10 = 0;
        while (i10 < i) {
            int i11 = read(bArr, i10, i - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:38:0x00a2 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long C() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f429w
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            ag.r r7 = r15.f428v
            ge.i.b(r7)
            byte[] r8 = r7.f462a
            int r9 = r7.f463b
            int r10 = r7.f464c
        L17:
            if (r9 >= r10) goto L8e
            r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L26
            r12 = 57
            if (r11 > r12) goto L26
            int r12 = r11 + (-48)
            goto L3b
        L26:
            r12 = 97
            if (r11 < r12) goto L31
            r12 = 102(0x66, float:1.43E-43)
            if (r11 > r12) goto L31
            int r12 = r11 + (-87)
            goto L3b
        L31:
            r12 = 65
            if (r11 < r12) goto L66
            r12 = 70
            if (r11 > r12) goto L66
            int r12 = r11 + (-55)
        L3b:
            r13 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r13 = r13 & r4
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 != 0) goto L4b
            r11 = 4
            long r4 = r4 << r11
            long r11 = (long) r12
            long r4 = r4 | r11
            int r9 = r9 + 1
            int r1 = r1 + 1
            goto L17
        L4b:
            ag.e r0 = new ag.e
            r0.<init>()
            r0.k0(r4)
            r0.i0(r11)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.O()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L66:
            r6 = 1
            if (r1 == 0) goto L6a
            goto L8e
        L6a:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            int r2 = r11 >> 4
            r2 = r2 & 15
            char[] r3 = bg.b.f1919a
            char r2 = r3[r2]
            r4 = r11 & 15
            char r3 = r3[r4]
            r4 = 2
            char[] r4 = new char[r4]
            r4[r0] = r2
            r4[r6] = r3
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L8e:
            if (r9 != r10) goto L9a
            ag.r r8 = r7.a()
            r15.f428v = r8
            ag.s.a(r7)
            goto L9c
        L9a:
            r7.f463b = r9
        L9c:
            if (r6 != 0) goto La2
            ag.r r7 = r15.f428v
            if (r7 != 0) goto Lc
        La2:
            long r2 = r15.f429w
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f429w = r2
            return r4
        La9:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.e.C():long");
    }

    @Override // ag.g
    public final String I(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j4).toString());
        }
        long j7 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
        long jZ = z((byte) 10, 0L, j7);
        if (jZ != -1) {
            return bg.a.a(jZ, this);
        }
        if (j7 < this.f429w && s(j7 - 1) == 13 && s(j7) == 10) {
            return bg.a.a(j7, this);
        }
        e eVar = new e();
        g(eVar, 0L, Math.min(32, this.f429w));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f429w, j4) + " content=" + eVar.k(eVar.f429w).b() + (char) 8230);
    }

    public final String J(long j4, Charset charset) throws EOFException {
        ge.i.e(charset, "charset");
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (this.f429w < j4) {
            throw new EOFException();
        }
        if (j4 == 0) {
            return "";
        }
        r rVar = this.f428v;
        ge.i.b(rVar);
        int i = rVar.f463b;
        if (((long) i) + j4 > rVar.f464c) {
            return new String(A(j4), charset);
        }
        int i10 = (int) j4;
        String str = new String(rVar.f462a, i, i10, charset);
        int i11 = rVar.f463b + i10;
        rVar.f463b = i11;
        this.f429w -= j4;
        if (i11 == rVar.f464c) {
            this.f428v = rVar.a();
            s.a(rVar);
        }
        return str;
    }

    public final String O() {
        return J(this.f429w, ne.a.f9126a);
    }

    public final h Q(int i) {
        if (i == 0) {
            return h.f430y;
        }
        u8.a.f(this.f429w, 0L, i);
        r rVar = this.f428v;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i) {
            ge.i.b(rVar);
            int i13 = rVar.f464c;
            int i14 = rVar.f463b;
            if (i13 == i14) {
                throw new AssertionError("s.limit == s.pos");
            }
            i11 += i13 - i14;
            i12++;
            rVar = rVar.f;
        }
        byte[][] bArr = new byte[i12][];
        int[] iArr = new int[i12 * 2];
        r rVar2 = this.f428v;
        int i15 = 0;
        while (i10 < i) {
            ge.i.b(rVar2);
            bArr[i15] = rVar2.f462a;
            i10 += rVar2.f464c - rVar2.f463b;
            iArr[i15] = Math.min(i10, i);
            iArr[i15 + i12] = rVar2.f463b;
            rVar2.f465d = true;
            i15++;
            rVar2 = rVar2.f;
        }
        return new t(bArr, iArr);
    }

    public final r R(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        r rVar = this.f428v;
        if (rVar == null) {
            r rVarB = s.b();
            this.f428v = rVarB;
            rVarB.f467g = rVarB;
            rVarB.f = rVarB;
            return rVarB;
        }
        r rVar2 = rVar.f467g;
        ge.i.b(rVar2);
        if (rVar2.f464c + i <= 8192 && rVar2.f466e) {
            return rVar2;
        }
        r rVarB2 = s.b();
        rVar2.b(rVarB2);
        return rVarB2;
    }

    @Override // ag.w
    public final long U(long j4, e eVar) {
        ge.i.e(eVar, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        long j7 = this.f429w;
        if (j7 == 0) {
            return -1L;
        }
        if (j4 > j7) {
            j4 = j7;
        }
        eVar.a0(j4, this);
        return j4;
    }

    @Override // ag.g
    public final void W(long j4) throws EOFException {
        if (this.f429w < j4) {
            throw new EOFException();
        }
    }

    public final void a() throws EOFException {
        skip(this.f429w);
    }

    @Override // ag.u
    public final void a0(long j4, e eVar) {
        r rVarB;
        ge.i.e(eVar, "source");
        if (eVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u8.a.f(eVar.f429w, 0L, j4);
        while (j4 > 0) {
            r rVar = eVar.f428v;
            ge.i.b(rVar);
            int i = rVar.f464c;
            r rVar2 = eVar.f428v;
            ge.i.b(rVar2);
            long j7 = i - rVar2.f463b;
            int i10 = 0;
            if (j4 < j7) {
                r rVar3 = this.f428v;
                r rVar4 = rVar3 != null ? rVar3.f467g : null;
                if (rVar4 != null && rVar4.f466e) {
                    if ((((long) rVar4.f464c) + j4) - ((long) (rVar4.f465d ? 0 : rVar4.f463b)) <= 8192) {
                        r rVar5 = eVar.f428v;
                        ge.i.b(rVar5);
                        rVar5.d(rVar4, (int) j4);
                        eVar.f429w -= j4;
                        this.f429w += j4;
                        return;
                    }
                }
                r rVar6 = eVar.f428v;
                ge.i.b(rVar6);
                int i11 = (int) j4;
                if (i11 <= 0 || i11 > rVar6.f464c - rVar6.f463b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i11 >= 1024) {
                    rVarB = rVar6.c();
                } else {
                    rVarB = s.b();
                    byte[] bArr = rVar6.f462a;
                    byte[] bArr2 = rVarB.f462a;
                    int i12 = rVar6.f463b;
                    sd.i.f(0, i12, i12 + i11, bArr, bArr2);
                }
                rVarB.f464c = rVarB.f463b + i11;
                rVar6.f463b += i11;
                r rVar7 = rVar6.f467g;
                ge.i.b(rVar7);
                rVar7.b(rVarB);
                eVar.f428v = rVarB;
            }
            r rVar8 = eVar.f428v;
            ge.i.b(rVar8);
            long j10 = rVar8.f464c - rVar8.f463b;
            eVar.f428v = rVar8.a();
            r rVar9 = this.f428v;
            if (rVar9 == null) {
                this.f428v = rVar8;
                rVar8.f467g = rVar8;
                rVar8.f = rVar8;
            } else {
                r rVar10 = rVar9.f467g;
                ge.i.b(rVar10);
                rVar10.b(rVar8);
                r rVar11 = rVar8.f467g;
                if (rVar11 == rVar8) {
                    throw new IllegalStateException("cannot compact");
                }
                ge.i.b(rVar11);
                if (rVar11.f466e) {
                    int i13 = rVar8.f464c - rVar8.f463b;
                    r rVar12 = rVar8.f467g;
                    ge.i.b(rVar12);
                    int i14 = 8192 - rVar12.f464c;
                    r rVar13 = rVar8.f467g;
                    ge.i.b(rVar13);
                    if (!rVar13.f465d) {
                        r rVar14 = rVar8.f467g;
                        ge.i.b(rVar14);
                        i10 = rVar14.f463b;
                    }
                    if (i13 <= i14 + i10) {
                        r rVar15 = rVar8.f467g;
                        ge.i.b(rVar15);
                        rVar8.d(rVar15, i13);
                        rVar8.a();
                        s.a(rVar8);
                    }
                }
            }
            eVar.f429w -= j10;
            this.f429w += j10;
            j4 -= j10;
        }
    }

    @Override // ag.g
    public final String b0(Charset charset) {
        ge.i.e(charset, "charset");
        return J(this.f429w, charset);
    }

    public final Object clone() {
        e eVar = new e();
        if (this.f429w == 0) {
            return eVar;
        }
        r rVar = this.f428v;
        ge.i.b(rVar);
        r rVarC = rVar.c();
        eVar.f428v = rVarC;
        rVarC.f467g = rVarC;
        rVarC.f = rVarC;
        for (r rVar2 = rVar.f; rVar2 != rVar; rVar2 = rVar2.f) {
            r rVar3 = rVarC.f467g;
            ge.i.b(rVar3);
            ge.i.b(rVar2);
            rVar3.b(rVar2.c());
        }
        eVar.f429w = this.f429w;
        return eVar;
    }

    @Override // ag.w, ag.u
    public final y d() {
        return y.f472d;
    }

    @Override // ag.g
    public final InputStream d0() {
        return new d(this, 0);
    }

    public final void e0(int i, byte[] bArr) {
        ge.i.e(bArr, "source");
        int i10 = 0;
        long j4 = i;
        u8.a.f(bArr.length, 0, j4);
        while (i10 < i) {
            r rVarR = R(1);
            int iMin = Math.min(i - i10, 8192 - rVarR.f464c);
            int i11 = i10 + iMin;
            sd.i.f(rVarR.f464c, i10, i11, bArr, rVarR.f462a);
            rVarR.f464c += iMin;
            i10 = i11;
        }
        this.f429w += j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        long j4 = this.f429w;
        e eVar = (e) obj;
        if (j4 != eVar.f429w) {
            return false;
        }
        if (j4 == 0) {
            return true;
        }
        r rVar = this.f428v;
        ge.i.b(rVar);
        r rVar2 = eVar.f428v;
        ge.i.b(rVar2);
        int i = rVar.f463b;
        int i10 = rVar2.f463b;
        long j7 = 0;
        while (j7 < this.f429w) {
            long jMin = Math.min(rVar.f464c - i, rVar2.f464c - i10);
            long j10 = 0;
            while (j10 < jMin) {
                int i11 = i + 1;
                int i12 = i10 + 1;
                if (rVar.f462a[i] != rVar2.f462a[i10]) {
                    return false;
                }
                j10++;
                i = i11;
                i10 = i12;
            }
            if (i == rVar.f464c) {
                rVar = rVar.f;
                ge.i.b(rVar);
                i = rVar.f463b;
            }
            if (i10 == rVar2.f464c) {
                rVar2 = rVar2.f;
                ge.i.b(rVar2);
                i10 = rVar2.f463b;
            }
            j7 += jMin;
        }
        return true;
    }

    public final void g(e eVar, long j4, long j7) {
        ge.i.e(eVar, "out");
        long j10 = j4;
        u8.a.f(this.f429w, j10, j7);
        if (j7 == 0) {
            return;
        }
        eVar.f429w += j7;
        r rVar = this.f428v;
        while (true) {
            ge.i.b(rVar);
            long j11 = rVar.f464c - rVar.f463b;
            if (j10 < j11) {
                break;
            }
            j10 -= j11;
            rVar = rVar.f;
        }
        r rVar2 = rVar;
        long j12 = j7;
        while (j12 > 0) {
            ge.i.b(rVar2);
            r rVarC = rVar2.c();
            int i = rVarC.f463b + ((int) j10);
            rVarC.f463b = i;
            rVarC.f464c = Math.min(i + ((int) j12), rVarC.f464c);
            r rVar3 = eVar.f428v;
            if (rVar3 == null) {
                rVarC.f467g = rVarC;
                rVarC.f = rVarC;
                eVar.f428v = rVarC;
            } else {
                r rVar4 = rVar3.f467g;
                ge.i.b(rVar4);
                rVar4.b(rVarC);
            }
            j12 -= (long) (rVarC.f464c - rVarC.f463b);
            rVar2 = rVar2.f;
            j10 = 0;
        }
    }

    public final void g0(h hVar) {
        ge.i.e(hVar, "byteString");
        hVar.k(this, hVar.a());
    }

    public final void h0(w wVar) {
        ge.i.e(wVar, "source");
        while (wVar.U(8192L, this) != -1) {
        }
    }

    public final int hashCode() {
        r rVar = this.f428v;
        if (rVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i10 = rVar.f464c;
            for (int i11 = rVar.f463b; i11 < i10; i11++) {
                i = (i * 31) + rVar.f462a[i11];
            }
            rVar = rVar.f;
            ge.i.b(rVar);
        } while (rVar != this.f428v);
        return i;
    }

    public final void i0(int i) {
        r rVarR = R(1);
        byte[] bArr = rVarR.f462a;
        int i10 = rVarR.f464c;
        rVarR.f464c = i10 + 1;
        bArr[i10] = (byte) i;
        this.f429w++;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final void j0(long j4) {
        boolean z10;
        if (j4 == 0) {
            i0(48);
            return;
        }
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                o0("-9223372036854775808");
                return;
            }
            z10 = true;
        } else {
            z10 = false;
        }
        byte[] bArr = bg.a.f1917a;
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j4)) * 10) >>> 5;
        int i = iNumberOfLeadingZeros + (j4 > bg.a.f1918b[iNumberOfLeadingZeros] ? 1 : 0);
        if (z10) {
            i++;
        }
        r rVarR = R(i);
        byte[] bArr2 = rVarR.f462a;
        int i10 = rVarR.f464c + i;
        while (j4 != 0) {
            long j7 = 10;
            i10--;
            bArr2[i10] = bg.a.f1917a[(int) (j4 % j7)];
            j4 /= j7;
        }
        if (z10) {
            bArr2[i10 - 1] = 45;
        }
        rVarR.f464c += i;
        this.f429w += (long) i;
    }

    @Override // ag.g
    public final h k(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        }
        if (this.f429w < j4) {
            throw new EOFException();
        }
        if (j4 < 4096) {
            return new h(A(j4));
        }
        h hVarQ = Q((int) j4);
        skip(j4);
        return hVarQ;
    }

    public final void k0(long j4) {
        if (j4 == 0) {
            i0(48);
            return;
        }
        long j7 = (j4 >>> 1) | j4;
        long j10 = j7 | (j7 >>> 2);
        long j11 = j10 | (j10 >>> 4);
        long j12 = j11 | (j11 >>> 8);
        long j13 = j12 | (j12 >>> 16);
        long j14 = j13 | (j13 >>> 32);
        long j15 = j14 - ((j14 >>> 1) & 6148914691236517205L);
        long j16 = ((j15 >>> 2) & 3689348814741910323L) + (j15 & 3689348814741910323L);
        long j17 = ((j16 >>> 4) + j16) & 1085102592571150095L;
        long j18 = j17 + (j17 >>> 8);
        long j19 = j18 + (j18 >>> 16);
        int i = (int) ((((j19 & 63) + ((j19 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        r rVarR = R(i);
        byte[] bArr = rVarR.f462a;
        int i10 = rVarR.f464c;
        for (int i11 = (i10 + i) - 1; i11 >= i10; i11--) {
            bArr[i11] = bg.a.f1917a[(int) (15 & j4)];
            j4 >>>= 4;
        }
        rVarR.f464c += i;
        this.f429w += (long) i;
    }

    public final void l0(int i) {
        r rVarR = R(4);
        byte[] bArr = rVarR.f462a;
        int i10 = rVarR.f464c;
        bArr[i10] = (byte) ((i >>> 24) & 255);
        bArr[i10 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i10 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i10 + 3] = (byte) (i & 255);
        rVarR.f464c = i10 + 4;
        this.f429w += 4;
    }

    public final void m0(int i) {
        r rVarR = R(2);
        byte[] bArr = rVarR.f462a;
        int i10 = rVarR.f464c;
        bArr[i10] = (byte) ((i >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i & 255);
        rVarR.f464c = i10 + 2;
        this.f429w += 2;
    }

    public final void n0(int i, int i10, String str) {
        char cCharAt;
        ge.i.e(str, "string");
        if (i < 0) {
            throw new IllegalArgumentException(l0.e.g(i, "beginIndex < 0: ").toString());
        }
        if (i10 < i) {
            throw new IllegalArgumentException(q4.a.m(i10, i, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i10 > str.length()) {
            StringBuilder sbM = l0.e.m(i10, "endIndex > string.length: ", " > ");
            sbM.append(str.length());
            throw new IllegalArgumentException(sbM.toString().toString());
        }
        while (i < i10) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                r rVarR = R(1);
                byte[] bArr = rVarR.f462a;
                int i11 = rVarR.f464c - i;
                int iMin = Math.min(i10, 8192 - i11);
                int i12 = i + 1;
                bArr[i + i11] = (byte) cCharAt2;
                while (true) {
                    i = i12;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i12 = i + 1;
                    bArr[i + i11] = (byte) cCharAt;
                }
                int i13 = rVarR.f464c;
                int i14 = (i11 + i) - i13;
                rVarR.f464c = i13 + i14;
                this.f429w += (long) i14;
            } else {
                if (cCharAt2 < 2048) {
                    r rVarR2 = R(2);
                    byte[] bArr2 = rVarR2.f462a;
                    int i15 = rVarR2.f464c;
                    bArr2[i15] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i15 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    rVarR2.f464c = i15 + 2;
                    this.f429w += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    r rVarR3 = R(3);
                    byte[] bArr3 = rVarR3.f462a;
                    int i16 = rVarR3.f464c;
                    bArr3[i16] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i16 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i16 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    rVarR3.f464c = i16 + 3;
                    this.f429w += 3;
                } else {
                    int i17 = i + 1;
                    char cCharAt3 = i17 < i10 ? str.charAt(i17) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        i0(63);
                        i = i17;
                    } else {
                        int i18 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        r rVarR4 = R(4);
                        byte[] bArr4 = rVarR4.f462a;
                        int i19 = rVarR4.f464c;
                        bArr4[i19] = (byte) ((i18 >> 18) | 240);
                        bArr4[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                        bArr4[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                        bArr4[i19 + 3] = (byte) ((i18 & 63) | 128);
                        rVarR4.f464c = i19 + 4;
                        this.f429w += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    @Override // ag.g
    public final boolean o(long j4) {
        return this.f429w >= j4;
    }

    public final void o0(String str) {
        ge.i.e(str, "string");
        n0(0, str.length(), str);
    }

    public final void p0(int i) {
        if (i < 128) {
            i0(i);
            return;
        }
        if (i < 2048) {
            r rVarR = R(2);
            byte[] bArr = rVarR.f462a;
            int i10 = rVarR.f464c;
            bArr[i10] = (byte) ((i >> 6) | 192);
            bArr[i10 + 1] = (byte) ((i & 63) | 128);
            rVarR.f464c = i10 + 2;
            this.f429w += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            i0(63);
            return;
        }
        if (i < 65536) {
            r rVarR2 = R(3);
            byte[] bArr2 = rVarR2.f462a;
            int i11 = rVarR2.f464c;
            bArr2[i11] = (byte) ((i >> 12) | 224);
            bArr2[i11 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i11 + 2] = (byte) ((i & 63) | 128);
            rVarR2.f464c = i11 + 3;
            this.f429w += 3;
            return;
        }
        if (i > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(u8.a.D(i)));
        }
        r rVarR3 = R(4);
        byte[] bArr3 = rVarR3.f462a;
        int i12 = rVarR3.f464c;
        bArr3[i12] = (byte) ((i >> 18) | 240);
        bArr3[i12 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i12 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i12 + 3] = (byte) ((i & 63) | 128);
        rVarR3.f464c = i12 + 4;
        this.f429w += 4;
    }

    public final boolean q() {
        return this.f429w == 0;
    }

    @Override // ag.g
    public final int r(m mVar) throws EOFException {
        ge.i.e(mVar, "options");
        int iB = bg.a.b(this, mVar, false);
        if (iB == -1) {
            return -1;
        }
        skip(mVar.f446v[iB].a());
        return iB;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        ge.i.e(byteBuffer, "sink");
        r rVar = this.f428v;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), rVar.f464c - rVar.f463b);
        byteBuffer.put(rVar.f462a, rVar.f463b, iMin);
        int i = rVar.f463b + iMin;
        rVar.f463b = i;
        this.f429w -= (long) iMin;
        if (i == rVar.f464c) {
            this.f428v = rVar.a();
            s.a(rVar);
        }
        return iMin;
    }

    @Override // ag.g
    public final byte readByte() {
        if (this.f429w == 0) {
            throw new EOFException();
        }
        r rVar = this.f428v;
        ge.i.b(rVar);
        int i = rVar.f463b;
        int i10 = rVar.f464c;
        int i11 = i + 1;
        byte b8 = rVar.f462a[i];
        this.f429w--;
        if (i11 != i10) {
            rVar.f463b = i11;
            return b8;
        }
        this.f428v = rVar.a();
        s.a(rVar);
        return b8;
    }

    @Override // ag.g
    public final int readInt() throws EOFException {
        if (this.f429w < 4) {
            throw new EOFException();
        }
        r rVar = this.f428v;
        ge.i.b(rVar);
        int i = rVar.f463b;
        int i10 = rVar.f464c;
        if (i10 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = rVar.f462a;
        int i11 = i + 3;
        int i12 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i13 = i + 4;
        int i14 = (bArr[i11] & 255) | i12;
        this.f429w -= 4;
        if (i13 != i10) {
            rVar.f463b = i13;
            return i14;
        }
        this.f428v = rVar.a();
        s.a(rVar);
        return i14;
    }

    @Override // ag.g
    public final short readShort() throws EOFException {
        if (this.f429w < 2) {
            throw new EOFException();
        }
        r rVar = this.f428v;
        ge.i.b(rVar);
        int i = rVar.f463b;
        int i10 = rVar.f464c;
        if (i10 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = rVar.f462a;
        int i11 = i + 1;
        int i12 = (bArr[i] & 255) << 8;
        int i13 = i + 2;
        int i14 = (bArr[i11] & 255) | i12;
        this.f429w -= 2;
        if (i13 == i10) {
            this.f428v = rVar.a();
            s.a(rVar);
        } else {
            rVar.f463b = i13;
        }
        return (short) i14;
    }

    public final byte s(long j4) {
        u8.a.f(this.f429w, j4, 1L);
        r rVar = this.f428v;
        if (rVar == null) {
            ge.i.b(null);
            throw null;
        }
        long j7 = this.f429w;
        if (j7 - j4 < j4) {
            while (j7 > j4) {
                rVar = rVar.f467g;
                ge.i.b(rVar);
                j7 -= (long) (rVar.f464c - rVar.f463b);
            }
            return rVar.f462a[(int) ((((long) rVar.f463b) + j4) - j7)];
        }
        long j10 = 0;
        while (true) {
            int i = rVar.f464c;
            int i10 = rVar.f463b;
            long j11 = ((long) (i - i10)) + j10;
            if (j11 > j4) {
                return rVar.f462a[(int) ((((long) i10) + j4) - j10)];
            }
            rVar = rVar.f;
            ge.i.b(rVar);
            j10 = j11;
        }
    }

    @Override // ag.g
    public final void skip(long j4) throws EOFException {
        while (j4 > 0) {
            r rVar = this.f428v;
            if (rVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j4, rVar.f464c - rVar.f463b);
            long j7 = iMin;
            this.f429w -= j7;
            j4 -= j7;
            int i = rVar.f463b + iMin;
            rVar.f463b = i;
            if (i == rVar.f464c) {
                this.f428v = rVar.a();
                s.a(rVar);
            }
        }
    }

    public final String toString() {
        long j4 = this.f429w;
        if (j4 <= 2147483647L) {
            return Q((int) j4).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f429w).toString());
    }

    @Override // ag.f
    public final /* bridge */ /* synthetic */ f u(h hVar) {
        g0(hVar);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        ge.i.e(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            r rVarR = R(1);
            int iMin = Math.min(i, 8192 - rVarR.f464c);
            byteBuffer.get(rVarR.f462a, rVarR.f464c, iMin);
            i -= iMin;
            rVarR.f464c += iMin;
        }
        this.f429w += (long) iRemaining;
        return iRemaining;
    }

    @Override // ag.f
    public final /* bridge */ /* synthetic */ f writeByte(int i) {
        i0(i);
        return this;
    }

    @Override // ag.f
    public final /* bridge */ /* synthetic */ f writeInt(int i) {
        l0(i);
        return this;
    }

    @Override // ag.f
    public final /* bridge */ /* synthetic */ f writeShort(int i) {
        m0(i);
        return this;
    }

    public final long z(byte b8, long j4, long j7) {
        r rVar;
        long j10 = 0;
        if (0 > j4 || j4 > j7) {
            throw new IllegalArgumentException(("size=" + this.f429w + " fromIndex=" + j4 + " toIndex=" + j7).toString());
        }
        long j11 = this.f429w;
        if (j7 > j11) {
            j7 = j11;
        }
        if (j4 == j7 || (rVar = this.f428v) == null) {
            return -1L;
        }
        if (j11 - j4 < j4) {
            while (j11 > j4) {
                rVar = rVar.f467g;
                ge.i.b(rVar);
                j11 -= (long) (rVar.f464c - rVar.f463b);
            }
            while (j11 < j7) {
                byte[] bArr = rVar.f462a;
                int iMin = (int) Math.min(rVar.f464c, (((long) rVar.f463b) + j7) - j11);
                for (int i = (int) ((((long) rVar.f463b) + j4) - j11); i < iMin; i++) {
                    if (bArr[i] == b8) {
                        return ((long) (i - rVar.f463b)) + j11;
                    }
                }
                j11 += (long) (rVar.f464c - rVar.f463b);
                rVar = rVar.f;
                ge.i.b(rVar);
                j4 = j11;
            }
            return -1L;
        }
        while (true) {
            long j12 = ((long) (rVar.f464c - rVar.f463b)) + j10;
            if (j12 > j4) {
                break;
            }
            rVar = rVar.f;
            ge.i.b(rVar);
            j10 = j12;
        }
        while (j10 < j7) {
            byte[] bArr2 = rVar.f462a;
            int iMin2 = (int) Math.min(rVar.f464c, (((long) rVar.f463b) + j7) - j10);
            for (int i10 = (int) ((((long) rVar.f463b) + j4) - j10); i10 < iMin2; i10++) {
                if (bArr2[i10] == b8) {
                    return ((long) (i10 - rVar.f463b)) + j10;
                }
            }
            j10 += (long) (rVar.f464c - rVar.f463b);
            rVar = rVar.f;
            ge.i.b(rVar);
            j4 = j10;
        }
        return -1L;
    }

    @Override // ag.f
    public final f write(byte[] bArr) {
        e0(bArr.length, bArr);
        return this;
    }

    public final int read(byte[] bArr, int i, int i10) {
        u8.a.f(bArr.length, i, i10);
        r rVar = this.f428v;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(i10, rVar.f464c - rVar.f463b);
        byte[] bArr2 = rVar.f462a;
        int i11 = rVar.f463b;
        sd.i.f(i, i11, i11 + iMin, bArr2, bArr);
        int i12 = rVar.f463b + iMin;
        rVar.f463b = i12;
        this.f429w -= (long) iMin;
        if (i12 == rVar.f464c) {
            this.f428v = rVar.a();
            s.a(rVar);
        }
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, ag.u
    public final void close() {
    }

    @Override // ag.f, ag.u, java.io.Flushable
    public final void flush() {
    }

    @Override // ag.g
    public final e w() {
        return this;
    }
}
