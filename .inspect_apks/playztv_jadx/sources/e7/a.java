package e7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements md.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Object f4582w = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile b f4583u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile Object f4584v;

    public static md.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f4584v = f4582w;
        aVar.f4583u = bVar;
        return aVar;
    }

    @Override // md.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f4584v;
        Object obj3 = f4582w;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f4584v;
                if (obj == obj3) {
                    obj = this.f4583u.get();
                    Object obj4 = this.f4584v;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f4584v = obj;
                    this.f4583u = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
