package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j5 extends v4 implements RandomAccess, m5, f6 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f2494y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final j5 f2495z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f2496w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2497x;

    static {
        int[] iArr = new int[0];
        f2494y = iArr;
        f2495z = new j5(iArr, 0, false);
    }

    public j5(int[] iArr, int i, boolean z10) {
        super(z10);
        this.f2496w = iArr;
        this.f2497x = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i10 = this.f2497x)) {
            throw new IndexOutOfBoundsException(x4.a(this.f2497x, i, (byte) 13, "Index:", ", Size:"));
        }
        int i11 = i + 1;
        int[] iArr = this.f2496w;
        int length = iArr.length;
        if (i10 < length) {
            System.arraycopy(iArr, i, iArr, i11, i10 - i);
        } else {
            int[] iArr2 = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2496w, 0, iArr2, 0, i);
            System.arraycopy(this.f2496w, i, iArr2, i11, this.f2497x - i);
            this.f2496w = iArr2;
        }
        this.f2496w[i] = iIntValue;
        this.f2497x++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = p5.f2570a;
        collection.getClass();
        if (!(collection instanceof j5)) {
            return super.addAll(collection);
        }
        j5 j5Var = (j5) collection;
        int i = j5Var.f2497x;
        if (i == 0) {
            return false;
        }
        int i10 = this.f2497x;
        if (Integer.MAX_VALUE - i10 < i) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i;
        int[] iArr = this.f2496w;
        if (i11 > iArr.length) {
            this.f2496w = Arrays.copyOf(iArr, i11);
        }
        System.arraycopy(j5Var.f2496w, 0, this.f2496w, this.f2497x, j5Var.f2497x);
        this.f2497x = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j5 e(int i) {
        if (i >= this.f2497x) {
            return new j5(i == 0 ? f2494y : Arrays.copyOf(this.f2496w, i), this.f2497x, true);
        }
        throw new IllegalArgumentException();
    }

    public final int c(int i) {
        f(i);
        return this.f2496w[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        a();
        int i10 = this.f2497x;
        int length = this.f2496w.length;
        if (i10 == length) {
            int[] iArr = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2496w, 0, iArr, 0, this.f2497x);
            this.f2496w = iArr;
        }
        int[] iArr2 = this.f2496w;
        int i11 = this.f2497x;
        this.f2497x = i11 + 1;
        iArr2[i11] = i;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j5)) {
            return super.equals(obj);
        }
        j5 j5Var = (j5) obj;
        if (this.f2497x != j5Var.f2497x) {
            return false;
        }
        int[] iArr = j5Var.f2496w;
        for (int i = 0; i < this.f2497x; i++) {
            if (this.f2496w[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i) {
        if (i < 0 || i >= this.f2497x) {
            throw new IndexOutOfBoundsException(x4.a(this.f2497x, i, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        f(i);
        return Integer.valueOf(this.f2496w[i]);
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i10 = 0; i10 < this.f2497x; i10++) {
            i = (i * 31) + this.f2496w[i10];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.f2497x;
        for (int i10 = 0; i10 < i; i10++) {
            if (this.f2496w[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        a();
        f(i);
        int[] iArr = this.f2496w;
        int i10 = iArr[i];
        if (i < this.f2497x - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f2497x--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        a();
        if (i10 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f2496w;
        System.arraycopy(iArr, i10, iArr, i, this.f2497x - i10);
        this.f2497x -= i10 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        f(i);
        int[] iArr = this.f2496w;
        int i10 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2497x;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
