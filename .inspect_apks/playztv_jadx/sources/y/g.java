package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14400m;

    public g(o oVar) {
        super(oVar);
        if (oVar instanceof k) {
            this.f14394e = 2;
        } else {
            this.f14394e = 3;
        }
    }

    @Override // y.f
    public final void d(int i) {
        if (this.f14397j) {
            return;
        }
        this.f14397j = true;
        this.f14395g = i;
        ArrayList arrayList = this.f14398k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }
}
