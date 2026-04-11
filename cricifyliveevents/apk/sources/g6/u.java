package g6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f5136b;

    public /* synthetic */ u(w wVar, int i) {
        this.f5135a = i;
        this.f5136b = wVar;
    }

    @Override // g6.v
    public final void run() {
        switch (this.f5135a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5136b.n();
                break;
            default:
                this.f5136b.l();
                break;
        }
    }
}
