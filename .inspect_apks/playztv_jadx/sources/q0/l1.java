package q0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class l1 extends k1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i0.d f10461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i0.d f10462p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i0.d f10463q;

    public l1(r1 r1Var, WindowInsets windowInsets) {
        super(r1Var, windowInsets);
        this.f10461o = null;
        this.f10462p = null;
        this.f10463q = null;
    }

    @Override // q0.o1
    public i0.d h() {
        if (this.f10462p == null) {
            this.f10462p = i0.d.d(this.f10454c.getMandatorySystemGestureInsets());
        }
        return this.f10462p;
    }

    @Override // q0.o1
    public i0.d j() {
        if (this.f10461o == null) {
            this.f10461o = i0.d.d(this.f10454c.getSystemGestureInsets());
        }
        return this.f10461o;
    }

    @Override // q0.o1
    public i0.d l() {
        if (this.f10463q == null) {
            this.f10463q = i0.d.d(this.f10454c.getTappableElementInsets());
        }
        return this.f10463q;
    }

    @Override // q0.i1, q0.o1
    public r1 m(int i, int i10, int i11, int i12) {
        return r1.h(null, this.f10454c.inset(i, i10, i11, i12));
    }

    @Override // q0.j1, q0.o1
    public void r(i0.d dVar) {
    }
}
