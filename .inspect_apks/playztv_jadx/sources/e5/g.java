package e5;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends Animation {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4461u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f4462v;

    public /* synthetic */ g(SwipeRefreshLayout swipeRefreshLayout, int i) {
        this.f4461u = i;
        this.f4462v = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        switch (this.f4461u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f4462v.setAnimationProgress(f);
                break;
            case 1:
                this.f4462v.setAnimationProgress(1.0f - f);
                break;
            case 2:
                SwipeRefreshLayout swipeRefreshLayout = this.f4462v;
                int iAbs = swipeRefreshLayout.R - Math.abs(swipeRefreshLayout.Q);
                swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.P + ((int) ((iAbs - r1) * f))) - swipeRefreshLayout.N.getTop());
                e eVar = swipeRefreshLayout.T;
                float f4 = 1.0f - f;
                d dVar = eVar.f4453u;
                if (f4 != dVar.f4447p) {
                    dVar.f4447p = f4;
                }
                eVar.invalidateSelf();
                break;
            default:
                this.f4462v.k(f);
                break;
        }
    }
}
