package r6;

import a9.l;
import ag.e;
import ag.h;
import ag.m;
import ag.q;
import java.io.EOFException;
import ka.f;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    public static final h G;
    public static final h H;
    public static final h I;
    public final q A;
    public final e B;
    public int C;
    public long D;
    public int E;
    public String F;

    static {
        h hVar = h.f430y;
        G = f.d("'\\");
        H = f.d("\"\\");
        I = f.d("{}[]:, \n\t\r\f/\\;#=");
        f.d("\n\r");
        f.d("*/");
    }

    public b(q qVar) {
        this.f10888w = new int[32];
        this.f10889x = new String[32];
        this.f10890y = new int[32];
        this.C = 0;
        this.A = qVar;
        this.B = qVar.f460w;
        e0(6);
    }

    @Override // r6.a
    public final boolean A() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        return (iL0 == 2 || iL0 == 4 || iL0 == 18) ? false : true;
    }

    @Override // r6.a
    public final boolean C() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 5) {
            this.C = 0;
            int[] iArr = this.f10890y;
            int i = this.f10887v - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iL0 == 6) {
            this.C = 0;
            int[] iArr2 = this.f10890y;
            int i10 = this.f10887v - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return false;
        }
        throw new l("Expected a boolean but was " + l0.e.u(R()) + " at path " + z());
    }

    @Override // r6.a
    public final double J() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 16) {
            this.C = 0;
            int[] iArr = this.f10890y;
            int i = this.f10887v - 1;
            iArr[i] = iArr[i] + 1;
            return this.D;
        }
        if (iL0 == 17) {
            long j4 = this.E;
            e eVar = this.B;
            eVar.getClass();
            this.F = eVar.J(j4, ne.a.f9126a);
        } else if (iL0 == 9) {
            this.F = q0(H);
        } else if (iL0 == 8) {
            this.F = q0(G);
        } else if (iL0 == 10) {
            this.F = r0();
        } else if (iL0 != 11) {
            throw new l("Expected a double but was " + l0.e.u(R()) + " at path " + z());
        }
        this.C = 11;
        try {
            double d10 = Double.parseDouble(this.F);
            if (Double.isNaN(d10) || Double.isInfinite(d10)) {
                throw new a2.a("JSON forbids NaN and infinities: " + d10 + " at path " + z());
            }
            this.F = null;
            this.C = 0;
            int[] iArr2 = this.f10890y;
            int i10 = this.f10887v - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return d10;
        } catch (NumberFormatException unused) {
            throw new l("Expected a double but was " + this.F + " at path " + z());
        }
    }

    @Override // r6.a
    public final int O() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 16) {
            long j4 = this.D;
            int i = (int) j4;
            if (j4 == i) {
                this.C = 0;
                int[] iArr = this.f10890y;
                int i10 = this.f10887v - 1;
                iArr[i10] = iArr[i10] + 1;
                return i;
            }
            throw new l("Expected an int but was " + this.D + " at path " + z());
        }
        if (iL0 == 17) {
            long j7 = this.E;
            e eVar = this.B;
            eVar.getClass();
            this.F = eVar.J(j7, ne.a.f9126a);
        } else if (iL0 == 9 || iL0 == 8) {
            String strQ0 = iL0 == 9 ? q0(H) : q0(G);
            this.F = strQ0;
            try {
                int i11 = Integer.parseInt(strQ0);
                this.C = 0;
                int[] iArr2 = this.f10890y;
                int i12 = this.f10887v - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return i11;
            } catch (NumberFormatException unused) {
            }
        } else if (iL0 != 11) {
            throw new l("Expected an int but was " + l0.e.u(R()) + " at path " + z());
        }
        this.C = 11;
        try {
            double d10 = Double.parseDouble(this.F);
            int i13 = (int) d10;
            if (i13 != d10) {
                throw new l("Expected an int but was " + this.F + " at path " + z());
            }
            this.F = null;
            this.C = 0;
            int[] iArr3 = this.f10890y;
            int i14 = this.f10887v - 1;
            iArr3[i14] = iArr3[i14] + 1;
            return i13;
        } catch (NumberFormatException unused2) {
            throw new l("Expected an int but was " + this.F + " at path " + z());
        }
    }

    @Override // r6.a
    public final String Q() throws a2.a, EOFException {
        String strJ;
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 10) {
            strJ = r0();
        } else if (iL0 == 9) {
            strJ = q0(H);
        } else if (iL0 == 8) {
            strJ = q0(G);
        } else if (iL0 == 11) {
            strJ = this.F;
            this.F = null;
        } else if (iL0 == 16) {
            strJ = Long.toString(this.D);
        } else {
            if (iL0 != 17) {
                throw new l("Expected a string but was " + l0.e.u(R()) + " at path " + z());
            }
            long j4 = this.E;
            e eVar = this.B;
            eVar.getClass();
            strJ = eVar.J(j4, ne.a.f9126a);
        }
        this.C = 0;
        int[] iArr = this.f10890y;
        int i = this.f10887v - 1;
        iArr[i] = iArr[i] + 1;
        return strJ;
    }

    @Override // r6.a
    public final int R() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        switch (iL0) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return 2;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return 8;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return 9;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
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

    @Override // r6.a
    public final void a() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 3) {
            e0(1);
            this.f10890y[this.f10887v - 1] = 0;
            this.C = 0;
        } else {
            throw new l("Expected BEGIN_ARRAY but was " + l0.e.u(R()) + " at path " + z());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        this.C = 0;
        this.f10888w[0] = 8;
        this.f10887v = 1;
        this.B.a();
        this.A.close();
    }

    @Override // r6.a
    public final void g() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 1) {
            e0(3);
            this.C = 0;
        } else {
            throw new l("Expected BEGIN_OBJECT but was " + l0.e.u(R()) + " at path " + z());
        }
    }

    @Override // r6.a
    public final int g0(w wVar) throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 < 12 || iL0 > 15) {
            return -1;
        }
        if (iL0 == 15) {
            return m0(this.F, wVar);
        }
        int iR = this.A.r((m) wVar.f9017x);
        if (iR != -1) {
            this.C = 0;
            this.f10889x[this.f10887v - 1] = ((String[]) wVar.f9016w)[iR];
            return iR;
        }
        String str = this.f10889x[this.f10887v - 1];
        String strO0 = o0();
        int iM0 = m0(strO0, wVar);
        if (iM0 == -1) {
            this.C = 15;
            this.F = strO0;
            this.f10889x[this.f10887v - 1] = str;
        }
        return iM0;
    }

    @Override // r6.a
    public final void h0() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 14) {
            long jQ = this.A.q(I);
            e eVar = this.B;
            if (jQ == -1) {
                jQ = eVar.f429w;
            }
            eVar.skip(jQ);
        } else if (iL0 == 13) {
            t0(H);
        } else if (iL0 == 12) {
            t0(G);
        } else if (iL0 != 15) {
            throw new l("Expected a name but was " + l0.e.u(R()) + " at path " + z());
        }
        this.C = 0;
        this.f10889x[this.f10887v - 1] = "null";
    }

    @Override // r6.a
    public final void i0() throws a2.a, EOFException {
        int i = 0;
        do {
            int iL0 = this.C;
            if (iL0 == 0) {
                iL0 = l0();
            }
            if (iL0 == 3) {
                e0(1);
            } else if (iL0 == 1) {
                e0(3);
            } else {
                if (iL0 == 4) {
                    i--;
                    if (i < 0) {
                        throw new l("Expected a value but was " + l0.e.u(R()) + " at path " + z());
                    }
                    this.f10887v--;
                } else if (iL0 == 2) {
                    i--;
                    if (i < 0) {
                        throw new l("Expected a value but was " + l0.e.u(R()) + " at path " + z());
                    }
                    this.f10887v--;
                } else {
                    e eVar = this.B;
                    if (iL0 == 14 || iL0 == 10) {
                        long jQ = this.A.q(I);
                        if (jQ == -1) {
                            jQ = eVar.f429w;
                        }
                        eVar.skip(jQ);
                    } else if (iL0 == 9 || iL0 == 13) {
                        t0(H);
                    } else if (iL0 == 8 || iL0 == 12) {
                        t0(G);
                    } else if (iL0 == 17) {
                        eVar.skip(this.E);
                    } else if (iL0 == 18) {
                        throw new l("Expected a value but was " + l0.e.u(R()) + " at path " + z());
                    }
                }
                this.C = 0;
            }
            i++;
            this.C = 0;
        } while (i != 0);
        int[] iArr = this.f10890y;
        int i10 = this.f10887v - 1;
        iArr[i10] = iArr[i10] + 1;
        this.f10889x[i10] = "null";
    }

    public final void k0() throws a2.a {
        j0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x0195, code lost:
    
        if (n0(r10) != false) goto L113;
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
    
        r22.D = r8;
        r7.skip(r2);
        r9 = 16;
        r22.C = 16;
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
    
        r22.E = r2;
        r9 = 17;
        r22.C = 17;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l0() throws a2.a, java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.b.l0():int");
    }

    public final int m0(String str, w wVar) {
        int length = ((String[]) wVar.f9016w).length;
        for (int i = 0; i < length; i++) {
            if (str.equals(((String[]) wVar.f9016w)[i])) {
                this.C = 0;
                this.f10889x[this.f10887v - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean n0(int i) throws a2.a {
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
        k0();
        throw null;
    }

    public final String o0() throws a2.a, EOFException {
        String strQ0;
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 == 14) {
            strQ0 = r0();
        } else if (iL0 == 13) {
            strQ0 = q0(H);
        } else if (iL0 == 12) {
            strQ0 = q0(G);
        } else {
            if (iL0 != 15) {
                throw new l("Expected a name but was " + l0.e.u(R()) + " at path " + z());
            }
            strQ0 = this.F;
        }
        this.C = 0;
        this.f10889x[this.f10887v - 1] = strQ0;
        return strQ0;
    }

    public final int p0(boolean z10) throws a2.a, EOFException {
        int i = 0;
        while (true) {
            int i10 = i + 1;
            q qVar = this.A;
            if (!qVar.o(i10)) {
                if (z10) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            long j4 = i;
            e eVar = this.B;
            byte bS = eVar.s(j4);
            if (bS != 10 && bS != 32 && bS != 13 && bS != 9) {
                eVar.skip(j4);
                if (bS == 47) {
                    if (qVar.o(2L)) {
                        k0();
                        throw null;
                    }
                } else if (bS == 35) {
                    k0();
                    throw null;
                }
                return bS;
            }
            i = i10;
        }
    }

    @Override // r6.a
    public final void q() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 != 4) {
            throw new l("Expected END_ARRAY but was " + l0.e.u(R()) + " at path " + z());
        }
        int i = this.f10887v;
        this.f10887v = i - 1;
        int[] iArr = this.f10890y;
        int i10 = i - 2;
        iArr[i10] = iArr[i10] + 1;
        this.C = 0;
    }

    public final String q0(h hVar) throws a2.a, EOFException {
        StringBuilder sb = null;
        while (true) {
            long jQ = this.A.q(hVar);
            if (jQ == -1) {
                j0("Unterminated string");
                throw null;
            }
            e eVar = this.B;
            if (eVar.s(jQ) != 92) {
                if (sb == null) {
                    String strJ = eVar.J(jQ, ne.a.f9126a);
                    eVar.readByte();
                    return strJ;
                }
                sb.append(eVar.J(jQ, ne.a.f9126a));
                eVar.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(eVar.J(jQ, ne.a.f9126a));
            eVar.readByte();
            sb.append(s0());
        }
    }

    public final String r0() {
        long jQ = this.A.q(I);
        e eVar = this.B;
        if (jQ == -1) {
            return eVar.O();
        }
        eVar.getClass();
        return eVar.J(jQ, ne.a.f9126a);
    }

    @Override // r6.a
    public final void s() throws a2.a, EOFException {
        int iL0 = this.C;
        if (iL0 == 0) {
            iL0 = l0();
        }
        if (iL0 != 2) {
            throw new l("Expected END_OBJECT but was " + l0.e.u(R()) + " at path " + z());
        }
        int i = this.f10887v;
        int i10 = i - 1;
        this.f10887v = i10;
        this.f10889x[i10] = null;
        int[] iArr = this.f10890y;
        int i11 = i - 2;
        iArr[i11] = iArr[i11] + 1;
        this.C = 0;
    }

    public final char s0() throws a2.a, EOFException {
        int i;
        q qVar = this.A;
        if (!qVar.o(1L)) {
            j0("Unterminated escape sequence");
            throw null;
        }
        e eVar = this.B;
        byte b8 = eVar.readByte();
        if (b8 == 10 || b8 == 34 || b8 == 39 || b8 == 47 || b8 == 92) {
            return (char) b8;
        }
        if (b8 == 98) {
            return '\b';
        }
        if (b8 == 102) {
            return '\f';
        }
        if (b8 == 110) {
            return '\n';
        }
        if (b8 == 114) {
            return '\r';
        }
        if (b8 == 116) {
            return '\t';
        }
        if (b8 != 117) {
            j0("Invalid escape sequence: \\" + ((char) b8));
            throw null;
        }
        if (!qVar.o(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + z());
        }
        char c9 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            byte bS = eVar.s(i10);
            char c10 = (char) (c9 << 4);
            if (bS >= 48 && bS <= 57) {
                i = bS - 48;
            } else if (bS >= 97 && bS <= 102) {
                i = bS - 87;
            } else {
                if (bS < 65 || bS > 70) {
                    j0("\\u".concat(eVar.J(4L, ne.a.f9126a)));
                    throw null;
                }
                i = bS - 55;
            }
            c9 = (char) (i + c10);
        }
        eVar.skip(4L);
        return c9;
    }

    public final void t0(h hVar) throws a2.a, EOFException {
        while (true) {
            long jQ = this.A.q(hVar);
            if (jQ == -1) {
                j0("Unterminated string");
                throw null;
            }
            e eVar = this.B;
            if (eVar.s(jQ) != 92) {
                eVar.skip(jQ + 1);
                return;
            } else {
                eVar.skip(jQ + 1);
                s0();
            }
        }
    }

    public final String toString() {
        return "JsonReader(" + this.A + ")";
    }
}
