package v2;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;
import v1.h1;
import v1.k1;
import v1.l1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends k1 {
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

    public h(i iVar) {
        e(iVar);
        this.F = iVar.o0;
        this.G = iVar.f13096p0;
        this.H = iVar.f13097q0;
        this.I = iVar.f13098r0;
        this.J = iVar.f13099s0;
        this.K = iVar.f13100t0;
        this.L = iVar.f13101u0;
        this.M = iVar.f13102v0;
        SparseArray sparseArray = iVar.f13103w0;
        SparseArray sparseArray2 = new SparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
        }
        this.N = sparseArray2;
        this.O = iVar.f13104x0.clone();
    }

    @Override // v1.k1
    public final l1 b() {
        return new i(this);
    }

    @Override // v1.k1
    public final k1 c() {
        super.c();
        return this;
    }

    @Override // v1.k1
    public final k1 d(int i) {
        super.d(i);
        return this;
    }

    @Override // v1.k1
    public final k1 g() {
        this.f12822y = -3;
        return this;
    }

    @Override // v1.k1
    public final k1 h(h1 h1Var) {
        super.h(h1Var);
        return this;
    }

    @Override // v1.k1
    public final k1 i(int i, boolean z10) {
        super.i(i, z10);
        return this;
    }

    public h() {
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
