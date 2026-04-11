package se;

/* JADX INFO: loaded from: classes.dex */
public final class p extends xd.c {
    public final /* synthetic */ nb.w A;
    public m B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f11705y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11706z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(nb.w wVar, xd.c cVar) {
        super(cVar);
        this.A = wVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f11705y = obj;
        this.f11706z |= Integer.MIN_VALUE;
        return this.A.z(null, this);
    }
}
