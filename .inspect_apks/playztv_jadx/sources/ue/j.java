package ue;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f12981j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f12982k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f12983l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f12984m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12989e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f12990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12991h;
    public final boolean i;

    public j(String str, String str2, long j5, String str3, String str4, boolean z2, boolean z10, boolean z11, boolean z12) {
        this.f12985a = str;
        this.f12986b = str2;
        this.f12987c = j5;
        this.f12988d = str3;
        this.f12989e = str4;
        this.f = z2;
        this.f12990g = z10;
        this.f12991h = z11;
        this.i = z12;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return be.h.a(jVar.f12985a, this.f12985a) && be.h.a(jVar.f12986b, this.f12986b) && jVar.f12987c == this.f12987c && be.h.a(jVar.f12988d, this.f12988d) && be.h.a(jVar.f12989e, this.f12989e) && jVar.f == this.f && jVar.f12990g == this.f12990g && jVar.f12991h == this.f12991h && jVar.i == this.i;
    }

    public final int hashCode() {
        int iH = e6.j.h(e6.j.h(527, 31, this.f12985a), 31, this.f12986b);
        long j5 = this.f12987c;
        return ((((((e6.j.h(e6.j.h((iH + ((int) (j5 ^ (j5 >>> 32)))) * 31, 31, this.f12988d), 31, this.f12989e) + (this.f ? 1231 : 1237)) * 31) + (this.f12990g ? 1231 : 1237)) * 31) + (this.f12991h ? 1231 : 1237)) * 31) + (this.i ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12985a);
        sb2.append('=');
        sb2.append(this.f12986b);
        if (this.f12991h) {
            long j5 = this.f12987c;
            if (j5 == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                String str = ((DateFormat) ze.c.f14966a.get()).format(new Date(j5));
                be.h.d(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb2.append(str);
            }
        }
        if (!this.i) {
            sb2.append("; domain=");
            sb2.append(this.f12988d);
        }
        sb2.append("; path=");
        sb2.append(this.f12989e);
        if (this.f) {
            sb2.append("; secure");
        }
        if (this.f12990g) {
            sb2.append("; httponly");
        }
        String string = sb2.toString();
        be.h.d(string, "toString()");
        return string;
    }
}
