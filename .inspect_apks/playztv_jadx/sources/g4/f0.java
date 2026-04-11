package g4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5002u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ m0 f5003v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ j1 f5004w;

    public /* synthetic */ f0(m0 m0Var, j1 j1Var, int i) {
        this.f5002u = i;
        this.f5003v = m0Var;
        this.f5004w = j1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5002u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m0 m0Var = this.f5003v;
                h4.z zVar = m0Var.f5118k;
                j1 j1Var = this.f5004w;
                zVar.k0(m0Var.G(j1Var));
                m0Var.i.w(j1Var.w().a(17) ? j1Var.w0() : p1.f1.f9741a);
                break;
            default:
                m0 m0Var2 = this.f5003v;
                m0Var2.f5118k.k0(m0Var2.G(this.f5004w));
                break;
        }
    }
}
