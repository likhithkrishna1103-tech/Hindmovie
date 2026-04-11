package x;

import java.util.ArrayList;
import y.n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends e {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public e[] f14201q0 = new e[4];

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f14202r0 = 0;

    public final void R(int i, ArrayList arrayList, n nVar) {
        for (int i10 = 0; i10 < this.f14202r0; i10++) {
            e eVar = this.f14201q0[i10];
            ArrayList arrayList2 = nVar.f14407a;
            if (!arrayList2.contains(eVar)) {
                arrayList2.add(eVar);
            }
        }
        for (int i11 = 0; i11 < this.f14202r0; i11++) {
            y.h.b(this.f14201q0[i11], i, arrayList, nVar);
        }
    }

    public void S() {
    }
}
