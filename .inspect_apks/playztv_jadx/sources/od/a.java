package od;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends be.a implements ListIterator {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ c f9559x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i) {
        super(2, cVar);
        this.f9559x = cVar;
        int iB = cVar.b();
        if (i < 0 || i > iB) {
            throw new IndexOutOfBoundsException(l4.a.l(i, iB, "index: ", ", size: "));
        }
        this.f2029v = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2029v > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2029v;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f2029v - 1;
        this.f2029v = i;
        return this.f9559x.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2029v - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
