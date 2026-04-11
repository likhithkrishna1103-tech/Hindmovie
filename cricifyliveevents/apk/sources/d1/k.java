package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends xd.c {
    public Object A;
    public ge.p B;
    public h0 C;
    public /* synthetic */ Object D;
    public final /* synthetic */ l E;
    public int F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3256y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f3257z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, xd.c cVar) {
        super(cVar);
        this.E = lVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.D = obj;
        this.F |= Integer.MIN_VALUE;
        return this.E.a(null, this);
    }
}
