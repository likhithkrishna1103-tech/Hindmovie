package aa;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends q1 implements ListIterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f675u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f676v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j0 f677w;

    public h0(j0 j0Var, int i) {
        int size = j0Var.size();
        q1.c.k(i, size);
        this.f675u = size;
        this.f676v = i;
        this.f677w = j0Var;
    }

    public final Object a(int i) {
        return this.f677w.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f676v < this.f675u;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f676v > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f676v;
        this.f676v = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f676v;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f676v - 1;
        this.f676v = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f676v - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
