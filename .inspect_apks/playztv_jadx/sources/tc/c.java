package tc;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.media3.ui.PlayerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ b f12456u;

    public c(b bVar) {
        this.f12456u = bVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        PlayerView playerView = (PlayerView) this.f12456u.B.f1739d;
        if (playerView.c()) {
            playerView.b();
            return true;
        }
        playerView.h(playerView.g());
        return true;
    }
}
