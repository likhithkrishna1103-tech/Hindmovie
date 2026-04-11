package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a3 extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7075e;
    public final /* synthetic */ z2 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a3(z2 z2Var, k1 k1Var, int i) {
        super(k1Var);
        this.f7075e = i;
        this.f = z2Var;
    }

    @Override // k8.n
    public final void c() {
        switch (this.f7075e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z2 z2Var = this.f;
                z2Var.p1();
                if (z2Var.D1()) {
                    z2Var.g().I.d("Inactivity, disconnecting from the service");
                    z2Var.C1();
                }
                break;
            default:
                this.f.g().D.d("Tasks have been queued for a long time");
                break;
        }
    }
}
