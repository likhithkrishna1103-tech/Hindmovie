package g4;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import v1.n0;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f5024a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(t tVar) {
        tVar.getClass();
        String strK = tVar.k(StandardCharsets.UTF_8);
        return strK != null && strK.startsWith("WEBVTT");
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        int i = a0.f14551a;
        String[] strArrSplit = str.split("\\.", 2);
        long j4 = 0;
        for (String str2 : strArrSplit[0].split(":", -1)) {
            j4 = (j4 * 60) + Long.parseLong(str2);
        }
        long j7 = j4 * 1000;
        if (strArrSplit.length == 2) {
            String strTrim = strArrSplit[1].trim();
            if (strTrim.length() != 3) {
                throw new IllegalArgumentException("Expected 3 decimal places, got: ".concat(strTrim));
            }
            j7 += Long.parseLong(strTrim);
        }
        return j7 * 1000;
    }

    public static void d(t tVar) throws n0 {
        int i = tVar.f14610b;
        if (a(tVar)) {
            return;
        }
        tVar.J(i);
        throw n0.a(null, "Expected WEBVTT. Got " + tVar.k(StandardCharsets.UTF_8));
    }
}
