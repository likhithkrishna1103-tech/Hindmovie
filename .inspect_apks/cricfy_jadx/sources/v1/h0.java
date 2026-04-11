package v1;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet f12707a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f12708b = "media3.common";

    public static synchronized void a(String str) {
        if (f12707a.add(str)) {
            f12708b += ", " + str;
        }
    }

    public static synchronized String b() {
        return f12708b;
    }
}
