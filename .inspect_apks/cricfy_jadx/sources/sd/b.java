package sd;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ge.b implements ListIterator {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ d f11656y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, int i) {
        super(2, dVar);
        this.f11656y = dVar;
        int iA = dVar.a();
        if (i < 0 || i > iA) {
            throw new IndexOutOfBoundsException(q4.a.m(i, iA, "index: ", ", size: "));
        }
        this.f5239w = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5239w > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5239w;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f5239w - 1;
        this.f5239w = i;
        return this.f11656y.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5239w - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
