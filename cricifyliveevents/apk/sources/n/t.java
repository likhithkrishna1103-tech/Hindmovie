package n;

import android.widget.PopupWindow;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8578v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f8579w;

    public /* synthetic */ t(int i, Object obj) {
        this.f8578v = i;
        this.f8579w = obj;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        switch (this.f8578v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((u) this.f8579w).c();
                break;
            default:
                ((b6.f) this.f8579w).getClass();
                break;
        }
    }
}
