package c4;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import p1.n0;
import s1.b0;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f2504a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(u uVar) {
        uVar.getClass();
        String strK = uVar.k(StandardCharsets.UTF_8);
        return strK != null && strK.startsWith("WEBVTT");
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        int i = b0.f11647a;
        String[] strArrSplit = str.split("\\.", 2);
        long j5 = 0;
        for (String str2 : strArrSplit[0].split(":", -1)) {
            j5 = (j5 * 60) + Long.parseLong(str2);
        }
        long j8 = j5 * 1000;
        if (strArrSplit.length == 2) {
            String strTrim = strArrSplit[1].trim();
            if (strTrim.length() != 3) {
                throw new IllegalArgumentException("Expected 3 decimal places, got: ".concat(strTrim));
            }
            j8 += Long.parseLong(strTrim);
        }
        return j8 * 1000;
    }

    public static void d(u uVar) throws n0 {
        int i = uVar.f11710b;
        if (a(uVar)) {
            return;
        }
        uVar.J(i);
        throw n0.a(null, "Expected WEBVTT. Got " + uVar.k(StandardCharsets.UTF_8));
    }
}
