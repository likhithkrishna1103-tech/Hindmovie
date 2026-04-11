package ne;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Pattern f9145v;

    public g(String str) {
        Pattern patternCompile = Pattern.compile(str);
        ge.i.d(patternCompile, "compile(...)");
        this.f9145v = patternCompile;
    }

    public final l7.a a(int i, String str) {
        ge.i.e(str, "input");
        Matcher matcherRegion = this.f9145v.matcher(str).useAnchoringBounds(false).useTransparentBounds(true).region(i, str.length());
        if (matcherRegion.lookingAt()) {
            return new l7.a(matcherRegion, str);
        }
        return null;
    }

    public final String b(String str) {
        ge.i.e(str, "input");
        String strReplaceAll = this.f9145v.matcher(str).replaceAll("");
        ge.i.d(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String toString() {
        String string = this.f9145v.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }
}
