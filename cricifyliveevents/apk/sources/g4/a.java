package g4;

import java.util.regex.Pattern;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f4979c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f4980d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f4981a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f4982b = new StringBuilder();

    public static String a(t tVar, StringBuilder sb) {
        boolean z10 = false;
        sb.setLength(0);
        int i = tVar.f14610b;
        int i10 = tVar.f14611c;
        while (i < i10 && !z10) {
            char c9 = (char) tVar.f14609a[i];
            if ((c9 < 'A' || c9 > 'Z') && ((c9 < 'a' || c9 > 'z') && !((c9 >= '0' && c9 <= '9') || c9 == '#' || c9 == '-' || c9 == '.' || c9 == '_'))) {
                z10 = true;
            } else {
                i++;
                sb.append(c9);
            }
        }
        tVar.K(i - tVar.f14610b);
        return sb.toString();
    }

    public static String b(t tVar, StringBuilder sb) {
        c(tVar);
        if (tVar.a() == 0) {
            return null;
        }
        String strA = a(tVar, sb);
        if (!strA.isEmpty()) {
            return strA;
        }
        return "" + ((char) tVar.x());
    }

    public static void c(t tVar) {
        while (true) {
            for (boolean z10 = true; tVar.a() > 0 && z10; z10 = false) {
                int i = tVar.f14610b;
                byte[] bArr = tVar.f14609a;
                byte b8 = bArr[i];
                char c9 = (char) b8;
                if (c9 == '\t' || c9 == '\n' || c9 == '\f' || c9 == '\r' || c9 == ' ') {
                    tVar.K(1);
                } else {
                    int i10 = tVar.f14611c;
                    int i11 = i + 2;
                    if (i11 <= i10) {
                        int i12 = i + 1;
                        if (b8 == 47 && bArr[i12] == 42) {
                            while (true) {
                                int i13 = i11 + 1;
                                if (i13 >= i10) {
                                    break;
                                }
                                if (((char) bArr[i11]) == '*' && ((char) bArr[i13]) == '/') {
                                    i11 += 2;
                                    i10 = i11;
                                } else {
                                    i11 = i13;
                                }
                            }
                            tVar.K(i10 - tVar.f14610b);
                        }
                    }
                }
            }
            return;
        }
    }
}
