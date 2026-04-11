package l5;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f7899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7901c;

    public /* synthetic */ s(w wVar, int i, int i10) {
        this.f7899a = wVar;
        this.f7900b = i;
        this.f7901c = i10;
    }

    @Override // l5.v
    public final void run() {
        w wVar = this.f7899a;
        j jVar = wVar.f7918u;
        int i = this.f7900b;
        int i10 = this.f7901c;
        if (jVar == null) {
            wVar.f7923z.add(new s(wVar, i, i10));
        } else {
            wVar.f7919v.i(i, i10 + 0.99f);
        }
    }
}
