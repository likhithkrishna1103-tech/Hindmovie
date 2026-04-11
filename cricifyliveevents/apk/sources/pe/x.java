package pe;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d5.a f10281a = new d5.a(3, "RESUME_TOKEN");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d5.a f10282b = new d5.a(3, "REMOVED_TASK");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d5.a f10283c = new d5.a(3, "CLOSED_EMPTY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d5.a f10284d = new d5.a(3, "COMPLETING_ALREADY");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d5.a f10285e = new d5.a(3, "COMPLETING_WAITING_CHILDREN");
    public static final d5.a f = new d5.a(3, "COMPLETING_RETRY");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d5.a f10286g = new d5.a(3, "TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d5.a f10287h = new d5.a(3, "SEALED");
    public static final i0 i = new i0(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i0 f10288j = new i0(true);

    public static n a() {
        n nVar = new n(true);
        nVar.I(null);
        return nVar;
    }

    public static final ue.c b(vd.h hVar) {
        if (hVar.C(t.f10271w) == null) {
            hVar = hVar.q(new x0(null));
        }
        return new ue.c(hVar);
    }

    public static a0 c(ue.c cVar, fe.p pVar) {
        a0 a0Var = new a0(l(cVar, vd.i.f13722v), true, 0);
        a0Var.f0(w.f10276v, a0Var, pVar);
        return a0Var;
    }

    public static final vd.h d(vd.h hVar, vd.h hVar2, boolean z10) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) hVar.J(bool, new q(0))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) hVar2.J(bool, new q(0))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return hVar.q(hVar2);
        }
        q qVar = new q(1);
        vd.i iVar = vd.i.f13722v;
        vd.h hVar3 = (vd.h) hVar.J(iVar, qVar);
        Object objJ = hVar2;
        if (zBooleanValue2) {
            objJ = hVar2.J(iVar, new q(2));
        }
        return hVar3.q((vd.h) objJ);
    }

    public static final s e(Executor executor) {
        return new q0(executor);
    }

    public static final b0 f(vd.h hVar) {
        vd.f fVarC = hVar.C(vd.d.f13721v);
        b0 b0Var = fVarC instanceof b0 ? (b0) fVarC : null;
        return b0Var == null ? z.f10291a : b0Var;
    }

    public static final String g(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final h h(vd.c cVar) {
        h hVar;
        h hVar2;
        if (!(cVar instanceof ue.f)) {
            return new h(1, cVar);
        }
        ue.f fVar = (ue.f) cVar;
        d5.a aVar = ue.a.f12455c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ue.f.C;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            hVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, aVar);
                hVar2 = null;
                break;
            }
            if (obj instanceof h) {
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, aVar)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                        break;
                    }
                }
                hVar2 = (h) obj;
                break loop0;
            }
            if (obj != aVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (hVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h.B;
            Object obj2 = atomicReferenceFieldUpdater2.get(hVar2);
            if (!(obj2 instanceof o) || ((o) obj2).f10257d == null) {
                h.A.set(hVar2, 536870911);
                atomicReferenceFieldUpdater2.set(hVar2, b.f10218a);
                hVar = hVar2;
            } else {
                hVar2.r();
            }
            if (hVar != null) {
                return hVar;
            }
        }
        return new h(2, cVar);
    }

    public static final void i(Throwable th, vd.h hVar) {
        try {
            qe.b bVar = (qe.b) hVar.C(t.f10270v);
            if (bVar != null) {
                bVar.h0(th);
            } else {
                ue.a.d(th, hVar);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                ab.b.c(runtimeException, th);
                th = runtimeException;
            }
            ue.a.d(th, hVar);
        }
    }

    public static final h0 j(v0 v0Var, boolean z10, y0 y0Var) {
        if (v0Var instanceof c1) {
            return ((c1) v0Var).K(z10, y0Var);
        }
        boolean zK = y0Var.k();
        hf.h hVar = new hf.h(1, y0Var, y0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0, 1);
        return ((c1) v0Var).K(z10, zK ? new u0(hVar) : new j(2, hVar));
    }

    public static a0 k(v vVar, u uVar, fe.p pVar, int i10) {
        boolean z10 = true;
        vd.h hVar = uVar;
        if ((i10 & 1) != 0) {
            hVar = vd.i.f13722v;
        }
        a0 a0Var = new a0(l(vVar, hVar), z10, 1);
        a0Var.f0(w.f10276v, a0Var, pVar);
        return a0Var;
    }

    public static final vd.h l(v vVar, vd.h hVar) {
        vd.h hVarD = d(vVar.b(), hVar, true);
        we.e eVar = f0.f10232a;
        return (hVarD == eVar || hVarD.C(vd.d.f13721v) != null) ? hVarD : hVarD.q(eVar);
    }

    public static final Object m(Object obj) {
        return obj instanceof p ? com.bumptech.glide.c.e(((p) obj).f10263a) : obj;
    }

    public static final void n(h hVar, vd.c cVar, boolean z10) {
        Object obj = h.B.get(hVar);
        Throwable thF = hVar.f(obj);
        Object objE = thF != null ? com.bumptech.glide.c.e(thF) : hVar.g(obj);
        if (!z10) {
            cVar.i(objE);
            return;
        }
        ge.i.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        ue.f fVar = (ue.f) cVar;
        xd.c cVar2 = fVar.f12465z;
        Object obj2 = fVar.B;
        vd.h hVarH = cVar2.h();
        Object objL = ue.a.l(hVarH, obj2);
        m1 m1VarR = objL != ue.a.f12456d ? r(cVar2, hVarH, objL) : null;
        try {
            cVar2.i(objE);
            if (m1VarR == null || m1VarR.g0()) {
                ue.a.g(hVarH, objL);
            }
        } catch (Throwable th) {
            if (m1VarR == null || m1VarR.g0()) {
                ue.a.g(hVarH, objL);
            }
            throw th;
        }
    }

    public static final Object o(vd.h hVar, fe.p pVar) throws Throwable {
        o0 o0VarA;
        vd.h hVarD;
        Thread threadCurrentThread = Thread.currentThread();
        vd.g gVar = vd.d.f13721v;
        vd.e eVar = (vd.e) hVar.C(gVar);
        vd.i iVar = vd.i.f13722v;
        if (eVar == null) {
            o0VarA = i1.a();
            hVarD = d(iVar, hVar.q(o0VarA), true);
            we.e eVar2 = f0.f10232a;
            if (hVarD != eVar2 && hVarD.C(gVar) == null) {
                hVarD = hVarD.q(eVar2);
            }
        } else {
            if (eVar instanceof o0) {
            }
            o0VarA = (o0) i1.f10240a.get();
            hVarD = d(iVar, hVar, true);
            we.e eVar3 = f0.f10232a;
            if (hVarD != eVar3 && hVarD.C(gVar) == null) {
                hVarD = hVarD.q(eVar3);
            }
        }
        c cVar = new c(hVarD, threadCurrentThread, o0VarA);
        cVar.f0(w.f10276v, cVar, pVar);
        o0 o0Var = cVar.f10224z;
        if (o0Var != null) {
            int i10 = o0.A;
            o0Var.m0(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jN0 = o0Var != null ? o0Var.n0() : Long.MAX_VALUE;
                if (cVar.L()) {
                    if (o0Var != null) {
                        int i11 = o0.A;
                        o0Var.k0(false);
                    }
                    Object objQ = q(c1.f10226v.get(cVar));
                    p pVar2 = objQ instanceof p ? (p) objQ : null;
                    if (pVar2 == null) {
                        return objQ;
                    }
                    throw pVar2.f10263a;
                }
                LockSupport.parkNanos(cVar, jN0);
            } catch (Throwable th) {
                if (o0Var != null) {
                    int i12 = o0.A;
                    o0Var.k0(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cVar.n(interruptedException);
        throw interruptedException;
    }

    public static final String p(vd.c cVar) {
        Object objE;
        if (cVar instanceof ue.f) {
            return ((ue.f) cVar).toString();
        }
        try {
            objE = cVar + '@' + g(cVar);
        } catch (Throwable th) {
            objE = com.bumptech.glide.c.e(th);
        }
        if (rd.h.a(objE) != null) {
            objE = cVar.getClass().getName() + '@' + g(cVar);
        }
        return (String) objE;
    }

    public static final Object q(Object obj) {
        s0 s0Var;
        t0 t0Var = obj instanceof t0 ? (t0) obj : null;
        return (t0Var == null || (s0Var = t0Var.f10272a) == null) ? obj : s0Var;
    }

    public static final m1 r(vd.c cVar, vd.h hVar, Object obj) {
        m1 m1Var = null;
        if ((cVar instanceof xd.d) && hVar.C(n1.f10253v) != null) {
            xd.d dVarD = (xd.d) cVar;
            while (true) {
                if ((dVarD instanceof c0) || (dVarD = dVarD.d()) == null) {
                    break;
                }
                if (dVarD instanceof m1) {
                    m1Var = (m1) dVarD;
                    break;
                }
            }
            if (m1Var != null) {
                m1Var.h0(hVar, obj);
            }
        }
        return m1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object s(vd.h hVar, fe.p pVar, vd.c cVar) throws Throwable {
        vd.h hVarH = cVar.h();
        vd.h hVarQ = !((Boolean) hVar.J(Boolean.FALSE, new q(0))).booleanValue() ? hVarH.q(hVar) : d(hVarH, hVar, false);
        v0 v0Var = (v0) hVarQ.C(t.f10271w);
        if (v0Var != null && !v0Var.a()) {
            throw ((c1) v0Var).x();
        }
        if (hVarQ == hVarH) {
            ue.q qVar = new ue.q(cVar, hVarQ);
            return a.a.r(qVar, qVar, pVar);
        }
        vd.d dVar = vd.d.f13721v;
        if (ge.i.a(hVarQ.C(dVar), hVarH.C(dVar))) {
            m1 m1Var = new m1(cVar, hVarQ);
            vd.h hVar2 = m1Var.f10215x;
            Object objL = ue.a.l(hVar2, null);
            try {
                return a.a.r(m1Var, m1Var, pVar);
            } finally {
                ue.a.g(hVar2, objL);
            }
        }
        c0 c0Var = new c0(cVar, hVarQ);
        try {
            ue.a.h(rd.l.f11003a, u8.a.t(((xd.a) pVar).m(c0Var, c0Var)));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c0.f10225z;
            do {
                int i10 = atomicIntegerFieldUpdater.get(c0Var);
                if (i10 != 0) {
                    if (i10 != 2) {
                        throw new IllegalStateException("Already suspended");
                    }
                    Object objQ = q(c1.f10226v.get(c0Var));
                    if (objQ instanceof p) {
                        throw ((p) objQ).f10263a;
                    }
                    return objQ;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(c0Var, 0, 1));
            return wd.a.f14143v;
        } catch (Throwable th) {
            c0Var.i(com.bumptech.glide.c.e(th));
            throw th;
        }
    }

    public static final Object t(long j4, d1.u uVar, y4.r rVar) throws Throwable {
        long jE;
        Object pVar;
        Object objP;
        int i10 = oe.a.f9767y;
        int i11 = 1;
        boolean z10 = j4 > 0;
        if (z10) {
            long jE2 = com.bumptech.glide.d.E(999999L, oe.c.NANOSECONDS);
            if (oe.a.d(j4)) {
                if (oe.a.d(jE2) && (jE2 ^ j4) < 0) {
                    throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
                }
            } else if (oe.a.d(jE2)) {
                j4 = jE2;
            } else {
                int i12 = ((int) j4) & 1;
                if (i12 == (((int) jE2) & 1)) {
                    long j7 = (j4 >> 1) + (jE2 >> 1);
                    j4 = i12 == 0 ? (-4611686018426999999L > j7 || j7 >= 4611686018427000000L) ? com.bumptech.glide.d.n(j7 / ((long) 1000000)) : com.bumptech.glide.d.o(j7) : (-4611686018426L > j7 || j7 >= 4611686018427L) ? com.bumptech.glide.d.n(com.bumptech.glide.f.h(j7)) : com.bumptech.glide.d.o(j7 * ((long) 1000000));
                } else {
                    j4 = i12 == 1 ? oe.a.a(j4 >> 1, jE2 >> 1) : oe.a.a(jE2 >> 1, j4 >> 1);
                }
            }
            jE = ((((int) j4) & 1) != 1 || oe.a.d(j4)) ? oe.a.e(j4, oe.c.MILLISECONDS) : j4 >> 1;
        } else {
            if (z10) {
                throw new a9.l();
            }
            jE = 0;
        }
        if (jE <= 0) {
            throw new j1("Timed out immediately", null);
        }
        k1 k1Var = new k1(jE, rVar);
        j(k1Var, true, new j(i11, f(k1Var.f12483y.h()).R(k1Var.f10246z, k1Var, k1Var.f10215x)));
        try {
            ge.s.a(2, uVar);
            pVar = uVar.j(k1Var, k1Var);
        } catch (Throwable th) {
            pVar = new p(th, false);
        }
        Object obj = wd.a.f14143v;
        if (pVar == obj || (objP = k1Var.P(pVar)) == f10285e) {
            return obj;
        }
        if (objP instanceof p) {
            Throwable th2 = ((p) objP).f10263a;
            if (!(th2 instanceof j1) || ((j1) th2).f10244v != k1Var) {
                throw th2;
            }
            if (pVar instanceof p) {
                throw ((p) pVar).f10263a;
            }
        } else {
            pVar = q(objP);
        }
        return pVar;
    }
}
