package a6;

import android.content.pm.PackageManager;
import app.cricfy.tv.app.ProApplication;
import h.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f303c = {"L29xNcm0kMGzLW5mjdehjMZi", "L29xNdDhfWScSYO=", "L29xNdZnjWPogBHhLW5ejc9qSF==", "L29xNck1g3DrfU5rkMVwL2PhLYZ5", "L29xNcPhSMZqSWyuNc11gMVqL2PskP9sgcncScIl", "fdFhL28hkBPij29ckMkmjcHhLW5ejc9qSJ5wLWDvSYVzLYG0kYZn", "L29xNc1qgcm1fU5hSYV3g3ZvL2PwkMIlSU5wjc8=", "L29xNc1qgcm1fU53fWSqLW5mgMn6SYO=", "L29xNc1qgcm1fU5hSYV3g3ZvL2PwkMIlST==", "L29xNdGmL2xmS2IsgcncScIlNcSlkMGmjcymfw==", "L29xNcI2LcPejc9qSJ53fWDmjBVngW8=", "LYGwNcklSYnsfBnlkMChj3DuL2PwkMIlST==", "L29xNck1g3DrfU5rkMVwL2PhLYZ5NdGlSW1qkW0=", "L29xNcIxLW51SWynSo5lSW1ikBIpL2PwkMIlST==", "L29xNcI2LcPejc9qSJ5wjc94aW1igb==", "L29xNc5nkMkijcuhjMZiaMe="};

    static {
        try {
            System.loadLibrary(a.a("45475a704a6e5a"));
            f301a = false;
        } catch (UnsatisfiedLinkError unused) {
            f302b = true;
        }
        try {
            System.loadLibrary(a.a("6e6c6d5a753932597545475a704a6e5a"));
            f301a = false;
        } catch (UnsatisfiedLinkError unused2) {
            f302b = true;
        }
        try {
            System.loadLibrary(a.a("30425861794e3263"));
            f301a = false;
        } catch (UnsatisfiedLinkError unused3) {
            f302b = true;
        }
    }

    public static void a(j jVar) {
        String string;
        ProApplication proApplication = (ProApplication) jVar.getApplication();
        proApplication.G = null;
        if (jVar.getSharedPreferences("DataPreferences", 0).getBoolean("is_tv", false)) {
            return;
        }
        PackageManager packageManager = jVar.getPackageManager();
        for (int i = 0; i < 16; i++) {
            try {
                string = packageManager.getApplicationLabel(packageManager.getApplicationInfo(a.b(f303c[i]), 0)).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                string = null;
            }
            if (string != null) {
                proApplication.G = string;
                return;
            }
        }
    }
}
