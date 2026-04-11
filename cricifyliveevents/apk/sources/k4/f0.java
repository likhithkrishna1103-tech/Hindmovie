package k4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6957v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l0 f6958w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h1 f6959x;

    public /* synthetic */ f0(l0 l0Var, h1 h1Var, int i) {
        this.f6957v = i;
        this.f6958w = l0Var;
        this.f6959x = h1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6957v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l0 l0Var = this.f6958w;
                l4.c0 c0Var = l0Var.f7063k;
                h1 h1Var = this.f6959x;
                c0Var.Y(l0Var.G(h1Var));
                l0Var.i.w(h1Var.u().a(17) ? h1Var.v0() : v1.f1.f12674a);
                break;
            default:
                l0 l0Var2 = this.f6958w;
                l0Var2.f7063k.Y(l0Var2.G(this.f6959x));
                break;
        }
    }
}
