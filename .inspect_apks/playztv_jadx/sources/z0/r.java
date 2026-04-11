package z0;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends td.c {
    public Object A;
    public t B;
    public Iterator C;
    public /* synthetic */ Object D;
    public final /* synthetic */ a0 E;
    public int F;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f14780x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f14781y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Serializable f14782z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(a0 a0Var, td.c cVar) {
        super(cVar);
        this.E = a0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.D = obj;
        this.F |= Integer.MIN_VALUE;
        return this.E.c(this);
    }
}
