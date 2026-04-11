package ue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f13007j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13012e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f13013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13014h;
    public final boolean i;

    public o(String str, String str2, String str3, String str4, int i, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        be.h.e(str, "scheme");
        be.h.e(str4, "host");
        this.f13008a = str;
        this.f13009b = str2;
        this.f13010c = str3;
        this.f13011d = str4;
        this.f13012e = i;
        this.f = arrayList2;
        this.f13013g = str5;
        this.f13014h = str6;
        this.i = str.equals("https");
    }

    public final String a() {
        if (this.f13010c.length() == 0) {
            return "";
        }
        int length = this.f13008a.length() + 3;
        String str = this.f13014h;
        String strSubstring = str.substring(ie.e.S(str, ':', length, 4) + 1, ie.e.S(str, '@', 0, 6));
        be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f13008a.length() + 3;
        String str = this.f13014h;
        int iS = ie.e.S(str, '/', length, 4);
        String strSubstring = str.substring(iS, ve.b.e(iS, str.length(), str, "?#"));
        be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f13008a.length() + 3;
        String str = this.f13014h;
        int iS = ie.e.S(str, '/', length, 4);
        int iE = ve.b.e(iS, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iS < iE) {
            int i = iS + 1;
            int iF = ve.b.f(str, '/', i, iE);
            String strSubstring = str.substring(i, iF);
            be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iS = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f == null) {
            return null;
        }
        String str = this.f13014h;
        int iS = ie.e.S(str, '?', 0, 6) + 1;
        String strSubstring = str.substring(iS, ve.b.f(str, '#', iS, str.length()));
        be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.f13009b.length() == 0) {
            return "";
        }
        int length = this.f13008a.length() + 3;
        String str = this.f13014h;
        String strSubstring = str.substring(length, ve.b.e(length, str.length(), str, ":@"));
        be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof o) && be.h.a(((o) obj).f13014h, this.f13014h);
    }

    public final String f() {
        n nVar;
        try {
            nVar = new n();
            nVar.c(this, "/...");
        } catch (IllegalArgumentException unused) {
            nVar = null;
        }
        be.h.b(nVar);
        nVar.f13001b = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        nVar.f13002c = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        return nVar.a().f13014h;
    }

    public final URI g() {
        String strSubstring;
        String strReplaceAll;
        n nVar = new n();
        String str = this.f13008a;
        nVar.f13000a = str;
        nVar.f13001b = e();
        nVar.f13002c = a();
        nVar.f13003d = this.f13011d;
        be.h.e(str, "scheme");
        int i = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i10 = this.f13012e;
        nVar.f13004e = i10 != i ? i10 : -1;
        ArrayList arrayList = nVar.f;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        nVar.f13005g = strD != null ? b.f(b.b(strD, 0, 0, " \"'<>#", 211)) : null;
        if (this.f13013g == null) {
            strSubstring = null;
        } else {
            String str2 = this.f13014h;
            strSubstring = str2.substring(ie.e.S(str2, '#', 0, 6) + 1);
            be.h.d(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        nVar.f13006h = strSubstring;
        String str3 = nVar.f13003d;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            be.h.d(patternCompile, "compile(...)");
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            be.h.d(strReplaceAll, "replaceAll(...)");
        } else {
            strReplaceAll = null;
        }
        nVar.f13003d = strReplaceAll;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.set(i11, b.b((String) arrayList.get(i11), 0, 0, "[]", 227));
        }
        ArrayList arrayList2 = nVar.f13005g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                String str4 = (String) arrayList2.get(i12);
                arrayList2.set(i12, str4 != null ? b.b(str4, 0, 0, "\\^`{|}", 195) : null);
            }
        }
        String str5 = nVar.f13006h;
        nVar.f13006h = str5 != null ? b.b(str5, 0, 0, " \"#<>\\^`{|}", 163) : null;
        String string = nVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                be.h.d(patternCompile2, "compile(...)");
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                be.h.d(strReplaceAll2, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll2);
                be.h.d(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final int hashCode() {
        return this.f13014h.hashCode();
    }

    public final String toString() {
        return this.f13014h;
    }
}
