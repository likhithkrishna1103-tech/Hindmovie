package com.google.firebase.messaging;

import ab.g;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.o;
import com.bumptech.glide.l;
import com.google.android.gms.internal.measurement.j4;
import com.google.firebase.messaging.FirebaseMessaging;
import ec.c;
import f9.i3;
import f9.t2;
import hb.f;
import hc.b;
import j9.p;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k4.p0;
import k8.m;
import l4.a;
import nc.h;
import nc.k;
import nc.q;
import nc.u;
import sd.i;
import t0.d;
import v.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static a f3035l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f3037n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f3038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f3040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f3041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f3042e;
    public final ScheduledThreadPoolExecutor f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f3043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f3044h;
    public final d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f3034k = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static b f3036m = new f(6);

    public FirebaseMessaging(g gVar, b bVar, b bVar2, ic.d dVar, b bVar3, c cVar) {
        gVar.a();
        Context context = gVar.f390a;
        final d dVar2 = new d(context);
        final o oVar = new o(gVar, dVar2, bVar, bVar2, dVar);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new t8.a("Firebase-Messaging-Task"));
        final int i = 1;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new t8.a("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new t8.a("Firebase-Messaging-File-Io"));
        final int i10 = 0;
        this.f3045j = false;
        f3036m = bVar3;
        this.f3038a = gVar;
        this.f3042e = new l(this, cVar);
        gVar.a();
        final Context context2 = gVar.f390a;
        this.f3039b = context2;
        t2 t2Var = new t2();
        this.i = dVar2;
        this.f3040c = oVar;
        this.f3041d = new h(executorServiceNewSingleThreadExecutor);
        this.f = scheduledThreadPoolExecutor;
        this.f3043g = threadPoolExecutor;
        gVar.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(t2Var);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: nc.j

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f9058w;

            {
                this.f9058w = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f9058w;
                if (firebaseMessaging.f3042e.k() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.f3045j) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                j9.p pVarZ;
                int i11;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f9058w;
                        Context context3 = firebaseMessaging.f3039b;
                        sd.i.v(context3);
                        c2.o oVar2 = firebaseMessaging.f3040c;
                        boolean zG = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesP = n5.a.p(context3);
                            if (!sharedPreferencesP.contains("proxy_retention") || sharedPreferencesP.getBoolean("proxy_retention", false) != zG) {
                                k8.b bVar4 = (k8.b) oVar2.f2037d;
                                if (bVar4.f7249c.f() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zG);
                                    k8.m mVarD = k8.m.d(bVar4.f7248b);
                                    synchronized (mVarD) {
                                        i11 = mVarD.f7279v;
                                        mVarD.f7279v = i11 + 1;
                                    }
                                    pVarZ = mVarD.e(new k8.l(i11, 4, bundle, 0));
                                } else {
                                    pVarZ = vf.g.z(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                pVarZ.d(new p.a(1), new p0(context3, zG, 3));
                            }
                        }
                        if (firebaseMessaging.g()) {
                            firebaseMessaging.e();
                            return;
                        }
                        return;
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new t8.a("Firebase-Messaging-Topics-Io"));
        int i11 = u.f9090j;
        p pVarE = vf.g.e(scheduledThreadPoolExecutor2, new Callable() { // from class: nc.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                s sVar;
                Context context3 = context2;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor3 = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                t0.d dVar3 = dVar2;
                c2.o oVar2 = oVar;
                synchronized (s.class) {
                    try {
                        WeakReference weakReference = s.f9081d;
                        sVar = weakReference != null ? (s) weakReference.get() : null;
                        if (sVar == null) {
                            s sVar2 = new s(context3.getSharedPreferences("com.google.android.gms.appid", 0), scheduledThreadPoolExecutor3);
                            sVar2.b();
                            s.f9081d = new WeakReference(sVar2);
                            sVar = sVar2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new u(firebaseMessaging, dVar3, sVar, oVar2, context3, scheduledThreadPoolExecutor3);
            }
        });
        this.f3044h = pVarE;
        pVarE.d(scheduledThreadPoolExecutor, new k(this, i10));
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: nc.j

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f9058w;

            {
                this.f9058w = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f9058w;
                if (firebaseMessaging.f3042e.k() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.f3045j) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                j9.p pVarZ;
                int i112;
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f9058w;
                        Context context3 = firebaseMessaging.f3039b;
                        sd.i.v(context3);
                        c2.o oVar2 = firebaseMessaging.f3040c;
                        boolean zG = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesP = n5.a.p(context3);
                            if (!sharedPreferencesP.contains("proxy_retention") || sharedPreferencesP.getBoolean("proxy_retention", false) != zG) {
                                k8.b bVar4 = (k8.b) oVar2.f2037d;
                                if (bVar4.f7249c.f() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zG);
                                    k8.m mVarD = k8.m.d(bVar4.f7248b);
                                    synchronized (mVarD) {
                                        i112 = mVarD.f7279v;
                                        mVarD.f7279v = i112 + 1;
                                    }
                                    pVarZ = mVarD.e(new k8.l(i112, 4, bundle, 0));
                                } else {
                                    pVarZ = vf.g.z(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                pVarZ.d(new p.a(1), new p0(context3, zG, 3));
                            }
                        }
                        if (firebaseMessaging.g()) {
                            firebaseMessaging.e();
                            return;
                        }
                        return;
                }
            }
        });
    }

    public static void b(Runnable runnable, long j4) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f3037n == null) {
                    f3037n = new ScheduledThreadPoolExecutor(1, new t8.a("TAG"));
                }
                f3037n.schedule(runnable, j4, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized a c(Context context) {
        try {
            if (f3035l == null) {
                f3035l = new a(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3035l;
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(g gVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) gVar.b(FirebaseMessaging.class);
        o8.u.h(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public final String a() {
        p pVarF;
        q qVarD = d();
        if (!i(qVarD)) {
            return qVarD.f9074a;
        }
        String strC = d.c(this.f3038a);
        h hVar = this.f3041d;
        synchronized (hVar) {
            pVarF = (p) ((e) hVar.f9053b).get(strC);
            if (pVarF == null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + strC);
                }
                o oVar = this.f3040c;
                pVarF = oVar.j(oVar.z(d.c((g) oVar.f2035b), "*", new Bundle())).k(this.f3043g, new c8.b(this, strC, qVarD, 8)).f((Executor) hVar.f9052a, new androidx.fragment.app.e(15, hVar, strC));
                ((e) hVar.f9053b).put(strC, pVarF);
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + strC);
            }
        }
        try {
            return (String) vf.g.b(pVarF);
        } catch (InterruptedException | ExecutionException e9) {
            throw new IOException(e9);
        }
    }

    public final q d() {
        q qVarB;
        a aVarC = c(this.f3039b);
        g gVar = this.f3038a;
        gVar.a();
        String strD = "[DEFAULT]".equals(gVar.f391b) ? "" : gVar.d();
        String strC = d.c(this.f3038a);
        synchronized (aVarC) {
            qVarB = q.b(((SharedPreferences) aVarC.f7697v).getString(strD + "|T|" + strC + "|*", null));
        }
        return qVarB;
    }

    public final void e() {
        p pVarZ;
        int i;
        k8.b bVar = (k8.b) this.f3040c.f2037d;
        if (bVar.f7249c.f() >= 241100000) {
            m mVarD = m.d(bVar.f7248b);
            Bundle bundle = Bundle.EMPTY;
            synchronized (mVarD) {
                i = mVarD.f7279v;
                mVarD.f7279v = i + 1;
            }
            pVarZ = mVarD.e(new k8.l(i, 5, bundle, 1)).e(k8.h.f7261x, k8.d.f7255x);
        } else {
            pVarZ = vf.g.z(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        pVarZ.d(this.f, new k(this, 1));
    }

    public final synchronized void f(boolean z10) {
        this.f3045j = z10;
    }

    public final boolean g() {
        Context context = this.f3039b;
        i.v(context);
        if (Build.VERSION.SDK_INT >= 29) {
            if (Binder.getCallingUid() != context.getApplicationInfo().uid) {
                Log.e("FirebaseMessaging", "error retrieving notification delegate for package " + context.getPackageName());
                return false;
            }
            if ("com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "GMS core is set for proxying");
                }
                if (this.f3038a.b(eb.b.class) != null) {
                    return true;
                }
                if (j4.e() && f3036m != null) {
                    return true;
                }
            }
        } else if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Platform doesn't support proxying.");
        }
        return false;
    }

    public final synchronized void h(long j4) {
        b(new i3(this, Math.min(Math.max(30L, 2 * j4), f3034k)), j4);
        this.f3045j = true;
    }

    public final boolean i(q qVar) {
        if (qVar != null) {
            return System.currentTimeMillis() > qVar.f9076c + q.f9073d || !this.i.a().equals(qVar.f9075b);
        }
        return true;
    }
}
