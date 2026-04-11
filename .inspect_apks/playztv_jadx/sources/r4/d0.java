package r4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends td.c {
    public int A;
    public int B;
    public /* synthetic */ Object C;
    public final /* synthetic */ g0 D;
    public int E;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public l f11434x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f11435y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String[] f11436z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(g0 g0Var, td.c cVar) {
        super(cVar);
        this.D = g0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.C = obj;
        this.E |= Integer.MIN_VALUE;
        return g0.d(this.D, null, 0, this);
    }
}
