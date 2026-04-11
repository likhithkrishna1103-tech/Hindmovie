package nb;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n8.k f8979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f8980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i2.k f8982e;
    public i2.k f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f8983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v f8984h;
    public final tb.c i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jb.a f8985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final jb.a f8986k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f8987l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final kb.a f8988m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p6.c f8989n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ob.c f8990o;

    public p(ab.g gVar, v vVar, kb.a aVar, n8.k kVar, jb.a aVar2, jb.a aVar3, tb.c cVar, i iVar, p6.c cVar2, ob.c cVar3) {
        this.f8979b = kVar;
        gVar.a();
        this.f8978a = gVar.f390a;
        this.f8984h = vVar;
        this.f8988m = aVar;
        this.f8985j = aVar2;
        this.f8986k = aVar3;
        this.i = cVar;
        this.f8987l = iVar;
        this.f8989n = cVar2;
        this.f8990o = cVar3;
        this.f8981d = System.currentTimeMillis();
        this.f8980c = new w(0);
    }

    public final void a(d8.j jVar) {
        ob.c.a();
        ob.c.a();
        this.f8982e.b();
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Initialization marker file was created.", null);
        }
        try {
            try {
                this.f8985j.a(new n(this));
                this.f8983g.f();
                if (!jVar.d().f13546b.f6039a) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Collection of crash reports disabled in Crashlytics settings.", null);
                    }
                    throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
                }
                if (!this.f8983g.d(jVar)) {
                    Log.w("FirebaseCrashlytics", "Previous sessions could not be finalized.", null);
                }
                this.f8983g.g(((j9.i) ((AtomicReference) jVar.i).get()).f6688a);
                c();
            } catch (Exception e9) {
                Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e9);
                c();
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }

    public final void b(d8.j jVar) {
        Future<?> futureSubmit = this.f8990o.f9742a.f9739v.submit(new m(this, jVar, 1));
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.", null);
        }
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e9) {
            Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e9);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e10) {
            Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during initialization.", e10);
        } catch (TimeoutException e11) {
            Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e11);
        }
    }

    public final void c() {
        ob.c.a();
        try {
            i2.k kVar = this.f8982e;
            tb.c cVar = (tb.c) kVar.f6086w;
            String str = (String) kVar.f6085v;
            cVar.getClass();
            if (new File((File) cVar.f11985x, str).delete()) {
                return;
            }
            Log.w("FirebaseCrashlytics", "Initialization marker file was not properly removed.", null);
        } catch (Exception e9) {
            Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e9);
        }
    }
}
