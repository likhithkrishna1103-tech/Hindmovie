package i2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends Exception {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f6099v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f6100w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final v1.p f6101x;

    /* JADX WARN: Illegal instructions before constructor call */
    public o(int i, int i10, int i11, int i12, int i13, v1.p pVar, boolean z10, RuntimeException runtimeException) {
        StringBuilder sbR = q4.a.r(i, i10, "AudioTrack init failed ", " Config(", ", ");
        sbR.append(i11);
        sbR.append(", ");
        sbR.append(i12);
        sbR.append(", ");
        sbR.append(i13);
        sbR.append(") ");
        sbR.append(pVar);
        sbR.append(z10 ? " (recoverable)" : "");
        super(sbR.toString(), runtimeException);
        this.f6099v = i;
        this.f6100w = z10;
        this.f6101x = pVar;
    }
}
