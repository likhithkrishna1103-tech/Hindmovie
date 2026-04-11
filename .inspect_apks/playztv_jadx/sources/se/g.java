package se;

import i4.o0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ke.p1;
import nd.k;
import pe.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11951u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ke.f f11952v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11947w = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head$volatile");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f11948x = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx$volatile");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11949y = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail$volatile");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f11950z = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater A = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits$volatile");

    public g(int i, int i10) {
        this.f11951u = i;
        if (i <= 0) {
            throw new IllegalArgumentException(e6.j.l("Semaphore should have at least 1 permit, but had ", i).toString());
        }
        if (i10 < 0 || i10 > i) {
            throw new IllegalArgumentException(e6.j.l("The number of acquired permits should be in 0..", i).toString());
        }
        j jVar = new j(0L, null, 2);
        this.head$volatile = jVar;
        this.tail$volatile = jVar;
        this._availablePermits$volatile = i - i10;
        this.f11952v = new ke.f(2, this);
    }

    public final boolean b(p1 p1Var) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11949y;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f11950z.getAndIncrement(this);
        e eVar = e.C;
        long j5 = andIncrement / ((long) i.f);
        loop0: while (true) {
            objB = pe.a.b(jVar, j5, eVar);
            if (!pe.a.e(objB)) {
                r rVarC = pe.a.c(objB);
                while (true) {
                    r rVar = (r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f10399c >= rVarC.f10399c) {
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
        j jVar2 = (j) pe.a.c(objB);
        AtomicReferenceArray atomicReferenceArray = jVar2.f11958e;
        int i = (int) (andIncrement % ((long) i.f));
        while (!atomicReferenceArray.compareAndSet(i, null, p1Var)) {
            if (atomicReferenceArray.get(i) != null) {
                o0 o0Var = i.f11954b;
                o0 o0Var2 = i.f11955c;
                while (!atomicReferenceArray.compareAndSet(i, o0Var, o0Var2)) {
                    if (atomicReferenceArray.get(i) != o0Var) {
                        return false;
                    }
                }
                ((ke.e) p1Var).e(k.f8990a, this.f11952v);
                return true;
            }
        }
        p1Var.a(jVar2, i);
        return true;
    }

    public final void c() {
        int i;
        Object objB;
        boolean z2;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = A;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i10 = this.f11951u;
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
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11947w;
            j jVar = (j) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f11948x.getAndIncrement(this);
            long j5 = andIncrement2 / ((long) i.f);
            f fVar = f.C;
            while (true) {
                objB = pe.a.b(jVar, j5, fVar);
                if (pe.a.e(objB)) {
                    break;
                }
                r rVarC = pe.a.c(objB);
                while (true) {
                    r rVar = (r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f10399c >= rVarC.f10399c) {
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
            j jVar2 = (j) pe.a.c(objB);
            AtomicReferenceArray atomicReferenceArray = jVar2.f11958e;
            jVar2.a();
            z2 = false;
            if (jVar2.f10399c <= j5) {
                int i11 = (int) (andIncrement2 % ((long) i.f));
                Object andSet = atomicReferenceArray.getAndSet(i11, i.f11954b);
                if (andSet == null) {
                    int i12 = i.f11953a;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (atomicReferenceArray.get(i11) == i.f11955c) {
                            z2 = true;
                            break;
                        }
                    }
                    o0 o0Var = i.f11954b;
                    o0 o0Var2 = i.f11956d;
                    while (true) {
                        if (!atomicReferenceArray.compareAndSet(i11, o0Var, o0Var2)) {
                            if (atomicReferenceArray.get(i11) != o0Var) {
                                break;
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = !z2;
                } else if (andSet != i.f11957e) {
                    if (!(andSet instanceof ke.e)) {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    ke.e eVar = (ke.e) andSet;
                    o0 o0VarK = eVar.k(k.f8990a, this.f11952v);
                    if (o0VarK != null) {
                        eVar.l(o0VarK);
                        z2 = true;
                        break;
                        break;
                    }
                }
            }
        } while (!z2);
    }
}
