package ua;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends b0 {
    public static final y0 D = new y0();
    public final transient int A;
    public final transient int B;
    public final transient y0 C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Object f12410y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient Object[] f12411z;

    public y0() {
        this.f12410y = null;
        this.f12411z = new Object[0];
        this.A = 0;
        this.B = 0;
        this.C = this;
    }

    @Override // ua.k0
    public final b1 b() {
        return new b1(this, this.f12411z, this.A, this.B);
    }

    @Override // ua.k0
    public final c1 c() {
        return new c1(this, new d1(this.f12411z, this.A, this.B));
    }

    @Override // ua.k0, java.util.Map
    public final Object get(Object obj) {
        Object objH = e1.h(this.f12410y, this.f12411z, this.B, this.A, obj);
        if (objH == null) {
            return null;
        }
        return objH;
    }

    @Override // java.util.Map
    public final int size() {
        return this.B;
    }

    public y0(int i, Object[] objArr) {
        this.f12411z = objArr;
        this.B = i;
        this.A = 0;
        int i10 = i >= 2 ? m0.i(i) : 0;
        Object objG = e1.g(objArr, i, i10, 0);
        if (!(objG instanceof Object[])) {
            this.f12410y = objG;
            Object objG2 = e1.g(objArr, i, i10, 1);
            if (!(objG2 instanceof Object[])) {
                this.C = new y0(objG2, objArr, i, this);
                return;
            }
            throw ((j0) ((Object[]) objG2)[2]).a();
        }
        throw ((j0) ((Object[]) objG)[2]).a();
    }

    public y0(Object obj, Object[] objArr, int i, y0 y0Var) {
        this.f12410y = obj;
        this.f12411z = objArr;
        this.A = 1;
        this.B = i;
        this.C = y0Var;
    }
}
