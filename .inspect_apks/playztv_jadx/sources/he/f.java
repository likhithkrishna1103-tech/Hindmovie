package he;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Iterator, rd.c, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6085u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f6086v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Iterator f6087w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public rd.c f6088x;

    public final RuntimeException a() {
        int i = this.f6085u;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f6085u);
    }

    @Override // rd.c
    public final rd.h f() {
        return rd.i.f11572u;
    }

    @Override // rd.c
    public final void g(Object obj) throws Throwable {
        i5.a.Q(obj);
        this.f6085u = 4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f6085u;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.f6087w;
                be.h.b(it);
                if (it.hasNext()) {
                    this.f6085u = 2;
                    return true;
                }
                this.f6087w = null;
            }
            this.f6085u = 5;
            rd.c cVar = this.f6088x;
            be.h.b(cVar);
            this.f6088x = null;
            cVar.g(nd.k.f8990a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f6085u;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.f6085u = 1;
            Iterator it = this.f6087w;
            be.h.b(it);
            return it.next();
        }
        if (i != 3) {
            throw a();
        }
        this.f6085u = 0;
        Object obj = this.f6086v;
        this.f6086v = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
