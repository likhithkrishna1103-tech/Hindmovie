package nb;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8970v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ p f8971w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ d8.j f8972x;

    public /* synthetic */ m(p pVar, d8.j jVar, int i) {
        this.f8970v = i;
        this.f8971w = pVar;
        this.f8972x = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8970v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f8971w.a(this.f8972x);
                break;
            default:
                this.f8971w.a(this.f8972x);
                break;
        }
    }
}
