package aa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends o0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient m0 f669x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient g1 f670y;

    public f1(m0 m0Var, g1 g1Var) {
        this.f669x = m0Var;
        this.f670y = g1Var;
    }

    @Override // aa.o0, aa.e0
    public final j0 b() {
        return this.f670y;
    }

    @Override // aa.e0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f669x.get(obj) != null;
    }

    @Override // aa.e0
    public final int d(int i, Object[] objArr) {
        return this.f670y.d(i, objArr);
    }

    @Override // aa.e0
    public final boolean i() {
        return true;
    }

    @Override // aa.e0
    /* JADX INFO: renamed from: j */
    public final q1 iterator() {
        return this.f670y.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f669x.size();
    }
}
