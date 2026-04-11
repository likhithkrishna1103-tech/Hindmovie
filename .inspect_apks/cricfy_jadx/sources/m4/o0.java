package m4;

import android.text.Html;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f8203a = Pattern.compile("(&#13;)?&#10;");

    public static String a(CharSequence charSequence) {
        return f8203a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
