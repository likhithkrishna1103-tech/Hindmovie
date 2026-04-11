package z0;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends td.c {
    public int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Serializable f14752x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Iterator f14753y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f14754z;

    @Override // td.a
    public final Object o(Object obj) {
        this.f14754z = obj;
        this.A |= Integer.MIN_VALUE;
        return cf.l.a(null, null, this);
    }
}
