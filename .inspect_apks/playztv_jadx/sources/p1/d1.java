package p1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final aa.j0 f9700e;
    public final aa.j0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f9701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f9702h;

    public d1(aa.c1 c1Var, aa.c1 c1Var2, int[] iArr) {
        s1.d.b(c1Var.f652x == iArr.length);
        this.f9700e = c1Var;
        this.f = c1Var2;
        this.f9701g = iArr;
        this.f9702h = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.f9702h[iArr[i]] = i;
        }
    }

    @Override // p1.f1
    public final int a(boolean z2) {
        if (p()) {
            return -1;
        }
        if (z2) {
            return this.f9701g[0];
        }
        return 0;
    }

    @Override // p1.f1
    public final int b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p1.f1
    public final int c(boolean z2) {
        if (p()) {
            return -1;
        }
        aa.j0 j0Var = this.f9700e;
        if (!z2) {
            return j0Var.size() - 1;
        }
        return this.f9701g[j0Var.size() - 1];
    }

    @Override // p1.f1
    public final int e(int i, int i10, boolean z2) {
        if (i10 == 1) {
            return i;
        }
        if (i == c(z2)) {
            if (i10 == 2) {
                return a(z2);
            }
            return -1;
        }
        if (!z2) {
            return i + 1;
        }
        return this.f9701g[this.f9702h[i] + 1];
    }

    @Override // p1.f1
    public final c1 f(int i, c1 c1Var, boolean z2) {
        c1 c1Var2 = (c1) this.f.get(i);
        c1Var.h(c1Var2.f9676a, c1Var2.f9677b, c1Var2.f9678c, c1Var2.f9679d, c1Var2.f9680e, c1Var2.f9681g, c1Var2.f);
        return c1Var;
    }

    @Override // p1.f1
    public final int h() {
        return this.f.size();
    }

    @Override // p1.f1
    public final int k(int i, int i10, boolean z2) {
        if (i10 == 1) {
            return i;
        }
        if (i == a(z2)) {
            if (i10 == 2) {
                return c(z2);
            }
            return -1;
        }
        if (!z2) {
            return i - 1;
        }
        return this.f9701g[this.f9702h[i] - 1];
    }

    @Override // p1.f1
    public final Object l(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p1.f1
    public final e1 m(int i, e1 e1Var, long j5) {
        e1 e1Var2 = (e1) this.f9700e.get(i);
        e1Var.b(e1Var2.f9713a, e1Var2.f9715c, e1Var2.f9716d, e1Var2.f9717e, e1Var2.f, e1Var2.f9718g, e1Var2.f9719h, e1Var2.i, e1Var2.f9720j, e1Var2.f9722l, e1Var2.f9723m, e1Var2.f9724n, e1Var2.f9725o, e1Var2.f9726p);
        e1Var.f9721k = e1Var2.f9721k;
        return e1Var;
    }

    @Override // p1.f1
    public final int o() {
        return this.f9700e.size();
    }
}
