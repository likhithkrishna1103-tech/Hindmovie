package c2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends Exception {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2363u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f2364v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p1.q f2365w;

    /* JADX WARN: Illegal instructions before constructor call */
    public m(int i, int i10, int i11, int i12, int i13, p1.q qVar, boolean z2, RuntimeException runtimeException) {
        StringBuilder sbP = l4.a.p(i, i10, "AudioTrack init failed ", " Config(", ", ");
        sbP.append(i11);
        sbP.append(", ");
        sbP.append(i12);
        sbP.append(", ");
        sbP.append(i13);
        sbP.append(") ");
        sbP.append(qVar);
        sbP.append(z2 ? " (recoverable)" : "");
        super(sbP.toString(), runtimeException);
        this.f2363u = i;
        this.f2364v = z2;
        this.f2365w = qVar;
    }
}
