package ec;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends td.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object f4665x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ m f4666y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4667z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(m mVar, td.c cVar) {
        super(cVar);
        this.f4666y = mVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f4665x = obj;
        this.f4667z |= Integer.MIN_VALUE;
        return this.f4666y.c(null, null, this);
    }
}
