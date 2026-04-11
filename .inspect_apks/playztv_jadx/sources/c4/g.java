package c4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2489u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f2490v;

    public g(int i, b bVar) {
        this.f2489u = i;
        this.f2490v = bVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f2489u, ((g) obj).f2489u);
    }
}
