package z9;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements l, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final transient Object f14917u = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l f14918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile transient boolean f14919w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient Object f14920x;

    public m(l lVar) {
        this.f14918v = lVar;
    }

    @Override // z9.l
    public final Object get() {
        if (!this.f14919w) {
            synchronized (this.f14917u) {
                try {
                    if (!this.f14919w) {
                        Object obj = this.f14918v.get();
                        this.f14920x = obj;
                        this.f14919w = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f14920x;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Suppliers.memoize(");
        if (this.f14919w) {
            obj = "<supplier that returned " + this.f14920x + ">";
        } else {
            obj = this.f14918v;
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }
}
