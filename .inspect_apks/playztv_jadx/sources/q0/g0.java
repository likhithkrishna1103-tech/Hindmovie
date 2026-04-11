package q0;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g0 {
    public static r1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        r1 r1VarH = r1.h(null, rootWindowInsets);
        o1 o1Var = r1VarH.f10492a;
        o1Var.q(r1VarH);
        o1Var.d(view.getRootView());
        return r1VarH;
    }

    public static void b(View view, int i, int i10) {
        view.setScrollIndicators(i, i10);
    }
}
