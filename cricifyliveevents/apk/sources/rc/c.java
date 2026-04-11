package rc;

import android.util.Log;
import j9.p;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f10929d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p.a f10930e = new p.a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f10931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f10932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f10933c = null;

    public c(Executor executor, m mVar) {
        this.f10931a = executor;
        this.f10932b = mVar;
    }

    public static Object a(p pVar) throws ExecutionException, TimeoutException {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        j9.k kVar = new j9.k(1);
        Executor executor = f10930e;
        pVar.d(executor, kVar);
        pVar.c(executor, kVar);
        pVar.a(executor, kVar);
        if (!kVar.f6692w.await(5L, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (pVar.j()) {
            return pVar.h();
        }
        throw new ExecutionException(pVar.g());
    }

    public static synchronized c d(Executor executor, m mVar) {
        String str;
        HashMap map;
        try {
            str = mVar.f10989b;
            map = f10929d;
            if (!map.containsKey(str)) {
                map.put(str, new c(executor, mVar));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (c) map.get(str);
    }

    public final synchronized p b() {
        try {
            p pVar = this.f10933c;
            if (pVar == null || (pVar.i() && !this.f10933c.j())) {
                Executor executor = this.f10931a;
                m mVar = this.f10932b;
                Objects.requireNonNull(mVar);
                this.f10933c = vf.g.e(executor, new g6.k(3, mVar));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10933c;
    }

    public final e c() {
        synchronized (this) {
            try {
                p pVar = this.f10933c;
                if (pVar != null && pVar.j()) {
                    return (e) this.f10933c.h();
                }
                try {
                    p pVarB = b();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    return (e) a(pVarB);
                } catch (InterruptedException | ExecutionException | TimeoutException e9) {
                    Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e9);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final p e(e eVar) {
        b2.j jVar = new b2.j(5, this, eVar);
        Executor executor = this.f10931a;
        return vf.g.e(executor, jVar).k(executor, new androidx.fragment.app.e(19, this, eVar));
    }
}
