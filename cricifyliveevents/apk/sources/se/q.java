package se;

/* JADX INFO: loaded from: classes.dex */
public final class q extends xd.c {
    public int A;
    public final /* synthetic */ m B;
    public Object C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m f11707y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f11708z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(m mVar, vd.c cVar) {
        super(cVar);
        this.B = mVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f11708z = obj;
        this.A |= Integer.MIN_VALUE;
        return this.B.f(null, this);
    }
}
