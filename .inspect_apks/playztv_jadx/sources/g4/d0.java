package g4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements l0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4991u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ m0 f4992v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f4993w;

    public /* synthetic */ d0(m0 m0Var, long j5, int i) {
        this.f4991u = i;
        this.f4992v = m0Var;
        this.f4993w = j5;
    }

    @Override // g4.l0
    public final void d(s sVar) {
        switch (this.f4991u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f4992v.f5115g.f4973t.p((int) this.f4993w);
                break;
            default:
                this.f4992v.f5115g.f4973t.F0(this.f4993w);
                break;
        }
    }
}
