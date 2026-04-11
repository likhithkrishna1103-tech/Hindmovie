package o;

import androidx.appcompat.widget.Toolbar;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9244v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Toolbar f9245w;

    public /* synthetic */ i3(Toolbar toolbar, int i) {
        this.f9244v = i;
        this.f9245w = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9244v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k3 k3Var = this.f9245w.f612k0;
                n.m mVar = k3Var == null ? null : k3Var.f9257w;
                if (mVar != null) {
                    mVar.collapseActionView();
                }
                break;
            default:
                this.f9245w.m();
                break;
        }
    }
}
