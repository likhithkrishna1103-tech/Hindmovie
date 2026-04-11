package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends xd.c {
    public Object A;
    public /* synthetic */ Object B;
    public final /* synthetic */ z0 C;
    public int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3316y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f3317z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(z0 z0Var, xd.c cVar) {
        super(cVar);
        this.C = z0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return this.C.b(null, this);
    }
}
