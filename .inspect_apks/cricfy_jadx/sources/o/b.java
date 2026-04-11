package o;

import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9181v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f9182w;

    public /* synthetic */ b(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f9181v = i;
        this.f9182w = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9181v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f9182w;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.R = actionBarOverlayLayout.f541y.animate().translationY(0.0f).setListener(actionBarOverlayLayout.S);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f9182w;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.R = actionBarOverlayLayout2.f541y.animate().translationY(-actionBarOverlayLayout2.f541y.getHeight()).setListener(actionBarOverlayLayout2.S);
                break;
        }
    }
}
