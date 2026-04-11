package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m5 extends v4 implements q5, f6, RandomAccess {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f3097x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final m5 f3098y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f3099v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3100w;

    static {
        int[] iArr = new int[0];
        f3097x = iArr;
        f3098y = new m5(iArr, 0, false);
    }

    public m5(int[] iArr, int i, boolean z2) {
        super(z2);
        this.f3099v = iArr;
        this.f3100w = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i10 = this.f3100w)) {
            throw new IndexOutOfBoundsException(l4.a.l(i, this.f3100w, "Index:", ", Size:"));
        }
        int[] iArr = this.f3099v;
        if (i10 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i10 - i);
        } else {
            int[] iArr2 = new int[Math.max(((iArr.length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f3099v, 0, iArr2, 0, i);
            System.arraycopy(this.f3099v, i, iArr2, i + 1, this.f3100w - i);
            this.f3099v = iArr2;
        }
        this.f3099v[i] = iIntValue;
        this.f3100w++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = l5.f3086a;
        collection.getClass();
        if (!(collection instanceof m5)) {
            return super.addAll(collection);
        }
        m5 m5Var = (m5) collection;
        int i = m5Var.f3100w;
        if (i == 0) {
            return false;
        }
        int i10 = this.f3100w;
        if (Integer.MAX_VALUE - i10 < i) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i;
        int[] iArr = this.f3099v;
        if (i11 > iArr.length) {
            this.f3099v = Arrays.copyOf(iArr, i11);
        }
        System.arraycopy(m5Var.f3099v, 0, this.f3099v, this.f3100w, m5Var.f3100w);
        this.f3100w = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final int b(int i) {
        f(i);
        return this.f3099v[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.s5
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final m5 c(int i) {
        if (i >= this.f3100w) {
            return new m5(i == 0 ? f3097x : Arrays.copyOf(this.f3099v, i), this.f3100w, true);
        }
        throw new IllegalArgumentException();
    }

    public final void e(int i) {
        a();
        int i10 = this.f3100w;
        int[] iArr = this.f3099v;
        if (i10 == iArr.length) {
            int[] iArr2 = new int[Math.max(((iArr.length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f3099v, 0, iArr2, 0, this.f3100w);
            this.f3099v = iArr2;
        }
        int[] iArr3 = this.f3099v;
        int i11 = this.f3100w;
        this.f3100w = i11 + 1;
        iArr3[i11] = i;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m5)) {
            return super.equals(obj);
        }
        m5 m5Var = (m5) obj;
        if (this.f3100w != m5Var.f3100w) {
            return false;
        }
        int[] iArr = m5Var.f3099v;
        for (int i = 0; i < this.f3100w; i++) {
            if (this.f3099v[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i) {
        if (i < 0 || i >= this.f3100w) {
            throw new IndexOutOfBoundsException(l4.a.l(i, this.f3100w, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(b(i));
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i10 = 0; i10 < this.f3100w; i10++) {
            i = (i * 31) + this.f3099v[i10];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.f3100w;
        for (int i10 = 0; i10 < i; i10++) {
            if (this.f3099v[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        f(i);
        int[] iArr = this.f3099v;
        int i10 = iArr[i];
        if (i < this.f3100w - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f3100w--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        a();
        if (i10 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f3099v;
        System.arraycopy(iArr, i10, iArr, i, this.f3100w - i10);
        this.f3100w -= i10 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        f(i);
        int[] iArr = this.f3099v;
        int i10 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3100w;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        e(((Integer) obj).intValue());
        return true;
    }
}
