package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ v2 f7541v;

    public /* synthetic */ x2(v2 v2Var, int i) {
        this.f7540u = i;
        this.f7541v = v2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7540u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v2 v2Var = this.f7541v;
                v2Var.f7462z = v2Var.E;
                break;
            default:
                this.f7541v.E = null;
                break;
        }
    }
}
