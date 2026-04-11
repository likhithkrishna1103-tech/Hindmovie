package a7;

import c7.m;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f613e;
    public static final a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f615b;

    static {
        String strH = android.support.v4.media.session.b.H("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f611c = strH;
        String strH2 = android.support.v4.media.session.b.H("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String strH3 = android.support.v4.media.session.b.H("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f612d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new z6.c("proto"), new z6.c("json"))));
        f613e = new a(strH, null);
        f = new a(strH2, strH3);
    }

    public a(String str, String str2) {
        this.f614a = str;
        this.f615b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}
