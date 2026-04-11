package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final o f5394v = new o(new eb.d(1));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f5395w = -100;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static p0.g f5396x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static p0.g f5397y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static Boolean f5398z = null;
    public static boolean A = false;
    public static final v.f B = new v.f(0);
    public static final Object C = new Object();
    public static final Object D = new Object();

    public static boolean c(Context context) {
        if (f5398z == null) {
            try {
                int i = g0.f5348v;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) g0.class), Build.VERSION.SDK_INT >= 24 ? f0.a() | 128 : 640).metaData;
                if (bundle != null) {
                    f5398z = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f5398z = Boolean.FALSE;
            }
        }
        return f5398z.booleanValue();
    }

    public static void f(a0 a0Var) {
        synchronized (C) {
            try {
                v.f fVar = B;
                fVar.getClass();
                v.a aVar = new v.a(fVar);
                while (aVar.hasNext()) {
                    p pVar = (p) ((WeakReference) aVar.next()).get();
                    if (pVar == a0Var || pVar == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void k() {
        if (f5395w != 2) {
            f5395w = 2;
            synchronized (C) {
                try {
                    v.f fVar = B;
                    fVar.getClass();
                    v.a aVar = new v.a(fVar);
                    while (aVar.hasNext()) {
                        p pVar = (p) ((WeakReference) aVar.next()).get();
                        if (pVar != null) {
                            ((a0) pVar).m(true, true);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void d();

    public abstract void e();

    public abstract boolean g(int i);

    public abstract void h(int i);

    public abstract void i(View view);

    public abstract void j(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void l(CharSequence charSequence);
}
