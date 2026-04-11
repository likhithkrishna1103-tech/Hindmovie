package se;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends xd.c {
    public final /* synthetic */ l4.a A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public te.g f11672y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f11673z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l4.a aVar, xd.c cVar) {
        super(cVar);
        this.A = aVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f11673z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.z(null, this);
    }
}
