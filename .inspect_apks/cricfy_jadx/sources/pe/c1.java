package pe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c1 implements v0, g1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10226v = AtomicReferenceFieldUpdater.newUpdater(c1.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10227w = AtomicReferenceFieldUpdater.newUpdater(c1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public c1(boolean z10) {
        this._state$volatile = z10 ? x.f10288j : x.i;
    }

    public static l S(ue.j jVar) {
        while (jVar.i()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ue.j.f12471w;
            ue.j jVarF = jVar.f();
            if (jVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (ue.j) obj;
                    if (!jVar.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = jVarF;
            }
        }
        while (true) {
            jVar = jVar.h();
            if (!jVar.i()) {
                if (jVar instanceof l) {
                    return (l) jVar;
                }
                if (jVar instanceof d1) {
                    return null;
                }
            }
        }
    }

    public static String Z(Object obj) {
        if (!(obj instanceof b1)) {
            return obj instanceof s0 ? ((s0) obj).a() ? "Active" : "New" : obj instanceof p ? "Cancelled" : "Completed";
        }
        b1 b1Var = (b1) obj;
        return b1Var.e() ? "Cancelling" : b1.f10219w.get(b1Var) != 0 ? "Completing" : "Active";
    }

    public final Throwable B(b1 b1Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (b1Var.e()) {
                return new w0(r(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof j1) {
            int size2 = arrayList.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof j1)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    @Override // vd.h
    public final vd.f C(vd.g gVar) {
        return w8.e.h(this, gVar);
    }

    public boolean D() {
        return true;
    }

    public boolean E() {
        return this instanceof n;
    }

    public final d1 F(s0 s0Var) {
        d1 d1VarD = s0Var.d();
        if (d1VarD != null) {
            return d1VarD;
        }
        if (s0Var instanceof i0) {
            return new d1();
        }
        if (s0Var instanceof y0) {
            X((y0) s0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + s0Var).toString());
    }

    public boolean G(Throwable th) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0087, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, pe.l, pe.y0, ue.j] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, pe.h0] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v8, types: [pe.d1, ue.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(pe.v0 r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = pe.c1.f10227w
            pe.e1 r1 = pe.e1.f10231v
            if (r8 != 0) goto La
            r0.set(r7, r1)
            return
        La:
            pe.c1 r8 = (pe.c1) r8
        Lc:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = pe.c1.f10226v
            java.lang.Object r3 = r2.get(r8)
            int r3 = r8.Y(r3)
            if (r3 == 0) goto L1c
            r4 = 1
            if (r3 == r4) goto L1c
            goto Lc
        L1c:
            pe.l r3 = new pe.l
            r3.<init>(r7)
            r3.f10290y = r8
        L23:
            java.lang.Object r4 = r2.get(r8)
            boolean r5 = r4 instanceof pe.i0
            if (r5 == 0) goto L45
            r5 = r4
            pe.i0 r5 = (pe.i0) r5
            boolean r6 = r5.f10239v
            if (r6 == 0) goto L41
        L32:
            boolean r5 = r2.compareAndSet(r8, r4, r3)
            if (r5 == 0) goto L3a
            goto L9d
        L3a:
            java.lang.Object r5 = r2.get(r8)
            if (r5 == r4) goto L32
            goto L23
        L41:
            r8.W(r5)
            goto L23
        L45:
            boolean r5 = r4 instanceof pe.s0
            r6 = 0
            if (r5 == 0) goto L89
            r5 = r4
            pe.s0 r5 = (pe.s0) r5
            pe.d1 r5 = r5.d()
            if (r5 != 0) goto L59
            pe.y0 r4 = (pe.y0) r4
            r8.X(r4)
            goto L23
        L59:
            r4 = 7
            boolean r4 = r5.e(r3, r4)
            if (r4 == 0) goto L61
            goto L9d
        L61:
            r4 = 3
            boolean r4 = r5.e(r3, r4)
            java.lang.Object r8 = r2.get(r8)
            boolean r2 = r8 instanceof pe.b1
            if (r2 == 0) goto L75
            pe.b1 r8 = (pe.b1) r8
            java.lang.Throwable r6 = r8.c()
            goto L81
        L75:
            boolean r2 = r8 instanceof pe.p
            if (r2 == 0) goto L7c
            pe.p r8 = (pe.p) r8
            goto L7d
        L7c:
            r8 = r6
        L7d:
            if (r8 == 0) goto L81
            java.lang.Throwable r6 = r8.f10263a
        L81:
            r3.l(r6)
            if (r4 == 0) goto L87
            goto L9d
        L87:
            r3 = r1
            goto L9d
        L89:
            java.lang.Object r8 = r2.get(r8)
            boolean r2 = r8 instanceof pe.p
            if (r2 == 0) goto L94
            pe.p r8 = (pe.p) r8
            goto L95
        L94:
            r8 = r6
        L95:
            if (r8 == 0) goto L99
            java.lang.Throwable r6 = r8.f10263a
        L99:
            r3.l(r6)
            goto L87
        L9d:
            r0.set(r7, r3)
            boolean r8 = r7.L()
            if (r8 == 0) goto Lac
            r3.b()
            r0.set(r7, r1)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pe.c1.I(pe.v0):void");
    }

    @Override // vd.h
    public final Object J(Object obj, fe.p pVar) {
        return pVar.j(obj, this);
    }

    public final h0 K(boolean z10, y0 y0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e1 e1Var;
        boolean z11;
        boolean zE;
        y0Var.f10290y = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f10226v;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z12 = obj instanceof i0;
            e1Var = e1.f10231v;
            z11 = true;
            if (!z12) {
                if (!(obj instanceof s0)) {
                    z11 = false;
                    break;
                }
                s0 s0Var = (s0) obj;
                d1 d1VarD = s0Var.d();
                if (d1VarD == null) {
                    X((y0) obj);
                } else {
                    if (y0Var.k()) {
                        b1 b1Var = s0Var instanceof b1 ? (b1) s0Var : null;
                        Throwable thC = b1Var != null ? b1Var.c() : null;
                        if (thC == null) {
                            zE = d1VarD.e(y0Var, 5);
                        } else if (z10) {
                            y0Var.l(thC);
                            return e1Var;
                        }
                    } else {
                        zE = d1VarD.e(y0Var, 1);
                    }
                    if (zE) {
                        break;
                    }
                }
            } else {
                i0 i0Var = (i0) obj;
                if (i0Var.f10239v) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, y0Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                W(i0Var);
            }
        }
        if (z11) {
            return y0Var;
        }
        if (z10) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            p pVar = obj2 instanceof p ? (p) obj2 : null;
            y0Var.l(pVar != null ? pVar.f10263a : null);
        }
        return e1Var;
    }

    public final boolean L() {
        return !(f10226v.get(this) instanceof s0);
    }

    public boolean M() {
        return this instanceof c;
    }

    public final boolean N(Object obj) {
        Object objA0;
        do {
            objA0 = a0(f10226v.get(this), obj);
            if (objA0 == x.f10284d) {
                return false;
            }
            if (objA0 == x.f10285e) {
                return true;
            }
        } while (objA0 == x.f);
        j(objA0);
        return true;
    }

    @Override // vd.h
    public final vd.h O(vd.g gVar) {
        return w8.e.i(this, gVar);
    }

    public final Object P(Object obj) {
        Object objA0;
        do {
            objA0 = a0(f10226v.get(this), obj);
            if (objA0 == x.f10284d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                p pVar = obj instanceof p ? (p) obj : null;
                throw new IllegalStateException(str, pVar != null ? pVar.f10263a : null);
            }
        } while (objA0 == x.f);
        return objA0;
    }

    public String R() {
        return getClass().getSimpleName();
    }

    public final void T(d1 d1Var, Throwable th) {
        d1Var.e(new ue.h(4), 4);
        Object obj = ue.j.f12470v.get(d1Var);
        ge.i.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        a9.l lVar = null;
        for (ue.j jVarH = (ue.j) obj; !jVarH.equals(d1Var); jVarH = jVarH.h()) {
            if ((jVarH instanceof y0) && ((y0) jVarH).k()) {
                try {
                    ((y0) jVarH).l(th);
                } catch (Throwable th2) {
                    if (lVar != null) {
                        ab.b.c(lVar, th2);
                    } else {
                        lVar = new a9.l("Exception in completion handler " + jVarH + " for " + this, th2);
                    }
                }
            }
        }
        if (lVar != null) {
            H(lVar);
        }
        p(th);
    }

    public final void W(i0 i0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        d1 d1Var = new d1();
        Object r0Var = d1Var;
        if (!i0Var.f10239v) {
            r0Var = new r0(d1Var);
        }
        do {
            atomicReferenceFieldUpdater = f10226v;
            if (atomicReferenceFieldUpdater.compareAndSet(this, i0Var, r0Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == i0Var);
    }

    public final void X(y0 y0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        d1 d1Var = new d1();
        y0Var.getClass();
        ue.j.f12471w.set(d1Var, y0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = ue.j.f12470v;
        atomicReferenceFieldUpdater2.set(d1Var, y0Var);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(y0Var) == y0Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(y0Var, y0Var, d1Var)) {
                    if (atomicReferenceFieldUpdater2.get(y0Var) != y0Var) {
                        break;
                    }
                }
                d1Var.g(y0Var);
                break loop0;
            }
            break;
        }
        ue.j jVarH = y0Var.h();
        do {
            atomicReferenceFieldUpdater = f10226v;
            if (atomicReferenceFieldUpdater.compareAndSet(this, y0Var, jVarH)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == y0Var);
    }

    public final int Y(Object obj) {
        boolean z10 = obj instanceof i0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10226v;
        if (z10) {
            if (((i0) obj).f10239v) {
                return 0;
            }
            i0 i0Var = x.f10288j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, i0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof r0)) {
            return 0;
        }
        d1 d1Var = ((r0) obj).f10268v;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, d1Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    @Override // pe.v0
    public boolean a() {
        Object obj = f10226v.get(this);
        return (obj instanceof s0) && ((s0) obj).a();
    }

    public final Object a0(Object obj, Object obj2) {
        if (!(obj instanceof s0)) {
            return x.f10284d;
        }
        if (((obj instanceof i0) || (obj instanceof y0)) && !(obj instanceof l) && !(obj2 instanceof p)) {
            s0 s0Var = (s0) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10226v;
            Object t0Var = obj2 instanceof s0 ? new t0((s0) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, s0Var, t0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != s0Var) {
                    return x.f;
                }
            }
            U(obj2);
            u(s0Var, obj2);
            return obj2;
        }
        s0 s0Var2 = (s0) obj;
        d1 d1VarF = F(s0Var2);
        if (d1VarF == null) {
            return x.f;
        }
        b1 b1Var = s0Var2 instanceof b1 ? (b1) s0Var2 : null;
        if (b1Var == null) {
            b1Var = new b1(d1VarF, null);
        }
        synchronized (b1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b1.f10219w;
            if (atomicIntegerFieldUpdater.get(b1Var) != 0) {
                return x.f10284d;
            }
            atomicIntegerFieldUpdater.set(b1Var, 1);
            if (b1Var != s0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f10226v;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, s0Var2, b1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != s0Var2) {
                        return x.f;
                    }
                }
            }
            boolean zE = b1Var.e();
            p pVar = obj2 instanceof p ? (p) obj2 : null;
            if (pVar != null) {
                b1Var.b(pVar.f10263a);
            }
            Throwable thC = zE ? null : b1Var.c();
            if (thC != null) {
                T(d1VarF, thC);
            }
            l lVarS = S(d1VarF);
            if (lVarS != null && b0(b1Var, lVarS, obj2)) {
                return x.f10285e;
            }
            d1VarF.e(new ue.h(2), 2);
            l lVarS2 = S(d1VarF);
            return (lVarS2 == null || !b0(b1Var, lVarS2, obj2)) ? w(b1Var, obj2) : x.f10285e;
        }
    }

    public final boolean b0(b1 b1Var, l lVar, Object obj) {
        while (x.j(lVar.f10247z, false, new a1(this, b1Var, lVar, obj)) == e1.f10231v) {
            lVar = S(lVar);
            if (lVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // pe.v0
    public void g(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new w0(r(), null, this);
        }
        o(cancellationException);
    }

    @Override // vd.f
    public final vd.g getKey() {
        return t.f10271w;
    }

    public void m(Object obj) {
        j(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r0
      0x003e: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v13 java.lang.Object) binds: [B:3:0x0008, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pe.c1.n(java.lang.Object):boolean");
    }

    public void o(CancellationException cancellationException) {
        n(cancellationException);
    }

    public final boolean p(Throwable th) {
        if (M()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        k kVar = (k) f10227w.get(this);
        return (kVar == null || kVar == e1.f10231v) ? z10 : kVar.c(th) || z10;
    }

    @Override // vd.h
    public final vd.h q(vd.h hVar) {
        return w8.e.k(this, hVar);
    }

    public String r() {
        return "Job was cancelled";
    }

    public boolean t(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return n(th) && D();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(R() + '{' + Z(f10226v.get(this)) + '}');
        sb.append('@');
        sb.append(x.g(this));
        return sb.toString();
    }

    public final void u(s0 s0Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10227w;
        k kVar = (k) atomicReferenceFieldUpdater.get(this);
        if (kVar != null) {
            kVar.b();
            atomicReferenceFieldUpdater.set(this, e1.f10231v);
        }
        a9.l lVar = null;
        p pVar = obj instanceof p ? (p) obj : null;
        Throwable th = pVar != null ? pVar.f10263a : null;
        if (s0Var instanceof y0) {
            try {
                ((y0) s0Var).l(th);
                return;
            } catch (Throwable th2) {
                H(new a9.l("Exception in completion handler " + s0Var + " for " + this, th2));
                return;
            }
        }
        d1 d1VarD = s0Var.d();
        if (d1VarD != null) {
            d1VarD.e(new ue.h(1), 1);
            Object obj2 = ue.j.f12470v.get(d1VarD);
            ge.i.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (ue.j jVarH = (ue.j) obj2; !jVarH.equals(d1VarD); jVarH = jVarH.h()) {
                if (jVarH instanceof y0) {
                    try {
                        ((y0) jVarH).l(th);
                    } catch (Throwable th3) {
                        if (lVar != null) {
                            ab.b.c(lVar, th3);
                        } else {
                            lVar = new a9.l("Exception in completion handler " + jVarH + " for " + this, th3);
                        }
                    }
                }
            }
            if (lVar != null) {
                H(lVar);
            }
        }
    }

    public final Throwable v(Object obj) {
        Throwable thC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        c1 c1Var = (c1) ((g1) obj);
        Object obj2 = f10226v.get(c1Var);
        if (obj2 instanceof b1) {
            thC = ((b1) obj2).c();
        } else if (obj2 instanceof p) {
            thC = ((p) obj2).f10263a;
        } else {
            if (obj2 instanceof s0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            thC = null;
        }
        CancellationException cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        return cancellationException == null ? new w0("Parent job is ".concat(Z(obj2)), thC, c1Var) : cancellationException;
    }

    public final Object w(b1 b1Var, Object obj) {
        Throwable thB;
        p pVar = obj instanceof p ? (p) obj : null;
        Throwable th = pVar != null ? pVar.f10263a : null;
        synchronized (b1Var) {
            b1Var.e();
            ArrayList arrayListF = b1Var.f(th);
            thB = B(b1Var, arrayListF);
            if (thB != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                int size = arrayListF.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayListF.get(i);
                    i++;
                    Throwable th2 = (Throwable) obj2;
                    if (th2 != thB && th2 != thB && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        ab.b.c(thB, th2);
                    }
                }
            }
        }
        if (thB != null && thB != th) {
            obj = new p(thB, false);
        }
        if (thB != null && (p(thB) || G(thB))) {
            ge.i.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            p.f10262b.compareAndSet((p) obj, 0, 1);
        }
        U(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10226v;
        Object t0Var = obj instanceof s0 ? new t0((s0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, b1Var, t0Var) && atomicReferenceFieldUpdater.get(this) == b1Var) {
        }
        u(b1Var, obj);
        return obj;
    }

    public final CancellationException x() {
        CancellationException cancellationException;
        Object obj = f10226v.get(this);
        if (!(obj instanceof b1)) {
            if (obj instanceof s0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof p)) {
                return new w0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((p) obj).f10263a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new w0(r(), th, this) : cancellationException;
        }
        Throwable thC = ((b1) obj).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = r();
        }
        return new w0(strConcat, thC, this);
    }

    public final Object y() throws Throwable {
        Object obj = f10226v.get(this);
        if (obj instanceof s0) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof p) {
            throw ((p) obj).f10263a;
        }
        return x.q(obj);
    }

    public void V() {
    }

    public void H(a9.l lVar) {
        throw lVar;
    }

    public void U(Object obj) {
    }

    public void j(Object obj) {
    }
}
