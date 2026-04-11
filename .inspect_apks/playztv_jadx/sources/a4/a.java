package a4;

import aa.c1;
import aa.h0;
import aa.j0;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import e6.j;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import s1.b;
import s1.b0;
import s1.h;
import s1.u;
import t3.d;
import t3.l;
import t3.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements m {
    public final int A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u f533u = new u();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f534v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f535w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f536x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f537y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f538z;

    public a(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f535w = 0;
            this.f536x = -1;
            this.f537y = "sans-serif";
            this.f534v = false;
            this.f538z = 0.85f;
            this.A = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f535w = bArr[24];
        this.f536x = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f537y = "Serif".equals(new String(bArr, 43, bArr.length - 43, StandardCharsets.UTF_8)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.A = i;
        boolean z2 = (bArr[0] & 32) != 0;
        this.f534v = z2;
        if (z2) {
            this.f538z = b0.h(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.f538z = 0.85f;
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
            boolean z2 = (i & 1) != 0;
            boolean z10 = (i & 2) != 0;
            if (z2) {
                if (z10) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i11, i12, i14);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i11, i12, i14);
                }
            } else if (z10) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, i14);
            }
            boolean z11 = (i & 4) != 0;
            if (z11) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, i14);
            }
            if (z11 || z2 || z10) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i11, i12, i14);
        }
    }

    @Override // t3.m
    public final /* synthetic */ d h(byte[] bArr, int i, int i10) {
        return j.a(this, bArr, i10);
    }

    @Override // t3.m
    public final int m() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t3.m
    public final void n(byte[] bArr, int i, int i10, l lVar, h hVar) {
        String strV;
        int i11;
        int i12;
        u uVar = this.f533u;
        uVar.H(i + i10, bArr);
        uVar.J(i);
        int i13 = 1;
        int i14 = 0;
        int i15 = 2;
        s1.d.b(uVar.a() >= 2);
        int iD = uVar.D();
        if (iD == 0) {
            strV = "";
        } else {
            int i16 = uVar.f11710b;
            Charset charsetF = uVar.F();
            int i17 = iD - (uVar.f11710b - i16);
            if (charsetF == null) {
                charsetF = StandardCharsets.UTF_8;
            }
            strV = uVar.v(i17, charsetF);
        }
        if (strV.isEmpty()) {
            h0 h0Var = j0.f690v;
            hVar.accept(new t3.a(-9223372036854775807L, -9223372036854775807L, c1.f650y));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strV);
        b(spannableStringBuilder, this.f535w, 0, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f536x, -1, 0, spannableStringBuilder.length(), 16711680);
        int length = spannableStringBuilder.length();
        String str = this.f537y;
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float fH = this.f538z;
        while (uVar.a() >= 8) {
            int i18 = uVar.f11710b;
            int iJ = uVar.j();
            int iJ2 = uVar.j();
            if (iJ2 == 1937013100) {
                s1.d.b(uVar.a() >= i15 ? i13 : i14);
                int iD2 = uVar.D();
                int i19 = i14;
                while (i19 < iD2) {
                    s1.d.b(uVar.a() >= 12 ? i13 : i14);
                    int iD3 = uVar.D();
                    int iD4 = uVar.D();
                    uVar.K(i15);
                    int i20 = i19;
                    int iX = uVar.x();
                    uVar.K(i13);
                    int iJ3 = uVar.j();
                    if (iD4 > spannableStringBuilder.length()) {
                        b.p("Tx3gParser", "Truncating styl end (" + iD4 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
                        iD4 = spannableStringBuilder.length();
                    }
                    if (iD3 >= iD4) {
                        b.p("Tx3gParser", "Ignoring styl with start (" + iD3 + ") >= end (" + iD4 + ").");
                        i12 = i20;
                    } else {
                        i12 = i20;
                        int i21 = iD4;
                        b(spannableStringBuilder, iX, this.f535w, iD3, i21, 0);
                        a(spannableStringBuilder, iJ3, this.f536x, iD3, i21, 0);
                    }
                    i19 = i12 + 1;
                    i13 = 1;
                    i14 = 0;
                    i15 = 2;
                }
                i11 = i15;
            } else if (iJ2 == 1952608120 && this.f534v) {
                i11 = 2;
                s1.d.b(uVar.a() >= 2);
                fH = b0.h(uVar.D() / this.A, 0.0f, 0.95f);
            } else {
                i11 = 2;
            }
            uVar.J(i18 + iJ);
            i15 = i11;
            i13 = 1;
            i14 = 0;
        }
        hVar.accept(new t3.a(-9223372036854775807L, -9223372036854775807L, j0.v(new r1.b(spannableStringBuilder, null, null, null, fH, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f, 0))));
    }

    @Override // t3.m
    public final /* synthetic */ void reset() {
    }
}
