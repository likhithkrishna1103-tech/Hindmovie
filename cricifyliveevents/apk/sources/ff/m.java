package ff;

import a3.a0;
import a3.k0;
import a3.l0;
import a3.r;
import android.opengl.GLES20;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import f9.s0;
import h4.b0;
import h4.e0;
import h4.g0;
import java.util.ArrayList;
import java.util.HashMap;
import v4.x0;
import y1.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class m implements b0 {
    public Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4599w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f4600x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f4601y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f4602z;

    public m(kf.i iVar) {
        this.f4598v = 3;
        this.f4599w = 0;
        this.f4600x = iVar;
        this.f4601y = new s0(8);
        this.f4602z = new ArrayList();
    }

    public static void a(int i, int i10, String str) throws y1.k {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        y1.b.d(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: \n" + str, iArr[0] == 1);
        GLES20.glAttachShader(i, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        y1.b.c();
    }

    public static /* synthetic */ void q(m mVar, String str, int i, int i10) {
        if ((i10 & 2) != 0) {
            i = mVar.f4599w;
        }
        mVar.p(i, str, (i10 & 4) != 0 ? "" : "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'");
        throw null;
    }

    public int A(int i) {
        if (i < ((String) this.f4602z).length()) {
            return i;
        }
        return -1;
    }

    public int B() {
        char cCharAt;
        int i = this.f4599w;
        if (i == -1) {
            return i;
        }
        String str = (String) this.f4602z;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i++;
        }
        this.f4599w = i;
        return i;
    }

    public boolean C() {
        int iB = B();
        String str = (String) this.f4602z;
        if (iB >= str.length() || iB == -1 || str.charAt(iB) != ',') {
            return false;
        }
        this.f4599w++;
        return true;
    }

    public void D(char c9) {
        int i = this.f4599w;
        if (i > 0 && c9 == '\"') {
            try {
                this.f4599w = i - 1;
                String strM = m();
                this.f4599w = i;
                if (ge.i.a(strM, "null")) {
                    p(this.f4599w - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f4599w = i;
                throw th;
            }
        }
        r(i.b(c9), true);
        throw null;
    }

    public void E(View view) {
        if (((ArrayList) this.f4602z).remove(view)) {
            kf.i iVar = (kf.i) this.f4600x;
            x0 x0VarM = RecyclerView.M(view);
            if (x0VarM != null) {
                RecyclerView recyclerView = (RecyclerView) iVar.f7483w;
                int i = x0VarM.f13400p;
                if (recyclerView.P()) {
                    x0VarM.f13401q = i;
                    recyclerView.O0.add(x0VarM);
                } else {
                    x0VarM.f13387a.setImportantForAccessibility(i);
                }
                x0VarM.f13400p = 0;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    @Override // h4.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(y1.t r38) {
        /*
            Method dump skipped, instruction units count: 761
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ff.m.b(y1.t):void");
    }

    public void d(View view, int i, boolean z10) {
        RecyclerView recyclerView = (RecyclerView) ((kf.i) this.f4600x).f7483w;
        int childCount = i < 0 ? recyclerView.getChildCount() : w(i);
        ((s0) this.f4601y).H(childCount, z10);
        if (z10) {
            z(view);
        }
        recyclerView.addView(view, childCount);
        RecyclerView.M(view);
    }

    public int e(CharSequence charSequence, int i) {
        int i10 = i + 4;
        if (i10 < charSequence.length()) {
            ((StringBuilder) this.A).append((char) (s(charSequence, i + 3) + (s(charSequence, i) << 12) + (s(charSequence, i + 1) << 8) + (s(charSequence, i + 2) << 4)));
            return i10;
        }
        this.f4599w = i;
        if (i10 < charSequence.length()) {
            return e(charSequence, this.f4599w);
        }
        q(this, "Unexpected EOF during unicode escape", 0, 6);
        throw null;
    }

    public void f(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z10) {
        RecyclerView recyclerView = (RecyclerView) ((kf.i) this.f4600x).f7483w;
        int childCount = i < 0 ? recyclerView.getChildCount() : w(i);
        ((s0) this.f4601y).H(childCount, z10);
        if (z10) {
            z(view);
        }
        x0 x0VarM = RecyclerView.M(view);
        if (x0VarM != null) {
            if (!x0VarM.j() && !x0VarM.o()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(x0VarM);
                throw new IllegalArgumentException(l0.e.i(recyclerView, sb));
            }
            if (RecyclerView.X0) {
                Log.d("RecyclerView", "reAttach " + x0VarM);
            }
            x0VarM.f13394j &= -257;
        } else if (RecyclerView.W0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(l0.e.i(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public boolean g() {
        int i = this.f4599w;
        if (i == -1) {
            return false;
        }
        String str = (String) this.f4602z;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f4599w = i;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i++;
        }
        this.f4599w = i;
        return false;
    }

    public void h(int i, String str) {
        String str2 = (String) this.f4602z;
        if (str2.length() - i < str.length()) {
            q(this, "Unexpected end of boolean literal", 0, 6);
            throw null;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) != (str2.charAt(i + i10) | ' ')) {
                q(this, "Expected valid boolean literal prefix, but had '" + m() + '\'', 0, 6);
                throw null;
            }
        }
        this.f4599w = str.length() + i;
    }

    public String i() {
        StringBuilder sb = (StringBuilder) this.A;
        String str = (String) this.f4602z;
        j('\"');
        int i = this.f4599w;
        int iH0 = ne.h.h0(str, '\"', i, 4);
        if (iH0 == -1) {
            m();
            r((byte) 1, false);
            throw null;
        }
        int i10 = i;
        while (i10 < iH0) {
            if (str.charAt(i10) == '\\') {
                int iA = this.f4599w;
                char cCharAt = str.charAt(i10);
                boolean z10 = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        sb.append((CharSequence) str, iA, i10);
                        int iA2 = A(i10 + 1);
                        if (iA2 == -1) {
                            q(this, "Expected escape sequence to continue, got EOF", 0, 6);
                            throw null;
                        }
                        int iE = iA2 + 1;
                        char cCharAt2 = str.charAt(iA2);
                        if (cCharAt2 == 'u') {
                            iE = e(str, iE);
                        } else {
                            char c9 = cCharAt2 < 'u' ? c.f4577a[cCharAt2] : (char) 0;
                            if (c9 == 0) {
                                q(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, 6);
                                throw null;
                            }
                            sb.append(c9);
                        }
                        iA = A(iE);
                        if (iA == -1) {
                            q(this, "Unexpected EOF", iA, 4);
                            throw null;
                        }
                    } else {
                        i10++;
                        if (i10 >= str.length()) {
                            sb.append((CharSequence) str, iA, i10);
                            iA = A(i10);
                            if (iA == -1) {
                                q(this, "Unexpected EOF", iA, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = str.charAt(i10);
                        }
                    }
                    i10 = iA;
                    z10 = true;
                    cCharAt = str.charAt(i10);
                }
                String string = !z10 ? str.subSequence(iA, i10).toString() : n(iA, i10);
                this.f4599w = i10 + 1;
                return string;
            }
            i10++;
        }
        this.f4599w = iH0 + 1;
        String strSubstring = str.substring(i, iH0);
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public void j(char c9) {
        int i = this.f4599w;
        if (i == -1) {
            D(c9);
            throw null;
        }
        String str = (String) this.f4602z;
        while (i < str.length()) {
            int i10 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f4599w = i10;
                if (cCharAt == c9) {
                    return;
                }
                D(c9);
                throw null;
            }
            i = i10;
        }
        this.f4599w = -1;
        D(c9);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0185, code lost:
    
        throw new a9.l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0186, code lost:
    
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0187, code lost:
    
        if (r14 == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0189, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x018e, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0191, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0192, code lost:
    
        q(r22, "Numeric value overflow", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0197, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0198, code lost:
    
        q(r22, "Expected numeric literal", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x019d, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
    
        q(r22, "Unexpected symbol '" + r5 + "' in numeric literal", r7, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0100, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0101, code lost:
    
        if (r12 == r1) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0103, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0105, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0106, code lost:
    
        if (r1 == r12) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0108, code lost:
    
        if (r14 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
    
        if (r1 == (r12 - 1)) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0113, code lost:
    
        if (r3 == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0115, code lost:
    
        if (r5 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x011d, code lost:
    
        if (r2.charAt(r12) != '\"') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x011f, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0122, code lost:
    
        q(r22, "Expected closing quotation mark", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0129, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012a, code lost:
    
        q(r22, "EOF", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012f, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0130, code lost:
    
        r22.f4599w = r12;
        r1 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0134, code lost:
    
        if (r13 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0136, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0139, code lost:
    
        if (r11 != 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013b, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0143, code lost:
    
        if (r11 != 1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0145, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014a, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x014f, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0155, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x015d, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x015f, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0161, code lost:
    
        q(r22, "Can't convert " + r1 + " to Long", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0179, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x017a, code lost:
    
        q(r22, "Numeric value overflow", 0, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x017f, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long k() {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ff.m.k():long");
    }

    public String l() {
        String str = (String) this.f4601y;
        if (str == null) {
            return i();
        }
        ge.i.b(str);
        this.f4601y = null;
        return str;
    }

    public String m() {
        String str = (String) this.f4602z;
        String str2 = (String) this.f4601y;
        if (str2 != null) {
            ge.i.b(str2);
            this.f4601y = null;
            return str2;
        }
        int iB = B();
        if (iB >= str.length() || iB == -1) {
            q(this, "EOF", iB, 4);
            throw null;
        }
        byte b8 = i.b(str.charAt(iB));
        if (b8 == 1) {
            return l();
        }
        if (b8 != 0) {
            q(this, "Expected beginning of the string, but got " + str.charAt(iB), 0, 6);
            throw null;
        }
        boolean z10 = false;
        while (i.b(str.charAt(iB)) == 0) {
            iB++;
            if (iB >= str.length()) {
                ((StringBuilder) this.A).append((CharSequence) str, this.f4599w, iB);
                int iA = A(iB);
                if (iA == -1) {
                    this.f4599w = iB;
                    return n(0, 0);
                }
                iB = iA;
                z10 = true;
            }
        }
        String string = !z10 ? str.subSequence(this.f4599w, iB).toString() : n(this.f4599w, iB);
        this.f4599w = iB;
        return string;
    }

    public String n(int i, int i10) {
        StringBuilder sb = (StringBuilder) this.A;
        sb.append((CharSequence) this.f4602z, i, i10);
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        sb.setLength(0);
        return string;
    }

    public void o(int i) {
        int iW = w(i);
        ((s0) this.f4601y).J(iW);
        RecyclerView recyclerView = (RecyclerView) ((kf.i) this.f4600x).f7483w;
        View childAt = recyclerView.getChildAt(iW);
        if (childAt != null) {
            x0 x0VarM = RecyclerView.M(childAt);
            if (x0VarM != null) {
                if (x0VarM.j() && !x0VarM.o()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(x0VarM);
                    throw new IllegalArgumentException(l0.e.i(recyclerView, sb));
                }
                if (RecyclerView.X0) {
                    Log.d("RecyclerView", "tmpDetach " + x0VarM);
                }
                x0VarM.a(256);
            }
        } else if (RecyclerView.W0) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(iW);
            throw new IllegalArgumentException(l0.e.i(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(iW);
    }

    public void p(int i, String str, String str2) {
        ge.i.e(str, "message");
        ge.i.e(str2, "hint");
        String str3 = str + " at path: " + ((f3.a) this.f4600x).l() + (str2.length() == 0 ? "" : "\n".concat(str2));
        String str4 = (String) this.f4602z;
        ge.i.e(str3, "message");
        ge.i.e(str4, "input");
        String str5 = str3 + "\nJSON input: " + ((Object) i.d(str4, i));
        ge.i.e(str5, "message");
        if (i >= 0) {
            str5 = "Unexpected JSON token at offset " + i + ": " + str5;
        }
        ge.i.e(str5, "message");
        throw new d(str5);
    }

    public void r(byte b8, boolean z10) {
        String str = (String) this.f4602z;
        String str2 = b8 == 1 ? "quotation mark '\"'" : b8 == 2 ? "string escape sequence '\\'" : b8 == 4 ? "comma ','" : b8 == 5 ? "colon ':'" : b8 == 6 ? "start of the object '{'" : b8 == 7 ? "end of the object '}'" : b8 == 8 ? "start of the array '['" : b8 == 9 ? "end of the array ']'" : b8 == 10 ? "end of the input" : b8 == 127 ? "invalid token" : "valid token";
        int i = z10 ? this.f4599w - 1 : this.f4599w;
        q(this, "Expected " + str2 + ", but had '" + ((this.f4599w == str.length() || i < 0) ? "EOF" : String.valueOf(str.charAt(i))) + "' instead", i, 4);
        throw null;
    }

    public int s(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        q(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, 6);
        throw null;
    }

    public int t(String str) throws y1.k {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f4599w, str);
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        y1.b.c();
        return iGlGetAttribLocation;
    }

    public String toString() {
        switch (this.f4598v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append(this.f4602z);
                sb.append("', currentPosition=");
                sb.append(this.f4599w);
                sb.append(')');
                return sb.toString();
            case 3:
                return ((s0) this.f4601y).toString() + ", hidden list:" + ((ArrayList) this.f4602z).size();
            default:
                return super.toString();
        }
    }

    public View u(int i) {
        return ((RecyclerView) ((kf.i) this.f4600x).f7483w).getChildAt(w(i));
    }

    public int v() {
        return ((RecyclerView) ((kf.i) this.f4600x).f7483w).getChildCount() - ((ArrayList) this.f4602z).size();
    }

    public int w(int i) {
        s0 s0Var = (s0) this.f4601y;
        if (i < 0) {
            return -1;
        }
        int childCount = ((RecyclerView) ((kf.i) this.f4600x).f7483w).getChildCount();
        int i10 = i;
        while (i10 < childCount) {
            int iD = i - (i10 - s0Var.D(i10));
            if (iD == 0) {
                while (s0Var.G(i10)) {
                    i10++;
                }
                return i10;
            }
            i10 += iD;
        }
        return -1;
    }

    public View x(int i) {
        return ((RecyclerView) ((kf.i) this.f4600x).f7483w).getChildAt(i);
    }

    public int y() {
        return ((RecyclerView) ((kf.i) this.f4600x).f7483w).getChildCount();
    }

    public void z(View view) {
        ((ArrayList) this.f4602z).add(view);
        kf.i iVar = (kf.i) this.f4600x;
        x0 x0VarM = RecyclerView.M(view);
        if (x0VarM != null) {
            View view2 = x0VarM.f13387a;
            RecyclerView recyclerView = (RecyclerView) iVar.f7483w;
            int i = x0VarM.f13401q;
            if (i != -1) {
                x0VarM.f13400p = i;
            } else {
                x0VarM.f13400p = view2.getImportantForAccessibility();
            }
            if (!recyclerView.P()) {
                view2.setImportantForAccessibility(4);
            } else {
                x0VarM.f13401q = 4;
                recyclerView.O0.add(x0VarM);
            }
        }
    }

    public m(String str, String str2) throws y1.k {
        this.f4598v = 4;
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f4599w = iGlCreateProgram;
        y1.b.c();
        a(iGlCreateProgram, 35633, str);
        a(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        y1.b.d("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram), iArr[0] == 1);
        GLES20.glUseProgram(iGlCreateProgram);
        this.f4602z = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f4600x = new x3.a[iArr2[0]];
        for (int i = 0; i < iArr2[0]; i++) {
            int i10 = this.f4599w;
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(i10, 35722, iArr3, 0);
            int i11 = iArr3[0];
            byte[] bArr = new byte[i11];
            GLES20.glGetActiveAttrib(i10, i, i11, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                if (bArr[i12] == 0) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
            String str3 = new String(bArr, 0, i11);
            GLES20.glGetAttribLocation(i10, str3);
            x3.a aVar = new x3.a();
            ((x3.a[]) this.f4600x)[i] = aVar;
            ((HashMap) this.f4602z).put(str3, aVar);
        }
        this.A = new HashMap();
        int[] iArr4 = new int[1];
        GLES20.glGetProgramiv(this.f4599w, 35718, iArr4, 0);
        this.f4601y = new x3.b[iArr4[0]];
        for (int i13 = 0; i13 < iArr4[0]; i13++) {
            int i14 = this.f4599w;
            int[] iArr5 = new int[1];
            GLES20.glGetProgramiv(i14, 35719, iArr5, 0);
            int i15 = iArr5[0];
            byte[] bArr2 = new byte[i15];
            GLES20.glGetActiveUniform(i14, i13, i15, new int[1], 0, new int[1], 0, new int[1], 0, bArr2, 0);
            int i16 = 0;
            while (true) {
                if (i16 >= i15) {
                    break;
                }
                if (bArr2[i16] == 0) {
                    i15 = i16;
                    break;
                }
                i16++;
            }
            String str4 = new String(bArr2, 0, i15);
            GLES20.glGetUniformLocation(i14, str4);
            x3.b bVar = new x3.b();
            ((x3.b[]) this.f4601y)[i13] = bVar;
            ((HashMap) this.A).put(str4, bVar);
        }
        y1.b.c();
    }

    public m(String str) {
        this.f4598v = 0;
        ge.i.e(str, "source");
        f3.a aVar = new f3.a();
        aVar.f3936x = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        aVar.f3937y = iArr;
        aVar.f3935w = -1;
        this.f4600x = aVar;
        this.A = new StringBuilder();
        this.f4602z = str;
    }

    public m(a0 a0Var, pc.c cVar, byte[] bArr, l0[] l0VarArr, int i) {
        this.f4598v = 2;
        this.f4600x = a0Var;
        this.f4601y = cVar;
        this.f4602z = bArr;
        this.A = l0VarArr;
        this.f4599w = i;
    }

    public m(e0 e0Var, int i) {
        this.f4598v = 1;
        this.A = e0Var;
        this.f4600x = new k0(5, new byte[5]);
        this.f4601y = new SparseArray();
        this.f4602z = new SparseIntArray();
        this.f4599w = i;
    }

    @Override // h4.b0
    public void c(y yVar, r rVar, g0 g0Var) {
    }
}
