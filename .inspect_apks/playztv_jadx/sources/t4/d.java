package t4;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends td.c {
    public be.n A;
    public rd.h B;
    public be.n C;
    public boolean D;
    public /* synthetic */ Object E;
    public final /* synthetic */ e F;
    public int G;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f12108x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Serializable f12109y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h f12110z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, td.c cVar) {
        super(cVar);
        this.F = eVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.E = obj;
        this.G |= Integer.MIN_VALUE;
        return this.F.I(false, null, this);
    }
}
