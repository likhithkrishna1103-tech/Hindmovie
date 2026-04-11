package ld;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f8118d = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f8119e = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    public static final Pattern f = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8122c;

    public a(String str) {
        this.f8120a = str;
        if (str != null) {
            Matcher matcher = f8118d.matcher(str);
            this.f8121b = matcher.find() ? matcher.group(1) : "";
            Matcher matcher2 = f8119e.matcher(str);
            this.f8122c = matcher2.find() ? matcher2.group(2) : null;
        } else {
            this.f8121b = "";
            this.f8122c = "UTF-8";
        }
        if ("multipart/form-data".equalsIgnoreCase(this.f8121b)) {
            Matcher matcher3 = f.matcher(str);
            if (matcher3.find()) {
                matcher3.group(2);
            }
        }
    }
}
