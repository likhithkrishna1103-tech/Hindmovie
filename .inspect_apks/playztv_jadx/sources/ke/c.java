package ke;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Thread f7678x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final o0 f7679y;

    public c(rd.h hVar, Thread thread, o0 o0Var) {
        super(hVar, true);
        this.f7678x = thread;
        this.f7679y = o0Var;
    }

    @Override // ke.d1
    public final void h(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f7678x;
        if (be.h.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
