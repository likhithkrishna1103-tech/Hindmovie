package n;

import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8519u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ SearchView f8520v;

    public /* synthetic */ r2(SearchView searchView, int i) {
        this.f8519u = i;
        this.f8520v = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8519u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f8520v.s();
                break;
            default:
                v0.a aVar = this.f8520v.f910m0;
                if (aVar instanceof a3) {
                    aVar.b(null);
                }
                break;
        }
    }
}
