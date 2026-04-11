package nc;

import android.util.Log;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f9077d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9080c;

    public r(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + ".");
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !f9077d.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(l0.e.k("Invalid topic name: ", strSubstring, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
        }
        this.f9078a = strSubstring;
        this.f9079b = str;
        this.f9080c = str + "!" + str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f9078a.equals(rVar.f9078a) && this.f9079b.equals(rVar.f9079b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9079b, this.f9078a});
    }
}
