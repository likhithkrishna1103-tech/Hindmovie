package ub;

import android.util.Log;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f12876d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12879c;

    public q(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + ".");
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !f12876d.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(e6.j.n("Invalid topic name: ", strSubstring, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
        }
        this.f12877a = strSubstring;
        this.f12878b = str;
        this.f12879c = str + "!" + str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f12877a.equals(qVar.f12877a) && this.f12878b.equals(qVar.f12878b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12878b, this.f12877a});
    }
}
