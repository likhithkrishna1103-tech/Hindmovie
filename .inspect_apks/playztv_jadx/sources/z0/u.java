package z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f14790x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f14791y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ a0 f14792z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(a0 a0Var, td.c cVar) {
        super(cVar);
        this.f14792z = a0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f14791y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f14792z.d(this);
    }
}
