package yb;

import android.util.Log;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import o8.o;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f14580d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n4.b f14581e = new n4.b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f14582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f14583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f14584c = null;

    public c(Executor executor, n nVar) {
        this.f14582a = executor;
        this.f14583b = nVar;
    }

    public static Object a(o oVar) throws ExecutionException, TimeoutException {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ta.j jVar = new ta.j();
        Executor executor = f14581e;
        oVar.d(executor, jVar);
        oVar.c(executor, jVar);
        oVar.a(executor, jVar);
        if (!((CountDownLatch) jVar.f12372u).await(5L, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (oVar.j()) {
            return oVar.h();
        }
        throw new ExecutionException(oVar.g());
    }

    public static synchronized c d(Executor executor, n nVar) {
        String str;
        HashMap map;
        try {
            str = nVar.f14639b;
            map = f14580d;
            if (!map.containsKey(str)) {
                map.put(str, new c(executor, nVar));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (c) map.get(str);
    }

    public final synchronized o b() {
        try {
            o oVar = this.f14584c;
            if (oVar == null || (oVar.i() && !this.f14584c.j())) {
                Executor executor = this.f14582a;
                n nVar = this.f14583b;
                Objects.requireNonNull(nVar);
                this.f14584c = t1.f(executor, new bb.d(4, nVar));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f14584c;
    }

    public final e c() {
        synchronized (this) {
            try {
                o oVar = this.f14584c;
                if (oVar != null && oVar.j()) {
                    return (e) this.f14584c.h();
                }
                try {
                    o oVarB = b();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    return (e) a(oVarB);
                } catch (InterruptedException | ExecutionException | TimeoutException e10) {
                    Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e10);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final o e(e eVar) {
        l5.d dVar = new l5.d(this, 5, eVar);
        Executor executor = this.f14582a;
        return t1.f(executor, dVar).k(executor, new b2.b(this, 24, eVar));
    }
}
