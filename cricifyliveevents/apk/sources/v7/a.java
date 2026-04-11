package v7;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import u7.c;
import w4.v;
import x7.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f13497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13498e;
    public static final a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13500b;

    static {
        String strN = v.n("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f13496c = strN;
        String strN2 = v.n("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String strN3 = v.n("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f13497d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new c("proto"), new c("json"))));
        f13498e = new a(strN, null);
        f = new a(strN2, strN3);
    }

    public a(String str, String str2) {
        this.f13499a = str;
        this.f13500b = str2;
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
