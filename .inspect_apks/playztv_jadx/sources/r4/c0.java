package r4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends td.c {
    public String[] A;
    public int B;
    public int C;
    public int D;
    public /* synthetic */ Object E;
    public final /* synthetic */ g0 F;
    public int G;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g0 f11430x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l f11431y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f11432z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(g0 g0Var, td.c cVar) {
        super(cVar);
        this.F = g0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.E = obj;
        this.G |= Integer.MIN_VALUE;
        return g0.c(this.F, null, 0, this);
    }
}
