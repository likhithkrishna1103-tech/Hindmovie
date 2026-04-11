package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1043a;

    public r(AtomicReference atomicReference) {
        this.f1043a = atomicReference;
    }

    @Override // e.c
    public final void a(Object obj) {
        e.c cVar = (e.c) this.f1043a.get();
        if (cVar == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        cVar.a(obj);
    }
}
