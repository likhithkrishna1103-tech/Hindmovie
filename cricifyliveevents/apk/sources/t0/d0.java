package t0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(g0.c.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static p1 b(View view, p1 p1Var, Rect rect) {
        WindowInsets windowInsetsG = p1Var.g();
        if (windowInsetsG != null) {
            return p1.h(view, view.computeSystemWindowInsets(windowInsetsG, rect));
        }
        rect.setEmpty();
        return p1Var;
    }

    public static ColorStateList c(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode d(View view) {
        return view.getBackgroundTintMode();
    }

    public static float e(View view) {
        return view.getElevation();
    }

    public static String f(View view) {
        return view.getTransitionName();
    }

    public static float g(View view) {
        return view.getZ();
    }

    public static boolean h(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void i(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void j(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void k(View view, float f) {
        view.setElevation(f);
    }

    public static void l(View view, o oVar) {
        c0 c0Var = oVar != null ? new c0(view, oVar) : null;
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(g0.c.tag_on_apply_window_listener, c0Var);
        }
        if (view.getTag(g0.c.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (c0Var != null) {
            view.setOnApplyWindowInsetsListener(c0Var);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(g0.c.tag_window_insets_animation_callback));
        }
    }

    public static void m(View view) {
        view.stopNestedScroll();
    }
}
