package g2;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4672e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4674h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4677l;

    public final String toString() {
        int i = this.f4668a;
        int i10 = this.f4669b;
        int i11 = this.f4670c;
        int i12 = this.f4671d;
        int i13 = this.f4672e;
        int i14 = this.f;
        int i15 = this.f4673g;
        int i16 = this.f4674h;
        int i17 = this.i;
        int i18 = this.f4675j;
        long j4 = this.f4676k;
        int i19 = this.f4677l;
        int i20 = y1.a0.f14551a;
        Locale locale = Locale.US;
        StringBuilder sbR = q4.a.r(i, i10, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", "\n queuedInputBuffers=");
        sbR.append(i11);
        sbR.append("\n skippedInputBuffers=");
        sbR.append(i12);
        sbR.append("\n renderedOutputBuffers=");
        sbR.append(i13);
        sbR.append("\n skippedOutputBuffers=");
        sbR.append(i14);
        sbR.append("\n droppedBuffers=");
        sbR.append(i15);
        sbR.append("\n droppedInputBuffers=");
        sbR.append(i16);
        sbR.append("\n maxConsecutiveDroppedBuffers=");
        sbR.append(i17);
        sbR.append("\n droppedToKeyframeEvents=");
        sbR.append(i18);
        sbR.append("\n totalVideoFrameProcessingOffsetUs=");
        sbR.append(j4);
        sbR.append("\n videoFrameProcessingOffsetCount=");
        sbR.append(i19);
        sbR.append("\n}");
        return sbR.toString();
    }
}
