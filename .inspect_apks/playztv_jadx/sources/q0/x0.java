package q0;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends a1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PathInterpolator f10512e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final k1.a f = new k1.a(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DecelerateInterpolator f10513g = new DecelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AccelerateInterpolator f10514h = new AccelerateInterpolator(1.5f);

    public static void f(View view, b1 b1Var) {
        c3.e eVarK = k(view);
        if (eVarK != null) {
            eVarK.f1(b1Var);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), b1Var);
            }
        }
    }

    public static void g(View view, b1 b1Var, r1 r1Var, boolean z2) {
        c3.e eVarK = k(view);
        if (eVarK != null) {
            eVarK.f2454v = r1Var;
            if (!z2) {
                eVarK.g1(b1Var);
                z2 = true;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), b1Var, r1Var, z2);
            }
        }
    }

    public static void h(View view, r1 r1Var, List list) {
        c3.e eVarK = k(view);
        if (eVarK != null) {
            eVarK.h1(r1Var, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                h(viewGroup.getChildAt(i), r1Var, list);
            }
        }
    }

    public static void i(View view, b1 b1Var, pb.c cVar) {
        c3.e eVarK = k(view);
        if (eVarK != null) {
            eVarK.i1(b1Var, cVar);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                i(viewGroup.getChildAt(i), b1Var, cVar);
            }
        }
    }

    public static WindowInsets j(View view, WindowInsets windowInsets) {
        return view.getTag(d0.c.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static c3.e k(View view) {
        Object tag = view.getTag(d0.c.tag_window_insets_animation_callback);
        if (tag instanceof w0) {
            return ((w0) tag).f10510a;
        }
        return null;
    }
}
