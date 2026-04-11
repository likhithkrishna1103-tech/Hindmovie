package l8;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7892b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f7893c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f7895e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f7891a = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f7894d = new AtomicBoolean();

    public static boolean a(Context context) {
        try {
            if (!f7893c) {
                try {
                    PackageInfo packageInfoB = u8.b.a(context).b(Build.VERSION.SDK_INT >= 28 ? 134217792 : 64, "com.google.android.gms");
                    i.b(context);
                    if (packageInfoB == null || i.d(packageInfoB, false) || !i.d(packageInfoB, true)) {
                        f7892b = false;
                    } else {
                        f7892b = true;
                    }
                    f7893c = true;
                } catch (PackageManager.NameNotFoundException e9) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e9);
                    f7893c = true;
                }
            }
            return f7892b || !"user".equals(Build.TYPE);
        } catch (Throwable th) {
            f7893c = true;
            throw th;
        }
    }
}
