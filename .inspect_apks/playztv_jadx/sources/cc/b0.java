package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends td.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object f2603x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2604y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ c0 f2605z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c0 c0Var, rd.c cVar) {
        super(cVar);
        this.f2605z = c0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f2603x = obj;
        this.f2604y |= Integer.MIN_VALUE;
        return this.f2605z.j(null, this);
    }
}
