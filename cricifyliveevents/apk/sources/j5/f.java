package j5;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends Animation {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6618v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f6619w;

    public /* synthetic */ f(SwipeRefreshLayout swipeRefreshLayout, int i) {
        this.f6618v = i;
        this.f6619w = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        switch (this.f6618v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6619w.setAnimationProgress(f);
                break;
            case 1:
                this.f6619w.setAnimationProgress(1.0f - f);
                break;
            case 2:
                SwipeRefreshLayout swipeRefreshLayout = this.f6619w;
                int iAbs = swipeRefreshLayout.S - Math.abs(swipeRefreshLayout.R);
                swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.Q + ((int) ((iAbs - r1) * f))) - swipeRefreshLayout.O.getTop());
                d dVar = swipeRefreshLayout.U;
                float f10 = 1.0f - f;
                c cVar = dVar.f6611v;
                if (f10 != cVar.f6605p) {
                    cVar.f6605p = f10;
                }
                dVar.invalidateSelf();
                break;
            default:
                this.f6619w.k(f);
                break;
        }
    }
}
