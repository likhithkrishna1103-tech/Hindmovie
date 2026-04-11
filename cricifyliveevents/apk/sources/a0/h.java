package a0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f101q0 = -1.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f102r0 = -1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f103s0 = -1;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public c f104t0 = this.J;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f105u0 = 0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f106v0;

    public h() {
        this.R.clear();
        this.R.add(this.f104t0);
        int length = this.Q.length;
        for (int i = 0; i < length; i++) {
            this.Q[i] = this.f104t0;
        }
    }

    @Override // a0.d
    public final boolean A() {
        return this.f106v0;
    }

    @Override // a0.d
    public final boolean B() {
        return this.f106v0;
    }

    @Override // a0.d
    public final void Q(y.c cVar, boolean z10) {
        if (this.T == null) {
            return;
        }
        c cVar2 = this.f104t0;
        cVar.getClass();
        int iN = y.c.n(cVar2);
        if (this.f105u0 == 1) {
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
        this.f104t0.l(i);
        this.f106v0 = true;
    }

    public final void S(int i) {
        if (this.f105u0 == i) {
            return;
        }
        this.f105u0 = i;
        ArrayList arrayList = this.R;
        arrayList.clear();
        if (this.f105u0 == 1) {
            this.f104t0 = this.I;
        } else {
            this.f104t0 = this.J;
        }
        arrayList.add(this.f104t0);
        c[] cVarArr = this.Q;
        int length = cVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            cVarArr[i10] = this.f104t0;
        }
    }

    @Override // a0.d
    public final void b(y.c cVar, boolean z10) {
        e eVar = (e) this.T;
        if (eVar == null) {
            return;
        }
        Object objI = eVar.i(2);
        Object objI2 = eVar.i(4);
        d dVar = this.T;
        boolean z11 = dVar != null && dVar.f54p0[0] == 2;
        if (this.f105u0 == 0) {
            objI = eVar.i(3);
            objI2 = eVar.i(5);
            d dVar2 = this.T;
            z11 = dVar2 != null && dVar2.f54p0[1] == 2;
        }
        if (this.f106v0) {
            c cVar2 = this.f104t0;
            if (cVar2.f21c) {
                y.f fVarK = cVar.k(cVar2);
                cVar.d(fVarK, this.f104t0.d());
                if (this.f102r0 != -1) {
                    if (z11) {
                        cVar.f(cVar.k(objI2), fVarK, 0, 5);
                    }
                } else if (this.f103s0 != -1 && z11) {
                    y.f fVarK2 = cVar.k(objI2);
                    cVar.f(fVarK, cVar.k(objI), 0, 5);
                    cVar.f(fVarK2, fVarK, 0, 5);
                }
                this.f106v0 = false;
                return;
            }
        }
        if (this.f102r0 != -1) {
            y.f fVarK3 = cVar.k(this.f104t0);
            cVar.e(fVarK3, cVar.k(objI), this.f102r0, 8);
            if (z11) {
                cVar.f(cVar.k(objI2), fVarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f103s0 != -1) {
            y.f fVarK4 = cVar.k(this.f104t0);
            y.f fVarK5 = cVar.k(objI2);
            cVar.e(fVarK4, fVarK5, -this.f103s0, 8);
            if (z11) {
                cVar.f(fVarK4, cVar.k(objI), 0, 5);
                cVar.f(fVarK5, fVarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f101q0 != -1.0f) {
            y.f fVarK6 = cVar.k(this.f104t0);
            y.f fVarK7 = cVar.k(objI2);
            float f = this.f101q0;
            y.b bVarL = cVar.l();
            bVarL.f14518d.g(fVarK6, -1.0f);
            bVarL.f14518d.g(fVarK7, f);
            cVar.c(bVarL);
        }
    }

    @Override // a0.d
    public final boolean c() {
        return true;
    }

    @Override // a0.d
    public final c i(int i) {
        int iC = y.e.c(i);
        if (iC != 1) {
            if (iC != 2) {
                if (iC != 3) {
                    if (iC != 4) {
                        return null;
                    }
                }
            }
            if (this.f105u0 == 0) {
                return this.f104t0;
            }
            return null;
        }
        if (this.f105u0 == 1) {
            return this.f104t0;
        }
        return null;
    }
}
