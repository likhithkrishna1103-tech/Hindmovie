package o;

import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t2 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9365v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ SearchView f9366w;

    public /* synthetic */ t2(SearchView searchView, int i) {
        this.f9365v = i;
        this.f9366w = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9365v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f9366w.s();
                break;
            default:
                y0.a aVar = this.f9366w.f568n0;
                if (aVar instanceof e3) {
                    aVar.b(null);
                }
                break;
        }
    }
}
