package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends xd.c {
    public /* synthetic */ Object A;
    public final /* synthetic */ a1 B;
    public int C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f13716y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public x0 f13717z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(a1 a1Var, vd.c cVar) {
        super(cVar);
        this.B = a1Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.A = obj;
        this.C |= Integer.MIN_VALUE;
        return a1.a(this.B, null, null, this);
    }
}
