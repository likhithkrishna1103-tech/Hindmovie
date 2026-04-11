package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ u f1437u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ n.s f1438v;

    public LegacySavedStateHandleController$tryToAddRecreator$1(u uVar, n.s sVar) {
        this.f1437u = uVar;
        this.f1438v = sVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar == m.ON_START) {
            this.f1437u.f(this);
            this.f1438v.g();
        }
    }
}
