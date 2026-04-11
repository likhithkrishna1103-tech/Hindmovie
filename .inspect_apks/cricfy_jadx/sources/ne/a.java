package ne;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f9126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f9127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f9128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Charset f9129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Charset f9130e;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        ge.i.d(charsetForName, "forName(...)");
        f9126a = charsetForName;
        ge.i.d(Charset.forName("UTF-16"), "forName(...)");
        Charset charsetForName2 = Charset.forName("UTF-16BE");
        ge.i.d(charsetForName2, "forName(...)");
        f9127b = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16LE");
        ge.i.d(charsetForName3, "forName(...)");
        f9128c = charsetForName3;
        ge.i.d(Charset.forName("US-ASCII"), "forName(...)");
        ge.i.d(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
