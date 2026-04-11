package androidx.navigation;

import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final Pattern i = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1357a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1358b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pattern f1359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1361e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pattern f1362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1363h;

    public j(String str, String str2, String str3) {
        int i10;
        int i11;
        this.f1359c = null;
        int i12 = 0;
        this.f1360d = false;
        this.f1361e = false;
        this.f1362g = null;
        this.f = str2;
        this.f1363h = str3;
        int i13 = 1;
        if (str != null) {
            Uri uri = Uri.parse(str);
            boolean z10 = uri.getQuery() != null;
            this.f1361e = z10;
            StringBuilder sb = new StringBuilder("^");
            if (!i.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern patternCompile = Pattern.compile("\\{(.+?)\\}");
            if (z10) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, patternCompile);
                }
                this.f1360d = false;
                for (String str4 : uri.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = uri.getQueryParameter(str4);
                    Matcher matcher2 = patternCompile.matcher(queryParameter);
                    i iVar = new i();
                    iVar.f1356b = new ArrayList();
                    int iEnd = i12;
                    while (matcher2.find()) {
                        iVar.f1356b.add(matcher2.group(i13));
                        sb2.append(Pattern.quote(queryParameter.substring(iEnd, matcher2.start())));
                        sb2.append("(.+?)?");
                        iEnd = matcher2.end();
                        i13 = i13;
                        i12 = i12;
                    }
                    int i14 = i13;
                    int i15 = i12;
                    if (iEnd < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(iEnd)));
                    }
                    iVar.f1355a = sb2.toString().replace(".*", "\\E.*\\Q");
                    this.f1358b.put(str4, iVar);
                    i13 = i14;
                    i12 = i15;
                }
                i10 = i13;
                i11 = i12;
            } else {
                i10 = 1;
                i11 = 0;
                this.f1360d = a(str, sb, patternCompile);
            }
            this.f1359c = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"), 2);
        } else {
            i10 = 1;
            i11 = 0;
        }
        if (str3 != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                throw new IllegalArgumentException(l0.e.k("The given mimeType ", str3, " does not match to required \"type/subtype\" format"));
            }
            String[] strArrSplit = str3.split("/", -1);
            this.f1362g = Pattern.compile(("^(" + strArrSplit[i11] + "|[*]+)/(" + strArrSplit[i10] + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
        }
    }

    public final boolean a(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z10 = !str.contains(".*");
        int iEnd = 0;
        while (matcher.find()) {
            this.f1357a.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(iEnd, matcher.start())));
            sb.append("(.+?)");
            iEnd = matcher.end();
            z10 = false;
        }
        if (iEnd < str.length()) {
            sb.append(Pattern.quote(str.substring(iEnd)));
        }
        sb.append("($|(\\?(.)*))");
        return z10;
    }
}
