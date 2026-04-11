package aa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends o0 {
    public static final Object[] C;
    public static final i1 D;
    public final transient int A;
    public final transient int B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Object[] f686x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient int f687y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient Object[] f688z;

    static {
        Object[] objArr = new Object[0];
        C = objArr;
        D = new i1(0, 0, 0, objArr, objArr);
    }

    public i1(int i, int i10, int i11, Object[] objArr, Object[] objArr2) {
        this.f686x = objArr;
        this.f687y = i;
        this.f688z = objArr2;
        this.A = i10;
        this.B = i11;
    }

    @Override // aa.e0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f688z;
            if (objArr.length != 0) {
                int iS = q.s(obj);
                while (true) {
                    int i = iS & this.A;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iS = i + 1;
                }
            }
        }
        return false;
    }

    @Override // aa.e0
    public final int d(int i, Object[] objArr) {
        Object[] objArr2 = this.f686x;
        int i10 = this.B;
        System.arraycopy(objArr2, 0, objArr, i, i10);
        return i + i10;
    }

    @Override // aa.e0
    public final Object[] e() {
        return this.f686x;
    }

    @Override // aa.e0
    public final int f() {
        return this.B;
    }

    @Override // aa.e0
    public final int h() {
        return 0;
    }

    @Override // aa.o0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f687y;
    }

    @Override // aa.e0
    public final boolean i() {
        return false;
    }

    @Override // aa.e0
    /* JADX INFO: renamed from: j */
    public final q1 iterator() {
        return b().listIterator(0);
    }

    @Override // aa.o0
    public final j0 s() {
        return j0.l(this.B, this.f686x);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.B;
    }
}
