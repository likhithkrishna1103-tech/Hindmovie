package t0;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {
    public static p1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        p1 p1VarH = p1.h(null, rootWindowInsets);
        m1 m1Var = p1VarH.f11791a;
        m1Var.q(p1VarH);
        m1Var.d(view.getRootView());
        return p1VarH;
    }

    public static void b(View view, int i, int i10) {
        view.setScrollIndicators(i, i10);
    }
}
