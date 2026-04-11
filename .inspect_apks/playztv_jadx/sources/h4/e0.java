package h4;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f5797b = Log.isLoggable("MediaSessionManager", 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f5798c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile e0 f5799d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f5800a;

    public static e0 a(Context context) {
        e0 e0Var;
        synchronized (f5798c) {
            try {
                if (f5799d == null) {
                    Context applicationContext = context.getApplicationContext();
                    e0 e0Var2 = new e0();
                    a0 a0Var = new a0();
                    a0Var.f5790a = applicationContext;
                    a0Var.f5791b = applicationContext.getContentResolver();
                    e0Var2.f5800a = a0Var;
                    f5799d = e0Var2;
                }
                e0Var = f5799d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return e0Var;
    }

    public final boolean b(b0 b0Var) {
        a0 a0Var = this.f5800a;
        d0 d0Var = b0Var.f5792a;
        Context context = a0Var.f5790a;
        int i = d0Var.f5794b;
        String str = d0Var.f5793a;
        int i10 = d0Var.f5795c;
        if (context.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", i, i10) == 0) {
            return true;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                if (a0Var.a(d0Var, "android.permission.STATUS_BAR_SERVICE") || a0Var.a(d0Var, "android.permission.MEDIA_CONTENT_CONTROL") || i10 == 1000) {
                    return true;
                }
                String string = Settings.Secure.getString(a0Var.f5791b, "enabled_notification_listeners");
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
            if (a0.f5789c) {
                Log.d("MediaSessionManager", "Package " + str + " doesn't exist");
            }
        }
        return false;
    }
}
