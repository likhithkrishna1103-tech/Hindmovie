package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f10240a = new ThreadLocal();

    public static o0 a() {
        ThreadLocal threadLocal = f10240a;
        o0 o0Var = (o0) threadLocal.get();
        if (o0Var != null) {
            return o0Var;
        }
        d dVar = new d(Thread.currentThread());
        threadLocal.set(dVar);
        return dVar;
    }
}
