package ne;

import ke.v0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends td.c {
    public v0 A;
    public Object B;
    public /* synthetic */ Object C;
    public final /* synthetic */ n D;
    public int E;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public n f9017x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c f9018y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p f9019z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, td.c cVar) {
        super(cVar);
        this.D = nVar;
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        this.C = obj;
        this.E |= Integer.MIN_VALUE;
        this.D.o(null, this);
        return sd.a.f11942u;
    }
}
