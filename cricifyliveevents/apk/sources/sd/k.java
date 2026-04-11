package sd;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends n5.a {
    public static int d0(List list) {
        ge.i.e(list, "<this>");
        return list.size() - 1;
    }

    public static void e0() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
