package rd;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c, Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10996x = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "w");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile fe.a f10997v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile Object f10998w;

    @Override // rd.c
    public final Object getValue() {
        Object obj = this.f10998w;
        k kVar = k.f11002a;
        if (obj != kVar) {
            return obj;
        }
        fe.a aVar = this.f10997v;
        if (aVar != null) {
            Object objB = aVar.b();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10996x;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, kVar, objB)) {
                if (atomicReferenceFieldUpdater.get(this) != kVar) {
                }
            }
            this.f10997v = null;
            return objB;
        }
        return this.f10998w;
    }

    public final String toString() {
        return this.f10998w != k.f11002a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
