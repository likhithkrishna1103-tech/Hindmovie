package w5;

import a2.y0;
import c6.c;
import e6.j;
import hf.f;
import hf.i;
import hf.n;
import hf.q;
import java.io.EOFException;
import lb.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    public static final i F;
    public static final i G;
    public static final i H;
    public final f A;
    public int B;
    public long C;
    public int D;
    public String E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final q f13743z;

    static {
        i iVar = i.f6114x;
        F = e.h("'\\");
        G = e.h("\"\\");
        H = e.h("{}[]:, \n\t\r\f/\\;#=");
        e.h("\n\r");
        e.h("*/");
    }

    public b(q qVar) {
        this.f13740v = new int[32];
        this.f13741w = new String[32];
        this.f13742x = new int[32];
        this.B = 0;
        this.f13743z = qVar;
        this.A = qVar.f6141v;
        h0(6);
    }

    @Override // w5.a
    public final boolean G() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        return (iN0 == 2 || iN0 == 4 || iN0 == 18) ? false : true;
    }

    @Override // w5.a
    public final boolean H() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 5) {
            this.B = 0;
            int[] iArr = this.f13742x;
            int i = this.f13739u - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iN0 == 6) {
            this.B = 0;
            int[] iArr2 = this.f13742x;
            int i10 = this.f13739u - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return false;
        }
        throw new y0("Expected a boolean but was " + j.v(g0()) + " at path " + F());
    }

    @Override // w5.a
    public final double J() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 16) {
            this.B = 0;
            int[] iArr = this.f13742x;
            int i = this.f13739u - 1;
            iArr[i] = iArr[i] + 1;
            return this.C;
        }
        if (iN0 == 17) {
            long j5 = this.D;
            f fVar = this.A;
            fVar.getClass();
            this.E = fVar.H(j5, ie.a.f6599a);
        } else if (iN0 == 9) {
            this.E = s0(G);
        } else if (iN0 == 8) {
            this.E = s0(F);
        } else if (iN0 == 10) {
            this.E = t0();
        } else if (iN0 != 11) {
            throw new y0("Expected a double but was " + j.v(g0()) + " at path " + F());
        }
        this.B = 11;
        try {
            double d10 = Double.parseDouble(this.E);
            if (Double.isNaN(d10) || Double.isInfinite(d10)) {
                throw new c("JSON forbids NaN and infinities: " + d10 + " at path " + F());
            }
            this.E = null;
            this.B = 0;
            int[] iArr2 = this.f13742x;
            int i10 = this.f13739u - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return d10;
        } catch (NumberFormatException unused) {
            throw new y0("Expected a double but was " + this.E + " at path " + F());
        }
    }

    @Override // w5.a
    public final int K() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 16) {
            long j5 = this.C;
            int i = (int) j5;
            if (j5 == i) {
                this.B = 0;
                int[] iArr = this.f13742x;
                int i10 = this.f13739u - 1;
                iArr[i10] = iArr[i10] + 1;
                return i;
            }
            throw new y0("Expected an int but was " + this.C + " at path " + F());
        }
        if (iN0 == 17) {
            long j8 = this.D;
            f fVar = this.A;
            fVar.getClass();
            this.E = fVar.H(j8, ie.a.f6599a);
        } else if (iN0 == 9 || iN0 == 8) {
            String strS0 = iN0 == 9 ? s0(G) : s0(F);
            this.E = strS0;
            try {
                int i11 = Integer.parseInt(strS0);
                this.B = 0;
                int[] iArr2 = this.f13742x;
                int i12 = this.f13739u - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return i11;
            } catch (NumberFormatException unused) {
            }
        } else if (iN0 != 11) {
            throw new y0("Expected an int but was " + j.v(g0()) + " at path " + F());
        }
        this.B = 11;
        try {
            double d10 = Double.parseDouble(this.E);
            int i13 = (int) d10;
            if (i13 != d10) {
                throw new y0("Expected an int but was " + this.E + " at path " + F());
            }
            this.E = null;
            this.B = 0;
            int[] iArr3 = this.f13742x;
            int i14 = this.f13739u - 1;
            iArr3[i14] = iArr3[i14] + 1;
            return i13;
        } catch (NumberFormatException unused2) {
            throw new y0("Expected an int but was " + this.E + " at path " + F());
        }
    }

    @Override // w5.a
    public final String S() throws c, EOFException {
        String strH;
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 10) {
            strH = t0();
        } else if (iN0 == 9) {
            strH = s0(G);
        } else if (iN0 == 8) {
            strH = s0(F);
        } else if (iN0 == 11) {
            strH = this.E;
            this.E = null;
        } else if (iN0 == 16) {
            strH = Long.toString(this.C);
        } else {
            if (iN0 != 17) {
                throw new y0("Expected a string but was " + j.v(g0()) + " at path " + F());
            }
            long j5 = this.D;
            f fVar = this.A;
            fVar.getClass();
            strH = fVar.H(j5, ie.a.f6599a);
        }
        this.B = 0;
        int[] iArr = this.f13742x;
        int i = this.f13739u - 1;
        iArr[i] = iArr[i] + 1;
        return strH;
    }

    @Override // w5.a
    public final void a() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 3) {
            h0(1);
            this.f13742x[this.f13739u - 1] = 0;
            this.B = 0;
        } else {
            throw new y0("Expected BEGIN_ARRAY but was " + j.v(g0()) + " at path " + F());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        this.B = 0;
        this.f13740v[0] = 8;
        this.f13739u = 1;
        this.A.a();
        this.f13743z.close();
    }

    @Override // w5.a
    public final void d() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 1) {
            h0(3);
            this.B = 0;
        } else {
            throw new y0("Expected BEGIN_OBJECT but was " + j.v(g0()) + " at path " + F());
        }
    }

    @Override // w5.a
    public final int g0() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        switch (iN0) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return 2;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return 8;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
            case 15:
                return 5;
            case 16:
            case 17:
                return 7;
            case 18:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    @Override // w5.a
    public final int i0(pb.c cVar) throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 < 12 || iN0 > 15) {
            return -1;
        }
        if (iN0 == 15) {
            return o0(this.E, cVar);
        }
        int iO = this.f13743z.o((n) cVar.f10311w);
        if (iO != -1) {
            this.B = 0;
            this.f13741w[this.f13739u - 1] = ((String[]) cVar.f10310v)[iO];
            return iO;
        }
        String str = this.f13741w[this.f13739u - 1];
        String strQ0 = q0();
        int iO0 = o0(strQ0, cVar);
        if (iO0 == -1) {
            this.B = 15;
            this.E = strQ0;
            this.f13741w[this.f13739u - 1] = str;
        }
        return iO0;
    }

    @Override // w5.a
    public final void j0() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 14) {
            long jV = this.f13743z.v(H);
            f fVar = this.A;
            if (jV == -1) {
                jV = fVar.f6113v;
            }
            fVar.skip(jV);
        } else if (iN0 == 13) {
            v0(G);
        } else if (iN0 == 12) {
            v0(F);
        } else if (iN0 != 15) {
            throw new y0("Expected a name but was " + j.v(g0()) + " at path " + F());
        }
        this.B = 0;
        this.f13741w[this.f13739u - 1] = "null";
    }

    @Override // w5.a
    public final void k0() throws c, EOFException {
        int i = 0;
        do {
            int iN0 = this.B;
            if (iN0 == 0) {
                iN0 = n0();
            }
            if (iN0 == 3) {
                h0(1);
            } else if (iN0 == 1) {
                h0(3);
            } else {
                if (iN0 == 4) {
                    i--;
                    if (i < 0) {
                        throw new y0("Expected a value but was " + j.v(g0()) + " at path " + F());
                    }
                    this.f13739u--;
                } else if (iN0 == 2) {
                    i--;
                    if (i < 0) {
                        throw new y0("Expected a value but was " + j.v(g0()) + " at path " + F());
                    }
                    this.f13739u--;
                } else {
                    f fVar = this.A;
                    if (iN0 == 14 || iN0 == 10) {
                        long jV = this.f13743z.v(H);
                        if (jV == -1) {
                            jV = fVar.f6113v;
                        }
                        fVar.skip(jV);
                    } else if (iN0 == 9 || iN0 == 13) {
                        v0(G);
                    } else if (iN0 == 8 || iN0 == 12) {
                        v0(F);
                    } else if (iN0 == 17) {
                        fVar.skip(this.D);
                    } else if (iN0 == 18) {
                        throw new y0("Expected a value but was " + j.v(g0()) + " at path " + F());
                    }
                }
                this.B = 0;
            }
            i++;
            this.B = 0;
        } while (i != 0);
        int[] iArr = this.f13742x;
        int i10 = this.f13739u - 1;
        iArr[i10] = iArr[i10] + 1;
        this.f13741w[i10] = "null";
    }

    public final void m0() throws c {
        l0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x0195, code lost:
    
        if (p0(r10) != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0197, code lost:
    
        if (r1 != 2) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0199, code lost:
    
        if (r4 == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x019f, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01a1, code lost:
    
        if (r13 == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01a5, code lost:
    
        if (r8 != r17) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01a7, code lost:
    
        if (r13 != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01a9, code lost:
    
        if (r13 == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01ac, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01ad, code lost:
    
        r22.C = r8;
        r7.skip(r2);
        r9 = 16;
        r22.B = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01b8, code lost:
    
        if (r1 == 2) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01bb, code lost:
    
        if (r1 == 4) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01be, code lost:
    
        if (r1 != 7) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01c0, code lost:
    
        r22.D = r2;
        r9 = 17;
        r22.B = 17;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int n0() throws c6.c, java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.b.n0():int");
    }

    public final int o0(String str, pb.c cVar) {
        int length = ((String[]) cVar.f10310v).length;
        for (int i = 0; i < length; i++) {
            if (str.equals(((String[]) cVar.f10310v)[i])) {
                this.B = 0;
                this.f13741w[this.f13739u - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean p0(int i) throws c {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m0();
        throw null;
    }

    public final String q0() throws c, EOFException {
        String strS0;
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 == 14) {
            strS0 = t0();
        } else if (iN0 == 13) {
            strS0 = s0(G);
        } else if (iN0 == 12) {
            strS0 = s0(F);
        } else {
            if (iN0 != 15) {
                throw new y0("Expected a name but was " + j.v(g0()) + " at path " + F());
            }
            strS0 = this.E;
        }
        this.B = 0;
        this.f13741w[this.f13739u - 1] = strS0;
        return strS0;
    }

    public final int r0(boolean z2) throws c, EOFException {
        int i = 0;
        while (true) {
            int i10 = i + 1;
            q qVar = this.f13743z;
            if (!qVar.q(i10)) {
                if (z2) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            long j5 = i;
            f fVar = this.A;
            byte bX = fVar.x(j5);
            if (bX != 10 && bX != 32 && bX != 13 && bX != 9) {
                fVar.skip(j5);
                if (bX == 47) {
                    if (qVar.q(2L)) {
                        m0();
                        throw null;
                    }
                } else if (bX == 35) {
                    m0();
                    throw null;
                }
                return bX;
            }
            i = i10;
        }
    }

    public final String s0(i iVar) throws c, EOFException {
        StringBuilder sb2 = null;
        while (true) {
            long jV = this.f13743z.v(iVar);
            if (jV == -1) {
                l0("Unterminated string");
                throw null;
            }
            f fVar = this.A;
            if (fVar.x(jV) != 92) {
                if (sb2 == null) {
                    String strH = fVar.H(jV, ie.a.f6599a);
                    fVar.readByte();
                    return strH;
                }
                sb2.append(fVar.H(jV, ie.a.f6599a));
                fVar.readByte();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(fVar.H(jV, ie.a.f6599a));
            fVar.readByte();
            sb2.append(u0());
        }
    }

    public final String t0() {
        long jV = this.f13743z.v(H);
        f fVar = this.A;
        if (jV == -1) {
            return fVar.J();
        }
        fVar.getClass();
        return fVar.H(jV, ie.a.f6599a);
    }

    public final String toString() {
        return "JsonReader(" + this.f13743z + ")";
    }

    public final char u0() throws c, EOFException {
        int i;
        q qVar = this.f13743z;
        if (!qVar.q(1L)) {
            l0("Unterminated escape sequence");
            throw null;
        }
        f fVar = this.A;
        byte b10 = fVar.readByte();
        if (b10 == 10 || b10 == 34 || b10 == 39 || b10 == 47 || b10 == 92) {
            return (char) b10;
        }
        if (b10 == 98) {
            return '\b';
        }
        if (b10 == 102) {
            return '\f';
        }
        if (b10 == 110) {
            return '\n';
        }
        if (b10 == 114) {
            return '\r';
        }
        if (b10 == 116) {
            return '\t';
        }
        if (b10 != 117) {
            l0("Invalid escape sequence: \\" + ((char) b10));
            throw null;
        }
        if (!qVar.q(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + F());
        }
        char c9 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            byte bX = fVar.x(i10);
            char c10 = (char) (c9 << 4);
            if (bX >= 48 && bX <= 57) {
                i = bX - 48;
            } else if (bX >= 97 && bX <= 102) {
                i = bX - 87;
            } else {
                if (bX < 65 || bX > 70) {
                    l0("\\u".concat(fVar.H(4L, ie.a.f6599a)));
                    throw null;
                }
                i = bX - 55;
            }
            c9 = (char) (i + c10);
        }
        fVar.skip(4L);
        return c9;
    }

    @Override // w5.a
    public final void v() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 != 4) {
            throw new y0("Expected END_ARRAY but was " + j.v(g0()) + " at path " + F());
        }
        int i = this.f13739u;
        this.f13739u = i - 1;
        int[] iArr = this.f13742x;
        int i10 = i - 2;
        iArr[i10] = iArr[i10] + 1;
        this.B = 0;
    }

    public final void v0(i iVar) throws c, EOFException {
        while (true) {
            long jV = this.f13743z.v(iVar);
            if (jV == -1) {
                l0("Unterminated string");
                throw null;
            }
            f fVar = this.A;
            if (fVar.x(jV) != 92) {
                fVar.skip(jV + 1);
                return;
            } else {
                fVar.skip(jV + 1);
                u0();
            }
        }
    }

    @Override // w5.a
    public final void x() throws c, EOFException {
        int iN0 = this.B;
        if (iN0 == 0) {
            iN0 = n0();
        }
        if (iN0 != 2) {
            throw new y0("Expected END_OBJECT but was " + j.v(g0()) + " at path " + F());
        }
        int i = this.f13739u;
        int i10 = i - 1;
        this.f13739u = i10;
        this.f13741w[i10] = null;
        int[] iArr = this.f13742x;
        int i11 = i - 2;
        iArr[i11] = iArr[i11] + 1;
        this.B = 0;
    }
}
