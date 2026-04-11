package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f1140v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h0 f1141w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1142x;

    public SavedStateHandleController(String str, h0 h0Var) {
        this.f1140v = str;
        this.f1141w = h0Var;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar == m.ON_DESTROY) {
            this.f1142x = false;
            sVar.f().f(this);
        }
    }

    public final void b(u uVar, b5.e eVar) {
        ge.i.e(eVar, "registry");
        ge.i.e(uVar, "lifecycle");
        if (this.f1142x) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f1142x = true;
        uVar.a(this);
        eVar.f(this.f1140v, this.f1141w.f1162e);
    }
}
