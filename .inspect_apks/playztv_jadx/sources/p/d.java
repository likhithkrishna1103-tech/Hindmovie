package p;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f9600u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9601v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ f f9602w;

    public d(f fVar) {
        this.f9602w = fVar;
    }

    @Override // p.e
    public final void a(c cVar) {
        c cVar2 = this.f9600u;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f9599x;
            this.f9600u = cVar3;
            this.f9601v = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9601v) {
            return this.f9602w.f9603u != null;
        }
        c cVar = this.f9600u;
        return (cVar == null || cVar.f9598w == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9601v) {
            this.f9601v = false;
            this.f9600u = this.f9602w.f9603u;
        } else {
            c cVar = this.f9600u;
            this.f9600u = cVar != null ? cVar.f9598w : null;
        }
        return this.f9600u;
    }
}
