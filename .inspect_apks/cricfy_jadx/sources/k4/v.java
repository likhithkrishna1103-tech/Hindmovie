package k4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7176v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b0 f7177w;

    public /* synthetic */ v(b0 b0Var, int i) {
        this.f7176v = i;
        this.f7177w = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7176v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = this.f7177w;
                z zVar = b0Var.f6925u;
                if (zVar != null) {
                    b0Var.f6924t.m0(zVar);
                }
                break;
            case 1:
                this.f7177w.getClass();
                break;
            case 2:
                b0.a(this.f7177w);
                break;
            default:
                this.f7177w.t();
                break;
        }
    }
}
