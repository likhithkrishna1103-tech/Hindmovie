package n;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ l9.o f8440u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ n0 f8441v;

    public m0(n0 n0Var, l9.o oVar) {
        this.f8441v = n0Var;
        this.f8440u = oVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f8441v.f8457b0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f8440u);
        }
    }
}
