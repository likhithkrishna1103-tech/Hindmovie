package pd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f10181d = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f10182e = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    public static final Pattern f = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10185c;

    public a(String str) {
        this.f10183a = str;
        if (str != null) {
            Matcher matcher = f10181d.matcher(str);
            this.f10184b = matcher.find() ? matcher.group(1) : "";
            Matcher matcher2 = f10182e.matcher(str);
            this.f10185c = matcher2.find() ? matcher2.group(2) : null;
        } else {
            this.f10184b = "";
            this.f10185c = "UTF-8";
        }
        if ("multipart/form-data".equalsIgnoreCase(this.f10184b)) {
            Matcher matcher3 = f.matcher(str);
            if (matcher3.find()) {
                matcher3.group(2);
            }
        }
    }
}
