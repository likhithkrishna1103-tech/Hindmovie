package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends xd.c {
    public Object A;
    public q0 B;
    public /* synthetic */ Object C;
    public final /* synthetic */ o0 D;
    public int E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public o0 f3278y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f3279z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(o0 o0Var, xd.c cVar) {
        super(cVar);
        this.D = o0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.C = obj;
        this.E |= Integer.MIN_VALUE;
        return this.D.b(null, this);
    }
}
