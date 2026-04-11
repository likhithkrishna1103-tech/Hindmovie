package ke;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class z0 extends pe.j implements h0, s0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d1 f7750x;

    @Override // ke.s0
    public final boolean a() {
        return true;
    }

    @Override // ke.h0
    public final void b() {
        d1 d1VarJ = j();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d1.f7686u;
            Object obj = atomicReferenceFieldUpdater.get(d1VarJ);
            if (obj instanceof z0) {
                if (obj != this) {
                    return;
                }
                j0 j0Var = x.f7747j;
                while (!atomicReferenceFieldUpdater.compareAndSet(d1VarJ, obj, j0Var)) {
                    if (atomicReferenceFieldUpdater.get(d1VarJ) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof s0) || ((s0) obj).d() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = pe.j.f10384u;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof pe.o) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                be.h.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                pe.j jVar = (pe.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = pe.j.f10386w;
                pe.o oVar = (pe.o) atomicReferenceFieldUpdater3.get(jVar);
                if (oVar == null) {
                    oVar = new pe.o(jVar);
                    atomicReferenceFieldUpdater3.set(jVar, oVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, oVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                jVar.f();
                return;
            }
        }
    }

    @Override // ke.s0
    public final e1 d() {
        return null;
    }

    public v0 getParent() {
        return j();
    }

    public final d1 j() {
        d1 d1Var = this.f7750x;
        if (d1Var != null) {
            return d1Var;
        }
        be.h.i("job");
        throw null;
    }

    public abstract boolean k();

    public abstract void l(Throwable th);

    @Override // pe.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + x.f(this) + "[job@" + x.f(j()) + ']';
    }
}
