package g4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b0 f5232v;

    public /* synthetic */ v(b0 b0Var, int i) {
        this.f5231u = i;
        this.f5232v = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5231u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = this.f5232v;
                z zVar = b0Var.f4974u;
                if (zVar != null) {
                    b0Var.f4973t.N0(zVar);
                }
                break;
            case 1:
                this.f5232v.getClass();
                break;
            case 2:
                b0.a(this.f5232v);
                break;
            default:
                this.f5232v.t();
                break;
        }
    }
}
