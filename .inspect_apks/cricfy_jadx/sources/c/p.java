package c;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1985a = Color.argb(230, 255, 255, 255);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1986b = Color.argb(128, 27, 27, 27);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a.a f1987c;

    public static final void a(h.j jVar) {
        b6.a aVar = new b6.a(4);
        h0 h0Var = new h0(0, 0, aVar);
        b6.a aVar2 = new b6.a(4);
        h0 h0Var2 = new h0(f1985a, f1986b, aVar2);
        View decorView = jVar.getWindow().getDecorView();
        ge.i.d(decorView, "getDecorView(...)");
        Resources resources = decorView.getResources();
        ge.i.d(resources, "getResources(...)");
        boolean zBooleanValue = ((Boolean) aVar.a(resources)).booleanValue();
        Resources resources2 = decorView.getResources();
        ge.i.d(resources2, "getResources(...)");
        boolean zBooleanValue2 = ((Boolean) aVar2.a(resources2)).booleanValue();
        a.a vVar = f1987c;
        if (vVar == null) {
            int i = Build.VERSION.SDK_INT;
            vVar = i >= 35 ? new v() : i >= 30 ? new u() : i >= 29 ? new t() : i >= 28 ? new s() : i >= 26 ? new r() : new q();
            f1987c = vVar;
        }
        a.a aVar3 = vVar;
        Window window = jVar.getWindow();
        ge.i.d(window, "getWindow(...)");
        aVar3.o(h0Var, h0Var2, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = jVar.getWindow();
        ge.i.d(window2, "getWindow(...)");
        aVar3.c(window2);
    }
}
