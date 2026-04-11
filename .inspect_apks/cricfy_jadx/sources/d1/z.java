package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends xd.c {
    public boolean A;
    public /* synthetic */ Object B;
    public final /* synthetic */ h0 C;
    public int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h0 f3322y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public l1 f3323z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(h0 h0Var, vd.c cVar) {
        super(cVar);
        this.C = h0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return h0.f(this.C, false, this);
    }
}
