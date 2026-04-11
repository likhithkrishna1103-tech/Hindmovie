package hb;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements ec.c, ec.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f5898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f5899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ib.k f5900c;

    public l() {
        ib.k kVar = ib.k.f6411v;
        this.f5898a = new HashMap();
        this.f5899b = new ArrayDeque();
        this.f5900c = kVar;
    }

    public final synchronized void a(Executor executor, ec.a aVar) {
        try {
            executor.getClass();
            if (!this.f5898a.containsKey(ab.b.class)) {
                this.f5898a.put(ab.b.class, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f5898a.get(ab.b.class)).put(aVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }
}
