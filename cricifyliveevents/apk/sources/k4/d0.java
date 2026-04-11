package k4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements k0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6940v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l0 f6941w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f6942x;

    public /* synthetic */ d0(l0 l0Var, long j4, int i) {
        this.f6940v = i;
        this.f6941w = l0Var;
        this.f6942x = j4;
    }

    @Override // k4.k0
    public final void d(s sVar) {
        switch (this.f6940v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6941w.f7060g.f6924t.m((int) this.f6942x);
                break;
            default:
                this.f6941w.f7060g.f6924t.F0(this.f6942x);
                break;
        }
    }
}
