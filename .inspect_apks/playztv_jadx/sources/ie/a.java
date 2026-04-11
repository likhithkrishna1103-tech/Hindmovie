package ie;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f6599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Charset f6600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Charset f6601c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        be.h.d(charsetForName, "forName(...)");
        f6599a = charsetForName;
        be.h.d(Charset.forName("UTF-16"), "forName(...)");
        be.h.d(Charset.forName("UTF-16BE"), "forName(...)");
        be.h.d(Charset.forName("UTF-16LE"), "forName(...)");
        be.h.d(Charset.forName("US-ASCII"), "forName(...)");
        be.h.d(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
