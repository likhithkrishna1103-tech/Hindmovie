package ob;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f9496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.h f9497b;

    public f(j jVar, o8.h hVar) {
        this.f9496a = jVar;
        this.f9497b = hVar;
    }

    @Override // ob.i
    public final boolean a(pb.a aVar) {
        if (aVar.f10301b != 4 || this.f9496a.a(aVar)) {
            return false;
        }
        String str = aVar.f10302c;
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.f9497b.a(new a(aVar.f10304e, aVar.f, str));
        return true;
    }

    @Override // ob.i
    public final boolean b(Exception exc) {
        this.f9497b.b(exc);
        return true;
    }
}
