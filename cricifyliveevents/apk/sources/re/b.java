package re;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.o1;
import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f11008v = e.f11029p;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public pe.h f11009w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ c f11010x;

    public b(c cVar) {
        this.f11010x = cVar;
    }

    @Override // pe.o1
    public final void a(ue.r rVar, int i) {
        pe.h hVar = this.f11009w;
        if (hVar != null) {
            hVar.a(rVar, i);
        }
    }

    public final Object b(se.e eVar) throws Throwable {
        k kVar;
        k kVarM;
        Object obj = this.f11008v;
        boolean z10 = true;
        if (obj == e.f11029p || obj == e.f11025l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.B;
            c cVar = this.f11010x;
            k kVar2 = (k) atomicReferenceFieldUpdater.get(cVar);
            while (!cVar.s(true, c.f11011w.get(cVar))) {
                long andIncrement = c.f11012x.getAndIncrement(cVar);
                long j4 = e.f11017b;
                long j7 = andIncrement / j4;
                int i = (int) (andIncrement % j4);
                if (kVar2.f12485c != j7) {
                    k kVarM2 = cVar.m(j7, kVar2);
                    if (kVarM2 == null) {
                        continue;
                    } else {
                        kVar = kVarM2;
                    }
                } else {
                    kVar = kVar2;
                }
                Object objA = cVar.A(kVar, i, andIncrement, null);
                d5.a aVar = e.f11026m;
                if (objA == aVar) {
                    throw new IllegalStateException("unreachable");
                }
                d5.a aVar2 = e.f11028o;
                if (objA == aVar2) {
                    if (andIncrement < cVar.q()) {
                        kVar.a();
                    }
                    kVar2 = kVar;
                } else if (objA == e.f11027n) {
                    pe.h hVarH = x.h(u8.a.t(eVar));
                    try {
                        this.f11009w = hVarH;
                        try {
                            Object objA2 = cVar.A(kVar, i, andIncrement, this);
                            if (objA2 == aVar) {
                                a(kVar, i);
                            } else {
                                if (objA2 == aVar2) {
                                    if (andIncrement < cVar.q()) {
                                        kVar.a();
                                    }
                                    k kVar3 = (k) c.B.get(cVar);
                                    while (true) {
                                        if (cVar.s(true, c.f11011w.get(cVar))) {
                                            pe.h hVar = this.f11009w;
                                            ge.i.b(hVar);
                                            this.f11009w = null;
                                            this.f11008v = e.f11025l;
                                            Throwable thN = cVar.n();
                                            if (thN == null) {
                                                hVar.i(Boolean.FALSE);
                                            } else {
                                                hVar.i(com.bumptech.glide.c.e(thN));
                                            }
                                        } else {
                                            long andIncrement2 = c.f11012x.getAndIncrement(cVar);
                                            long j10 = e.f11017b;
                                            long j11 = andIncrement2 / j10;
                                            int i10 = (int) (andIncrement2 % j10);
                                            if (kVar3.f12485c != j11) {
                                                kVarM = cVar.m(j11, kVar3);
                                                if (kVarM == null) {
                                                }
                                            } else {
                                                kVarM = kVar3;
                                            }
                                            Object objA3 = cVar.A(kVarM, i10, andIncrement2, this);
                                            if (objA3 == e.f11026m) {
                                                a(kVarM, i10);
                                                break;
                                            }
                                            if (objA3 == e.f11028o) {
                                                if (andIncrement2 < cVar.q()) {
                                                    kVarM.a();
                                                }
                                                kVar3 = kVarM;
                                            } else {
                                                if (objA3 == e.f11027n) {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                                kVarM.a();
                                                this.f11008v = objA3;
                                                this.f11009w = null;
                                            }
                                        }
                                    }
                                } else {
                                    kVar.a();
                                    this.f11008v = objA2;
                                    this.f11009w = null;
                                }
                                hVarH.k(Boolean.TRUE, null);
                            }
                            return hVarH.v();
                        } catch (Throwable th) {
                            th = th;
                            hVarH.E();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    kVar.a();
                    this.f11008v = objA;
                }
            }
            this.f11008v = e.f11025l;
            Throwable thN2 = cVar.n();
            if (thN2 != null) {
                int i11 = ue.s.f12486a;
                throw thN2;
            }
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
