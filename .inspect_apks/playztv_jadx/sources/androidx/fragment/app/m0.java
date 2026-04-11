package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f1300b;

    public m0(n0 n0Var, int i) {
        this.f1300b = n0Var;
        this.f1299a = i;
    }

    @Override // androidx.fragment.app.l0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        n0 n0Var = this.f1300b;
        v vVar = n0Var.f1330w;
        int i = this.f1299a;
        if (vVar == null || i >= 0 || !vVar.i().P(-1, 0)) {
            return n0Var.Q(arrayList, arrayList2, i, 1);
        }
        return false;
    }
}
