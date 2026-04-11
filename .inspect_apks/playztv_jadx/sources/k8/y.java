package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f7551v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d0 f7552w;

    public /* synthetic */ y(d0 d0Var, long j5, int i) {
        this.f7550u = i;
        this.f7551v = j5;
        this.f7552w = d0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7550u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((q) this.f7552w).x1(this.f7551v);
                break;
            default:
                v2 v2Var = (v2) this.f7552w;
                ((k1) v2Var.f2454v).k().t1(this.f7551v);
                v2Var.f7462z = null;
                break;
        }
    }
}
