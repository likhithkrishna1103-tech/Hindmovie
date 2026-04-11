package j5;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends Animation {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f6621w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f6622x;

    public g(SwipeRefreshLayout swipeRefreshLayout, int i, int i10) {
        this.f6622x = swipeRefreshLayout;
        this.f6620v = i;
        this.f6621w = i10;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        this.f6622x.U.setAlpha((int) (((this.f6621w - r0) * f) + this.f6620v));
    }
}
