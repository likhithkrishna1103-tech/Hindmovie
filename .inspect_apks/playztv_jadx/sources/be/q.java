package be;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static void a(int i, Object obj) {
        if (obj == null || b(i, obj)) {
            return;
        }
        c(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean b(int i, Object obj) {
        if (obj instanceof nd.a) {
            if ((obj instanceof f ? ((f) obj).d() : obj instanceof ae.a ? 0 : obj instanceof ae.l ? 1 : obj instanceof ae.p ? 2 : obj instanceof ae.q ? 3 : obj instanceof a5.a ? 4 : -1) == i) {
                return true;
            }
        }
        return false;
    }

    public static void c(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        h.g(classCastException, q.class.getName());
        throw classCastException;
    }
}
