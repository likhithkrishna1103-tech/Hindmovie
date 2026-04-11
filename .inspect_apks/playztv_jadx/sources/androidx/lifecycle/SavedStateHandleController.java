package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f1442u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h0 f1443v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1444w;

    public SavedStateHandleController(String str, h0 h0Var) {
        this.f1442u = str;
        this.f1443v = h0Var;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar == m.ON_DESTROY) {
            this.f1444w = false;
            sVar.f().f(this);
        }
    }

    public final void b(u uVar, n.s sVar) {
        be.h.e(sVar, "registry");
        be.h.e(uVar, "lifecycle");
        if (this.f1444w) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f1444w = true;
        uVar.a(this);
        sVar.f(this.f1442u, this.f1443v.f1465e);
    }
}
