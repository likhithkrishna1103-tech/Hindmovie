package t3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f12079u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte[] f12080v;

    public g(long j5, byte[] bArr) {
        this.f12079u = j5;
        this.f12080v = bArr;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f12079u, ((g) obj).f12079u);
    }
}
