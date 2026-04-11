package dc;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends td.c {
    public se.c A;
    public Map B;
    public Object C;
    public /* synthetic */ Object D;
    public final /* synthetic */ c E;
    public int F;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map f4120x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Iterator f4121y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f4122z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, td.c cVar2) {
        super(cVar2);
        this.E = cVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.D = obj;
        this.F |= Integer.MIN_VALUE;
        return this.E.b(this);
    }
}
