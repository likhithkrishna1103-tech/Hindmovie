package kf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7519e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f7521h;

    public q(String str, String str2, String str3, String str4, int i, ArrayList arrayList, String str5, String str6) {
        this.f7515a = str;
        this.f7516b = str2;
        this.f7517c = str3;
        this.f7518d = str4;
        this.f7519e = i;
        this.f = arrayList;
        this.f7520g = str5;
        this.f7521h = str6;
    }

    public final String a() {
        if (this.f7517c.length() == 0) {
            return "";
        }
        int length = this.f7515a.length() + 3;
        String str = this.f7521h;
        String strSubstring = str.substring(ne.h.h0(str, ':', length, 4) + 1, ne.h.h0(str, '@', 0, 6));
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f7515a.length() + 3;
        String str = this.f7521h;
        int iH0 = ne.h.h0(str, '/', length, 4);
        String strSubstring = str.substring(iH0, lf.d.c(iH0, str.length(), str, "?#"));
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f7515a.length() + 3;
        String str = this.f7521h;
        int iH0 = ne.h.h0(str, '/', length, 4);
        int iC = lf.d.c(iH0, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iH0 < iC) {
            int i = iH0 + 1;
            int iD = lf.d.d(str, '/', i, iC);
            String strSubstring = str.substring(i, iD);
            ge.i.d(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
            iH0 = iD;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f == null) {
            return null;
        }
        String str = this.f7521h;
        int iH0 = ne.h.h0(str, '?', 0, 6) + 1;
        String strSubstring = str.substring(iH0, lf.d.d(str, '#', iH0, str.length()));
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String e() {
        if (this.f7516b.length() == 0) {
            return "";
        }
        int length = this.f7515a.length() + 3;
        String str = this.f7521h;
        String strSubstring = str.substring(length, lf.d.c(length, str.length(), str, ":@"));
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q) && ge.i.a(((q) obj).f7521h, this.f7521h);
    }

    public final String f() {
        ka.c0 c0Var;
        try {
            c0Var = new ka.c0(1);
            c0Var.e(this, "/...");
        } catch (IllegalArgumentException unused) {
            c0Var = null;
        }
        ge.i.b(c0Var);
        c0Var.f7294d = zf.a.a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 123);
        c0Var.f7295e = zf.a.a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 123);
        return c0Var.b().f7521h;
    }

    public final URI g() {
        String strSubstring;
        String strReplaceAll;
        ka.c0 c0Var = new ka.c0(1);
        ArrayList arrayList = (ArrayList) c0Var.f7296g;
        String str = this.f7515a;
        c0Var.f7293c = str;
        c0Var.f7294d = e();
        c0Var.f7295e = a();
        c0Var.f = this.f7518d;
        ge.i.e(str, "scheme");
        int i = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i10 = this.f7519e;
        c0Var.f7292b = i10 != i ? i10 : -1;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        c0Var.f7297h = strD != null ? ka.c0.f(zf.a.a(strD, 0, 0, " \"'<>#", 83)) : null;
        if (this.f7520g == null) {
            strSubstring = null;
        } else {
            String str2 = this.f7521h;
            strSubstring = str2.substring(ne.h.h0(str2, '#', 0, 6) + 1);
            ge.i.d(strSubstring, "substring(...)");
        }
        c0Var.i = strSubstring;
        String str3 = (String) c0Var.f;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            ge.i.d(patternCompile, "compile(...)");
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            ge.i.d(strReplaceAll, "replaceAll(...)");
        } else {
            strReplaceAll = null;
        }
        c0Var.f = strReplaceAll;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.set(i11, zf.a.a((String) arrayList.get(i11), 0, 0, "[]", 99));
        }
        ArrayList arrayList2 = (ArrayList) c0Var.f7297h;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                String str4 = (String) arrayList2.get(i12);
                arrayList2.set(i12, str4 != null ? zf.a.a(str4, 0, 0, "\\^`{|}", 67) : null);
            }
        }
        String str5 = (String) c0Var.i;
        c0Var.i = str5 != null ? zf.a.a(str5, 0, 0, " \"#<>\\^`{|}", 35) : null;
        String string = c0Var.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e9) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                ge.i.d(patternCompile2, "compile(...)");
                ge.i.e(string, "input");
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                ge.i.d(strReplaceAll2, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll2);
                ge.i.b(uriCreate);
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e9);
            }
        }
    }

    public final int hashCode() {
        return this.f7521h.hashCode();
    }

    public final String toString() {
        return this.f7521h;
    }
}
