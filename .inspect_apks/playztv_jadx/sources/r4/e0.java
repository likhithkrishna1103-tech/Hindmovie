package r4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public kc.b f11438x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f11439y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ g0 f11440z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(g0 g0Var, td.c cVar) {
        super(cVar);
        this.f11440z = g0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f11439y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f11440z.f(this);
    }
}
