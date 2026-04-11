package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends b implements RandomAccess {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final s0 f791y = new s0(new Object[0], 0, false);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object[] f792w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f793x;

    public s0(Object[] objArr, int i, boolean z10) {
        this.f680v = z10;
        this.f792w = objArr;
        this.f793x = i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.f793x;
        Object[] objArr = this.f792w;
        if (i == objArr.length) {
            this.f792w = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f792w;
        int i10 = this.f793x;
        this.f793x = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.f793x) {
            StringBuilder sbM = l0.e.m(i, "Index:", ", Size:");
            sbM.append(this.f793x);
            throw new IndexOutOfBoundsException(sbM.toString());
        }
    }

    public final s0 c(int i) {
        if (i >= this.f793x) {
            return new s0(Arrays.copyOf(this.f792w, i), this.f793x, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.f792w[i];
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.f792w;
        Object obj = objArr[i];
        if (i < this.f793x - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f793x--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.f792w;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f793x;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        a();
        if (i >= 0 && i <= (i10 = this.f793x)) {
            Object[] objArr = this.f792w;
            if (i10 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i10 - i);
            } else {
                Object[] objArr2 = new Object[((i10 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.f792w, i, objArr2, i + 1, this.f793x - i);
                this.f792w = objArr2;
            }
            this.f792w[i] = obj;
            this.f793x++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbM = l0.e.m(i, "Index:", ", Size:");
        sbM.append(this.f793x);
        throw new IndexOutOfBoundsException(sbM.toString());
    }
}
