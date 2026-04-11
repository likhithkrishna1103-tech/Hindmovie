package se;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends te.b implements u, c, te.e {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11718z = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11719y;

    public x(Object obj) {
        this._state$volatile = obj;
    }

    @Override // te.b
    public final z a() {
        return new z();
    }

    @Override // te.b
    public final z[] b() {
        return new z[2];
    }

    public final Object d() {
        d5.a aVar = te.c.f12021b;
        Object obj = f11718z.get(this);
        if (obj == aVar) {
            return null;
        }
        return obj;
    }

    public final boolean e(Object obj, Object obj2) {
        int i;
        z[] zVarArr;
        d5.a aVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11718z;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !ge.i.a(obj3, obj)) {
                return false;
            }
            if (ge.i.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i10 = this.f11719y;
            if ((i10 & 1) != 0) {
                this.f11719y = i10 + 2;
                return true;
            }
            int i11 = i10 + 1;
            this.f11719y = i11;
            z[] zVarArr2 = this.f12017v;
            while (true) {
                z[] zVarArr3 = zVarArr2;
                if (zVarArr3 != null) {
                    for (z zVar : zVarArr3) {
                        if (zVar != null) {
                            AtomicReference atomicReference = zVar.f11722a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (aVar = y.f11721b)) {
                                    d5.a aVar2 = y.f11720a;
                                    if (obj4 != aVar2) {
                                        while (!atomicReference.compareAndSet(obj4, aVar2)) {
                                            if (atomicReference.get() != obj4) {
                                                break;
                                            }
                                        }
                                        ((pe.h) obj4).i(rd.l.f11003a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj4, aVar)) {
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
                    i = this.f11719y;
                    if (i == i11) {
                        this.f11719y = i11 + 1;
                        return true;
                    }
                    zVarArr = this.f12017v;
                }
                zVarArr2 = zVarArr;
                i11 = i;
            }
        }
    }

    @Override // se.d
    public final Object f(Object obj, vd.c cVar) {
        if (obj == null) {
            obj = te.c.f12021b;
        }
        e(null, obj);
        return rd.l.f11003a;
    }

    @Override // te.e
    public final c j(vd.h hVar, int i, re.a aVar) {
        return ((((i < 0 || i >= 2) && i != -2) || aVar != re.a.f11005w) && !((i == 0 || i == -3) && aVar == re.a.f11004v)) ? new b(this, hVar, i, aVar, 1) : this;
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
    @Override // se.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(se.d r18, xd.c r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.x.z(se.d, xd.c):java.lang.Object");
    }
}
