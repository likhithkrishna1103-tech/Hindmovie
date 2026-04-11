package e5;

import android.view.animation.Animation;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f4460b;

    public /* synthetic */ f(SwipeRefreshLayout swipeRefreshLayout, int i) {
        this.f4459a = i;
        this.f4460b = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        j jVar;
        switch (this.f4459a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SwipeRefreshLayout swipeRefreshLayout = this.f4460b;
                if (!swipeRefreshLayout.f1700w) {
                    swipeRefreshLayout.l();
                } else {
                    swipeRefreshLayout.T.setAlpha(255);
                    swipeRefreshLayout.T.start();
                    if (swipeRefreshLayout.f1692b0 && (jVar = swipeRefreshLayout.f1699v) != null) {
                        jVar.a();
                    }
                    swipeRefreshLayout.H = swipeRefreshLayout.N.getTop();
                }
                break;
            default:
                SwipeRefreshLayout swipeRefreshLayout2 = this.f4460b;
                g gVar = new g(swipeRefreshLayout2, 1);
                swipeRefreshLayout2.V = gVar;
                gVar.setDuration(150L);
                a aVar = swipeRefreshLayout2.N;
                aVar.f4428u = null;
                aVar.clearAnimation();
                swipeRefreshLayout2.N.startAnimation(swipeRefreshLayout2.V);
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f4459a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f4459a;
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
