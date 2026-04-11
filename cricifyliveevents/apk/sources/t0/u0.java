package t0;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends y0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PathInterpolator f11811e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final q1.a f = new q1.a(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DecelerateInterpolator f11812g = new DecelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AccelerateInterpolator f11813h = new AccelerateInterpolator(1.5f);

    public static void f(View view, z0 z0Var) {
        a7.a aVarK = k(view);
        if (aVarK != null) {
            aVarK.f1(z0Var);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), z0Var);
            }
        }
    }

    public static void g(View view, z0 z0Var, p1 p1Var, boolean z10) {
        a7.a aVarK = k(view);
        if (aVarK != null) {
            aVarK.f307w = p1Var;
            if (!z10) {
                aVarK.g1(z0Var);
                z10 = true;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), z0Var, p1Var, z10);
            }
        }
    }

    public static void h(View view, p1 p1Var, List list) {
        a7.a aVarK = k(view);
        if (aVarK != null) {
            aVarK.h1(p1Var, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                h(viewGroup.getChildAt(i), p1Var, list);
            }
        }
    }

    public static void i(View view, z0 z0Var, nb.w wVar) {
        a7.a aVarK = k(view);
        if (aVarK != null) {
            aVarK.i1(z0Var, wVar);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                i(viewGroup.getChildAt(i), z0Var, wVar);
            }
        }
    }

    public static WindowInsets j(View view, WindowInsets windowInsets) {
        return view.getTag(g0.c.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static a7.a k(View view) {
        Object tag = view.getTag(g0.c.tag_window_insets_animation_callback);
        if (tag instanceof t0) {
            return ((t0) tag).f11808a;
        }
        return null;
    }
}
