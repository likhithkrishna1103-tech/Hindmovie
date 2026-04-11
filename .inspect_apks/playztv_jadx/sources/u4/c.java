package u4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends td.c {
    public final /* synthetic */ d A;
    public int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d f12764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public z4.a f12765y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f12766z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, td.c cVar) {
        super(cVar);
        this.A = dVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f12766z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.e(null, null, this);
    }
}
