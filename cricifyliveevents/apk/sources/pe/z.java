package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f10291a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [qe.c] */
    /* JADX WARN: Type inference failed for: r0v7, types: [pe.y] */
    /* JADX WARN: Type inference failed for: r0v8, types: [pe.b0] */
    /* JADX WARN: Type inference failed for: r0v9, types: [pe.y] */
    static {
        String property;
        ?? r02;
        int i = ue.t.f12487a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            we.e eVar = f0.f10232a;
            r02 = ue.n.f12481a;
            qe.c cVar = r02.f10809z;
            if (!(r02 != 0)) {
                r02 = y.E;
            }
        } else {
            r02 = y.E;
        }
        f10291a = r02;
    }
}
