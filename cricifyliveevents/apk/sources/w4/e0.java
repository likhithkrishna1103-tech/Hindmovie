package w4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends xd.c {
    public final /* synthetic */ l0 A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f13930y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f13931z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(l0 l0Var, xd.c cVar) {
        super(cVar);
        this.A = l0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f13931z = obj;
        this.B |= Integer.MIN_VALUE;
        return l0.a(this.A, null, this);
    }
}
