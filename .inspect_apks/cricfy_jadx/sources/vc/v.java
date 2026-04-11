package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends xd.c {
    public final /* synthetic */ q A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f13701y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f13702z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(q qVar, xd.c cVar) {
        super(cVar);
        this.A = qVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f13702z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.a(null, this);
    }
}
