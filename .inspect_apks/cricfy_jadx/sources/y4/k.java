package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends xd.c {
    public /* synthetic */ Object A;
    public final /* synthetic */ n B;
    public int C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f14862y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public fe.l f14863z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(n nVar, xd.c cVar) {
        super(cVar);
        this.B = nVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.A = obj;
        this.C |= Integer.MIN_VALUE;
        return this.B.c(null, null, this);
    }
}
