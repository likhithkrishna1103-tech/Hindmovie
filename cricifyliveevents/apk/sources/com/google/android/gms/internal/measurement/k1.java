package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile k1 f2502g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f2503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.d f2504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2507e;
    public volatile j0 f;

    public k1(Context context, Bundle bundle) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new f1(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2503a = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f2504b = new p6.d(11, this);
        this.f2505c = new ArrayList();
        try {
            if (f9.h2.b(context, f9.h2.a(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, k1.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.f2507e = true;
                    Log.w("FA", "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        c(new z0(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w("FA", "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new j1(this));
        }
    }

    public static k1 e(Context context, Bundle bundle) {
        o8.u.g(context);
        if (f2502g == null) {
            synchronized (k1.class) {
                try {
                    if (f2502g == null) {
                        f2502g = new k1(context, bundle);
                    }
                } finally {
                }
            }
        }
        return f2502g;
    }

    public final Map a(String str, String str2, boolean z10) {
        g0 g0Var = new g0();
        c(new e1(this, str, str2, z10, g0Var));
        Bundle bundleE = g0Var.e(5000L);
        if (bundleE == null || bundleE.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleE.size());
        for (String str3 : bundleE.keySet()) {
            Object obj = bundleE.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final int b(String str) {
        g0 g0Var = new g0();
        c(new z0(this, str, g0Var));
        Integer num = (Integer) g0.f(g0Var.e(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final void c(g1 g1Var) {
        this.f2503a.execute(g1Var);
    }

    public final void d(Exception exc, boolean z10, boolean z11) {
        this.f2507e |= z10;
        if (z10) {
            Log.w("FA", "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z11) {
            c(new w0(this, exc));
        }
        Log.w("FA", "Error with data collection. Data lost.", exc);
    }

    public final List f(String str, String str2) {
        g0 g0Var = new g0();
        c(new y0(this, str, str2, g0Var));
        List list = (List) g0.f(g0Var.e(5000L), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }
}
