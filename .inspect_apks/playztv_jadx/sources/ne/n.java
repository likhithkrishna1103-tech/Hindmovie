package ne;

import i4.o0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends oe.b implements k, b {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9020y = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9021x;

    public n(Object obj) {
        this._state$volatile = obj;
    }

    @Override // oe.b
    public final p a() {
        return new p();
    }

    @Override // oe.b
    public final p[] b() {
        return new p[2];
    }

    public final Object d() {
        o0 o0Var = oe.c.f9578b;
        Object obj = f9020y.get(this);
        if (obj == o0Var) {
            return null;
        }
        return obj;
    }

    public final void e(Object obj) {
        if (obj == null) {
            obj = oe.c.f9578b;
        }
        f(null, obj);
    }

    public final boolean f(Object obj, Object obj2) {
        int i;
        p[] pVarArr;
        o0 o0Var;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9020y;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !be.h.a(obj3, obj)) {
                return false;
            }
            if (be.h.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i10 = this.f9021x;
            if ((i10 & 1) != 0) {
                this.f9021x = i10 + 2;
                return true;
            }
            int i11 = i10 + 1;
            this.f9021x = i11;
            p[] pVarArr2 = this.f9574u;
            while (true) {
                p[] pVarArr3 = pVarArr2;
                if (pVarArr3 != null) {
                    for (p pVar : pVarArr3) {
                        if (pVar != null) {
                            AtomicReference atomicReference = pVar.f9024a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (o0Var = o.f9023b)) {
                                    o0 o0Var2 = o.f9022a;
                                    if (obj4 != o0Var2) {
                                        while (!atomicReference.compareAndSet(obj4, o0Var2)) {
                                            if (atomicReference.get() != obj4) {
                                                break;
                                            }
                                        }
                                        ((ke.g) obj4).g(nd.k.f8990a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj4, o0Var)) {
                                        if (atomicReference.get() != obj4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i = this.f9021x;
                    if (i == i11) {
                        this.f9021x = i11 + 1;
                        return true;
                    }
                    pVarArr = this.f9574u;
                }
                pVarArr2 = pVarArr;
                i11 = i;
            }
        }
    }

    @Override // ne.c
    public final Object j(Object obj, rd.c cVar) {
        e(obj);
        return nd.k.f8990a;
    }

    /* JADX WARN: Path cross not found for [B:82:0x014a, B:83:0x014b], limit reached: 97 */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d7 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:14:0x0037, B:52:0x00cf, B:54:0x00d7, B:57:0x00de, B:58:0x00e4, B:60:0x00e7, B:70:0x0108, B:73:0x0118, B:74:0x0134, B:80:0x0144, B:77:0x013b, B:79:0x0141, B:62:0x00ed, B:66:0x00f4, B:21:0x0052, B:24:0x005d, B:51:0x00bf), top: B:91:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e7 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:14:0x0037, B:52:0x00cf, B:54:0x00d7, B:57:0x00de, B:58:0x00e4, B:60:0x00e7, B:70:0x0108, B:73:0x0118, B:74:0x0134, B:80:0x0144, B:77:0x013b, B:79:0x0141, B:62:0x00ed, B:66:0x00f4, B:21:0x0052, B:24:0x005d, B:51:0x00bf), top: B:91:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0118 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:14:0x0037, B:52:0x00cf, B:54:0x00d7, B:57:0x00de, B:58:0x00e4, B:60:0x00e7, B:70:0x0108, B:73:0x0118, B:74:0x0134, B:80:0x0144, B:77:0x013b, B:79:0x0141, B:62:0x00ed, B:66:0x00f4, B:21:0x0052, B:24:0x005d, B:51:0x00bf), top: B:91:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x0117 -> B:52:0x00cf). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // ne.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(ne.c r18, td.c r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ne.n.o(ne.c, td.c):java.lang.Object");
    }
}
