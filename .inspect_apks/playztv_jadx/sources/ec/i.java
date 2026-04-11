package ec;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j f4658x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f4659y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ j f4660z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, td.c cVar) {
        super(cVar);
        this.f4660z = jVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f4659y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f4660z.b(this);
    }
}
