package com.google.firebase.messaging;

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
import com.google.firebase.messaging.FirebaseMessaging;
import g4.q0;
import ga.g;
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
import k8.j2;
import k8.q2;
import na.f;
import nb.b;
import o4.c;
import o8.o;
import p7.h;
import p7.l;
import p7.m;
import q0.d;
import s.e;
import t7.v;
import ub.i;
import ub.k;
import ub.p;
import ub.t;
import wa.t1;
import y7.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static c f3572l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f3574n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f3575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2.g f3577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f3578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a2.c f3579e;
    public final ScheduledThreadPoolExecutor f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f3580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f3581h;
    public final d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f3571k = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static b f3573m = new f(6);

    public FirebaseMessaging(g gVar, b bVar, b bVar2, ob.d dVar, b bVar3, kb.c cVar) {
        gVar.a();
        Context context = gVar.f5346a;
        final d dVar2 = new d(context);
        final b2.g gVar2 = new b2.g(gVar, dVar2, bVar, bVar2, dVar);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a("Firebase-Messaging-Task"));
        final int i = 1;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Firebase-Messaging-File-Io"));
        final int i10 = 0;
        this.f3582j = false;
        f3573m = bVar3;
        this.f3575a = gVar;
        this.f3579e = new a2.c(this, cVar);
        gVar.a();
        final Context context2 = gVar.f5346a;
        this.f3576b = context2;
        q2 q2Var = new q2();
        this.i = dVar2;
        this.f3577c = gVar2;
        this.f3578d = new i(executorServiceNewSingleThreadExecutor);
        this.f = scheduledThreadPoolExecutor;
        this.f3580g = threadPoolExecutor;
        gVar.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(q2Var);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: ub.j

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f12857v;

            {
                this.f12857v = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f12857v;
                if (firebaseMessaging.f3579e.h() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.f3582j) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                o8.o oVarJ;
                int i11;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f12857v;
                        Context context3 = firebaseMessaging.f3576b;
                        android.support.v4.media.session.b.D(context3);
                        b2.g gVar3 = firebaseMessaging.f3577c;
                        boolean zG = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesP = b8.h.p(context3);
                            if (!sharedPreferencesP.contains("proxy_retention") || sharedPreferencesP.getBoolean("proxy_retention", false) != zG) {
                                p7.b bVar4 = (p7.b) gVar3.f1739d;
                                if (bVar4.f10252c.f() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zG);
                                    p7.m mVarD = p7.m.d(bVar4.f10251b);
                                    synchronized (mVarD) {
                                        i11 = mVarD.f10283u;
                                        mVarD.f10283u = i11 + 1;
                                    }
                                    oVarJ = mVarD.e(new p7.l(i11, 4, bundle, 0));
                                } else {
                                    oVarJ = t1.j(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                oVarJ.d(new n4.b(0), new q0(context3, zG, 3));
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
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new a("Firebase-Messaging-Topics-Io"));
        int i11 = t.f12889j;
        o oVarF = t1.f(scheduledThreadPoolExecutor2, new Callable() { // from class: ub.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                r rVar;
                Context context3 = context2;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor3 = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                q0.d dVar3 = dVar2;
                b2.g gVar3 = gVar2;
                synchronized (r.class) {
                    try {
                        WeakReference weakReference = r.f12880d;
                        rVar = weakReference != null ? (r) weakReference.get() : null;
                        if (rVar == null) {
                            r rVar2 = new r(context3.getSharedPreferences("com.google.android.gms.appid", 0), scheduledThreadPoolExecutor3);
                            rVar2.b();
                            r.f12880d = new WeakReference(rVar2);
                            rVar = rVar2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new t(firebaseMessaging, dVar3, rVar, gVar3, context3, scheduledThreadPoolExecutor3);
            }
        });
        this.f3581h = oVarF;
        oVarF.d(scheduledThreadPoolExecutor, new k(this, i10));
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: ub.j

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f12857v;

            {
                this.f12857v = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f12857v;
                if (firebaseMessaging.f3579e.h() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.f3582j) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                o8.o oVarJ;
                int i112;
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f12857v;
                        Context context3 = firebaseMessaging.f3576b;
                        android.support.v4.media.session.b.D(context3);
                        b2.g gVar3 = firebaseMessaging.f3577c;
                        boolean zG = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesP = b8.h.p(context3);
                            if (!sharedPreferencesP.contains("proxy_retention") || sharedPreferencesP.getBoolean("proxy_retention", false) != zG) {
                                p7.b bVar4 = (p7.b) gVar3.f1739d;
                                if (bVar4.f10252c.f() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zG);
                                    p7.m mVarD = p7.m.d(bVar4.f10251b);
                                    synchronized (mVarD) {
                                        i112 = mVarD.f10283u;
                                        mVarD.f10283u = i112 + 1;
                                    }
                                    oVarJ = mVarD.e(new p7.l(i112, 4, bundle, 0));
                                } else {
                                    oVarJ = t1.j(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                oVarJ.d(new n4.b(0), new q0(context3, zG, 3));
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

    public static void b(Runnable runnable, long j5) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f3574n == null) {
                    f3574n = new ScheduledThreadPoolExecutor(1, new a("TAG"));
                }
                f3574n.schedule(runnable, j5, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized c c(Context context) {
        try {
            if (f3572l == null) {
                f3572l = new c(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3572l;
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(g gVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) gVar.b(FirebaseMessaging.class);
        v.i(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public final String a() {
        o oVarF;
        p pVarD = d();
        if (!i(pVarD)) {
            return pVarD.f12873a;
        }
        String strD = d.d(this.f3575a);
        i iVar = this.f3578d;
        synchronized (iVar) {
            oVarF = (o) ((e) iVar.f12855b).get(strD);
            if (oVarF == null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + strD);
                }
                b2.g gVar = this.f3577c;
                oVarF = gVar.i(gVar.x(d.d((g) gVar.f1737b), "*", new Bundle())).k(this.f3580g, new dd.e(this, strD, pVarD, 11)).f((Executor) iVar.f12854a, new b2.b(iVar, 21, strD));
                ((e) iVar.f12855b).put(strD, oVarF);
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + strD);
            }
        }
        try {
            return (String) t1.d(oVarF);
        } catch (InterruptedException | ExecutionException e10) {
            throw new IOException(e10);
        }
    }

    public final p d() {
        p pVarB;
        c cVarC = c(this.f3576b);
        g gVar = this.f3575a;
        gVar.a();
        String strD = "[DEFAULT]".equals(gVar.f5347b) ? "" : gVar.d();
        String strD2 = d.d(this.f3575a);
        synchronized (cVarC) {
            pVarB = p.b(((SharedPreferences) cVarC.f9349u).getString(strD + "|T|" + strD2 + "|*", null));
        }
        return pVarB;
    }

    public final void e() {
        o oVarJ;
        int i;
        p7.b bVar = (p7.b) this.f3577c.f1739d;
        if (bVar.f10252c.f() >= 241100000) {
            m mVarD = m.d(bVar.f10251b);
            Bundle bundle = Bundle.EMPTY;
            synchronized (mVarD) {
                i = mVarD.f10283u;
                mVarD.f10283u = i + 1;
            }
            oVarJ = mVarD.e(new l(i, 5, bundle, 1)).e(h.f10264w, p7.d.f10258w);
        } else {
            oVarJ = t1.j(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        oVarJ.d(this.f, new k(this, 1));
    }

    public final synchronized void f(boolean z2) {
        this.f3582j = z2;
    }

    public final boolean g() {
        Context context = this.f3576b;
        android.support.v4.media.session.b.D(context);
        if (Build.VERSION.SDK_INT >= 29) {
            if (Binder.getCallingUid() != context.getApplicationInfo().uid) {
                Log.e("FirebaseMessaging", "error retrieving notification delegate for package " + context.getPackageName());
                return false;
            }
            if ("com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "GMS core is set for proxying");
                }
                if (this.f3575a.b(ka.b.class) != null) {
                    return true;
                }
                if (a.a.e() && f3573m != null) {
                    return true;
                }
            }
        } else if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Platform doesn't support proxying.");
        }
        return false;
    }

    public final synchronized void h(long j5) {
        b(new j2(this, Math.min(Math.max(30L, 2 * j5), f3571k)), j5);
        this.f3582j = true;
    }

    public final boolean i(p pVar) {
        if (pVar != null) {
            return System.currentTimeMillis() > pVar.f12875c + p.f12872d || !this.i.b().equals(pVar.f12874b);
        }
        return true;
    }
}
