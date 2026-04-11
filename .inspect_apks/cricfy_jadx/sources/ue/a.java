package ue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d5.a f12453a = new d5.a(3, "CLOSED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d5.a f12454b = new d5.a(3, "UNDEFINED");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d5.a f12455c = new d5.a(3, "REUSABLE_CLAIMED");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d5.a f12456d = new d5.a(3, "NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final pe.q f12457e = new pe.q(4);
    public static final pe.q f = new pe.q(5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final pe.q f12458g = new pe.q(6);

    public static final void a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(l0.e.g(i, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(r rVar, long j4, fe.p pVar) {
        while (true) {
            if (rVar.f12485c >= j4 && !rVar.c()) {
                return rVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f12459a;
            Object obj = atomicReferenceFieldUpdater.get(rVar);
            d5.a aVar = f12453a;
            if (obj == aVar) {
                return aVar;
            }
            r rVar2 = (r) ((b) obj);
            if (rVar2 == null) {
                rVar2 = (r) pVar.j(Long.valueOf(rVar.f12485c + 1), rVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(rVar, null, rVar2)) {
                    if (atomicReferenceFieldUpdater.get(rVar) != null) {
                        break;
                    }
                }
                if (rVar.c()) {
                    rVar.d();
                }
            }
            rVar = rVar2;
        }
    }

    public static final r c(Object obj) {
        if (obj != f12453a) {
            return (r) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(Throwable th, vd.h hVar) {
        Throwable runtimeException;
        Iterator it = d.f12462a.iterator();
        while (it.hasNext()) {
            try {
                ((qe.b) it.next()).h0(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    ab.b.c(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            ab.b.c(th, new e(hVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f12453a;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void g(vd.h hVar, Object obj) {
        if (obj == f12456d) {
            return;
        }
        if (!(obj instanceof x)) {
            Object objJ = hVar.J(null, f);
            ge.i.c(objJ, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((u) objJ).b(obj);
            return;
        }
        x xVar = (x) obj;
        u[] uVarArr = xVar.f12496c;
        int length = uVarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            u uVar = uVarArr[length];
            ge.i.b(uVar);
            uVar.b(xVar.f12495b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0097 A[Catch: all -> 0x0076, DONT_GENERATE, TryCatch #2 {all -> 0x0076, blocks: (B:19:0x0054, B:21:0x0062, B:23:0x0068, B:36:0x009a, B:26:0x0078, B:28:0x0086, B:33:0x0091, B:35:0x0097, B:41:0x00a7, B:44:0x00b0, B:43:0x00ad, B:31:0x008c), top: B:57:0x0054, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(java.lang.Object r9, vd.c r10) {
        /*
            boolean r0 = r10 instanceof ue.f
            if (r0 == 0) goto Lbb
            ue.f r10 = (ue.f) r10
            pe.s r0 = r10.f12464y
            xd.c r1 = r10.f12465z
            java.lang.Throwable r2 = rd.h.a(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            pe.p r3 = new pe.p
            r4 = 0
            r3.<init>(r2, r4)
        L18:
            vd.h r2 = r1.h()
            boolean r2 = r0.i0(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.A = r3
            r10.f10228x = r4
            vd.h r9 = r1.h()
            r0.h0(r9, r10)
            return
        L2f:
            pe.o0 r0 = pe.i1.a()
            long r5 = r0.f10259x
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L51
            r10.A = r3
            r10.f10228x = r4
            sd.h r9 = r0.f10261z
            if (r9 != 0) goto L4d
            sd.h r9 = new sd.h
            r9.<init>()
            r0.f10261z = r9
        L4d:
            r9.addLast(r10)
            goto Lb5
        L51:
            r0.m0(r4)
            vd.h r2 = r1.h()     // Catch: java.lang.Throwable -> L76
            pe.t r3 = pe.t.f10271w     // Catch: java.lang.Throwable -> L76
            vd.f r2 = r2.C(r3)     // Catch: java.lang.Throwable -> L76
            pe.v0 r2 = (pe.v0) r2     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L78
            boolean r3 = r2.a()     // Catch: java.lang.Throwable -> L76
            if (r3 != 0) goto L78
            pe.c1 r2 = (pe.c1) r2     // Catch: java.lang.Throwable -> L76
            java.util.concurrent.CancellationException r9 = r2.x()     // Catch: java.lang.Throwable -> L76
            rd.g r9 = com.bumptech.glide.c.e(r9)     // Catch: java.lang.Throwable -> L76
            r10.i(r9)     // Catch: java.lang.Throwable -> L76
            goto L9a
        L76:
            r9 = move-exception
            goto Lb1
        L78:
            java.lang.Object r2 = r10.B     // Catch: java.lang.Throwable -> L76
            vd.h r3 = r1.h()     // Catch: java.lang.Throwable -> L76
            java.lang.Object r2 = l(r3, r2)     // Catch: java.lang.Throwable -> L76
            d5.a r5 = ue.a.f12456d     // Catch: java.lang.Throwable -> L76
            if (r2 == r5) goto L8b
            pe.m1 r5 = pe.x.r(r1, r3, r2)     // Catch: java.lang.Throwable -> L76
            goto L8c
        L8b:
            r5 = 0
        L8c:
            r1.i(r9)     // Catch: java.lang.Throwable -> La4
            if (r5 == 0) goto L97
            boolean r9 = r5.g0()     // Catch: java.lang.Throwable -> L76
            if (r9 == 0) goto L9a
        L97:
            g(r3, r2)     // Catch: java.lang.Throwable -> L76
        L9a:
            boolean r9 = r0.o0()     // Catch: java.lang.Throwable -> L76
            if (r9 != 0) goto L9a
        La0:
            r0.k0(r4)
            goto Lb5
        La4:
            r9 = move-exception
            if (r5 == 0) goto Lad
            boolean r1 = r5.g0()     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto Lb0
        Lad:
            g(r3, r2)     // Catch: java.lang.Throwable -> L76
        Lb0:
            throw r9     // Catch: java.lang.Throwable -> L76
        Lb1:
            r10.j(r9)     // Catch: java.lang.Throwable -> Lb6
            goto La0
        Lb5:
            return
        Lb6:
            r9 = move-exception
            r0.k0(r4)
            throw r9
        Lbb:
            r10.i(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ue.a.h(java.lang.Object, vd.c):void");
    }

    public static final long i(String str, long j4, long j7, long j10) {
        String property;
        int i = t.f12487a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j4;
        }
        Long lB0 = ne.o.b0(property);
        if (lB0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lB0.longValue();
        if (j7 <= jLongValue && jLongValue <= j10) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j7 + ".." + j10 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int j(int i, int i10, String str) {
        return (int) i(str, i, 1, (i10 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object k(vd.h hVar) {
        Object objJ = hVar.J(0, f12457e);
        ge.i.b(objJ);
        return objJ;
    }

    public static final Object l(vd.h hVar, Object obj) {
        if (obj == null) {
            obj = k(hVar);
        }
        return obj == 0 ? f12456d : obj instanceof Integer ? hVar.J(new x(((Number) obj).intValue(), hVar), f12458g) : ((u) obj).c(hVar);
    }
}
