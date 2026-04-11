package h1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5628b;

    public e(long j5, long j8) {
        if (j8 == 0) {
            this.f5627a = 0L;
            this.f5628b = 1L;
        } else {
            this.f5627a = j5;
            this.f5628b = j8;
        }
    }

    public final String toString() {
        return this.f5627a + "/" + this.f5628b;
    }
}
