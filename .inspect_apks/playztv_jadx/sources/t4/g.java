package t4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public h f12120x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f12121y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ h f12122z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, td.c cVar) {
        super(cVar);
        this.f12122z = hVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f12121y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f12122z.a(this);
    }
}
