package b0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1612m;

    public g(o oVar) {
        super(oVar);
        if (oVar instanceof k) {
            this.f1606e = 2;
        } else {
            this.f1606e = 3;
        }
    }

    @Override // b0.f
    public final void d(int i) {
        if (this.f1609j) {
            return;
        }
        this.f1609j = true;
        this.f1607g = i;
        ArrayList arrayList = this.f1610k;
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
