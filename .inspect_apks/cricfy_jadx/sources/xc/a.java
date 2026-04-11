package xc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object f14479x = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile b f14480v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile Object f14481w;

    public static c a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f14481w = f14479x;
        aVar.f14480v = bVar;
        return aVar;
    }

    @Override // qd.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f14481w;
        Object obj3 = f14479x;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f14481w;
                if (obj == obj3) {
                    obj = this.f14480v.get();
                    Object obj4 = this.f14481w;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f14481w = obj;
                    this.f14480v = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
