package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7398u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f7399v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f7400w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f7401x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f7402y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ y0 f7403z;

    public r2(g2 g2Var, z1 z1Var, long j5, boolean z2, z1 z1Var2) {
        this.f7401x = z1Var;
        this.f7399v = j5;
        this.f7400w = z2;
        this.f7402y = z1Var2;
        this.f7403z = g2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7398u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g2 g2Var = (g2) this.f7403z;
                z1 z1Var = (z1) this.f7401x;
                g2Var.F1(z1Var);
                g2.H1((g2) this.f7403z, (z1) this.f7401x, this.f7399v, false, this.f7400w);
                g2.I1(g2Var, z1Var, (z1) this.f7402y);
                break;
            default:
                ((v2) this.f7403z).A1((w2) this.f7401x, (w2) this.f7402y, this.f7399v, this.f7400w, null);
                break;
        }
    }

    public r2(v2 v2Var, w2 w2Var, w2 w2Var2, long j5, boolean z2) {
        this.f7401x = w2Var;
        this.f7402y = w2Var2;
        this.f7399v = j5;
        this.f7400w = z2;
        this.f7403z = v2Var;
    }
}
