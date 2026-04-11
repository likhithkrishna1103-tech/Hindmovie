package z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f14793x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f14794y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ a0 f14795z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(a0 a0Var, td.c cVar) {
        super(cVar);
        this.f14795z = a0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f14794y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f14795z.e(this);
    }
}
