package y1;

import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f14568a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f14569b = {"", "A", "B", "C"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f14570c = Pattern.compile("^\\D?(\\d+)$");

    public static String a(int i, boolean z10, int i10, int i11, int[] iArr, int i12) {
        Object[] objArr = {f14569b[i], Integer.valueOf(i10), Integer.valueOf(i11), Character.valueOf(z10 ? 'H' : 'L'), Integer.valueOf(i12)};
        int i13 = a0.f14551a;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i14 = 0; i14 < length; i14++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i14])));
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair b(v1.p r33) {
        /*
            Method dump skipped, instruction units count: 2134
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.e.b(v1.p):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair c(java.lang.String r11, java.lang.String[] r12, v1.g r13) {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.e.c(java.lang.String, java.lang.String[], v1.g):android.util.Pair");
    }
}
