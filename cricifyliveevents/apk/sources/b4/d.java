package b4;

import android.graphics.PointF;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f1771a = Pattern.compile("\\{([^}]*)\\}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f1772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f1773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f1774d;

    static {
        int i = a0.f14551a;
        Locale locale = Locale.US;
        f1772b = Pattern.compile(String.format(locale, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        f1773c = Pattern.compile(String.format(locale, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        f1774d = Pattern.compile("\\\\an(\\d+)");
    }

    public static PointF a(String str) {
        String strGroup;
        String strGroup2;
        Matcher matcher = f1772b.matcher(str);
        Matcher matcher2 = f1773c.matcher(str);
        boolean zFind = matcher.find();
        boolean zFind2 = matcher2.find();
        if (zFind) {
            if (zFind2) {
                y1.b.k("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
            }
            strGroup = matcher.group(1);
            strGroup2 = matcher.group(2);
        } else {
            if (!zFind2) {
                return null;
            }
            strGroup = matcher2.group(1);
            strGroup2 = matcher2.group(2);
        }
        strGroup.getClass();
        float f = Float.parseFloat(strGroup.trim());
        strGroup2.getClass();
        return new PointF(f, Float.parseFloat(strGroup2.trim()));
    }
}
