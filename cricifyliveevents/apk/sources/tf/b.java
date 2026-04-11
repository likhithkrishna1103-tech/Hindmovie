package tf;

import ag.h;
import ka.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12032a;

    static {
        h hVar = h.f430y;
        f12032a = f.d("xn--");
    }

    public static int a(int i, int i10, boolean z10) {
        int i11 = z10 ? i / 700 : i / 2;
        int i12 = (i11 / i10) + i11;
        int i13 = 0;
        while (i12 > 455) {
            i12 /= 35;
            i13 += 36;
        }
        return ((i12 * 36) / (i12 + 38)) + i13;
    }

    public static int b(int i) {
        if (i < 26) {
            return i + 97;
        }
        if (i < 36) {
            return i + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i).toString());
    }
}
