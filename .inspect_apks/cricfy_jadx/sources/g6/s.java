package g6;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f5130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5132c;

    public /* synthetic */ s(w wVar, int i, int i10) {
        this.f5130a = wVar;
        this.f5131b = i;
        this.f5132c = i10;
    }

    @Override // g6.v
    public final void run() {
        w wVar = this.f5130a;
        i iVar = wVar.f5152v;
        int i = this.f5131b;
        int i10 = this.f5132c;
        if (iVar == null) {
            wVar.A.add(new s(wVar, i, i10));
        } else {
            wVar.f5153w.i(i, i10 + 0.99f);
        }
    }
}
