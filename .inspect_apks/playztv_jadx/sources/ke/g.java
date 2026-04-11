package ke;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class g extends d0 implements e, td.d, p1 {
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final rd.c f7693x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final rd.h f7694y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7692z = AtomicIntegerFieldUpdater.newUpdater(g.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater A = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater B = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_parentHandle$volatile");

    public g(int i, rd.c cVar) {
        super(i);
        this.f7693x = cVar;
        this.f7694y = cVar.f();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f7675a;
    }

    public static void A(g1 g1Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + g1Var + ", already has " + obj).toString());
    }

    public static Object E(g1 g1Var, Object obj, int i, ae.q qVar) {
        if (obj instanceof o) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (qVar != null || (g1Var instanceof i0)) {
            return new n(obj, g1Var instanceof i0 ? (i0) g1Var : null, qVar, (CancellationException) null, 16);
        }
        return obj;
    }

    public String B() {
        return "CancellableContinuation";
    }

    public final void C() {
        rd.c cVar = this.f7693x;
        Throwable th = null;
        pe.f fVar = cVar instanceof pe.f ? (pe.f) cVar : null;
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pe.f.B;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                i4.o0 o0Var = pe.a.f10367c;
                if (obj == o0Var) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, o0Var, this)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != o0Var) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            r();
            q(th);
        }
    }

    public final void D(Object obj, int i, ae.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof g1) {
                Object objE = E((g1) obj2, obj, i, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objE)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!z()) {
                    r();
                }
                s(i);
                return;
            }
            if (obj2 instanceof h) {
                h hVar = (h) obj2;
                if (h.f7696c.compareAndSet(hVar, 0, 1)) {
                    if (qVar != null) {
                        o(qVar, hVar.f7717a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    @Override // ke.p1
    public final void a(pe.r rVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f7692z;
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, ((i10 >> 29) << 29) + i));
        y(rVar);
    }

    @Override // ke.d0
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof g1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof o) {
                return;
            }
            if (!(obj instanceof n)) {
                cancellationException2 = cancellationException;
                n nVar = new n(obj, (i0) null, (ae.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            n nVar2 = (n) obj;
            if (nVar2.f7714e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            n nVarA = n.a(nVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            i0 i0Var = nVar2.f7711b;
            if (i0Var != null) {
                n(i0Var, cancellationException);
            }
            ae.q qVar = nVar2.f7712c;
            if (qVar != null) {
                o(qVar, cancellationException, nVar2.f7710a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // td.d
    public final td.d c() {
        rd.c cVar = this.f7693x;
        if (cVar instanceof td.d) {
            return (td.d) cVar;
        }
        return null;
    }

    @Override // ke.d0
    public final rd.c d() {
        return this.f7693x;
    }

    @Override // ke.e
    public final void e(Object obj, ae.q qVar) {
        D(obj, this.f7685w, qVar);
    }

    @Override // rd.c
    public final rd.h f() {
        return this.f7694y;
    }

    @Override // rd.c
    public final void g(Object obj) {
        Throwable thA = nd.h.a(obj);
        if (thA != null) {
            obj = new o(thA, false);
        }
        D(obj, this.f7685w, null);
    }

    @Override // ke.d0
    public final Throwable h(Object obj) {
        Throwable thH = super.h(obj);
        if (thH != null) {
            return thH;
        }
        return null;
    }

    @Override // ke.d0
    public final Object i(Object obj) {
        return obj instanceof n ? ((n) obj).f7710a : obj;
    }

    @Override // ke.e
    public final i4.o0 k(Object obj, ae.q qVar) {
        i4.o0 o0Var = x.f7740a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof g1)) {
                return null;
            }
            Object objE = E((g1) obj2, obj, this.f7685w, qVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objE)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!z()) {
                r();
            }
            return o0Var;
        }
    }

    @Override // ke.e
    public final void l(Object obj) {
        s(this.f7685w);
    }

    @Override // ke.d0
    public final Object m() {
        return A.get(this);
    }

    public final void n(i0 i0Var, Throwable th) {
        try {
            i0Var.f7699a.b();
        } catch (Throwable th2) {
            x.h(new a2.y0("Exception in invokeOnCancellation handler for " + this, th2), this.f7694y);
        }
    }

    public final void o(ae.q qVar, Throwable th, Object obj) {
        rd.h hVar = this.f7694y;
        try {
            qVar.h(th, obj, hVar);
        } catch (Throwable th2) {
            x.h(new a2.y0("Exception in resume onCancellation handler for " + this, th2), hVar);
        }
    }

    public final void p(pe.r rVar, Throwable th) {
        rd.h hVar = this.f7694y;
        int i = f7692z.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            rVar.g(i, hVar);
        } catch (Throwable th2) {
            x.h(new a2.y0("Exception in invokeOnCancellation handler for " + this, th2), hVar);
        }
    }

    public final boolean q(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof g1)) {
                return false;
            }
            h hVar = new h(this, th, (obj instanceof i0) || (obj instanceof pe.r));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, hVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            g1 g1Var = (g1) obj;
            if (g1Var instanceof i0) {
                n((i0) obj, th);
            } else if (g1Var instanceof pe.r) {
                p((pe.r) obj, th);
            }
            if (!z()) {
                r();
            }
            s(this.f7685w);
            return true;
        }
    }

    public final void r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
        h0 h0Var = (h0) atomicReferenceFieldUpdater.get(this);
        if (h0Var == null) {
            return;
        }
        h0Var.b();
        atomicReferenceFieldUpdater.set(this, f1.f7691u);
    }

    public final void s(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f7692z;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z2 = i == 4;
                rd.c cVar = this.f7693x;
                if (!z2 && (cVar instanceof pe.f)) {
                    boolean z10 = i == 1 || i == 2;
                    int i12 = this.f7685w;
                    if (z10 == (i12 == 1 || i12 == 2)) {
                        pe.f fVar = (pe.f) cVar;
                        r rVar = fVar.f10376x;
                        rd.h hVarF = fVar.f10377y.f();
                        if (rVar.i0(hVarF)) {
                            rVar.h0(hVarF, this);
                            return;
                        }
                        o0 o0VarA = j1.a();
                        if (o0VarA.f7719w < 4294967296L) {
                            o0VarA.m0(true);
                            try {
                                x.l(this, cVar, true);
                                do {
                                } while (o0VarA.o0());
                            } finally {
                                try {
                                } finally {
                                }
                            }
                            return;
                        }
                        od.g gVar = o0VarA.f7721y;
                        if (gVar == null) {
                            gVar = new od.g();
                            o0VarA.f7721y = gVar;
                        }
                        gVar.addLast(this);
                        return;
                    }
                }
                x.l(this, cVar, z2);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
    }

    public Throwable t(d1 d1Var) {
        return d1Var.s();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(B());
        sb2.append('(');
        sb2.append(x.n(this.f7693x));
        sb2.append("){");
        Object obj = A.get(this);
        sb2.append(obj instanceof g1 ? "Active" : obj instanceof h ? "Cancelled" : "Completed");
        sb2.append("}@");
        sb2.append(x.f(this));
        return sb2.toString();
    }

    public final Object u() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        v0 v0Var;
        boolean z2 = z();
        do {
            atomicIntegerFieldUpdater = f7692z;
            i = atomicIntegerFieldUpdater.get(this);
            int i10 = i >> 29;
            if (i10 != 0) {
                if (i10 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (z2) {
                    C();
                }
                Object obj = A.get(this);
                if (obj instanceof o) {
                    throw ((o) obj).f7717a;
                }
                int i11 = this.f7685w;
                if ((i11 != 1 && i11 != 2) || (v0Var = (v0) this.f7694y.v(s.f7730v)) == null || v0Var.a()) {
                    return i(obj);
                }
                CancellationException cancellationExceptionS = ((d1) v0Var).s();
                b(cancellationExceptionS);
                throw cancellationExceptionS;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((h0) B.get(this)) == null) {
            w();
        }
        if (z2) {
            C();
        }
        return sd.a.f11942u;
    }

    public final void v() {
        h0 h0VarW = w();
        if (h0VarW == null || (A.get(this) instanceof g1)) {
            return;
        }
        h0VarW.b();
        B.set(this, f1.f7691u);
    }

    public final h0 w() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        v0 v0Var = (v0) this.f7694y.v(s.f7730v);
        if (v0Var == null) {
            return null;
        }
        h0 h0VarI = x.i(v0Var, true, new i(0, this));
        do {
            atomicReferenceFieldUpdater = B;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, h0VarI)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return h0VarI;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:
    
        A(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(ke.g1 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ke.g.A
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof ke.b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto L97
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof ke.i0
            r3 = 0
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof pe.r
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof ke.o
            if (r1 == 0) goto L4d
            r0 = r2
            ke.o r0 = (ke.o) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = ke.o.f7716b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L49
            boolean r1 = r2 instanceof ke.h
            if (r1 == 0) goto L97
            java.lang.Throwable r0 = r0.f7717a
            boolean r1 = r8 instanceof ke.i0
            if (r1 == 0) goto L43
            ke.i0 r8 = (ke.i0) r8
            r7.n(r8, r0)
            return
        L43:
            pe.r r8 = (pe.r) r8
            r7.p(r8, r0)
            return
        L49:
            A(r8, r2)
            throw r3
        L4d:
            boolean r1 = r2 instanceof ke.n
            if (r1 == 0) goto L80
            r1 = r2
            ke.n r1 = (ke.n) r1
            ke.i0 r4 = r1.f7711b
            if (r4 != 0) goto L7c
            boolean r4 = r8 instanceof pe.r
            if (r4 == 0) goto L5d
            goto L97
        L5d:
            r4 = r8
            ke.i0 r4 = (ke.i0) r4
            java.lang.Throwable r5 = r1.f7714e
            if (r5 == 0) goto L68
            r7.n(r4, r5)
            return
        L68:
            r5 = 29
            ke.n r1 = ke.n.a(r1, r4, r3, r5)
        L6e:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L75
            goto L97
        L75:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L6e
            goto L0
        L7c:
            A(r8, r2)
            throw r3
        L80:
            boolean r1 = r8 instanceof pe.r
            if (r1 == 0) goto L85
            goto L97
        L85:
            r3 = r8
            ke.i0 r3 = (ke.i0) r3
            ke.n r1 = new ke.n
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
        L91:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L98
        L97:
            return
        L98:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L91
            goto L0
        La0:
            A(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.g.y(ke.g1):void");
    }

    public final boolean z() {
        if (this.f7685w != 2) {
            return false;
        }
        rd.c cVar = this.f7693x;
        be.h.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return pe.f.B.get((pe.f) cVar) != null;
    }
}
