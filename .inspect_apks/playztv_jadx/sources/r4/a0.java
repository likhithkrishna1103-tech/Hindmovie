package r4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends td.c {
    public final /* synthetic */ g0 A;
    public int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g0 f11424x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public kc.b f11425y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f11426z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(g0 g0Var, td.c cVar) {
        super(cVar);
        this.A = g0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f11426z = obj;
        this.B |= Integer.MIN_VALUE;
        return g0.b(this.A, this);
    }
}
