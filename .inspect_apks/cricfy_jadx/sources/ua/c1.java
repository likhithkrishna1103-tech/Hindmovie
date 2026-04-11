package ua;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends m0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient k0 f12312y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient d1 f12313z;

    public c1(k0 k0Var, d1 d1Var) {
        this.f12312y = k0Var;
        this.f12313z = d1Var;
    }

    @Override // ua.m0, ua.d0
    public final i0 a() {
        return this.f12313z;
    }

    @Override // ua.d0
    public final int b(int i, Object[] objArr) {
        return this.f12313z.b(i, objArr);
    }

    @Override // ua.d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f12312y.get(obj) != null;
    }

    @Override // ua.d0
    public final boolean g() {
        return true;
    }

    @Override // ua.d0
    /* JADX INFO: renamed from: h */
    public final n1 iterator() {
        return this.f12313z.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f12312y.size();
    }
}
