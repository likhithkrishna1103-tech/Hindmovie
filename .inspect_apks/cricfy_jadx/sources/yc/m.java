package yc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends xd.c {
    public int A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f15047y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ n f15048z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, xd.c cVar) {
        super(cVar);
        this.f15048z = nVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f15047y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f15048z.c(null, this);
    }
}
