package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public m0 f2672x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f2673y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ m0 f2674z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(m0 m0Var, td.c cVar) {
        super(cVar);
        this.f2674z = m0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f2673y = obj;
        this.A |= Integer.MIN_VALUE;
        return m0.a(this.f2674z, this);
    }
}
