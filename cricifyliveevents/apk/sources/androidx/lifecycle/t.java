package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f1195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f1196b;

    public final void a(s sVar, m mVar) {
        n nVarA = mVar.a();
        n nVar = this.f1195a;
        ge.i.e(nVar, "state1");
        if (nVarA.compareTo(nVar) < 0) {
            nVar = nVarA;
        }
        this.f1195a = nVar;
        this.f1196b.a(sVar, mVar);
        this.f1195a = nVarA;
    }
}
