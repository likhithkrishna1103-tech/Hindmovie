package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends xd.c {
    public final /* synthetic */ nc.p A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public nc.p f3251y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f3252z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(nc.p pVar, xd.c cVar) {
        super(cVar);
        this.A = pVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f3252z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.g(this);
    }
}
