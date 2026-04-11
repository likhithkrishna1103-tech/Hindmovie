package q7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11042b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f11043c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f11045e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f11041a = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f11044d = new AtomicBoolean();

    public static boolean a(Context context) {
        try {
            if (!f11043c) {
                try {
                    PackageInfo packageInfoC = z7.b.a(context).c("com.google.android.gms", 64);
                    h.b(context);
                    if (packageInfoC == null || h.e(packageInfoC, false) || !h.e(packageInfoC, true)) {
                        f11042b = false;
                    } else {
                        f11042b = true;
                    }
                    f11043c = true;
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e10);
                    f11043c = true;
                }
            }
            return f11042b || !"user".equals(Build.TYPE);
        } catch (Throwable th) {
            f11043c = true;
            throw th;
        }
    }
}
