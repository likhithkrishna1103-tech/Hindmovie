package w4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends xd.c {
    public String[] A;
    public int B;
    public int C;
    public int D;
    public /* synthetic */ Object E;
    public final /* synthetic */ l0 F;
    public int G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m f13944y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f13945z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(l0 l0Var, xd.c cVar) {
        super(cVar);
        this.F = l0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.E = obj;
        this.G |= Integer.MIN_VALUE;
        return l0.c(this.F, null, 0, this);
    }
}
