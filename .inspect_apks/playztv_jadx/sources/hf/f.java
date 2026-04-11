package hf;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements h, g, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public r f6112u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f6113v;

    public final long F(byte b10, long j5, long j8) {
        r rVar;
        long j10 = 0;
        if (0 > j5 || j5 > j8) {
            throw new IllegalArgumentException(("size=" + this.f6113v + " fromIndex=" + j5 + " toIndex=" + j8).toString());
        }
        long j11 = this.f6113v;
        if (j8 > j11) {
            j8 = j11;
        }
        if (j5 == j8 || (rVar = this.f6112u) == null) {
            return -1L;
        }
        if (j11 - j5 < j5) {
            while (j11 > j5) {
                rVar = rVar.f6148g;
                be.h.b(rVar);
                j11 -= (long) (rVar.f6145c - rVar.f6144b);
            }
            while (j11 < j8) {
                byte[] bArr = rVar.f6143a;
                int iMin = (int) Math.min(rVar.f6145c, (((long) rVar.f6144b) + j8) - j11);
                for (int i = (int) ((((long) rVar.f6144b) + j5) - j11); i < iMin; i++) {
                    if (bArr[i] == b10) {
                        return ((long) (i - rVar.f6144b)) + j11;
                    }
                }
                j11 += (long) (rVar.f6145c - rVar.f6144b);
                rVar = rVar.f;
                be.h.b(rVar);
                j5 = j11;
            }
            return -1L;
        }
        while (true) {
            long j12 = ((long) (rVar.f6145c - rVar.f6144b)) + j10;
            if (j12 > j5) {
                break;
            }
            rVar = rVar.f;
            be.h.b(rVar);
            j10 = j12;
        }
        while (j10 < j8) {
            byte[] bArr2 = rVar.f6143a;
            int iMin2 = (int) Math.min(rVar.f6145c, (((long) rVar.f6144b) + j8) - j10);
            for (int i10 = (int) ((((long) rVar.f6144b) + j5) - j10); i10 < iMin2; i10++) {
                if (bArr2[i10] == b10) {
                    return ((long) (i10 - rVar.f6144b)) + j10;
                }
            }
            j10 += (long) (rVar.f6145c - rVar.f6144b);
            rVar = rVar.f;
            be.h.b(rVar);
            j5 = j10;
        }
        return -1L;
    }

    public final byte[] G(long j5) throws EOFException {
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        }
        if (this.f6113v < j5) {
            throw new EOFException();
        }
        int i = (int) j5;
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

    public final String H(long j5, Charset charset) throws EOFException {
        be.h.e(charset, "charset");
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        }
        if (this.f6113v < j5) {
            throw new EOFException();
        }
        if (j5 == 0) {
            return "";
        }
        r rVar = this.f6112u;
        be.h.b(rVar);
        int i = rVar.f6144b;
        if (((long) i) + j5 > rVar.f6145c) {
            return new String(G(j5), charset);
        }
        int i10 = (int) j5;
        String str = new String(rVar.f6143a, i, i10, charset);
        int i11 = rVar.f6144b + i10;
        rVar.f6144b = i11;
        this.f6113v -= j5;
        if (i11 == rVar.f6145c) {
            this.f6112u = rVar.a();
            s.a(rVar);
        }
        return str;
    }

    public final String J() {
        return H(this.f6113v, ie.a.f6599a);
    }

    public final i K(int i) {
        if (i == 0) {
            return i.f6114x;
        }
        b8.h.c(this.f6113v, 0L, i);
        r rVar = this.f6112u;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i) {
            be.h.b(rVar);
            int i13 = rVar.f6145c;
            int i14 = rVar.f6144b;
            if (i13 == i14) {
                throw new AssertionError("s.limit == s.pos");
            }
            i11 += i13 - i14;
            i12++;
            rVar = rVar.f;
        }
        byte[][] bArr = new byte[i12][];
        int[] iArr = new int[i12 * 2];
        r rVar2 = this.f6112u;
        int i15 = 0;
        while (i10 < i) {
            be.h.b(rVar2);
            bArr[i15] = rVar2.f6143a;
            i10 += rVar2.f6145c - rVar2.f6144b;
            iArr[i15] = Math.min(i10, i);
            iArr[i15 + i12] = rVar2.f6144b;
            rVar2.f6146d = true;
            i15++;
            rVar2 = rVar2.f;
        }
        return new t(bArr, iArr);
    }

    @Override // hf.h
    public final String M(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j5).toString());
        }
        long j8 = j5 != Long.MAX_VALUE ? j5 + 1 : Long.MAX_VALUE;
        long jF = F((byte) 10, 0L, j8);
        if (jF != -1) {
            return jf.a.a(jF, this);
        }
        if (j8 < this.f6113v && x(j8 - 1) == 13 && x(j8) == 10) {
            return jf.a.a(j8, this);
        }
        f fVar = new f();
        d(fVar, 0L, Math.min(32, this.f6113v));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f6113v, j5) + " content=" + fVar.m(fVar.f6113v).b() + (char) 8230);
    }

    public final r S(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        r rVar = this.f6112u;
        if (rVar == null) {
            r rVarB = s.b();
            this.f6112u = rVarB;
            rVarB.f6148g = rVarB;
            rVarB.f = rVarB;
            return rVarB;
        }
        r rVar2 = rVar.f6148g;
        be.h.b(rVar2);
        if (rVar2.f6145c + i <= 8192 && rVar2.f6147e) {
            return rVar2;
        }
        r rVarB2 = s.b();
        rVar2.b(rVarB2);
        return rVarB2;
    }

    @Override // hf.h
    public final void X(long j5) throws EOFException {
        if (this.f6113v < j5) {
            throw new EOFException();
        }
    }

    @Override // hf.g
    public final /* bridge */ /* synthetic */ g Y(String str) {
        o0(str);
        return this;
    }

    public final void a() throws EOFException {
        skip(this.f6113v);
    }

    @Override // hf.u
    public final void b0(long j5, f fVar) {
        r rVarB;
        be.h.e(fVar, "source");
        if (fVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        b8.h.c(fVar.f6113v, 0L, j5);
        while (j5 > 0) {
            r rVar = fVar.f6112u;
            be.h.b(rVar);
            int i = rVar.f6145c;
            r rVar2 = fVar.f6112u;
            be.h.b(rVar2);
            long j8 = i - rVar2.f6144b;
            int i10 = 0;
            if (j5 < j8) {
                r rVar3 = this.f6112u;
                r rVar4 = rVar3 != null ? rVar3.f6148g : null;
                if (rVar4 != null && rVar4.f6147e) {
                    if ((((long) rVar4.f6145c) + j5) - ((long) (rVar4.f6146d ? 0 : rVar4.f6144b)) <= 8192) {
                        r rVar5 = fVar.f6112u;
                        be.h.b(rVar5);
                        rVar5.d(rVar4, (int) j5);
                        fVar.f6113v -= j5;
                        this.f6113v += j5;
                        return;
                    }
                }
                r rVar6 = fVar.f6112u;
                be.h.b(rVar6);
                int i11 = (int) j5;
                if (i11 <= 0 || i11 > rVar6.f6145c - rVar6.f6144b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i11 >= 1024) {
                    rVarB = rVar6.c();
                } else {
                    rVarB = s.b();
                    byte[] bArr = rVar6.f6143a;
                    byte[] bArr2 = rVarB.f6143a;
                    int i12 = rVar6.f6144b;
                    od.h.R(0, i12, i12 + i11, bArr, bArr2);
                }
                rVarB.f6145c = rVarB.f6144b + i11;
                rVar6.f6144b += i11;
                r rVar7 = rVar6.f6148g;
                be.h.b(rVar7);
                rVar7.b(rVarB);
                fVar.f6112u = rVarB;
            }
            r rVar8 = fVar.f6112u;
            be.h.b(rVar8);
            long j10 = rVar8.f6145c - rVar8.f6144b;
            fVar.f6112u = rVar8.a();
            r rVar9 = this.f6112u;
            if (rVar9 == null) {
                this.f6112u = rVar8;
                rVar8.f6148g = rVar8;
                rVar8.f = rVar8;
            } else {
                r rVar10 = rVar9.f6148g;
                be.h.b(rVar10);
                rVar10.b(rVar8);
                r rVar11 = rVar8.f6148g;
                if (rVar11 == rVar8) {
                    throw new IllegalStateException("cannot compact");
                }
                be.h.b(rVar11);
                if (rVar11.f6147e) {
                    int i13 = rVar8.f6145c - rVar8.f6144b;
                    r rVar12 = rVar8.f6148g;
                    be.h.b(rVar12);
                    int i14 = 8192 - rVar12.f6145c;
                    r rVar13 = rVar8.f6148g;
                    be.h.b(rVar13);
                    if (!rVar13.f6146d) {
                        r rVar14 = rVar8.f6148g;
                        be.h.b(rVar14);
                        i10 = rVar14.f6144b;
                    }
                    if (i13 <= i14 + i10) {
                        r rVar15 = rVar8.f6148g;
                        be.h.b(rVar15);
                        rVar8.d(rVar15, i13);
                        rVar8.a();
                        s.a(rVar8);
                    }
                }
            }
            fVar.f6113v -= j10;
            this.f6113v += j10;
            j5 -= j10;
        }
    }

    @Override // hf.w
    public final y c() {
        return y.f6155d;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:38:0x00a2 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    @Override // hf.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long c0() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f6113v
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            hf.r r7 = r15.f6112u
            be.h.b(r7)
            byte[] r8 = r7.f6143a
            int r9 = r7.f6144b
            int r10 = r7.f6145c
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
            hf.f r0 = new hf.f
            r0.<init>()
            r0.k0(r4)
            r0.j0(r11)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.J()
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
            char[] r3 = jf.b.f6968a
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
            hf.r r8 = r7.a()
            r15.f6112u = r8
            hf.s.a(r7)
            goto L9c
        L9a:
            r7.f6144b = r9
        L9c:
            if (r6 != 0) goto La2
            hf.r r7 = r15.f6112u
            if (r7 != 0) goto Lc
        La2:
            long r2 = r15.f6113v
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f6113v = r2
            return r4
        La9:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hf.f.c0():long");
    }

    public final Object clone() {
        f fVar = new f();
        if (this.f6113v == 0) {
            return fVar;
        }
        r rVar = this.f6112u;
        be.h.b(rVar);
        r rVarC = rVar.c();
        fVar.f6112u = rVarC;
        rVarC.f6148g = rVarC;
        rVarC.f = rVarC;
        for (r rVar2 = rVar.f; rVar2 != rVar; rVar2 = rVar2.f) {
            r rVar3 = rVarC.f6148g;
            be.h.b(rVar3);
            be.h.b(rVar2);
            rVar3.b(rVar2.c());
        }
        fVar.f6113v = this.f6113v;
        return fVar;
    }

    public final void d(f fVar, long j5, long j8) {
        be.h.e(fVar, "out");
        long j10 = j5;
        b8.h.c(this.f6113v, j10, j8);
        if (j8 == 0) {
            return;
        }
        fVar.f6113v += j8;
        r rVar = this.f6112u;
        while (true) {
            be.h.b(rVar);
            long j11 = rVar.f6145c - rVar.f6144b;
            if (j10 < j11) {
                break;
            }
            j10 -= j11;
            rVar = rVar.f;
        }
        r rVar2 = rVar;
        long j12 = j8;
        while (j12 > 0) {
            be.h.b(rVar2);
            r rVarC = rVar2.c();
            int i = rVarC.f6144b + ((int) j10);
            rVarC.f6144b = i;
            rVarC.f6145c = Math.min(i + ((int) j12), rVarC.f6145c);
            r rVar3 = fVar.f6112u;
            if (rVar3 == null) {
                rVarC.f6148g = rVarC;
                rVarC.f = rVarC;
                fVar.f6112u = rVarC;
            } else {
                r rVar4 = rVar3.f6148g;
                be.h.b(rVar4);
                rVar4.b(rVarC);
            }
            j12 -= (long) (rVarC.f6145c - rVarC.f6144b);
            rVar2 = rVar2.f;
            j10 = 0;
        }
    }

    @Override // hf.h
    public final String d0(Charset charset) {
        return H(this.f6113v, charset);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        long j5 = this.f6113v;
        f fVar = (f) obj;
        if (j5 != fVar.f6113v) {
            return false;
        }
        if (j5 == 0) {
            return true;
        }
        r rVar = this.f6112u;
        be.h.b(rVar);
        r rVar2 = fVar.f6112u;
        be.h.b(rVar2);
        int i = rVar.f6144b;
        int i10 = rVar2.f6144b;
        long j8 = 0;
        while (j8 < this.f6113v) {
            long jMin = Math.min(rVar.f6145c - i, rVar2.f6145c - i10);
            long j10 = 0;
            while (j10 < jMin) {
                int i11 = i + 1;
                int i12 = i10 + 1;
                if (rVar.f6143a[i] != rVar2.f6143a[i10]) {
                    return false;
                }
                j10++;
                i = i11;
                i10 = i12;
            }
            if (i == rVar.f6145c) {
                rVar = rVar.f;
                be.h.b(rVar);
                i = rVar.f6144b;
            }
            if (i10 == rVar2.f6145c) {
                rVar2 = rVar2.f;
                be.h.b(rVar2);
                i10 = rVar2.f6144b;
            }
            j8 += jMin;
        }
        return true;
    }

    @Override // hf.h
    public final InputStream f0() {
        return new e(this, 0);
    }

    @Override // hf.g
    public final /* bridge */ /* synthetic */ g g(i iVar) {
        h0(iVar);
        return this;
    }

    public final void g0(int i, byte[] bArr) {
        be.h.e(bArr, "source");
        int i10 = 0;
        long j5 = i;
        b8.h.c(bArr.length, 0, j5);
        while (i10 < i) {
            r rVarS = S(1);
            int iMin = Math.min(i - i10, 8192 - rVarS.f6145c);
            int i11 = i10 + iMin;
            od.h.R(rVarS.f6145c, i10, i11, bArr, rVarS.f6143a);
            rVarS.f6145c += iMin;
            i10 = i11;
        }
        this.f6113v += j5;
    }

    @Override // hf.g
    public final /* bridge */ /* synthetic */ g h(long j5) {
        k0(j5);
        return this;
    }

    public final void h0(i iVar) {
        be.h.e(iVar, "byteString");
        iVar.i(this, iVar.a());
    }

    public final int hashCode() {
        r rVar = this.f6112u;
        if (rVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i10 = rVar.f6145c;
            for (int i11 = rVar.f6144b; i11 < i10; i11++) {
                i = (i * 31) + rVar.f6143a[i11];
            }
            rVar = rVar.f;
            be.h.b(rVar);
        } while (rVar != this.f6112u);
        return i;
    }

    public final void i0(w wVar) {
        be.h.e(wVar, "source");
        while (wVar.l(8192L, this) != -1) {
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final void j0(int i) {
        r rVarS = S(1);
        byte[] bArr = rVarS.f6143a;
        int i10 = rVarS.f6145c;
        rVarS.f6145c = i10 + 1;
        bArr[i10] = (byte) i;
        this.f6113v++;
    }

    public final void k0(long j5) {
        if (j5 == 0) {
            j0(48);
            return;
        }
        long j8 = (j5 >>> 1) | j5;
        long j10 = j8 | (j8 >>> 2);
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
        r rVarS = S(i);
        byte[] bArr = rVarS.f6143a;
        int i10 = rVarS.f6145c;
        for (int i11 = (i10 + i) - 1; i11 >= i10; i11--) {
            bArr[i11] = jf.a.f6967a[(int) (15 & j5)];
            j5 >>>= 4;
        }
        rVarS.f6145c += i;
        this.f6113v += (long) i;
    }

    @Override // hf.w
    public final long l(long j5, f fVar) {
        be.h.e(fVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        long j8 = this.f6113v;
        if (j8 == 0) {
            return -1L;
        }
        if (j5 > j8) {
            j5 = j8;
        }
        fVar.b0(j5, this);
        return j5;
    }

    public final void l0(int i) {
        r rVarS = S(4);
        byte[] bArr = rVarS.f6143a;
        int i10 = rVarS.f6145c;
        bArr[i10] = (byte) ((i >>> 24) & 255);
        bArr[i10 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i10 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i10 + 3] = (byte) (i & 255);
        rVarS.f6145c = i10 + 4;
        this.f6113v += 4;
    }

    @Override // hf.h
    public final i m(long j5) throws EOFException {
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        }
        if (this.f6113v < j5) {
            throw new EOFException();
        }
        if (j5 < 4096) {
            return new i(G(j5));
        }
        i iVarK = K((int) j5);
        skip(j5);
        return iVarK;
    }

    public final void m0(int i) {
        r rVarS = S(2);
        byte[] bArr = rVarS.f6143a;
        int i10 = rVarS.f6145c;
        bArr[i10] = (byte) ((i >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i & 255);
        rVarS.f6145c = i10 + 2;
        this.f6113v += 2;
    }

    public final void n0(int i, int i10, String str) {
        char cCharAt;
        be.h.e(str, "string");
        if (i < 0) {
            throw new IllegalArgumentException(e6.j.l("beginIndex < 0: ", i).toString());
        }
        if (i10 < i) {
            throw new IllegalArgumentException(l4.a.l(i10, i, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i10 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i10 + " > " + str.length()).toString());
        }
        while (i < i10) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                r rVarS = S(1);
                byte[] bArr = rVarS.f6143a;
                int i11 = rVarS.f6145c - i;
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
                int i13 = rVarS.f6145c;
                int i14 = (i11 + i) - i13;
                rVarS.f6145c = i13 + i14;
                this.f6113v += (long) i14;
            } else {
                if (cCharAt2 < 2048) {
                    r rVarS2 = S(2);
                    byte[] bArr2 = rVarS2.f6143a;
                    int i15 = rVarS2.f6145c;
                    bArr2[i15] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i15 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    rVarS2.f6145c = i15 + 2;
                    this.f6113v += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    r rVarS3 = S(3);
                    byte[] bArr3 = rVarS3.f6143a;
                    int i16 = rVarS3.f6145c;
                    bArr3[i16] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i16 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i16 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    rVarS3.f6145c = i16 + 3;
                    this.f6113v += 3;
                } else {
                    int i17 = i + 1;
                    char cCharAt3 = i17 < i10 ? str.charAt(i17) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        j0(63);
                        i = i17;
                    } else {
                        int i18 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        r rVarS4 = S(4);
                        byte[] bArr4 = rVarS4.f6143a;
                        int i19 = rVarS4.f6145c;
                        bArr4[i19] = (byte) ((i18 >> 18) | 240);
                        bArr4[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                        bArr4[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                        bArr4[i19 + 3] = (byte) ((i18 & 63) | 128);
                        rVarS4.f6145c = i19 + 4;
                        this.f6113v += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    @Override // hf.h
    public final int o(n nVar) throws EOFException {
        be.h.e(nVar, "options");
        int iB = jf.a.b(this, nVar, false);
        if (iB == -1) {
            return -1;
        }
        skip(nVar.f6129u[iB].a());
        return iB;
    }

    public final void o0(String str) {
        be.h.e(str, "string");
        n0(0, str.length(), str);
    }

    public final void p0(int i) {
        String str;
        if (i < 128) {
            j0(i);
            return;
        }
        if (i < 2048) {
            r rVarS = S(2);
            byte[] bArr = rVarS.f6143a;
            int i10 = rVarS.f6145c;
            bArr[i10] = (byte) ((i >> 6) | 192);
            bArr[i10 + 1] = (byte) ((i & 63) | 128);
            rVarS.f6145c = i10 + 2;
            this.f6113v += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            j0(63);
            return;
        }
        if (i < 65536) {
            r rVarS2 = S(3);
            byte[] bArr2 = rVarS2.f6143a;
            int i11 = rVarS2.f6145c;
            bArr2[i11] = (byte) ((i >> 12) | 224);
            bArr2[i11 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i11 + 2] = (byte) ((i & 63) | 128);
            rVarS2.f6145c = i11 + 3;
            this.f6113v += 3;
            return;
        }
        if (i <= 1114111) {
            r rVarS3 = S(4);
            byte[] bArr3 = rVarS3.f6143a;
            int i12 = rVarS3.f6145c;
            bArr3[i12] = (byte) ((i >> 18) | 240);
            bArr3[i12 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i12 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i12 + 3] = (byte) ((i & 63) | 128);
            rVarS3.f6145c = i12 + 4;
            this.f6113v += 4;
            return;
        }
        StringBuilder sb2 = new StringBuilder("Unexpected code point: 0x");
        if (i != 0) {
            char[] cArr = jf.b.f6968a;
            char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
            int i13 = 0;
            while (i13 < 8 && cArr2[i13] == '0') {
                i13++;
            }
            if (i13 < 0) {
                throw new IndexOutOfBoundsException(e6.j.j(i13, "startIndex: ", ", endIndex: 8, size: 8"));
            }
            if (i13 > 8) {
                throw new IllegalArgumentException(e6.j.j(i13, "startIndex: ", " > endIndex: 8"));
            }
            str = new String(cArr2, i13, 8 - i13);
        } else {
            str = "0";
        }
        sb2.append(str);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // hf.h
    public final boolean q(long j5) {
        return this.f6113v >= j5;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        be.h.e(byteBuffer, "sink");
        r rVar = this.f6112u;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), rVar.f6145c - rVar.f6144b);
        byteBuffer.put(rVar.f6143a, rVar.f6144b, iMin);
        int i = rVar.f6144b + iMin;
        rVar.f6144b = i;
        this.f6113v -= (long) iMin;
        if (i == rVar.f6145c) {
            this.f6112u = rVar.a();
            s.a(rVar);
        }
        return iMin;
    }

    @Override // hf.h
    public final byte readByte() {
        if (this.f6113v == 0) {
            throw new EOFException();
        }
        r rVar = this.f6112u;
        be.h.b(rVar);
        int i = rVar.f6144b;
        int i10 = rVar.f6145c;
        int i11 = i + 1;
        byte b10 = rVar.f6143a[i];
        this.f6113v--;
        if (i11 != i10) {
            rVar.f6144b = i11;
            return b10;
        }
        this.f6112u = rVar.a();
        s.a(rVar);
        return b10;
    }

    @Override // hf.h
    public final int readInt() throws EOFException {
        if (this.f6113v < 4) {
            throw new EOFException();
        }
        r rVar = this.f6112u;
        be.h.b(rVar);
        int i = rVar.f6144b;
        int i10 = rVar.f6145c;
        if (i10 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = rVar.f6143a;
        int i11 = i + 3;
        int i12 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i13 = i + 4;
        int i14 = (bArr[i11] & 255) | i12;
        this.f6113v -= 4;
        if (i13 != i10) {
            rVar.f6144b = i13;
            return i14;
        }
        this.f6112u = rVar.a();
        s.a(rVar);
        return i14;
    }

    @Override // hf.h
    public final short readShort() throws EOFException {
        if (this.f6113v < 2) {
            throw new EOFException();
        }
        r rVar = this.f6112u;
        be.h.b(rVar);
        int i = rVar.f6144b;
        int i10 = rVar.f6145c;
        if (i10 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = rVar.f6143a;
        int i11 = i + 1;
        int i12 = (bArr[i] & 255) << 8;
        int i13 = i + 2;
        int i14 = (bArr[i11] & 255) | i12;
        this.f6113v -= 2;
        if (i13 == i10) {
            this.f6112u = rVar.a();
            s.a(rVar);
        } else {
            rVar.f6144b = i13;
        }
        return (short) i14;
    }

    @Override // hf.h
    public final void skip(long j5) throws EOFException {
        while (j5 > 0) {
            r rVar = this.f6112u;
            if (rVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j5, rVar.f6145c - rVar.f6144b);
            long j8 = iMin;
            this.f6113v -= j8;
            j5 -= j8;
            int i = rVar.f6144b + iMin;
            rVar.f6144b = i;
            if (i == rVar.f6145c) {
                this.f6112u = rVar.a();
                s.a(rVar);
            }
        }
    }

    public final String toString() {
        long j5 = this.f6113v;
        if (j5 <= 2147483647L) {
            return K((int) j5).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f6113v).toString());
    }

    public final boolean v() {
        return this.f6113v == 0;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        be.h.e(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            r rVarS = S(1);
            int iMin = Math.min(i, 8192 - rVarS.f6145c);
            byteBuffer.get(rVarS.f6143a, rVarS.f6145c, iMin);
            i -= iMin;
            rVarS.f6145c += iMin;
        }
        this.f6113v += (long) iRemaining;
        return iRemaining;
    }

    @Override // hf.g
    public final /* bridge */ /* synthetic */ g writeByte(int i) {
        j0(i);
        return this;
    }

    @Override // hf.g
    public final /* bridge */ /* synthetic */ g writeInt(int i) {
        l0(i);
        return this;
    }

    @Override // hf.g
    public final /* bridge */ /* synthetic */ g writeShort(int i) {
        m0(i);
        return this;
    }

    public final byte x(long j5) {
        b8.h.c(this.f6113v, j5, 1L);
        r rVar = this.f6112u;
        if (rVar == null) {
            be.h.b(null);
            throw null;
        }
        long j8 = this.f6113v;
        if (j8 - j5 < j5) {
            while (j8 > j5) {
                rVar = rVar.f6148g;
                be.h.b(rVar);
                j8 -= (long) (rVar.f6145c - rVar.f6144b);
            }
            return rVar.f6143a[(int) ((((long) rVar.f6144b) + j5) - j8)];
        }
        long j10 = 0;
        while (true) {
            int i = rVar.f6145c;
            int i10 = rVar.f6144b;
            long j11 = ((long) (i - i10)) + j10;
            if (j11 > j5) {
                return rVar.f6143a[(int) ((((long) i10) + j5) - j10)];
            }
            rVar = rVar.f;
            be.h.b(rVar);
            j10 = j11;
        }
    }

    @Override // hf.h
    public final String y() {
        return M(Long.MAX_VALUE);
    }

    @Override // hf.g
    public final g write(byte[] bArr) {
        g0(bArr.length, bArr);
        return this;
    }

    public final int read(byte[] bArr, int i, int i10) {
        b8.h.c(bArr.length, i, i10);
        r rVar = this.f6112u;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(i10, rVar.f6145c - rVar.f6144b);
        byte[] bArr2 = rVar.f6143a;
        int i11 = rVar.f6144b;
        od.h.R(i, i11, i11 + iMin, bArr2, bArr);
        int i12 = rVar.f6144b + iMin;
        rVar.f6144b = i12;
        this.f6113v -= (long) iMin;
        if (i12 == rVar.f6145c) {
            this.f6112u = rVar.a();
            s.a(rVar);
        }
        return iMin;
    }

    @Override // hf.h
    public final f B() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, hf.u
    public final void close() {
    }

    @Override // hf.g, hf.u, java.io.Flushable
    public final void flush() {
    }
}
