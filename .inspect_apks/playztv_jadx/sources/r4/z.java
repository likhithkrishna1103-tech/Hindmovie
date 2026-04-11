package r4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f11515x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f11516y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ g0 f11517z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(g0 g0Var, td.c cVar) {
        super(cVar);
        this.f11517z = g0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f11516y = obj;
        this.A |= Integer.MIN_VALUE;
        return g0.a(this.f11517z, null, this);
    }
}
