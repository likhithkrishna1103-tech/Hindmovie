package g2;

import java.util.ArrayList;
import k8.b0;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f4854c = {8, 13, 11, 2, 0, 1, 7};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f4855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4856b;

    public static void a(int i, ArrayList arrayList) {
        if (q1.c.E(f4854c, i, 0, 7) == -1 || arrayList.contains(Integer.valueOf(i))) {
            return;
        }
        arrayList.add(Integer.valueOf(i));
    }

    public final p1.q b(p1.q qVar) {
        if (!this.f4856b || !this.f4855a.d(qVar)) {
            return qVar;
        }
        p1.p pVarA = qVar.a();
        String str = qVar.f10020k;
        pVarA.f9967m = m0.p("application/x-media3-cues");
        pVarA.K = this.f4855a.e(qVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(qVar.f10023n);
        sb2.append(str != null ? " ".concat(str) : "");
        pVarA.f9964j = sb2.toString();
        pVarA.f9972r = Long.MAX_VALUE;
        return new p1.q(pVarA);
    }
}
