package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends xd.c {
    public final /* synthetic */ q0 A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q0 f13675y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f13676z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(q0 q0Var, xd.c cVar) {
        super(cVar);
        this.A = q0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f13676z = obj;
        this.B |= Integer.MIN_VALUE;
        return q0.a(this.A, this);
    }
}
