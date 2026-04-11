package p2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends Exception {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f9935v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f9936w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final o f9937x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f9938y;

    public p(v1.p pVar, u uVar, boolean z10, int i) {
        this("Decoder init failed: [" + i + "], " + pVar, uVar, pVar.f12946n, z10, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i));
    }

    public p(String str, Throwable th, String str2, boolean z10, o oVar, String str3) {
        super(str, th);
        this.f9935v = str2;
        this.f9936w = z10;
        this.f9937x = oVar;
        this.f9938y = str3;
    }
}
