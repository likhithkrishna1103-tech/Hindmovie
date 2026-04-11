package he;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f6079u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6080v = -2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d f6081w;

    public c(d dVar) {
        this.f6081w = dVar;
    }

    public final void a() throws Exception {
        Object objA;
        int i = this.f6080v;
        d dVar = this.f6081w;
        if (i == -2) {
            objA = ((a5.c) dVar.f6083b).b();
        } else {
            i iVar = (i) dVar.f6084c;
            Object obj = this.f6079u;
            be.h.b(obj);
            objA = iVar.a(obj);
        }
        this.f6079u = objA;
        this.f6080v = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws Exception {
        if (this.f6080v < 0) {
            a();
        }
        return this.f6080v == 1;
    }

    @Override // java.util.Iterator
    public final Object next() throws Exception {
        if (this.f6080v < 0) {
            a();
        }
        if (this.f6080v == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.f6079u;
        be.h.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.f6080v = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
