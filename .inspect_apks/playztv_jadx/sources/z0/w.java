package z0;

import java.io.FileInputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends td.c {
    public final /* synthetic */ a0 A;
    public int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f14796x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FileInputStream f14797y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f14798z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(a0 a0Var, td.c cVar) {
        super(cVar);
        this.A = a0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f14798z = obj;
        this.B |= Integer.MIN_VALUE;
        return this.A.f(this);
    }
}
