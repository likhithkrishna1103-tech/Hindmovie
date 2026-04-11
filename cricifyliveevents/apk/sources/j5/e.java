package j5;

import android.view.animation.Animation;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f6617b;

    public /* synthetic */ e(SwipeRefreshLayout swipeRefreshLayout, int i) {
        this.f6616a = i;
        this.f6617b = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        i iVar;
        switch (this.f6616a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SwipeRefreshLayout swipeRefreshLayout = this.f6617b;
                if (!swipeRefreshLayout.f1484x) {
                    swipeRefreshLayout.l();
                } else {
                    swipeRefreshLayout.U.setAlpha(255);
                    swipeRefreshLayout.U.start();
                    if (swipeRefreshLayout.f1476c0 && (iVar = swipeRefreshLayout.f1483w) != null) {
                        iVar.d();
                    }
                    swipeRefreshLayout.I = swipeRefreshLayout.O.getTop();
                }
                break;
            default:
                SwipeRefreshLayout swipeRefreshLayout2 = this.f6617b;
                f fVar = new f(swipeRefreshLayout2, 1);
                swipeRefreshLayout2.W = fVar;
                fVar.setDuration(150L);
                a aVar = swipeRefreshLayout2.O;
                aVar.f6588v = null;
                aVar.clearAnimation();
                swipeRefreshLayout2.O.startAnimation(swipeRefreshLayout2.W);
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f6616a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f6616a;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }
}
