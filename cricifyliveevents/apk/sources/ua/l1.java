package ua;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends m0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Object f12357y;

    public l1(Object obj) {
        obj.getClass();
        this.f12357y = obj;
    }

    @Override // ua.m0, ua.d0
    public final i0 a() {
        return i0.o(this.f12357y);
    }

    @Override // ua.d0
    public final int b(int i, Object[] objArr) {
        objArr[i] = this.f12357y;
        return i + 1;
    }

    @Override // ua.d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f12357y.equals(obj);
    }

    @Override // ua.d0
    public final boolean g() {
        return false;
    }

    @Override // ua.d0
    /* JADX INFO: renamed from: h */
    public final n1 iterator() {
        return new p0(this.f12357y);
    }

    @Override // ua.m0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f12357y.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.f12357y.toString() + ']';
    }
}
