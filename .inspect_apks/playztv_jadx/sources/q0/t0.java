package q0;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10499a;

    public t0(View view) {
        this.f10499a = new WeakReference(view);
    }

    public final void a(float f) {
        View view = (View) this.f10499a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void b() {
        View view = (View) this.f10499a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j5) {
        View view = (View) this.f10499a.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
    }

    public final void d(u0 u0Var) {
        View view = (View) this.f10499a.get();
        if (view != null) {
            if (u0Var != null) {
                view.animate().setListener(new g5.k(u0Var, view, 2));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f) {
        View view = (View) this.f10499a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}
