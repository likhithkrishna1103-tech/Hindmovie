package c;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2193a = Color.argb(230, 255, 255, 255);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2194b = Color.argb(128, 27, 27, 27);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static q1.c f2195c;

    public static final void a(h.j jVar) {
        e0 e0Var = new e0(0);
        f0 f0Var = new f0(0, 0, e0Var);
        e0 e0Var2 = new e0(0);
        f0 f0Var2 = new f0(f2193a, f2194b, e0Var2);
        View decorView = jVar.getWindow().getDecorView();
        be.h.d(decorView, "getDecorView(...)");
        Resources resources = decorView.getResources();
        be.h.d(resources, "getResources(...)");
        boolean zBooleanValue = ((Boolean) e0Var.a(resources)).booleanValue();
        Resources resources2 = decorView.getResources();
        be.h.d(resources2, "getResources(...)");
        boolean zBooleanValue2 = ((Boolean) e0Var2.a(resources2)).booleanValue();
        q1.c uVar = f2195c;
        if (uVar == null) {
            int i = Build.VERSION.SDK_INT;
            uVar = i >= 35 ? new u() : i >= 30 ? new t() : i >= 29 ? new s() : i >= 28 ? new r() : i >= 26 ? new q() : new p();
            f2195c = uVar;
        }
        q1.c cVar = uVar;
        Window window = jVar.getWindow();
        be.h.d(window, "getWindow(...)");
        cVar.O(f0Var, f0Var2, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = jVar.getWindow();
        be.h.d(window2, "getWindow(...)");
        cVar.b(window2);
    }
}
