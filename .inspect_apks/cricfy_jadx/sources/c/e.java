package c;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1945v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h.j f1946w;

    public /* synthetic */ e(h.j jVar, int i) {
        this.f1945v = i;
        this.f1946w = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1945v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m.g(this.f1946w);
                break;
            default:
                this.f1946w.invalidateOptionsMenu();
                break;
        }
    }
}
