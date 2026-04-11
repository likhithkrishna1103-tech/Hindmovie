package z9;

import a2.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements l {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final t f14921x = new t(4);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f14922u = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile l f14923v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f14924w;

    public n(l lVar) {
        this.f14923v = lVar;
    }

    @Override // z9.l
    public final Object get() {
        l lVar = this.f14923v;
        t tVar = f14921x;
        if (lVar != tVar) {
            synchronized (this.f14922u) {
                try {
                    if (this.f14923v != tVar) {
                        Object obj = this.f14923v.get();
                        this.f14924w = obj;
                        this.f14923v = tVar;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f14924w;
    }

    public final String toString() {
        Object obj = this.f14923v;
        StringBuilder sb2 = new StringBuilder("Suppliers.memoize(");
        if (obj == f14921x) {
            obj = "<supplier that returned " + this.f14924w + ">";
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }
}
