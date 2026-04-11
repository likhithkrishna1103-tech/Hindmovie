package e4;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import l0.e;
import ua.g0;
import ua.i0;
import ua.z0;
import x3.c;
import x3.g;
import x3.o;
import x3.p;
import y1.a0;
import y1.b;
import y1.d;
import y1.h;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {
    public final float A;
    public final int B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t f3776v = new t();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f3777w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3778x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3779y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f3780z;

    public a(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f3778x = 0;
            this.f3779y = -1;
            this.f3780z = "sans-serif";
            this.f3777w = false;
            this.A = 0.85f;
            this.B = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f3778x = bArr[24];
        this.f3779y = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f3780z = "Serif".equals(new String(bArr, 43, bArr.length - 43, StandardCharsets.UTF_8)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.B = i;
        boolean z10 = (bArr[0] & 32) != 0;
        this.f3777w = z10;
        if (z10) {
            this.A = a0.h(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.A = 0.85f;
        }
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i, int i10, int i11, int i12, int i13) {
        if (i != i10) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i11, i12, i13 | 33);
        }
    }

    public static void b(SpannableStringBuilder spannableStringBuilder, int i, int i10, int i11, int i12, int i13) {
        if (i != i10) {
            int i14 = i13 | 33;
            boolean z10 = (i & 1) != 0;
            boolean z11 = (i & 2) != 0;
            if (z10) {
                if (z11) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i11, i12, i14);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i11, i12, i14);
                }
            } else if (z11) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, i14);
            }
            boolean z12 = (i & 4) != 0;
            if (z12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, i14);
            }
            if (z12 || z10 || z11) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i11, i12, i14);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x3.p
    public final void C(byte[] bArr, int i, int i10, o oVar, h hVar) {
        String strV;
        int i11;
        int i12;
        t tVar = this.f3776v;
        tVar.H(i + i10, bArr);
        tVar.J(i);
        int i13 = 1;
        int i14 = 0;
        int i15 = 2;
        d.b(tVar.a() >= 2);
        int iD = tVar.D();
        if (iD == 0) {
            strV = "";
        } else {
            int i16 = tVar.f14610b;
            Charset charsetF = tVar.F();
            int i17 = iD - (tVar.f14610b - i16);
            if (charsetF == null) {
                charsetF = StandardCharsets.UTF_8;
            }
            strV = tVar.v(i17, charsetF);
        }
        if (strV.isEmpty()) {
            g0 g0Var = i0.f12341w;
            hVar.accept(new c(-9223372036854775807L, -9223372036854775807L, z0.f12413z));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strV);
        b(spannableStringBuilder, this.f3778x, 0, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f3779y, -1, 0, spannableStringBuilder.length(), 16711680);
        int length = spannableStringBuilder.length();
        String str = this.f3780z;
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float fH = this.A;
        while (tVar.a() >= 8) {
            int i18 = tVar.f14610b;
            int iJ = tVar.j();
            int iJ2 = tVar.j();
            if (iJ2 == 1937013100) {
                d.b(tVar.a() >= i15 ? i13 : i14);
                int iD2 = tVar.D();
                int i19 = i14;
                while (i19 < iD2) {
                    d.b(tVar.a() >= 12 ? i13 : i14);
                    int iD3 = tVar.D();
                    int iD4 = tVar.D();
                    tVar.K(i15);
                    int i20 = i19;
                    int iX = tVar.x();
                    tVar.K(i13);
                    int iJ3 = tVar.j();
                    if (iD4 > spannableStringBuilder.length()) {
                        StringBuilder sbM = e.m(iD4, "Truncating styl end (", ") to cueText.length() (");
                        sbM.append(spannableStringBuilder.length());
                        sbM.append(").");
                        b.p("Tx3gParser", sbM.toString());
                        iD4 = spannableStringBuilder.length();
                    }
                    if (iD3 >= iD4) {
                        b.p("Tx3gParser", "Ignoring styl with start (" + iD3 + ") >= end (" + iD4 + ").");
                        i12 = i20;
                    } else {
                        i12 = i20;
                        int i21 = iD4;
                        b(spannableStringBuilder, iX, this.f3778x, iD3, i21, 0);
                        a(spannableStringBuilder, iJ3, this.f3779y, iD3, i21, 0);
                    }
                    i19 = i12 + 1;
                    i13 = 1;
                    i14 = 0;
                    i15 = 2;
                }
                i11 = i15;
            } else if (iJ2 == 1952608120 && this.f3777w) {
                i11 = 2;
                d.b(tVar.a() >= 2);
                fH = a0.h(tVar.D() / this.B, 0.0f, 0.95f);
            } else {
                i11 = 2;
            }
            tVar.J(i18 + iJ);
            i15 = i11;
            i13 = 1;
            i14 = 0;
        }
        hVar.accept(new c(-9223372036854775807L, -9223372036854775807L, i0.o(new x1.b(spannableStringBuilder, null, null, null, fH, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f, 0))));
    }

    @Override // x3.p
    public final int D() {
        return 2;
    }

    @Override // x3.p
    public final /* synthetic */ g r(byte[] bArr, int i, int i10) {
        return e.a(this, bArr, i10);
    }

    @Override // x3.p
    public final /* synthetic */ void reset() {
    }
}
