package c;

import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements androidx.lifecycle.q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ c0 f2166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ l f2167v;

    public /* synthetic */ g(c0 c0Var, l lVar) {
        this.f2166u = c0Var;
        this.f2167v = lVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
        if (mVar == androidx.lifecycle.m.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = this.f2167v.getOnBackInvokedDispatcher();
            be.h.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            this.f2166u.b(onBackInvokedDispatcher);
        }
    }
}
