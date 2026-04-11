package a0;

import b0.n;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends d {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public d[] f107q0 = new d[4];

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f108r0 = 0;

    public final void R(int i, n nVar, ArrayList arrayList) {
        for (int i10 = 0; i10 < this.f108r0; i10++) {
            d dVar = this.f107q0[i10];
            ArrayList arrayList2 = nVar.f1619a;
            if (!arrayList2.contains(dVar)) {
                arrayList2.add(dVar);
            }
        }
        for (int i11 = 0; i11 < this.f108r0; i11++) {
            b0.h.b(this.f107q0[i11], i, arrayList, nVar);
        }
    }

    public void S() {
    }
}
