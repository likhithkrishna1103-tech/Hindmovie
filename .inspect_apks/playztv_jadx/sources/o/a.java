package o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends q1.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f9025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n4.b f9026h = new n4.b(1);
    public final c f = new c();

    public static a Y() {
        if (f9025g != null) {
            return f9025g;
        }
        synchronized (a.class) {
            try {
                if (f9025g == null) {
                    f9025g = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f9025g;
    }
}
