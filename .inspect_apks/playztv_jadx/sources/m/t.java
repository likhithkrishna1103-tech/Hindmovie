package m;

import android.widget.PopupWindow;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8264u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f8265v;

    public /* synthetic */ t(int i, Object obj) {
        this.f8264u = i;
        this.f8265v = obj;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        switch (this.f8264u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((u) this.f8265v).c();
                break;
            default:
                ((ub.o) this.f8265v).getClass();
                break;
        }
    }
}
