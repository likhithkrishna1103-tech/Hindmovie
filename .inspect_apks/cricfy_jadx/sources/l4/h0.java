package l4;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f7716b = Log.isLoggable("MediaSessionManager", 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f7717c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile h0 f7718d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f7719a;

    public static h0 a(Context context) {
        h0 h0Var;
        synchronized (f7717c) {
            try {
                if (f7718d == null) {
                    Context applicationContext = context.getApplicationContext();
                    h0 h0Var2 = new h0();
                    d0 d0Var = new d0();
                    d0Var.f7708a = applicationContext;
                    d0Var.f7709b = applicationContext.getContentResolver();
                    h0Var2.f7719a = d0Var;
                    f7718d = h0Var2;
                }
                h0Var = f7718d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return h0Var;
    }

    public final boolean b(e0 e0Var) {
        d0 d0Var = this.f7719a;
        g0 g0Var = e0Var.f7710a;
        Context context = d0Var.f7708a;
        int i = g0Var.f7713b;
        String str = g0Var.f7712a;
        int i10 = g0Var.f7714c;
        if (context.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", i, i10) == 0) {
            return true;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                if (d0Var.a(g0Var, "android.permission.STATUS_BAR_SERVICE") || d0Var.a(g0Var, "android.permission.MEDIA_CONTENT_CONTROL") || i10 == 1000) {
                    return true;
                }
                String string = Settings.Secure.getString(d0Var.f7709b, "enabled_notification_listeners");
                if (string != null) {
                    for (String str2 : string.split(":")) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str2);
                        if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (d0.f7707c) {
                Log.d("MediaSessionManager", "Package " + str + " doesn't exist");
            }
        }
        return false;
    }
}
