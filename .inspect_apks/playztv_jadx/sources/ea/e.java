package ea;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends android.support.v4.media.session.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f4603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f4604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f4605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f4606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f4607e;

    public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f4603a = atomicReferenceFieldUpdater;
        this.f4604b = atomicReferenceFieldUpdater2;
        this.f4605c = atomicReferenceFieldUpdater3;
        this.f4606d = atomicReferenceFieldUpdater4;
        this.f4607e = atomicReferenceFieldUpdater5;
    }

    @Override // android.support.v4.media.session.b
    public final void M(o oVar, o oVar2) {
        this.f4604b.lazySet(oVar, oVar2);
    }

    @Override // android.support.v4.media.session.b
    public final void N(o oVar, Thread thread) {
        this.f4603a.lazySet(oVar, thread);
    }

    @Override // android.support.v4.media.session.b
    public final boolean e(p pVar, d dVar, d dVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f4606d;
            if (atomicReferenceFieldUpdater.compareAndSet(pVar, dVar, dVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(pVar) == dVar);
        return false;
    }

    @Override // android.support.v4.media.session.b
    public final boolean f(p pVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f4607e;
            if (atomicReferenceFieldUpdater.compareAndSet(pVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(pVar) == obj);
        return false;
    }

    @Override // android.support.v4.media.session.b
    public final boolean g(p pVar, o oVar, o oVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f4605c;
            if (atomicReferenceFieldUpdater.compareAndSet(pVar, oVar, oVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(pVar) == oVar);
        return false;
    }

    @Override // android.support.v4.media.session.b
    public final d p(p pVar) {
        return (d) this.f4606d.getAndSet(pVar, d.f4598d);
    }

    @Override // android.support.v4.media.session.b
    public final o q(p pVar) {
        return (o) this.f4605c.getAndSet(pVar, o.f4619c);
    }
}
