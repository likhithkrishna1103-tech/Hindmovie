package ta;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2.p f12405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pb.c f12406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p2.c f12408e;
    public p2.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f12409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v f12410h;
    public final za.c i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final pa.a f12411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final pa.a f12412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f12413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final qa.a f12414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q0.e f12415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ua.d f12416o;

    public q(ga.g gVar, v vVar, qa.a aVar, o2.p pVar, pa.a aVar2, pa.a aVar3, za.c cVar, i iVar, q0.e eVar, ua.d dVar) {
        this.f12405b = pVar;
        gVar.a();
        this.f12404a = gVar.f5346a;
        this.f12410h = vVar;
        this.f12414m = aVar;
        this.f12411j = aVar2;
        this.f12412k = aVar3;
        this.i = cVar;
        this.f12413l = iVar;
        this.f12415n = eVar;
        this.f12416o = dVar;
        this.f12407d = System.currentTimeMillis();
        this.f12406c = new pb.c(12);
    }

    public final void a(b7.s sVar) {
        ua.d.a();
        ua.d.a();
        this.f12408e.g();
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Initialization marker file was created.", null);
        }
        try {
            try {
                this.f12411j.e(new o(this));
                this.f12409g.f();
                if (!sVar.d().f1981b.f1977a) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Collection of crash reports disabled in Crashlytics settings.", null);
                    }
                    throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
                }
                if (!this.f12409g.d(sVar)) {
                    Log.w("FirebaseCrashlytics", "Previous sessions could not be finalized.", null);
                }
                this.f12409g.g(((o8.h) ((AtomicReference) sVar.i).get()).f9421a);
                c();
            } catch (Exception e10) {
                Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e10);
                c();
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }

    public final void b(b7.s sVar) {
        Future<?> futureSubmit = this.f12416o.f12823a.f12820u.submit(new n(this, sVar, 1));
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.", null);
        }
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e10);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e11) {
            Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during initialization.", e11);
        } catch (TimeoutException e12) {
            Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e12);
        }
    }

    public final void c() {
        ua.d.a();
        try {
            p2.c cVar = this.f12408e;
            za.c cVar2 = (za.c) cVar.f10131w;
            String str = (String) cVar.f10130v;
            cVar2.getClass();
            if (new File((File) cVar2.f14936c, str).delete()) {
                return;
            }
            Log.w("FirebaseCrashlytics", "Initialization marker file was not properly removed.", null);
        } catch (Exception e10) {
            Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e10);
        }
    }
}
