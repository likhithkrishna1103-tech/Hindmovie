package d6;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.media3.ui.PlayerView;
import m4.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f3408v;

    public d(c cVar) {
        this.f3408v = cVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        PlayerView playerView = (PlayerView) this.f3408v.C.f9070b;
        q qVar = playerView.E;
        if (qVar == null || !qVar.h()) {
            playerView.g(playerView.f());
            return true;
        }
        playerView.b();
        return true;
    }
}
