package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h6 extends v4 implements RandomAccess {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Object[] f2471y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final h6 f2472z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object[] f2473w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2474x;

    static {
        Object[] objArr = new Object[0];
        f2471y = objArr;
        f2472z = new h6(objArr, 0, false);
    }

    public h6(Object[] objArr, int i, boolean z10) {
        super(z10);
        this.f2473w = objArr;
        this.f2474x = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i10;
        a();
        if (i < 0 || i > (i10 = this.f2474x)) {
            throw new IndexOutOfBoundsException(x4.a(this.f2474x, i, (byte) 13, "Index:", ", Size:"));
        }
        int i11 = i + 1;
        Object[] objArr = this.f2473w;
        int length = objArr.length;
        if (i10 < length) {
            System.arraycopy(objArr, i, objArr, i11, i10 - i);
        } else {
            Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2473w, 0, objArr2, 0, i);
            System.arraycopy(this.f2473w, i, objArr2, i11, this.f2474x - i);
            this.f2473w = objArr2;
        }
        this.f2473w[i] = obj;
        this.f2474x++;
        ((AbstractList) this).modCount++;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.f2474x) {
            throw new IndexOutOfBoundsException(x4.a(this.f2474x, i, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final /* bridge */ /* synthetic */ o5 e(int i) {
        if (i >= this.f2474x) {
            return new h6(i == 0 ? f2471y : Arrays.copyOf(this.f2473w, i), this.f2474x, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b(i);
        return this.f2473w[i];
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        b(i);
        Object[] objArr = this.f2473w;
        Object obj = objArr[i];
        if (i < this.f2474x - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f2474x--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        b(i);
        Object[] objArr = this.f2473w;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2474x;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.f2474x;
        int length = this.f2473w.length;
        if (i == length) {
            this.f2473w = Arrays.copyOf(this.f2473w, Math.max(((length * 3) / 2) + 1, 10));
        }
        Object[] objArr = this.f2473w;
        int i10 = this.f2474x;
        this.f2474x = i10 + 1;
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
