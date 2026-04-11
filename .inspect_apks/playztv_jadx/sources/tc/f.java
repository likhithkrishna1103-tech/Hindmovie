package tc;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12461u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g f12462v;

    public /* synthetic */ f(g gVar, int i) {
        this.f12461u = i;
        this.f12462v = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12461u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f12462v.f12468g.g0(0);
                break;
            default:
                g gVar = this.f12462v;
                if (gVar.f12484x) {
                    gVar.g();
                }
                break;
        }
    }
}
