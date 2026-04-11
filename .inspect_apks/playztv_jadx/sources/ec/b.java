package ec;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends td.c {
    public final /* synthetic */ e A;
    public int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f4641x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public se.a f4642y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f4643z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, td.c cVar) {
        super(cVar);
        this.A = eVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f4643z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.d(this);
    }
}
