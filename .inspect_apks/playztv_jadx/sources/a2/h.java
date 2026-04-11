package a2;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f248e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f250h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f253l;

    public final String toString() {
        int i = this.f244a;
        int i10 = this.f245b;
        int i11 = this.f246c;
        int i12 = this.f247d;
        int i13 = this.f248e;
        int i14 = this.f;
        int i15 = this.f249g;
        int i16 = this.f250h;
        int i17 = this.i;
        int i18 = this.f251j;
        long j5 = this.f252k;
        int i19 = this.f253l;
        int i20 = s1.b0.f11647a;
        Locale locale = Locale.US;
        StringBuilder sbP = l4.a.p(i, i10, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", "\n queuedInputBuffers=");
        sbP.append(i11);
        sbP.append("\n skippedInputBuffers=");
        sbP.append(i12);
        sbP.append("\n renderedOutputBuffers=");
        sbP.append(i13);
        sbP.append("\n skippedOutputBuffers=");
        sbP.append(i14);
        sbP.append("\n droppedBuffers=");
        sbP.append(i15);
        sbP.append("\n droppedInputBuffers=");
        sbP.append(i16);
        sbP.append("\n maxConsecutiveDroppedBuffers=");
        sbP.append(i17);
        sbP.append("\n droppedToKeyframeEvents=");
        sbP.append(i18);
        sbP.append("\n totalVideoFrameProcessingOffsetUs=");
        sbP.append(j5);
        sbP.append("\n videoFrameProcessingOffsetCount=");
        sbP.append(i19);
        sbP.append("\n}");
        return sbP.toString();
    }
}
