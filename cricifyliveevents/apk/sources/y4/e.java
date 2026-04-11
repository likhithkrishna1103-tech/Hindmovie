package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends xd.c {
    public Object A;
    public ge.p B;
    public vd.h C;
    public ge.p D;
    public x2.b E;
    public /* synthetic */ Object F;
    public final /* synthetic */ f G;
    public int H;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14845y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f14846z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, xd.c cVar) {
        super(cVar);
        this.G = fVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.F = obj;
        this.H |= Integer.MIN_VALUE;
        return this.G.T(false, null, this);
    }
}
