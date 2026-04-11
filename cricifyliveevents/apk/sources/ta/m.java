package ta;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements l, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final transient Object f11966v = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l f11967w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile transient boolean f11968x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public transient Object f11969y;

    public m(l lVar) {
        this.f11967w = lVar;
    }

    @Override // ta.l
    public final Object get() {
        if (!this.f11968x) {
            synchronized (this.f11966v) {
                try {
                    if (!this.f11968x) {
                        Object obj = this.f11967w.get();
                        this.f11969y = obj;
                        this.f11968x = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f11969y;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (this.f11968x) {
            obj = "<supplier that returned " + this.f11969y + ">";
        } else {
            obj = this.f11967w;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
