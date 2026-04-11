package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g6 extends v4 implements RandomAccess {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object[] f3016x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final g6 f3017y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f3018v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3019w;

    static {
        Object[] objArr = new Object[0];
        f3016x = objArr;
        f3017y = new g6(objArr, 0, false);
    }

    public g6(Object[] objArr, int i, boolean z2) {
        super(z2);
        this.f3018v = objArr;
        this.f3019w = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        a();
        if (i < 0 || i > (i10 = this.f3019w)) {
            throw new IndexOutOfBoundsException(l4.a.l(i, this.f3019w, "Index:", ", Size:"));
        }
        Object[] objArr = this.f3018v;
        if (i10 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i10 - i);
        } else {
            Object[] objArr2 = new Object[Math.max(((objArr.length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f3018v, 0, objArr2, 0, i);
            System.arraycopy(this.f3018v, i, objArr2, i + 1, this.f3019w - i);
            this.f3018v = objArr2;
        }
        this.f3018v[i] = obj;
        this.f3019w++;
        ((AbstractList) this).modCount++;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.f3019w) {
            throw new IndexOutOfBoundsException(l4.a.l(i, this.f3019w, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.measurement.s5
    public final /* synthetic */ s5 c(int i) {
        if (i >= this.f3019w) {
            return new g6(i == 0 ? f3016x : Arrays.copyOf(this.f3018v, i), this.f3019w, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.f3018v[i];
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.f3018v;
        Object obj = objArr[i];
        if (i < this.f3019w - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f3019w--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.f3018v;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3019w;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.f3019w;
        Object[] objArr = this.f3018v;
        if (i == objArr.length) {
            this.f3018v = Arrays.copyOf(this.f3018v, Math.max(((objArr.length * 3) / 2) + 1, 10));
        }
        Object[] objArr2 = this.f3018v;
        int i10 = this.f3019w;
        this.f3019w = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
