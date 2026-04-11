package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.r0;
import g7.w;
import java.util.HashMap;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Handler.Callback {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ka.f f2268z = new ka.f(9);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile com.bumptech.glide.p f2269v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k f2270w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f2271x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c0 f2272y;

    public l(k kVar) {
        kVar = kVar == null ? f2268z : kVar;
        this.f2270w = kVar;
        this.f2272y = new c0(kVar);
        this.f2271x = (w.f && w.f5219e) ? new e(0) : new o8.j(8);
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

    public final com.bumptech.glide.p b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = s7.m.f11607a;
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
        if (this.f2269v == null) {
            synchronized (this) {
                try {
                    if (this.f2269v == null) {
                        this.f2269v = this.f2270w.b(com.bumptech.glide.b.a(context.getApplicationContext()), new jb.b(8), new fc.e(9), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f2269v;
    }

    public final com.bumptech.glide.p c(h.j jVar) {
        char[] cArr = s7.m.f11607a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return b(jVar.getApplicationContext());
        }
        if (jVar.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.f2271x.f(jVar);
        Activity activityA = a(jVar);
        boolean z10 = activityA == null || !activityA.isFinishing();
        com.bumptech.glide.b bVarA = com.bumptech.glide.b.a(jVar.getApplicationContext());
        androidx.lifecycle.u uVar = jVar.f5437v;
        r0 r0VarO = jVar.o();
        c0 c0Var = this.f2272y;
        c0Var.getClass();
        HashMap map = (HashMap) c0Var.f7705w;
        s7.m.a();
        s7.m.a();
        com.bumptech.glide.p pVar = (com.bumptech.glide.p) map.get(uVar);
        if (pVar != null) {
            return pVar;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(uVar);
        com.bumptech.glide.p pVarB = ((k) c0Var.f7706x).b(bVarA, lifecycleLifecycle, new jb.b(c0Var, r0VarO), jVar);
        map.put(uVar, pVarB);
        lifecycleLifecycle.b(new i(c0Var, uVar));
        if (z10) {
            pVarB.l();
        }
        return pVarB;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return false;
    }
}
