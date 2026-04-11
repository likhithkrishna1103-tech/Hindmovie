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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final o f5550u = new o(new p(0));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f5551v = -100;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static m0.g f5552w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static m0.g f5553x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static Boolean f5554y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f5555z = false;
    public static final s.f A = new s.f(0);
    public static final Object B = new Object();
    public static final Object C = new Object();

    public static boolean c(Context context) {
        if (f5554y == null) {
            try {
                int i = h0.f5500u;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) h0.class), Build.VERSION.SDK_INT >= 24 ? g0.a() | 128 : 640).metaData;
                if (bundle != null) {
                    f5554y = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f5554y = Boolean.FALSE;
            }
        }
        return f5554y.booleanValue();
    }

    public static void f(b0 b0Var) {
        synchronized (B) {
            try {
                s.f fVar = A;
                fVar.getClass();
                s.a aVar = new s.a(fVar);
                while (aVar.hasNext()) {
                    q qVar = (q) ((WeakReference) aVar.next()).get();
                    if (qVar == b0Var || qVar == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void l() {
        if (f5551v != 2) {
            f5551v = 2;
            synchronized (B) {
                try {
                    s.f fVar = A;
                    fVar.getClass();
                    s.a aVar = new s.a(fVar);
                    while (aVar.hasNext()) {
                        q qVar = (q) ((WeakReference) aVar.next()).get();
                        if (qVar != null) {
                            ((b0) qVar).n(true, true);
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

    public abstract boolean h(int i);

    public abstract void i(int i);

    public abstract void j(View view);

    public abstract void k(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void m(CharSequence charSequence);
}
