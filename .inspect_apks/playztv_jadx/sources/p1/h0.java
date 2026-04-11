package p1;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet f9779a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f9780b = "media3.common";

    public static synchronized void a(String str) {
        if (f9779a.add(str)) {
            f9780b += ", " + str;
        }
    }

    public static synchronized String b() {
        return f9780b;
    }
}
