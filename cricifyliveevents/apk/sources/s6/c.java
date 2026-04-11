package s6;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11547a = new b();

    public static void a() {
        f11547a.getClass();
    }

    public static void b(String str) {
        f11547a.getClass();
        HashSet hashSet = b.f11546a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, null);
        hashSet.add(str);
    }

    public static void c(String str, Throwable th) {
        f11547a.getClass();
        HashSet hashSet = b.f11546a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        hashSet.add(str);
    }
}
