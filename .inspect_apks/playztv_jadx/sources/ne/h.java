package ne;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends td.c {
    public final /* synthetic */ i A;
    public int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public i f9007x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f9008y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f9009z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, rd.c cVar) {
        super(cVar);
        this.A = iVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f9009z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.j(null, this);
    }
}
