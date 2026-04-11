package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ z0 f1261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f1262e;

    public d(ViewGroup viewGroup, View view, boolean z2, z0 z0Var, g gVar) {
        this.f1258a = viewGroup;
        this.f1259b = view;
        this.f1260c = z2;
        this.f1261d = z0Var;
        this.f1262e = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f1258a;
        View view = this.f1259b;
        viewGroup.endViewTransition(view);
        boolean z2 = this.f1260c;
        z0 z0Var = this.f1261d;
        if (z2) {
            l4.a.a(view, z0Var.f1427a);
        }
        this.f1262e.d();
        if (n0.G(2)) {
            Log.v("FragmentManager", "Animator from operation " + z0Var + " has ended.");
        }
    }
}
