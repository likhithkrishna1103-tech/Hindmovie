package ub;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import g4.h0;
import java.util.concurrent.ExecutorService;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f12852c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static z f12853d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12855b;

    public i(ExecutorService executorService) {
        this.f12855b = new s.e(0);
        this.f12854a = executorService;
    }

    public static o8.o a(Context context, Intent intent, boolean z2) {
        z zVar;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized (f12852c) {
            try {
                if (f12853d == null) {
                    f12853d = new z(context);
                }
                zVar = f12853d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            return zVar.b(intent).e(new n4.b(0), new r2.h(6));
        }
        if (o.z().E(context)) {
            w.c(context, zVar, intent);
        } else {
            zVar.b(intent);
        }
        return t1.k(-1);
    }

    public o8.o b(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = (Context) this.f12854a;
        n4.b bVar = (n4.b) this.f12855b;
        boolean z2 = x7.b.d() && context.getApplicationInfo().targetSdkVersion >= 26;
        boolean z10 = (intent.getFlags() & 268435456) != 0;
        return (!z2 || z10) ? t1.f(bVar, new l5.d(context, 1, intent)).f(bVar, new h0(context, intent, z10)) : a(context, intent, z10);
    }

    public i(Context context) {
        this.f12854a = context;
        this.f12855b = new n4.b(0);
    }
}
