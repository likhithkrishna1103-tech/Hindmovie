package qc;

import android.content.pm.PackageManager;
import com.playz.tv.app.ProApplication;
import h.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f11191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f11192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f11193c = {"L29xNcm0kMGzLW5mjdehjMZi", "L29xNdDhfWScSYO=", "L29xNdZnjWPogBHhLW5ejc9qSF==", "L29xNck1g3DrfU5rkMVwL2PhLYZ5", "L29xNcPhSMZqSWyuNc11gMVqL2PskP9sgcncScIl", "fdFhL28hkBPij29ckMkmjcHhLW5ejc9qSJ5wLWDvSYVzLYG0kYZn", "L29xNc1qgcm1fU5hSYV3g3ZvL2PwkMIlSU5wjc8=", "L29xNc1qgcm1fU53fWSqLW5mgMn6SYO=", "L29xNc1qgcm1fU5hSYV3g3ZvL2PwkMIlST==", "L29xNdGmL2xmS2IsgcncScIlNcSlkMGmjcymfw==", "L29xNcI2LcPejc9qSJ53fWDmjBVngW8=", "LYGwNcklSYnsfBnlkMChj3DuL2PwkMIlST==", "L29xNck1g3DrfU5rkMVwL2PhLYZ5NdGlSW1qkW0=", "L29xNcIxLW51SWynSo5lSW1ikBIpL2PwkMIlST==", "L29xNcI2LcPejc9qSJ5wjc94aW1igb==", "L29xNc5nkMkijcuhjMZiaMe="};

    static {
        try {
            System.loadLibrary(a.a("45475a704a6e5a"));
            f11191a = false;
        } catch (UnsatisfiedLinkError unused) {
            f11192b = true;
        }
        try {
            System.loadLibrary(a.a("6e6c6d5a753932597545475a704a6e5a"));
            f11191a = false;
        } catch (UnsatisfiedLinkError unused2) {
            f11192b = true;
        }
        try {
            System.loadLibrary(a.a("30425861794e3263"));
            f11191a = false;
        } catch (UnsatisfiedLinkError unused3) {
            f11192b = true;
        }
    }

    public static void a(j jVar) {
        String string;
        ProApplication proApplication = (ProApplication) jVar.getApplication();
        proApplication.F = null;
        if (jVar.getSharedPreferences("DataPreferences", 0).getBoolean("is_tv", false)) {
            return;
        }
        PackageManager packageManager = jVar.getPackageManager();
        for (int i = 0; i < 16; i++) {
            try {
                string = packageManager.getApplicationLabel(packageManager.getApplicationInfo(a.b(f11193c[i]), 0)).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                string = null;
            }
            if (string != null) {
                proApplication.F = string;
                return;
            }
        }
    }
}
