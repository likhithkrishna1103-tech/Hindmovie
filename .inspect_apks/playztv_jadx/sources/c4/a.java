package c4;

import java.util.regex.Pattern;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f2459c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f2460d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f2461a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f2462b = new StringBuilder();

    public static String a(u uVar, StringBuilder sb2) {
        boolean z2 = false;
        sb2.setLength(0);
        int i = uVar.f11710b;
        int i10 = uVar.f11711c;
        while (i < i10 && !z2) {
            char c9 = (char) uVar.f11709a[i];
            if ((c9 < 'A' || c9 > 'Z') && ((c9 < 'a' || c9 > 'z') && !((c9 >= '0' && c9 <= '9') || c9 == '#' || c9 == '-' || c9 == '.' || c9 == '_'))) {
                z2 = true;
            } else {
                i++;
                sb2.append(c9);
            }
        }
        uVar.K(i - uVar.f11710b);
        return sb2.toString();
    }

    public static String b(u uVar, StringBuilder sb2) {
        c(uVar);
        if (uVar.a() == 0) {
            return null;
        }
        String strA = a(uVar, sb2);
        if (!strA.isEmpty()) {
            return strA;
        }
        return "" + ((char) uVar.x());
    }

    public static void c(u uVar) {
        while (true) {
            for (boolean z2 = true; uVar.a() > 0 && z2; z2 = false) {
                int i = uVar.f11710b;
                byte[] bArr = uVar.f11709a;
                byte b10 = bArr[i];
                char c9 = (char) b10;
                if (c9 == '\t' || c9 == '\n' || c9 == '\f' || c9 == '\r' || c9 == ' ') {
                    uVar.K(1);
                } else {
                    int i10 = uVar.f11711c;
                    int i11 = i + 2;
                    if (i11 <= i10) {
                        int i12 = i + 1;
                        if (b10 == 47 && bArr[i12] == 42) {
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
                            uVar.K(i10 - uVar.f11710b);
                        }
                    }
                }
            }
            return;
        }
    }
}
