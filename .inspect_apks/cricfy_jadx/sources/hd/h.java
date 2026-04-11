package hd;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5942v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ cd.e f5943w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ dd.e f5944x;

    public /* synthetic */ h(cd.e eVar, dd.e eVar2, int i) {
        this.f5942v = i;
        this.f5943w = eVar;
        this.f5944x = eVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5942v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5943w.h(this.f5944x);
                break;
            case 1:
                this.f5943w.b(this.f5944x);
                break;
            default:
                this.f5943w.e(this.f5944x);
                break;
        }
    }
}
