package aa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends o0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Object f720x;

    public o1(Object obj) {
        obj.getClass();
        this.f720x = obj;
    }

    @Override // aa.o0, aa.e0
    public final j0 b() {
        return j0.v(this.f720x);
    }

    @Override // aa.e0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f720x.equals(obj);
    }

    @Override // aa.e0
    public final int d(int i, Object[] objArr) {
        objArr[i] = this.f720x;
        return i + 1;
    }

    @Override // aa.o0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f720x.hashCode();
    }

    @Override // aa.e0
    public final boolean i() {
        return false;
    }

    @Override // aa.e0
    /* JADX INFO: renamed from: j */
    public final q1 iterator() {
        return new r0(this.f720x);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.f720x.toString() + ']';
    }
}
