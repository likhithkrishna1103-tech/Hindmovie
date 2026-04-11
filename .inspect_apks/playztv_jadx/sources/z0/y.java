package z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y extends td.c {
    public /* synthetic */ Object A;
    public final /* synthetic */ a0 B;
    public int C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f14802x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f14803y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f14804z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(a0 a0Var, td.c cVar) {
        super(cVar);
        this.B = a0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.A = obj;
        this.C |= Integer.MIN_VALUE;
        return this.B.h(null, null, this);
    }
}
