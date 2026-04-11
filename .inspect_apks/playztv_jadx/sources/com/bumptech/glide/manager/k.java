package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.n0;
import h4.z;
import java.util.HashMap;
import l6.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Handler.Callback {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final q9.e f2840y = new q9.e(8);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile com.bumptech.glide.m f2841u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q9.e f2842v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f2843w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final z f2844x;

    public k(q9.e eVar) {
        eVar = eVar == null ? f2840y : eVar;
        this.f2842v = eVar;
        this.f2844x = new z(eVar);
        this.f2843w = (u.f && u.f8001e) ? new e(0) : new t7.j(7);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final com.bumptech.glide.m b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = x6.m.f14291a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof h.j) {
                return c((h.j) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f2841u == null) {
            synchronized (this) {
                try {
                    if (this.f2841u == null) {
                        this.f2841u = this.f2842v.i(com.bumptech.glide.b.a(context.getApplicationContext()), new pa.b(7), new lb.e(8), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f2841u;
    }

    public final com.bumptech.glide.m c(h.j jVar) {
        char[] cArr = x6.m.f14291a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return b(jVar.getApplicationContext());
        }
        if (jVar.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f2843w.l(jVar);
        Activity activityA = a(jVar);
        boolean z2 = activityA == null || !activityA.isFinishing();
        com.bumptech.glide.b bVarA = com.bumptech.glide.b.a(jVar.getApplicationContext());
        androidx.lifecycle.u uVar = jVar.f4244u;
        n0 n0VarO = jVar.o();
        z zVar = this.f2844x;
        zVar.getClass();
        HashMap map = (HashMap) zVar.f5867v;
        x6.m.a();
        x6.m.a();
        com.bumptech.glide.m mVar = (com.bumptech.glide.m) map.get(uVar);
        if (mVar != null) {
            return mVar;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(uVar);
        com.bumptech.glide.m mVarI = ((q9.e) zVar.f5868w).i(bVarA, lifecycleLifecycle, new pa.b(zVar, 8, n0VarO), jVar);
        map.put(uVar, mVarI);
        lifecycleLifecycle.b(new i(zVar, uVar));
        if (z2) {
            mVarI.l();
        }
        return mVarI;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return false;
    }
}
