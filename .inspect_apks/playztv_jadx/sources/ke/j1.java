package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f7701a = new ThreadLocal();

    public static o0 a() {
        ThreadLocal threadLocal = f7701a;
        o0 o0Var = (o0) threadLocal.get();
        if (o0Var != null) {
            return o0Var;
        }
        d dVar = new d(Thread.currentThread());
        threadLocal.set(dVar);
        return dVar;
    }
}
