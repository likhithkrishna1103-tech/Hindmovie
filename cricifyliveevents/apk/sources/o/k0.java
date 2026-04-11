package o;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ fa.e f9254v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l0 f9255w;

    public k0(l0 l0Var, fa.e eVar) {
        this.f9255w = l0Var;
        this.f9254v = eVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f9255w.f9261c0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f9254v);
        }
    }
}
