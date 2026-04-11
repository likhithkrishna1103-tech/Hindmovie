package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f1499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f1500b;

    public final void a(s sVar, m mVar) {
        n nVarA = mVar.a();
        n nVar = this.f1499a;
        be.h.e(nVar, "state1");
        if (nVarA.compareTo(nVar) < 0) {
            nVar = nVarA;
        }
        this.f1499a = nVar;
        this.f1500b.a(sVar, mVar);
        this.f1499a = nVarA;
    }
}
