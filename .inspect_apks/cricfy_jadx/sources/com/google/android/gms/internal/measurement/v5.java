package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v5 extends v4 implements RandomAccess, n5, f6 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long[] f2662y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final v5 f2663z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long[] f2664w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2665x;

    static {
        long[] jArr = new long[0];
        f2662y = jArr;
        f2663z = new v5(jArr, 0, false);
    }

    public v5(long[] jArr, int i, boolean z10) {
        super(z10);
        this.f2664w = jArr;
        this.f2665x = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        long jLongValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i10 = this.f2665x)) {
            throw new IndexOutOfBoundsException(x4.a(this.f2665x, i, (byte) 13, "Index:", ", Size:"));
        }
        int i11 = i + 1;
        long[] jArr = this.f2664w;
        int length = jArr.length;
        if (i10 < length) {
            System.arraycopy(jArr, i, jArr, i11, i10 - i);
        } else {
            long[] jArr2 = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2664w, 0, jArr2, 0, i);
            System.arraycopy(this.f2664w, i, jArr2, i11, this.f2665x - i);
            this.f2664w = jArr2;
        }
        this.f2664w[i] = jLongValue;
        this.f2665x++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = p5.f2570a;
        collection.getClass();
        if (!(collection instanceof v5)) {
            return super.addAll(collection);
        }
        v5 v5Var = (v5) collection;
        int i = v5Var.f2665x;
        if (i == 0) {
            return false;
        }
        int i10 = this.f2665x;
        if (Integer.MAX_VALUE - i10 < i) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i;
        long[] jArr = this.f2664w;
        if (i11 > jArr.length) {
            this.f2664w = Arrays.copyOf(jArr, i11);
        }
        System.arraycopy(v5Var.f2664w, 0, this.f2664w, this.f2665x, v5Var.f2665x);
        this.f2665x = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final long b(int i) {
        f(i);
        return this.f2664w[i];
    }

    @Override // com.google.android.gms.internal.measurement.o5
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final v5 e(int i) {
        if (i >= this.f2665x) {
            return new v5(i == 0 ? f2662y : Arrays.copyOf(this.f2664w, i), this.f2665x, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(long j4) {
        a();
        int i = this.f2665x;
        int length = this.f2664w.length;
        if (i == length) {
            long[] jArr = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2664w, 0, jArr, 0, this.f2665x);
            this.f2664w = jArr;
        }
        long[] jArr2 = this.f2664w;
        int i10 = this.f2665x;
        this.f2665x = i10 + 1;
        jArr2[i10] = j4;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v5)) {
            return super.equals(obj);
        }
        v5 v5Var = (v5) obj;
        if (this.f2665x != v5Var.f2665x) {
            return false;
        }
        long[] jArr = v5Var.f2664w;
        for (int i = 0; i < this.f2665x; i++) {
            if (this.f2664w[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i) {
        if (i < 0 || i >= this.f2665x) {
            throw new IndexOutOfBoundsException(x4.a(this.f2665x, i, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        f(i);
        return Long.valueOf(this.f2664w[i]);
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i10 = 0; i10 < this.f2665x; i10++) {
            long j4 = this.f2664w[i10];
            Charset charset = p5.f2570a;
            i = (i * 31) + ((int) (j4 ^ (j4 >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.f2665x;
        for (int i10 = 0; i10 < i; i10++) {
            if (this.f2664w[i10] == jLongValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        a();
        f(i);
        long[] jArr = this.f2664w;
        long j4 = jArr[i];
        if (i < this.f2665x - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f2665x--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        a();
        if (i10 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f2664w;
        System.arraycopy(jArr, i10, jArr, i, this.f2665x - i10);
        this.f2665x -= i10 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        a();
        f(i);
        long[] jArr = this.f2664w;
        long j4 = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2665x;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }
}
