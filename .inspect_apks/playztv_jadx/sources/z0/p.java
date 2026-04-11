package z0;

/* JADX INFO: loaded from: classes.dex */
public final class p extends td.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object f14774x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14775y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ cc.c0 f14776z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(cc.c0 c0Var, rd.c cVar) {
        super(cVar);
        this.f14776z = c0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f14774x = obj;
        this.f14775y |= Integer.MIN_VALUE;
        return this.f14776z.j(null, this);
    }
}
