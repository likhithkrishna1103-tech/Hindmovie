package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k0 f1139v;

    public SavedStateHandleAttacher(k0 k0Var) {
        this.f1139v = k0Var;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar == m.ON_CREATE) {
            sVar.f().f(this);
            this.f1139v.b();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + mVar).toString());
        }
    }
}
