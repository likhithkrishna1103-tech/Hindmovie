package we;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends h {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e f14162y;

    static {
        int i = k.f14170c;
        int i10 = k.f14171d;
        long j4 = k.f14172e;
        String str = k.f14168a;
        e eVar = new e();
        eVar.f14164x = new c(i, i10, j4, str);
        f14162y = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // pe.s
    public final String toString() {
        return "Dispatchers.Default";
    }
}
