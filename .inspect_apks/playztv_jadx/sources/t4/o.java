package t4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends td.c {
    public f A;
    public /* synthetic */ Object B;
    public final /* synthetic */ p C;
    public int D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public p f12145x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f12146y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ae.l f12147z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, td.c cVar) {
        super(cVar);
        this.C = pVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return this.C.a(null, null, this);
    }
}
