package aa;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends j0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c1 f650y = new c1(0, new Object[0]);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final transient Object[] f651w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient int f652x;

    public c1(int i, Object[] objArr) {
        this.f651w = objArr;
        this.f652x = i;
    }

    @Override // aa.j0, aa.e0
    public final int d(int i, Object[] objArr) {
        Object[] objArr2 = this.f651w;
        int i10 = this.f652x;
        System.arraycopy(objArr2, 0, objArr, i, i10);
        return i + i10;
    }

    @Override // aa.e0
    public final Object[] e() {
        return this.f651w;
    }

    @Override // aa.e0
    public final int f() {
        return this.f652x;
    }

    @Override // java.util.List
    public final Object get(int i) {
        q1.c.i(i, this.f652x);
        Object obj = this.f651w[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // aa.e0
    public final int h() {
        return 0;
    }

    @Override // aa.e0
    public final boolean i() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f652x;
    }
}
