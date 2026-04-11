package c;

import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements androidx.lifecycle.q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f0 f1953v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ m f1954w;

    public /* synthetic */ g(f0 f0Var, m mVar) {
        this.f1953v = f0Var;
        this.f1954w = mVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
        if (mVar == androidx.lifecycle.m.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = this.f1954w.getOnBackInvokedDispatcher();
            ge.i.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            this.f1953v.c(onBackInvokedDispatcher);
        }
    }
}
