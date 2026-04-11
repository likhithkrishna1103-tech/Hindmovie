package c4;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l0.e;
import ua.i0;
import x3.c;
import x3.g;
import x3.o;
import x3.p;
import y1.b;
import y1.h;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f2094y = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f2095z = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final StringBuilder f2096v = new StringBuilder();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f2097w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final t f2098x = new t();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x1.b a(android.text.Spanned r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.a.a(android.text.Spanned, java.lang.String):x1.b");
    }

    public static long b(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j4 = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        strGroup2.getClass();
        long j7 = (Long.parseLong(strGroup2) * 60000) + j4;
        String strGroup3 = matcher.group(i + 3);
        strGroup3.getClass();
        long j10 = (Long.parseLong(strGroup3) * 1000) + j7;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j10 += Long.parseLong(strGroup4);
        }
        return j10 * 1000;
    }

    @Override // x3.p
    public final void C(byte[] bArr, int i, int i10, o oVar, h hVar) {
        String strK;
        String str;
        a aVar = this;
        long j4 = oVar.f14315a;
        t tVar = aVar.f2098x;
        tVar.H(i + i10, bArr);
        tVar.J(i);
        Charset charsetF = tVar.F();
        if (charsetF == null) {
            charsetF = StandardCharsets.UTF_8;
        }
        long j7 = -9223372036854775807L;
        ArrayList arrayList = (j4 == -9223372036854775807L || !oVar.f14316b) ? null : new ArrayList();
        while (true) {
            String strK2 = tVar.k(charsetF);
            if (strK2 == null) {
                break;
            }
            if (!strK2.isEmpty()) {
                try {
                    Integer.parseInt(strK2);
                    strK = tVar.k(charsetF);
                } catch (NumberFormatException unused) {
                    b.p("SubripParser", "Skipping invalid index: ".concat(strK2));
                }
                if (strK == null) {
                    b.p("SubripParser", "Unexpected end");
                    break;
                }
                Matcher matcher = f2094y.matcher(strK);
                if (matcher.matches()) {
                    long jB = b(matcher, 1);
                    long jB2 = b(matcher, 6);
                    StringBuilder sb = aVar.f2096v;
                    sb.setLength(0);
                    long j10 = j7;
                    ArrayList arrayList2 = aVar.f2097w;
                    arrayList2.clear();
                    for (String strK3 = tVar.k(charsetF); !TextUtils.isEmpty(strK3); strK3 = tVar.k(charsetF)) {
                        if (sb.length() > 0) {
                            sb.append("<br>");
                        }
                        String strTrim = strK3.trim();
                        StringBuilder sb2 = new StringBuilder(strTrim);
                        Matcher matcher2 = f2095z.matcher(strTrim);
                        int i11 = 0;
                        while (matcher2.find()) {
                            String strGroup = matcher2.group();
                            arrayList2.add(strGroup);
                            int iStart = matcher2.start() - i11;
                            int length = strGroup.length();
                            sb2.replace(iStart, iStart + length, "");
                            i11 += length;
                            j4 = j4;
                        }
                        sb.append(sb2.toString());
                    }
                    long j11 = j4;
                    Spanned spannedFromHtml = Html.fromHtml(sb.toString());
                    int i12 = 0;
                    while (true) {
                        if (i12 >= arrayList2.size()) {
                            str = null;
                            break;
                        }
                        str = (String) arrayList2.get(i12);
                        if (str.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                    if (j11 == j10 || jB2 >= j11) {
                        hVar.accept(new c(jB, jB2 - jB, i0.o(a(spannedFromHtml, str))));
                    } else if (arrayList != null) {
                        arrayList.add(new c(jB, jB2 - jB, i0.o(a(spannedFromHtml, str))));
                    }
                    aVar = this;
                    j7 = j10;
                    j4 = j11;
                } else {
                    b.p("SubripParser", "Skipping invalid timing: ".concat(strK));
                    aVar = this;
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList.get(i13);
                i13++;
                hVar.accept((c) obj);
            }
        }
    }

    @Override // x3.p
    public final int D() {
        return 1;
    }

    @Override // x3.p
    public final /* synthetic */ g r(byte[] bArr, int i, int i10) {
        return e.a(this, bArr, i10);
    }

    @Override // x3.p
    public final /* synthetic */ void reset() {
    }
}
