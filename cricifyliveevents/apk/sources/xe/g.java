package xe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.o1;
import rd.l;
import ue.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f14495v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final pe.g f14496w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f14492x = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f14493y = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx$volatile");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f14494z = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater A = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater B = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits$volatile");

    public g(int i, int i10) {
        this.f14495v = i;
        if (i <= 0) {
            throw new IllegalArgumentException(l0.e.g(i, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i10 < 0 || i10 > i) {
            throw new IllegalArgumentException(l0.e.g(i, "The number of acquired permits should be in 0..").toString());
        }
        j jVar = new j(0L, null, 2);
        this.head$volatile = jVar;
        this.tail$volatile = jVar;
        this._availablePermits$volatile = i - i10;
        this.f14496w = new pe.g(2, this);
    }

    public final boolean b(o1 o1Var) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14494z;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        long andIncrement = A.getAndIncrement(this);
        e eVar = e.D;
        long j4 = andIncrement / ((long) i.f);
        loop0: while (true) {
            objB = ue.a.b(jVar, j4, eVar);
            if (!ue.a.e(objB)) {
                r rVarC = ue.a.c(objB);
                while (true) {
                    r rVar = (r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f12485c >= rVarC.f12485c) {
                        break loop0;
                    }
                    if (!rVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, rVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != rVar) {
                            if (rVarC.e()) {
                                rVarC.d();
                            }
                        }
                    }
                    if (rVar.e()) {
                        rVar.d();
                    }
                }
            } else {
                break;
            }
        }
        j jVar2 = (j) ue.a.c(objB);
        AtomicReferenceArray atomicReferenceArray = jVar2.f14502e;
        int i = (int) (andIncrement % ((long) i.f));
        while (!atomicReferenceArray.compareAndSet(i, null, o1Var)) {
            if (atomicReferenceArray.get(i) != null) {
                d5.a aVar = i.f14498b;
                d5.a aVar2 = i.f14499c;
                while (!atomicReferenceArray.compareAndSet(i, aVar, aVar2)) {
                    if (atomicReferenceArray.get(i) != aVar) {
                        return false;
                    }
                }
                ((pe.f) o1Var).k(l.f11003a, this.f14496w);
                return true;
            }
        }
        o1Var.a(jVar2, i);
        return true;
    }

    public final void c() {
        int i;
        Object objB;
        boolean z10;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = B;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i10 = this.f14495v;
            if (andIncrement >= i10) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i10) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i10));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i10).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14492x;
            j jVar = (j) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f14493y.getAndIncrement(this);
            long j4 = andIncrement2 / ((long) i.f);
            f fVar = f.D;
            while (true) {
                objB = ue.a.b(jVar, j4, fVar);
                if (ue.a.e(objB)) {
                    break;
                }
                r rVarC = ue.a.c(objB);
                while (true) {
                    r rVar = (r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f12485c >= rVarC.f12485c) {
                        break;
                    }
                    if (!rVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, rVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != rVar) {
                            if (rVarC.e()) {
                                rVarC.d();
                            }
                        }
                    }
                    if (rVar.e()) {
                        rVar.d();
                    }
                }
            }
            j jVar2 = (j) ue.a.c(objB);
            AtomicReferenceArray atomicReferenceArray = jVar2.f14502e;
            jVar2.a();
            z10 = false;
            if (jVar2.f12485c <= j4) {
                int i11 = (int) (andIncrement2 % ((long) i.f));
                Object andSet = atomicReferenceArray.getAndSet(i11, i.f14498b);
                if (andSet == null) {
                    int i12 = i.f14497a;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (atomicReferenceArray.get(i11) == i.f14499c) {
                            z10 = true;
                            break;
                        }
                    }
                    d5.a aVar = i.f14498b;
                    d5.a aVar2 = i.f14500d;
                    while (true) {
                        if (!atomicReferenceArray.compareAndSet(i11, aVar, aVar2)) {
                            if (atomicReferenceArray.get(i11) != aVar) {
                                break;
                            }
                        } else {
                            z10 = true;
                            break;
                        }
                    }
                    z10 = !z10;
                } else if (andSet != i.f14501e) {
                    if (!(andSet instanceof pe.f)) {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    pe.f fVar2 = (pe.f) andSet;
                    d5.a aVarC = fVar2.c(l.f11003a, this.f14496w);
                    if (aVarC != null) {
                        fVar2.l(aVarC);
                        z10 = true;
                        break;
                        break;
                    }
                }
            }
        } while (!z10);
    }
}
