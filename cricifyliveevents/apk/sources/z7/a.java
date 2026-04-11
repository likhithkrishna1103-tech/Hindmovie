package z7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements qd.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object f15332x = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile b f15333v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile Object f15334w;

    public static qd.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f15334w = f15332x;
        aVar.f15333v = bVar;
        return aVar;
    }

    @Override // qd.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f15334w;
        Object obj3 = f15332x;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f15334w;
                if (obj == obj3) {
                    obj = this.f15333v.get();
                    Object obj4 = this.f15334w;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f15334w = obj;
                    this.f15333v = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
