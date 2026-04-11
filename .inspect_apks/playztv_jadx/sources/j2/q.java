package j2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends Exception {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f6720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f6721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p f6722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f6723x;

    public q(p1.q qVar, v vVar, boolean z2, int i) {
        this("Decoder init failed: [" + i + "], " + qVar, vVar, qVar.f10023n, z2, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i));
    }

    public q(String str, Throwable th, String str2, boolean z2, p pVar, String str3) {
        super(str, th);
        this.f6720u = str2;
        this.f6721v = z2;
        this.f6722w = pVar;
        this.f6723x = str3;
    }
}
