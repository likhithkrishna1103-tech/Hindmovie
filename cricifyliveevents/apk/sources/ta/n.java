package ta;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements l {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b2.i f11970y = new b2.i(3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f11971v = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile l f11972w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f11973x;

    public n(l lVar) {
        this.f11972w = lVar;
    }

    @Override // ta.l
    public final Object get() {
        l lVar = this.f11972w;
        b2.i iVar = f11970y;
        if (lVar != iVar) {
            synchronized (this.f11971v) {
                try {
                    if (this.f11972w != iVar) {
                        Object obj = this.f11972w.get();
                        this.f11973x = obj;
                        this.f11972w = iVar;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f11973x;
    }

    public final String toString() {
        Object obj = this.f11972w;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == f11970y) {
            obj = "<supplier that returned " + this.f11973x + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
