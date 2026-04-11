package t0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p1 f11733a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f11735c;

    public c0(View view, o oVar) {
        this.f11734b = view;
        this.f11735c = oVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        p1 p1VarH = p1.h(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        o oVar = this.f11735c;
        if (i < 30) {
            d0.a(windowInsets, this.f11734b);
            if (p1VarH.equals(this.f11733a)) {
                return oVar.k(view, p1VarH).g();
            }
        }
        this.f11733a = p1VarH;
        p1 p1VarK = oVar.k(view, p1VarH);
        if (i >= 30) {
            return p1VarK.g();
        }
        WeakHashMap weakHashMap = m0.f11777a;
        b0.c(view);
        return p1VarK.g();
    }
}
