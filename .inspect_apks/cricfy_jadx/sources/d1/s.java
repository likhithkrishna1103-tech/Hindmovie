package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends xd.c {
    public final /* synthetic */ t A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f3296y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3297z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, vd.c cVar) {
        super(cVar);
        this.A = tVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f3296y = obj;
        this.f3297z |= Integer.MIN_VALUE;
        return this.A.f(null, this);
    }
}
