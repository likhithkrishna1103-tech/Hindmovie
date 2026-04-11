package v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ua.i0 f12628e;
    public final ua.i0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f12629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f12630h;

    public d1(ua.z0 z0Var, ua.z0 z0Var2, int[] iArr) {
        y1.d.b(z0Var.f12415y == iArr.length);
        this.f12628e = z0Var;
        this.f = z0Var2;
        this.f12629g = iArr;
        this.f12630h = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.f12630h[iArr[i]] = i;
        }
    }

    @Override // v1.f1
    public final int a(boolean z10) {
        if (p()) {
            return -1;
        }
        if (z10) {
            return this.f12629g[0];
        }
        return 0;
    }

    @Override // v1.f1
    public final int b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // v1.f1
    public final int c(boolean z10) {
        if (p()) {
            return -1;
        }
        ua.i0 i0Var = this.f12628e;
        if (!z10) {
            return i0Var.size() - 1;
        }
        return this.f12629g[i0Var.size() - 1];
    }

    @Override // v1.f1
    public final int e(int i, int i10, boolean z10) {
        if (i10 == 1) {
            return i;
        }
        if (i == c(z10)) {
            if (i10 == 2) {
                return a(z10);
            }
            return -1;
        }
        if (!z10) {
            return i + 1;
        }
        return this.f12629g[this.f12630h[i] + 1];
    }

    @Override // v1.f1
    public final c1 f(int i, c1 c1Var, boolean z10) {
        c1 c1Var2 = (c1) this.f.get(i);
        c1Var.h(c1Var2.f12616a, c1Var2.f12617b, c1Var2.f12618c, c1Var2.f12619d, c1Var2.f12620e, c1Var2.f12621g, c1Var2.f);
        return c1Var;
    }

    @Override // v1.f1
    public final int h() {
        return this.f.size();
    }

    @Override // v1.f1
    public final int k(int i, int i10, boolean z10) {
        if (i10 == 1) {
            return i;
        }
        if (i == a(z10)) {
            if (i10 == 2) {
                return c(z10);
            }
            return -1;
        }
        if (!z10) {
            return i - 1;
        }
        return this.f12629g[this.f12630h[i] - 1];
    }

    @Override // v1.f1
    public final Object l(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // v1.f1
    public final e1 m(int i, e1 e1Var, long j4) {
        e1 e1Var2 = (e1) this.f12628e.get(i);
        e1Var.b(e1Var2.f12643a, e1Var2.f12645c, e1Var2.f12646d, e1Var2.f12647e, e1Var2.f, e1Var2.f12648g, e1Var2.f12649h, e1Var2.i, e1Var2.f12650j, e1Var2.f12652l, e1Var2.f12653m, e1Var2.f12654n, e1Var2.f12655o, e1Var2.f12656p);
        e1Var.f12651k = e1Var2.f12651k;
        return e1Var;
    }

    @Override // v1.f1
    public final int o() {
        return this.f12628e.size();
    }
}
