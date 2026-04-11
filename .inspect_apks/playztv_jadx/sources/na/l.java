package na;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements kb.c, kb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f8902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f8903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oa.j f8904c;

    public l() {
        oa.j jVar = oa.j.f9477u;
        this.f8902a = new HashMap();
        this.f8903b = new ArrayDeque();
        this.f8904c = jVar;
    }

    public final synchronized void a(Executor executor, kb.a aVar) {
        try {
            executor.getClass();
            if (!this.f8902a.containsKey(ga.b.class)) {
                this.f8902a.put(ga.b.class, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f8902a.get(ga.b.class)).put(aVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }
}
