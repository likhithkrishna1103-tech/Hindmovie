package ke;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7421v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7422w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7423x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7424y;

    public b(int i, int i10, int i11) {
        this.f7421v = i11;
        this.f7422w = i10;
        boolean z10 = false;
        if (i11 <= 0 ? i >= i10 : i <= i10) {
            z10 = true;
        }
        this.f7423x = z10;
        this.f7424y = z10 ? i : i10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7423x;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f7424y;
        if (i != this.f7422w) {
            this.f7424y = this.f7421v + i;
        } else {
            if (!this.f7423x) {
                throw new NoSuchElementException();
            }
            this.f7423x = false;
        }
        return Integer.valueOf(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
