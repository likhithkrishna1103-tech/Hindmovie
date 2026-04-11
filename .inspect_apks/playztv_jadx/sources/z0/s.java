package z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends td.c {
    public be.n A;
    public a0 B;
    public /* synthetic */ Object C;
    public final /* synthetic */ t D;
    public int E;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f14783x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f14784y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f14785z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, td.c cVar) {
        super(cVar);
        this.D = tVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.C = obj;
        this.E |= Integer.MIN_VALUE;
        return this.D.a(null, this);
    }
}
