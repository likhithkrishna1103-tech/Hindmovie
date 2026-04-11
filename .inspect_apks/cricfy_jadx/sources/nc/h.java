package nc;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import k4.h0;
import k4.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f9050c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a0 f9051d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9053b;

    public h(ExecutorService executorService) {
        this.f9053b = new v.e(0);
        this.f9052a = executorService;
    }

    public static j9.p a(Context context, Intent intent, boolean z10) {
        a0 a0Var;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized (f9050c) {
            try {
                if (f9051d == null) {
                    f9051d = new a0(context);
                }
                a0Var = f9051d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z10) {
            return a0Var.b(intent).e(new p.a(1), new r0(29));
        }
        if (p.p().r(context)) {
            x.c(context, a0Var, intent);
        } else {
            a0Var.b(intent);
        }
        return vf.g.A(-1);
    }

    public j9.p b(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = (Context) this.f9052a;
        p.a aVar = (p.a) this.f9053b;
        boolean z10 = s8.b.d() && context.getApplicationInfo().targetSdkVersion >= 26;
        boolean z11 = (intent.getFlags() & 268435456) != 0;
        return (!z10 || z11) ? vf.g.e(aVar, new b2.j(3, context, intent)).f(aVar, new h0(context, intent, z11)) : a(context, intent, z11);
    }

    public h(Context context) {
        this.f9052a = context;
        this.f9053b = new p.a(1);
    }
}
