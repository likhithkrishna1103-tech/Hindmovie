package y3;

import aa.j0;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import e6.j;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import s1.b;
import s1.h;
import s1.u;
import t3.d;
import t3.l;
import t3.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements m {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f14516x = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f14517y = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final StringBuilder f14518u = new StringBuilder();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f14519v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f14520w = new u();

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
    public static r1.b a(android.text.Spanned r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.a.a(android.text.Spanned, java.lang.String):r1.b");
    }

    public static long b(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j5 = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        strGroup2.getClass();
        long j8 = (Long.parseLong(strGroup2) * 60000) + j5;
        String strGroup3 = matcher.group(i + 3);
        strGroup3.getClass();
        long j10 = (Long.parseLong(strGroup3) * 1000) + j8;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j10 += Long.parseLong(strGroup4);
        }
        return j10 * 1000;
    }

    @Override // t3.m
    public final /* synthetic */ d h(byte[] bArr, int i, int i10) {
        return j.a(this, bArr, i10);
    }

    @Override // t3.m
    public final int m() {
        return 1;
    }

    @Override // t3.m
    public final void n(byte[] bArr, int i, int i10, l lVar, h hVar) {
        String strK;
        String str;
        a aVar = this;
        long j5 = lVar.f12094a;
        u uVar = aVar.f14520w;
        uVar.H(i + i10, bArr);
        uVar.J(i);
        Charset charsetF = uVar.F();
        if (charsetF == null) {
            charsetF = StandardCharsets.UTF_8;
        }
        long j8 = -9223372036854775807L;
        ArrayList arrayList = (j5 == -9223372036854775807L || !lVar.f12095b) ? null : new ArrayList();
        while (true) {
            String strK2 = uVar.k(charsetF);
            if (strK2 == null) {
                break;
            }
            if (!strK2.isEmpty()) {
                try {
                    Integer.parseInt(strK2);
                    strK = uVar.k(charsetF);
                } catch (NumberFormatException unused) {
                    b.p("SubripParser", "Skipping invalid index: ".concat(strK2));
                }
                if (strK == null) {
                    b.p("SubripParser", "Unexpected end");
                    break;
                }
                Matcher matcher = f14516x.matcher(strK);
                if (matcher.matches()) {
                    long jB = b(matcher, 1);
                    long jB2 = b(matcher, 6);
                    StringBuilder sb2 = aVar.f14518u;
                    sb2.setLength(0);
                    long j10 = j8;
                    ArrayList arrayList2 = aVar.f14519v;
                    arrayList2.clear();
                    for (String strK3 = uVar.k(charsetF); !TextUtils.isEmpty(strK3); strK3 = uVar.k(charsetF)) {
                        if (sb2.length() > 0) {
                            sb2.append("<br>");
                        }
                        String strTrim = strK3.trim();
                        StringBuilder sb3 = new StringBuilder(strTrim);
                        Matcher matcher2 = f14517y.matcher(strTrim);
                        int i11 = 0;
                        while (matcher2.find()) {
                            String strGroup = matcher2.group();
                            arrayList2.add(strGroup);
                            int iStart = matcher2.start() - i11;
                            int length = strGroup.length();
                            sb3.replace(iStart, iStart + length, "");
                            i11 += length;
                            j5 = j5;
                        }
                        sb2.append(sb3.toString());
                    }
                    long j11 = j5;
                    Spanned spannedFromHtml = Html.fromHtml(sb2.toString());
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
                        hVar.accept(new t3.a(jB, jB2 - jB, j0.v(a(spannedFromHtml, str))));
                    } else if (arrayList != null) {
                        arrayList.add(new t3.a(jB, jB2 - jB, j0.v(a(spannedFromHtml, str))));
                    }
                    aVar = this;
                    j8 = j10;
                    j5 = j11;
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
                hVar.accept((t3.a) obj);
            }
        }
    }

    @Override // t3.m
    public final /* synthetic */ void reset() {
    }
}
