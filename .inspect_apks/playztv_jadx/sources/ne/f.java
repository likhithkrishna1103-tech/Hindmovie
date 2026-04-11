package ne;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f9002x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f9003y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ g f9004z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, rd.c cVar) {
        super(cVar);
        this.f9004z = gVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f9003y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f9004z.j(null, this);
    }
}
