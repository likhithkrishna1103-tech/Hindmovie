package aa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends b0 {
    public static final b1 C = new b1();
    public final transient int A;
    public final transient b1 B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Object f643x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Object[] f644y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient int f645z;

    public b1() {
        this.f643x = null;
        this.f644y = new Object[0];
        this.f645z = 0;
        this.A = 0;
        this.B = this;
    }

    @Override // aa.m0
    public final e1 b() {
        return new e1(this, this.f644y, this.f645z, this.A);
    }

    @Override // aa.m0
    public final f1 c() {
        return new f1(this, new g1(this.f644y, this.f645z, this.A));
    }

    @Override // aa.m0, java.util.Map
    public final Object get(Object obj) {
        Object objG = h1.g(this.f643x, this.f644y, this.A, this.f645z, obj);
        if (objG == null) {
            return null;
        }
        return objG;
    }

    @Override // java.util.Map
    public final int size() {
        return this.A;
    }

    public b1(int i, Object[] objArr) {
        this.f644y = objArr;
        this.A = i;
        this.f645z = 0;
        int iL = i >= 2 ? o0.l(i) : 0;
        Object objF = h1.f(objArr, i, iL, 0);
        if (!(objF instanceof Object[])) {
            this.f643x = objF;
            Object objF2 = h1.f(objArr, i, iL, 1);
            if (!(objF2 instanceof Object[])) {
                this.B = new b1(objF2, objArr, i, this);
                return;
            }
            throw ((k0) ((Object[]) objF2)[2]).a();
        }
        throw ((k0) ((Object[]) objF)[2]).a();
    }

    public b1(Object obj, Object[] objArr, int i, b1 b1Var) {
        this.f643x = obj;
        this.f644y = objArr;
        this.f645z = 1;
        this.A = i;
        this.B = b1Var;
    }
}
