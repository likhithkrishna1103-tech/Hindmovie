package ke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d1 implements v0, h1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7686u = AtomicReferenceFieldUpdater.newUpdater(d1.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7687v = AtomicReferenceFieldUpdater.newUpdater(d1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public d1(boolean z2) {
        this._state$volatile = z2 ? x.f7747j : x.i;
    }

    public static k N(pe.j jVar) {
        while (jVar.i()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pe.j.f10385v;
            pe.j jVarF = jVar.f();
            if (jVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (pe.j) obj;
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
                if (jVar instanceof k) {
                    return (k) jVar;
                }
                if (jVar instanceof e1) {
                    return null;
                }
            }
        }
    }

    public static String U(Object obj) {
        if (!(obj instanceof c1)) {
            return obj instanceof s0 ? ((s0) obj).a() ? "Active" : "New" : obj instanceof o ? "Cancelled" : "Completed";
        }
        c1 c1Var = (c1) obj;
        return c1Var.e() ? "Cancelling" : c1.f7681v.get(c1Var) != 0 ? "Completing" : "Active";
    }

    public boolean A(Throwable th) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0087, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, ke.k, ke.z0, pe.j] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, ke.h0] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v8, types: [ke.e1, pe.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(ke.v0 r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ke.d1.f7687v
            ke.f1 r1 = ke.f1.f7691u
            if (r8 != 0) goto La
            r0.set(r7, r1)
            return
        La:
            ke.d1 r8 = (ke.d1) r8
        Lc:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = ke.d1.f7686u
            java.lang.Object r3 = r2.get(r8)
            int r3 = r8.T(r3)
            if (r3 == 0) goto L1c
            r4 = 1
            if (r3 == r4) goto L1c
            goto Lc
        L1c:
            ke.k r3 = new ke.k
            r3.<init>(r7)
            r3.f7750x = r8
        L23:
            java.lang.Object r4 = r2.get(r8)
            boolean r5 = r4 instanceof ke.j0
            if (r5 == 0) goto L45
            r5 = r4
            ke.j0 r5 = (ke.j0) r5
            boolean r6 = r5.f7700u
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
            r8.R(r5)
            goto L23
        L45:
            boolean r5 = r4 instanceof ke.s0
            r6 = 0
            if (r5 == 0) goto L89
            r5 = r4
            ke.s0 r5 = (ke.s0) r5
            ke.e1 r5 = r5.d()
            if (r5 != 0) goto L59
            ke.z0 r4 = (ke.z0) r4
            r8.S(r4)
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
            boolean r5 = r8 instanceof ke.c1
            if (r5 == 0) goto L75
            ke.c1 r8 = (ke.c1) r8
            java.lang.Throwable r6 = r8.c()
            goto L81
        L75:
            boolean r5 = r8 instanceof ke.o
            if (r5 == 0) goto L7c
            ke.o r8 = (ke.o) r8
            goto L7d
        L7c:
            r8 = r6
        L7d:
            if (r8 == 0) goto L81
            java.lang.Throwable r6 = r8.f7717a
        L81:
            r3.l(r6)
            if (r4 == 0) goto L87
            goto L9d
        L87:
            r3 = r1
            goto L9d
        L89:
            java.lang.Object r8 = r2.get(r8)
            boolean r4 = r8 instanceof ke.o
            if (r4 == 0) goto L94
            ke.o r8 = (ke.o) r8
            goto L95
        L94:
            r8 = r6
        L95:
            if (r8 == 0) goto L99
            java.lang.Throwable r6 = r8.f7717a
        L99:
            r3.l(r6)
            goto L87
        L9d:
            r0.set(r7, r3)
            java.lang.Object r8 = r2.get(r7)
            boolean r8 = r8 instanceof ke.s0
            if (r8 != 0) goto Lae
            r3.b()
            r0.set(r7, r1)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.d1.C(ke.v0):void");
    }

    public final h0 D(boolean z2, z0 z0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        f1 f1Var;
        boolean z10;
        boolean zE;
        z0Var.f7750x = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f7686u;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z11 = obj instanceof j0;
            f1Var = f1.f7691u;
            z10 = true;
            if (!z11) {
                if (!(obj instanceof s0)) {
                    z10 = false;
                    break;
                }
                s0 s0Var = (s0) obj;
                e1 e1VarD = s0Var.d();
                if (e1VarD == null) {
                    S((z0) obj);
                } else {
                    if (z0Var.k()) {
                        c1 c1Var = s0Var instanceof c1 ? (c1) s0Var : null;
                        Throwable thC = c1Var != null ? c1Var.c() : null;
                        if (thC == null) {
                            zE = e1VarD.e(z0Var, 5);
                        } else if (z2) {
                            z0Var.l(thC);
                            return f1Var;
                        }
                    } else {
                        zE = e1VarD.e(z0Var, 1);
                    }
                    if (zE) {
                        break;
                    }
                }
            } else {
                j0 j0Var = (j0) obj;
                if (j0Var.f7700u) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, z0Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                R(j0Var);
            }
        }
        if (z10) {
            return z0Var;
        }
        if (z2) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            o oVar = obj2 instanceof o ? (o) obj2 : null;
            z0Var.l(oVar != null ? oVar.f7717a : null);
        }
        return f1Var;
    }

    public boolean E() {
        return this instanceof c;
    }

    @Override // rd.h
    public final rd.h G(rd.g gVar) {
        return q1.c.F(this, gVar);
    }

    public final boolean I(Object obj) {
        Object objV;
        do {
            objV = V(f7686u.get(this), obj);
            if (objV == x.f7743d) {
                return false;
            }
            if (objV == x.f7744e) {
                return true;
            }
        } while (objV == x.f);
        h(objV);
        return true;
    }

    @Override // rd.h
    public final rd.h K(rd.h hVar) {
        return q1.c.H(this, hVar);
    }

    public final Object L(Object obj) {
        Object objV;
        do {
            objV = V(f7686u.get(this), obj);
            if (objV == x.f7743d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                o oVar = obj instanceof o ? (o) obj : null;
                throw new IllegalStateException(str, oVar != null ? oVar.f7717a : null);
            }
        } while (objV == x.f);
        return objV;
    }

    public String M() {
        return getClass().getSimpleName();
    }

    public final void O(e1 e1Var, Throwable th) {
        e1Var.e(new pe.h(4), 4);
        Object obj = pe.j.f10384u.get(e1Var);
        be.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        a2.y0 y0Var = null;
        for (pe.j jVarH = (pe.j) obj; !jVarH.equals(e1Var); jVarH = jVarH.h()) {
            if ((jVarH instanceof z0) && ((z0) jVarH).k()) {
                try {
                    ((z0) jVarH).l(th);
                } catch (Throwable th2) {
                    if (y0Var != null) {
                        com.bumptech.glide.d.d(y0Var, th2);
                    } else {
                        y0Var = new a2.y0("Exception in completion handler " + jVarH + " for " + this, th2);
                    }
                }
            }
        }
        if (y0Var != null) {
            B(y0Var);
        }
        m(th);
    }

    public final void R(j0 j0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e1 e1Var = new e1();
        Object r0Var = e1Var;
        if (!j0Var.f7700u) {
            r0Var = new r0(e1Var);
        }
        do {
            atomicReferenceFieldUpdater = f7686u;
            if (atomicReferenceFieldUpdater.compareAndSet(this, j0Var, r0Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == j0Var);
    }

    public final void S(z0 z0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e1 e1Var = new e1();
        z0Var.getClass();
        pe.j.f10385v.set(e1Var, z0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = pe.j.f10384u;
        atomicReferenceFieldUpdater2.set(e1Var, z0Var);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(z0Var) == z0Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(z0Var, z0Var, e1Var)) {
                    if (atomicReferenceFieldUpdater2.get(z0Var) != z0Var) {
                        break;
                    }
                }
                e1Var.g(z0Var);
                break loop0;
            }
            break;
        }
        pe.j jVarH = z0Var.h();
        do {
            atomicReferenceFieldUpdater = f7686u;
            if (atomicReferenceFieldUpdater.compareAndSet(this, z0Var, jVarH)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == z0Var);
    }

    public final int T(Object obj) {
        boolean z2 = obj instanceof j0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7686u;
        if (z2) {
            if (((j0) obj).f7700u) {
                return 0;
            }
            j0 j0Var = x.f7747j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, j0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof r0)) {
            return 0;
        }
        e1 e1Var = ((r0) obj).f7728u;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, e1Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    public final Object V(Object obj, Object obj2) {
        if (!(obj instanceof s0)) {
            return x.f7743d;
        }
        if (((obj instanceof j0) || (obj instanceof z0)) && !(obj instanceof k) && !(obj2 instanceof o)) {
            s0 s0Var = (s0) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7686u;
            Object t0Var = obj2 instanceof s0 ? new t0((s0) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, s0Var, t0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != s0Var) {
                    return x.f;
                }
            }
            P(obj2);
            p(s0Var, obj2);
            return obj2;
        }
        s0 s0Var2 = (s0) obj;
        e1 e1VarZ = z(s0Var2);
        if (e1VarZ == null) {
            return x.f;
        }
        c1 c1Var = s0Var2 instanceof c1 ? (c1) s0Var2 : null;
        if (c1Var == null) {
            c1Var = new c1(e1VarZ, null);
        }
        synchronized (c1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c1.f7681v;
            if (atomicIntegerFieldUpdater.get(c1Var) != 0) {
                return x.f7743d;
            }
            atomicIntegerFieldUpdater.set(c1Var, 1);
            if (c1Var != s0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f7686u;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, s0Var2, c1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != s0Var2) {
                        return x.f;
                    }
                }
            }
            boolean zE = c1Var.e();
            o oVar = obj2 instanceof o ? (o) obj2 : null;
            if (oVar != null) {
                c1Var.b(oVar.f7717a);
            }
            Throwable thC = zE ? null : c1Var.c();
            if (thC != null) {
                O(e1VarZ, thC);
            }
            k kVarN = N(e1VarZ);
            if (kVarN != null && W(c1Var, kVarN, obj2)) {
                return x.f7744e;
            }
            e1VarZ.e(new pe.h(2), 2);
            k kVarN2 = N(e1VarZ);
            return (kVarN2 == null || !W(c1Var, kVarN2, obj2)) ? r(c1Var, obj2) : x.f7744e;
        }
    }

    public final boolean W(c1 c1Var, k kVar, Object obj) {
        while (x.i(kVar.f7702y, false, new b1(this, c1Var, kVar, obj)) == f1.f7691u) {
            kVar = N(kVar);
            if (kVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // ke.v0
    public boolean a() {
        Object obj = f7686u.get(this);
        return (obj instanceof s0) && ((s0) obj).a();
    }

    @Override // rd.h
    public final Object d(Object obj, ae.p pVar) {
        return pVar.i(obj, this);
    }

    @Override // rd.f
    public final rd.g getKey() {
        return s.f7730v;
    }

    public void i(Object obj) {
        h(obj);
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
    public final boolean j(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.d1.j(java.lang.Object):boolean");
    }

    public final boolean m(Throwable th) {
        if (E()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        j jVar = (j) f7687v.get(this);
        return (jVar == null || jVar == f1.f7691u) ? z2 : jVar.c(th) || z2;
    }

    public String n() {
        return "Job was cancelled";
    }

    public boolean o(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return j(th) && w();
    }

    public final void p(s0 s0Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7687v;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        if (jVar != null) {
            jVar.b();
            atomicReferenceFieldUpdater.set(this, f1.f7691u);
        }
        a2.y0 y0Var = null;
        o oVar = obj instanceof o ? (o) obj : null;
        Throwable th = oVar != null ? oVar.f7717a : null;
        if (s0Var instanceof z0) {
            try {
                ((z0) s0Var).l(th);
                return;
            } catch (Throwable th2) {
                B(new a2.y0("Exception in completion handler " + s0Var + " for " + this, th2));
                return;
            }
        }
        e1 e1VarD = s0Var.d();
        if (e1VarD != null) {
            e1VarD.e(new pe.h(1), 1);
            Object obj2 = pe.j.f10384u.get(e1VarD);
            be.h.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (pe.j jVarH = (pe.j) obj2; !jVarH.equals(e1VarD); jVarH = jVarH.h()) {
                if (jVarH instanceof z0) {
                    try {
                        ((z0) jVarH).l(th);
                    } catch (Throwable th3) {
                        if (y0Var != null) {
                            com.bumptech.glide.d.d(y0Var, th3);
                        } else {
                            y0Var = new a2.y0("Exception in completion handler " + jVarH + " for " + this, th3);
                        }
                    }
                }
            }
            if (y0Var != null) {
                B(y0Var);
            }
        }
    }

    public final Throwable q(Object obj) {
        Throwable thC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        d1 d1Var = (d1) ((h1) obj);
        Object obj2 = f7686u.get(d1Var);
        if (obj2 instanceof c1) {
            thC = ((c1) obj2).c();
        } else if (obj2 instanceof o) {
            thC = ((o) obj2).f7717a;
        } else {
            if (obj2 instanceof s0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            thC = null;
        }
        CancellationException cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        return cancellationException == null ? new w0("Parent job is ".concat(U(obj2)), thC, d1Var) : cancellationException;
    }

    public final Object r(c1 c1Var, Object obj) {
        Throwable thU;
        o oVar = obj instanceof o ? (o) obj : null;
        Throwable th = oVar != null ? oVar.f7717a : null;
        synchronized (c1Var) {
            c1Var.e();
            ArrayList arrayListF = c1Var.f(th);
            thU = u(c1Var, arrayListF);
            if (thU != null && arrayListF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListF.size()));
                int size = arrayListF.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayListF.get(i);
                    i++;
                    Throwable th2 = (Throwable) obj2;
                    if (th2 != thU && th2 != thU && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        com.bumptech.glide.d.d(thU, th2);
                    }
                }
            }
        }
        if (thU != null && thU != th) {
            obj = new o(thU, false);
        }
        if (thU != null && (m(thU) || A(thU))) {
            be.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            o.f7716b.compareAndSet((o) obj, 0, 1);
        }
        P(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7686u;
        Object t0Var = obj instanceof s0 ? new t0((s0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, c1Var, t0Var) && atomicReferenceFieldUpdater.get(this) == c1Var) {
        }
        p(c1Var, obj);
        return obj;
    }

    public final CancellationException s() {
        CancellationException cancellationException;
        Object obj = f7686u.get(this);
        if (!(obj instanceof c1)) {
            if (obj instanceof s0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof o)) {
                return new w0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((o) obj).f7717a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new w0(n(), th, this) : cancellationException;
        }
        Throwable thC = ((c1) obj).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = n();
        }
        return new w0(strConcat, thC, this);
    }

    public final Object t() throws Throwable {
        Object obj = f7686u.get(this);
        if (obj instanceof s0) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof o) {
            throw ((o) obj).f7717a;
        }
        return x.o(obj);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(M() + '{' + U(f7686u.get(this)) + '}');
        sb2.append('@');
        sb2.append(x.f(this));
        return sb2.toString();
    }

    public final Throwable u(c1 c1Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (c1Var.e()) {
                return new w0(n(), null, this);
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
        if (th2 instanceof k1) {
            int size2 = arrayList.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof k1)) {
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

    @Override // rd.h
    public final rd.f v(rd.g gVar) {
        return q1.c.B(this, gVar);
    }

    public boolean w() {
        return true;
    }

    public boolean y() {
        return this instanceof m;
    }

    public final e1 z(s0 s0Var) {
        e1 e1VarD = s0Var.d();
        if (e1VarD != null) {
            return e1VarD;
        }
        if (s0Var instanceof j0) {
            return new e1();
        }
        if (s0Var instanceof z0) {
            S((z0) s0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + s0Var).toString());
    }

    public void Q() {
    }

    public void B(a2.y0 y0Var) {
        throw y0Var;
    }

    public void P(Object obj) {
    }

    public void h(Object obj) {
    }
}
