package se;

/* JADX INFO: loaded from: classes.dex */
public final class g extends xd.c {
    public final /* synthetic */ h A;
    public Object B;
    public d C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f11684y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11685z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, xd.c cVar) {
        super(cVar);
        this.A = hVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.f11684y = obj;
        this.f11685z |= Integer.MIN_VALUE;
        return this.A.z(null, this);
    }
}
