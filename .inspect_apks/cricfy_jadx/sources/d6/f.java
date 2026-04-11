package d6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f3412w;

    public /* synthetic */ f(k kVar, int i) {
        this.f3411v = i;
        this.f3412w = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3411v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3412w.f3427g.g0(0);
                break;
            default:
                k kVar = this.f3412w;
                if (kVar.f3441v) {
                    kVar.e();
                }
                break;
        }
    }
}
