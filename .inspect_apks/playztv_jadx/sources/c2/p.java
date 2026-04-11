package c2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends Exception {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2366u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f2367v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p1.q f2368w;

    public p(int i, p1.q qVar, boolean z2) {
        super(e6.j.l("AudioTrack write failed: ", i));
        this.f2367v = z2;
        this.f2366u = i;
        this.f2368w = qVar;
    }
}
