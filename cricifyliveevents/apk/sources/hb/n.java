package hb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements hc.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f5901c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f5902a = f5901c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile hc.b f5903b;

    public n(hc.b bVar) {
        this.f5903b = bVar;
    }

    @Override // hc.b
    public final Object get() {
        Object obj;
        Object obj2 = this.f5902a;
        Object obj3 = f5901c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f5902a;
                if (obj == obj3) {
                    obj = this.f5903b.get();
                    this.f5902a = obj;
                    this.f5903b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
