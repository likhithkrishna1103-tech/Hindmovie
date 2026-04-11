package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i1 {
    public static volatile i1 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3043a = "FA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x7.a f3044b = x7.a.f14294a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f3045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rc.b f3046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f3047e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile s0 f3049h;

    public i1(Context context, Bundle bundle) {
        n1 n1Var = new n1();
        n1Var.f3116a = Executors.defaultThreadFactory();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), n1Var);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f3045c = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f3046d = new rc.b(16, this);
        this.f3047e = new ArrayList();
        int i10 = 0;
        try {
            String strB = k8.c2.b(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(strB)) {
                strB = k8.c2.b(context);
            }
            int identifier = resources.getIdentifier("google_app_id", "string", strB);
            String string = null;
            if (identifier != 0) {
                try {
                    string = resources.getString(identifier);
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (string != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, i1.class.getClassLoader());
                } catch (ClassNotFoundException unused2) {
                    this.f3048g = true;
                    Log.w(this.f3043a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused3) {
        }
        e(new e1(this, context, bundle, i10));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f3043a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new h1(this));
        }
    }

    public static i1 b(Context context, Bundle bundle) {
        t7.v.h(context);
        if (i == null) {
            synchronized (i1.class) {
                try {
                    if (i == null) {
                        i = new i1(context, bundle);
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public final int a(String str) {
        t0 t0Var = new t0();
        e(new e1(this, str, t0Var, 1));
        Integer num = (Integer) t0.f(t0Var.e(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final List c(String str, String str2) {
        t0 t0Var = new t0();
        e(new l1(this, str, str2, t0Var));
        List list = (List) t0.f(t0Var.e(5000L), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final Map d(String str, String str2, boolean z2) {
        t0 t0Var = new t0();
        e(new q1(this, str, str2, z2, t0Var));
        Bundle bundleE = t0Var.e(5000L);
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

    public final void e(f1 f1Var) {
        this.f3045c.execute(f1Var);
    }

    public final void f(Exception exc, boolean z2, boolean z10) {
        this.f3048g |= z2;
        String str = this.f3043a;
        if (z2) {
            Log.w(str, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z10) {
            e(new j1(this, exc));
        }
        Log.w(str, "Error with data collection. Data lost.", exc);
    }
}
