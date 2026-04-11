package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends xd.c {
    public ge.p A;
    public /* synthetic */ Object B;
    public final /* synthetic */ s C;
    public int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f14878y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public fe.a f14879z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, xd.c cVar) {
        super(cVar);
        this.C = sVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return this.C.b(0L, null, this);
    }
}
