package kf;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f7493k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f7494l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f7495m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f7496n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7501e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7503h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f7504j;

    public l(String str, String str2, long j4, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, String str5) {
        this.f7497a = str;
        this.f7498b = str2;
        this.f7499c = j4;
        this.f7500d = str3;
        this.f7501e = str4;
        this.f = z10;
        this.f7502g = z11;
        this.f7503h = z12;
        this.i = z13;
        this.f7504j = str5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return ge.i.a(lVar.f7497a, this.f7497a) && ge.i.a(lVar.f7498b, this.f7498b) && lVar.f7499c == this.f7499c && ge.i.a(lVar.f7500d, this.f7500d) && ge.i.a(lVar.f7501e, this.f7501e) && lVar.f == this.f && lVar.f7502g == this.f7502g && lVar.f7503h == this.f7503h && lVar.i == this.i && ge.i.a(lVar.f7504j, this.f7504j);
    }

    public final int hashCode() {
        int iE = l0.e.e(l0.e.e(527, 31, this.f7497a), 31, this.f7498b);
        long j4 = this.f7499c;
        int iE2 = (((((((l0.e.e(l0.e.e((iE + ((int) (j4 ^ (j4 >>> 32)))) * 31, 31, this.f7500d), 31, this.f7501e) + (this.f ? 1231 : 1237)) * 31) + (this.f7502g ? 1231 : 1237)) * 31) + (this.f7503h ? 1231 : 1237)) * 31) + (this.i ? 1231 : 1237)) * 31;
        String str = this.f7504j;
        return iE2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7497a);
        sb.append('=');
        sb.append(this.f7498b);
        if (this.f7503h) {
            long j4 = this.f7499c;
            if (j4 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String str = ((DateFormat) pf.d.f10295a.get()).format(new Date(j4));
                ge.i.d(str, "format(...)");
                sb.append(str);
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            sb.append(this.f7500d);
        }
        sb.append("; path=");
        sb.append(this.f7501e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.f7502g) {
            sb.append("; httponly");
        }
        String str2 = this.f7504j;
        if (str2 != null) {
            sb.append("; samesite=");
            sb.append(str2);
        }
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }
}
