package t0;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f11795a;

    public q0(View view) {
        this.f11795a = new WeakReference(view);
    }

    public final void a(float f) {
        View view = (View) this.f11795a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void b() {
        View view = (View) this.f11795a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j4) {
        View view = (View) this.f11795a.get();
        if (view != null) {
            view.animate().setDuration(j4);
        }
    }

    public final void d(r0 r0Var) {
        View view = (View) this.f11795a.get();
        if (view != null) {
            if (r0Var != null) {
                view.animate().setListener(new fa.b(r0Var, view, 2));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f) {
        View view = (View) this.f11795a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}
