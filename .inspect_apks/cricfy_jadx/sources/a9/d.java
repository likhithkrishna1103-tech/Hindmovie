package a9;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ListIterator, Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f361v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f362w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f363x;

    public d(g gVar, int i) {
        int size = gVar.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(sd.i.L(i, size, "index"));
        }
        this.f361v = size;
        this.f362w = i;
        this.f363x = gVar;
    }

    public final Object a(int i) {
        return this.f363x.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f362w < this.f361v;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f362w > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f362w;
        this.f362w = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f362w;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f362w - 1;
        this.f362w = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f362w - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
