package a6;

import android.util.Base64;
import com.google.android.gms.internal.measurement.j4;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f297a = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f298b = {'f', 'F', 'g', 'G', 'j', 'J', 'k', 'K', 'a', 'A', 'p', 'P', 'b', 'B', 'm', 'M', 'o', 'O', 'z', 'Z', 'e', 'E', 'n', 'N', 'c', 'C', 'd', 'D', 'r', 'R', 'q', 'Q', 't', 'T', 'v', 'V', 'u', 'U', 'x', 'X', 'h', 'H', 'i', 'I', 'w', 'W', 'y', 'Y', 'l', 'L', 's', 'S'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f299c = new char[128];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f300d = new char[128];

    static {
        int i = 0;
        while (true) {
            char[] cArr = f297a;
            if (i >= cArr.length) {
                break;
            }
            char[] cArr2 = f299c;
            char c9 = cArr[i];
            char[] cArr3 = f298b;
            cArr2[c9] = cArr3[i];
            f300d[cArr3[i]] = cArr[i];
            i++;
        }
        for (int i10 = 0; i10 < 128; i10++) {
            char[] cArr4 = f299c;
            if (cArr4[i10] == 0) {
                cArr4[i10] = (char) i10;
            }
            char[] cArr5 = f300d;
            if (cArr5[i10] == 0) {
                cArr5[i10] = (char) i10;
            }
        }
    }

    public static String a(String str) {
        return new String(Base64.decode(new StringBuilder(new String(Base64.decode(new StringBuilder(j4.s(str)).toString(), 0))).reverse().toString(), 0));
    }

    public static String b(String str) {
        char[] cArr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            cArr[i] = f300d[str.charAt(i)];
        }
        return new String(Base64.decode(new String(cArr), 0), StandardCharsets.UTF_8);
    }
}
