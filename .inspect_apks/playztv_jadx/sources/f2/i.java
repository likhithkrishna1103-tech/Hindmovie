package f2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4734u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ k f4735v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4736w;

    public /* synthetic */ i(k kVar, l lVar, int i) {
        this.f4734u = i;
        this.f4735v = kVar;
        this.f4736w = lVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [f2.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [f2.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [f2.l, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4734u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f4735v;
                this.f4736w.r(kVar.f4739a, kVar.f4740b);
                break;
            case 1:
                k kVar2 = this.f4735v;
                this.f4736w.Q(kVar2.f4739a, kVar2.f4740b);
                break;
            default:
                k kVar3 = this.f4735v;
                this.f4736w.D(kVar3.f4739a, kVar3.f4740b);
                break;
        }
    }
}
