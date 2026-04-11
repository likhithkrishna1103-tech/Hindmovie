package i4;

import android.text.Html;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f6258a = Pattern.compile("(&#13;)?&#10;");

    public static String a(CharSequence charSequence) {
        return f6258a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
