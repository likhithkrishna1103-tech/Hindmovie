package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends xd.c {
    public final /* synthetic */ h0 A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ge.o f3228y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f3229z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(h0 h0Var, xd.c cVar) {
        super(cVar);
        this.A = h0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f3229z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.k(null, false, this);
    }
}
