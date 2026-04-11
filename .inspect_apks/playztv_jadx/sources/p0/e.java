package p0;

import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends d {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f9609w;

    public e(int i) {
        super(i);
        this.f9609w = new Object();
    }

    @Override // p0.d, p0.c
    public final boolean b(Object obj) {
        boolean zB;
        h.e(obj, "instance");
        synchronized (this.f9609w) {
            zB = super.b(obj);
        }
        return zB;
    }

    @Override // p0.d, p0.c
    public final Object i() {
        Object objI;
        synchronized (this.f9609w) {
            objI = super.i();
        }
        return objI;
    }
}
