package pe;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Thread f10223y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o0 f10224z;

    public c(vd.h hVar, Thread thread, o0 o0Var) {
        super(hVar, true);
        this.f10223y = thread;
        this.f10224z = o0Var;
    }

    @Override // pe.c1
    public final void j(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f10223y;
        if (ge.i.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
