package z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x extends td.c {
    public final /* synthetic */ a0 A;
    public int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f14799x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f14800y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f14801z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a0 a0Var, td.c cVar) {
        super(cVar);
        this.A = a0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f14801z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.g(this);
    }
}
