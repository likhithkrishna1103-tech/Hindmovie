package nc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f9105a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f9106b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static i9.a f9107c;

    public static void a(Context context) {
        if (f9107c == null) {
            i9.a aVar = new i9.a(context);
            f9107c = aVar;
            synchronized (aVar.f6366a) {
                aVar.f6371g = true;
            }
        }
    }

    public static void b(Intent intent) {
        synchronized (f9106b) {
            try {
                if (f9107c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    f9107c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(Context context, a0 a0Var, Intent intent) {
        synchronized (f9106b) {
            try {
                a(context);
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                if (!booleanExtra) {
                    f9107c.a(f9105a);
                }
                j9.p pVarB = a0Var.b(intent);
                kb.d dVar = new kb.d(2, intent);
                pVarB.getClass();
                pVarB.f6707b.h(new j9.n(j9.j.f6689a, dVar));
                pVarB.q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ComponentName d(Context context, Intent intent) {
        synchronized (f9106b) {
            try {
                a(context);
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!booleanExtra) {
                    f9107c.a(f9105a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
