package ob;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o8.h f9498a;

    public g(o8.h hVar) {
        this.f9498a = hVar;
    }

    @Override // ob.i
    public final boolean a(pb.a aVar) {
        int i = aVar.f10301b;
        if (i != 3 && i != 4 && i != 5) {
            return false;
        }
        this.f9498a.c(aVar.f10300a);
        return true;
    }

    @Override // ob.i
    public final boolean b(Exception exc) {
        return false;
    }
}
