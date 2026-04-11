package d1;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends ge.j implements fe.l {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3209w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3210x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f3211y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b1(int i, Object obj, Object obj2) {
        super(1);
        this.f3209w = i;
        this.f3210x = obj;
        this.f3211y = obj2;
    }

    @Override // fe.l
    public final Object a(Object obj) throws Throwable {
        Object hVar;
        rd.l lVar;
        rd.l lVar2;
        switch (this.f3209w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                boolean zA = ge.i.a((String) obj, ((File) this.f3210x).getName());
                rd.l lVar3 = rd.l.f11003a;
                if (zA) {
                    re.p pVar = (re.p) ((re.q) this.f3211y);
                    Object objE = pVar.e(lVar3);
                    if (objE instanceof re.i) {
                        Object obj2 = ((re.j) pe.x.o(vd.i.f13722v, new e(pVar, (vd.c) null, 5))).f11038a;
                    }
                }
                return lVar3;
            case 1:
                Throwable th = (Throwable) obj;
                ((e0) this.f3210x).a(th);
                re.c cVar = (re.c) ((b6.f) this.f3211y).f1802y;
                cVar.h(th, false);
                do {
                    cVar.getClass();
                    AtomicLongFieldUpdater atomicLongFieldUpdater = re.c.f11012x;
                    long j4 = atomicLongFieldUpdater.get(cVar);
                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = re.c.f11011w;
                    long j7 = atomicLongFieldUpdater2.get(cVar);
                    if (cVar.s(true, j7)) {
                        hVar = new re.h(cVar.n());
                    } else {
                        long j10 = j7 & 1152921504606846975L;
                        re.i iVar = re.j.f11037b;
                        if (j4 >= j10) {
                            hVar = iVar;
                        } else {
                            Object obj3 = re.e.f11024k;
                            re.k kVar = (re.k) re.c.B.get(cVar);
                            while (true) {
                                if (cVar.s(true, atomicLongFieldUpdater2.get(cVar))) {
                                    hVar = new re.h(cVar.n());
                                } else {
                                    long andIncrement = atomicLongFieldUpdater.getAndIncrement(cVar);
                                    long j11 = re.e.f11017b;
                                    long j12 = andIncrement / j11;
                                    int i = (int) (andIncrement % j11);
                                    if (kVar.f12485c != j12) {
                                        re.k kVarM = cVar.m(j12, kVar);
                                        if (kVarM == null) {
                                            continue;
                                        } else {
                                            kVar = kVarM;
                                        }
                                    }
                                    Object objA = cVar.A(kVar, i, andIncrement, obj3);
                                    if (objA == re.e.f11026m) {
                                        pe.o1 o1Var = obj3 instanceof pe.o1 ? (pe.o1) obj3 : null;
                                        if (o1Var != null) {
                                            o1Var.a(kVar, i);
                                        }
                                        cVar.C(andIncrement);
                                        kVar.h();
                                    } else if (objA == re.e.f11028o) {
                                        if (andIncrement < cVar.q()) {
                                            kVar.a();
                                        }
                                    } else {
                                        if (objA == re.e.f11027n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        kVar.a();
                                        hVar = objA;
                                    }
                                }
                            }
                        }
                    }
                    lVar = null;
                    if (hVar instanceof re.i) {
                        hVar = null;
                    }
                    lVar2 = rd.l.f11003a;
                    if (hVar != null) {
                        pe.n nVar = ((t0) hVar).f3301b;
                        Throwable cancellationException = th == null ? new CancellationException("DataStore scope was cancelled before updateData could complete") : th;
                        nVar.getClass();
                        nVar.N(new pe.p(cancellationException, false));
                        lVar = lVar2;
                    }
                } while (lVar != null);
                return lVar2;
            default:
                Throwable th2 = (Throwable) obj;
                x.i iVar2 = (x.i) this.f3210x;
                if (th2 == null) {
                    Object objY = ((pe.a0) this.f3211y).y();
                    iVar2.f14204d = true;
                    x.k kVar2 = iVar2.f14202b;
                    if (kVar2 != null && kVar2.f14206w.j(objY)) {
                        iVar2.f14201a = null;
                        iVar2.f14202b = null;
                        iVar2.f14203c = null;
                    }
                } else if (th2 instanceof CancellationException) {
                    iVar2.f14204d = true;
                    x.k kVar3 = iVar2.f14202b;
                    if (kVar3 != null && kVar3.f14206w.cancel(true)) {
                        iVar2.f14201a = null;
                        iVar2.f14202b = null;
                        iVar2.f14203c = null;
                    }
                } else {
                    iVar2.f14204d = true;
                    x.k kVar4 = iVar2.f14202b;
                    if (kVar4 != null && kVar4.f14206w.k(th2)) {
                        iVar2.f14201a = null;
                        iVar2.f14202b = null;
                        iVar2.f14203c = null;
                    }
                }
                return rd.l.f11003a;
        }
    }
}
