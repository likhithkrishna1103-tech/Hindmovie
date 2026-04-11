package ta;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12396u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ q f12397v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b7.s f12398w;

    public /* synthetic */ n(q qVar, b7.s sVar, int i) {
        this.f12396u = i;
        this.f12397v = qVar;
        this.f12398w = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12396u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f12397v.a(this.f12398w);
                break;
            default:
                this.f12397v.a(this.f12398w);
                break;
        }
    }
}
