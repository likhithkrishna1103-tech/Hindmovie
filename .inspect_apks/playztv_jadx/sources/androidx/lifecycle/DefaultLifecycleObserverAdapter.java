package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f1435u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f1436v;

    public DefaultLifecycleObserverAdapter(e eVar, q qVar) {
        this.f1435u = eVar;
        this.f1436v = qVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        int i = f.f1458a[mVar.ordinal()];
        if (i == 3) {
            this.f1435u.d();
        } else if (i == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        q qVar = this.f1436v;
        if (qVar != null) {
            qVar.a(sVar, mVar);
        }
    }
}
