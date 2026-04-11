package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ u0 f1253u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c0 f1254v;

    public b0(c0 c0Var, u0 u0Var) {
        this.f1254v = c0Var;
        this.f1253u = u0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        u0 u0Var = this.f1253u;
        v vVar = u0Var.f1374c;
        u0Var.k();
        j.f((ViewGroup) vVar.f1378a0.getParent(), this.f1254v.f1257u.E()).e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
