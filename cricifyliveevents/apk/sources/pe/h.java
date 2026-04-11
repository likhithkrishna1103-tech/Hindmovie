package pe;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class h extends d0 implements f, xd.d, o1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater A = AtomicIntegerFieldUpdater.newUpdater(h.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater B = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater C = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final vd.c f10236y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final vd.h f10237z;

    public h(int i, vd.c cVar) {
        super(i);
        this.f10236y = cVar;
        this.f10237z = cVar.h();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f10218a;
    }

    public static void C(f1 f1Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + f1Var + ", already has " + obj).toString());
    }

    public static Object H(f1 f1Var, Object obj, int i, fe.q qVar) {
        if (obj instanceof p) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (qVar != null || (f1Var instanceof e)) {
            return new o(obj, f1Var instanceof e ? (e) f1Var : null, qVar, (CancellationException) null, 16);
        }
        return obj;
    }

    public final boolean B() {
        if (this.f10228x != 2) {
            return false;
        }
        vd.c cVar = this.f10236y;
        ge.i.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ue.f.C.get((ue.f) cVar) != null;
    }

    public String D() {
        return "CancellableContinuation";
    }

    public final void E() {
        vd.c cVar = this.f10236y;
        Throwable th = null;
        ue.f fVar = cVar instanceof ue.f ? (ue.f) cVar : null;
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ue.f.C;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                d5.a aVar = ue.a.f12455c;
                if (obj == aVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, aVar, this)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != aVar) {
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

    public final void F(Object obj, int i, fe.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof f1) {
                Object objH = H((f1) obj2, obj, i, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objH)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!B()) {
                    r();
                }
                t(i);
                return;
            }
            if (obj2 instanceof i) {
                i iVar = (i) obj2;
                if (i.f10238c.compareAndSet(iVar, 0, 1)) {
                    if (qVar != null) {
                        o(qVar, iVar.f10263a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    public final void G(s sVar) {
        vd.c cVar = this.f10236y;
        ue.f fVar = cVar instanceof ue.f ? (ue.f) cVar : null;
        F(rd.l.f11003a, (fVar != null ? fVar.f12464y : null) == sVar ? 4 : this.f10228x, null);
    }

    @Override // pe.o1
    public final void a(ue.r rVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = A;
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, ((i10 >> 29) << 29) + i));
        y(rVar);
    }

    @Override // pe.d0
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof f1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof p) {
                return;
            }
            if (!(obj instanceof o)) {
                cancellationException2 = cancellationException;
                o oVar = new o(obj, (e) null, (fe.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, oVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            o oVar2 = (o) obj;
            if (oVar2.f10258e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            o oVarA = o.a(oVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, oVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            e eVar = oVar2.f10255b;
            if (eVar != null) {
                n(eVar, cancellationException);
            }
            fe.q qVar = oVar2.f10256c;
            if (qVar != null) {
                o(qVar, cancellationException, oVar2.f10254a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // pe.f
    public final d5.a c(Object obj, fe.q qVar) {
        d5.a aVar = x.f10281a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof f1)) {
                return null;
            }
            Object objH = H((f1) obj2, obj, this.f10228x, qVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objH)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!B()) {
                r();
            }
            return aVar;
        }
    }

    @Override // xd.d
    public final xd.d d() {
        vd.c cVar = this.f10236y;
        if (cVar instanceof xd.d) {
            return (xd.d) cVar;
        }
        return null;
    }

    @Override // pe.d0
    public final vd.c e() {
        return this.f10236y;
    }

    @Override // pe.d0
    public final Throwable f(Object obj) {
        Throwable thF = super.f(obj);
        if (thF != null) {
            return thF;
        }
        return null;
    }

    @Override // pe.d0
    public final Object g(Object obj) {
        return obj instanceof o ? ((o) obj).f10254a : obj;
    }

    @Override // vd.c
    public final vd.h h() {
        return this.f10237z;
    }

    @Override // vd.c
    public final void i(Object obj) {
        Throwable thA = rd.h.a(obj);
        if (thA != null) {
            obj = new p(thA, false);
        }
        F(obj, this.f10228x, null);
    }

    @Override // pe.f
    public final void k(Object obj, fe.q qVar) {
        F(obj, this.f10228x, qVar);
    }

    @Override // pe.f
    public final void l(Object obj) {
        t(this.f10228x);
    }

    @Override // pe.d0
    public final Object m() {
        return B.get(this);
    }

    public final void n(e eVar, Throwable th) {
        try {
            switch (eVar.f10229a) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    ((ScheduledFuture) eVar.f10230b).cancel(false);
                    break;
                case 1:
                    ((fe.l) eVar.f10230b).a(th);
                    break;
                default:
                    ((h0) eVar.f10230b).b();
                    break;
            }
        } catch (Throwable th2) {
            x.i(new a9.l("Exception in invokeOnCancellation handler for " + this, th2), this.f10237z);
        }
    }

    public final void o(fe.q qVar, Throwable th, Object obj) {
        vd.h hVar = this.f10237z;
        try {
            qVar.g(th, obj, hVar);
        } catch (Throwable th2) {
            x.i(new a9.l("Exception in resume onCancellation handler for " + this, th2), hVar);
        }
    }

    public final void p(ue.r rVar, Throwable th) {
        vd.h hVar = this.f10237z;
        int i = A.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            rVar.g(i, hVar);
        } catch (Throwable th2) {
            x.i(new a9.l("Exception in invokeOnCancellation handler for " + this, th2), hVar);
        }
    }

    public final boolean q(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof f1)) {
                return false;
            }
            i iVar = new i(this, th, (obj instanceof e) || (obj instanceof ue.r));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, iVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            f1 f1Var = (f1) obj;
            if (f1Var instanceof e) {
                n((e) obj, th);
            } else if (f1Var instanceof ue.r) {
                p((ue.r) obj, th);
            }
            if (!B()) {
                r();
            }
            t(this.f10228x);
            return true;
        }
    }

    public final void r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C;
        h0 h0Var = (h0) atomicReferenceFieldUpdater.get(this);
        if (h0Var == null) {
            return;
        }
        h0Var.b();
        atomicReferenceFieldUpdater.set(this, e1.f10231v);
    }

    public final void t(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = A;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z10 = i == 4;
                vd.c cVar = this.f10236y;
                if (!z10 && (cVar instanceof ue.f)) {
                    boolean z11 = i == 1 || i == 2;
                    int i12 = this.f10228x;
                    if (z11 == (i12 == 1 || i12 == 2)) {
                        ue.f fVar = (ue.f) cVar;
                        s sVar = fVar.f12464y;
                        vd.h hVarH = fVar.f12465z.h();
                        if (sVar.i0(hVarH)) {
                            sVar.h0(hVarH, this);
                            return;
                        }
                        o0 o0VarA = i1.a();
                        if (o0VarA.f10259x < 4294967296L) {
                            o0VarA.m0(true);
                            try {
                                x.n(this, cVar, true);
                                do {
                                } while (o0VarA.o0());
                            } finally {
                                try {
                                } finally {
                                }
                            }
                            return;
                        }
                        sd.h hVar = o0VarA.f10261z;
                        if (hVar == null) {
                            hVar = new sd.h();
                            o0VarA.f10261z = hVar;
                        }
                        hVar.addLast(this);
                        return;
                    }
                }
                x.n(this, cVar, z10);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(D());
        sb.append('(');
        sb.append(x.p(this.f10236y));
        sb.append("){");
        Object obj = B.get(this);
        sb.append(obj instanceof f1 ? "Active" : obj instanceof i ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(x.g(this));
        return sb.toString();
    }

    public Throwable u(c1 c1Var) {
        return c1Var.x();
    }

    public final Object v() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        v0 v0Var;
        boolean zB = B();
        do {
            atomicIntegerFieldUpdater = A;
            i = atomicIntegerFieldUpdater.get(this);
            int i10 = i >> 29;
            if (i10 != 0) {
                if (i10 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zB) {
                    E();
                }
                Object obj = B.get(this);
                if (obj instanceof p) {
                    throw ((p) obj).f10263a;
                }
                int i11 = this.f10228x;
                if ((i11 != 1 && i11 != 2) || (v0Var = (v0) this.f10237z.C(t.f10271w)) == null || v0Var.a()) {
                    return g(obj);
                }
                CancellationException cancellationExceptionX = ((c1) v0Var).x();
                b(cancellationExceptionX);
                throw cancellationExceptionX;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((h0) C.get(this)) == null) {
            x();
        }
        if (zB) {
            E();
        }
        return wd.a.f14143v;
    }

    public final void w() {
        h0 h0VarX = x();
        if (h0VarX == null || (B.get(this) instanceof f1)) {
            return;
        }
        h0VarX.b();
        C.set(this, e1.f10231v);
    }

    public final h0 x() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        v0 v0Var = (v0) this.f10237z.C(t.f10271w);
        if (v0Var == null) {
            return null;
        }
        h0 h0VarJ = x.j(v0Var, true, new j(0, this));
        do {
            atomicReferenceFieldUpdater = C;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, h0VarJ)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return h0VarJ;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:
    
        C(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(pe.f1 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = pe.h.B
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof pe.b
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
            boolean r1 = r2 instanceof pe.e
            r3 = 0
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof ue.r
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof pe.p
            if (r1 == 0) goto L4d
            r0 = r2
            pe.p r0 = (pe.p) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = pe.p.f10262b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L49
            boolean r1 = r2 instanceof pe.i
            if (r1 == 0) goto L97
            java.lang.Throwable r0 = r0.f10263a
            boolean r1 = r8 instanceof pe.e
            if (r1 == 0) goto L43
            pe.e r8 = (pe.e) r8
            r7.n(r8, r0)
            return
        L43:
            ue.r r8 = (ue.r) r8
            r7.p(r8, r0)
            return
        L49:
            C(r8, r2)
            throw r3
        L4d:
            boolean r1 = r2 instanceof pe.o
            if (r1 == 0) goto L80
            r1 = r2
            pe.o r1 = (pe.o) r1
            pe.e r4 = r1.f10255b
            if (r4 != 0) goto L7c
            boolean r4 = r8 instanceof ue.r
            if (r4 == 0) goto L5d
            goto L97
        L5d:
            r4 = r8
            pe.e r4 = (pe.e) r4
            java.lang.Throwable r5 = r1.f10258e
            if (r5 == 0) goto L68
            r7.n(r4, r5)
            return
        L68:
            r5 = 29
            pe.o r1 = pe.o.a(r1, r4, r3, r5)
        L6e:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L75
            goto L97
        L75:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L6e
            goto L0
        L7c:
            C(r8, r2)
            throw r3
        L80:
            boolean r1 = r8 instanceof ue.r
            if (r1 == 0) goto L85
            goto L97
        L85:
            r3 = r8
            pe.e r3 = (pe.e) r3
            pe.o r1 = new pe.o
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
            C(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: pe.h.y(pe.f1):void");
    }
}
