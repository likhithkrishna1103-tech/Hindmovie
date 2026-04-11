package yc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends xd.c {
    public /* synthetic */ Object A;
    public final /* synthetic */ c B;
    public int C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f15022y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public xe.a f15023z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, xd.c cVar2) {
        super(cVar2);
        this.B = cVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.A = obj;
        this.C |= Integer.MIN_VALUE;
        return this.B.d(this);
    }
}
