package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends xd.c {
    public int A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f14876y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ s f14877z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s sVar, xd.c cVar) {
        super(cVar);
        this.f14877z = sVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f14876y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f14877z.a(this);
    }
}
