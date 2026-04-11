package x6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends s.e {
    public int A;

    @Override // s.i, java.util.Map
    public final void clear() {
        this.A = 0;
        super.clear();
    }

    @Override // s.i
    public final void g(s.e eVar) {
        this.A = 0;
        super.g(eVar);
    }

    @Override // s.i
    public final Object h(int i) {
        this.A = 0;
        return super.h(i);
    }

    @Override // s.i, java.util.Map
    public final int hashCode() {
        if (this.A == 0) {
            this.A = super.hashCode();
        }
        return this.A;
    }

    @Override // s.i
    public final Object i(int i, Object obj) {
        this.A = 0;
        return super.i(i, obj);
    }

    @Override // s.i, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.A = 0;
        return super.put(obj, obj2);
    }
}
