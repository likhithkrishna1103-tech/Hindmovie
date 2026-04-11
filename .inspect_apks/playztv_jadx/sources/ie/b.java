package ie;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6602u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6603v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6604w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public fe.c f6605x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ he.d f6606y;

    public b(he.d dVar) {
        this.f6606y = dVar;
        int length = ((CharSequence) dVar.f6083b).length();
        if (length < 0) {
            throw new IllegalArgumentException(e6.j.j(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.f6603v = length;
        this.f6604w = length;
    }

    public final void a() {
        nd.f fVar;
        he.d dVar = this.f6606y;
        CharSequence charSequence = (CharSequence) dVar.f6083b;
        int i = this.f6604w;
        if (i < 0) {
            this.f6602u = 0;
            this.f6605x = null;
            return;
        }
        if (i <= charSequence.length() && (fVar = (nd.f) ((o) dVar.f6084c).i(charSequence, Integer.valueOf(this.f6604w))) != null) {
            int iIntValue = ((Number) fVar.f8983u).intValue();
            int iIntValue2 = ((Number) fVar.f8984v).intValue();
            this.f6605x = ga.b.G(this.f6603v, iIntValue);
            int i10 = iIntValue + iIntValue2;
            this.f6603v = i10;
            this.f6604w = i10 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.f6605x = new fe.c(this.f6603v, e.P(charSequence), 1);
            this.f6604w = -1;
        }
        this.f6602u = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6602u == -1) {
            a();
        }
        return this.f6602u == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f6602u == -1) {
            a();
        }
        if (this.f6602u == 0) {
            throw new NoSuchElementException();
        }
        fe.c cVar = this.f6605x;
        be.h.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f6605x = null;
        this.f6602u = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
