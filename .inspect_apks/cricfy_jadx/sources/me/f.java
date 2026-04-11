package me;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rd.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Iterator, vd.c, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8462v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f8463w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Iterator f8464x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public vd.c f8465y;

    public final RuntimeException a() {
        int i = this.f8462v;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f8462v);
    }

    @Override // vd.c
    public final vd.h h() {
        return vd.i.f13722v;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f8462v;
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
                Iterator it = this.f8464x;
                ge.i.b(it);
                if (it.hasNext()) {
                    this.f8462v = 2;
                    return true;
                }
                this.f8464x = null;
            }
            this.f8462v = 5;
            vd.c cVar = this.f8465y;
            ge.i.b(cVar);
            this.f8465y = null;
            cVar.i(l.f11003a);
        }
    }

    @Override // vd.c
    public final void i(Object obj) throws Throwable {
        com.bumptech.glide.c.C(obj);
        this.f8462v = 4;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f8462v;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.f8462v = 1;
            Iterator it = this.f8464x;
            ge.i.b(it);
            return it.next();
        }
        if (i != 3) {
            throw a();
        }
        this.f8462v = 0;
        Object obj = this.f8463w;
        this.f8463w = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
