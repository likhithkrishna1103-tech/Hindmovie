package na;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements nb.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8905c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f8906a = f8905c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile nb.b f8907b;

    public n(nb.b bVar) {
        this.f8907b = bVar;
    }

    @Override // nb.b
    public final Object get() {
        Object obj;
        Object obj2 = this.f8906a;
        Object obj3 = f8905c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f8906a;
                if (obj == obj3) {
                    obj = this.f8907b.get();
                    this.f8906a = obj;
                    this.f8907b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
