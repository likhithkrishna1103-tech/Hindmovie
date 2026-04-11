package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends b implements RandomAccess {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final z0 f1149x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f1150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1151w;

    static {
        z0 z0Var = new z0(0, new Object[0]);
        f1149x = z0Var;
        z0Var.f1011u = false;
    }

    public z0(int i, Object[] objArr) {
        this.f1150v = objArr;
        this.f1151w = i;
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i = this.f1151w;
        Object[] objArr = this.f1150v;
        if (i == objArr.length) {
            this.f1150v = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f1150v;
        int i10 = this.f1151w;
        this.f1151w = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void d(int i) {
        if (i < 0 || i >= this.f1151w) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.f1151w);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        d(i);
        return this.f1150v[i];
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final y k(int i) {
        if (i < this.f1151w) {
            throw new IllegalArgumentException();
        }
        return new z0(this.f1151w, Arrays.copyOf(this.f1150v, i));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        d(i);
        Object[] objArr = this.f1150v;
        Object obj = objArr[i];
        if (i < this.f1151w - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f1151w--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b();
        d(i);
        Object[] objArr = this.f1150v;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1151w;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        b();
        if (i >= 0 && i <= (i10 = this.f1151w)) {
            Object[] objArr = this.f1150v;
            if (i10 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i10 - i);
            } else {
                Object[] objArr2 = new Object[((i10 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.f1150v, i, objArr2, i + 1, this.f1151w - i);
                this.f1150v = objArr2;
            }
            this.f1150v[i] = obj;
            this.f1151w++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.f1151w);
    }
}
