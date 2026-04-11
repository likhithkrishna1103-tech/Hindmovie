package n;

import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8344u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f8345v;

    public /* synthetic */ b(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f8344u = i;
        this.f8345v = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8344u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f8345v;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.Q = actionBarOverlayLayout.f883x.animate().translationY(0.0f).setListener(actionBarOverlayLayout.R);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f8345v;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.Q = actionBarOverlayLayout2.f883x.animate().translationY(-actionBarOverlayLayout2.f883x.getHeight()).setListener(actionBarOverlayLayout2.R);
                break;
        }
    }
}
