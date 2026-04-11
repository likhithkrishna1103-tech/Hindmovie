package y9;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ View f14565u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f14566v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g9.a f14567w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ ExpandableBehavior f14568x;

    public a(ExpandableBehavior expandableBehavior, View view, int i, g9.a aVar) {
        this.f14568x = expandableBehavior;
        this.f14565u = view;
        this.f14566v = i;
        this.f14567w = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.f14565u;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.f14568x;
        if (expandableBehavior.f3552u == this.f14566v) {
            Object obj = this.f14567w;
            expandableBehavior.w((View) obj, view, ((FloatingActionButton) obj).I.f5331a, false);
        }
        return false;
    }
}
