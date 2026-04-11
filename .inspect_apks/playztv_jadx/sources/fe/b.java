package fe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f4820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4822w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4823x;

    public b(int i, int i10, int i11) {
        this.f4820u = i11;
        this.f4821v = i10;
        boolean z2 = false;
        if (i11 <= 0 ? i >= i10 : i <= i10) {
            z2 = true;
        }
        this.f4822w = z2;
        this.f4823x = z2 ? i : i10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4822w;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f4823x;
        if (i != this.f4821v) {
            this.f4823x = this.f4820u + i;
        } else {
            if (!this.f4822w) {
                throw new NoSuchElementException();
            }
            this.f4822w = false;
        }
        return Integer.valueOf(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
