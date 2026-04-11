package ff;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4575a;

    static {
        Object objE;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            ge.i.d(property, "getProperty(...)");
            objE = ne.o.a0(property);
        } catch (Throwable th) {
            objE = com.bumptech.glide.c.e(th);
        }
        if (objE instanceof rd.g) {
            objE = null;
        }
        Integer num = (Integer) objE;
        f4575a = num != null ? num.intValue() : 2097152;
    }
}
