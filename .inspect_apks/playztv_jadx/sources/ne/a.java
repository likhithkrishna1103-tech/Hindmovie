package ne;

import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public oe.f f8993x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f8994y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ a1 f8995z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(a1 a1Var, td.c cVar) {
        super(cVar);
        this.f8995z = a1Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f8994y = obj;
        this.A |= Integer.MIN_VALUE;
        return this.f8995z.o(null, this);
    }
}
