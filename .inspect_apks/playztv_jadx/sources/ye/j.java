package ye;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends be.i implements ae.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ue.f f14725v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ ue.l f14726w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ ue.a f14727x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ue.f fVar, ue.l lVar, ue.a aVar) {
        super(0);
        this.f14725v = fVar;
        this.f14726w = lVar;
        this.f14727x = aVar;
    }

    @Override // ae.a
    public final Object b() {
        com.bumptech.glide.c cVar = this.f14725v.f12957b;
        be.h.b(cVar);
        return cVar.e(this.f14727x.f12929h.f13011d, this.f14726w.a());
    }
}
