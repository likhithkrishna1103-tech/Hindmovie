package ke;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i4.o0 f7740a = new i4.o0("RESUME_TOKEN", 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i4.o0 f7741b = new i4.o0("REMOVED_TASK", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i4.o0 f7742c = new i4.o0("CLOSED_EMPTY", 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i4.o0 f7743d = new i4.o0("COMPLETING_ALREADY", 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i4.o0 f7744e = new i4.o0("COMPLETING_WAITING_CHILDREN", 1);
    public static final i4.o0 f = new i4.o0("COMPLETING_RETRY", 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i4.o0 f7745g = new i4.o0("TOO_LATE_TO_CANCEL", 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i4.o0 f7746h = new i4.o0("SEALED", 1);
    public static final j0 i = new j0(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j0 f7747j = new j0(true);

    public static final pe.c a(rd.h hVar) {
        if (hVar.v(s.f7730v) == null) {
            hVar = hVar.K(new x0(null));
        }
        return new pe.c(hVar);
    }

    public static a0 b(pe.c cVar, ae.p pVar) {
        boolean z2 = true;
        rd.h hVarC = c(cVar.b(), rd.i.f11572u, true);
        re.e eVar = f0.f7690a;
        if (hVarC != eVar && hVarC.v(rd.d.f11571u) == null) {
            hVarC = hVarC.K(eVar);
        }
        a0 a0Var = new a0(hVarC, z2, 0);
        a0Var.X(v.f7736u, a0Var, pVar);
        return a0Var;
    }

    public static final rd.h c(rd.h hVar, rd.h hVar2, boolean z2) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) hVar.d(bool, new p(0))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) hVar2.d(bool, new p(0))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return hVar.K(hVar2);
        }
        p pVar = new p(1);
        rd.i iVar = rd.i.f11572u;
        rd.h hVar3 = (rd.h) hVar.d(iVar, pVar);
        Object objD = hVar2;
        if (zBooleanValue2) {
            objD = hVar2.d(iVar, new p(2));
        }
        return hVar3.K((rd.h) objD);
    }

    public static final r d(Executor executor) {
        return new q0(executor);
    }

    public static final b0 e(rd.h hVar) {
        rd.f fVarV = hVar.v(rd.d.f11571u);
        b0 b0Var = fVarV instanceof b0 ? (b0) fVarV : null;
        return b0Var == null ? z.f7749a : b0Var;
    }

    public static final String f(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final g g(rd.c cVar) {
        g gVar;
        g gVar2;
        if (!(cVar instanceof pe.f)) {
            return new g(1, cVar);
        }
        pe.f fVar = (pe.f) cVar;
        i4.o0 o0Var = pe.a.f10367c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pe.f.B;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            gVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, o0Var);
                gVar2 = null;
                break;
            }
            if (obj instanceof g) {
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, o0Var)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                        break;
                    }
                }
                gVar2 = (g) obj;
                break loop0;
            }
            if (obj != o0Var && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (gVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = g.A;
            Object obj2 = atomicReferenceFieldUpdater2.get(gVar2);
            if (!(obj2 instanceof n) || ((n) obj2).f7713d == null) {
                g.f7692z.set(gVar2, 536870911);
                atomicReferenceFieldUpdater2.set(gVar2, b.f7675a);
                gVar = gVar2;
            } else {
                gVar2.r();
            }
            if (gVar != null) {
                return gVar;
            }
        }
        return new g(2, cVar);
    }

    public static final void h(Throwable th, rd.h hVar) {
        try {
            le.b bVar = (le.b) hVar.v(s.f7729u);
            if (bVar != null) {
                bVar.h0(th);
            } else {
                pe.a.d(th, hVar);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                com.bumptech.glide.d.d(runtimeException, th);
                th = runtimeException;
            }
            pe.a.d(th, hVar);
        }
    }

    public static final h0 i(v0 v0Var, boolean z2, z0 z0Var) {
        if (v0Var instanceof d1) {
            return ((d1) v0Var).D(z2, z0Var);
        }
        boolean zK = z0Var.k();
        y0 y0Var = new y0(1, z0Var, z0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0, 0);
        return ((d1) v0Var).D(z2, zK ? new u0(y0Var) : new i(2, y0Var));
    }

    public static a0 j(u uVar, t tVar, ae.p pVar, int i10) {
        boolean z2 = true;
        rd.h hVar = tVar;
        if ((i10 & 1) != 0) {
            hVar = rd.i.f11572u;
        }
        rd.h hVarC = c(uVar.b(), hVar, true);
        re.e eVar = f0.f7690a;
        if (hVarC != eVar && hVarC.v(rd.d.f11571u) == null) {
            hVarC = hVarC.K(eVar);
        }
        a0 a0Var = new a0(hVarC, z2, 1);
        a0Var.X(v.f7736u, a0Var, pVar);
        return a0Var;
    }

    public static final Object k(Object obj) {
        return obj instanceof o ? i5.a.h(((o) obj).f7717a) : obj;
    }

    public static final void l(g gVar, rd.c cVar, boolean z2) {
        Object obj = g.A.get(gVar);
        Throwable thH = gVar.h(obj);
        Object objH = thH != null ? i5.a.h(thH) : gVar.i(obj);
        if (!z2) {
            cVar.g(objH);
            return;
        }
        be.h.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        pe.f fVar = (pe.f) cVar;
        td.c cVar2 = fVar.f10377y;
        Object obj2 = fVar.A;
        rd.h hVarF = cVar2.f();
        Object objK = pe.a.k(hVarF, obj2);
        n1 n1VarP = objK != pe.a.f10368d ? p(cVar2, hVarF, objK) : null;
        try {
            cVar2.g(objH);
            if (n1VarP == null || n1VarP.Y()) {
                pe.a.g(hVarF, objK);
            }
        } catch (Throwable th) {
            if (n1VarP == null || n1VarP.Y()) {
                pe.a.g(hVarF, objK);
            }
            throw th;
        }
    }

    public static final Object m(rd.h hVar, ae.p pVar) throws Throwable {
        o0 o0VarA;
        rd.h hVarC;
        Thread threadCurrentThread = Thread.currentThread();
        rd.g gVar = rd.d.f11571u;
        rd.e eVar = (rd.e) hVar.v(gVar);
        rd.i iVar = rd.i.f11572u;
        if (eVar == null) {
            o0VarA = j1.a();
            hVarC = c(iVar, hVar.K(o0VarA), true);
            re.e eVar2 = f0.f7690a;
            if (hVarC != eVar2 && hVarC.v(gVar) == null) {
                hVarC = hVarC.K(eVar2);
            }
        } else {
            if (eVar instanceof o0) {
            }
            o0VarA = (o0) j1.f7701a.get();
            hVarC = c(iVar, hVar, true);
            re.e eVar3 = f0.f7690a;
            if (hVarC != eVar3 && hVarC.v(gVar) == null) {
                hVarC = hVarC.K(eVar3);
            }
        }
        c cVar = new c(hVarC, threadCurrentThread, o0VarA);
        cVar.X(v.f7736u, cVar, pVar);
        o0 o0Var = cVar.f7679y;
        if (o0Var != null) {
            int i10 = o0.f7718z;
            o0Var.m0(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jN0 = o0Var != null ? o0Var.n0() : Long.MAX_VALUE;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d1.f7686u;
                if (!(atomicReferenceFieldUpdater.get(cVar) instanceof s0)) {
                    if (o0Var != null) {
                        int i11 = o0.f7718z;
                        o0Var.k0(false);
                    }
                    Object objO = o(atomicReferenceFieldUpdater.get(cVar));
                    o oVar = objO instanceof o ? (o) objO : null;
                    if (oVar == null) {
                        return objO;
                    }
                    throw oVar.f7717a;
                }
                LockSupport.parkNanos(cVar, jN0);
            } catch (Throwable th) {
                if (o0Var != null) {
                    int i12 = o0.f7718z;
                    o0Var.k0(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cVar.j(interruptedException);
        throw interruptedException;
    }

    public static final String n(rd.c cVar) {
        Object objH;
        if (cVar instanceof pe.f) {
            return ((pe.f) cVar).toString();
        }
        try {
            objH = cVar + '@' + f(cVar);
        } catch (Throwable th) {
            objH = i5.a.h(th);
        }
        if (nd.h.a(objH) != null) {
            objH = cVar.getClass().getName() + '@' + f(cVar);
        }
        return (String) objH;
    }

    public static final Object o(Object obj) {
        s0 s0Var;
        t0 t0Var = obj instanceof t0 ? (t0) obj : null;
        return (t0Var == null || (s0Var = t0Var.f7733a) == null) ? obj : s0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, td.c] */
    /* JADX WARN: Type inference failed for: r2v1, types: [td.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [td.d] */
    public static final n1 p(td.c cVar, rd.h hVar, Object obj) {
        n1 n1Var = null;
        if (l4.a.v(cVar) && hVar.v(o1.f7722u) != null) {
            while (true) {
                if ((cVar instanceof c0) || (cVar = cVar.c()) == 0) {
                    break;
                }
                if (cVar instanceof n1) {
                    n1Var = (n1) cVar;
                    break;
                }
            }
            if (n1Var != null) {
                n1Var.Z(hVar, obj);
            }
        }
        return n1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object q(ae.p pVar, rd.h hVar, td.c cVar) throws Throwable {
        rd.h hVarF = cVar.f();
        rd.h hVarK = !((Boolean) hVar.d(Boolean.FALSE, new p(0))).booleanValue() ? hVarF.K(hVar) : c(hVarF, hVar, false);
        v0 v0Var = (v0) hVarK.v(s.f7730v);
        if (v0Var != null && !v0Var.a()) {
            throw ((d1) v0Var).s();
        }
        if (hVarK == hVarF) {
            pe.q qVar = new pe.q(hVarK, cVar);
            return z7.a.D(qVar, qVar, pVar);
        }
        rd.d dVar = rd.d.f11571u;
        if (be.h.a(hVarK.v(dVar), hVarF.v(dVar))) {
            n1 n1Var = new n1(hVarK, cVar);
            rd.h hVar2 = n1Var.f7673w;
            Object objK = pe.a.k(hVar2, null);
            try {
                return z7.a.D(n1Var, n1Var, pVar);
            } finally {
                pe.a.g(hVar2, objK);
            }
        }
        c0 c0Var = new c0(hVarK, cVar);
        try {
            pe.a.h(nd.k.f8990a, a.a.w(((td.a) pVar).m(c0Var, c0Var)));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c0.f7680y;
            do {
                int i10 = atomicIntegerFieldUpdater.get(c0Var);
                if (i10 != 0) {
                    if (i10 != 2) {
                        throw new IllegalStateException("Already suspended");
                    }
                    Object objO = o(d1.f7686u.get(c0Var));
                    if (objO instanceof o) {
                        throw ((o) objO).f7717a;
                    }
                    return objO;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(c0Var, 0, 1));
            return sd.a.f11942u;
        } catch (Throwable th) {
            c0Var.g(i5.a.h(th));
            throw th;
        }
    }

    public static final Object r(long j5, cc.l lVar, t4.d dVar) throws Throwable {
        long jD;
        Object oVar;
        Object objL;
        int i10 = je.a.f6958x;
        int i11 = 1;
        boolean z2 = j5 > 0;
        if (z2) {
            long jO = a.a.O(999999L, je.c.NANOSECONDS);
            if (je.a.c(j5)) {
                if (je.a.c(jO) && (jO ^ j5) < 0) {
                    throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
                }
            } else if (je.a.c(jO)) {
                j5 = jO;
            } else {
                int i12 = ((int) j5) & 1;
                if (i12 == (((int) jO) & 1)) {
                    long j8 = (j5 >> 1) + (jO >> 1);
                    if (i12 == 0) {
                        if (-4611686018426999999L > j8 || j8 >= 4611686018427000000L) {
                            j5 = a.a.g(j8 / ((long) 1000000));
                        } else {
                            j5 = j8 << 1;
                            int i13 = je.b.f6960a;
                        }
                    } else if (-4611686018426L > j8 || j8 >= 4611686018427L) {
                        j5 = a.a.g(ga.b.d(j8));
                    } else {
                        j5 = (j8 * ((long) 1000000)) << 1;
                        int i14 = je.b.f6960a;
                    }
                } else {
                    j5 = i12 == 1 ? je.a.a(j5 >> 1, jO >> 1) : je.a.a(jO >> 1, j5 >> 1);
                }
            }
            jD = ((((int) j5) & 1) != 1 || je.a.c(j5)) ? je.a.d(j5, je.c.MILLISECONDS) : j5 >> 1;
        } else {
            if (z2) {
                throw new a2.y0();
            }
            jD = 0;
        }
        if (jD <= 0) {
            throw new k1("Timed out immediately", null);
        }
        l1 l1Var = new l1(jD, dVar);
        i(l1Var, true, new i(i11, e(l1Var.f10397x.f()).S(l1Var.f7707y, l1Var, l1Var.f7673w)));
        try {
            be.q.a(2, lVar);
            oVar = lVar.i(l1Var, l1Var);
        } catch (Throwable th) {
            oVar = new o(th, false);
        }
        Object obj = sd.a.f11942u;
        if (oVar == obj || (objL = l1Var.L(oVar)) == f7744e) {
            return obj;
        }
        if (objL instanceof o) {
            Throwable th2 = ((o) objL).f7717a;
            if (!(th2 instanceof k1) || ((k1) th2).f7704u != l1Var) {
                throw th2;
            }
            if (oVar instanceof o) {
                throw ((o) oVar).f7717a;
            }
        } else {
            oVar = o(objL);
        }
        return oVar;
    }
}
