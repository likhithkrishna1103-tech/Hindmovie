package z0;

import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z extends td.c {
    public FileOutputStream A;
    public /* synthetic */ Object B;
    public final /* synthetic */ a0 C;
    public int D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a0 f14805x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public File f14806y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FileOutputStream f14807z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(a0 a0Var, td.c cVar) {
        super(cVar);
        this.C = a0Var;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return this.C.i(null, this);
    }
}
