package ua;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends m0 {
    public static final Object[] D;
    public static final f1 E;
    public final transient Object[] A;
    public final transient int B;
    public final transient int C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Object[] f12328y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient int f12329z;

    static {
        Object[] objArr = new Object[0];
        D = objArr;
        E = new f1(0, 0, 0, objArr, objArr);
    }

    public f1(int i, int i10, int i11, Object[] objArr, Object[] objArr2) {
        this.f12328y = objArr;
        this.f12329z = i;
        this.A = objArr2;
        this.B = i10;
        this.C = i11;
    }

    @Override // ua.d0
    public final int b(int i, Object[] objArr) {
        Object[] objArr2 = this.f12328y;
        int i10 = this.C;
        System.arraycopy(objArr2, 0, objArr, i, i10);
        return i + i10;
    }

    @Override // ua.d0
    public final Object[] c() {
        return this.f12328y;
    }

    @Override // ua.d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.A;
            if (objArr.length != 0) {
                int iT = q.t(obj);
                while (true) {
                    int i = iT & this.B;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iT = i + 1;
                }
            }
        }
        return false;
    }

    @Override // ua.d0
    public final int d() {
        return this.C;
    }

    @Override // ua.d0
    public final int f() {
        return 0;
    }

    @Override // ua.d0
    public final boolean g() {
        return false;
    }

    @Override // ua.d0
    /* JADX INFO: renamed from: h */
    public final n1 iterator() {
        return a().listIterator(0);
    }

    @Override // ua.m0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f12329z;
    }

    @Override // ua.m0
    public final i0 l() {
        return i0.i(this.C, this.f12328y);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.C;
    }
}
