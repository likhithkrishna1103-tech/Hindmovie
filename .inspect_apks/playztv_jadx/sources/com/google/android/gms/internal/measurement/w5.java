package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w5 extends v4 implements o5, f6, RandomAccess {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long[] f3223x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final w5 f3224y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long[] f3225v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3226w;

    static {
        long[] jArr = new long[0];
        f3223x = jArr;
        f3224y = new w5(jArr, 0, false);
    }

    public w5(long[] jArr, int i, boolean z2) {
        super(z2);
        this.f3225v = jArr;
        this.f3226w = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        long jLongValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i10 = this.f3226w)) {
            throw new IndexOutOfBoundsException(l4.a.l(i, this.f3226w, "Index:", ", Size:"));
        }
        long[] jArr = this.f3225v;
        if (i10 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i10 - i);
        } else {
            long[] jArr2 = new long[Math.max(((jArr.length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f3225v, 0, jArr2, 0, i);
            System.arraycopy(this.f3225v, i, jArr2, i + 1, this.f3226w - i);
            this.f3225v = jArr2;
        }
        this.f3225v[i] = jLongValue;
        this.f3226w++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = l5.f3086a;
        collection.getClass();
        if (!(collection instanceof w5)) {
            return super.addAll(collection);
        }
        w5 w5Var = (w5) collection;
        int i = w5Var.f3226w;
        if (i == 0) {
            return false;
        }
        int i10 = this.f3226w;
        if (Integer.MAX_VALUE - i10 < i) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i;
        long[] jArr = this.f3225v;
        if (i11 > jArr.length) {
            this.f3225v = Arrays.copyOf(jArr, i11);
        }
        System.arraycopy(w5Var.f3225v, 0, this.f3225v, this.f3226w, w5Var.f3226w);
        this.f3226w = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(long j5) {
        a();
        int i = this.f3226w;
        long[] jArr = this.f3225v;
        if (i == jArr.length) {
            long[] jArr2 = new long[Math.max(((jArr.length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f3225v, 0, jArr2, 0, this.f3226w);
            this.f3225v = jArr2;
        }
        long[] jArr3 = this.f3225v;
        int i10 = this.f3226w;
        this.f3226w = i10 + 1;
        jArr3[i10] = j5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final long d(int i) {
        f(i);
        return this.f3225v[i];
    }

    @Override // com.google.android.gms.internal.measurement.s5
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final w5 c(int i) {
        if (i >= this.f3226w) {
            return new w5(i == 0 ? f3223x : Arrays.copyOf(this.f3225v, i), this.f3226w, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w5)) {
            return super.equals(obj);
        }
        w5 w5Var = (w5) obj;
        if (this.f3226w != w5Var.f3226w) {
            return false;
        }
        long[] jArr = w5Var.f3225v;
        for (int i = 0; i < this.f3226w; i++) {
            if (this.f3225v[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i) {
        if (i < 0 || i >= this.f3226w) {
            throw new IndexOutOfBoundsException(l4.a.l(i, this.f3226w, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(d(i));
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.f3226w; i++) {
            iA = (iA * 31) + l5.a(this.f3225v[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.f3226w;
        for (int i10 = 0; i10 < i; i10++) {
            if (this.f3225v[i10] == jLongValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        f(i);
        long[] jArr = this.f3225v;
        long j5 = jArr[i];
        if (i < this.f3226w - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f3226w--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        a();
        if (i10 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f3225v;
        System.arraycopy(jArr, i10, jArr, i, this.f3226w - i10);
        this.f3226w -= i10 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        a();
        f(i);
        long[] jArr = this.f3225v;
        long j5 = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3226w;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        b(((Long) obj).longValue());
        return true;
    }
}
