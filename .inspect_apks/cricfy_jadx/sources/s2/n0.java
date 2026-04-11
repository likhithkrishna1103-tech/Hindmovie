package s2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n0 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11279v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ s0 f11280w;

    public /* synthetic */ n0(s0 s0Var, int i) {
        this.f11279v = i;
        this.f11280w = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11279v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f11280w.f11313e0 = true;
                break;
            case 1:
                this.f11280w.z();
                break;
            default:
                s0 s0Var = this.f11280w;
                if (!s0Var.f11319k0) {
                    z zVar = s0Var.N;
                    zVar.getClass();
                    zVar.f(s0Var);
                }
                break;
        }
    }
}
