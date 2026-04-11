package q0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r1 f10437a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f10438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f10439c;

    public e0(View view, p pVar) {
        this.f10438b = view;
        this.f10439c = pVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        r1 r1VarH = r1.h(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        p pVar = this.f10439c;
        if (i < 30) {
            f0.a(windowInsets, this.f10438b);
            if (r1VarH.equals(this.f10437a)) {
                return pVar.C(view, r1VarH).g();
            }
        }
        this.f10437a = r1VarH;
        r1 r1VarC = pVar.C(view, r1VarH);
        if (i >= 30) {
            return r1VarC.g();
        }
        WeakHashMap weakHashMap = o0.f10475a;
        d0.c(view);
        return r1VarC.g();
    }
}
