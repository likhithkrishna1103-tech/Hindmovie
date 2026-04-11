package re;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends h {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e f11593x;

    static {
        int i = k.f11601c;
        int i10 = k.f11602d;
        long j5 = k.f11603e;
        String str = k.f11599a;
        e eVar = new e();
        eVar.f11595w = new c(i, i10, j5, str);
        f11593x = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // ke.r
    public final String toString() {
        return "Dispatchers.Default";
    }
}
