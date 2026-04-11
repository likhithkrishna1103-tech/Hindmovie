package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k0 f1441u;

    public SavedStateHandleAttacher(k0 k0Var) {
        this.f1441u = k0Var;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar == m.ON_CREATE) {
            sVar.f().f(this);
            this.f1441u.b();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + mVar).toString());
        }
    }
}
