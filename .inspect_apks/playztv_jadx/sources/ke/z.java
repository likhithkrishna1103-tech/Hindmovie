package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f7749a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [le.d] */
    /* JADX WARN: Type inference failed for: r0v7, types: [ke.y] */
    /* JADX WARN: Type inference failed for: r0v8, types: [ke.b0] */
    /* JADX WARN: Type inference failed for: r0v9, types: [ke.y] */
    static {
        String property;
        ?? r02;
        int i = pe.t.f10401a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            re.e eVar = f0.f7690a;
            r02 = pe.n.f10395a;
            le.d dVar = r02.f8161y;
            if (!(r02 != 0)) {
                r02 = y.D;
            }
        } else {
            r02 = y.D;
        }
        f7749a = r02;
    }
}
