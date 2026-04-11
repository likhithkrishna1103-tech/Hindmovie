package w4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends xd.c {
    public String[] A;
    public int B;
    public int C;
    public /* synthetic */ Object D;
    public final /* synthetic */ l0 E;
    public int F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m f13947y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f13948z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(l0 l0Var, xd.c cVar) {
        super(cVar);
        this.E = l0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.D = obj;
        this.F |= Integer.MIN_VALUE;
        return l0.d(this.E, null, 0, this);
    }
}
