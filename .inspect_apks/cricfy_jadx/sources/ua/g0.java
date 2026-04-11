package ua;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends n1 implements ListIterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12331v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12332w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i0 f12333x;

    public g0(i0 i0Var, int i) {
        int size = i0Var.size();
        com.bumptech.glide.d.i(i, size);
        this.f12331v = size;
        this.f12332w = i;
        this.f12333x = i0Var;
    }

    public final Object a(int i) {
        return this.f12333x.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f12332w < this.f12331v;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f12332w > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f12332w;
        this.f12332w = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f12332w;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f12332w - 1;
        this.f12332w = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f12332w - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
