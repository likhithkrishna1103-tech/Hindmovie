package e5;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends Animation {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4463u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4464v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f4465w;

    public h(SwipeRefreshLayout swipeRefreshLayout, int i, int i10) {
        this.f4465w = swipeRefreshLayout;
        this.f4463u = i;
        this.f4464v = i10;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        this.f4465w.T.setAlpha((int) (((this.f4464v - r0) * f) + this.f4463u));
    }
}
