package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends xd.c {
    public /* synthetic */ Object A;
    public final /* synthetic */ z B;
    public int C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14893y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h f14894z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(z zVar, xd.c cVar) {
        super(cVar);
        this.B = zVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.A = obj;
        this.C |= Integer.MIN_VALUE;
        return this.B.f(false, this);
    }
}
