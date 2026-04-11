package pe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class q extends ke.a implements td.d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final td.c f10397x;

    public q(rd.h hVar, td.c cVar) {
        super(hVar, true);
        this.f10397x = cVar;
    }

    @Override // ke.d1
    public final boolean E() {
        return true;
    }

    @Override // td.d
    public final td.d c() {
        td.c cVar = this.f10397x;
        if (l4.a.v(cVar)) {
            return cVar;
        }
        return null;
    }

    @Override // ke.d1
    public void h(Object obj) {
        a.h(ke.x.k(obj), a.a.w(this.f10397x));
    }

    @Override // ke.d1
    public void i(Object obj) {
        this.f10397x.g(ke.x.k(obj));
    }
}
