package t4;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends td.c {
    public /* synthetic */ Object A;
    public final /* synthetic */ p B;
    public int C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f12142x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Serializable f12143y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12144z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(p pVar, td.c cVar) {
        super(cVar);
        this.B = pVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.A = obj;
        this.C |= Integer.MIN_VALUE;
        return this.B.g(null, null, this);
    }
}
