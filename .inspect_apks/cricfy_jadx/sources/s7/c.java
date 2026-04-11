package s7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends v.e {
    public int B;

    @Override // v.k, java.util.Map
    public final void clear() {
        this.B = 0;
        super.clear();
    }

    @Override // v.k
    public final void g(v.e eVar) {
        this.B = 0;
        super.g(eVar);
    }

    @Override // v.k
    public final Object h(int i) {
        this.B = 0;
        return super.h(i);
    }

    @Override // v.k, java.util.Map
    public final int hashCode() {
        if (this.B == 0) {
            this.B = super.hashCode();
        }
        return this.B;
    }

    @Override // v.k
    public final Object i(int i, Object obj) {
        this.B = 0;
        return super.i(i, obj);
    }

    @Override // v.k, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.B = 0;
        return super.put(obj, obj2);
    }
}
