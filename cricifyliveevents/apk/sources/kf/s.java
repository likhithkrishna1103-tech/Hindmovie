package kf;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ne.g f7522c = new ne.g("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ne.g f7523d = new ne.g(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f7525b;

    public s(String str, String str2, String str3, String[] strArr) {
        ge.i.e(str, "mediaType");
        ge.i.e(strArr, "parameterNamesAndValues");
        this.f7524a = str;
        this.f7525b = strArr;
    }

    public static Charset a(s sVar) {
        String str;
        String[] strArr = sVar.f7525b;
        int i = 0;
        int iR = com.bumptech.glide.c.r(0, strArr.length - 1, 2);
        if (iR >= 0) {
            while (true) {
                String str2 = strArr[i];
                if (!(str2 == null ? false : str2.equalsIgnoreCase("charset"))) {
                    if (i == iR) {
                        break;
                    }
                    i += 2;
                } else {
                    str = strArr[i + 1];
                    break;
                }
            }
            str = null;
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof s) && ge.i.a(((s) obj).f7524a, this.f7524a);
    }

    public final int hashCode() {
        return this.f7524a.hashCode();
    }

    public final String toString() {
        return this.f7524a;
    }
}
