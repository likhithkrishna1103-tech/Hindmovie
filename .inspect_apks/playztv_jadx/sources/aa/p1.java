package aa;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p1 implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Iterator f728u;

    public p1(Iterator it) {
        it.getClass();
        this.f728u = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f728u.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f728u.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f728u.remove();
    }
}
