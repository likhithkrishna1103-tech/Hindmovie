package c;

import android.os.Build;
import android.view.View;
import android.view.Window;
import t0.q1;
import t0.r1;
import t0.s1;
import t0.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class t extends s {
    @Override // c.r, a.a
    public void o(h0 h0Var, h0 h0Var2, Window window, View view, boolean z10, boolean z11) {
        ge.i.e(h0Var, "statusBarStyle");
        ge.i.e(h0Var2, "navigationBarStyle");
        ge.i.e(window, "window");
        ge.i.e(view, "view");
        w8.e.l(window, false);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(true);
        l4.a aVar = new l4.a(view);
        int i = Build.VERSION.SDK_INT;
        ab.b t1Var = i >= 35 ? new t1(window, aVar) : i >= 30 ? new s1(window, aVar) : i >= 26 ? new r1(window, aVar) : new q1(window, aVar);
        t1Var.A(!z10);
        t1Var.z(!z11);
    }
}
