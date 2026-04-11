package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends xd.c {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ z C;
    public int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f14895y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Throwable f14896z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(z zVar, xd.c cVar) {
        super(cVar);
        this.C = zVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return this.C.g(null, null, this);
    }
}
