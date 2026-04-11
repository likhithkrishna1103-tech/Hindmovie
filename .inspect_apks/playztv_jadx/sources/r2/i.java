package r2;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;
import p1.h1;
import p1.k1;
import p1.l1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k1 {
    public final boolean F;
    public boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final SparseArray N;
    public final SparseBooleanArray O;

    public i(j jVar) {
        e(jVar);
        this.F = jVar.f11322o0;
        this.G = jVar.f11323p0;
        this.H = jVar.f11324q0;
        this.I = jVar.f11325r0;
        this.J = jVar.f11326s0;
        this.K = jVar.f11327t0;
        this.L = jVar.f11328u0;
        this.M = jVar.f11329v0;
        SparseArray sparseArray = jVar.f11330w0;
        SparseArray sparseArray2 = new SparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
        }
        this.N = sparseArray2;
        this.O = jVar.f11331x0.clone();
    }

    @Override // p1.k1
    public final l1 b() {
        return new j(this);
    }

    @Override // p1.k1
    public final k1 c() {
        super.c();
        return this;
    }

    @Override // p1.k1
    public final k1 d(int i) {
        super.d(i);
        return this;
    }

    @Override // p1.k1
    public final k1 g() {
        this.f9889y = -3;
        return this;
    }

    @Override // p1.k1
    public final k1 h(h1 h1Var) {
        super.h(h1Var);
        return this;
    }

    @Override // p1.k1
    public final k1 i(int i, boolean z2) {
        super.i(i, z2);
        return this;
    }

    public i() {
        this.N = new SparseArray();
        this.O = new SparseBooleanArray();
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
        this.M = true;
    }
}
