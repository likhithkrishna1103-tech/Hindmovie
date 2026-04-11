package ub;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f12905a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12906b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static n8.a f12907c;

    public static void a(Context context) {
        if (f12907c == null) {
            n8.a aVar = new n8.a(context);
            f12907c = aVar;
            synchronized (aVar.f8841a) {
                aVar.f8846g = true;
            }
        }
    }

    public static void b(Intent intent) {
        synchronized (f12906b) {
            try {
                if (f12907c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    f12907c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(Context context, z zVar, Intent intent) {
        synchronized (f12906b) {
            try {
                a(context);
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                if (!booleanExtra) {
                    f12907c.a(f12905a);
                }
                o8.o oVarB = zVar.b(intent);
                nc.c cVar = new nc.c(16, intent);
                oVarB.getClass();
                oVarB.f9440b.i(new o8.m(o8.i.f9422a, cVar));
                oVarB.q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ComponentName d(Context context, Intent intent) {
        synchronized (f12906b) {
            try {
                a(context);
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!booleanExtra) {
                    f12907c.a(f12905a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
