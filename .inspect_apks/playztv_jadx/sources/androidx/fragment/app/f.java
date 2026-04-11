package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z0 f1269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f1272d;

    public f(z0 z0Var, ViewGroup viewGroup, View view, g gVar) {
        this.f1269a = z0Var;
        this.f1270b = viewGroup;
        this.f1271c = view;
        this.f1272d = gVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f1270b.post(new e(0, this));
        if (n0.G(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f1269a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        if (n0.G(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f1269a + " has reached onAnimationStart.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
