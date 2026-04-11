package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f2689x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f2690y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ x0 f2691z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(x0 x0Var, td.c cVar) {
        super(cVar);
        this.f2691z = x0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f2690y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f2691z.a(null, this);
    }
}
