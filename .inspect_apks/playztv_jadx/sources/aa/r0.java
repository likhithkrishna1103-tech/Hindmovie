package aa;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r0 extends q1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f738u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f739v;

    public r0(Object obj) {
        this.f738u = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f739v;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f739v) {
            throw new NoSuchElementException();
        }
        this.f739v = true;
        return this.f738u;
    }
}
