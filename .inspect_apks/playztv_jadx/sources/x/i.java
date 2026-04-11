package x;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends e {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f14195q0 = -1.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f14196r0 = -1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f14197s0 = -1;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public d f14198t0 = this.J;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f14199u0 = 0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f14200v0;

    public i() {
        this.R.clear();
        this.R.add(this.f14198t0);
        int length = this.Q.length;
        for (int i = 0; i < length; i++) {
            this.Q[i] = this.f14198t0;
        }
    }

    @Override // x.e
    public final boolean A() {
        return this.f14200v0;
    }

    @Override // x.e
    public final boolean B() {
        return this.f14200v0;
    }

    @Override // x.e
    public final void Q(v.c cVar, boolean z2) {
        if (this.T == null) {
            return;
        }
        d dVar = this.f14198t0;
        cVar.getClass();
        int iN = v.c.n(dVar);
        if (this.f14199u0 == 1) {
            this.Y = iN;
            this.Z = 0;
            L(this.T.k());
            O(0);
            return;
        }
        this.Y = 0;
        this.Z = iN;
        O(this.T.q());
        L(0);
    }

    public final void R(int i) {
        this.f14198t0.l(i);
        this.f14200v0 = true;
    }

    public final void S(int i) {
        if (this.f14199u0 == i) {
            return;
        }
        this.f14199u0 = i;
        ArrayList arrayList = this.R;
        arrayList.clear();
        if (this.f14199u0 == 1) {
            this.f14198t0 = this.I;
        } else {
            this.f14198t0 = this.J;
        }
        arrayList.add(this.f14198t0);
        d[] dVarArr = this.Q;
        int length = dVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            dVarArr[i10] = this.f14198t0;
        }
    }

    @Override // x.e
    public final void b(v.c cVar, boolean z2) {
        f fVar = (f) this.T;
        if (fVar == null) {
            return;
        }
        Object objI = fVar.i(2);
        Object objI2 = fVar.i(4);
        e eVar = this.T;
        boolean z10 = eVar != null && eVar.f14149p0[0] == 2;
        if (this.f14199u0 == 0) {
            objI = fVar.i(3);
            objI2 = fVar.i(5);
            e eVar2 = this.T;
            z10 = eVar2 != null && eVar2.f14149p0[1] == 2;
        }
        if (this.f14200v0) {
            d dVar = this.f14198t0;
            if (dVar.f14116c) {
                v.f fVarK = cVar.k(dVar);
                cVar.d(fVarK, this.f14198t0.d());
                if (this.f14196r0 != -1) {
                    if (z10) {
                        cVar.f(cVar.k(objI2), fVarK, 0, 5);
                    }
                } else if (this.f14197s0 != -1 && z10) {
                    v.f fVarK2 = cVar.k(objI2);
                    cVar.f(fVarK, cVar.k(objI), 0, 5);
                    cVar.f(fVarK2, fVarK, 0, 5);
                }
                this.f14200v0 = false;
                return;
            }
        }
        if (this.f14196r0 != -1) {
            v.f fVarK3 = cVar.k(this.f14198t0);
            cVar.e(fVarK3, cVar.k(objI), this.f14196r0, 8);
            if (z10) {
                cVar.f(cVar.k(objI2), fVarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f14197s0 != -1) {
            v.f fVarK4 = cVar.k(this.f14198t0);
            v.f fVarK5 = cVar.k(objI2);
            cVar.e(fVarK4, fVarK5, -this.f14197s0, 8);
            if (z10) {
                cVar.f(fVarK4, cVar.k(objI), 0, 5);
                cVar.f(fVarK5, fVarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f14195q0 != -1.0f) {
            v.f fVarK6 = cVar.k(this.f14198t0);
            v.f fVarK7 = cVar.k(objI2);
            float f = this.f14195q0;
            v.b bVarL = cVar.l();
            bVarL.f13085d.g(fVarK6, -1.0f);
            bVarL.f13085d.g(fVarK7, f);
            cVar.c(bVarL);
        }
    }

    @Override // x.e
    public final boolean c() {
        return true;
    }

    @Override // x.e
    public final d i(int i) {
        int iC = v.e.c(i);
        if (iC != 1) {
            if (iC != 2) {
                if (iC != 3) {
                    if (iC != 4) {
                        return null;
                    }
                }
            }
            if (this.f14199u0 == 0) {
                return this.f14198t0;
            }
            return null;
        }
        if (this.f14199u0 == 1) {
            return this.f14198t0;
        }
        return null;
    }
}
