package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1.g f9243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nc.c f9244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a7.b f9245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k8.a0 f9246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9247e;

    public w0(v1.g gVar, w2.m mVar) {
        nc.c cVar = new nc.c(2, mVar);
        a7.b bVar = new a7.b(18);
        k8.a0 a0Var = new k8.a0(25);
        this.f9243a = gVar;
        this.f9244b = cVar;
        this.f9245c = bVar;
        this.f9246d = a0Var;
        this.f9247e = 1048576;
    }

    @Override // o2.c0
    public final a c(p1.g0 g0Var) {
        g0Var.f9757b.getClass();
        return new x0(g0Var, this.f9243a, this.f9244b, this.f9245c.b(g0Var), this.f9246d, this.f9247e, null);
    }

    @Override // o2.c0
    public final c0 b() {
        return this;
    }

    @Override // o2.c0
    public final c0 a(boolean z2) {
        return this;
    }

    @Override // o2.c0
    public final c0 d(k8.b0 b0Var) {
        return this;
    }
}
