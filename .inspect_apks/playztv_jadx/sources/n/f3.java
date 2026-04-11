package n;

import androidx.appcompat.widget.Toolbar;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8388v;

    public /* synthetic */ f3(Toolbar toolbar, int i) {
        this.f8387u = i;
        this.f8388v = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8387u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h3 h3Var = this.f8388v.f935j0;
                m.m mVar = h3Var == null ? null : h3Var.f8397v;
                if (mVar != null) {
                    mVar.collapseActionView();
                }
                break;
            default:
                this.f8388v.n();
                break;
        }
    }
}
