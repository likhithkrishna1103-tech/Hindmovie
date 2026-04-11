package pe;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 extends ue.j implements h0, s0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c1 f10290y;

    @Override // pe.s0
    public final boolean a() {
        return true;
    }

    @Override // pe.h0
    public final void b() {
        c1 c1VarJ = j();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c1.f10226v;
            Object obj = atomicReferenceFieldUpdater.get(c1VarJ);
            if (obj instanceof y0) {
                if (obj != this) {
                    return;
                }
                i0 i0Var = x.f10288j;
                while (!atomicReferenceFieldUpdater.compareAndSet(c1VarJ, obj, i0Var)) {
                    if (atomicReferenceFieldUpdater.get(c1VarJ) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof s0) || ((s0) obj).d() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = ue.j.f12470v;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof ue.o) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                ge.i.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                ue.j jVar = (ue.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = ue.j.f12472x;
                ue.o oVar = (ue.o) atomicReferenceFieldUpdater3.get(jVar);
                if (oVar == null) {
                    oVar = new ue.o(jVar);
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

    @Override // pe.s0
    public final d1 d() {
        return null;
    }

    public v0 getParent() {
        return j();
    }

    public final c1 j() {
        c1 c1Var = this.f10290y;
        if (c1Var != null) {
            return c1Var;
        }
        ge.i.i("job");
        throw null;
    }

    public abstract boolean k();

    public abstract void l(Throwable th);

    @Override // ue.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + x.g(this) + "[job@" + x.g(j()) + ']';
    }
}
