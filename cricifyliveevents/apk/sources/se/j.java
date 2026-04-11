package se;

/* JADX INFO: loaded from: classes.dex */
public final class j extends xd.c {
    public final /* synthetic */ nb.w A;
    public nb.w B;
    public d C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f11690y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11691z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(nb.w wVar, xd.c cVar) {
        super(cVar);
        this.A = wVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f11690y = obj;
        this.f11691z |= Integer.MIN_VALUE;
        return this.A.z(null, this);
    }
}
