package se;

/* JADX INFO: loaded from: classes.dex */
public final class i extends xd.c {
    public final /* synthetic */ nb.w A;
    public nb.w B;
    public d C;
    public te.g D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f11688y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11689z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(nb.w wVar, xd.c cVar) {
        super(cVar);
        this.A = wVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f11688y = obj;
        this.f11689z |= Integer.MIN_VALUE;
        return this.A.z(null, this);
    }
}
