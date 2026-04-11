package c;

import android.os.Build;
import android.view.View;
import android.view.Window;
import q0.s1;
import q0.t1;
import q0.u1;
import q0.v1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends q1.c {
    @Override // q1.c
    public void O(f0 f0Var, f0 f0Var2, Window window, View view, boolean z2, boolean z10) {
        be.h.e(f0Var, "statusBarStyle");
        be.h.e(f0Var2, "navigationBarStyle");
        be.h.e(window, "window");
        be.h.e(view, "view");
        a.a.K(window, false);
        window.setStatusBarColor(z2 ? f0Var.f2165b : f0Var.f2164a);
        window.setNavigationBarColor(f0Var2.f2165b);
        q0.e eVar = new q0.e(view);
        int i = Build.VERSION.SDK_INT;
        (i >= 35 ? new v1(window, eVar) : i >= 30 ? new u1(window, eVar) : i >= 26 ? new t1(window, eVar) : new s1(window, eVar)).C(!z2);
    }
}
