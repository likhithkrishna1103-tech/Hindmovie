package od;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c implements RandomAccess {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f9560u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9561v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f9562w;

    public b(c cVar, int i, int i10) {
        this.f9560u = cVar;
        this.f9561v = i;
        z7.a.f(i, i10, cVar.b());
        this.f9562w = i10 - i;
    }

    @Override // od.c
    public final int b() {
        return this.f9562w;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i10 = this.f9562w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        return this.f9560u.get(this.f9561v + i);
    }
}
