package pe;

import i4.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f10365a = new o0("CLOSED", 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o0 f10366b = new o0("UNDEFINED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o0 f10367c = new o0("REUSABLE_CLAIMED", 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o0 f10368d = new o0("NO_THREAD_ELEMENTS", 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ke.p f10369e = new ke.p(4);
    public static final ke.p f = new ke.p(5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ke.p f10370g = new ke.p(6);

    public static final void a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(e6.j.l("Expected positive parallelism level, but got ", i).toString());
        }
    }

    public static final Object b(r rVar, long j5, ae.p pVar) {
        while (true) {
            if (rVar.f10399c >= j5 && !rVar.c()) {
                return rVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f10371a;
            Object obj = atomicReferenceFieldUpdater.get(rVar);
            o0 o0Var = f10365a;
            if (obj == o0Var) {
                return o0Var;
            }
            r rVar2 = (r) ((b) obj);
            if (rVar2 == null) {
                rVar2 = (r) pVar.i(Long.valueOf(rVar.f10399c + 1), rVar);
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
        if (obj != f10365a) {
            return (r) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(Throwable th, rd.h hVar) {
        Throwable runtimeException;
        Iterator it = d.f10374a.iterator();
        while (it.hasNext()) {
            try {
                ((le.b) it.next()).h0(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    com.bumptech.glide.d.d(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            com.bumptech.glide.d.d(th, new e(hVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f10365a;
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

    public static final void g(rd.h hVar, Object obj) {
        if (obj == f10368d) {
            return;
        }
        if (!(obj instanceof x)) {
            Object objD = hVar.d(null, f);
            be.h.c(objD, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((u) objD).b(obj);
            return;
        }
        x xVar = (x) obj;
        u[] uVarArr = xVar.f10410c;
        int length = uVarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            u uVar = uVarArr[length];
            be.h.b(uVar);
            uVar.b(xVar.f10409b[length]);
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
    public static final void h(java.lang.Object r9, rd.c r10) {
        /*
            boolean r0 = r10 instanceof pe.f
            if (r0 == 0) goto Lbb
            pe.f r10 = (pe.f) r10
            ke.r r0 = r10.f10376x
            td.c r1 = r10.f10377y
            java.lang.Throwable r2 = nd.h.a(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            ke.o r3 = new ke.o
            r4 = 0
            r3.<init>(r2, r4)
        L18:
            rd.h r2 = r1.f()
            boolean r2 = r0.i0(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.f10378z = r3
            r10.f7685w = r4
            rd.h r9 = r1.f()
            r0.h0(r9, r10)
            return
        L2f:
            ke.o0 r0 = ke.j1.a()
            long r5 = r0.f7719w
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L51
            r10.f10378z = r3
            r10.f7685w = r4
            od.g r9 = r0.f7721y
            if (r9 != 0) goto L4d
            od.g r9 = new od.g
            r9.<init>()
            r0.f7721y = r9
        L4d:
            r9.addLast(r10)
            goto Lb5
        L51:
            r0.m0(r4)
            rd.h r2 = r1.f()     // Catch: java.lang.Throwable -> L76
            ke.s r3 = ke.s.f7730v     // Catch: java.lang.Throwable -> L76
            rd.f r2 = r2.v(r3)     // Catch: java.lang.Throwable -> L76
            ke.v0 r2 = (ke.v0) r2     // Catch: java.lang.Throwable -> L76
            if (r2 == 0) goto L78
            boolean r3 = r2.a()     // Catch: java.lang.Throwable -> L76
            if (r3 != 0) goto L78
            ke.d1 r2 = (ke.d1) r2     // Catch: java.lang.Throwable -> L76
            java.util.concurrent.CancellationException r9 = r2.s()     // Catch: java.lang.Throwable -> L76
            nd.g r9 = i5.a.h(r9)     // Catch: java.lang.Throwable -> L76
            r10.g(r9)     // Catch: java.lang.Throwable -> L76
            goto L9a
        L76:
            r9 = move-exception
            goto Lb1
        L78:
            java.lang.Object r2 = r10.A     // Catch: java.lang.Throwable -> L76
            rd.h r3 = r1.f()     // Catch: java.lang.Throwable -> L76
            java.lang.Object r2 = k(r3, r2)     // Catch: java.lang.Throwable -> L76
            i4.o0 r5 = pe.a.f10368d     // Catch: java.lang.Throwable -> L76
            if (r2 == r5) goto L8b
            ke.n1 r5 = ke.x.p(r1, r3, r2)     // Catch: java.lang.Throwable -> L76
            goto L8c
        L8b:
            r5 = 0
        L8c:
            r1.g(r9)     // Catch: java.lang.Throwable -> La4
            if (r5 == 0) goto L97
            boolean r9 = r5.Y()     // Catch: java.lang.Throwable -> L76
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
            boolean r1 = r5.Y()     // Catch: java.lang.Throwable -> L76
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
            r10.g(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pe.a.h(java.lang.Object, rd.c):void");
    }

    public static final long i(String str, long j5, long j8, long j10) {
        String property;
        int i = t.f10401a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j5;
        }
        Long lG = ie.m.G(property);
        if (lG == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lG.longValue();
        if (j8 <= jLongValue && jLongValue <= j10) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j8 + ".." + j10 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int j(int i, int i10, String str) {
        return (int) i(str, i, 1, (i10 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object k(rd.h hVar, Object obj) {
        if (obj == null) {
            obj = hVar.d(0, f10369e);
            be.h.b(obj);
        }
        return obj == 0 ? f10368d : obj instanceof Integer ? hVar.d(new x(((Number) obj).intValue(), hVar), f10370g) : ((u) obj).c(hVar);
    }
}
